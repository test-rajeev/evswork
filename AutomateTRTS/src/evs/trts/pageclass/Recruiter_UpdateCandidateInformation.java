package evs.trts.pageclass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DynamicWait;

public class Recruiter_UpdateCandidateInformation {
	
	static WebDriver driver;
	
	public Recruiter_UpdateCandidateInformation(WebDriver rdriver)
	{
		this.driver=rdriver;
	}

	@FindBy(xpath="//tr[2]/td[2]/a") //first ---  "xpath=//tr[2]/td[2]/a"; // for quick find : "linkText=IND2016May1220"
	WebElement firstjoblink;
	
	@FindBy(id="JobID")
	WebElement drpdwn_jobcode;
	
	@FindBy(id="status")
	WebElement drpdwn_status;
	
	@FindBy(id="Reason")
	WebElement drpdwn_reason;
	
	@FindBy(id="Candidate_FirstName")
	WebElement txt_candidateFname;
	
	@FindBy(id="Candidate_MiddleName")
	WebElement txt_candidateMname;
	
	@FindBy(id="Candidate_LastName")
	WebElement txt_candidateLname;
	
	@FindBy(id="strJoiningDate")
	WebElement caln_calander;
	
	@FindBy(id="EmpCode")
	WebElement txt_empcode;
	
	@FindBy(id="ContactNo")
	WebElement txt_contactnum;
	
	@FindBy(id="EmailID")
	WebElement txt_emailid;
	
	@FindBy(id="Location")
	WebElement drpdwn_entity;
	
	@FindBy(id="CurrentLocation")
	WebElement txt_crrntloc;
	
	@FindBy(id="CurrentOrganisation")
	WebElement txt_crntorganisation;
	
	@FindBy(id="NoticePeriodCurrentindays")
	WebElement txt_noticeperiod;
	
	@FindBy(id="CurrentSalary")
	WebElement txt_crntsalary;
	
	@FindBy(id="ExpectedCTC")
	WebElement txt_expCTC;
	
	@FindBy(id="Skills")
	WebElement drpdwn_skill;
	
	@FindBy(id="HighestQualification")
	WebElement drpdwn_highestqualif;
	
	@FindBy(id="Specialization")
	WebElement drpdwn_specilalization;
	
	@FindBy(id="PassingYear")
	WebElement txt_passingyear;
	
	@FindBy(id="Percentage")
	WebElement txt_percentage;
	
	@FindBy(id="CollegeUniversity")
	WebElement txt_collegeUniv;
	
	@FindBy(id="TotalExperienceYear")
	WebElement txt_ttlexpYr;
	
	@FindBy(id="TotalExperienceMonth")
	WebElement txt_ttlexpMon;
	
	@FindBy(id="RelevantIndustryExperienceYear")
	WebElement txt_relevINDxpYr;
	
	@FindBy(id="RelevantIndustryExperienceMonth")
	WebElement txt_relevINDxpMon;
	
	@FindBy(id="RelevantExperienceYear")
	WebElement txt_relevxpYr;
	
	@FindBy(id="RelevantExperienceMonth")
	WebElement txt_relevxpMo;
	
	@FindBy(id="ChannelSource")
	WebElement drpdown_channelsource;
	
	@FindBy(id="VendorCost")
	WebElement txt_vendorcost;
	
	@FindBy(id="SourceName")
	WebElement drpdown_sourceName;
	
	@FindBy(id="SourceOther")
	WebElement txt_sourceNameasOther;
	
	@FindBy(id="SourcerName")
	WebElement drpdown_sourcerName;
		
	@FindBy(id="file")
	WebElement browsebtn_uploadresume;
	
/*	@FindBy(id="File") //// if 'File' not work then use 'File0'
	WebElement browsebtn_uploadFit;*/
	
	@FindBy(xpath="//td[4]/input[2]")
	WebElement browsebtn_uploadFit;
	
	@FindBy(id="pofile")
	WebElement browsebtn_purchaseorder;
	
	@FindBy(id="CAFFile0")
	WebElement browsebtn_CAF;
	
	@FindBy(id="IdProof_Id")
	WebElement dropdwn_idproof;
	
	@FindBy(id="Comments")
	WebElement txt_comments;
	
	@FindBy(id="TravelCost")
	WebElement txt_travelcost;
	
	@FindBy(id="MiscCost")
	WebElement txt_miscost;
	
	@FindBy(id="fileAuditData")
	WebElement browsebtn_AuditZip;
	
	@FindBy(id="btnGenerateHRSSRequest")
	WebElement btn_HRSSRequest;
	
	@FindBy(id="Update")
	WebElement btn_update;
	
	@FindBy(linkText="Update Candidate Information")
	WebElement menu_updatecandidateinfn;

	static String firstjobcodeforUCInfo;
	
	static String jobcodeonEdit;
	
	/////locators in grid $$$$$ .. xpath find using IDE
	
	@FindBy(xpath="//div/table/tbody/tr[2]/td[3]")
	WebElement firstjobcodeingrid_uci;
	
	@FindBy(xpath="//tr[2]/td[7]")
	WebElement statusselectedingrid_uci;
	
