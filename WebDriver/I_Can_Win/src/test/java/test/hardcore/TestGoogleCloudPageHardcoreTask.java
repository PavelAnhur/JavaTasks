package test.hardcore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import step.Steps;

import static webdriver.WebDriverSetup.getDriver;

public class TestGoogleCloudPageHardcoreTask {

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
		String totalCostEstimateCost = steps.getTotalEstimateCost();
		System.out.println(totalCostEstimateCost);
		steps.addTenMinutesEMailTab()
				.getMailAddressFromTenMinutesMailSite()
				.inputMailAddressIntoEstimateForm()
				.getMailOnTenMinutesMailBox();
		String estimateCostFromMail = steps.getEstimateCostFromMail();
		System.out.println(estimateCostFromMail);

		Assert.assertEquals(totalCostEstimateCost, estimateCostFromMail);
	}

	@After
	public void teardown() {
		steps.quitDriver();
		steps = null;
	}
}
