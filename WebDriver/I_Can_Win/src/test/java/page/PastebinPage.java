package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinPage {

	private WebDriver driver;

	@FindBy(xpath = "//*[@id='postform-text']")
	public WebElement textArea;

	@FindBy(id = "select2-postform-expiration-container")
	public WebElement pasteExpirationDropdown;

	@FindBy(xpath = "//li[text()='10 Minutes']")
	public WebElement tenMinutesOption;

	@FindBy(id = "postform-name")
	public WebElement pasteNameInput;

	@FindBy(css = "button.btn")
	public WebElement createNewPasteButton;

	public PastebinPage(WebDriver driver) {
		this.driver = driver;
	}
}
