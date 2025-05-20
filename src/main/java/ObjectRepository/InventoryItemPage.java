package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {//rule1
	
	//rule2- Declaration
	@FindBy(id = "add-to-cart") 
	private WebElement addToCartBtn;
	
//	@FindBy(className = "inventory_details_price")
//	private WebElement priceTxt;
	
	
	
	//rule 3 - Initialization
			public InventoryItemPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

		
			//Rule 4 - utilization
			
			public WebElement getAddToCartBtn() {
				return addToCartBtn;
			}

//			public WebElement getPriceTxt() {
//				return priceTxt;
//			}
			
			//Business Library
			
			/**
			 * This method will click on add to cart button
			 */
			public void clickOnAddToCartBtn()
			{
				addToCartBtn.click();
			}
			
	
	
	

}
