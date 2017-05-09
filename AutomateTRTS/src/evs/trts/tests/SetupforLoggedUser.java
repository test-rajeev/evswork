package evs.trts.tests;
import evs.trts.pageclass.*;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import evs.trts.pageclass.LoginPage;
import evs.trts.pageclass.Role;
import helper.DynamicWait;

public class SetupforLoggedUser {
	
	WebDriver driver;
	
	public SetupforLoggedUser(WebDriver edriver)
	{
		this.driver=edriver;
	}
	
	public void loginhiringapprover() throws AWTException, InterruptedException
	{
		
	LoginPage loginpg= PageFactory.initElements(driver, LoginPage.class);
	loginpg.login_trts(driver,"madhup.narula", "a");
		

	Role role = PageFactory.initElements(driver, Role.class);
	role.selectroleashiringapprover();
	System.out.println("hiring approver role is selected");
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void loginforadmin() throws AWTException, InterruptedException
	{
		LoginPage loginpg= PageFactory.initElements(driver, LoginPage.class);
		loginpg.login_trts(driver,"xxdebasis.nandi", "a");
		
		Role role = PageFactory.initElements(driver, Role.class);
		role.taadmin();
		System.out.println("TA admin role is selected");
		Thread.sleep(10000);
		return;
	}
	
	public void loginForRecruiter() throws AWTException, InterruptedException
	{
		LoginPage loginpg= PageFactory.initElements(driver, LoginPage.class);
		loginpg.login_trts(driver,"xxdebasis.nandi", "a");
		
		Role role = PageFactory.initElements(driver, Role.class);
		role.recruiter();
		
		System.out.println("Recruiter role is selected");
		
		}
	
	public void loginForHRCompliace() throws AWTException, InterruptedException
	{
		LoginPage loginpg= PageFactory.initElements(driver, LoginPage.class);
		loginpg.login_trts(driver,"xxdebasis.nandi", "a");
		
		Role role = PageFactory.initElements(driver, Role.class);
		role.hrCompliance();
		
		System.out.println("HR Compliace role is selected");
		
		try {
			Thread.sleep(10000); //5000
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loginForFPnA() throws AWTException, InterruptedException
	{
		LoginPage loginpg= PageFactory.initElements(driver, LoginPage.class);
		loginpg.login_trts(driver,"xxdebasis.nandi", "a");
		
		Thread.sleep(1000);
		Role role = PageFactory.initElements(driver, Role.class);
		role.fPnAuser();
		 Thread.sleep(3000);
		
	}
	
}
