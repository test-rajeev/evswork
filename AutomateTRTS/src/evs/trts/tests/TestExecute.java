package evs.trts.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import evs.trts.pageclass.AssignRequest_TAAdmin;
import evs.trts.pageclass.CreateRequest;
import evs.trts.pageclass.FPnA_Approval;
import evs.trts.pageclass.HRCompliance_RegularJoin;
import evs.trts.pageclass.HR_ReplcmntPreAppdMsubLoB;
import evs.trts.pageclass.HiringApprover;
import evs.trts.pageclass.LoginPage;
import evs.trts.pageclass.Logout;
import evs.trts.pageclass.OfferAcceptedandHRSSticket;
import evs.trts.pageclass.Recruiter_CampusOL;
import evs.trts.pageclass.Recruiter_ContractualEVSOL;
import evs.trts.pageclass.Recruiter_DeclinedOfferLetter;
import evs.trts.pageclass.Recruiter_GenerateOfferLetter;
import evs.trts.pageclass.Recruiter_InternOL;
import evs.trts.pageclass.Recruiter_InternalTransfer;
import evs.trts.pageclass.Recruiter_InternationalAnalystOL;
import evs.trts.pageclass.Recruiter_OfferLetterList;
import evs.trts.pageclass.Recruiter_RegularOL;
import evs.trts.pageclass.Recruiter_ThirdPartyContractual;
import evs.trts.pageclass.Recruiter_UpdateCandidateInformation;
import evs.trts.pageclass.Report_CandidateJoiningReport;
import evs.trts.pageclass.Role;
import evs.trts.pageclass.VerifyJobRequest_HiringRequester;
import helper.BrowserFactory;
import helper.DataBaseConnector;
import helper.DynamicWait;
import helper.SwithUser;

public class TestExecute  
{
	public static WebDriver driverobj;
	Logger logger;
	
	@BeforeTest
	public void startbrowser() throws InterruptedException
	{
	// this will launch browser with specific url. driver getting here will pass in each initElement.
	 driverobj = BrowserFactory.startBrowser("IE", "http://evs01tst05:8080/MRTS_UAT/");
	 logger=Logger.getLogger(TestExecute.class);
	//PropertyConfigurator.configure("Log4j.properties");
	}
	 
	@Test(priority=0)
	
	// code as per change request CRN_TRT-201606-001
	public void newrequestReplacementAndPreappvd() throws AWTException, InterruptedException 
	{
		LoginPage loginpg= PageFactory.initElements(driverobj, LoginPage.class);
		loginpg.login_trts(driverobj,"xxatithi.ganjoo", "a");
		
		Role role = PageFactory.initElements(driverobj, Role.class);
		role.selectroleashiringrequester();
		logger.info("hriring requester role  is selected");

		HR_ReplcmntPreAppdMsubLoB rplc= PageFactory.initElements(driverobj, HR_ReplcmntPreAppdMsubLoB.class);
		rplc.createRequestReplcAndPreapproved();
		Thread.sleep(4000);
		rplc.LogOut();
		
		// code to check '-M' sub lob for AVP
		/*		
		rplc.LogOut();
		Thread.sleep(2000);
		Robot robb= new Robot();
		robb.keyPress(KeyEvent.VK_F5);
		robb.keyRelease(KeyEvent.VK_F5);
		loginpg.login_trts(driverobj,"xxsheetal.ranganathan", "a"); // now login with sheetal rangnathan to check -M sub lob for AVP
		role.selectroleashiringrequester();
		rplc.createRequestReplcAndPreapproved();
	
		//-----------------------------
		
		*/
		
	}
	
	
 @Test(priority=1)	
	public void createJobRequest() throws InterruptedException, AWTException, IOException
	{
		LoginPage loginpg= PageFactory.initElements(driverobj, LoginPage.class);
		loginpg.login_trts(driverobj,"xxatithi.ganjoo", "a");
		
		
		 logger.info("hriring requester is login");
		
		Role role = PageFactory.initElements(driverobj, Role.class);
		role.selectroleashiringrequester();
		logger.info("hriring requester role  is selected");
		
		 
		CreateRequest createreq=PageFactory.initElements(driverobj, CreateRequest.class);
		createreq.createjobrequest();
		//logger.error("error is found");
		Thread.sleep(2000);
		createreq.verifyCreatedRequest();
		 
		ITestResult res= Reporter.getCurrentTestResult();
		System.out.println("reporter result is: "+ res.toString());		
		Thread.sleep(5000);
		
		 driverobj.findElement(By.xpath("//img[@alt='Logout']")).click(); /// click on logout 
		 Thread.sleep(1000);
		 driverobj.findElement(By.linkText("here")).click(); /// click on here link after logout
		 Thread.sleep(2000);
		
	}
	
