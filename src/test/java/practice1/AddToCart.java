package practice1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Read data from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read data from Excel File
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);//document
		Sheet sh = wb.getSheet("Products");//sheet
		Row rw = sh.getRow(1);//row
		Cell cl = rw.getCell(2);//cell
		String PRODUCTNAME = cl.getStringCellValue();//has to be added to cart-run time data
		
		//Launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//load the url
		driver.get(URL);
		
		//Login to the application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
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
