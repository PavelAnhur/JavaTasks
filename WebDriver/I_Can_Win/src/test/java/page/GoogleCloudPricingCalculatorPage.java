package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculatorPage {

	@FindBy (id = "input_62")
	public WebElement inputNumberOfInstances;

	@FindBy (css = "iframe[src*=calculator]")
	public WebElement calculatorIFrame;

	public GoogleCloudPricingCalculatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
