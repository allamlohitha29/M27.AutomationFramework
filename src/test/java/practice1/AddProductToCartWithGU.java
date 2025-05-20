package practice1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;

public class AddProductToCartWithGU {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//create object of utilities
		FileUtility fUtil=new FileUtility();
		JavaUtility jUtil=new JavaUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		
		
		//Read data from property file
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		String URL = fUtil.readDataFromPropertyFile("url");
		
		//Read data from Excel File
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);
		//has to be added to cart-run time data
		
		//Launch the browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//load the url
		driver.get(URL);
		
		//Login to the application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
   		LoginPage lp=new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
   		lp.loginToApp(USERNAME, PASSWORD);
		
		
		
		//click on product -Use excel data(Sauce Labs Bike Light)-Dynamic Xpath
		// WebElement ele = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		 WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		 String productToBeAdded = ele.getText();
		 ele.click();
		
		//Add Product To cart
		driver.findElement(By.id("add-to-cart")).click();
		
	
		
		//navigate to cart
		driver.findElement(By.className("shopping_cart_link")).click();
		Thread.sleep(10);
		
		//capture screenshot
		String screenshotname = "addProductToCart"+jUtil.getSystemDate();
		String path = sUtil.captureScreenshot(driver, screenshotname);
		System.out.println(path);
		
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
    	
    	
		//Logout of the application
		 driver.findElement(By.id("react-burger-menu-btn")).click();
		 driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Logout Completed");
	}

}
