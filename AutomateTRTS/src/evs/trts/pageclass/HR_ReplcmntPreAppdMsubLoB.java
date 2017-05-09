package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import helper.DynamicWait;

public class HR_ReplcmntPreAppdMsubLoB extends CreateRequest

{
	
	public HR_ReplcmntPreAppdMsubLoB(WebDriver rdriver)
	{		
		super(rdriver);
		
	}

	@FindBy(xpath="//input[@id='RequestType'][@value='Replacement']")
	WebElement radiobtn_replacement;
	
	@FindBy(id="ReplacementEmployee")
	WebElement txt_replcmnt;
	
	@FindBy(id="PreApproved")
	WebElement chkbx_preapproved;
	
	
	@FindBy(xpath=".//*[@id='ApprovalMailFile']")
	WebElement brwse_btn;
	
	@FindBy(xpath=".//*[@id='ApprovedBy']")
	WebElement drp_approvedby;
	
	@FindBy(css="span.userClr")
	WebElement loggedin_user;

	public void createRequestReplcAndPreapproved() throws AWTException, InterruptedException
	{
	
		String[][] RP = new String[3][1];
		RP[0][0] = "le"; // employee whose replacement is needed 
		
		//fooString1.equals(fooString2);
	String hiringrequester="Atithi Ganjoo";
	String hrforAVP="Sheetal Ranganathan";   // to check '-M' sublob for AVP and above level
	
//===========================================================================================================================================
		
		menu_createjobrequest.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 100, txt_comment);
		
		Select wl=new Select(dropdown_worklocation);
		Select gr=new Select(dropdown_grade);
		Select slob=new Select(dropdown_subLoB);
		Select de=new Select(dropdown_designation);
		
		if (hiringrequester.equals(loggedin_user.getText()))
		{
		wl.selectByValue("9"); // selected  'India - .Com-Gurgaon'
		gr.selectByValue("6"); // selected  'SBA'
		Thread.sleep(1000);
		de.selectByValue("25"); // selected  'Sr. software engineer' // 340
		
		}  else if (hrforAVP.equals(loggedin_user.getText())) // check if sheetal rangnathan is logged
		
		{
			wl.selectByValue("11"); // selected  'India - SEZ'
			gr.selectByValue("7"); // selected BA
			Select sel = new Select(driver.findElement(By.id("SubLOB")));
			List<WebElement> list = sel.getOptions();
			list.remove(sel.getFirstSelectedOption());////Removing the first dropdown option from the list, i.e., '-Select Style-'
			System.out.println("list of Sub LoB for BA level: ");
			System.out.println("\n");
			for(WebElement ele: list) 
			System.out.println(ele.getText());
			
			Thread.sleep(1000);
			gr.selectByValue("3"); // selected  'AVP'  ; 1= vp
		    Select selavp = new Select(driver.findElement(By.id("SubLOB")));
			List<WebElement> dd = selavp.getOptions();
			System.out.println(dd.size());
			String names[] = new String[6];
			names[0]=dd.get(2).getText();
			System.out.println(names[0]);
		
		/*	for (int j = 0; j < dd.size(); j++) 
			{
			        System.out.println(dd.get(j).getText());

			 }*/
			   
			   
		//	list = sel.getOptions();
		//  list.remove(sel.getFirstSelectedOption());
		//	System.out.println("list of Sub LoB for AVP level: ");
		//	System.out.println("\n");
		//	for(WebElement elem: list)
		//	System.out.println(elem.getText());
		
			Assert.assertEquals(names[0], "LSHC-00-M (SEZ)");
			de.selectByValue("340"); // selected  'Associate Head of Research ' // 340
			
		}
		
		
		Thread.sleep(3000);
		radiobtn_replacement.click();
		
		Thread.sleep(2000);
		txt_replcmnt.sendKeys(RP[0][0]);
		
		Thread.sleep(3000);
		Robot rp = new Robot();
		rp.keyPress(KeyEvent.VK_DOWN);
		rp.keyRelease(KeyEvent.VK_DOWN);
		rp.keyPress(KeyEvent.VK_ENTER);
		rp.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		radiobtn_permanent.click();
		
		Select rm=new Select(dropdown_reportingmngr);
		Select jf=new Select(dropdown_jobfamily);
		if (hiringrequester.equals(loggedin_user.getText()))
		{
		rm.selectByValue("7747"); // selected CRK 4753 not present frm 21Apr2016// other values-- 13932 'Adrian Pinto', 7747 Madhup Narula; 7566 Antra Sethi(SEZ-2046)<
		jf.selectByValue("13"); // selected  'Software Testing'
		
		} else if (hrforAVP.equals(loggedin_user.getText())) // sheetal login
		{
			rm.selectByValue("7566");  // 7566 Antra Sethi(SEZ-2046)
			jf.selectByValue("23"); // selected  'Software Testing'
		}
		
		Select qu=new Select(listbox_qualification);
		qu.selectByValue("10"); // selected  'BCA'
		
		Select sk=new Select(dropdown_skill);
		sk.selectByValue("45"); // selected  'Apple Technology'
		
		txt_client.sendKeys("damco");
		
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
		txt_comment.sendKeys("testcomment");
			
	
		
		if (hiringrequester.equals(loggedin_user.getText())) 
		{
		chkbx_preapproved.click();
		
		Thread.sleep(3000);
	
		uploaadfile1(brwse_btn, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\IT Notification-GyaanPaatra Application downtime - Completed.msg");
		Thread.sleep(3000);
		
		Select pa=new Select(drp_approvedby);
		pa.selectByValue("7747"); // pre approved by madhup narula
	
		
	    btn_submit.click();
		
		Thread.sleep(5000);
			
		try { 
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		    //if alert present, accept and move on.
		}
		catch (NoAlertPresentException e) {
			
		    //do what you normally would if you didn't have the alert.
			
			Robot rob= new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
		}
		
		DynamicWait.expwaitelmnttobeclickable(driver, 80, lnk_firsteditingrid);
		}
		
	}
	
	public static void uploaadfile1(WebElement element, String filepath) 
	{	
		element.click();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.switchTo().activeElement().sendKeys(filepath);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    return;
	}
	
	public void LogOut() throws InterruptedException
	{
		 driver.findElement(By.xpath("//img[@alt='Logout']")).click(); /// click on logout 
		 Thread.sleep(1000);
		 driver.findElement(By.linkText("here")).click(); /// click on here link after logout
		 Thread.sleep(1000);
		 
		 
	}
	
	
	public void checkMsubLoBforAVP() throws InterruptedException
	{
	
		//createRequestReplcAndPreapproved;
		 
	}
	
	
}
