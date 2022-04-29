package PepperfryPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ResultsPage {
	WebDriver driver=null;
    //@FindBy(how=How.LINK_TEXT,using="Add") WebElement Addelement;
   @FindBy(xpath="//h2[@class='clipCard__ttl marginBottom8']//a") List<WebElement> list;
	public ResultsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	public List<WebElement> check()
	{
		return list;
	}

}
