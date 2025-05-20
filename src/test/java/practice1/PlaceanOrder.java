package practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlaceanOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//load the url
		driver.get("https://www.saucedemo.com/");
		
		//Login to the application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//click on product -Sauce Labs Backpack
		 WebElement ele = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		 String productToBeAdded = ele.getText();
		 ele.click();
		
		//Add Product To cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//navigate to cart
		driver.findElement(By.className("shopping_cart_link")).click();
		Thread.sleep(1000);
		
		//validate for product
    	String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
    	if(productInCart.equals(productToBeAdded))
    	{
    		System.out.println("PASS");
    		System.out.println(productInCart);
    	}
    	else
    	{
    		System.out.println("FAIL");
    	}
    	Thread.sleep(1000);
		
		//Checkout the product
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("lohitha");
		driver.findElement(By.id("last-name")).sendKeys("raj");
		driver.findElement(By.id("postal-code")).sendKeys("500032");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		Thread.sleep(1000);
		
		//Logout of the application
	    driver.findElement(By.id("react-burger-menu-btn")).click();
	    driver.findElement(By.id("logout_sidebar_link")).click();
	    System.out.println("Logout Completed");
	}

}