	@FindBy(xpath="//td[8]/a")
	WebElement Resumelinkingrid_uci;
	
	@FindBy(xpath="//td[9]/a")
	WebElement Fitformlinkingrid_uci;
	
	
	@FindBy(xpath="//td[10]/a")
	WebElement CAFlinkingrid_uci;
	
	@FindBy(xpath="//td[11]/a")
	WebElement POlinkingrid_uci;
	
	@FindBy(xpath="//input[@value='Edit']")  //earlier used and worked but not now //td[13]/input
	WebElement firstEditlinkingrid_uci; // clicking this will not highlight in IDE
	
	@FindBy(xpath="//td[14]/a")
	WebElement firstGeneratelinkingrid_uci;
	
	@FindBy(xpath="//td[6]/span")
	WebElement nextpagenavigation_uci;
	
	@FindBy(xpath="//div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/span")
	WebElement backpagenavigation_uci;
	
	@FindBy(xpath="//a[contains(text(),'Generate')]")
	WebElement lnk_firstgenerate;
	
	public void updateCandidateinfo() throws InterruptedException, AWTException
	{
		
		String[][] uci = new String[4][2];
		uci[0][0] = "Devendra";  	// first name
		uci[1][0] = "kUMAR";		// middle name
		uci[2][0] = "Pandy"; 	// last name
		uci[0][1] = "Pie"; // other source name
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		firstjobcodeforUCInfo=firstjoblink.getText();
		System.out.println("first job code to update is:" + firstjobcodeforUCInfo);
		
		firstjoblink.click();
	
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(txt_candidateFname));
		 
		Select gr=new Select(drpdwn_status); 
		gr.selectByValue("7"); //// selected 'selected'
				
		txt_candidateFname.clear();
		Thread.sleep(1000);
		txt_candidateFname.sendKeys(uci[0][0]);
		txt_candidateMname.clear();
		txt_candidateMname.sendKeys(uci[1][0]);
		txt_candidateLname.clear();
		txt_candidateLname.sendKeys(uci[2][0]);
		Thread.sleep(2000);
		//try{
		calanderdatepic();
		//} catch (NotFoundException e) {System.out.println("date is not found");}
	//	Thread.sleep(1000);
		
		Thread.sleep(2000);
		txt_contactnum.clear();
		txt_contactnum.sendKeys("9586895621");
		Thread.sleep(1000);
		txt_emailid.clear();
		txt_emailid.sendKeys("ab@gmail.com");

	// this field is now disabled : 07 Oct 2016
	//	selectvaluefromdrpdwn(drpdwn_entity,"9");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		txt_crrntloc.clear();
		txt_crrntloc.sendKeys("Noida");
		txt_crntorganisation.clear();
		txt_crntorganisation.sendKeys("Facebook");
		Thread.sleep(2000);
		txt_noticeperiod.clear();
		txt_noticeperiod.sendKeys("30");
		txt_crntsalary.clear();
		txt_crntsalary.sendKeys("800000");
		Thread.sleep(1000);
		txt_expCTC.clear();
		txt_expCTC.sendKeys("1000000");
		selectvaluefromdrpdwn(drpdwn_skill,"45"); //Apple Technology//  other values 46,47 -> sharepoint, vba
		selectvaluefromdrpdwn(drpdwn_highestqualif,"11"); // MCA // other values 8, 10 - MBA, BCA
		selectvaluefromdrpdwn(drpdwn_specilalization,"6"); // COMPUTERS // other values 1,2- acccountancy, arts
		txt_passingyear.clear();
		txt_passingyear.sendKeys("2009");
		txt_percentage.clear();
		txt_percentage.sendKeys("88");
		txt_collegeUniv.clear();
		txt_collegeUniv.sendKeys("MDU");
		txt_ttlexpYr.clear();
		txt_ttlexpYr.sendKeys("9");
		txt_ttlexpMon.clear();
		txt_ttlexpMon.sendKeys("8");
		txt_relevINDxpYr.clear();
		txt_relevINDxpYr.sendKeys("7");
		txt_relevINDxpMon.clear();
		txt_relevINDxpMon.sendKeys("6");
		txt_relevxpYr.clear();
		txt_relevxpYr.sendKeys("5");
		Thread.sleep(500);
		txt_relevxpMo.clear();
		txt_relevxpMo.sendKeys("4");
		selectvaluefromdrpdwn(drpdown_channelsource,"5"); // SOURCER 5// other values 1, 2, 5 - Job Board, Employee Referral, Consultant
		txt_vendorcost.clear();
		txt_vendorcost.sendKeys("6000");
		Thread.sleep(1000);
		selectvaluefromdrpdwn(drpdown_sourceName,"13"); //ABC CONSULTANT 13 // rest values are 1, 3 - naukri, monster
	//	txt_sourceNameasOther.clear();
	//	txt_sourceNameasOther.sendKeys(uci[0][1]);
		selectvaluefromdrpdwn(drpdown_sourcerName,"3"); //Radhika  Acharya 3// other values 2 - debasis nandi
		
		Thread.sleep(1000);
		
