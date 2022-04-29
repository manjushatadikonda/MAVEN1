package southwestTests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import southwestPages.HomePage;
import southwestPages.SearchResultsPage;


import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase{
	//WebDriver driver=null;
	TestBase test=null;
	HomePage home=null;
	SearchResultsPage item=null;
	



@BeforeClass
public void testtitle()
{
	test=new TestBase();
	test.launchURL();
	home=PageFactory.initElements(driver, HomePage.class);
	Assert.assertEquals(home.getTitle(),"Southwest Airlines | Book Flights, Make Reservations & Plan a Trip");
	
}
@Test(priority=0)
public void departurecheck() throws InterruptedException
{
	
	Assert.assertFalse(home.getdeparture().isEmpty());

}

@Test(priority=1,retryAnalyzer=Retry.class)
public void clicksearchbutton() throws InterruptedException
{
	item= home.searchitem();
	Assert.assertEquals(item.getTitle(),"Southwest Airlines - Select Flights");

}
@AfterMethod
public void tearDown(ITestResult result)
{
 
if(ITestResult.FAILURE==result.getStatus())
{
try 
{
	takeSnapshot(driver,"C:\\Users\\saita\\Desktop\\Manju Workspace\\MAVEN1\\target\\test.png");
}
catch(Exception e)
{
	System.out.println(e);
}
}}
public static void takeSnapshot(WebDriver webdriver,String filepath) throws IOException
{
TakesScreenshot obj=(TakesScreenshot)webdriver;
File src= obj.getScreenshotAs(OutputType.FILE);
File des=new File(filepath);
FileUtils.copyFile(src,des);
System.out.println("this is file:" );
}
}
