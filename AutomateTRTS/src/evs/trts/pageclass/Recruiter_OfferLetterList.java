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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DynamicWait;

public class Recruiter_OfferLetterList extends Recruiter_GenerateOfferLetter {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public Recruiter_OfferLetterList(WebDriver driver)
	{		
		super(driver);
		
	}
	
	public void regular_OfferLetterList(WebDriver driver) throws InterruptedException, AWTException
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
		System.out.println("first job code in grid for regular candidate is" +grid_frstjobcode.getText());
		System.out.println("Name in grid for regular candidate is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
		System.out.println("first offer letter in grid for regular candidate is: " +grid_regoffrletrlink.getText());
		System.out.println("first emp agreement in grid for regular candidate is: " +grid_frstempaggrmnt.getText());
		System.out.println("first pre screening form in grid for regular candidate is: " +grid_frstprescrngform.getText());
		grid_frstEditlink.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 10, txt_fatherfirstname);
		System.out.println("title of page after click on edit: "+driver.getTitle());
		//Recruiter_GenerateOfferLetter rg= new Recruiter_GenerateOfferLetter(driver);
	/*	Recruiter_RegularOL ro= new Recruiter_RegularOL(driver);
		ro.txt_ctc.clear();
		ro.txt_ctc.clear();
		ro.txt_ctc.sendKeys("700000");
		ro.btn_save.click();
		Thread.sleep(3000);
		ro.bttn_submit.click();*/
		
		txt_ctc.clear();
		txt_ctc.sendKeys("700000");
		Thread.sleep(2000);
		btn_save.click();
		Thread.sleep(8000);
		bttn_submit.click();
		Thread.sleep(3000);
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}
	
	public static void calanderDates()
	{
		
    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    //find the calendar and select start date
    driver.findElement(By.id("strStartdate"));  
    driver.findElement(By.id("strStartdate")).click();
    driver.findElement(By.linkText(today)).click();
    wait= new WebDriverWait(driver,2);
    //find the calendar and select end date
    driver.findElement(By.id("strEnddate"));  
    driver.findElement(By.id("strEnddate")).click();
    driver.findElement(By.linkText(today)).click();
    wait= new WebDriverWait(driver,2);
    }
	
	
	
}
