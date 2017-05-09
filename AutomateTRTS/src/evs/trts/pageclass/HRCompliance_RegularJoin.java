package evs.trts.pageclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HRCompliance_RegularJoin
{
	WebDriver driver;
	
	public HRCompliance_RegularJoin(WebDriver sdriver)
	{
		this.driver=sdriver;
	}

	@FindBy(id="EmpType")
	WebElement drpdwn_emptype;
	
	@FindBy(id="EntityDisplayName")
	WebElement drpdwn_facility;
		
	@FindBy(id="JoiningStatus")
	WebElement drpdwn_joiningstatus;
	
	@FindBy(xpath=".//*[@id='ToBeDecided'][@value='1']")
	WebElement rad_choosejoiningdate;
	
	@FindBy(id="strStartdate")
	WebElement calndr_startdate;
	
	@FindBy(id="strEnddate")
	WebElement calndr_enddate;
	
	@FindBy(id="btnSubmit")
	WebElement btn_submit;
	
	//grid locators
	@FindBy(id="cb_jqDashboardTable")
	WebElement chk_masterchkbox;
	
	@FindBy(xpath="//tr[2]/td/input")
	WebElement chk_firstchkbox;
	
	@FindBy(xpath="//tr[2]/td[6]")
	WebElement lbl_firstjobcode;
	
	@FindBy(xpath="//tr[2]/td[7]")
	WebElement lbl_name;
	
	@FindBy(xpath="//tr[2]/td[12]")
	WebElement lbl_joiningdate;
	
	@FindBy(id="btnGenEmpCode")
	WebElement btn_genempcode;
	
	@FindBy(id="btnSendMail")
	WebElement btn_sendmail;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement btn_afterjoiningandsendmailbothOK;
	
	public void joinRegularCandidate() throws InterruptedException
	{	
	Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "1");// "2">Contractual; "3">International Analyst; "7">Contractual Third Party
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_facility, ".Com");
	Thread.sleep(1000);
	Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_joiningstatus, "1"); // Not Joined
	btn_submit.click();
	Thread.sleep(5000);
	chk_masterchkbox.click();
	//chk_firstchkbox.click();
	System.out.println("HR Compliance: Candidate job code and name is: "+lbl_firstjobcode.getText() +": " +lbl_name.getText() );
	System.out.println("HR Compliance: Candidate joining date is: "+lbl_joiningdate.getText());
	btn_genempcode.click(); // emp code generate bttn
	Thread.sleep(5000);
	btn_afterjoiningandsendmailbothOK.click();
	System.out.println("emp code is generated for Regualr candidate");
	Thread.sleep(3000);

	}
	
	public void sentMailRegularCandidate() throws InterruptedException
	{
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "1");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_facility, ".Com");
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_joiningstatus, "2"); //Joined
		btn_submit.click();
		Thread.sleep(5000);	
		chk_masterchkbox.click();
		Thread.sleep(1000);
		btn_sendmail.click(); // send mail bttn
		Thread.sleep(5000);
		btn_afterjoiningandsendmailbothOK.click();
		System.out.println("mail is sent for Regualr candidate");
		System.out.println("\n");
		
	}

 	public void joinContractualandInterns() throws InterruptedException
 	{
 		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "2");// "2">Contractual; "3">International Analyst; "7">Contractual Third Party
 		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_facility, ".Com");
 		Thread.sleep(1000);
 		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_joiningstatus, "1");
 		btn_submit.click();
 		chk_firstchkbox.click();
 		System.out.println("HR Compliance:Contractual: Candidate job code and name is: "+lbl_firstjobcode.getText() +": " +lbl_name.getText() );
 		System.out.println("HR Compliance:Contractual:Candidate joining date is: "+lbl_joiningdate.getText());
 		btn_genempcode.click();
 		Thread.sleep(3000);
 		btn_afterjoiningandsendmailbothOK.click();
 		System.out.println("Mail sent for Contractual/interns candidate");
 		
	}
	
}
