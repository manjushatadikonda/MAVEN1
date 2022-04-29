package EMPLOYEES_TESTS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EMPLOYEES_PAGES.AddPage;
import EMPLOYEES_PAGES.HomePage;



public class HomePageTest extends TestBase {
	TestBase test=null;
	HomePage home=null;
	AddPage add=null;
	
@BeforeClass
public void testtitle()
{
	test=new TestBase();
	test.launchURL();
	home=PageFactory.initElements(driver, HomePage.class);
	Assert.assertEquals(home.getURL(),"http://52.42.108.52/");
	
}
@Test(priority=0)
public void departurecheck() throws InterruptedException
{
	add=home.savingdetails();
	Assert.assertEquals(add.getURL(),"http://52.42.108.52/add");

}


}
