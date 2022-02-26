package gamestoppack;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Searchitemresults  {
	WebDriver driver=null;
	WebDriverWait wait=null;
	@FindBy(xpath="//a[@href='/gaming-accessories/controllers/xbox-one/products/microsoft-xbox-elite-black-series-2-wireless-controller/202695.html']") WebElement item;
	
public Searchitemresults(WebDriver driver)
{
	this.driver=driver;
}
public String getTitle() throws InterruptedException
{
	Thread.sleep(3000);
	return driver.getTitle();
}

public Itempage selectitem() throws InterruptedException 
{
	System.out.println("hi");
	Thread.sleep(5000);
    item.click();
    Thread.sleep(5000);
    return new Itempage(driver);
	
}
}
