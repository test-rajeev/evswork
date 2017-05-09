package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import evs.trts.tests.TestExecute;
import helper.DynamicWait;

public class FPnA_Approval 
{
	WebDriver driver;
	
	public FPnA_Approval(WebDriver pdriver)
	{
		this.driver=pdriver;
	}
		
@FindBy(xpath=".//*[@id='Role'][@value='FPAOperation']")
WebElement rad_FPnA;

@FindBy(xpath="//td/input")
WebElement chk_firstjobcode;   // added new locator as per TRT-201606-001_03 pageid (CRN_TRT-201606-001).


@FindBy(xpath=".//*[@id='btnMultiReferBack']")
WebElement btn_referback;   // added new locator as per TRT-201606-001_03 pageid (CRN_TRT-201606-001).

@FindBy(xpath=".//*[@id='MultiReferBack_error']")
WebElement lbl_errorforreferback;   // added new locator as per TRT-201606-001_03 pageid (CRN_TRT-201606-001).

@FindBy(xpath=".//*[@id='Comment']")
WebElement txt_commentboxReferback;   // added new locator as per TRT-201606-001_03 pageid (CRN_TRT-201606-001).

@FindBy(xpath="//button[@type='button']")
WebElement btn_Submitreferbackcommnet;   // added new locator as per TRT-201606-001_03 pageid (CRN_TRT-201606-001).

@FindBy(xpath="//tr[2]/td[3]")
WebElement jobcode_firstingridforFPnA;  

@FindBy(xpath="//td[13]/a")
WebElement lnk_firstViewforfpna;

@FindBy(css="span.labelCol")
WebElement lbl_jobcodeinViewforFpnA;

@FindBy(id="Comment")
WebElement txt_commentforFpna;

@FindBy(id="btnFPAApprove")
WebElement btn_FPnaAprvd;

@FindBy(id="btnFPAReturn")
WebElement btn_FpnArefferedback;

@FindBy(xpath="//td/input")
WebElement chkbx_firstingridforFPnaAfterApprove;

@FindBy(linkText="Approved")
WebElement lnk_approvedsubmenuforfpna;

@FindBy(xpath="//td[12]/a")
WebElement lnk_firstviewinApprovedmenu;

@FindBy(xpath="//div[3]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]")
WebElement jobcode_firstingridforFPnaInApprovedsubmenu;

@FindBy(xpath="//button[@type='button']")
WebElement btn_OK;

@FindBy(xpath=".//*[@id='1360']/td[3]")
WebElement jobcode_forTemptest;

@FindBy(xpath=".//*[@id='1360']/td[13]/a")
WebElement lnk_viewTemptest;

@FindBy(linkText="Download approval mail file")
WebElement lnk_dwnldapprvlmail;

@FindBy(linkText="Download Hiring Requests")
WebElement lnk_dwnldExcel;


	Logger logger=Logger.getLogger(FPnA_Approval.class);
  //  static String job=jobcode_firstingridforFPnA.getText();
	

	public void fpnaApprovalreferback() throws InterruptedException, AWTException
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// String jobcodefpna= jobcode_firstingridforFPnA.getText();
		System.out.println("Job code for FPnA approval is "+ jobcode_firstingridforFPnA.getText());
		logger.info("job code for FPnA is" + jobcode_firstingridforFPnA.getText());   
		
	/*	System.out.println("Job code for FPnA approval is "+ jobcode_forTemptest.getText());
		logger.info("job code for FPnA is" + jobcode_forTemptest.getText());*/
		
		//changes as per TRT-201606-001_03 --------------------------------------------------------------------------------------------------
	
		chk_firstjobcode.click(); 
		//jobcode_forTemptest.click();
		
		btn_referback.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 7, txt_commentboxReferback);
		txt_commentboxReferback.sendKeys("referred back from main page");
		btn_Submitreferbackcommnet.click();
		Thread.sleep(5000);
		Robot rf= new Robot();
		rf.keyPress(KeyEvent.VK_ENTER);
		rf.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(9000);
		//-------------------------------------------------------------------------------------------------------------------------------------------
	}
		public void approvedAndDwnldfromInside() throws InterruptedException
		{
			
	//   lnk_viewTemptest.click();
		 lnk_firstViewforfpna.click(); 
		
		DynamicWait.expwaitelmnttobeclickable(driver, 40,txt_commentforFpna);
		System.out.println("\n");
		System.out.println("Job code in View details window is "+ lbl_jobcodeinViewforFpnA.getText());
		txt_commentforFpna.sendKeys("FPaA approved");
	//	lnk_dwnldapprvlmail.click();  //  its clicking
		
		
		
		// if user want to download approval mail then uncommnent below code
		/*	FPnA_downloadMail fp = new FPnA_downloadMail();
			try{
			fp.rightClick(lnk_dwnldapprvlmail,driver);
			} catch (Exception e) {System.out.println("mail download unsuccessfull");}
			
			Thread.sleep(2000);
			
			try{
			fp.saveFile(driver);
			Thread.sleep(3000);
			fp.pressEnter();
			
			} catch (NullPointerException e) {e.printStackTrace();} catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		Thread.sleep(3000);	
			*/
			
			
		
		btn_FPnaAprvd.click();
		Thread.sleep(3000);
		btn_OK.click();
		
		DynamicWait.expwaitelmnttobeclickable(driver, 20,chkbx_firstingridforFPnaAfterApprove);
		Thread.sleep(2000);
		
		}
	
		public void downloadRequestExcel() throws InterruptedException,AWTException
		{
			
	
				FPnA_downloadMail fp = new FPnA_downloadMail();
				try {
				fp.rightClick(lnk_dwnldExcel,driver);
				} catch (Exception e){e.printStackTrace();}
				
				try {
					fp.saveFile(driver);
					Thread.sleep(7000);
				   }
				catch (Exception e) {e.printStackTrace();	
				}
				
				fp.newWindowHandle();
				
				/*Thread.sleep(1000);
				try{
				fp.replaceExistingdownloadRequestExcel(driver); } catch (Exception e){e.printStackTrace();}*/
			    return;
		}

		public void verifyFpnAapproval()
		{
		lnk_approvedsubmenuforfpna.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 30,lnk_firstviewinApprovedmenu);
		System.out.println("job code in approved submenu for FPnA is "+ jobcode_firstingridforFPnaInApprovedsubmenu.getText());
		System.out.println("job code is verified successfully for FPnA");
	//	Assert.assertEquals(jobcode_firstingridforFPnaInApprovedsubmenu.getText(),jobcode_firstingridforFPnA.getText());
		
	}
		
		public void pressEnter() throws AWTException
		{
			Robot ro = new Robot();			
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
		}
	
}