	@Test(priority=2 ,  dependsOnMethods={"createJobRequest"})	
	public void verifyJobRequest() throws InterruptedException	
	{
		//setupforlogin(driverobj);
		CreateRequest createreq=PageFactory.initElements(driverobj, CreateRequest.class);
		VerifyJobRequest_HiringRequester verifyjobreq =PageFactory.initElements(driverobj, VerifyJobRequest_HiringRequester.class);
		verifyjobreq.verifyjobrequest(driverobj,createreq );
		Thread.sleep(2000);
	//	verifyjobreq.assertJobreq(driverobj,createreq); // error is coming to not find id= comment
		
		ITestResult res= Reporter.getCurrentTestResult();
		System.out.println("reporter result is: "+ res.toString());
		
		//Logout.logoutpage();
		
		 driverobj.findElement(By.xpath("//img[@alt='Logout']")).click(); /// click on logout 
		 Thread.sleep(1000);
		 driverobj.findElement(By.linkText("here")).click(); /// click on here link after logout
 		 Thread.sleep(2000);
		
	}
	
	@Test(priority=3)		
	public void approveRequestWithHiringApprover() throws InterruptedException, AWTException
	{
		SetupforLoggedUser setup = new SetupforLoggedUser(driverobj);
		setup.loginhiringapprover();
		
		HiringApprover hiringapprover= PageFactory.initElements(driverobj, HiringApprover.class);
		hiringapprover.approveRequest();
		//hiringapprover.multiapprove();  /// to click Submit button on landing page.
		driverobj.findElement(By.xpath("//img[@alt='Logout']")).click(); /// click on logout 
		Thread.sleep(1000);
	    driverobj.findElement(By.linkText("here")).click(); /// redirect to login page to ta admin user
		Thread.sleep(3000);

	}
	
	@Test(priority=4 ,  dependsOnMethods={"createJobRequest"})    //  ,  dependsOnMethods={"approveRequestWithHiringApprover"}
	public void approvewithFPnA() throws AWTException, InterruptedException
	{
		SetupforLoggedUser setup = new SetupforLoggedUser(driverobj);
		setup.loginForFPnA();
		
		FPnA_Approval fpna= PageFactory.initElements(driverobj, FPnA_Approval.class);
		
		 // --- to test refer back functionality
    	//	fpna.fpnaApprovalreferback();  
		
		fpna.approvedAndDwnldfromInside();
		fpna.verifyFpnAapproval(); 
	//	fpna.downloadRequestExcel();
		
		Thread.sleep(4000);
	}
	
	@Test(priority=5 , dependsOnMethods={"approvewithFPnA"})     /// , dependsOnMethods={"approvewithFPnA"}
	public void assignRequestWithTAadmin() throws InterruptedException, AWTException
	{	
	/*	SetupforLoggedUser setup = new SetupforLoggedUser(driverobj);
		setup.loginforadmin();*/
		
		SwithUser su= PageFactory.initElements(driverobj, SwithUser.class);
		su.selectTAAdminSwitch();
		
		AssignRequest_TAAdmin tadmin= PageFactory.initElements(driverobj, AssignRequest_TAAdmin.class);
		tadmin.assignToRecruiter();
		tadmin.verifyAssignedJobCode();
		Thread.sleep(2000);
		
	/*     driverobj.findElement(By.xpath("//img[@alt='Logout']")).click(); /// click on logout 
	     Thread.sleep(1000);
		 driverobj.findElement(By.linkText("here")).click(); /// redirect to login page of recruiter
		 Thread.sleep(2000);*/
			
	}
	
