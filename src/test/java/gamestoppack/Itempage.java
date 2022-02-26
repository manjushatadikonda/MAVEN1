package gamestoppack;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Itempage {
	
	
		
		WebDriver driver=null;
		@FindBy(id="add-to-cart")WebElement cartadd;
		@FindBy(xpath="//a[@href='https://www.gamestop.com/cart/']") WebElement cart;
	public Itempage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public CartPage addtocart() throws InterruptedException
	{
		cartadd.click();
		Thread.sleep(5000);
		cart.click();
		return new CartPage(driver);
	}
	}


