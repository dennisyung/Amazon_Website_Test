package test.java.implementation.utils;

import static test.java.implementation.utils.TestConstants.*;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PageFactory {
	//We store one webdriver per browser in the hashmap
    private static HashMap<String, WebDriver> drivermap = new HashMap<String, WebDriver>();
    
    public static WebDriver getDriver(String browserType)
    {
    	browserType = browserType.toLowerCase();
    	
    	//If the driver does not exist yet for the specified key, then create it
    	//This covers the case where the browser key exists, but no corresponding driver AND also where the key does not exist at all.
    	if (drivermap.get(browserType) == null)
    	{
    		WebDriver driverValue;
        	switch(browserType)
        	{
        	   case "firefox" :
           		  driverValue = new FirefoxDriver(TEST_FIREFOX_DESIRED_CAPABILITIES);
           		  drivermap.put("firefox", driverValue);
           		  System.out.println("firefoxden");
           		  break;
        		
        	   case "internetexplorer":
        		   System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
        		   //Setting the driver service host/port
        		   InternetExplorerDriverService.Builder builder
        		   = new InternetExplorerDriverService.Builder();
        		   InternetExplorerDriverService ieService 
        		   = builder.usingPort(5555).withHost("127.0.0.1").build();
        		   //Create new IE driver instance
        		   driverValue = new InternetExplorerDriver(ieService, TEST_IE_DESIRED_CAPABILITIES);        	
        		   drivermap.put("internetexplorer", driverValue);
        		   System.out.println("IEden");
        		   break;
        		   
        	   case "chrome":
        	       System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        		   driverValue = new ChromeDriver(TEST_CHROME_DESIRED_CAPABILITIES);
        		   drivermap.put("chrome", driverValue);
        		   System.out.println("chromeDen");
        		   break;
        	}
    	}
    	
    	//Return the requested driver
        return drivermap.get(browserType);
    }

    public static void closeDriver(String browserType)
    {
    	browserType = browserType.toLowerCase();
    	WebDriver browserDriver = drivermap.get(browserType);
    	//Close the driver
    	browserDriver.quit();
    	drivermap.put(browserType, null);
    	//At this point, in hashmap for key browserType, the value should be null, since driver is destroyed
    }

}
