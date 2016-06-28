package test.java.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       //System.out.println(ResourcesPlugin.getWorkspace().getRoot().getName());    
       //System.out.println(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString(););
       driver.get("http://google.ca");
       
	}

}
