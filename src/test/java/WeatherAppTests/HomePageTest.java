package WeatherAppTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import WeatherAppPages.HomePage;
import weatherappresorces.weatherappreader;


public class HomePageTest extends TestBase{
	TestBase test=null;
	HomePage home=null;
	String filepath="C:\\Users\\saita\\Desktop\\Manju Workspace\\MAVEN1\\src\\test\\java\\weatherappresorces\\weatherapp.xlsx";
	weatherappreader reader=new weatherappreader();
@BeforeClass
public void testtitle()
{
	test=new TestBase();
	test.launchURL();
	home=PageFactory.initElements(driver, HomePage.class);
	
}
@Test(dataProvider="sampledata")
public void check(String input, String output) throws InterruptedException
{
String message=home.savingdetails(input);
Assert.assertEquals(message,output);
	
}
@Test
public void test1()
{
	Assert.assertEquals(home.getcolor(),"rgb(0,0,255)");
}
@DataProvider
public Object[][] sampledata()
{
	 Object[][] data=reader.getExcelData(filepath);
	 
	return data;
}

}
