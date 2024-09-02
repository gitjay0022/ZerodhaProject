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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.HomePage;
import pom.LoginPage;
import pom.PinPage;

import utils.Utility;

public class AplicationHeaderVeification extends Browser {
	private WebDriver driver;
	private int TestID;
	private HomePage homePage;
	private LoginPage loginPage;
	private PinPage pinPage;
	private SoftAssert softAssert;
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
	public void verifyAccHolderName(){
		TestID=106;
		homePage.clickOnDashboardTab();
		String AccName=homePage.verifyDematAccName();
		
		softAssert=new SoftAssert();
		softAssert.assertEquals(AccName,"Akshay", "URl fail");
		
		softAssert.assertAll();
	}
	@Test(priority=6)
	public void verifyHoldingsTab(){
		TestID=106;
		homePage.clickOnHoldingsTab();
		String Url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		softAssert=new SoftAssert();
		softAssert.assertEquals(Url,"https://kite.zerodha.com/holdings", "URl fail");
		softAssert.assertEquals(Title, "Holdings / Kite","Title is Fail");
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void verifyOrdersTab(){
		TestID=102;
		homePage.clickOnOrdersTab();
		String Url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		softAssert=new SoftAssert();
		softAssert.assertEquals(Url,"https://kite.zerodha.com/orders", "URl fail");
		softAssert.assertEquals(Title, "Orders / Kite","Title is Fail");
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void verifyPositionTab(){
		TestID=103;
		homePage.clickOnPositionsTab();
		String Url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		softAssert=new SoftAssert();
		softAssert.assertEquals(Url,"https://kite.zerodha.com/positions", "URl fail");
		softAssert.assertEquals(Title, "Positions / Kite","Title is Fail");
		softAssert.assertAll();
	}
	
	@Test(priority=4)
	public void verifyDashBoardTab(){
		TestID=104;
		homePage.clickOnDashboardTab();
		String Url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		softAssert=new SoftAssert();
		softAssert.assertEquals(Url,"https://kite.zerodha.com/dashboard", "URl fail");
		softAssert.assertEquals(Title, "Dashboard / Kite","Title is Fail");
		softAssert.assertAll();
	}
	

	@Test(priority=5)
	public void verifyFundsTab(){
		TestID=105;
		homePage.clickOnFundsTab();
		String Url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		softAssert=new SoftAssert();
		softAssert.assertEquals(Url,"https://kite.zerodha.com/funds", "URl fail");
		softAssert.assertEquals(Title, "Funds / Kite","Title is Fail");
		softAssert.assertAll();
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
		System.out.println("Test Execution Done");
		driver.quit();
		driver=null;
		System.gc();
		
	}

}
