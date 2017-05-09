package helper;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browsername, String url) throws InterruptedException 
	{
		
		if (browsername.equalsIgnoreCase("Firefox")) 
		{
			
			driver= new FirefoxDriver();
	 /*    	String	nodeURL= "http://172.16.30.26:5566/wd/hub";
	     	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	     	capabilities.setBrowserName(browsername);
	     	capabilities.setPlatform(Platform.WINDOWS);
	     	try {
				driver= new RemoteWebDriver(new URL(nodeURL),capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		} else if (browsername.equalsIgnoreCase("chrome"))
		
		{   
			System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			
		} else if (browsername.equalsIgnoreCase("IE"))
			
		{    
			 System.setProperty("webdriver.ie.driver","C://TRTSautomationStuffs//TRTSworkspace_v1//AutomateTRTS//src//Drivers//IEDriverServer.exe");		
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			 capabilities.setCapability("requireWindowFocus", true);
			 capabilities.setCapability("Ignore",UnexpectedAlertBehaviour.IGNORE);
			 driver = new InternetExplorerDriver(capabilities);
			//driver= new InternetExplorerDriver();
			 Thread.sleep(12000);
			 
			
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
		
	}

}
