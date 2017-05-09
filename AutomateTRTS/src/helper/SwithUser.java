package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwithUser {
	
	WebDriver driver;
	
	public SwithUser(WebDriver sdriver)
	{
		this.driver=sdriver;
	}

	@FindBy(linkText="SwitchRole")
	WebElement menu_switch;
	
	@FindBy(xpath=".//*[@id='Role'][@value='Recruiter']")
	WebElement rad_recruiter;
	
	@FindBy(xpath=".//*[@id='Role'][@value='HRCompliance']")
	WebElement rad_hrcompliance;
	
	@FindBy(xpath="//input[@id='Role'][@value='TAAdmin']")
	WebElement rad_taadmin;
	
	@FindBy(xpath=".//*[@id='Role'][@value='FPAOperation']")
	WebElement rad_FPnA;
	
	@FindBy(xpath="//td/input")
	WebElement chkbx_firstingridforFPnA;
	
	@FindBy(id="Select")
	WebElement btn_submit;
	
	@FindBy(xpath="//tr[2]/td[2]/a")
	WebElement link_firstjobcodeingrid;
	
 public void clickOnswitchUserMenu()
 	{
	 menu_switch.click();
	 
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 DynamicWait.expwaitelmnttobeclickable(driver, 10, rad_recruiter );
	 
 	}
 
 public void selectRecruiterafterSwitch() throws InterruptedException
 {
	 menu_switch.click();
	 Thread.sleep(5000);
	 rad_recruiter.click();
	 btn_submit.click();
	 DynamicWait.expwaitelmnttobeclickable(driver, 15, link_firstjobcodeingrid);
	// Thread.sleep(9000);
 }
 
 public void selectHRComplianceUser() throws InterruptedException
 {
	 Thread.sleep(5000);
	 menu_switch.click();
	 System.out.println("Switch role menu clicked");
	 Thread.sleep(3000);
	 rad_hrcompliance.click();
	 btn_submit.click();
	 System.out.println("HR Compliance role is selected");
	 Thread.sleep(6000);
	 
 }
 
 public void selectTAAdminSwitch() throws InterruptedException
 {
	 //Thread.sleep(4000);
	 menu_switch.click();
	 System.out.println("Switch role menu clicked");
	 DynamicWait.expwaitelmnttobeclickable(driver, 20,rad_taadmin );
	// Thread.sleep(4000);
	 rad_taadmin.click();
	 btn_submit.click();
	 System.out.println("TA Admin role is selected");
	 Thread.sleep(8000);
	 
 }
 
 public void switchtoFPnAuser() throws InterruptedException
 {
	 menu_switch.click();
	 Thread.sleep(5000);
	 rad_FPnA.click();
	 btn_submit.click();
	 DynamicWait.expwaitelmnttobeclickable(driver, 10, chkbx_firstingridforFPnA);
	 System.out.println("\n");
	 System.out.println("FPnA role is selected");
	 
 }
 
}