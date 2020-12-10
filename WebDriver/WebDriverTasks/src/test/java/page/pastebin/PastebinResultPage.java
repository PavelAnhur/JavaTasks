package page.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinResultPage {

	@FindBy(xpath = "//div[@class='info-top']")
	public WebElement headingInfoPastebinPage;

	@FindBy(xpath = "//a[text()='Bash']")
	public WebElement bashSyntax;

	@FindBy(css = "textarea.textarea")
	public WebElement inputTextArea;

	public String getCodeFromTextArea() {
		return inputTextArea.getText();
	}

	public PastebinResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
