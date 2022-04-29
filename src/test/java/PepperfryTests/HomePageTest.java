package PepperfryTests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PepperfryPages.HomePage;
import PepperfryPages.ResultsPage;
import PepperfryPages.TestBase;

public class HomePageTest extends TestBase{
TestBase test=null;
HomePage home=null;
ResultsPage res=null;
@Test(priority=0)
public void test1()
{
	test=PageFactory.initElements(driver, TestBase.class);
	//test.initializedriver();
	test.launchURL();
}
@Test
public void test2() throws InterruptedException
{
	home=PageFactory.initElements(driver, HomePage.class);
	res=home.savingdetails();
  
}
}
