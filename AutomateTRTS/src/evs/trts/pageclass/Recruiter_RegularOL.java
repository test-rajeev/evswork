package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DynamicWait;

public class Recruiter_RegularOL extends Recruiter_GenerateOfferLetter {
	

	public Recruiter_RegularOL(WebDriver odriver)
	{
		super(odriver);		
	}
	
	static WebDriverWait wait;

	public void generateRegularoffrltr() throws InterruptedException, AWTException
	{
		rad_Regular.click();
		Thread.sleep(7000);
		txt_fatherfirstname.clear();
		txt_fatherfirstname.sendKeys("regularFF");
		txt_fahermidName.clear();
		txt_fahermidName.sendKeys("regularFM");
		Thread.sleep(1000);
		txt_faherlastName.clear();
		txt_faherlastName.sendKeys("regularFL");
		rad_Male.click(); // select M
		Thread.sleep(2000);
		txt_address1.clear();
		txt_address1.sendKeys("add 1,/");
		txt_address2.clear();
		txt_address2.sendKeys("add 2 -");
		txt_city.clear();
		txt_city.sendKeys("Pune");
		txt_state.clear();
		txt_state.sendKeys("Maharastra");
		txt_pincode.clear();
		txt_pincode.sendKeys("110029");
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_subdepartment, "2035"); // select CC_KT-1 (IND-STP-I)
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_groupmanger, "9103"); // Madhup Narula; 10636">Atithi Ganjoo ; 9103 nitin
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_facility, "1");// Cyber park; 6 >Cyber Park-Onsite
		txt_refferdby.clear();
		txt_refferdby.sendKeys("raj");
		Thread.sleep(3000);
		//wait= new WebDriverWait(driver,5);
		selectIndexwithRobot(0);
		txt_referrelamount.clear();
		txt_referrelamount.sendKeys("2000");
	
		//selectOptionWithText(0,txt_refferdby,txt_refferdby);
		
		txt_ctc.clear();
		txt_ctc.sendKeys("600000");
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_noticeperiodEVS, "3");
		/*	calndr_joiningbonus
		txt_joiningbonus
		drpdwn_joiningbonusmonth*/
		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ORC, "1"); //NA; "4">Wells Fargo
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_levelofentry, "2");
				
		txt_retentionbonus.clear();
		txt_retentionbonus.sendKeys("5000");
		txt_specialbonus.sendKeys("ghj");
		txt_specialbonus.clear();
		txt_specialbonus.sendKeys("6000");
		
		rad_YesRelocationexpnse.click();
		txt_relocationexpnse.clear();
		txt_relocationexpnse.sendKeys("1000");
		rad_MaxPF.click();
		
		rad_Yesnoticeperiotbuyout.click();
		txt_noticeperiodbuyout.click();
		txt_noticeperiodbuyout.sendKeys("abc");
		txt_noticeperiodbuyout.clear();
		txt_noticeperiodbuyout.sendKeys("50000");
	
		btn_save.click();
		
		Thread.sleep(7000);
		System.out.println(lbl_pf.getText());
		System.out.println(lbl_totalCTC.getText());
		//Thread.sleep(2000);
		//btn_submit.click();
		
		bttn_submit.click();
		Thread.sleep(6000);
	/*	btn_OK.click();
		Thread.sleep(5000);*/
		
		
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		return;
		
	}
	
	public void searchRegularOL() throws InterruptedException, AWTException
	{
			//	menu_offerletter.click();
				driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				//	wait= new WebDriverWait(driver,10);
				lnk_offerletterlist.click();
				DynamicWait.expwaitelmnttobeclickable(driver, 20, txt_offrltrname);		
				Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_entity, "9");//India - .Com-Gurgaon; 11">India - SEZ
				driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
				Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, "1");//Regular
				Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ofracptedstatus, "10");//Extended; "11">OfferAccepted; "12">Joined; "13">Declined; "14">Revoked
				calanderDates();
				btn_submit.click();
				
			//	Thread.sleep(8000);
				DynamicWait.expwaitelmnttobeclickable(driver, 10, grid_frstEditlink);	
				
				System.out.println("\n");
				System.out.println("first job code in grid for regular candidate is" +grid_frstjobcode.getText());
				System.out.println("Name in grid for regular candidate is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
				System.out.println("first emp agreement in grid for regular candidate is: " +grid_frstempaggrmnt.getText());
				System.out.println("first pre screening form in grid for regular candidate is: " +grid_frstprescrngform.getText());
				System.out.println("first offer letter in grid for regular candidate is: " +grid_regoffrletrlink.getText());
				System.out.println("\n");
				Thread.sleep(1000);
				
				/*Thread.sleep(3000);
				grid_regoffrletrlink.click();
				Robot robt= new Robot();
				robt.keyPress(KeyEvent.VK_DOWN);
				robt.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(500);
				robt.keyPress(KeyEvent.VK_DOWN);
				robt.keyRelease(KeyEvent.VK_DOWN);
				robt.keyPress(KeyEvent.VK_ENTER);
				robt.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
			//	setClipboardDatatoSaveOL("C:\\TRTSautomationStuffs\\downloadedOfferLetters");
				setClipboardDatatoSaveOL("Regular_aggreement_letter1");
				Thread.sleep(2000);
				System.out.println("Regular offer letter downloaded");
				robt.keyPress(KeyEvent.VK_ENTER);
				robt.keyRelease(KeyEvent.VK_ENTER);
				robt.keyPress(KeyEvent.VK_ENTER);
				robt.keyRelease(KeyEvent.VK_ENTER);*/
				
				grid_frstEditlink.click();
				DynamicWait.expwaitelmnttobeclickable(driver, 35, txt_fatherfirstname);
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
				txt_ctc.sendKeys("725000");
				Thread.sleep(2000);
				rad_MinPF.click();
				Thread.sleep(1000);
				
				btn_save.click();
				Thread.sleep(6000);
				bttn_submit.click();
				Thread.sleep(4000);
			/*	btn_OK.click();
				Thread.sleep(5000);*/
				
				
				Robot robo= new Robot();
				robo.keyPress(KeyEvent.VK_ENTER);
				robo.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(5000);
				return;
			
			}
			
			public static void calanderDates() throws InterruptedException
			{
				
		    DateFormat dateFormat2 = new SimpleDateFormat("d"); // if current date is two digit then make here "dd" else for single make here "d"
		    Date date2 = new Date();

		    String today = dateFormat2.format(date2); 
		    //find the calendar and select start date
		    driver.findElement(By.id("strStartdate"));  
		    driver.findElement(By.id("strStartdate")).click();
		    driver.findElement(By.linkText(today)).click();
		    Thread.sleep(2000);
		   // wait= new WebDriverWait(driver,2);
		    //find the calendar and select end date
		    driver.findElement(By.id("strEnddate"));  
		    driver.findElement(By.id("strEnddate")).click();
		    driver.findElement(By.linkText(today)).click();
		    Thread.sleep(2000);
		   // wait= new WebDriverWait(driver,2);
		    }
			
			   public static void  setClipboardDatatoSaveOL(String str)
			   {		
				StringSelection ss = new StringSelection(str);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			   }
	}


