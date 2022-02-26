package Mavenprojects.MAVEN1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xmlreader {
	WebDriver driver=null;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.get("https://en.wikipedia.org/wiki/Special:Export/advertising");
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	@Test
	public void readxml(){
		String SiteName= driver.findElement(By.cssSelector("#folder1 > div.opened > div:nth-child(2) > span:nth-child(2)")).getText();
		System.out.println(SiteName);
		String Dbname=driver.findElement(By.cssSelector("#folder1 > div.opened > div:nth-child(4) > span:nth-child(2)")).getText();
		System.out.println(Dbname);
		String base=driver.findElement(By.cssSelector("#folder1 > div.opened > div:nth-child(6) > span:nth-child(2)")).getText();
		System.out.println(base);
		String generator=driver.findElement(By.cssSelector("#folder1 > div.opened > div:nth-child(8) > span:nth-child(2)")).getText();
		System.out.println(generator);
				for(int i=2;i<=60;i++)
				{
					if(i%2==0&&i!=6)
					{
						//String namespace="\"#folder2 > div.opened > div:nth-child("+i+") > span:nth-child(2)\"";
						//System.out.println(namespace);
						String namespace1=driver.findElement(By.cssSelector("#folder2 > div.opened > div:nth-child("+i+") > span:nth-child(2)")).getText();
						//driver.findElement(By.cssSelector(namespace1));
						System.out.println(namespace1);
					}
				}
		//String namespace=driver.findElement(By.cssSelector("#folder2 > div.opened > div:nth-child(2) > span:nth-child(2)")).getText();
		//System.out.println(namespace);
	}
}
