package Mavenprojects.MAVEN1;




import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TestDatabase {
 
 
    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    WebDriver driver;
    int rowcount;
     int colcount;

    @Test
    public void SetUpConnection() throws SQLException, ClassNotFoundException {

        // Register JDBC driver (JDBC driver name and Database URL)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Open a connection
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/oracle","username", "password");

            // Execute a query
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("select EMPLOYEE_ID, FIRST_NAME,LAST_NAME,DEPARTMENT_ID from hr.employees where department_id in (30)");
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
             colcount = rsMetaData.getColumnCount();
            
         // Print the result untill all the records are printed
         // res.next() returns true if there is any next record else returns false
         while (resultSet.next())
         {
             
         System.out.print(resultSet.getString(1));
         System.out.print(" " + resultSet.getString(2));
         System.out.print(" " + resultSet.getString(3));
         System.out.print(" " + resultSet.getString(4));

         rowcount++;
         }
      
        WebDriver driver ;
        ChromeOptions chrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
       
        
        // Code to disable the popup of saved password
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        chrome.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(chrome);
        driver.get("http://tableassignment.s3-website.us-east-2.amazonaws.com/");
        System.out.println("website launched");
        
        List<WebElement> lstTr = driver.findElement(By.tagName("table")).findElements(By.xpath("//tr/td"));
        for(WebElement ele:lstTr)
        {
            System.out.println(ele.getText());
        }
        /**Rows Matching**/
      int uirows = driver.findElement(By.tagName("table")).findElements(By.xpath("//td/parent::tr")).size();
      System.out.println("ui rows==>"+uirows);
      
     
        System.out.println(rowcount);
        Assert.assertEquals(uirows, rowcount);
        
        /**column matching**/
        
        int uicolumn= driver.findElements(By.xpath("//tr/th")).size();
        System.out.println("ui columns--> "+uicolumn);
        
        System.out.println("database columns"+colcount);
        Assert.assertEquals(uicolumn,colcount);
        
        /** Heading Matching**/
        System.out.println(rsMetaData.getColumnName(1));
        String dbcolLabel1 =rsMetaData.getColumnName(1);
        String uicolLabel1=driver.findElement(By.xpath("//th[1]")).getText();
        Assert.assertEquals(dbcolLabel1, uicolLabel1);
        
        String dbcolLabel2 =rsMetaData.getColumnName(2);
        String uicolLabel2=driver.findElement(By.xpath("//th[2]")).getText();
        Assert.assertEquals(dbcolLabel2, uicolLabel2);
        
        String dbcolLabel3 =rsMetaData.getColumnName(3);
        String uicolLabel3=driver.findElement(By.xpath("//th[3]")).getText();
        Assert.assertEquals(dbcolLabel3, uicolLabel3);
        
        String dbcolLabel4 =rsMetaData.getColumnName(4);
        String uicolLabel4=driver.findElement(By.xpath("//th[4]")).getText();
        Assert.assertEquals(dbcolLabel4, uicolLabel4);
        
        resultSet = stmt.executeQuery("select EMPLOYEE_ID, FIRST_NAME,LAST_NAME,DEPARTMENT_ID from hr.employees where department_id in (30)");
       /**Data Matching**/
        List<WebElement> uicol1 = driver.findElement(By.tagName("table")).findElements(By.xpath("(//tr/child::td/parent::tr)/child::td[1]"));
      List<String>dbCol1Values=new ArrayList<String>();
        while(resultSet.next())
        {
            dbCol1Values.add(resultSet.getString("EMPLOYEE_ID") );
            
            System.out.println("dbValue for EMPLOYEE_ID"+resultSet.getString("EMPLOYEE_ID") );
            
            
        }
    for(int i=0;i<uicol1.size();i++)
    {
        System.out.println(uicol1.get(i).getText());
        Assert.assertEquals(uicol1.get(0).getText(), dbCol1Values.get(0));
    
    } 
//Assert.assertEquals(uicol1.get(0).getText(), dbCol1Values);
      
        
        
    }
    
       
    
//  @Test
//  public void testTable() {
//      try {
//          // Execute a query
//          stmt = conn.createStatement();
//          resultSet = stmt.executeQuery("select * from sampletable");
//
//          // Get the all row of UI Table
//          List<WebElement> lstTr = driver.findElement(By.id("grdData")).findElements(By.tagName("tr"));
//
//          // Index for Row
//          int rowCount = 0;
//
//          // Count of Matched Column
//          int matchColumnCount = 0;
//
//          // Count of Matched Row
//          int matchRowCount = 0;
//
//          System.out.println("Row Count => " + lstTr.size());
//
//          // Extract the data from Table
//          while (resultSet.next()) {
//
//
//          List<WebElement> lstTd = lstTr.get(rowCount + 1).findElements(By.tagName("td"));
//          System.out.println("Cloumn Count => " + lstTd.size());
//
//          for (int j = 0; j < lstTd.size(); j++) {
//              String uiCell = lstTd.get(j).getText();
//              System.out.println("UI Cell Data => " + uiCell);
//
//              /*
//              * (j + 1) in the resultSet => because index is start from 1
//              * and here loop is starting from 0
//              */
//              String dbCell = resultSet.getString(j + 1);
//              System.out.println("DB Cell Data => " + dbCell);
//
//              // Comparison between both string
//              if (uiCell.trim().equalsIgnoreCase(dbCell.trim())) {
//                  matchColumnCount++;
//              }
//          }
//
//          if (matchColumnCount == lstTd.size()) {
//              matchRowCount++;
//              System.out.println("========ROW MATCHED==========");
//          }
//
//          }
//              assertEquals(matchRowCount, rowCount, "UI Table is the exact copy of Database Table");
//      } catch (Exception e) {
//              System.out.println(e);
//      }
//  }
}