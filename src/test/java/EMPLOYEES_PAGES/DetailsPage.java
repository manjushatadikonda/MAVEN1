package EMPLOYEES_PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage {
	WebDriver driver=null;
	@FindBy(xpath="//a[text()='Home']") WebElement homebutton;
	@FindBy(xpath="/html/body/div/div/div/div/h5") WebElement checkname;
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/div[2]/div[1]/div") WebElement checklocation;
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/div[2]/div[2]/div") WebElement checkjobtitle;
	@FindBy(xpath="//span[@class='badge badge-primary']") WebElement checkcheckbox;
	@FindBy(xpath="//a[text()='Edit']") WebElement editbutton;
public DetailsPage(WebDriver driver)
{
	this.driver=driver;
}
public String editbutton()
{
	
	return driver.getPageSource();
}
public String getURL()
{
	return driver.getCurrentUrl();
}
public String getname()
{
	return checkname.getText();
}
public String getlocation()
{
	return checklocation.getText();
}
public String getjtitle()
{
	return checkjobtitle.getText();
}
public String getcheckbox()
{
	return checkcheckbox.getText();
}

}
