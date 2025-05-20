package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductToCartTest extends BaseClass {

	@Test
	public void tc_02_AddLowestPriceProductToCartTest() throws IOException
	{
		// TODO Auto-generated method stub

				
				//Read data from Excel File
				
				String SORTOPTION = fUtil.readDataFromExcel("Products", 4, 2);
				String PRODUCTNAME = fUtil.readDataFromExcel("Products", 4, 3);
				//has to be added to cart-run time data
				
				
				//click on product
				InventoryPage ip=new InventoryPage(driver);
				ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);
				
				//add product to cart
				InventoryItemPage iip=new InventoryItemPage(driver);
				iip.clickOnAddToCartBtn();
				
				//click on cart container
				ip.clickOnCartContainer();
				
				//validate in cart
				CartPage cp=new CartPage(driver);
				  String productInCart = cp.getItemName();
				  
				  Assert.assertTrue(productInCart.equals(PRODUCTNAME));
				  System.out.println(productInCart);
	
//				  if(productInCart.equals(PRODUCTNAME))
//				  {
//					  System.out.println("pass");
//					  System.out.println(productInCart);
//				  }
//				  else
//				  {
//					  System.out.println("fail");
//				  }
				  
				 
				  
	} 

	
	
}
