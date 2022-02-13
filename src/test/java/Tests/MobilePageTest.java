package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.MobilePage;

public class MobilePageTest extends TestBase{

	 MobilePage mobobj1=null;
	    
	   CartPage cartobj=null;
		
		
	@Test(priority=0)
	public void validatecart() throws InterruptedException
	{
		
		mobobj1=PageFactory.initElements(driver, MobilePage.class);
		cartobj=mobobj1.addtocart();
		Assert.assertEquals(cartobj.getTitle(),"Shopping Cart | Flipkart.com");
		
	}
}
