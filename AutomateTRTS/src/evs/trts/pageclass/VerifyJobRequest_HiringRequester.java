package evs.trts.pageclass;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.eclipse.jetty.http.HttpTester.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import helper.DynamicWait;

public class VerifyJobRequest_HiringRequester {
	
public static final String[] Session = null;

static WebDriver driver;
	
//String jobcode=null;

	public VerifyJobRequest_HiringRequester(WebDriver edriver)
	{		
		this.driver=edriver;
		
	}
	
	@FindBy(xpath="//tr[2]/td[2]") // xpath position of first job request
	@CacheLookup
	WebElement firstJobingrid;
	
	@FindBy(xpath="//tr[2]/td[12]/a") // xpath position of first edit link
	@CacheLookup
	WebElement firstEditlink;
	
@FindBy(id="Comment")
@CacheLookup
WebElement commentforjob;
	

	public void verifyjobrequest(WebDriver driver, CreateRequest createreq) throws InterruptedException
	{
		String pagetitle= driver.getTitle();
		System.out.println("page title after create request is:"+pagetitle);
	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String jobcode= firstJobingrid.getText();
		//Session["abc"]=jobcode;
		System.out.println("\n");
		System.out.println("first job code in grid is: "+ jobcode);
		System.out.println("\n");
		try{
		firstEditlink.click(); } catch (Exception e) {System.out.println("time out after click");}
		Thread.sleep(15000);
		System.out.println("edit button is clicked");
		
		return;
	}
	
	public void assertJobreq(WebDriver driver,CreateRequest createreq) 
	{
	    String textcmnt= createreq.txt_comment.getText();
		System.out.println("comment text is:"+ textcmnt);
		if(textcmnt.equals("testcomment"))
		{
		System.out.println("job request is verified sucessfully");
		} else {
		System.out.println("job request in wrong");
		}	
		return;
	}
}
