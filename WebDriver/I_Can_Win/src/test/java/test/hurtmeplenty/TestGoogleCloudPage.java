package test.hurtmeplenty;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import step.HurtMePlentySteps;

import static webdriver.WebDriverSetup.getDriver;

public class TestGoogleCloudPage {

	private HurtMePlentySteps hurtMePlentySteps;

	@Before
	public void setupClass() {
		hurtMePlentySteps = new HurtMePlentySteps(getDriver());
		hurtMePlentySteps.openGoogleCloudPage();
	}

	@Test
	public void googleCloudTest() {
		hurtMePlentySteps.openPricingCalculator();
		hurtMePlentySteps.switchToCalculatorFrame();
		hurtMePlentySteps.inputNumberOfInstances("4");
		hurtMePlentySteps.selectSeries();
		hurtMePlentySteps.selectMachineType();
		hurtMePlentySteps.addGPU();
		hurtMePlentySteps.addSSD();
		hurtMePlentySteps.selectDatacenterLocation();
		hurtMePlentySteps.selectCommittedUsage();
		hurtMePlentySteps.pressAddToEstimate();
		hurtMePlentySteps.openEstimateComputeEngine();

		Assert.assertEquals("VM class: regular", hurtMePlentySteps.getTextFromVMClassField());
		Assert.assertEquals("Instance type: n1-standard-8", hurtMePlentySteps.getTextFromInstanceTypeField());
		Assert.assertEquals("Region: Frankfurt", hurtMePlentySteps.getTextFromRegionField());
		Assert.assertEquals("Total available local SSD space 2x375 GiB", hurtMePlentySteps.getTextFromAvailableSSDField());
		Assert.assertEquals("Commitment term: 1 Year", hurtMePlentySteps.getTextFromCommitmentField());
		Assert.assertEquals("Estimated Component Cost: USD 1,082.77 per 1 month", hurtMePlentySteps.getTotalEstimatedCost());
	}

	@After
	public void teardown() {
		hurtMePlentySteps.quitDriver();
		hurtMePlentySteps = null;
	}
}
