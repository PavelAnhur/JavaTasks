package page.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPage {

	@FindBy(xpath = "//input[@name='q']")
	public WebElement searchField;

	public GoogleCloudPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
