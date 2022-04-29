package EMPLOYEES_TESTS;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import EMPLOYEES_PAGES.DetailsPage;

public class DetailsPageTest extends TestBase{
DetailsPage detobj=null;
@Test
public void test1()
{
	detobj=PageFactory.initElements(driver,DetailsPage.class);
	Assert.assertTrue(detobj.getname().contains("Manju"));
	Assert.assertEquals(detobj.getlocation(),"MN");
	Assert.assertEquals(detobj.getjtitle(),"QA");
	Assert.assertEquals(detobj.getcheckbox(),"Mac User");
	
}
}
