package test.hurtmeplenty;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import step.Steps;

import static webdriver.WebDriverSetup.getDriver;

public class TestGoogleCloudPageHurtMePlentyTask {

	private Steps steps;

	@Before
	public void setupClass() {
		steps = new Steps(getDriver());
		steps.openGoogleCloudPage();
	}

	@Test
	public void googleCloudTest() {
		steps.openPricingCalculator()
				.switchToCalculatorFrame()
				.inputNumberOfInstances("4")
				.selectSeries()
				.selectMachineType()
				.addGPU()
				.addSSD()
				.selectDatacenterLocation()
				.selectCommittedUsage()
				.pressAddToEstimate();

		Assert.assertEquals("VM class: regular", steps.getTextFromVMClassField());
		Assert.assertEquals("Instance type: n1-standard-8", steps.getTextFromInstanceTypeField());
		Assert.assertEquals("Region: Frankfurt", steps.getTextFromRegionField());
		Assert.assertEquals("Total available local SSD space 2x375 GiB", steps.getTextFromAvailableSSDField());
		Assert.assertEquals("Commitment term: 1 Year", steps.getTextFromCommitmentField());
		Assert.assertEquals("1,082.77", steps.getTotalEstimateCost());
	}

	@After
	public void teardown() {
		steps.quitDriver();
		steps = null;
	}
}
