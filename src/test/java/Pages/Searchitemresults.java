package Pages;

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
    @FindAll
	({
		@FindBy(className="_4rR01T"),
	})List<WebElement> list1;
	@FindBy(xpath="//div[text()='realme Narzo 50i (Mint Green, 32 GB)']") WebElement mobile;
public Searchitemresults(WebDriver driver)
{
	this.driver=driver;
}
public String getTitle() throws InterruptedException
{
	Thread.sleep(3000);
	return driver.getTitle();
}

public MobilePage selectitem() throws InterruptedException 
{
	System.out.println("hi");
  //  wait=new WebDriverWait(driver,20);
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_4rR01T']")));
 // list1= driver.findElements(By.xpath("//div[@class='_4rR01T']"));
//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(list1));

int n= list1.size();
System.out.println(n);
    for(int i=0; i<n; i++)
    {
    	String s1= list1.get(i).getText();
    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='realme Narzo 50i (Mint Green, 32 GB)']")));
    	System.out.println(s1);
    	String s2="realme Narzo 50i (Mint Green, 32 GB)"; 
    	
    	if(s1.contains(s2))
    	{
    		
    		//driver.findElement(By.xpath("//div[text()='realme Narzo 50i (Mint Green, 32 GB)']")).click();
    		mobile.click();
    		Thread.sleep(5000);
    		
    	for(String handle : driver.getWindowHandles())
    		{
    		driver.switchTo().window(handle);
    		}
    		//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
    		break;
    	
    	}
    	
    	
    	
    }
  
    return new MobilePage(driver);
	
}
}
