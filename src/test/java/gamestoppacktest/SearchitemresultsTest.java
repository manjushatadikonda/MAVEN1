package gamestoppacktest;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import gamestoppack.Itempage;
import gamestoppack.Searchitemresults;



public class SearchitemresultsTest extends TestBase{

	
	 Itempage mobobj=null;
	    
	   Searchitemresults searchobj=null; 
		
		
	@Test(priority=0)
	public void validateitem() throws InterruptedException
	{
		
		searchobj=PageFactory.initElements(driver, Searchitemresults.class);
		mobobj=searchobj.selectitem();
		Assert.assertEquals(mobobj.getTitle(),"Microsoft Xbox Elite Wireless Controller Series 2 for Xbox One | GameStop");
	}
}
