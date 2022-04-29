package EMPLOYEES_PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {
	WebDriver driver=null;
    //@FindBy(how=How.LINK_TEXT,using="Add") WebElement Addelement;
   @FindBy(xpath="//a[text()='Add']") WebElement Addbutton;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	public AddPage savingdetails() throws InterruptedException
	{
		
		Addbutton.click();
		Thread.sleep(3000);
		return new AddPage(driver);
	}
}
