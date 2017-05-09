package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.DynamicWait;

public class Recruiter_CampusOL extends Recruiter_GenerateOfferLetter {

	public Recruiter_CampusOL(WebDriver odriver) 
	{
		super(odriver);
		
	}
	
	
	public void generateCampusOL() throws InterruptedException, AWTException
 	{
		String [][] camp= new String [15][1];
		camp[0][0]= "CampusFatherF";
		camp[1][0]= "CampusFatherM";
		camp[2][0]= "CampusFatherL";
		camp[3][0]= "cmps add1";
		camp[4][0]= "camps add2";
		camp[5][0]= "Chail";
		camp[6][0]= "HP";
		camp[7][0]= "550022"; // pin code
		camp[8][0]= "2035"; // select CC_KT-1 (IND-STP-I)
		camp[9][0]= "9103"; // 7747 Madhup Narula // 9103 nitin
		camp[10][0]= "6"; // cyber park onsite
		camp[11][0]= "425000";//CTC
		camp[12][0]= "1"; // lvl of entry
		camp[13][0]= "25000"; // notice period buy out

 ///////////////////////////////////////////////////////////////////////////////////////////////////////	
		
	/*	selectOfferLetterMenu();
		Thread.sleep(1000);
		selectLastJobCode();
		Thread.sleep(1000);*/
		
		rad_Campus.click();
		Thread.sleep(5000);
		txt_fatherfirstname.clear();
		txt_fatherfirstname.sendKeys(camp[0][0]);
		txt_fahermidName.clear();
		txt_fahermidName.sendKeys(camp[1][0]);
		Thread.sleep(1000);
		txt_faherlastName.clear();
		txt_faherlastName.sendKeys(camp[2][0]);
		rad_Male.click();
		txt_address1.clear();
		txt_address1.sendKeys(camp[3][0]);
		txt_address2.clear();
		txt_address2.sendKeys(camp[4][0]);
		txt_city.clear();
		txt_city.sendKeys(camp[5][0]);
		txt_state.clear();
		txt_state.sendKeys(camp[6][0]);
		txt_pincode.clear();
		txt_pincode.sendKeys(camp[7][0]);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_subdepartment,camp[8][0]); // select CC_KT-1 (IND-STP-I)
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_groupmanger, camp[9][0]); // Madhup Narula; 10636">Atithi Ganjoo
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_facility, camp[10][0]);// Cyber park; 6 >Cyber Park-Onsite
		Thread.sleep(1000);
		txt_ctc.clear();
		txt_ctc.sendKeys(camp[11][0]);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_levelofentry, camp[12][0]);
	//	rad_Yesnoticeperiotbuyout.click();
	//	txt_noticeperiodbuyout.clear();
	//	txt_noticeperiodbuyout.sendKeys(camp[13][0]);
		try{
		btn_save.click();		
		} catch (Exception e)
		{System.out.println("something left blank");}
		
		Thread.sleep(6000);
		System.out.println(lbl_pf.getText());
		System.out.println(lbl_totalCTC.getText());
		bttn_submit.click();
		Thread.sleep(5000);
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		return;		
 	}

	public void searchcampuscandidate() throws InterruptedException, AWTException
	{
		//menu_offerletter.click();
				driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				//	wait= new WebDriverWait(driver,10);
				lnk_offerletterlist.click();
				DynamicWait.expwaitelmnttobeclickable(driver, 5, txt_offrltrname);		
				Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_entity, "9");//India - .Com-Gurgaon; 11">India - SEZ
				driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
				Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "1");//Regular
				Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ofracptedstatus, "10");//Extended; "11">OfferAccepted; "12">Joined; "13">Declined; "14">Revoked
				calanderDates();
				btn_submit.click();
				Thread.sleep(4000);
				System.out.println("\n");
				System.out.println("first job code in grid for campus candidate is" +grid_frstjobcode.getText());
				System.out.println("Name in grid for campus candidate is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
				System.out.println("first offer letter in grid for campus candidate is: " +grid_regoffrletrlink.getText());
				System.out.println("first emp agreement in grid for campus candidate is: " +grid_frstempaggrmnt.getText());
				System.out.println("first pre screening form in grid for campus candidate is: " +grid_frstprescrngform.getText());
				System.out.println("\n");
				grid_frstEditlink.click();
				DynamicWait.expwaitelmnttobeclickable(driver, 30, txt_fatherfirstname);
				System.out.println("title of page after click on edit: "+driver.getTitle());
			
	}
	
	public static void calanderDates() throws InterruptedException
	{
	DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    driver.findElement(By.id("strStartdate"));  
    driver.findElement(By.id("strStartdate")).click();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(2000);
    driver.findElement(By.id("strEnddate"));  
    driver.findElement(By.id("strEnddate")).click();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(2000);
   // wait= new WebDriverWait(driver,2);
    }
	
}
