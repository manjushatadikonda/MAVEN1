package Tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pirates {
	WebDriver driver=null;
	@BeforeClass
	public void launchurl()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html");
	driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
}
