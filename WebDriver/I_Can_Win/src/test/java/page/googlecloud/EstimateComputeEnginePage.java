package page.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimateComputeEnginePage {

	@FindBy(css = "md-list-item[ng-if*=initialInputs]")
	public WebElement vMClassFieldInComputeEngineForm;

	@FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[3]")
	public WebElement instanceTypeFieldInComputeEngineForm;

	@FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[4]")
	public WebElement regionFieldInComputeEngineForm;

	@FindBy(css = "md-list-item[ng-if*=ssd]")
	public WebElement availableSSDFieldInComputeEngineForm;

	@FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[6]")
	public WebElement commitmentFieldInComputeEngineForm;

	@FindBy(css = "b[class=ng-binding]")
	public WebElement totalCostFieldInComputeEngineForm;

	public EstimateComputeEnginePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
