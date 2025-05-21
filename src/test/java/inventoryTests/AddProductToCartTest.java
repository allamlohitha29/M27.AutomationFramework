package inventoryTests;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;


@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass {
     
	@Test(groups = "SmokeSuite")
     public void tc_01_AddProductToCartTest() throws IOException
	{
		// TODO Auto-generated method stub

				//Read data from Excel File
				String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);
				//has to be added to cart-run time data
			//	System.out.println(PRODUCTNAME);
				
				
				//click on product
				InventoryPage ip=new InventoryPage(driver);
				ip.clickOnAProduct(driver, PRODUCTNAME);
				
				//add product to cart
				InventoryItemPage iip=new InventoryItemPage(driver);
				iip.clickOnAddToCartBtn();
				
				//click on cart container
				ip.clickOnCartContainer();
				
				//validate in cart
				CartPage cp=new CartPage(driver);
				  String productInCart = cp.getItemName();
				  
				  Assert.assertEquals(productInCart, PRODUCTNAME);
				  System.out.println(productInCart);
				  
				  
				  
				  
	//			  if(productInCart.equals(PRODUCTNAME))
	//			  {
   //					  System.out.println("pass");
	//				  System.out.println(productInCart);
	//			  }
	//			  else
	//			  {
	//				  System.out.println("fail");
	//			  }
	}
				  
				  @Test
				  public void SampleTest()
				  {
					  Assert.fail();
					  System.out.println("sample");
				  }
				
				  
	   

	}


