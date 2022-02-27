package Mavenprojects.MAVEN1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class screenshot {
@Test
public void launchurl() throws IOException
{
   WebDriver driver=null;
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
try
{
driver.get("https://the-internet.herokuapp.com/typos");
Reporter.log("hi");
Assert.assertEquals(driver.getTitle(),"The Internet1");
}
catch(AssertionError e)
{
takeSnapshot(driver,"C:\\Users\\bhimk\\Desktop\\QA wrk space\\mavenflipkart\\target\\test.png");
}
}
public static void takeSnapshot(WebDriver webdriver,String filepath) throws IOException
{
TakesScreenshot obj=(TakesScreenshot)webdriver;
File src= obj.getScreenshotAs(OutputType.FILE);
File des=new File(filepath);
FileUtils.copyFile(src,des);
System.out.println("this is file:" );
}
}