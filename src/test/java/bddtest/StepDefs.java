package test.java.bddtest;

import cucumber.api.java.en.*;
import test.java.implementation.Checkout;
import cucumber.api.PendingException;

import org.junit.Assert;
import java.util.*;

public class StepDefs {

//int bananaPrice = 0;
HashMap<String, Integer> itemPrice = new HashMap<String, Integer>();
Checkout checkout = new Checkout();

	
	@Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
	public void thePriceOfAIsC(String item, int price) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		itemPrice.put(item, price);
		
	}

	@When("^I checkout (\\d+) \"([^\"]*)\"$")
	public void iCheckout(int itemCount, String itemName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkout.add(itemCount, itemPrice.get(itemName));
	}

	@Then("^the total price should be (\\d+)c$")
	public void theTotalPriceShouldBeC(int totalPrice) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(totalPrice, checkout.getTotal(), 0);
	
	}

	
}
