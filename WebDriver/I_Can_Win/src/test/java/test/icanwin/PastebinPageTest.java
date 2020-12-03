package test.icanwin;

import org.openqa.selenium.WebDriver;
import page.PastebinPage;
import webdriver.WebDriverSetup;

import java.util.concurrent.TimeUnit;

public class PastebinPageTest {
	public static void main(String[] args) {
		WebDriver testDriver = new WebDriverSetup().getDriver();
		testDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PastebinPage pastebinPage = new PastebinPage(testDriver);

		testDriver.manage().window().maximize();
		pastebinPage.textArea.sendKeys("Hello from WebDriver");
		pastebinPage.pasteExpirationDropdown.click();
		pastebinPage.tenMinutesOption.click();
		pastebinPage.pasteNameInput.sendKeys("helloweb");
		pastebinPage.createNewPasteButton.click();
		testDriver.quit();
	}
}
