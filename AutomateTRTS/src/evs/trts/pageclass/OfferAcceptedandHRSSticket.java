package evs.trts.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OfferAcceptedandHRSSticket extends Recruiter_UpdateCandidateInformation{

	public OfferAcceptedandHRSSticket(WebDriver rdriver) 
	{
		super(rdriver);
		
	}
	
	public void offerAcceptedandHRSSticketRaised() throws InterruptedException, AWTException
	{
		menu_updatecandidateinfn.click();
		Thread.sleep(3000);
		firstEditlinkingrid_uci.click();
		Thread.sleep(3000);
		Select acc=new Select(drpdwn_status);
		acc.selectByValue("11"); //// offer accepted
		
		btn_HRSSRequest.click();
		Thread.sleep(4000);
		
		Robot hrss = new Robot();
		hrss.keyPress(KeyEvent.VK_ENTER);
		hrss.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		hrss.keyPress(KeyEvent.VK_ENTER);
		hrss.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		
		btn_update.click();
		//Thread.sleep(2000);
		
		boolean noalert = true;
				while (noalert)
				{
				try{	
					
					Alert alert = driver.switchTo().alert();
					noalert= false;
					String alertmsg= alert.getText();
					System.out.println("alert found and message shown is:"+alertmsg); // o/p: Request Submitted successfully
					alert.accept();	
					}   catch (NoAlertPresentException e){ } 
				}
				
		hrss.keyPress(KeyEvent.VK_ENTER);
		hrss.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return;
		
	}
}
