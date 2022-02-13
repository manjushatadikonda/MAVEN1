package Mavenprojects.MAVEN1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class awards {
List<WebElement> list=null;
List<WebElement> list1=null;
WebElement element=null;
WebDriver driver=null;
int j=0;
@Test
public void launchurl() throws IOException
{
 
//System.setProperty("webdriver.chrome.driver","C:\\Users\\bhimk\\Desktop\\QA wrk space\\ManjuSelenium\\jars\\chromedriver.exe");
//WebDriver driver=new ChromeDriver();
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.dbs.com/about-us/who-we-are/awards-accolades/default.page?productId=jxeawnvl");
list=driver.findElements(By.xpath("//div[@class='col-md-8']//li"));
Assert.assertEquals(80,list.size());
}
@Test(dataProvider="testdata")
public void validate(String awardname,String caption){
list1=driver.findElements(By.xpath("//div[@class='col-md-8']"));
for(int i=0;i<list1.size();i++)
{
//System.out.println(list1.get(i).getText());

String s2="(//div[@class='"+list1.get(i).getAttribute("class")+"'])["+(i+1)+"]//h3";
//System.out.println(s2);
WebElement element2=driver.findElement(By.xpath(s2));
if((element2.getText().toLowerCase()).contains(awardname.toLowerCase()))
{
System.out.println("entered");
//System.out.println(element2.getText().toLowerCase());
element=list1.get(i);
j=i+1;
break;

}

}
 // System.out.println(element);
String headingClass = element.getAttribute("class");
//System.out.println("hi");
       // System.out.println(headingClass);
       // System.out.println("hi");
//System.out.println(j);
String headingPath = "(//div[@class='"+headingClass+"'])["+j+"]//p";
 // System.out.println(headingPath);
Assert.assertEquals(driver.findElement(By.xpath(headingPath)).getText(),caption);
}
@DataProvider(name="testdata")
public Object[][] senddata(){


Object [][] data=new Object[2][2];
data[0][0]="Euromoney";

data[0][1]="Awards for Excellence";

data[1][0]="Global Finance";

data[1][1]="World's Best Banks";

return data;
}
}