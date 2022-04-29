package EMPLOYEES_TESTS;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import EMPLOYEES_PAGES.AddPage;
import EMPLOYEES_PAGES.HomeWithSavedDetailsPage;
import resources.employeejsonreader;



public class AddPageTest extends TestBase
{
AddPage addobj=null;
HomeWithSavedDetailsPage homeobj=null;
employeejsonreader empreader=new employeejsonreader();

@Test(priority=0)
public void departurecheck() throws InterruptedException, ParseException
{
	addobj=PageFactory.initElements(driver, AddPage.class);
	HashMap<String,String> hMap=empreader.employeeJsondata();
	homeobj=addobj.clicksave(hMap.get("Name"),hMap.get("location"),hMap.get("jobTitle"));
	Assert.assertEquals(homeobj.getURL(),"http://52.42.108.52/");

}
}
