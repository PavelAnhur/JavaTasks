package test.icanwin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.PastebinPage;
import webdriver.WebDriverSetup;

import java.util.concurrent.TimeUnit;

public class TestPastebinPageICanWin {

	private WebDriver testDriver;
	private PastebinPage pastebinPage;

	@Before
	public void setupClass() {
		testDriver = WebDriverSetup.getDriver();
		pastebinPage = new PastebinPage(testDriver);
		testDriver.get("https://pastebin.com");
		testDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testDriver.manage().window().maximize();
	}

	@Test
	public void pastebinTest() {

		pastebinPage.textArea.sendKeys("Hello from WebDriver");
		pastebinPage.pasteExpirationDropdown.click();
		pastebinPage.tenMinutesOption.click();
		pastebinPage.pasteNameInput.sendKeys("helloweb");
		pastebinPage.createNewPasteButton.click();
	}

	@After
	public void quitDriver() {
		testDriver.quit();
	}
}
