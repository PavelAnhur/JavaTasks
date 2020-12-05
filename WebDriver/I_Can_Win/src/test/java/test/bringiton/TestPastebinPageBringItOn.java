package test.bringiton;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import page.PastebinPage;
import page.PastebinPageResult;
import webdriver.WebDriverSetup;

import java.util.concurrent.TimeUnit;

public class TestPastebinPageBringItOn {

	private WebDriver testDriver;
	private PastebinPage pastebinPage;
	private PastebinPageResult pastebinPageResult;

	@Before
	public void setupClass() {
		testDriver = WebDriverSetup.getDriver();
		pastebinPage = new PastebinPage(testDriver);
		testDriver.get("https://pastebin.com");
		testDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testDriver.manage().window().maximize();
		pastebinPageResult = new PastebinPageResult(testDriver);
	}

	@Test
	public void pastebinTest() {

		String codeInTextArea = "git config --global user.name  \"New Sheriff in Town\"\n" +
				"git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
				"git push origin master --force";
		pastebinPage.textArea.sendKeys(codeInTextArea);
		pastebinPage.syntaxHighlightingDropdown.click();
		pastebinPage.bashOption.sendKeys("Bash");
		pastebinPage.bashOption.sendKeys(Keys.ENTER);
		pastebinPage.syntaxHighlightingSelector.click();
		pastebinPage.pasteExpirationDropdown.click();
		pastebinPage.tenMinutesOption.click();
		pastebinPage.pasteNameInput.sendKeys("how to gain dominance among developers");
		pastebinPage.createNewPasteButton.click();

		Assert.assertEquals("how to gain dominance among developers", pastebinPageResult.headingInfoPastebinPage.getText());
		Assert.assertTrue(pastebinPageResult.bashSyntax.isDisplayed());
		Assert.assertEquals(codeInTextArea, pastebinPageResult.getCodeFromTextArea());
	}

	@After
	public void teardown() {
		if (testDriver != null) {
			testDriver.quit();
		}
	}
}
