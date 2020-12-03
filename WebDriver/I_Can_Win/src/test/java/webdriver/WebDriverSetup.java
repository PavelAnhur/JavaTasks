package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetup {

	private WebDriver driver;

	public WebDriverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
