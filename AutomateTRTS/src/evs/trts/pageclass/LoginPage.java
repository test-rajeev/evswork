package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DynamicWait;

public class LoginPage {
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver Idriver)
	{		
		this.driver=Idriver;
		
	}

	  @FindBy(id= "UserName") 
	  WebElement lgn_username;
	  
	  @FindBy(id= "Password")  
	  WebElement lgn_password;
	  
	  @FindBy(id= "Submit")   
	  WebElement lgn_btn;
	  
	  @FindBy(id= "Role")   
	  WebElement roleradiobtn;
	  
	   /*@FindBy(how = How.ID, using = "Role")
	   WebElement radRole;*/
	
	public void login_trts(WebDriver driver,String uid, String pwd) throws AWTException, InterruptedException
	{
		lgn_username.clear();
		lgn_username.sendKeys(uid);
		lgn_password.clear();
		lgn_password.sendKeys(pwd);
		lgn_btn.click();
		//lgn_btn.click();
		
		DynamicWait.expwaitelmnttobeclickable(driver, 700, roleradiobtn);
	
	}
	
}
