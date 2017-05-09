package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import helper.DynamicWait;

public class HiringApprover {
	
		static  WebDriver driver;
	
	public HiringApprover(WebDriver driver)
	{
		this.driver=driver;
	}

	///----- elements on landing page
	@FindBy(xpath="//input[@id='Role'][@value='GlobalOperationHead']")
	WebElement rad_hiringapprover;
	
	@FindBy(xpath="//tr[2]/td[3]")
	WebElement jobcode_gridfirst;
	
	@FindBy(xpath="//td[13]/a")
	WebElement viewlnk_gridfirst;
	
	@FindBy(xpath=".//*[@id='midContainer']/ul/li[2]/a")
	WebElement submenu_approve;
	
	@FindBy(xpath="//div[3]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]")
	WebElement firstjobcode_inapprovedsubmenu;
	
	@FindBy(xpath="//td/input")
	WebElement chkbx_firstingrid;
	
	@FindBy(id="btnMultiApprove")
	WebElement btn_multiapprove;
	
	////-- element on job request details page--
	
	@FindBy(xpath=".//*[@id='CreateRequestDiv']/table[1]/tbody/tr[1]/td[2]/span")
	WebElement lbl_jobreqid; ///job request id on new window
	
	@FindBy(id="Comment")
	WebElement txt_comment;
	
	@FindBy(xpath="//button")
	WebElement btn_close;
	
	@FindBy(id="btnApprove")
	WebElement btn_approve;
	
	@FindBy(xpath="html/body/div[9]/div[3]/div/button/span")
	WebElement btn_Ok_onalert;
	
	@FindBy(id="btnReject")
	WebElement btn_reject;
	

	
   @FindBy(xpath=".//*[@id='CreateRequestDiv']/table[1]/tbody/tr[12]/td[2]/table/tbody/tr/td[2]/a")
   WebElement link_downloadjobprofile;
	
	public void approveRequest() throws InterruptedException, AWTException
	{		
		
		String firstjobcodeforhiringapprover= jobcode_gridfirst.getText();
		System.out.println("first job request in grid for hiring approver is :"+ firstjobcodeforhiringapprover);
		
		viewlnk_gridfirst.click();
		
		DynamicWait.expwaitelmnttobeclickable(driver, 30, txt_comment);
		
		String jobreqid= lbl_jobreqid.getText();
		System.out.println("job request id on new window is: "+ jobreqid);
		System.out.println("job request id is verified in job request details window");
		
		txt_comment.sendKeys("comment by hiring approver");
		
		Assert.assertEquals(jobreqid, firstjobcodeforhiringapprover);
		
		btn_approve.click();
		
		Thread.sleep(2000);
		
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(6000);
		
		//DynamicWait.expwaitpresenceofelement(driver, 50, By.xpath(".//*[@id='gview_jqOpenRequestTable']/div[3]")); //  myrequest > grid object
		
		submenu_approve.click();
		
		Thread.sleep(2000);
		
		String firstjobcodeinapprove= firstjobcode_inapprovedsubmenu.getText();
		System.out.println("first job code in Approved submenu is: "+ firstjobcodeinapprove);
		
		Assert.assertEquals(firstjobcodeinapprove, firstjobcodeforhiringapprover);
		System.out.println("job request is successfully verified in Approved submenu");
		
	}
	
	public void multiapprove() throws InterruptedException, AWTException
	{
		String firstjobcodeforhiringapprover= jobcode_gridfirst.getText();
		System.out.println("first job request in grid for hiring approver is :"+ firstjobcodeforhiringapprover);
		
		chkbx_firstingrid.click();
		
		btn_multiapprove.click();
		
		Thread.sleep(2000);
		
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
	}
}