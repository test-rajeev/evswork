package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DynamicWait;
import helper.ExcelRead;

public class CreateRequest {
	
static WebDriver driver;
	
	
	public CreateRequest(WebDriver driver)
	{		
		this.driver=driver;
		
	}

	@FindBy(xpath=".//*[@id='topNav']/div[1]/ul/li[2]/a")
//	@CacheLookup
	WebElement menu_createjobrequest;
		
	@FindBy(id="SubLOB")
//	@CacheLookup
	WebElement dropdown_subLoB;
	
	@FindBy(id="WorkLocation")
//	@CacheLookup
	WebElement dropdown_worklocation;
	 
	@FindBy(id="Grade")
//	@CacheLookup
	WebElement dropdown_grade;
	
	@FindBy(id="Designation")
//	@CacheLookup
	WebElement dropdown_designation;
	
	@FindBy(id="ExperienceFrom")
//	@CacheLookup
	WebElement textbox_expfrom;
	
	@FindBy(id="ExperienceTo")
//	@CacheLookup
	WebElement textbox_expto;
	
	@FindBy(xpath="//input[@id='RequestType']")
//	@CacheLookup
	WebElement radiobtn_newrequirement;
	
	@FindBy(xpath="//input[@id='NatureOfJob']")
//	@CacheLookup
	WebElement radiobtn_permanent;
	
	@FindBy(id="ReportingManagerID")
//	@CacheLookup
	WebElement dropdown_reportingmngr;
	
	@FindBy(id="JobFamilyId")
//	@CacheLookup
	WebElement dropdown_jobfamily;
	
	@FindBy(id="Qualification")
//	@CacheLookup
	WebElement listbox_qualification;
	
	@FindBy(id="skill")
//	@CacheLookup
	WebElement dropdown_skill;
	
	@FindBy(id="Client")
//	@CacheLookup
	WebElement txt_client;
	
	
	@FindBy(xpath=".//*[@id='IsBillable'][@value='true']")
//	@CacheLookup
	WebElement rad_yes_billable;
	
	@FindBy(xpath=".//*[@id='IsBillable'][@value='false']")
//	@CacheLookup
	WebElement rad_no_billable;
	
	@FindBy(xpath="//div[@id='midContainer']/form/table[2]/tbody/tr[11]/td[2]/div/div[2]/iframe")
	//@CacheLookup
	WebElement  tiframe;
	

	@FindBy(id="Comment")
	//@CacheLookup
	WebElement txt_comment;
	
	@FindBy(id="Submit")
//	@CacheLookup
	WebElement btn_submit;
	
	@FindBy(id="PreApproved")
//	@CacheLookup
	WebElement chkbx_preapproved;
	
	@FindBy(id="ApprovalMailFile")
//	@CacheLookup
	WebElement btn_browse;
	
	@FindBy(id="ApprovedBy")
//	@CacheLookup
	WebElement dropdown_approvedby;
	
	@FindBy(linkText="Edit")
//	@CacheLookup
	WebElement lnk_firsteditingrid;
	
	@FindBy(xpath=".//*[@id='ApprovalMailFile']")
	WebElement brwse_btn;
	
	@FindBy(xpath=".//*[@id='ApprovedBy']")
	WebElement drp_approvedby;
	
	@FindBy(id="MailCC")
	WebElement txt_mailCC;
	
	
	@FindBy(linkText="Approved")
	WebElement submenu_approved;
		
	
	
	public void createjobrequest() throws AWTException, InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		menu_createjobrequest.click();
		
		DynamicWait.expwaitelmnttobeclickable(driver, 60, txt_mailCC);
		
		Select wl=new Select(dropdown_worklocation);
		wl.selectByValue("9"); // selected  'India - .Com-Gurgaon'
		
		
		Select gr=new Select(dropdown_grade);
		gr.selectByValue("6"); // selected  'SBA'
		
		
		Select de=new Select(dropdown_designation);
		de.selectByValue("25"); // selected  'Sr. software engineer'
		
		Thread.sleep(1000);
		textbox_expfrom.clear();
		textbox_expfrom.sendKeys("5");
		textbox_expto.clear();
		Thread.sleep(1000);
		textbox_expto.sendKeys("8");
		
