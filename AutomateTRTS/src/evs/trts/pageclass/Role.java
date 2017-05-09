package evs.trts.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DynamicWait;

public class Role {
	
	WebDriver driver;
	
	public Role (WebDriver Idriver)
	{
		this.driver=Idriver;
	}

	// Hiring requester radio button
		
	@FindBy(xpath="//input[@name='Role'][@value='Manager'][@id='Role']") // for hiring requester
	//@CacheLookup
	WebElement radiobtn_requester;
	
	@FindBy(id="Select") 
//	@CacheLookup
	WebElement btn_submit;
	
	  @FindBy(xpath= "//div[@id='topNav']/div[2]/div/a/img") 
	  WebElement img_logout;
	  
	  @FindBy(xpath= "//tr[2]/td[2]/a")  //td[13]/a
	//  @CacheLookup
	  WebElement grid_firstjobcode;
	  
	  @FindBy(xpath= "//td[13]/a")  
	//  @CacheLookup
	  WebElement grid_firstview;
	  
	  
/*	  @FindBy(css="img[alt="Logout"]")
	  WebElement img_logout;*/
	  
		@FindBy(xpath="//input[@id='Role'][@value='GlobalOperationHead']") // role button for hiring approver user
		WebElement rad_hiringapprover;
	  
		@FindBy(xpath="//input[@id='Role'][@value='TAAdmin']")
		WebElement rad_taadmin;
		
		@FindBy(xpath="//input[@id='Role'][@value='Recruiter']")
		WebElement rad_recruiter;
		
		@FindBy(xpath="//input[@id='Role'][@value='HRCompliance']")
		WebElement rad_hrcompliance;
		
		@FindBy(xpath=".//*[@id='Role'][@value='FPAOperation']")
		WebElement rad_FPnA;
		
		@FindBy(xpath="//td/input")
		WebElement chkbx_firstingridforFPnA;
		
		
	public void selectroleashiringrequester() throws InterruptedException
	{
		if(radiobtn_requester.isSelected()==false)
		{
		radiobtn_requester.click();
		System.out.println("hiring requester role is selected");
		
		} 
			
		 else
		
		{System.out.println("hiring requester radio button not found");
		}
		
		btn_submit.click();
	//	DynamicWait.expwaitpresenceofelement(driver, 80, By.xpath("//tr[2]/td[2]"));
		DynamicWait.expwaitelmnttobeclickable(driver, 100, grid_firstview );
		Thread.sleep(5000);	
		return;
	}
	
	public void selectroleashiringapprover()
	{
		rad_hiringapprover.click();
		
		btn_submit.click();
	//	btn_submit.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 40, img_logout );
	}
	
	public void taadmin()
	{
		rad_taadmin.click();	
		btn_submit.click();
//		btn_submit.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 40, img_logout );
	}
	
	public void recruiter()
	{
		rad_recruiter.click();	
		btn_submit.click();
		//btn_submit.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 60, grid_firstview );
	}
	
	public void hrCompliance()
	{
		rad_hrcompliance.click();	
		btn_submit.click();
		//btn_submit.click();
		DynamicWait.expwaitelmnttobeclickable(driver, 40, img_logout );
	}
	
	public void fPnAuser() throws InterruptedException
	{
		 rad_FPnA.click();
		 btn_submit.click();
	//	 DynamicWait.expwaitelmnttobeclickable(driver, 150, chkbx_firstingridforFPnA);
		 		 
		 WebDriverWait wait= new WebDriverWait(driver,100);
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[13]/a")));
		// WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/input")));
	//	 element.click();
		 
		 System.out.println("\n");
		 System.out.println("FPnA role is login");
		
	}
}

