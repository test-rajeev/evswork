package evs.trts.pageclass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import helper.DynamicWait;

public class Recruiter_InternationalAnalystOL extends Recruiter_GenerateOfferLetter 
{

	public Recruiter_InternationalAnalystOL(WebDriver odriver) 
	{
		super(odriver);
	
	}
	
	public void generateInternationalOL() throws InterruptedException
	{
		String[][] ia = new String[8][1];
		ia[0][0]="IntlFF";
		ia[1][0]="IntlFM";
		ia[2][0]="IntlFL";
		ia[3][0]="INTL ADD1";
		ia[4][0]="Intl add 2-/";
		ia[5][0]="Russian";
		ia[6][0]="PASS01PRT";
		ia[7][0]="150000";
		
		rad_International.click();
		Thread.sleep(5000);
		txt_fatherfirstname.clear();
		txt_fatherfirstname.sendKeys(ia[0][0]);
		txt_fahermidName.clear();
		txt_fahermidName.sendKeys(ia[1][0]);
		txt_faherlastName.clear();
		txt_faherlastName.sendKeys(ia[2][0]);
		rad_Male.click();
		txt_address1.clear();
		txt_address1.sendKeys(ia[3][0]);
		txt_address2.clear();
		txt_address2.sendKeys(ia[4][0]);
		txt_ctc.clear();
		txt_ctc.sendKeys(ia[7][0]);
		rad_MaxPF.click();
		
	    String FutureDate = "11-10-2017";		 // tenure end date
	   	String javaStringToSetDate = "var x=document.getElementsByName('strTenureEndDate');x[0].value=" + "'" + FutureDate + "';";
	    ((JavascriptExecutor)driver).executeScript(javaStringToSetDate);
	    
		txt_nationality.sendKeys(ia[5][0]);
		txt_passportnum.sendKeys(ia[6][0]);
		calanderForVisa(); // visa period
	    
		btn_save.click();
		Thread.sleep(4000);
		btn_OK.click();
		Thread.sleep(6000);
		return;	

	}
	
	public static void calanderForVisa() throws InterruptedException
	{
		
    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    //find the calendar and select start date
    driver.findElement(By.id("strVisaValidFrom"));  
    driver.findElement(By.id("strVisaValidFrom")).click();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(2000);
    
    String FutureDate = "11-10-2025";		
   	String javaStringToSetDate = "var x=document.getElementsByName('strVisaValidTo');x[0].value=" + "'" + FutureDate + "';";
    ((JavascriptExecutor)driver).executeScript(javaStringToSetDate);
    
 
    }
	
	public void searchInternational() throws InterruptedException
	{
		lnk_offerletterlist.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		DynamicWait.expwaitelmnttobeclickable(driver, 5, txt_offrltrname);		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_entity, "9");//India - .Com-Gurgaon; 11">India - SEZ
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "2");//2:Contractual/Intern
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ofracptedstatus, "10");//Extended; "11">OfferAccepted; "12">Joined; "13">Declined; "14">Revoked
		calanderDatesforcontract();
		btn_submit.click();
		Thread.sleep(3000);
		System.out.println("contractual is not found");
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "3");//3:International Analyst; 7">Contractual Third Party
		btn_submit.click();		
		Thread.sleep(3000);
		System.out.println("\n");
		System.out.println("first job code in grid for international analyst is" +grid_frstjobcode.getText());
		System.out.println("Name in grid for international analyst is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
		System.out.println("first offer letter in grid for international analyst is: " +grid_regoffrletrlink.getText());
		System.out.println("first pre screening form in grid for international analyst is: " +grid_frstprescrngform.getText());
		System.out.println("\n");
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
