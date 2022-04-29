package PepperfryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver=null;
	//public String path = "webdriver.chrome.driver";
	//public String value = "/Users/sandeepvecha/Desktop/Java Manju/ManjuSelinium/jars/chromedriverjar";
	public static WebDriverWait wait=null;
	DesiredCapabilities c=null;
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void initializedriver()
	{
		//System.setProperty(path, value);
		WebDriverManager.chromedriver().setup();
			      // configure options parameter to Chrome driver
			      ChromeOptions o= new ChromeOptions();
			      // add Incognito parameter
			      o.addArguments("--test-type");
			      o.addArguments("--disable-popup-blocking");
			      o.addArguments("--incognito");
			     
			      // DesiredCapabilities object
			      c =  new DesiredCapabilities();

c.setCapability(ChromeOptions.CAPABILITY, o);

 driver = new ChromeDriver(c);
			     
			     
	}
	public void launchURL()
	{
		driver.manage().window().maximize();
		driver.get("https://www.pepperfry.com/");

	}

	@AfterSuite
	public void clean()
	{
		TestBase.driver.quit();
	}
}
