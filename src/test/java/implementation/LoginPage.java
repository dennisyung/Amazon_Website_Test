package test.java.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import test.java.implementation.GenericPage;

public class LoginPage extends GenericPage {

    @FindBy(how = How.XPATH, using= "//*[@id='ap_email']")
    WebElement inputUsername;
    
    @FindBy(how = How.XPATH, using= "//*[@id='ap_password']")
    WebElement inputPassword;
    
    @FindBy(how = How.XPATH, using= "//*[@id='signInSubmit']")
    WebElement btnSubmit;
    
    @FindBy(how = How.XPATH, using="//*[@id='auth-alert-window']")
    WebElement errorBlock;
    
    @FindBy(how = How.XPATH, using="//*[@id='auth-email-missing-alert']")
    WebElement errorUserNameMissing;
    
    @FindBy(how = How.XPATH, using="//*[@id='auth-password-missing-alert']")
    WebElement errorPasswordMissing;
    
    @FindBy(how = How.XPATH, using="//*[@id='auth-warning-message-box']/div/h4[contains(text(), 'Important Message')]")
    WebElement errorImportantMessage;
    
    @FindBy(how = How.XPATH, using="//*[@id='auth-warning-message-box']//*[contains(text(), 'To better protect')]")
    WebElement errorImportantMessageDescription;
  
    private String username_entered = "";
    private String password_entered = "";
    
	
	public LoginPage(WebDriver driver, String URL, String evidenceLoadedXPath) {
		super(driver, URL, evidenceLoadedXPath);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUsername(String username)
	{
		inputUsername.sendKeys(username);
		this.username_entered = username;
	}
	
	public void enterPassword(String password)
	{
		inputPassword.sendKeys(password);
		this.password_entered = password;
	}
	
	public void loginWtihCredentials(String username, String password)
	{
		enterUsername(username);
		enterPassword(password);
		btnSubmit.click();
	}
	
	public GenericPage loginWithValidCredentials(String username, String password)
	{
		loginWtihCredentials(username, password);
	    String intendedURL = "https://www.amazon.ca";  
	    String evidenceLoadedXPath = "//*[@id='nav-link-yourAccount']/span[@class='nav-line-1']";
	    GenericPage genericPage = new GenericPage(driver, intendedURL, evidenceLoadedXPath);
	    genericPage.verifyIsLoaded();
	    GenericPage.setPageSignedInState(true);  //Set the cross-page signIn state to true
		return genericPage;
	}
	
	public LoginPage loginWithInvalidCredentials(String username, String password)
	{
		loginWtihCredentials(username, password);
	    String intendedURL = "https://www.amazon.ca";  
	    String evidenceLoadedXPath = "//*[@id='a-page']//h1[contains(text(), 'Sign in')]";
	    LoginPage loginPage = new LoginPage(driver, intendedURL, evidenceLoadedXPath);
	    loginPage.verifyIsLoaded();
		return loginPage;
	}
	
	
	private void verifyEmptyUsernamePasswordErrorShown()
	{
		Assert.assertTrue("Empty username error not shown", errorUserNameMissing.isDisplayed());
		Assert.assertTrue("Empty password error not shown", errorPasswordMissing.isDisplayed());
	}
	
	private void verifyIncorrectCredentialsErrorShown()
	{
		Assert.assertTrue("Empty username error not shown", errorImportantMessage.isDisplayed());
		Assert.assertTrue("Empty username error not shown", errorImportantMessageDescription.isDisplayed());
	}
	
	public void verifyAppropriateErrorMessageShown()
	{
		if (this.password_entered.equals("") && this.username_entered.equals(""))
		{
			verifyEmptyUsernamePasswordErrorShown();
		}
		else
		{
			verifyIncorrectCredentialsErrorShown();
		}
		
	}
	
}
