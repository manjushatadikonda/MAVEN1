package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.MobilePage;
import Pages.Searchitemresults;



public class SearchitemresultsTest extends TestBase{

	
	 MobilePage mobobj=null;
	    
	   Searchitemresults searchobj=null; 
		
		
	@Test(priority=0)
	public void validateitem() throws InterruptedException
	{
		
		searchobj=PageFactory.initElements(driver, Searchitemresults.class);
		mobobj=searchobj.selectitem();
		Assert.assertEquals(mobobj.getTitle(),"realme Narzo 50i ( 32 GB Storage, 2 GB RAM ) Online at Best Price On Flipkart.com");
	}
}
