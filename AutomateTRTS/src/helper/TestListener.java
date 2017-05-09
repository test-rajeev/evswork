package helper;
//package com.pack.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import helper.BrowserFactory;
import evs.trts.tests.TestExecute;


public class TestListener implements ITestListener {
	WebDriver driver=null;
	
	 String filePath = "./failed-screenshots/";
	//String filePath = "C:\\failedcases\\"; 
    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName);
    }
    
    public void takeScreenShot(String methodName) {
    	//get the driver
    	driver=TestExecute.driverobj;
    //	driver=BrowserFactory.driver;
    	//driver=TestBase.getDriver();
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
			//	FileUtils.copyFile(scrFile, new File(filePath+methodName+"_abc"+".png"));
				FileUtils.copyFile(scrFile, new File(filePath+methodName+"_"+adddate()+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	private  String adddate() 
	{
	    Date today = Calendar.getInstance().getTime();
	    
	 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");    // create a date "formatter" (the date format we want)
	    String folderName = formatter.format(today);    // create a new String using the date format we want 
	   
	    // this prints "Folder Name = 2009-09-06-08.23.23"
	    // System.out.println("Folder Name = " + folderName);
		return folderName;
	    
/*		Date date= new Date();
		return date.toString();*/
		
	}

	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
} 