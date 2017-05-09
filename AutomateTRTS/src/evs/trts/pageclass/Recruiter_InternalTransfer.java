package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.DynamicWait;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;


public class Recruiter_InternalTransfer extends Recruiter_GenerateOfferLetter 
{

	public Recruiter_InternalTransfer(WebDriver odriver) 
	{
		super(odriver);
	
	}

	public void internalTransferOL() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, AWTException
	{
		menu_offerletter.click();
		Thread.sleep(5000);
		rad_InternalTransfr.click();
		Thread.sleep(9000);
	
		String[][] it = new String[5][3];
		it[0][0]= "ama"; // Sar; Kin
		it[1][0]= "11"; //Entity drop dwn 11 is SEZ
		it[2][0]= "222"; //dept: CaPS-01 (SEZ); "214">CAPS-03 (SEZ)
		it[3][0]= "1902"; //SubDepartment:CaPS-01-1 (SEZ) ; 1903">CaPS-03-1 (SEZ)
		it[4][0]= "290"; //design: Assistant Compliance Officer
		it[0][1]= "10173"; //GM  : Aashish Bhandari(IND-9398)
		it[1][1]= "14450"; //RM : Abhijeet Sinha(IND-12843)
		it[2][1]= "5"; //facility: SEZ; "8">SEZ-Onsite
		it[3][1]= "4"; //shift timing : 09:00:00 - 06:00:00
		it[0][2]= "800000"; // CTC
		it[1][2]= "5000"; // retention bns
		it[2][2]= "524"; // spcl bns
		
		txt_jobcodeforinternaltransfer.clear();
		txt_jobcodeforinternaltransfer.sendKeys(it[0][0]);
		Thread.sleep(3000);
		selectIndexwithRobot(1);
		btn_okforinfr.click();
		Thread.sleep(5000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(disdropdwn_Entity, it[1][0]);
		Thread.sleep(3000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_department, it[2][0]);
		Thread.sleep(3000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_subdepartment, it[3][0]);
		Thread.sleep(2000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_designation, it[4][0]);
		Thread.sleep(2000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_groupmanger, it[0][1]);
		Thread.sleep(2000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_reportingmanger, it[1][1]);
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_facility, it[2][1]);
		txt_ctc.clear();
		txt_ctc.sendKeys(it[0][2]);
		Thread.sleep(1000);
		txt_retentionbonus.clear();
		txt_retentionbonus.sendKeys(it[1][2]);
		Thread.sleep(1000);
		txt_specialbonus.clear();
		txt_specialbonus.sendKeys(it[2][2]);
		
		btn_save.click();
		Thread.sleep(4000);
		System.out.println(lbl_pf.getText());
		System.out.println(lbl_totalCTC.getText());
		bttn_submit.click();
		Thread.sleep(3000);
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		return;
		
		
		/*excelred();
		txt_jobcodeforinternaltransfer.sendKeys();
		String empname=excelRead(1,1);
		txt_jobcodeforinternaltransfer.sendKeys(empname);
		Thread.sleep(2000);
		selectIndexwithRobot(1);
		btn_okforinfr.click();		
		String ctc= excelRead(2,1);
		txt_ctc.sendKeys(ctc);
		String rbns= excelRead(3,1);
		txt_retentionbonus.sendKeys(rbns);		
		String sbns= excelRead(4,1);
		txt_specialbonus.sendKeys(sbns);		
		String enty= excelRead(5,1); //SEZ
		String dept= excelRead(6,1); //CAPS-03 (SEZ)
		String sbdept= excelRead(7,1); 
		//String desig= excelRead(8,1); 
		String desigAVP= excelRead(8,3); 
		String gm= excelRead(9,1); 
		String rm= excelRead(10,1); 
		String facil= excelRead(11,1); 
		String gmbns= excelRead(12,1); 		
		txt_jobcodeforinternaltransfer.sendKeys(empname);
		Thread.sleep(2000);
		selectIndexwithRobot(1);
		btn_okforinfr.click();
		Thread.sleep(5000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(disdropdwn_Entity, enty);
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_department, dept); //CAPS-03 (SEZ)
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_subdepartment, sbdept);
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_designation, desigAVP);
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_groupmanger, gm);
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_reportingmanger, rm);
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(dropdwn_facility, facil);
		Thread.sleep(1000);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_GMandabovebonus, gmbns);
		*/
	}
	
	public void searchInternalTransfer(String entity, String emptype) throws InterruptedException
	{
	/*	menu_offerletter.click();
		Thread.sleep(3000);*/
		lnk_offerletterlist.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		DynamicWait.expwaitelmnttobeclickable(driver, 5, txt_offrltrname);		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_entity, entity);//India - .Com-Gurgaon; 11">India - SEZ
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_emptype, emptype);//internal transfer
		
		Recruiter_UpdateCandidateInformation.selectvaluefromdrpdwn(drpdwn_ofracptedstatus, "11");//Extended; "11">OfferAccepted; "12">Joined; "13">Declined; "14">Revoked
		calanderDatesforinternaltransfer();
		btn_submit.click();
		Thread.sleep(3000);
		System.out.println("\n");
		System.out.println("first job code in grid for internal analyst candidate is" +grid_frstjobcode.getText());
		System.out.println("Name in grid for internal analyst candidate is: " +grid_frstjobcode.getText()+": " +grid_frstNameincolumn.getText());
		System.out.println("first offer letter in grid for internal analyst candidate is: " +grid_regoffrletrlink.getText());
		System.out.println("first agreement letter for internal transfer is: "+grid_frstempaggrmnt.getText());
		System.out.println("\n");
		//System.out.println("first pre screening form in grid for internal analyst candidate is: " +grid_frstprescrngform.getText());
		grid_frstEditlink.click();
		//System.out.println("title of page after click on edit: "+driver.getTitle());
		DynamicWait.expwaitelmnttobeclickable(driver, 10, txt_ctc);
		return;
		
		}
	
	public static void calanderDatesforinternaltransfer() throws InterruptedException
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
	
	
	
	
		public static void excelred() throws IOException
		{
			File src=new File("C:\\TRTSautomationStuffs\\TestData.xlsx");
			FileInputStream fis= new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet wsh=wb.getSheetAt(0);

			for(int i=0;i<=wsh.getLastRowNum();i++)
			{
				for (int j=0;j<wsh.getColumnOutlineLevel(i+1);j++)
				{System.out.println(wsh.getRow(i).getCell(j).getStringCellValue());}
			}
		}
			
			
			
}