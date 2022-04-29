package PepperfryPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver=null;
    //@FindBy(how=How.LINK_TEXT,using="Add") WebElement Addelement;
   @FindBy(xpath="//input[@id='search']") WebElement searchinput;
   @FindBy(xpath="//input[@id='searchButton']") WebElement searchbutton;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	public ResultsPage savingdetails() throws InterruptedException
	{
		
		searchinput.sendKeys("furniture");
		Thread.sleep(3000);
		searchbutton.click();
		Thread.sleep(3000);
		return new ResultsPage(driver);
	}
}
