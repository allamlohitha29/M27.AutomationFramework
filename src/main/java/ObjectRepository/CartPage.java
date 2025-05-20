package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {//rule1
	
	
	//rule 2- Declaration
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(id = "remove")
	private WebElement removeBtn;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingBtn;
	

	//rule 3 - Initialization
			public CartPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

		
			//Rule 4 - utilization
			public WebElement getitemInfo() {
				return itemInfo;
			}

			public WebElement getRemoveBtn() {
				return removeBtn;
			}


			public WebElement getCheckoutBtn() {
				return checkoutBtn;
			}


			public WebElement getContinueShoppingBtn() {
				return continueShoppingBtn;
			}
			
			//Business libraries
			
			/**
			 * This method will capture productname and return to caller
			 * @return
			 */
			public String getItemName()
			{
				return itemInfo.getText();
				}

			public void ClickOnRemoveBtn()
			{
				removeBtn.click();
			}
}
