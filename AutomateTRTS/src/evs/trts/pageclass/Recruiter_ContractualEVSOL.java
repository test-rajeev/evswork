package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import helper.DynamicWait;

public class Recruiter_ContractualEVSOL extends Recruiter_GenerateOfferLetter
{
	public Recruiter_ContractualEVSOL(WebDriver odriver) 
	{
		super(odriver);
		
	}


	public void clickonContractualRadiobtn() throws InterruptedException
	{
		rad_ContractualEVS.click();
		Thread.sleep(5000);
	}
	public void contractualEVSpayrollOL() throws AWTException, InterruptedException
	{
		String[][] personaldetail = new String[11][1];
		personaldetail[0][0] ="ContrEVSF";
		personaldetail[1][0] ="confathMid";
		personaldetail[2][0] ="confathLast";
		personaldetail[3][0] ="add1/";
		personaldetail[4][0] ="add2/-";
		personaldetail[5][0] ="Ooty";
		personaldetail[6][0] ="Kerala";
		personaldetail[7][0] ="445520";
		personaldetail[8][0] ="2035"; //sub dept
		personaldetail[9][0] ="9103"; // GM 9103 -nitin //  7747- madhup
		personaldetail[10][0] ="1"; //FACILITY
				
		String[][] jd = new String[5][1];
		jd[0][0]="75000"; //CTC per month
		jd[1][0]="raj";
		jd[2][0]="6000"; // referral ammount
		jd[3][0]="1"; // NOTICE PERIOD
		jd[4][0]="1"; //Level of entry
		
		String[][] msc = new String[2][2];
		msc[0][0]="5000"; //retention bns
		msc[0][1]="2000"; // spcl bns
		msc[1][0]="8000"; //relocation expns
		msc[1][1]="40000"; //notice periot buy out
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		txt_fatherfirstname.clear();
		txt_fatherfirstname.sendKeys(personaldetail[0][0]);
		txt_fahermidName.clear();
		txt_fahermidName.sendKeys(personaldetail[1][0]);
		txt_faherlastName.clear();
		txt_faherlastName.sendKeys(personaldetail[2][0]);
		rad_Female.click();
		txt_address1.clear();
		txt_address1.sendKeys(personaldetail[3][0]);
		txt_address2.clear();
		txt_address2.sendKeys(personaldetail[4][0]);
		txt_city.clear();
		txt_city.sendKeys(personaldetail[5][0]);
		txt_state.clear();
		txt_state.sendKeys(personaldetail[6][0]);
		txt_pincode.clear();
		txt_pincode.sendKeys(personaldetail[7][0]);
		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_subdepartment,personaldetail[8][0]); // select CC_KT-1 (IND-STP-I)
		Thread.sleep(2000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_groupmanger, personaldetail[9][0]); // Madhup Narula; 10636">Atithi Ganjoo
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_facility, personaldetail[10][0]);// Cyber park; 6 >Cyber Park-Onsite
		txt_ctc.clear();
		txt_ctc.sendKeys(jd[0][0]);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_noticeperiodEVS, jd[3][0]);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_levelofentry, jd[4][0]);
		
		txt_retentionbonus.clear();
		txt_retentionbonus.sendKeys(msc[0][0]);
		txt_specialbonus.sendKeys("ghj");
		txt_specialbonus.clear();
		txt_specialbonus.sendKeys(msc[0][1]);
		
		rad_YesRelocationexpnse.click();
		txt_relocationexpnse.clear();
		txt_relocationexpnse.sendKeys(msc[1][0]);
		
		calanderdatepick();
		Thread.sleep(1000);
		//calanderdatepick(calndr_tenureStartDate, calndr_tenureEndDate);
		
		rad_Yesnoticeperiotbuyout.click();
		txt_noticeperiodbuyout.clear();
		txt_noticeperiodbuyout.sendKeys("abc");
		txt_noticeperiodbuyout.clear();
		txt_noticeperiodbuyout.sendKeys(msc[1][1]);
	
		btn_save.click();
		Thread.sleep(5000);
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		// btn_OK.click();
		Thread.sleep(4000);
		
		/*Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);*/
		return;
				
	}
	
	public static void calanderdatepick() throws InterruptedException
	{
		
    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    //find the calendar
    driver.findElement(By.id("strTenureStartDate"));  
    driver.findElement(By.id("strTenureStartDate")).click();
    Thread.sleep(1000);
    //driver.findElement(By.id("strJoiningDate")).clear();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(2000);
    
    //fill tenure end date
    String FutureDate = "15-06-2017";		
   	String javaStringToSetDate = "var x=document.getElementsByName('strTenureEndDate');x[0].value=" + "'" + FutureDate + "';";
    ((JavascriptExecutor)driver).executeScript(javaStringToSetDate);
    
    }
	
	public void searchContractualEVSemp(String entity, String emptype) throws InterruptedException, IOException
	{
		/*menu_offerletter.click();
		Thread.sleep(3000);*/
		
		lnk_offerletterlist.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		DynamicWait.expwaitelmnttobeclickable(driver, 20, txt_offrltrname);		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_entity, entity);//India - .Com-Gurgaon; 11">India - SEZ
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, emptype);//Contractual EVS
		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ofracptedstatus, "10");//Extended; "11">OfferAccepted; "12">Joined; "13">Declined; "14">Revoked
		calanderDatesforcontract();
		btn_submit.click();
		Thread.sleep(7000);
		System.out.println("\n");
		System.out.println("first job code in grid for contractual EVS candidate is" +grid_frstjobcode.getText());
		System.out.println("Name in grid for contractual EVS candidate is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
		System.out.println("first offer letter in grid for contractual EVS candidate is: " +grid_regoffrletrlink.getText());
		System.out.println("first pre screening form in grid for contractual EVS candidate is: " +grid_frstprescrngform.getText());
		System.out.println("\n");
		/*grid_regoffrletrlink.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\AutoITdownloadexes\\tests.exe"); // use of auto it  exe
		Thread.sleep(6000);*/
		grid_frstEditlink.click();
		//System.out.println("title of page after click on edit: "+driver.getTitle());
		DynamicWait.expwaitelmnttobeclickable(driver, 30, txt_fatherfirstname);
		return;
		
		}
	
	public static void calanderDatesforcontract() throws InterruptedException
	{
		
    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    //find the calendar and select start date
    driver.findElement(By.id("strStartdate"));  
    driver.findElement(By.id("strStartdate")).click();
    driver.findElement(By.linkText(today)).click();
   Thread.sleep(1000);
    //find the calendar and select end date
    driver.findElement(By.id("strEnddate"));  
    driver.findElement(By.id("strEnddate")).click();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(1000);
    }
	
}


