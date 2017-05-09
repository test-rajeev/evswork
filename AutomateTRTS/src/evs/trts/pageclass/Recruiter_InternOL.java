package evs.trts.pageclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import helper.DynamicWait;

public class Recruiter_InternOL extends Recruiter_GenerateOfferLetter
{

	public Recruiter_InternOL(WebDriver odriver)
	{
		super(odriver);
		
	}
	
	public void generateInternsOL() throws InterruptedException
	{
		String[][] iol = new String[5][1];
		iol[0][0]="internFatherF";
		iol[1][0]="internFatherM";
		iol[2][0]="internFatherL";
		iol[3][0]="address1";
		iol[4][0]="add23-";
		
		rad_Interns.click();
		Thread.sleep(5000);
		txt_fatherfirstname.clear();
		txt_fatherfirstname.sendKeys(iol[0][0]);
		txt_fahermidName.clear();
		txt_fahermidName.sendKeys(iol[1][0]);
		Thread.sleep(1000);
		txt_faherlastName.clear();
		txt_faherlastName.sendKeys(iol[2][0]);
		rad_Male.click();
		txt_address1.clear();
		txt_address1.sendKeys(iol[3][0]);
		txt_address2.clear();
		txt_address2.sendKeys(iol[4][0]);
		rad_MaxPF.click();
		
	    String FutureDate = "21-03-2017";		
	   	String javaStringToSetDate = "var x=document.getElementsByName('strTenureEndDate');x[0].value=" + "'" + FutureDate + "';";
	    ((JavascriptExecutor)driver).executeScript(javaStringToSetDate);
	    
		btn_save.click();
		Thread.sleep(4000);
		btn_OK.click();
		Thread.sleep(5000);
		return;	    
	}

	public void searchInterns() throws InterruptedException
	{
		lnk_offerletterlist.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		DynamicWait.expwaitelmnttobeclickable(driver, 5, txt_offrltrname);		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_entity, "9");//India - .Com-Gurgaon; 11">India - SEZ
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "2");//"1">Regular; "2">Contractual; "3">International Analyst; "7">Contractual Third Party
		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ofracptedstatus, "10");//Extended; "11">OfferAccepted; "12">Joined; "13">Declined; "14">Revoked
		Recruiter_ContractualEVSOL.calanderDatesforcontract();
		btn_submit.click();
		Thread.sleep(4000);
		System.out.println("\n");
		System.out.println("first job code in grid for interns candidate is" +grid_frstjobcode.getText());
		System.out.println("Name in grid for interns candidate is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
		System.out.println("first offer letter in grid for interns candidate is: " +grid_regoffrletrlink.getText());
		System.out.println("first pre screening form in grid for interns candidate is: " +grid_frstprescrngform.getText());
		System.out.println("\n");
		grid_frstEditlink.click();
		//System.out.println("title of page after click on edit: "+driver.getTitle());
		DynamicWait.expwaitelmnttobeclickable(driver, 30, txt_fatherfirstname);
		return;
	}
}