	@Test(priority=6  , dependsOnMethods={"assignRequestWithTAadmin"}) // , dependsOnMethods={"assignRequestWithTAadmin"}
	public void updateCandidateInformation() throws InterruptedException, AWTException
	{
		
		/*SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();
		*/
		
		
		
		SwithUser su= PageFactory.initElements(driverobj, SwithUser.class);
		su.selectRecruiterafterSwitch();		
		Thread.sleep(2000);	
		
		
		Recruiter_UpdateCandidateInformation rctr= PageFactory.initElements(driverobj, Recruiter_UpdateCandidateInformation.class);
		rctr.updateCandidateinfo();
		rctr.verifyUpdatedJobcode();
		rctr.verifyUploadedfiles();
	//	rctr.editCandidateInformation();
		rctr.clickOnGenerateLink(); // click on Generate link
		Thread.sleep(7000);
		
	}
	
	@Test(dataProvider="contractualEVS" ,dependsOnMethods={"updateCandidateInformation"} ) // ,dependsOnMethods={"updateCandidateInformation"}
	public void generateContractualEVSpayrollOL(String entity1, String emptype1) throws AWTException, InterruptedException, IOException
	{
		/*SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();*/
		
		Recruiter_ContractualEVSOL cevs= PageFactory.initElements(driverobj, Recruiter_ContractualEVSOL.class);
		
/*		// to select job code from drop down
		cevs.selectOfferLetterMenu();
		cevs.selectLastJobCode();
		*/
		
		cevs.clickonContractualRadiobtn(); // click on Contractual radio bttn
		cevs.contractualEVSpayrollOL();
	 	Thread.sleep(1000);
		cevs.searchContractualEVSemp(entity1, emptype1); // it will click on edit link to redirect on regular/intern ol at last
		Thread.sleep(5000);
				
	}
	 
	@Test(priority=8  , dependsOnMethods={"generateContractualEVSpayrollOL"} )   //  , dependsOnMethods={"generateContractualEVSpayrollOL"}
	public void generateThirdPartyContractualOL() throws InterruptedException, AWTException
	{
/*		SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();*/
		
	/*	Recruiter_ContractualEVSOL cevs1= PageFactory.initElements(driverobj, Recruiter_ContractualEVSOL.class);
		// to select job code from drop down
		cevs1.selectOfferLetterMenu();
		cevs1.selectLastJobCode();
		////-----------------------------------
*/		
		
		Recruiter_ThirdPartyContractual third = PageFactory.initElements(driverobj, Recruiter_ThirdPartyContractual.class);
		third.generateThirdPartyContractualOL();
		Thread.sleep(2000);
		third.searchContractualthird("9", "7"); // 7- contractual third party
		Thread.sleep(5000);
		
	}
	
	@Test(priority=9,dependsOnMethods={"generateThirdPartyContractualOL"} )
	public void generateInternsOL() throws InterruptedException
	{
		Recruiter_InternOL intrns= PageFactory.initElements(driverobj, Recruiter_InternOL.class);
		intrns.generateInternsOL(); // execution will start with click on Interns radio bttn
		intrns.searchInterns(); // it will click on edit link to redirect on ol page
		Thread.sleep(5000);
		
	}
	
	@Test(priority=10, dependsOnMethods={"generateInternsOL"})
	public void gnrateInternationalAnalystOL() throws InterruptedException
	{
		Recruiter_InternationalAnalystOL ia= PageFactory.initElements(driverobj, Recruiter_InternationalAnalystOL.class);
		ia.generateInternationalOL();
		Thread.sleep(2000);
		ia.searchInternational();// it will click on edit link to redirect on ol page
		Thread.sleep(2000);
		
	}
	
	@Test (priority=11  , dependsOnMethods={"gnrateInternationalAnalystOL"} )  // , dependsOnMethods={"gnrateInternationalAnalystOL"}
	public void generateCampusOL() throws InterruptedException, AWTException
	{
	/*	SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();*/
				
		Recruiter_CampusOL camp= PageFactory.initElements(driverobj, Recruiter_CampusOL.class);
		camp.generateCampusOL();
		Thread.sleep(2000);
		camp.searchcampuscandidate();
		Thread.sleep(5000);
	}
	
