package helper;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class GridExecution
{
	WebDriver driver;
	String baseURL1, nodeURL,baseURL2;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		baseURL1="http://newtours.demoaut.com/";  // http://www.testertimes.wordpress.com/
		baseURL2= "http://www.google.com";
		nodeURL="http://172.16.30.157:5566/wd/hub";  // 5566
		
	   	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
     	capabilities.setBrowserName("firefox");
     	capabilities.setPlatform(Platform.WINDOWS);
     	driver= new RemoteWebDriver(new URL(nodeURL),capabilities);
     	driver.get(baseURL1);
     	
	}
	@Test
	public void demotest2()
	{
		driver.get(baseURL2);
		System.out.println(driver.getTitle());
	}
	@Test
	public void demotest()
	{
		Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}
	
}
