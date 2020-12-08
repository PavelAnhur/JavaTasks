package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudResultPage {

	@FindBy(css = "a[data-ctorig$=calculator]")
	public WebElement searchResult;

	public GoogleCloudResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
