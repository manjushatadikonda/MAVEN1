package WeatherAppPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class HomePage {
	WebDriver driver=null;
    //@FindBy(how=How.LINK_TEXT,using="Add") WebElement Addelement;
   @FindBy(xpath="/html/body/section[1]/div/form/input") WebElement city;
   @FindBy(xpath="//button[text()='SUBMIT']") WebElement submit;
   @FindBy(xpath="/html/body/section[2]/div/ul/li/h2/span") List<WebElement> list1;
   @FindBy(xpath="/html/body/section[1]/div/form/span") WebElement msg;
   @FindBy(xpath="/html/body") WebElement body;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getcolor()
	{
		return body.getCssValue("color");
	}
	public String savingdetails(String cityname) throws InterruptedException
	{
		String cityname1="";
		city.sendKeys(cityname);
		
		submit.click();
		Thread.sleep(3000);
		if(msg.getText().isEmpty())
		{
			for(int i=0;i<list1.size();i++)
			{
				if(list1.get(i).getText().contains(cityname))
					cityname1=list1.get(i).getText();
			
			}
			return cityname1;
		}
		else
		return msg.getText();
	}
}
