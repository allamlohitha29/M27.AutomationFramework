package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{//rule 1
	
	//rule 2 -declaration

	
	@FindBy(className = "product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cartContainerBtn;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutLnk;
	
	
	//rule 3 - Initialization
		public InventoryPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Rule 4 - utilization


		public WebElement getSortFilter() {
			return sortDropDown;
		}


		public WebElement getCartContainer() {
			return cartContainerBtn;
		}


		public WebElement getMenuBtn() {
			return menuBtn;
		}


		public WebElement getLogoutlink() {
			return logoutLnk;
		}


	//Business library
		/**
		 * This method will click on any product specified by caller
		 * @param driver
		 * @param productname
		 */
		public void clickOnAProduct(WebDriver driver,String productname)
		{
			driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
			
		}
		
		/**
		 * This method will perform logout operation
		 */
		
		public void logoutOfApp()
		{
			menuBtn.click();
			logoutLnk.click();
		}
		
		
		/**
		 * This method will sort for the lowest priced product and click on it
		 * @param driver
		 * @param sortOption
		 * @param productname
		 */
		public void clickOnLowestPriceProduct(WebDriver driver,String sortOption,String productname )
		{
			handleDropDown(sortDropDown, sortOption);
			driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
		}
		
		
		public void clickOnCartContainer()
		{
			cartContainerBtn.click();
		}
		}
		
		
	


