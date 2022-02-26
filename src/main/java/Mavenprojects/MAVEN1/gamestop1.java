package Mavenprojects.MAVEN1;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gamestop1 {
	WebDriver driver;
	String filepath="C:\\Users\\saita\\Desktop\\Manju Workspace\\Book2.xlsx";
	DataFormatter dataformatter=new DataFormatter();
	//WebDriverWait wt = new WebDriverWait(driver, 10);
	//WebDriverWait wait1;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void launchurl()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	driver.get("https://www.gamestop.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

	}
	 public String[][] getExcelData(String filename)
	    {
	    	
	    	String Data[][]= new String[5][2]; 
	    	try
	    	{
	    		Workbook workbook=WorkbookFactory.create(new File(filename));
	    		Sheet worksheet=(Sheet)workbook.getSheetAt(0);
	    		  
	    	    	
	    	    	
	    	     for(int i=0; i<5; i++) 
	    	     {  
	    	     Row row= worksheet.getRow(i+1);
	    	     
	    	     for (int j=0; j<=1; j++)
	    	     {
	    	     if(row==null)
	    	     Data[i][j]= "";
	    	     else 
	    	     {
	    	     Cell cell= row.getCell(j);
	    	     if(cell==null)
	    	     Data[i][j]= ""; 
	    	     else
	    	     {
	    	     String value=dataformatter.formatCellValue(cell);
	    	     Data[i][j]=value;
	    	     }
	    	     }
	    	     }
	    	     }
	    	     System.out.println("data is"+Data[0][1]);
	    	     return Data;

	    	}
	    	 catch(Exception e)
	    	 {
	    		System.out.println(e); 
	    		  System.out.println("data is"+Data.toString());
	    		return Data;
	    	 }
	   
	    }
	@SuppressWarnings("deprecation")
	@Test(dataProvider="sampledata")
	public void clicksearch(String SearchItem,final String Item) throws InterruptedException
	
	{
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
		
	//Thread.sleep(8000);
	
		driver.findElement(By.xpath("//input[@id='searchRedesignTemplateInput']")).sendKeys(SearchItem);
		driver.findElement(By.xpath("//div[@class='search-icon material-icons']")).click();
	WebElement p4 =(WebElement)wait.until(new Function<WebDriver,WebElement>(){
	      public WebElement apply(WebDriver driver ) {
	    	 // String xpath1="//a[@href='"+Item+""
	           return driver.findElement(By.xpath("//a[@href='"+Item+"']"));
	      }
	});
	p4.click();
	WebDriverWait wt = new WebDriverWait(driver, 30);
	
	driver.manage().deleteAllCookies();
	try
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement p2=driver.findElement(By.cssSelector("#add-to-cart"));
	 
	p2.click();
	
	Thread.sleep(5000);
	
	actions.click().build().perform();
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	

	Thread.sleep(5000);
driver.findElement(By.xpath("//span[@class='shopping-cart d-none d-md-block material-icons material-icons-outlined']")).click();
	}
	@AfterClass
	public void closeall()
	{
	driver.quit();
	}
	@DataProvider
	public Object[][] sampledata()
	{
		
		 Object[][] data=getExcelData(filepath);
		 
			return data;
	}
}
