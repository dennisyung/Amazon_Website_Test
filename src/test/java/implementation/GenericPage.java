package test.java.implementation;
import org.junit.Assert;
import org.openqa.selenium.*;

import test.java.implementation.MasterParentPage;


public class GenericPage extends MasterParentPage {
	
	//We store the signedIn state via this variable which exists across all pages
	private static boolean signedIn = false;
	
	public GenericPage(WebDriver driver, String URL, String evidenceLoadedXPath){
		super(driver, URL, evidenceLoadedXPath);
	}
	
	public static boolean setPageSignedInState(Boolean newState)
	{
		signedIn = newState;
		return signedIn;
	}
	
	public LoginPage navigateToSignInPageViaTopMenu(){
		Assert.assertTrue("This method is not applicable for current sign-in state", GenericPage.signedIn == false);
	
		WebElement element = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
		element.click();
	    String intendedURL = "https://www.amazon.ca/ap/signin?_encoding=UTF8&openid.assoc_handle=caflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca";
	    String evidenceLoadedXPath = "//*[@id='signInSubmit']";
		return new LoginPage(this.driver, intendedURL, evidenceLoadedXPath);
	}
	
	public LoginPage signOut()
	{
		Assert.assertTrue("This method is not applicable for current sign-in state", GenericPage.signedIn == true);
		//Implement step 1 - hover over the Your Account tab
		//Implement step 2 - click on the popup logout link
	    //Step 3 - verify the login page is loaded
		String URL = "https://www.amazon.ca/ap/signin";
		String evidenceLoadedXpath = "//*[@id='signInSubmit']";
		LoginPage loginPage = new LoginPage(this.driver, URL, evidenceLoadedXpath);
		loginPage.verifyIsLoaded();
		return loginPage;
	}
		
}
