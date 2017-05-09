package evs.trts.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Logout {
	
	WebDriver driver;
	
	
	public Logout(WebDriver Idriver)
	{
		this.driver=Idriver;
	}
	
	  @FindBy(xpath= "//img[@alt='Logout']")
	 
	  //@CacheLookup
	  static WebElement img_logout;
	  
	  @FindBy(xpath=".//*[@id='topNav']/div/strong/span")
	  WebElement loginusername;
	  
	  String user1= "Atithi Ganjoo";
	  String user2= "Debasis nandi";
	  String user3= "Madhup Narula";
	  
	  public static void logoutpage()
	  {
/*		  if (loginusername.getText()==user1)
		  {
		  img_logout.click();} else if(loginusername.getText()==user2)
		  {
			  img_logout.click();
			  
		  } else if(loginusername.getText()==user3){
			  img_logout.click(); 
		  } 
		  */
		  
		img_logout.click();  
		return;
		  
	  }

}
