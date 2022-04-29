package Mavenprojects.MAVEN1;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class tester {
	WebDriver driver=null;
	WebDriverWait wait=new WebDriverWait()
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html");
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	/*@Test
	public void clicktesterfood() throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,700)");
	driver.switchTo().frame("pact");
	WebElement host = driver.findElement(By.id("snacktime"));
	SearchContext root=  (SearchContext) js.executeScript("return arguments[0].shadowRoot", host);
   WebElement tester=root.findElement(By.partialLinkText("Tester"));
   System.out.println(driver.getCurrentUrl());
   String parent = driver.getWindowHandle();
   js.executeScript("arguments[0].click();", tester);
   
	for(String handle : driver.getWindowHandles()){
	if(!handle.equals(parent))
	{
	   driver.switchTo().window(handle);
	   break;
	}
	}
	Assert.assertEquals(driver.getCurrentUrl(), "https://selectorshub.com/selectorshub-training/");
}*/
	@Test
    public void testqueryandsubmit()
    {
       Boolean condition1= driver.findElement(By.id("search-input")).isDisplayed();
       // Boolean condition1=query.isDisplayed();
      
    //    Boolean condition2=webDriver.findElement(By.id("search-button")).isDisplayed;
        
       assertTrue(condition1);
      //assertTrue(condition2);
    }
	@Test
    public void checkemptyquery()
    {
        driver.findElement(By.id("search-input")).sendKeys(null);
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("error-empty-query")).isDisplayed();
    }
	@Test
	public void checkli()
	{
		driver.findElement(By.id("search-input")).sendKeys("isla");
		driver.findElement(By.id("search-button")).click();
		List<WebElement> results=driver.findElements(By.id("search-results")//li);
				results.get(0).is
		Boolean condition1=results.size()>0;
		assertTrue(condition1);
	}
	@Test
	public void checknoresults()
	{
		driver.findElement(By.id("search-input")).sendKeys("castle");
		driver.findElement(By.id("search-button")).click();
		assertTrue(driver.findElement(By.id("error-empty-query")).isDisplayed());
	}
	@Test
	public void matchquery()
	{
		driver.findElement(By.id("search-input")).sendKeys("port");
		driver.findElement(By.id("search-button")).click();
		List<WebElement> results=driver.findElements(By.tagName("li"));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("li")));
		assertTrue(results.size()==1);
		Boolean condition2=results.get(0).getText().equals("Port Royal");
		assertTrue(condition2);
		results.get(0).getAttribute("tagname");
		assertTrue(driver.findElement(By.tagName("li")).isDisplayed());
	}
	@AfterClass
	public void classclose()
	{
		driver.quit();
	}
}
