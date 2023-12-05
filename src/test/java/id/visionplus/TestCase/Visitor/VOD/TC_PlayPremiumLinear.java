package id.visionplus.TestCase.Visitor.VOD;

import org.testng.annotations.Test;

import id.visionplus.BaseTest;
import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;

public class TC_PlayPremiumLinear extends BaseTest{
	
	@Test
	public void TC_PlayPremiumLinear() throws InterruptedException {
		Click click = new Click(android);
		Assertion assertion = new Assertion(android);
		
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		click.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		click.clickBtnTVku();
		test.pass("User berhasil Klik Button TV ku");

		click.clickBtnPremiumLinearTransTV();
		test.pass("User berhasil Klik Premium Linear");
		assertion.assertErrorSubcriptionPremiumLinear();
		test.pass("Assert sesuai!");
		Thread.sleep(3000);
	}

}