		try{
		uploaadfile(browsebtn_uploadFit, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\TestFitForm.docx");
		}
		catch(Exception e){System.out.println("organisaton security message appear");}
		
		Thread.sleep(3000);
		
		try{
		uploaadfile(browsebtn_uploadresume, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\TestResume.docx");
		}
		catch(Exception e){System.out.println("organisaton security message appear");}
		
		Thread.sleep(3000);
		
	/*	uploaadfile(browsebtn_uploadFit, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\TestFitForm.docx");
		Thread.sleep(1000);*/
		try{
		uploaadfile(browsebtn_purchaseorder, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\TestPO.png");
		} 	catch(Exception e){System.out.println("organisaton security message appear");}
		
		Thread.sleep(3000);
		
		try{
		uploaadfile(browsebtn_CAF, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\TestCAF.docx");
		} catch(Exception e){System.out.println("organisaton security message appear");}
				
		
		Thread.sleep(3000);
		
		selectvaluefromdrpdwn(dropdwn_idproof,"3"); // ADHAAR CARD // other values 1, 2 - passport, license
		txt_comments.clear();
		txt_comments.sendKeys("test comment");
		txt_travelcost.clear();
		txt_travelcost.sendKeys("abc");
		txt_travelcost.clear();
		txt_travelcost.sendKeys("1000");
		txt_miscost.clear();
		txt_miscost.sendKeys("fdc");
		txt_miscost.clear();
		txt_miscost.sendKeys("750");
		Thread.sleep(1000);
		uploaadfile(browsebtn_AuditZip, "C:\\TRTSautomationStuffs\\uploadedfilesforUCInfo\\trts audit test.zip");
		Thread.sleep(2000);
		btn_update.click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
	/*	Alert alert = driver.switchTo().alert();
		alert.accept();*/
		
		boolean noalert = true;
		while (noalert)
		{
		try{	
			
			Alert alert = driver.switchTo().alert();
			noalert= false;
			String alertmsg= alert.getText();
			System.out.println("alert found and message shown is:"+alertmsg); // o/p: Request Submitted successfully
			alert.accept();	
			}   catch (NoAlertPresentException e){ } 
		}
		
		
		
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		}
		
			
	public static void calanderdatepic() throws InterruptedException
	{
		
    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    //find the calendar
    driver.findElement(By.id("strJoiningDate"));  
    driver.findElement(By.id("strJoiningDate")).click();
    //driver.findElement(By.id("strJoiningDate")).clear();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(2000);
    }
	
	public static void selectvaluefromdrpdwn( WebElement element, String str)
	{
		Select selectval=new Select(element);
		selectval.selectByValue(str);
	}
	
	public static void uploaadfile(WebElement element, String filepath) 
	{	
		element.click();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.switchTo().activeElement().sendKeys(filepath);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    return;
	}
	
	public void verifyUpdatedJobcode()
	{
		String updatedjobcodeingrid=firstjobcodeingrid_uci.getText();
		System.out.println("first job code in grid is :" + updatedjobcodeingrid);
		
		if(updatedjobcodeingrid.equals(firstjobcodeforUCInfo) && "Selected".equals(statusselectedingrid_uci.getText()))
			
		{
			System.out.println("updated job code is verified which is :" +updatedjobcodeingrid );
		} else 
		{ System.out.println("verification failed since job code is mismatched");
		}
	
	}
	
	public void verifyUploadedfiles() throws InterruptedException, AWTException
	{
		System.out.println("Method verifyUploadedfiles is started to verify uploads");
		System.out.println("Uploaded Resume title is: " + Resumelinkingrid_uci.getText());
		System.out.println("Uploaded Fit form tile is: "+ Fitformlinkingrid_uci.getText());
		System.out.println("Uploaded CAF tile is: "+ CAFlinkingrid_uci.getText());
		System.out.println("Uploaded PO title is: "+ POlinkingrid_uci.getText());
		System.out.println("document Upload verification is completed");
		System.out.println("\n");
		Thread.sleep(2000);
		return;
		}
	
	public void editCandidateInformation() throws AWTException, InterruptedException
	{
		System.out.println("Method editCandidateInformation is started to edit candidate data");
		//menu_updatecandidateinfn.click();
		//Thread.sleep(2000);
		firstEditlinkingrid_uci.click();
		try{
		DynamicWait.expwaitelmnttobeclickable(driver, 20, txt_emailid);
		} catch ( Exception e){System.out.println("ELEMENT NOT VISIBLE");}
		txt_emailid.clear();
		txt_emailid.sendKeys("editedmail@gmail.com");
		btn_update.click();
		Thread.sleep(3000);
		Robot rob= new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("candidate data is edited successfully");
		Thread.sleep(3000);
		return;
	}
	
	public void clickOnGenerateLink() throws InterruptedException
	{
		lnk_firstgenerate.click();
		Thread.sleep(8000);
		return;
	}
	
		public boolean isLinkClickable(String xpath)
		{
	    WebElement lnk = driver.findElement(By.xpath(xpath));
	       try {
	    	   lnk.click(); 
	          return true;
	        } catch(Exception e){
	          return false;
	       }
	}
	
	
}


