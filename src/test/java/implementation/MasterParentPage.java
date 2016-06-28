package test.java.implementation;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.LoadableComponent;


/*
 * Description: This base class provides all the inherited commmon functions to all children pages
   All pages inherit from this page.  Key features include:
   Load / isLoaded() - automatically is called when get() is called on an instantiated object
 *
 */

public class MasterParentPage extends LoadableComponent<MasterParentPage> {

    protected WebDriver driver;
    protected String URL;
    protected String evidenceLoadedXPath;
	
	public MasterParentPage(WebDriver driver, String URL, String evidenceLoadedXPath){
        this.driver = driver;
        this.URL = URL;
        this.evidenceLoadedXPath = evidenceLoadedXPath;
	}

	@Override
	protected void isLoaded() throws Error {

			Assert.assertTrue("Actual: " + driver.getCurrentUrl() + " Expected: " + URL, driver.getCurrentUrl().contains(URL));
			Boolean isEvidenceElementLoaded = false;  //initialize to false, unless it is proven to be found in next statement
			Boolean isEvidenceElementVisible = false; 
			WebElement element;
			try{
			    element = driver.findElement(By.xpath(this.evidenceLoadedXPath));
			    isEvidenceElementLoaded = true;  //if reaches this line without exception, it must be loaded okay
			    isEvidenceElementVisible = element.isDisplayed()? true : false;
			}
			catch(NoSuchElementException e){
			}
		    
			String failureMessage = "Element not found/visible.  LOADED <" + isEvidenceElementLoaded.toString() 
			                      + ">" + " VISIBLE <" + isEvidenceElementVisible + ">" 
			                      + " XPATH USED <" + this.evidenceLoadedXPath + ">";
			//Assert that element is visible.  If visible is true, then implicitly it also must be loaded.
			Assert.assertTrue(failureMessage, isEvidenceElementVisible);
	}

	public void verifyIsLoaded()
	{
		isLoaded();
	}
	
	@Override
	protected void load() {
		//Only load this.URL specified, if the loadPageURL boolean is set to True
		//By default, loadPageURL is false, and will not load (with the assumption the previous event
		//already brought the user to the current page.
		driver.get(this.URL);
	}
	
	
}
