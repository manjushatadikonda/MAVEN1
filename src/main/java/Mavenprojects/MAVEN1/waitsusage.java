package Mavenprojects.MAVEN1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class waitsusage {
	WebDriver driver=null;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.get("https://webdriveruniversity.com/Accordion/index.html");
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    driver.manage().window().maximize();
	}
	@Test
	public void clickonplus()
	{
	driver.findElement(By.xpath("//button[text()='Manual Testing']")).click();
	WebElement p1=driver.findElement(By.xpath("//div[@id='manual-testing-description']//p"));
	String para1=p1.getText();
	System.out.println(para1);
	Boolean condition1=para1.contains("Manual testing");
	Assert.assertTrue(condition1);
	}
	@Test
	public void clickonplus1()
	{
	driver.findElement(By.xpath("//button[text()='Cucumber BDD']")).click();
	WebElement p2=driver.findElement(By.xpath("//div[@id='cucumber-testing-description']//p"));
	String para2=p2.getText();
	System.out.println(para2);
	Boolean condition2=para2.contains("Cucumber");
	Assert.assertTrue(condition2);
	}
	@Test
	public void clickonplus2()
	{
	driver.findElement(By.xpath("//button[text()='Automation Testing']")).click();
	WebElement p3=driver.findElement(By.xpath("//div[@id='automation-testing-description']//p"));
	String para3=p3.getText();
	System.out.println(para3);
	Boolean condition3=para3.startsWith("Automation");
	Assert.assertTrue(condition3);
	}
	@Test
	public void clickonplus4()
	{
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
	WebElement p4 =(WebElement)wait.until(new Function<WebDriver,WebElement>(){
	      public WebElement apply(WebDriver driver ) {
	           return driver.findElement(By.xpath("//div[text()='This text has appeared after 5 seconds!']"));
	       }
	   });
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,100)");
	driver.findElement(By.xpath("//button[text()='Keep Clicking! - Text will Appear After 5 Seconds!']")).click();
    String para4=p4.getText();
    System.out.println(para4);
    Boolean condition4=para4.contains("5 seconds");
	Assert.assertTrue(condition4);
	}
	@AfterClass
	public void closing()
	{
		driver.quit();
	}
}
