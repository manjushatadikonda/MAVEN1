package Mavenprojects.MAVEN1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hoverme {
	WebDriver driver=null;
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("http://javaprogramls.s3-website-us-west-2.amazonaws.com");
	}
	@Test
	public void test1()
	{
		WebElement ele=driver.findElement(By.xpath("//h1[text()='Hover Me']"));
		
		System.out.println("Color:"+ele.getCssValue("background-color"));
		
		 Actions action = new Actions(driver); 
		 action.moveToElement(ele).build().perform(); 
		 System.out.println("Color1:"+ele.getCssValue("background-color"));
	}
}
