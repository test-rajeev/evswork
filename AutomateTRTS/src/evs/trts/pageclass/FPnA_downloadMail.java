package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FPnA_downloadMail 
{
static WebDriver driver;
	

	public void downloadMail( WebElement elem) throws AWTException, InterruptedException
	{
		//lnk_dwnldapprvlmail.click();
	//	rightClick(elem);
	//	saveFile();
		
		
	}
	
	public void rightClick(WebElement element, WebDriver idriver) {
		try {
			Actions action = new Actions(idriver).contextClick(element);
			action.build().perform();

			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable "
					+ e.getStackTrace());
		}
	}

	public void saveFile(WebDriver sdriver) throws AWTException, InterruptedException
	{
		Robot rsf= new Robot();
		rsf.keyPress(KeyEvent.VK_DOWN);
		rsf.keyRelease(KeyEvent.VK_DOWN);
	//	Thread.sleep(1000);
		rsf.keyPress(KeyEvent.VK_DOWN);
		rsf.keyRelease(KeyEvent.VK_DOWN);
	//	Thread.sleep(1000);
		rsf.keyPress(KeyEvent.VK_DOWN);
		rsf.keyRelease(KeyEvent.VK_DOWN);
	//	Thread.sleep(1000);
		rsf.keyPress(KeyEvent.VK_DOWN);
		rsf.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		
		rsf.keyPress(KeyEvent.VK_ENTER);
		rsf.keyRelease(KeyEvent.VK_ENTER);
		return;
		
	}	
		
		public void newWindowHandle() throws AWTException, InterruptedException
		{
		String parentWindow = driver.getWindowHandle();
		Set <String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		        // <!--Perform your operation here for new window-->
		          Robot rsf= new Robot();
		      	rsf.keyPress(KeyEvent.VK_ENTER);
				rsf.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				
				rsf.keyPress(KeyEvent.VK_LEFT);
				rsf.keyRelease(KeyEvent.VK_LEFT);
				rsf.keyPress(KeyEvent.VK_ENTER);
				rsf.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(5000);
				
				
		//		replaceExistingdownloadRequestExcel(driver);
		     //    driver.close(); //closing child window
		         //cntrl to parent window
		          }
		       }
		   driver.switchTo().window(parentWindow);
		   return;
		}
	
		
	
	
	public static void replaceExistingdownloadRequestExcel(WebDriver sdriver) throws AWTException, InterruptedException
	{
	//	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Robot dw = new Robot();
		dw.keyPress(KeyEvent.VK_LEFT);
		dw.keyRelease(KeyEvent.VK_LEFT);
		dw.keyPress(KeyEvent.VK_ENTER);
		dw.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}
	
	public void pressEnter() throws AWTException
	{
		Robot ro = new Robot();			
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
	}
}
