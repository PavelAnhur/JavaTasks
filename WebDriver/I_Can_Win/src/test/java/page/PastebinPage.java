package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPage {

	@FindBy(id = "postform-text")
	public WebElement textArea;

	@FindBy(id = "select2-postform-expiration-container")
	public WebElement pasteExpirationDropdown;

	@FindBy(xpath = "//li[text()='10 Minutes']")
	public WebElement tenMinutesOption;

	@FindBy(id = "select2-postform-format-container")
	public WebElement syntaxHighlightingDropdown;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	public WebElement bashOption;

	@FindBy(xpath = "//*[@id='w0']/div[2]/div/div/div/label")
	public WebElement syntaxHighlightingSelector;

	@FindBy(id = "postform-name")
	public WebElement pasteNameInput;

	@FindBy(css = "button.btn")
	public WebElement createNewPasteButton;

	public PastebinPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
