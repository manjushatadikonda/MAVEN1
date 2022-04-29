package southwestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	WebDriver driver=null;
    @FindBy(how=How.ID,using="form-mixin--submit-button") WebElement search1;
    @FindBy(xpath="//div[@class='form-container--search-block']//button") WebElement search;
    @FindBy(xpath="//*[@id='LandingAirBookingSearchForm_originationAirportCode']") WebElement departure;
    @FindBy(xpath="//*[@id='LandingAirBookingSearchForm_destinationAirportCode']") WebElement arrive;
    @FindBy(xpath="//*[@id='LandingAirBookingSearchForm_departureDate']") WebElement departuredate;
    @FindBy(xpath="//*[@id='LandingAirBookingSearchForm_returnDate']") WebElement returndate;
    
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public String getdeparture()
	{
		return departure.getAttribute("value");
	}
	public SearchResultsPage searchitem() throws InterruptedException
	{
		//driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l')]")).click();
		//WebElement search=driver.findElement(By.className("_3704LK"));
		
		arrive.sendKeys("LGA");
		departuredate.click();
		  while(!driver.findElement(By.xpath("//div[@class='calendar-month--title']")).getText().contains("April"))
	        {
	        	driver.findElement(By.xpath("//button[@class='actionable actionable_button actionable_icon-only actionable_light button calendar-controls--button calendar-controls--next']")).click();
	        }
	   
	        java.util.List<WebElement> date=driver.findElements(By.xpath("//div[@class='calendar-month--days']//button"));
	        int count= date.size();
	        System.out.println(count);
	        for(int i=0;i<count;i++)
	        {
	         String s=date.get(i).getAttribute("id");
	        	if(s.equalsIgnoreCase("calendar-66-2022-04-07"))
	        	{
	        		driver.findElements(By.xpath("//div[@class='calendar-month--days']//button")).get(i).click();
	        	    break;
	        	}
	        }
	        Thread.sleep(3000);
	       
	        try
	        {
	        while(!driver.findElement(By.xpath("//div[@class='calendar-month--title']")).getText().contains("April"))
	        {
	        	driver.findElement(By.xpath("//span[@class='swa-icon actionable--icon actionable--icon_prefix actionable--icon_medium-gap swa-icon_arrow-right']")).click();
	        	Thread.sleep(3000);
	        }
	   
	        java.util.List<WebElement> date1=driver.findElements(By.xpath("//div[@class='calendar-month--days']//button"));
	       
	        for(int i=0;i<count;i++)
	        {
	         String s=date1.get(i).getAttribute("id");
	        	if(s.equalsIgnoreCase("calendar-69-2022-04-22"))
	        	{
	        		driver.findElements(By.xpath("//div[@class='calendar-month--days']//button")).get(i).click();
	        		Thread.sleep(3000);
	        	    break;
	        	}
	        }
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        JavascriptExecutor js = (JavascriptExecutor) driver;// Java Script to scroll the web page
			js.executeScript("window.scrollBy(0, 180)");
	        search.click();
	     
		Thread.sleep(3000);
		search1.click();
		return new SearchResultsPage(driver);
	}
}
