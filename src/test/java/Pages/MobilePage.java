package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePage {
	
	WebDriver driver=null;
	@FindBy(xpath="//button[text()='ADD TO CART']") WebElement cartadd;
public MobilePage(WebDriver driver)
{
	this.driver=driver;
}
public String getTitle()
{
	return driver.getTitle();
}
public CartPage addtocart()
{
	//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	cartadd.click();
	return new CartPage(driver);
}
}
