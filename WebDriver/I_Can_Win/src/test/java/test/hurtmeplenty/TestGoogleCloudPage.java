package test.hurtmeplenty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.GoogleCloudPage;
import page.GoogleCloudPricingCalculatorPage;
import page.GoogleCloudResultPage;
import webdriver.WebDriverSetup;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGoogleCloudPage {

	private WebDriver webDriver;
	private GoogleCloudPage googleCloudPage;
	private GoogleCloudResultPage googleCloudResultPage;
	private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;

	@Before
	public void setupClass() {
		webDriver = WebDriverSetup.getDriver();
		googleCloudPage = new GoogleCloudPage(webDriver);
		webDriver.get("https://cloud.google.com/");
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		googleCloudResultPage = new GoogleCloudResultPage(webDriver);
		googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(webDriver);
	}

	@Test
	public void googleCloudTest() {
		googleCloudPage.searchField.sendKeys("Google Cloud Platform Pricing Calculator");
		googleCloudPage.searchField.submit();
		List<WebElement> search = googleCloudPage.searchField.findElements(By.linkText("Google Cloud Platform Pricing Calculator"));
		if (!search.isEmpty()) {
			search.get(0).submit();
		}
		googleCloudResultPage.searchResult.click();
		WebDriver frameDriver = webDriver.switchTo().frame(3);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frameDriver.findElement(By.id("input_62")).click();
		frameDriver.findElement(By.id("input_62")).sendKeys("4");
//		googleCloudPricingCalculatorPage.inputNumberOfInstances.click();
//		googleCloudPricingCalculatorPage.inputNumberOfInstances.sendKeys("4");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void teardown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
