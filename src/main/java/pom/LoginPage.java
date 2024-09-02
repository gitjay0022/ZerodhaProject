package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	   @FindBy (xpath = "//input[@id='userid']")
	   private WebElement userName;
	   
	   @FindBy (xpath = "(//div[@id='outer-base']//input[1])[2]")
	   private WebElement password;
	   
	   @FindBy (xpath = "//button[@type='submit']")
	   private WebElement logIn;
	   
	   
	   
	 //  @FindBy (xpath = " //span[@class='user-id']")
	 //  private WebElement account;
	  
	   
	   public LoginPage(WebDriver driver)
	   {
	 	  PageFactory.initElements( driver, this);
	   }
	   
	   public void userNameTab(String User)
	    {
		   userName.clear();
		   userName.sendKeys(User);
	    }
	   
	   public void passwordTab(String pass) throws InterruptedException
	    {
		   password.clear();
		   Thread.sleep(1000);
		   password.sendKeys(pass);;
	    }
	   
	    public void logInTab()
	    {
	    	logIn.click();
	    }
	    
	    
	    

}
