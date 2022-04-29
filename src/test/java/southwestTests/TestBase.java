package southwestTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;

	@BeforeSuite
	public void initializedriver()
	{
		//System.setProperty(path, value);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// wait=new WebDriverWait(driver,20);
	}
	public void launchURL()
	{
		driver.manage().window().maximize();
		driver.get("https://www.southwest.com/");

	}

@AfterSuite
	public void clean()
	{
		TestBase.driver.quit();
	}
}
