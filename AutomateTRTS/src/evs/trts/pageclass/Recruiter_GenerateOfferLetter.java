package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Recruiter_GenerateOfferLetter {
	
	 static WebDriver driver;
	
	public Recruiter_GenerateOfferLetter (WebDriver odriver)
	{
		//super(driver);
		this.driver=odriver;
	}

	@FindBy(linkText="Offer Letter")
	WebElement menu_offerletter;
	
	@FindBy(xpath="//*[@id='offerLetterForm']/ul/li[4]/a")
	WebElement submenu_generateofferletter;
	
	@FindBy(xpath="//*[@id='JobRequestID']")
    WebElement drpdown_jobcode;
	
	@FindBy(xpath=".//*[@id='rdoEmpType-1']")
    WebElement rad_Regular;
	
	@FindBy(id="rdoEmpType-2")
	WebElement rad_ContractualEVS;
	
	@FindBy(id="rdoEmpType-3")
	WebElement rad_International;
	
	@FindBy(id="rdoEmpType-4")
	WebElement rad_Campus;
	
	@FindBy(id="rdoEmpType-5")
	WebElement rad_Interns;
	
	@FindBy(id="rdoEmpType-6")
	WebElement rad_InternalTransfr;
	
	@FindBy(id="strIAEmpCode")
	WebElement txt_jobcodeforinternaltransfer; // job code for internal transfer
	
	@FindBy(id="IASubmit")
	WebElement btn_okforinfr; // ok bttn for internal transfer	
	
	@FindBy(id="rdoEmpType-7")
	WebElement rad_ThirdpartyContractual;
	
	@FindBy(id="strOfferDate")
    WebElement calndr_offerdate;
	
	@FindBy(id="FatherFirstName")
    WebElement txt_fatherfirstname;
	
	@FindBy(id="FatherMiddleName")
    WebElement txt_fahermidName;
	
	@FindBy(id="FatherLastName")
    WebElement txt_faherlastName;
	
	@FindBy(xpath=".//*[@id='Gender'][@value='M']")
    WebElement rad_Male;
	
	@FindBy(xpath=".//*[@id='Gender'][@value='F']")
    WebElement rad_Female;
	
	@FindBy(xpath=".//*[@id='txtEditor1']")
    WebElement txt_address1;
	
	@FindBy(xpath=".//*[@id='txtEditor2']")
    WebElement txt_address2;
	
	@FindBy(id="Country")
    WebElement drpdwn_country;
	
	@FindBy(id="City")
    WebElement txt_city;
	
	@FindBy(id="State")
    WebElement txt_state;
	
	@FindBy(id="PinZip")
    WebElement txt_pincode;
	
	@FindBy(id="ContactNo")
    WebElement distxt_contact;
	
	@FindBy(id="EmailID")
    WebElement distxt_email;
	
	@FindBy(id="strJoiningDate")
    WebElement calnder_joiningdate;
	
	@FindBy(id="Location")
    WebElement disdropdwn_Entity;
	
	@FindBy(id="DepartmentId")
    WebElement dropdwn_department;
	
	@FindBy(id="SubDepartment")
    WebElement dropdwn_subdepartment;
	
	@FindBy(id="Designation")
    WebElement dropdwn_designation;
	
	@FindBy(id="GroupManager")
    WebElement dropdwn_groupmanger;
	
	@FindBy(id="ReportingManager")
    WebElement dropdwn_reportingmanger;
	
	@FindBy(id="ReasonId")
    WebElement disdropdwn_reason;
	
	@FindBy(id="Facility")
    WebElement dropdwn_facility;
	
	@FindBy(id="ShiftTiming")
    WebElement dropdwn_shifttiming;
	
	@FindBy(id="strReferredBy")
    WebElement txt_refferdby;
	
	@FindBy(id="ReferralAmount")
    WebElement txt_referrelamount;
	
	@FindBy(id="IsAnnual")
    WebElement rad_CTCyearly;
	
	@FindBy(xpath="//*[@id='IsAnnual'][@value='false']")
    WebElement rad_CTCmonthly;
	
	@FindBy(id="strCTC")
    WebElement txt_ctc;
		
	@FindBy(id="EmpCode")
    WebElement distxt_empcode;
		
	@FindBy(id="strOldEmp")
    WebElement txt_oldempid;
		
	@FindBy(id="AcceptanceStatus")
    WebElement disdrp_acceptancestatus;
	
	@FindBy(id="NoticePeriodEVS")
    WebElement drpdwn_noticeperiodEVS;
	
	@FindBy(id="JoiningBonus")
    WebElement txt_joiningbonus;
	
	@FindBy(id="strJoiningBonusToDate")
    WebElement calndr_joiningbonusmonth;
	
	@FindBy(id="JoiningBonusMonths")
    WebElement drpdwn_joiningbonusmonth;
	
	@FindBy(id="ORC")
    WebElement drpdwn_ORC;
	
	@FindBy(id="LevelOfEntry")
    WebElement drpdwn_levelofentry;
	
	@FindBy(id="CurrentOrganisation")
    WebElement distxt_currentorg;
	
	@FindBy(id="IsBondRequired")
    WebElement chk_bond;
	
	@FindBy(id="BondId")
    WebElement drpdwn_bond;
	
	@FindBy(id="RetentionBonus")
    WebElement txt_retentionbonus;
	
	@FindBy(id="SpecialBonus")
    WebElement txt_specialbonus;
	
	@FindBy(id="GMAndABoveBonus")
    WebElement drpdwn_GMandabovebonus;
	
	@FindBy(xpath=".//*[@id='IsRelocationExpenses'][@value='true']")
    WebElement rad_YesRelocationexpnse;
	
	@FindBy(id="RelocationExpense")
    WebElement txt_relocationexpnse;
	
	@FindBy(id="strTenureStartDate")
    WebElement calndr_tenureStartDate; // Contractual locator
	
	@FindBy(id="strTenureEndDate")
    WebElement calndr_tenureEndDate; // Contractual locator
		
	@FindBy(xpath=".//*[@id='IsNoticePeriodBuyOut'][@value='true']")
    WebElement rad_Yesnoticeperiotbuyout;
	
	@FindBy(id="NoticePeriodBuyOut")
    WebElement txt_noticeperiodbuyout;
	
	@FindBy(name="PfId")
    WebElement rad_MaxPF;
	
	@FindBy(xpath="(//input[@id='1'])[2]")
    WebElement rad_MinPF;
	
	@FindBy(id="Save")
    WebElement btn_save;
	
	@FindBy(id="Nationality")
    WebElement txt_nationality; // locator for internation analyst
	
	@FindBy(id="FaxNumber")
    WebElement txt_fax;   // locator for internation analyst
	
	@FindBy(id="VisaType")
    WebElement drpdwn_visatype; // locator for internation analyst
	
	@FindBy(id="VisaNumber")
    WebElement txt_visanumber; // locator for internation analyst
	
	@FindBy(id="PassportNumber")
    WebElement txt_passportnum; // locator for internation analyst
	
	@FindBy(id="strVisaValidFrom")
    WebElement calndr_visafrom;   // locator for internation analyst
	
	@FindBy(id="strVisaValidTo")
    WebElement calndr_visaTo;    // locator for internation analyst
	
	
	// locators on salary structure window	
	@FindBy(xpath=".//*[@id='salary-structure']/table[1]/tbody/tr[2]/td[2]")
    WebElement lbl_pf;
	
	@FindBy(xpath=".//*[@id='salary-structure']/table[2]/tbody/tr[4]/td[2]")
    WebElement lbl_convenyance;
	
	@FindBy(xpath=".//*[@id='salary-structure']/table[2]/tbody/tr[9]/td[3]")
    WebElement lbl_bonus;
	
	@FindBy(xpath=".//*[@id='salary-structure']/table[2]/tbody/tr[10]/td/table/tbody/tr/td[5]")
    WebElement lbl_totalCTC;
	
	@FindBy(xpath="//span[text()='Submit']")
    WebElement bttn_submit;
	
	@FindBy(xpath="html/body/div[5]/div[3]/div/button[2]")
    WebElement btn_cancel;
	
	@FindBy(xpath="//div[3]/div/button")
    WebElement btn_OK;
	
	// offer letter list locators
	
	@FindBy(linkText="Offer Letter List")
	WebElement lnk_offerletterlist;
	
	@FindBy(id="Entity")
	WebElement drpdwn_entity;
	
	@FindBy(id="EmpType")
	WebElement drpdwn_emptype;
	
	@FindBy(id="deptHorizontal")
	WebElement drpdwn_horizontal;
	
	@FindBy(id="OfferLetterName")
	WebElement txt_offrltrname;
	
	@FindBy(id="OfferAcceptanceStatus")
	WebElement drpdwn_ofracptedstatus;
	
	@FindBy(id="GeneratedBy")
	WebElement disable_offrgentdby;
	
	@FindBy(xpath="//input[@id='ToBeDecided'][@value='0']")
	WebElement rad_tobedecided;
	
	@FindBy(xpath="//input[@id='ToBeDecided'][@value='1']")
	WebElement rad_choose;

	@FindBy(id="strStartdate")
	WebElement calndr_startdate;
	
	@FindBy(id="strEnddate")
	WebElement calndr_enddate;
	
	@FindBy(id="btnSubmit")
	WebElement btn_submit;
	
	// locators in grid on offer letter list
	
	@FindBy(xpath="//tr[2]/td[6]")
	WebElement grid_frstjobcode; // first regular job code
	
	@FindBy(xpath="//tr[2]/td[7]")
	WebElement grid_frstNameincolumn; // first regular name
	
	@FindBy(xpath="//td[13]/a")
	WebElement grid_regoffrletrlink;
	
	@FindBy(xpath="//td[14]/a")
	WebElement grid_frstempaggrmnt;
	
	@FindBy(xpath="//td[15]/a")
	WebElement grid_frstprescrngform;
	
	@FindBy(linkText="Edit")
	WebElement grid_frstEditlink;

	
	public  void selectOfferLetterMenu() throws InterruptedException
	{
		
		menu_offerletter.click();
		Thread.sleep(2000);
	}
	public void selectLastJobCode() throws InterruptedException
	{
		/*Recruiter_UpdateCandidateInformation ruci= new Recruiter_UpdateCandidateInformation(driver);
		String jobcodeforofferletter=ruci.jobcodeonEdit;
		*/
		System.out.println("job code drop down found");
		driver.findElement(By.xpath(".//*[@id='JobRequestID']")).click();
		List<WebElement> options= driver.findElements(By.xpath(".//*[@id='JobRequestID']/option"));
		System.out.println("size of drop down is: "+options.size());
		System.out.println( "required job code is: "+options.get(options.size()-1).getText());
		System.out.println("size is taken");
		Select jc=new Select((WebElement) drpdown_jobcode);
		jc.selectByIndex(options.size()-1);
		Thread.sleep(2000);
		return;
				
	}
	
public void selectOptionWithIndex(int indexToSelect, WebElement ele, WebElement ele2) {
		
		try {
			WebElement autoOptions = driver.findElement((By) ele);
			WebDriverWait wait = new WebDriverWait(driver,3);
			//WebDriver wait=wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements((By) ele2);
		        if(indexToSelect<=optionsToSelect.size()) {
		        	System.out.println("Trying to select based on index: "+indexToSelect);
		           optionsToSelect.get(indexToSelect).click();
		        }
		} 		
		catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

public static void selectIndexwithRobot(int index) throws AWTException
{
	Robot rob= new Robot();
	rob.keyPress(KeyEvent.VK_DOWN);
	rob.keyRelease(KeyEvent.VK_DOWN);
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	
}

}

	
	

