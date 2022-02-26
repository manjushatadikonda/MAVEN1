package Mavenprojects.MAVEN1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataproviderexcel 
{
	WebDriver driver=null;
	public static final String filepath="C:\\Users\\saita\\Desktop\\Manju Workspace\\Book1.xlsx";
	DataFormatter dataformatter=new DataFormatter();
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	       
	}
    public String[][] getExcelData(String filename)
    {
    	
    	String Data[][]= new String[10][10]; 
    	try
    	{
    		Workbook workbook=WorkbookFactory.create(new File(filename));
    		Sheet worksheet=(Sheet)workbook.getSheetAt(0);
    		  
    	    	
    	    	
    	     for(int i=0; i<10; i++) 
    	     {  
    	     Row row= worksheet.getRow(i+1);
    	     
    	     for (int j=0; j<10; j++)
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
	@Test(priority=0,dataProvider="sampledata")
	public void formfilling(String firstname,String middlename,String lastname,String course,String Gender,String phone,String address,String email,String password,String Repassword) throws EncryptedDocumentException, IOException
	{
		 driver.get("http://assignmentbucket123.s3-website.us-east-2.amazonaws.com/");
		WebElement FirstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		FirstName.sendKeys(firstname);
		
		WebElement MiddleName=driver.findElement(By.xpath("//input[@name='middlename']"));
		MiddleName.sendKeys(middlename);
		
		WebElement LastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		LastName.sendKeys(lastname);
		
		Select Course=new Select(driver.findElement(By.xpath("/html/body/form/select")));
	    Course.selectByVisibleText(course);
		 
	    WebElement Gender1=driver.findElement(By.xpath("//input[@name='"+Gender+"']"));
	    Gender1.click();
	    
	    WebElement Phone=driver.findElement(By.xpath("//input[@name='phone']"));
	    Phone.sendKeys(phone);
	    
	    WebElement Address=driver.findElement(By.xpath("/html/body/form/textarea"));
	    Address.sendKeys(address);
	    
	    WebElement Email =driver.findElement(By.xpath("//input[@name='email']"));
	    Email.sendKeys(email);
	    
	    WebElement Password=driver.findElement(By.xpath("//input[@name='pass']"));
	    Password.sendKeys(password);
	    
	    WebElement Repass=driver.findElement(By.xpath("//input[@name='repass']"));
	    Repass.sendKeys(Repassword);
		
	    WebElement submit=driver.findElement(By.xpath("/html/body/form/a/input"));
	    submit.click();
	    Assert.assertEquals(driver.getTitle(),"Title");
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
