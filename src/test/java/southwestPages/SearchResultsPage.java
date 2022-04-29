package southwestPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	WebDriver driver=null;
	WebDriverWait wait=null;
  
public SearchResultsPage(WebDriver driver)
{
	this.driver=driver;
}
public String getTitle() throws InterruptedException
{
	Thread.sleep(3000);
	return driver.getTitle();
}
}
