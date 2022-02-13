package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.Searchitemresults;



public class HomePageTest extends TestBase
{
	//WebDriver driver=null;
	TestBase test=null;
	HomePage home=null;
	Searchitemresults item=null;
	



@BeforeClass
public void testtitle()
{
	test=new TestBase();
	test.launchURL();
	home=PageFactory.initElements(driver, HomePage.class);
	Assert.assertEquals(home.getTitle(),"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	
}
@Test(priority=0)
public void clicksearchbutton() throws InterruptedException
{
	item= home.searchitem();
	Assert.assertEquals(item.getTitle(),"Realme Mobiles- Buy Products Online at Best Price in India - All Categories | Flipkart.com");

}

}
