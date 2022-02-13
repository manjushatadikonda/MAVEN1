package Mavenprojects.MAVEN1;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ISelect;

//import com.sun.org.apache.bcel.internal.generic.Select;

public class path2usa {
	
		public static void main(String[] args) throws InterruptedException {
			///Users/sandeepvecha/Desktop/Java Manju/ManjuSelinium/jars/chromedriver 5
			// TODO Auto-generated method stub
	        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\saita\\\\Desktop\\\\Manju Workspace\\\\Trail\\\\jars\\\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.google.com/");
	        driver.manage().window().maximize();
	        //WebDriverWait wait=new WebDriverWait(driver,20);
	        driver.navigate().to("https://www.path2usa.com/travel-companions");
	        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        //From City
	        JavascriptExecutor js = (JavascriptExecutor) driver;// Java Script to scroll the web page
			js.executeScript("window.scrollBy(0, 180)");// scroll the window to 200 pixels

	        driver.findElement(By.xpath("//input[@class='form-control required']")).sendKeys("HY");
	        List<WebElement> list1=driver.findElements(By.xpath("//div[@id='ajax_listOfOptions']//div[@class='optionDiv']"));
	        for(int i=0;i<list1.size();i++)
	        {
	        	String fromcity=list1.get(i).getText();
	        	if(fromcity.contains("Hyderabad"))
	        	{
	        		list1.get(i).click();
	        		break;
	        	}
	        }
	        //To City
	        JavascriptExecutor js1 = (JavascriptExecutor) driver;// Java Script to scroll the web page
			js1.executeScript("window.scrollBy(0, 180)");// scroll the window to 200 pixels

	        driver.findElement(By.id("travel_to")).sendKeys("Ch");
			List<WebElement> list2 = driver
					.findElements(By.xpath("//div[@id='ajax_listOfOptions'] //div[@class='optionDiv']"));
		

			for (int k = 0; k < list2.size(); k++) {
				String tocity = list2.get(k).getText();
				System.out.println(tocity);

				if (tocity.contains("Chennai International")) {
					list2.get(k).click();
				}
			}
			
		//traveldate
			driver.findElement(By.xpath("//input[@name='travel_date']")).click();
	        while(!driver.findElement(By.xpath("//table[@class=' table-condensed']//th[@class='datepicker-switch']")).getText().contains("March"))
	        {
	        	driver.findElement(By.xpath("//table[@class=' table-condensed']//th[@class='next']")).click();
	        }
	        List<WebElement> list3=driver.findElements(By.xpath("//table[@class=' table-condensed']//td[@class='day']"));
	        for(int j=0;j<list3.size();j++)
	        {
	        	if((list3.get(j).getText()).contains("7")) {
	        		list3.get(j).click();
	        		break;
	        	}
	        }
	     // toselect +-week
	       // Select week= new Select(driver.findElements(By.id("datebetween")));
	    Select week= new Select(driver.findElement(By.xpath("//select[@id='datebetween']")));
	    week.selectByIndex(2);
	    //toselect Airline
	    Select airline=new Select(driver.findElement(By.xpath("//select[@id='travel_airline']")));
	    airline.selectByValue("Air India");
	    //toselect language
	    Select language=new Select(driver.findElement(By.xpath("//div[@class='select-style']//select[@id='travel_language']")));
	    language.selectByValue("Telugu");
	    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	    driver.quit();
	}
	} 


