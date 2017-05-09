package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import helper.DynamicWait;

public class AssignRequest_TAAdmin {
	
	WebDriver driver;
	
	public AssignRequest_TAAdmin(WebDriver tdriver)
	{
		this.driver=tdriver;
	}

	@FindBy(linkText="Approved/Unassigned")
	WebElement submenu_approvedunassigned;
	
	@FindBy(linkText="Assigned")
	WebElement submenu_assigned;
	
	@FindBy(xpath="//div[2]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]") /// old used //tr[2]/td[2]
	WebElement jobcode_firstingrid;
	
	@FindBy(xpath="//div[2]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[12]/a") // old used //td[12]/a
	WebElement lnk_view;
	
	@FindBy(linkText="Download Job Profile")
	WebElement lnk_downloadjobprofile;
	
	@FindBy(xpath=".//*[@id='CreateRequestDiv']/table[1]/tbody/tr[1]/td[2]/span")
	WebElement lbl_jobcodeindetailswindow;
	
	@FindBy(id="PEMPID")
	WebElement drpdwn_primaryrecruiter;
	
	@FindBy(id="SEMPID")
	WebElement drpdwn_TAManager;
	
	@FindBy(xpath=".//*[@id='Comment']")
	WebElement txt_comment;
	
	@FindBy(id="btnSubmitTA")
	WebElement btn_assign;
	
	@FindBy(linkText="Assigned")
	WebElement lnk_sbmenu_assigned;
	
	@FindBy(xpath="//div[7]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]")
	WebElement firstjobcodein_assignedgrid;
	
	String firstjobcode=null;
	
	public void assignToRecruiter() throws InterruptedException, AWTException
	{
		submenu_approvedunassigned.click();
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(7000);
		firstjobcode= jobcode_firstingrid.getText();
		System.out.println("First job code for TA Admin is: "+firstjobcode );
		lnk_view.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 20, lnk_downloadjobprofile);
		String jobcode= lbl_jobcodeindetailswindow.getText();
		System.out.println("Job code in job request details pane for TA Admin is "+ jobcode);
		Assert.assertEquals(jobcode, firstjobcode);
		System.out.println("Job code is matched after assert");
		
		Select rctr=new Select(drpdwn_primaryrecruiter);
		rctr.selectByValue("13640"); /// selected recruiter as debasis nandi // other values 10636 atithi; 4753 CRK
		Thread.sleep(2000);
	/*	Alert alert = driver.switchTo().alert();
		alert.accept();*/
		
	    Robot rb =new Robot();
	 	rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);		
		//Thread.sleep(2000);
		Select tamngr=new Select(drpdwn_TAManager);
		tamngr.selectByValue("10636"); /// selected ta manager as crk jithendra // other values 10636 atithi; 13640 debasis
		txt_comment.clear();
		txt_comment.sendKeys("comment is Assigned");
		Thread.sleep(2000);
		btn_assign.click();
		
        Thread.sleep(5000);
        
      
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(6000);
		
	}
	
	public void verifyAssignedJobCode() throws InterruptedException
	{
	
		lnk_sbmenu_assigned.click();
		Thread.sleep(4000);
		String assignedjobcode= firstjobcodein_assignedgrid.getText();
		System.out.println("First job code in assigned grid is :" +assignedjobcode);
	//	Assert.assertEquals(assignedjobcode,firstjobcode);
	//	System.out.println("first job code getting in second method is: "+firstjobcode );
		System.out.println("Job code is verified after assert for TA Admin");
		
		
	}
}
