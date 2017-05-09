package evs.trts.pageclass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import helper.DynamicWait;

public class Recruiter_ThirdPartyContractual extends Recruiter_GenerateOfferLetter
{

	public Recruiter_ThirdPartyContractual(WebDriver odriver) 
	{
		super(odriver);
		
	}
	
	public void generateThirdPartyContractualOL() throws InterruptedException
	{
		String[][] tpc = new String[11][1];
		tpc[0][0] ="ThirdPartyF";
		tpc[1][0] ="3FathL";
		tpc[2][0] ="3FatherL";
		tpc[3][0] ="third add 1";
		tpc[4][0] ="third add2/-";
		tpc[5][0] ="Perumbudoor";
		tpc[6][0] ="Tamilnadu";
		tpc[7][0] ="887744";
		tpc[8][0] ="2035"; //sub dept
		tpc[9][0] ="9103"; // GM
		tpc[10][0] ="1"; //FACILITY
				
		String[][] tpcjd = new String[5][1];
		tpcjd[0][0]="45000"; //CTC per month
		tpcjd[1][0]="raj"; // referd by
		tpcjd[2][0]="6000"; // referral ammount
		tpcjd[3][0]="1"; // NOTICE PERIOD
		tpcjd[4][0]="1"; //Level of entry
		
		
		String[][] tpcmsc = new String[2][2];
		tpcmsc[0][0]="2000"; //retention bns
		tpcmsc[0][1]="1000"; // spcl bns
		tpcmsc[1][0]="7500"; //relocation expns
		tpcmsc[1][1]="2900"; //notice periot buy out
		
////////////////////////////////////////////////////////////////////////////////////
		
		rad_ThirdpartyContractual.click();
		Thread.sleep(5000);
		
		txt_fatherfirstname.clear();
		txt_fatherfirstname.sendKeys(tpc[0][0]);
		txt_fahermidName.clear();
		txt_fahermidName.sendKeys(tpc[1][0]);
		txt_faherlastName.clear();
		txt_faherlastName.sendKeys(tpc[2][0]);
		rad_Female.click();
		txt_address1.clear();
		txt_address1.sendKeys(tpc[3][0]);
		txt_address2.clear();
		txt_address2.sendKeys(tpc[4][0]);
		txt_city.clear();
		txt_city.sendKeys(tpc[5][0]);
		txt_state.clear();
		txt_state.sendKeys(tpc[6][0]);
		txt_pincode.clear();
		txt_pincode.sendKeys(tpc[7][0]);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_subdepartment,tpc[8][0]); // select CC_KT-1 (IND-STP-I)
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_groupmanger, tpc[9][0]); // Madhup Narula; 10636">Atithi Ganjoo
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_facility, tpc[10][0]);// Cyber park; 6 >Cyber Park-Onsite
		txt_ctc.clear();
		txt_ctc.sendKeys(tpcjd[0][0]);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_noticeperiodEVS, tpcjd[3][0]);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_levelofentry, tpcjd[4][0]);
		txt_retentionbonus.clear();
		txt_retentionbonus.sendKeys(tpcmsc[0][0]);
		txt_specialbonus.sendKeys("ghj");
		txt_specialbonus.clear();
		txt_specialbonus.sendKeys(tpcmsc[0][1]);
		
		rad_YesRelocationexpnse.click();
		txt_relocationexpnse.clear();
		txt_relocationexpnse.sendKeys(tpcmsc[1][0]);
	
		
		tenureforthirdparty();
		Thread.sleep(1000);
	/*	rad_Yesnoticeperiotbuyout.click();
		rad_Yesnoticeperiotbuyout.clear();
		rad_Yesnoticeperiotbuyout.sendKeys(tpcmsc[1][1]);
		Thread.sleep(1000);*/
		btn_save.click();
		Thread.sleep(7000);
		btn_OK.click();
		Thread.sleep(4000);
		return;
		
		
	}
	public static void tenureforthirdparty() throws InterruptedException
	{
		
    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    //find the calendar
    driver.findElement(By.id("strTenureStartDate"));  
    driver.findElement(By.id("strTenureStartDate")).click();
    //driver.findElement(By.id("strJoiningDate")).clear();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(2000);
    
    //fill tenure end date
    String FutureDate = "18-11-2017";		
   	String javaStringToSetDate = "var x=document.getElementsByName('strTenureEndDate');x[0].value=" + "'" + FutureDate + "';";
    ((JavascriptExecutor)driver).executeScript(javaStringToSetDate);
    
    }
	
	public void searchContractualthird(String entity, String emptype) throws InterruptedException
	{
	/*	menu_offerletter.click();
		Thread.sleep(3000);*/
		lnk_offerletterlist.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		DynamicWait.expwaitelmnttobeclickable(driver, 10, txt_offrltrname);		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_entity, entity);//India - .Com-Gurgaon; 11">India - SEZ
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, emptype);//Contractual EVS
		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ofracptedstatus, "10");//Extended; "11">OfferAccepted; "12">Joined; "13">Declined; "14">Revoked
		searchcalanderDatesforcontractthirdparty();
		btn_submit.click();
		Thread.sleep(4000);
		System.out.println("\n");
		System.out.println("first job code in grid for contractual 3rd party candidate is" +grid_frstjobcode.getText());
		System.out.println("Name in grid for contractual 3rd party candidate is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
		//System.out.println("first offer letter in grid for contractual 3rd party candidate is: " +grid_regoffrletrlink.getText());
		System.out.println("first pre screening form in grid for contractual 3rd party candidate is: " +grid_frstprescrngform.getText());
		System.out.println("\n");
		grid_frstEditlink.click();
		//System.out.println("title of page after click on edit: "+driver.getTitle());
		DynamicWait.expwaitelmnttobeclickable(driver, 30, txt_fatherfirstname);
		return;
		
		}
	public static void searchcalanderDatesforcontractthirdparty() throws InterruptedException
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
