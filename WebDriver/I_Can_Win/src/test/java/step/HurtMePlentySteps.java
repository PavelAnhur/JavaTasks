package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.GoogleCloudPage;
import page.GoogleCloudPricingCalculatorPage;
import page.GoogleCloudResultPage;
import page.EstimateComputeEnginePage;

public class HurtMePlentySteps {

	private final WebDriver webDriver;
	private GoogleCloudPage googleCloudPage;
	private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;
	private final WebDriverWait wait;
	private EstimateComputeEnginePage estimatePage;


	public HurtMePlentySteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		webDriver.manage().window().maximize();
		wait = new WebDriverWait(webDriver, 5);
	}

	public void openGoogleCloudPage() {
		googleCloudPage = new GoogleCloudPage(webDriver);
		webDriver.get("https://cloud.google.com/");
	}

	public void openPricingCalculator() {
		googleCloudPage.searchField.sendKeys("Google Cloud Platform Pricing Calculator");
		googleCloudPage.searchField.submit();
		GoogleCloudResultPage googleCloudResultPage = new GoogleCloudResultPage(webDriver);
		wait.until(ExpectedConditions
				.visibilityOf(googleCloudResultPage.searchResult));
		googleCloudResultPage.searchResult.click();
	}

	public void switchToCalculatorFrame() {
		googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(webDriver);
		webDriver.switchTo().frame(googleCloudPricingCalculatorPage.calculatorIFrame)
				.switchTo().frame(googleCloudPricingCalculatorPage.myFrame);
	}

	public void inputNumberOfInstances(String number) {
		googleCloudPricingCalculatorPage.inputNumberOfInstances.click();
		googleCloudPricingCalculatorPage.inputNumberOfInstances.sendKeys(number);
	}

	public void selectSeries() {
		googleCloudPricingCalculatorPage.seriesSelectField.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.seriesSelectedOptions));
		googleCloudPricingCalculatorPage.seriesSelectedOptions.click();
	}

	public void selectMachineType() {
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.machineTypeSelectedField));
		googleCloudPricingCalculatorPage.machineTypeSelectedField.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.machineTypeSelect));
		googleCloudPricingCalculatorPage.machineTypeSelect.click();
	}

	public void addGPU() {
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.addGPUCheckbox));
		googleCloudPricingCalculatorPage.addGPUCheckbox.click();
		googleCloudPricingCalculatorPage.numberOfGPUDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.chooseNumberOfGPU));
		googleCloudPricingCalculatorPage.chooseNumberOfGPU.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.gPUTypeDropdown));
		googleCloudPricingCalculatorPage.gPUTypeDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.chooseGPUType));
		googleCloudPricingCalculatorPage.chooseGPUType.click();
	}

	public void addSSD() {
		googleCloudPricingCalculatorPage.localSSDDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.chooseLocalSSDNumber));
		googleCloudPricingCalculatorPage.chooseLocalSSDNumber.click();
	}

	public void selectDatacenterLocation() {
		googleCloudPricingCalculatorPage.datacenterLocationDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.datacenterLocationChoice));
		googleCloudPricingCalculatorPage.datacenterLocationChoice.click();
	}

	public void selectCommittedUsage() {
		googleCloudPricingCalculatorPage.committedUsageDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(googleCloudPricingCalculatorPage.committedUsageChoice));
		googleCloudPricingCalculatorPage.committedUsageChoice.click();
	}

	public void pressAddToEstimate() {
		googleCloudPricingCalculatorPage.addToEstimateButton.click();
	}

	public void openEstimateComputeEngine() {
		estimatePage = new EstimateComputeEnginePage(webDriver);
	}

	public String getTextFromVMClassField() {
		return estimatePage.vMClassFieldInCompueEngineForm.getText();
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
