package step;

import org.openqa.selenium.WebDriver;
import page.googlecloud.EstimateComputeEnginePage;
import page.googlecloud.GoogleCloudPage;
import page.googlecloud.GoogleCloudPricingCalculatorPage;
import page.googlecloud.GoogleCloudResultPage;

import static waitmanager.WaitManager.waitForElementVisibility;

public class Steps {

	private final WebDriver webDriver;
	private GoogleCloudPage googleCloudPage;
	private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;
	private EstimateComputeEnginePage estimatePage;


	public Steps(WebDriver webDriver) {
		this.webDriver = webDriver;
		webDriver.manage().window().maximize();
	}

	public void openGoogleCloudPage() {
		googleCloudPage = new GoogleCloudPage(webDriver);
		webDriver.get("https://cloud.google.com/");
	}

	public Steps openPricingCalculator() {
		googleCloudPage.searchField.sendKeys("Google Cloud Platform Pricing Calculator");
		googleCloudPage.searchField.submit();
		GoogleCloudResultPage googleCloudResultPage = new GoogleCloudResultPage(webDriver);
		waitForElementVisibility(googleCloudResultPage.searchResult);
		googleCloudResultPage.searchResult.click();
		return this;
	}

	public Steps switchToCalculatorFrame() {
		googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(webDriver);
		webDriver.switchTo().frame(googleCloudPricingCalculatorPage.calculatorIFrame)
				.switchTo().frame(googleCloudPricingCalculatorPage.myFrame);
		return this;
	}

	public Steps inputNumberOfInstances(String number) {
		googleCloudPricingCalculatorPage.inputNumberOfInstances.click();
		googleCloudPricingCalculatorPage.inputNumberOfInstances.sendKeys(number);
		return this;
	}

	public Steps selectSeries() {
		googleCloudPricingCalculatorPage.seriesSelectField.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.seriesSelectedOptions);
		googleCloudPricingCalculatorPage.seriesSelectedOptions.click();
		return this;
	}

	public Steps selectMachineType() {
		waitForElementVisibility(googleCloudPricingCalculatorPage.machineTypeSelectedField);
		googleCloudPricingCalculatorPage.machineTypeSelectedField.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.machineTypeSelect);
		googleCloudPricingCalculatorPage.machineTypeSelect.click();
		return this;
	}

	public Steps addGPU() {
		waitForElementVisibility(googleCloudPricingCalculatorPage.addGPUCheckbox);
		googleCloudPricingCalculatorPage.addGPUCheckbox.click();
		googleCloudPricingCalculatorPage.numberOfGPUDropdown.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.chooseNumberOfGPU);
		googleCloudPricingCalculatorPage.chooseNumberOfGPU.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.gPUTypeDropdown);
		googleCloudPricingCalculatorPage.gPUTypeDropdown.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.chooseGPUType);
		googleCloudPricingCalculatorPage.chooseGPUType.click();
		return this;
	}

	public Steps addSSD() {
		googleCloudPricingCalculatorPage.localSSDDropdown.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.chooseLocalSSDNumber);
		googleCloudPricingCalculatorPage.chooseLocalSSDNumber.click();
		return this;
	}

	public Steps selectDatacenterLocation() {
		googleCloudPricingCalculatorPage.datacenterLocationDropdown.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.datacenterLocationChoice);
		googleCloudPricingCalculatorPage.datacenterLocationChoice.click();
		return this;
	}

	public Steps selectCommittedUsage() {
		googleCloudPricingCalculatorPage.committedUsageDropdown.click();
		waitForElementVisibility(googleCloudPricingCalculatorPage.committedUsageChoice);
		googleCloudPricingCalculatorPage.committedUsageChoice.click();
		return this;
	}

	public Steps pressAddToEstimate() {
		googleCloudPricingCalculatorPage.addToEstimateButton.click();
		return this;
	}

	public void openEstimateComputeEngine() {
		estimatePage = new EstimateComputeEnginePage(webDriver);
	}

	public String getTextFromVMClassField() {
		return estimatePage.vMClassFieldInComputeEngineForm.getText();
	}

	public String getTextFromInstanceTypeField() {
		return estimatePage.instanceTypeFieldInComputeEngineForm.getText();
	}

	public String getTextFromRegionField() {
		return estimatePage.regionFieldInComputeEngineForm.getText();
	}

	public String getTextFromAvailableSSDField() {
		return estimatePage.availableSSDFieldInComputeEngineForm.getText();
	}

	public String getTextFromCommitmentField() {
		return estimatePage.commitmentFieldInComputeEngineForm.getText();
	}

	public String getTotalEstimatedCost() {
		return estimatePage.totalCostFieldInComputeEngineForm.getText();
	}

	public void quitDriver() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
