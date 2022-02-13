package Mavenprojects.MAVEN1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tester {
	WebDriver driver=null;
	public WebElement getShadowRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver)
		    .executeScript("return arguments[0].shadowRoot", element);
		        return ele;
		    }
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	        driver.get("https://selectorshub.com/xpath-practice-page/");
	        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	    }
	@Test
	public void clicktesterfood() throws InterruptedException
	{
		

		 JavascriptExecutor js = (JavascriptExecutor) driver;// Java Script to scroll the web page
			js.executeScript("window.scrollBy(0,700)");// scroll the window to 200 pixels
			Thread.sleep(5000);
	driver.switchTo().frame("pact");
	Thread.sleep(5000);
	WebElement root1 = driver.findElement(By.id("snacktime"));

	//Get shadow root element
	WebElement shadowRoot1 = getShadowRootElement(root1);
	WebElement shadowElement = shadowRoot1.findElement(By.partialLinkText("Tester"));
	//WebElement tester=driver.findElement(By.partialLinkText("Tester"));
	//shadowElement.click();
	//tester.click();*/
	//WebElement host = driver.findElement(By.id("snacktime"));
	//JavascriptExecutor js1 = (JavascriptExecutor)driver;
	//WebElement clickone=(WebElement)js.executeScript("arguments[0].shadowRoot.getElementByClassName('food').click()", host);
	String parent = driver.getWindowHandle();
	for(String handle : driver.getWindowHandles()){
	if(!handle.equals(parent))
	{
	   driver.switchTo().window(handle);
	   break;
	}
	}
	System.out.println(driver.getCurrentUrl());
	Assert.assertEquals(driver.getCurrentUrl(), "https://selectorshub.com/selectorshub-training/");
}
	@AfterClass
	public void classclose()
	{
		driver.quit();
	}
}
