package Mavenprojects.MAVEN1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class fluentwait {
WebDriver driver=null;
@BeforeClass
public void launchurl()
{
WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
}
@Test
public void clickonstart()
{
Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class);
WebElement start=driver.findElement(By.xpath("//button[text()='Start']"));
start.click();
WebElement clickseleniumlink =(WebElement)wait.until(new Function<WebDriver,WebElement>(){
      public WebElement apply(WebDriver driver ) {
           return driver.findElement(By.xpath("//div[@id='finish']//h4"));
       }
   });
 

}



}

