package page.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculatorPage {

	@FindBy(id = "input_62")
	public WebElement inputNumberOfInstances;

	@FindBy(css = "iframe[src*=calculator]")
	public WebElement calculatorIFrame;

	@FindBy(id = "myFrame")
	public WebElement myFrame;

	@FindBy(css = "md-select[ng-change*=Series]")
	public WebElement seriesSelectField;

	@FindBy(css = "md-option[value=n1]")
	public WebElement seriesSelectedOptions;

	@FindBy(css = "md-select[ng-change*='Compute']")
	public WebElement machineTypeSelectedField;

	@FindBy(css = "md-option[value$=STANDARD-8]")
	public WebElement machineTypeSelect;

	@FindBy(css = "div[class=md-label]")
	public WebElement addGPUCheckbox;

	@FindBy(css = "md-select[ng-model$=gpuCount]")
	public WebElement numberOfGPUDropdown;

	@FindBy(css = "div.md-clickable md-select-menu md-content md-option[value=\"1\"]")
	public WebElement chooseNumberOfGPU;

	@FindBy(css = "md-select[placeholder='GPU type']")
	public WebElement gPUTypeDropdown;

	@FindBy(css = "div.md-clickable md-select-menu md-content md-option[value=\"NVIDIA_TESLA_P4\"]")
	public WebElement chooseGPUType;

	@FindBy(css = "md-select[placeholder='Local SSD']")
	public WebElement localSSDDropdown;

	@FindBy(css = "div.md-clickable md-select-menu md-content md-option[value=\"2\"]")
	public WebElement chooseLocalSSDNumber;

	@FindBy(css = "md-select[placeholder=\"Datacenter location\"]")
	public WebElement datacenterLocationDropdown;

	@FindBy(css = "div.md-clickable md-select-menu md-content md-option[value=\"europe-west3\"]")
	public WebElement datacenterLocationChoice;

	@FindBy(css = "md-select[placeholder=\"Committed usage\"]")
	public WebElement committedUsageDropdown;

	@FindBy(css = "div.md-clickable md-select-menu md-content md-option[value=\"1\"]")
	public WebElement committedUsageChoice;

	@FindBy(xpath = "//button[@aria-label='Add to Estimate']")
	public WebElement addToEstimateButton;

	public GoogleCloudPricingCalculatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
