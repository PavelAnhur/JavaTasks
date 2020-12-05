package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {

	private static WebDriver driver;

	private WebDriverSetup() {
	}

	private static void setupWebDriver() {
		switch (System.getenv("WebDriver")) {
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "Chrome":
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
		}
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			setupWebDriver();
		}
		return driver;
	}
}
