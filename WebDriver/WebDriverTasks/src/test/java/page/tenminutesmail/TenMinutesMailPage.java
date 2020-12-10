package page.tenminutesmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinutesMailPage {

	@FindBy(id = "copy_address")
	public WebElement eMailAddress;

	@FindBy(css = "span[class='small_message_icon']")
	public WebElement inboxCount;

	@FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
	public WebElement estimateCosInMail;

	public TenMinutesMailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
