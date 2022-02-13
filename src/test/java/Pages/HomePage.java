package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {
	WebDriver driver=null;
    @FindBy(how=How.CLASS_NAME,using="_3704LK") WebElement search;
   @FindBy(xpath="//button[contains(@class,'_2KpZ6l')]") WebElement closebutton;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public Searchitemresults searchitem() throws InterruptedException
	{
		//driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l')]")).click();
		//WebElement search=driver.findElement(By.className("_3704LK"));
		closebutton.click();
		search.sendKeys("Realme Mobiles"+"\n");
		Thread.sleep(3000);
		return new Searchitemresults(driver);
	}
}
