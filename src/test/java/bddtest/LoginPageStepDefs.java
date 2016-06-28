package test.java.bddtest;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import test.java.implementation.GenericPage;
import test.java.implementation.LoginPage;
import test.java.implementation.utils.PageFactory;

import static test.java.implementation.utils.TestConstants.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;


public class LoginPageStepDefs {
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
	
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^I am not currently on the login page$")
	public void i_am_not_currently_on_the_login_page() throws Throwable {
	    //Go to homepage (but not logged in)
	    String intendedURL = "https://www.amazon.ca";  
	    String evidenceLoadedXPath = "//*[@id='nav-link-yourAccount']/span[@class='nav-line-1']";
		genericPage = new GenericPage(driver, intendedURL, evidenceLoadedXPath);
		genericPage.get();
	}

	@When("^I access the login page URL via directURL$")
	public void i_access_the_login_page_URL_via_directURL() throws Throwable {
	    String intendedURL = "https://www.amazon.ca/ap/signin?_encoding=UTF8&openid.assoc_handle=caflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca";
	    String evidenceLoadedXPath = "//*[@id='signInSubmit']";
	    loginPage = new LoginPage(driver, intendedURL, evidenceLoadedXPath);
	    loginPage.get();
	}

	@Then("^the login page should be loaded correctly$")
	public void the_login_page_should_be_loaded_correctly() throws Throwable {
		loginPage.verifyIsLoaded();
	}

	@When("^I access the login page URL via navigate_from_top_menu$")
	public void i_access_the_login_page_URL_via_navigate_from_top_menu() throws Throwable {
		this.loginPage = genericPage.navigateToSignInPageViaTopMenu();
	}

	@Given("^I am currently on the login page$")
	public void i_am_currently_on_the_login_page() throws Throwable {
		i_access_the_login_page_URL_via_directURL();
	}

	@When("^I attempt to sign in with no username or password entered$")
	public void i_attempt_to_sign_in_with_no_username_or_password_entered() throws Throwable {
		String username = "wrongusername";
		String password = "password";
		loginPage.loginWtihCredentials(username, password);
	}

	@Then("^the sign in should fail with appropriate error message$")
	public void the_sign_in_should_fail_with_appropriate_error_message() throws Throwable {
	    //Identify the error message element
		loginPage.verifyAppropriateErrorMessageShown();;
	}

	@When("^I attempt to sign in with incorrect username$")
	public void i_attempt_to_sign_in_with_incorrect_username() throws Throwable {
		String username = "randomBadUsernameXYZabc";
		String password = "abc123xy";
		loginPage.loginWtihCredentials(username, password);
	}

	@When("^I attempt to sign in with correct username but incorrect password$")
	public void i_attempt_to_sign_in_with_correct_username_but_incorrect_password() throws Throwable {
		JSONArray logindata = TEST_VALID_LOGIN_DATA_JSONARRAY;
		String username = (String) ((JSONObject) logindata.get(0)).get("username");
		String password = "wrongpass";
		loginPage.loginWtihCredentials(username, password);
	}

	@When("^I attempt to sign in with correct username and correct password$")
	public void i_attempt_to_sign_in_with_correct_username_and_correct_password() throws Throwable {
		JSONArray logindata = TEST_VALID_LOGIN_DATA_JSONARRAY;
		String username = (String) ((JSONObject) logindata.get(0)).get("username");
		String password = (String) ((JSONObject) logindata.get(0)).get("password");
		loginPage.loginWtihCredentials(username, password);
	}

	@Then("^the sign in should be successful$")
	public void the_sign_in_should_be_successful() throws Throwable {
		loginPage.get();
	}

	
}
