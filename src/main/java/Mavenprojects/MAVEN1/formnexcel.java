package Mavenprojects.MAVEN1;

import java.io.File;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class formnexcel {
WebDriver driver=null;
public static final String filepath="C:\\\\Users\\\\bhimk\\\\Desktop\\\\QA wrk space\\\\mavenflipkart\\\\target\\\\formdata.xlsx";
DataFormatter dataformatter=new DataFormatter();
@BeforeClass
public void launchurl()
{
WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
        driver.get("http://assignmentbucket123.s3-website.us-east-2.amazonaws.com/");
}

@Test(priority=0)
public void formfilling() throws EncryptedDocumentException, IOException
{ Workbook workbook=WorkbookFactory.create(new File(filepath));
Sheet s1=(Sheet)workbook.getSheetAt(0);
Row r1=s1.getRow(1);
   Cell c1=r1.getCell(0);
   String firstname=dataformatter.formatCellValue(c1);
WebElement FirstName=driver.findElement(By.xpath("//input[@name='firstname']"));
FirstName.sendKeys(firstname);

Cell c2=r1.getCell(1);
String middlename=dataformatter.formatCellValue(c2);
WebElement MiddleName=driver.findElement(By.xpath("//input[@name='middlename']"));
MiddleName.sendKeys(middlename);

Cell c3=r1.getCell(2);
String lastname=dataformatter.formatCellValue(c3);
WebElement LastName=driver.findElement(By.xpath("//input[@name='lastname']"));
LastName.sendKeys(lastname);

Cell c4=r1.getCell(3);
String course=dataformatter.formatCellValue(c4);
Select Course=new Select(driver.findElement(By.xpath("/html/body/form/select")));
 Course.selectByVisibleText(course);
 
Cell c5=r1.getCell(4);
String gender=dataformatter.formatCellValue(c5).toLowerCase();
String Gender="(//input[@name='"+gender+"'])";
WebElement Gender1=driver.findElement(By.xpath(Gender));
Gender1.click();

Cell c6=r1.getCell(5);
String phone=dataformatter.formatCellValue(c6);
WebElement Phone=driver.findElement(By.xpath("//input[@name='phone']"));
 Phone.sendKeys(phone);
 
Cell c7=r1.getCell(6);
String address=dataformatter.formatCellValue(c7);
WebElement Address=driver.findElement(By.xpath("/html/body/form/textarea"));
Address.sendKeys(address);

Cell c8=r1.getCell(7);
String email=dataformatter.formatCellValue(c8);
WebElement Email =driver.findElement(By.xpath("//input[@name='email']"));
Email.sendKeys(email);

Cell c9=r1.getCell(8);
String pswd=dataformatter.formatCellValue(c9);
WebElement Pass=driver.findElement(By.xpath("//input[@name='pass']"));
Pass.sendKeys(pswd);

Cell c10=r1.getCell(9);
String repswd=dataformatter.formatCellValue(c10);
WebElement Repass=driver.findElement(By.xpath("//input[@name='repass']"));
   Repass.sendKeys(repswd);
}
@Test(priority=1)
   public void clicksubmit()
   {
WebElement submit=driver.findElement(By.xpath("/html/body/form/a/input"));
   submit.click();
   Assert.assertEquals(driver.getTitle(),"Title");
   }



}

