package test.java.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import test.java.implementation.GenericPage;

public class WishListSettings extends GenericPage {

    @FindBy(how = How.XPATH, using= "//*[@id='g-manage-table-wishlist']/tbody/tr")
    List<WebElement> savedWishLists;
    
	
	public WishListSettings(WebDriver driver, String URL, String evidenceLoadedXPath) {
		super(driver, URL, evidenceLoadedXPath);
		PageFactory.initElements(driver, this);
	}
	
    public void removeAllWishLists()
    {
    	
    }

	
}
