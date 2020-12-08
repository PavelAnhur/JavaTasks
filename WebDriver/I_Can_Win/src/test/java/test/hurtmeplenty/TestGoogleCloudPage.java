package test.hurtmeplenty;

import org.junit.After;
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void teardown() {
		hurtMePlentySteps.quitDriver();
		hurtMePlentySteps = null;
	}
}
