package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 @FindBy (xpath = "//span[text()='Dashboard']")
	   private WebElement dashBord; 
	 
	 @FindBy (xpath = "//span[text()='Orders']")
	   private WebElement orders;
	 
	 @FindBy (xpath = "//input[@type='text']")
	   private WebElement searchBar;
	  
	 @FindBy (xpath = "//ul[@class='omnisearch-results']//li[1]")
	   private WebElement shareResult;
	 
	 @FindBy (xpath = "//button[text()='B ']")
	   private WebElement buyButton;
	 
	 @FindBy (xpath = "(//form[@data-drag-boundary='true']//label)[7]")
	   private WebElement intraday;
	 
	 @FindBy (xpath = "(//input[@type='number'])[1]")
	   private WebElement qty;
	 
	 @FindBy (xpath = "(//input[@type='number'])[2]")
	   private WebElement price;
	 
	 @FindBy (xpath = "(//input[@type='number'])[3]")
	   private WebElement triggerPrice;
	 
	 @FindBy (xpath = "(//form[@data-drag-boundary='true']//label)[12]")
	   private WebElement marketOrder;
	 
	 @FindBy (xpath = "(//form[@data-drag-boundary='true']//label)[14]")
	   private WebElement stopLoss;
	 
	 @FindBy (xpath = "//button[text()='Cancel ']")
	   private WebElement cancelOrder;
	 
	 @FindBy (xpath = "//span[text()='Holdings']")
	   private WebElement holdings;
	  
	  @FindBy (xpath = "//span[text()='Positions']")
	  private WebElement positions;
	  
	  @FindBy (xpath = "//span[text()='Funds']")
	  private WebElement funds;
	  
	  @FindBy (xpath = "//span[@class='nickname']")
	  private WebElement dematHolderName;
	  
	  
	  @FindBy (xpath = "//span[text()='Apps']")
	  private WebElement apps;
	  
	  @FindBy (xpath = "//span[@class='user-id']")
	  private WebElement account ;
	  
	  @FindBy (xpath = "//a[text()=' Logout']")
	  private WebElement logOut;
	  
	  
	  private WebDriver driver;  
	  private Actions actions;
	public HomePage(WebDriver driver)
	  {
		  PageFactory.initElements( driver, this);
		 
		  this.driver = driver;
		  actions=new Actions(driver);
	  }

	   public void clickOnDashboardTab()
	   {
		   dashBord.click();
	   }
	   
	   public String verifyDematAccName()
	   {
		  String dematName= dematHolderName.getText();
		  return dematName;
	   }
	   
	   
	   public void clickOnSearchBar(String shareName) throws InterruptedException
	   {
		   searchBar.click();
		   Thread.sleep(1500);
		   searchBar.sendKeys(shareName);
	   }
	   
	   public void moveOnShare() throws InterruptedException
	   {
		
		   actions.moveToElement(shareResult).build().perform();
		   Thread.sleep(1000);
	   }
	   
	   public void clickOnbuy() throws InterruptedException
	   {
		  
		   actions.moveToElement(buyButton).click().build().perform();
	   }
	   
	   public void clickOnIntraDay() throws InterruptedException
	   {
		   intraday.click();
		   
	   }
	   
	   public void enterQty(String qtyValue) throws InterruptedException
	   {
		   qty.clear();
		   Thread.sleep(1000);
		   qty.sendKeys(qtyValue);
	   }
	   
	   public void enterPrice(String priceOfShare) throws InterruptedException
	   {
		   price.clear();
		   Thread.sleep(1000);
		   price.sendKeys(priceOfShare);
	   }
	   
	   public void enterTriggerPrice(String triggerPriceOfShare) throws InterruptedException
	   {
		   triggerPrice.clear();
		   Thread.sleep(1000);
		   triggerPrice.sendKeys(triggerPriceOfShare);
	   }
	   
	   
	   public void clickOnMarketOrder() throws InterruptedException
	   {
		   Thread.sleep(1000);
		   marketOrder.click();
		   
	   }
	   
	   public void clickOnStopLoss() throws InterruptedException
	   {
		   Thread.sleep(1000);
		   stopLoss.click();
		   
	   }
	   
	   public void clickOnCancel() throws InterruptedException
	   {
		   Thread.sleep(1000);
		   cancelOrder.click();
		   
	   }
	   
	   public void clickOnOrdersTab()
	   {
		   orders.click();
	   }
	   
	   public void clickOnHoldingsTab()
	   {
		   holdings.click();
	   }
	   
	   public void clickOnPositionsTab()
	   {
		   positions.click();
	   }
	   
	   public void clickOnFundsTab()
	   {
		   funds.click();
	   }
	   
	   public void clickOnApsTab()
	   {
		   apps.click();
	   }
	   
	   public void clickOnAccountTab()
	   {
		   account.click();
	   }
	   
	   public void clickOnLogOutTab() throws InterruptedException
	   {
		   Thread.sleep(1000);
		  actions.moveToElement(logOut).click().build().perform();
		
	   }

}
