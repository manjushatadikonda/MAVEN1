package EMPLOYEES_TESTS;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import EMPLOYEES_PAGES.AddPage;
import EMPLOYEES_PAGES.DetailsPage;
import EMPLOYEES_PAGES.HomeWithSavedDetailsPage;

public class HomeWithSavedDetailsPageTest extends TestBase {
HomeWithSavedDetailsPage saveobj=null;
DetailsPage detailsobj=null;
@Test(priority=0)
public void departurecheck() throws InterruptedException
{
	saveobj=PageFactory.initElements(driver, HomeWithSavedDetailsPage.class);
	Assert.assertEquals(saveobj.getAlerttext(),"Saved!");
}
@Test(priority=1)
public void checkurl() throws InterruptedException
{
	detailsobj=saveobj.clickondetails();
	Thread.sleep(5000);
	Assert.assertTrue(detailsobj.editbutton().contains("Edit"));
}
}
