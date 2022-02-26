package gamestoppacktest;


import org.testng.annotations.Test;

import gamestoppack.CartPage;
import gamestoppack.Itempage;

import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ItempageTest extends TestBase{

	 Itempage mobobj1=null;
	    
	   CartPage cartobj=null;
		
		
	@Test(priority=0)
	public void validatecart() throws InterruptedException
	{
		
		mobobj1=PageFactory.initElements(driver, Itempage.class);
		cartobj=mobobj1.addtocart();
		Assert.assertEquals(cartobj.getTitle(),"Cart | GameStop");
		
	}
}
