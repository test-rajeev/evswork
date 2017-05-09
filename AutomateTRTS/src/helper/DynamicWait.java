package helper;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWait {
	
	WebDriver driver;
	
	public static void expwaitelmnttobeclickable(WebDriver driver, int time, WebElement element)
	{
	
	WebDriverWait wait = new WebDriverWait(driver, time);		 
	//By locator = null;
	 wait.until(ExpectedConditions.elementToBeClickable(element));
     return ;

    }
	
	public static void expwaitpresenceofelement(WebDriver driver, int time, By Locator)
	{
	WebDriverWait wait = new WebDriverWait(driver,time);
	//By locator = null;
	wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	
	return ;
	}

}