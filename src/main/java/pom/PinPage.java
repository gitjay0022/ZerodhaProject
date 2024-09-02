package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinPage {

	@FindBy (xpath = "//input[@id='pin']")
	   private WebElement logInPin;
	 
	   @FindBy (xpath = "//button[@type='submit']")
	   private WebElement submitButton;
	   
	   
	   public PinPage(WebDriver driver)
	   {
	 	  PageFactory.initElements( driver, this);
	   }
	   
	   public void pinTab(String Pin)
	    {
		   logInPin.clear();
		   logInPin.sendKeys(Pin);
	    }
	    
	    public void submitButtonTab()
	    {
	    	submitButton.click();
	    }
	   
}

