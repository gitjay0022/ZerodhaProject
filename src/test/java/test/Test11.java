package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.Browser;
import pom.HomePage;
import pom.LoginPage;
import pom.PinPage;
import utils.Utility;

public class Test11 extends Browser {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		String jay = "Jay Loharkar";
		HomePage homePage;
		LoginPage loginPage;
		PinPage pinPage;
		System.setProperty("webdriver.chrome.driver",
				"E:\\Software Testing\\Automation Tool\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		homePage = new HomePage(driver);
		pinPage = new PinPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/");
		loginPage = new LoginPage(driver);
		String userName = Utility.getDataFromExcel("UserNamePass", 1, 0);
		loginPage.userNameTab(userName);
		String pass = Utility.getDataFromExcel("UserNamePass", 1, 1);
		loginPage.passwordTab(pass);
		loginPage.logInTab();
		Thread.sleep(1000);
		String pin = Utility.getDataFromExcel("UserNamePass", 1, 2);
		pinPage.pinTab(pin);
		pinPage.submitButtonTab();
		String TataShare = Utility.getDataFromExcel("SharePurchase", 1, 0);
		homePage.clickOnSearchBar(TataShare);
		Thread.sleep(1000);
		homePage.moveOnShare();
		homePage.clickOnbuy();
		Thread.sleep(1000);
		homePage.clickOnIntraDay();
		String qty = Utility.getDataFromExcel("SharePurchase", 1, 1);
		homePage.enterQty(qty);
		Thread.sleep(1000);
		homePage.clickOnStopLoss();
		Thread.sleep(1000);
		String price = Utility.getDataFromExcel("SharePurchase", 1, 2);
		homePage.enterPrice(price);
		String triggerPrice = Utility.getDataFromExcel("SharePurchase", 1, 3);
		homePage.enterPrice(triggerPrice);
		homePage.clickOnCancel();
		System.out.println("Oreder Executed");

	}
}