	@Test(priority=12  , dependsOnMethods={"generateCampusOL"}  ) // , dependsOnMethods={"generateCampusOL"}
	public void generateRegularOL() throws AWTException, InterruptedException
	{
		
		/*SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();
		*/
		Recruiter_RegularOL glo= PageFactory.initElements(driverobj, Recruiter_RegularOL.class);
		
	/*	glo.selectOfferLetterMenu();
		Thread.sleep(3000);
		glo.selectLastJobCode();
		Thread.sleep(5000);*/
		
		glo.generateRegularoffrltr(); // execution will start to click on Regular radio bttn
		glo.searchRegularOL();
		Thread.sleep(5000);	
		
		}
	
	
	@Test(priority=13 ,dependsOnMethods={"generateRegularOL"}) // ,dependsOnMethods={"generateRegularOL"}
	public void offerAcceptedandHRSSticket() throws InterruptedException, AWTException
	{
/*		SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();*/
		
		OfferAcceptedandHRSSticket hrss= PageFactory.initElements(driverobj, OfferAcceptedandHRSSticket.class);
		hrss.offerAcceptedandHRSSticketRaised();
		Thread.sleep(4000);
	}
	
	
	@Test(priority=14 ,dependsOnMethods={"offerAcceptedandHRSSticket"}) // ,dependsOnMethods={"offerAcceptedandHRSSticket"}
	public void generateInternalTransferOL() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
	{
	/*	SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();
		
		SwithUser su= PageFactory.initElements(driverobj, SwithUser.class);
		su.selectRecruiterafterSwitch();*/
		
		Recruiter_InternalTransfer intfr= PageFactory.initElements(driverobj, Recruiter_InternalTransfer.class);
		intfr.internalTransferOL();
		intfr.searchInternalTransfer("11", "1"); // SEZ, Regular
		Thread.sleep(4000);
	}
	
	@Test(priority=15 ,dependsOnMethods={"generateInternalTransferOL"}) //  ,dependsOnMethods={"generateInternalTransferOL"} - offerAcceptedandHRSSticket
	public void hrComplianaceJoiningAndMailsend() throws AWTException, InterruptedException
	{
	/*	SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();*/
		
		SwithUser swusr= PageFactory.initElements(driverobj, SwithUser.class);
		swusr.selectHRComplianceUser(); 
		
		HRCompliance_RegularJoin compl= PageFactory.initElements(driverobj, HRCompliance_RegularJoin.class);
		compl.joinRegularCandidate();
		compl.sentMailRegularCandidate();
	//	compl.joinContractualandInterns();
		Thread.sleep(6000);
				
	}
	@Test(priority=16 ,dependsOnMethods={"hrComplianaceJoiningAndMailsend"})
	public void reportCandidateJoiningReport() throws InterruptedException
	{
		SwithUser su= PageFactory.initElements(driverobj, SwithUser.class);
		su.selectTAAdminSwitch();
		
		Report_CandidateJoiningReport rptjoing= PageFactory.initElements(driverobj, Report_CandidateJoiningReport.class);
		rptjoing.offerLetterReport();
		Thread.sleep(4000);
		Thread.sleep(1000);
		
	}
	
	
	@AfterTest
	public void quitDriver() throws InterruptedException
	{		
	//	driverobj.findElement(By.xpath("//img[@alt='Logout']")).click(); /// click on logout 
	//	Thread.sleep(2000);	
		
		driverobj.findElement(By.xpath("//img[@alt='Logout']")).click(); /// click on logout 
		Thread.sleep(1000);
	    driverobj.findElement(By.linkText("here")).click(); /// redirect to login page to ta admin user
		Thread.sleep(2000);
		driverobj.close();
		driverobj.quit();
			
		System.out.println("\n");
		System.out.println("Tests have been executed");
		System.out.println("\n");
	}
	
	
	@Test(priority=17)
	public void dataBaseSentMailVerification() throws InterruptedException
	{
		DataBaseConnector db= PageFactory.initElements(driverobj, DataBaseConnector.class);
		//db.executeSQLQuery(sqlQuery);
		db.testVerifySpecificRecord();
		Thread.sleep(2000);
	}
	
	@Test(priority=18)
	public void declinedOfferLeter() throws AWTException, InterruptedException
	{
		
		SetupforLoggedUser rsetup = new SetupforLoggedUser(driverobj);
		rsetup.loginForRecruiter();
				
		Thread.sleep(4000);
		Recruiter_DeclinedOfferLetter decl= PageFactory.initElements(driverobj, Recruiter_DeclinedOfferLetter.class);
		decl.declinedofferletter();
	}
	
	
	@DataProvider
	public Object[][] contractualEVS()
	{
		// "contractualEVS" is the function name which is passing the data
	       // Number of columns should match the number of input parameters
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[1][2];
	// 1st row
	data[0][0] = "9";
	data[0][1] = "2";
	return data;
	
	}
	
}




