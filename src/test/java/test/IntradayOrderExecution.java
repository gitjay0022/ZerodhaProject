package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pom.HomePage;
import pom.LoginPage;
import pom.PinPage;
import utils.Utility;

public class IntradayOrderExecution extends Browser {
	private WebDriver driver;
	private int TestID;
	private HomePage homePage;
	private LoginPage loginPage;
	private PinPage pinPage;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws EncryptedDocumentException, IOException
	{

		System.out.println("Before Test");
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=launchChromeBrowser();
		}
		if(browser.equalsIgnoreCase("Edge")) {
			driver=launchEdgeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/");
		loginPage=new LoginPage(driver);
		String userName=Utility.getDataFromExcel("UserNamePass",1,0);
		loginPage.userNameTab(userName);
		
		
	}
	@BeforeClass
	public void createPOMObject()
	{
		homePage=new HomePage(driver);	
		pinPage=new PinPage(driver);
	}
	@BeforeMethod
	public void loginZerodha() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String pass=Utility.getDataFromExcel("UserNamePass",1,1);
		loginPage.passwordTab(pass);
		loginPage.logInTab();
		Thread.sleep(1000);
		String pin=Utility.getDataFromExcel("UserNamePass",1,2);
		pinPage.pinTab(pin);
		pinPage.submitButtonTab();
	}
	
	@Test(priority=1)
	public void buyOrderOfTataMotorsCO() throws EncryptedDocumentException, IOException, InterruptedException{
		
		String TataShare=Utility.getDataFromExcel("SharePurchase", 1, 0);
		homePage.clickOnSearchBar(TataShare);
		Thread.sleep(1000);
		homePage.moveOnShare();
		homePage.clickOnbuy();
		Thread.sleep(1000);
		homePage.clickOnIntraDay();
		String qty=Utility.getDataFromExcel("SharePurchase", 1, 1);
		homePage.enterQty(qty);
		Thread.sleep(1000);
		homePage.clickOnStopLoss();
		Thread.sleep(1000);
		String price=Utility.getDataFromExcel("SharePurchase", 1, 2);
		homePage.enterPrice(price);
		String triggerPrice=Utility.getDataFromExcel("SharePurchase", 1, 3);
		homePage.enterPrice(triggerPrice);
		homePage.clickOnCancel();
		System.out.println("Oreder Executed");
		
	}
	
	@Test(priority=2)
	public void buyOrderOfDixonTech(){
		
	}
	
	@AfterMethod
	public void logOutZerodha(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeSnapshot(driver, TestID);
		}
		
		homePage.clickOnAccountTab();
		Thread.sleep(1500);
		homePage.clickOnLogOutTab();
	
	}
	
	@AfterClass
	public void deletePOMObject() {
		homePage=null;
		pinPage=null;
		loginPage=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		driver=null;
		System.gc();
		
	}

}
