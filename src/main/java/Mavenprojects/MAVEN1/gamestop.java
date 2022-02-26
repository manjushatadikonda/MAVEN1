package Mavenprojects.MAVEN1;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gamestop {
	WebDriver driver=null;
	String filepath="C:\\Users\\saita\\Desktop\\Manju Workspace\\Book2.xlsx";
	DataFormatter dataformatter=new DataFormatter();
	WebDriverWait wait;
	public String[][] getExcelData(String filename)
    {
    	
    	String Data[][]= new String[5][5]; 
    	try
    	{
    		Workbook workbook=WorkbookFactory.create(new File(filename));
    		Sheet worksheet=(Sheet)workbook.getSheetAt(0);
    		  
    	    	
    	    	
    	     for(int i=0; i<5; i++) 
    	     {  
    	     Row row= worksheet.getRow(i+1);
    	     
    	     for (int j=0; j<5; j++)
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
    	     return Data;

    	}
    	 catch(Exception e)
    	 {
    		System.out.println(e); 
    		return Data;
    	 }
   
    }
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.get("https://www.gamestop.com/");
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="sampledata")
	public void search(String searchitem,String Item) throws InterruptedException
	{
		 WebElement query=webDriver.findElement(By.id("search-input"));
		driver.findElement(By.xpath("//input[@id='searchRedesignTemplateInput']")).sendKeys(searchitem+"\n");
		//wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"),10));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
	WebElement p4 =(WebElement)wait.until(new Function<WebDriver,WebElement>(){
	      public WebElement apply(WebDriver driver ) {
	           return driver.findElement(By.xpath("//div[text()='This text has appeared after 5 seconds!']"));
	       }
	   });
		
		List<WebElement> list1= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int n= list1.size();
        System.out.println(n);
        Boolean condition1=n>20;
        Assert.assertTrue(condition1);
        for(int i=0; i<n; i++)
        {
        	try
        	{
        	String s1= list1.get(i).getText();
        	System.out.println(s1);
        	String s2="TCL 20 SE 6.82\" Unlocked Cellphone, 4GB RAM + 128GB ROM, US Version Android 11 Smartphone with 48MP Rear AI Quad-Camera, 5000mAh Big Battery, Dual Speaker, OTG Reverse Charging, Octa-Core, Nuit Black"; 
        	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='TCL 20 SE 6.82\" Unlocked Cellphone, 4GB RAM + 128GB ROM, US Version Android 11 Smartphone with 48MP Rear AI Quad-Camera, 5000mAh Big Battery, Dual Speaker, OTG Reverse Charging, Octa-Core, Nuit Black']")));
        	if(s1.contains(s2))
        	{
        		System.out.println("hi");
        		
        		driver.findElement(By.xpath("//span[text()='TCL 20 SE 6.82\" Unlocked Cellphone, 4GB RAM + 128GB ROM, US Version Android 11 Smartphone with 48MP Rear AI Quad-Camera, 5000mAh Big Battery, Dual Speaker, OTG Reverse Charging, Octa-Core, Nuit Black']")).click();
          
        		for(String handle : driver.getWindowHandles())
        		{
        		driver.switchTo().window(handle);
        		}
        		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        	driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        	wait.until(ExpectedConditions.titleContains("Shopping Cart"));
        	String currenttitle1=driver.getTitle();
            Boolean condition2=currenttitle1.contains("Shopping Cart");
            Assert.assertTrue(condition2);
        	}
        	break;
        	}
        	catch(Exception e)
        	{
        		System.out.println(e);
        	}
		
        }
		
	}
	
	@AfterClass
	public void driverquit()
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
	
	
	
	
	

