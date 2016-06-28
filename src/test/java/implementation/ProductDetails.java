package test.java.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import test.java.implementation.GenericPage;

public class ProductDetails extends GenericPage {

    @FindBy(how = How.XPATH, using= "//*[@id='add-to-wishlist-button-submit']")
    WebElement btnAddToWishlist;
    
	
	public ProductDetails(WebDriver driver, String URL, String evidenceLoadedXPath) {
		super(driver, URL, evidenceLoadedXPath);
		PageFactory.initElements(driver, this);
	}
	
	private void addToWishList()
	{
		Assert.assertTrue("Add to wishlist button is not displayed", btnAddToWishlist.isDisplayed());
		btnAddToWishlist.click();
		
	}

	
}
