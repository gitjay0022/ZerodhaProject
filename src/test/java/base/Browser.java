package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	public static WebDriver launchChromeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Software Testing\\Automation Tool\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	public static WebDriver launchEdgeBrowser() {

		System.setProperty("webdriver.edge.driver",
				"E:\\Software Testing\\Automation Tool\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		return driver;

	}

}
