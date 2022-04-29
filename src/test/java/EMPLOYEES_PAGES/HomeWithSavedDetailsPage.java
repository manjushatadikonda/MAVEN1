package EMPLOYEES_PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeWithSavedDetailsPage {
	WebDriver driver=null;
	@FindBy(xpath="//button[text()='ADD TO CART']") WebElement cartadd;
	@FindBy(xpath="/html/body/div/div/div/div[1]") WebElement savealert;
	@FindBy(xpath="//a[text()='Manjusha']") WebElement details;
public HomeWithSavedDetailsPage(WebDriver driver)
{
	this.driver=driver;
}
public String getURL()
{
	return driver.getCurrentUrl();
}
public String getAlerttext()
{
	return savealert.getText();
}
public DetailsPage clickondetails()
{
	details.click();
	return new DetailsPage(driver);
}
}
