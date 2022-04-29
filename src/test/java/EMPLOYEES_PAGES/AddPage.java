package EMPLOYEES_PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPage {
	WebDriver driver=null;
	@FindBy(xpath="//input[@id='full_name']") WebElement fullname;
	@FindBy(xpath="//input[@id='location']") WebElement location;
	@FindBy(xpath="//input[@id='job_title']") WebElement jobtitle;
	@FindBy(xpath="//input[@id='apple']") WebElement usercheckbox;
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/form/div/div[2]/div[17]/div/input") WebElement savebutton;
public AddPage(WebDriver driver)
{
	this.driver=driver;
}
public String getURL()
{
	return driver.getCurrentUrl();
}

public HomeWithSavedDetailsPage clicksave(String empname,String emplocation,String empjob)
{
	fullname.sendKeys(empname);
	location.sendKeys(emplocation);
	jobtitle.sendKeys(empjob);
	usercheckbox.click();
	savebutton.click();
	
	return new HomeWithSavedDetailsPage(driver);
}
}