		Thread.sleep(1000);
		radiobtn_newrequirement.click();
		
		radiobtn_permanent.click();
		
		
		Select rm=new Select(dropdown_reportingmngr);
		rm.selectByValue("7747"); // selected CRK 4753 not present frm 21Apr2016// other values-- 13932 'Adrian Pinto', 7747 Madhup Narula
		
		
		Select jf=new Select(dropdown_jobfamily);
		jf.selectByValue("13"); // selected  'Software Testing'
		
		
		Select qu=new Select(listbox_qualification);
		qu.selectByValue("10"); // selected  'BCA'
		
		Select sk=new Select(dropdown_skill);
		sk.selectByValue("45"); // selected  'Apple Technology'
		
		txt_client.sendKeys("Insightbee");
		
		rad_yes_billable.click();		
		
		List<WebElement> frameList=driver.findElements(By.tagName("iframe"));
		System.out.println("\n");
		System.out.println("no of frames on page: "+ frameList.size());
		
		
		frameList=driver.findElements(By.tagName("body"));
		System.out.println("no of body tag on page is: "+ frameList.size());
      
		// use java script executor to focus on frame
    	((JavascriptExecutor)driver).executeScript("window.scrollTo(0," +driver.findElement(By.xpath(".//*[@id='midContainer']/form/table[2]/tbody/tr[12]/td[2]/div/div[2]/iframe")).getLocation().y+")");

		WebElement descriptionElement = driver.findElement(By.xpath(".//*[@id='midContainer']/form/table[2]/tbody/tr[12]/td[2]/div/div[2]/iframe"));

		driver.switchTo().frame(descriptionElement);	
		WebElement editable= driver.switchTo().activeElement();	

	
		// use robot class object to write in job description 
		Robot	robot = new Robot();
		setClipboardData("test candidate");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		System.out.println("test description is added");
		/*robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);*/
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
	//	ExcelRead x= new ExcelRead();
	//	ExcelRead.setexcel("C:\\TestData.xlsx", "internaltransfer");
		//ExcelRead.getCellData(14, 2);
		
		// txt_comment.sendKeys(ExcelRead.getCellData(14, 2));
		txt_comment.sendKeys("test comment");
		chkbx_preapproved.click();
		
		Thread.sleep(3000);
	try{
		uploaadfile1(brwse_btn, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\IT Notification-GyaanPaatra Application downtime - Completed.msg");
		} catch (NotFoundException e){System.out.println("security message appeared");}
		Thread.sleep(4000);
		
		Select pa=new Select(drp_approvedby);
		pa.selectByValue("7747"); // pre approved by madhup narula
		
		
	    btn_submit.click();
		Thread.sleep(4000);
		
		
		 boolean noalert = true;
		 while (noalert){
		  try {
		   Alert al = driver.switchTo().alert();
		   noalert = false;
		   al.accept();
		  } catch (NoAlertPresentException e){
			
		  }
		 }
		 
		/*	try
		{	
		Alert alert = driver.switchTo().alert();
		String alertmsg= alert.getText();
		System.out.println("alert found and message shown is:"+alertmsg); // o/p: Request Submitted successfully
		alert.accept();
		} catch (Exception e) 
		{*/
		
	    //do what you normally would if you didn't have the alert.
			
		
			//	Thread.sleep(1000);
			//	DynamicWait.expwaitpresenceofelement(driver, 60, By.xpath(".//*[@id='gbox_jqOpenRequestHM']")); //  myrequest > grid object .//*[@id='jqOpenRequestHM']
			Robot rob= new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);		
		 DynamicWait.expwaitelmnttobeclickable(driver, 80, lnk_firsteditingrid);
	
		}
	
		public static void  setClipboardData(String str)
		{		
		StringSelection ss = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		System.out.println("text desc is added");
		System.out.println("text desc is added SUCCESSFULLY");
		
		}
	
	public static void uploaadfile1(WebElement element, String filepath) 
	{	
		element.click();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.switchTo().activeElement().sendKeys(filepath);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    return;
	}
	
	public void verifyCreatedRequest() throws InterruptedException
	{
		submenu_approved.click();
		Thread.sleep(2000);
	}
	
}
