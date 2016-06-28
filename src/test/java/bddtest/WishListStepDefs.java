package test.java.bddtest;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import test.java.implementation.GenericPage;
import test.java.implementation.ProductDetails;
import test.java.implementation.utils.PageFactory;

import static test.java.implementation.utils.TestConstants.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;


public class WishListStepDefs {
    WebDriver driver;
    LoginPage loginPage;
    GenericPage genericPage;
	
    @Before
    public void beforeScenario()
    {
    	driver = PageFactory.getDriver(TEST_BROWSER_TYPE);
    	System.out.println("denbefore test");
    }
    
    @After
    public void afterScenario()
    {
    	
    	System.out.println("denafter test");
    	PageFactory.closeDriver(TEST_BROWSER_TYPE);
    }    

    @When("^I search and add (\\d+) items to wishlist$")
    public void i_search_and_add_items_to_wishlist(int numbItems) throws Throwable {
    	JSONObject wishListData = TEST_WISHLIST_DATA;
    	for (Object item: wishListData.values())
    	{
    		String itemDescription = (String) ((JSONArray)item).get(0);
    		String itemURL = (String) ((JSONArray)item).get(1);
    		String evidenceLoadedXPath = "//*[@id='productTitle']//*[contains(text()," + itemDescription + ")]";
    		ProductDetails productDetails = new ProductDetails(driver, itemURL, evidenceLoadedXPath);
    		productDetails.get();
    		productDetails
    	}
    		
    }

    @Then("^the item is saved to my wishlist$")
    public void the_item_is_saved_to_my_wishlist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the items are saved to my wishlist$")
    public void the_items_are_saved_to_my_wishlist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I navigate to wishlist$")
    public void i_navigate_to_wishlist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^remove a single item$")
    public void remove_a_single_item() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the removed item is no longer saved in wishlist$")
    public void the_removed_item_is_no_longer_saved_in_wishlist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

	
	
}
