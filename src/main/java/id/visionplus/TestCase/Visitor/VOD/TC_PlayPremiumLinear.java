package id.visionplus.TestCase.Visitor.VOD;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_PlayPremiumLinear extends BaseTest{
	
	@Test
	public void TC_PlayPremiumLinear() throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();
		
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
