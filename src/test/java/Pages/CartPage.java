package Pages;

import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver=null;
CartPage(WebDriver driver)
{
	this.driver=driver;
}
public String getTitle() throws InterruptedException
{
	Thread.sleep(3000);
	return driver.getTitle();
}
}
