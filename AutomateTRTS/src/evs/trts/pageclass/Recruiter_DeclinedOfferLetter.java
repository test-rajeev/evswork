package evs.trts.pageclass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Recruiter_DeclinedOfferLetter  {
		
	 static  WebDriver driver;
	  
	   public Recruiter_DeclinedOfferLetter(WebDriver sdriver) 
	   {
			this.driver=sdriver;
	   }
	   
		@FindBy(linkText="Update Candidate Information")
		WebElement menu_updatecandidateinfn;
		
		
	   public void declinedofferletter() throws InterruptedException
	   {
		   
		   menu_updatecandidateinfn.click();
		   Thread.sleep(4000);
		   getColumnValues(4);
		   
	   }
	   
	    public List<WebElement> getColumnValues(int colIndex)
	    {
	    	 
	    	//WebElement colElement;
	    	//List<WebElement> colValues = driver.findElements(By.cssSelector("#gbox_UpdateCandidateinfoTable>tr>th:nth-child("+colIndex+")"));
	    	List<WebElement> colValues = driver.findElements(By.xpath(".//*[@id='gbox_UpdateCandidateinfoTable']"));
	    	int tblsixe= colValues.size();
	    	for (int i=0; i<tblsixe; i++)
	    	{
	    		System.out.println("values:" + colValues.get(i).getText().toString());
	    	}
	    		  	    	
	    	return colValues;
	   
	    	
		}

}
