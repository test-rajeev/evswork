package evs.trts.pageclass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Report_CandidateJoiningReport 
{
	static WebDriver driver;
		
		public Report_CandidateJoiningReport (WebDriver odriver)
		{
			this.driver=odriver;
		}
		
		
/*	@FindBy(xpath=".//*[@id='topNav']/div[1]/ul/li[7]/a") 
	WebElement menu_Report;*/
	
	@FindBy(linkText="Report")   //
	WebElement menu_Report;
	
	@FindBy(linkText="Offer Letter Report")
	WebElement submenu_OfferLetterReport;
	
	@FindBy(id="strFromDate")
	WebElement calndr_fromdate;
	
	@FindBy(id="strToDate")
	WebElement calndr_todate;
	
	@FindBy(id="JoiningStatus")
	WebElement drpdwn_joiningstatus;
	
	@FindBy(xpath=".//*[@id='1']/td[3]")
	WebElement grid_firstname;
	
	@FindBy(xpath=".//*[@id='1']/td[4]")
	WebElement grid_firstEmpCode;
	
	@FindBy(xpath=".//*[@id='1']/td[6]")
	WebElement grid_firstOfferleterDate;
		
	@FindBy(id="btnGenerate")
	WebElement btn_generate;
	
	
	public void offerLetterReport() throws InterruptedException
	{
		menu_Report.click();
		Thread.sleep(5000);
		submenu_OfferLetterReport.click();
		Thread.sleep(1000);
		calanderDatesforofferletterReport();
	    Thread.sleep(1000);
	    btn_generate.click();
	    Thread.sleep(3000);
	    String empname= grid_firstname.getText();
	    System.out.println("Employee name in candidate joining Report: "+ empname);
	    String empcode= grid_firstEmpCode.getText();
	    System.out.println("Employee code in candidate joining Report: "+ empcode);
	    String oldate= grid_firstOfferleterDate.getText();
	    System.out.println("Offer letter date for the employee:" +empname+ " is: " +  oldate);
	    
	}
	
	public static void calanderDatesforofferletterReport() throws InterruptedException
	{
		
    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    //find the calendar and select start date
    driver.findElement(By.id("strFromDate"));  
    driver.findElement(By.id("strFromDate")).click();
    driver.findElement(By.linkText(today)).click();
    Thread.sleep(2000);
 
    driver.findElement(By.id("strToDate"));  
    driver.findElement(By.id("strToDate")).click();
    driver.findElement(By.linkText(today)).click();
    }
	
	
}
