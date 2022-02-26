package gamestoppacktest;



import org.testng.annotations.Test;

import gamestoppack.HomePage;
import gamestoppack.Searchitemresults;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




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
	Assert.assertEquals(home.getTitle(),"Consoles, Collectibles, Video Games, and More – Buy, Sell or Trade | GameStop");
	
}
@Test(priority=0)
public void clicksearchbutton() throws InterruptedException
{
	item= home.searchitem();
	Assert.assertEquals(item.getTitle(),"xbox controller | Search Results | GameStop");

}

}
