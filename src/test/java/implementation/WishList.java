package test.java.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import test.java.implementation.GenericPage;
import test.java.implementation.WishListSettings;

public class WishList extends GenericPage {

    @FindBy(how = How.XPATH, using= "//*[@id='ap_email']")
    WebElement inputUsername;
     
    By listSettings = By.xpath("//*[@id='wishlist-page']/ul//*/a");
     

	public WishList(WebDriver driver, String URL, String evidenceLoadedXPath) {
		super(driver, URL, evidenceLoadedXPath);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void navigateToWishListSettings()
	{
		verifyURL = ;
	    xPath = ;
		WishListSettings wishListSettings = new WishListSettings(driver, "", "");
	}

	
}
