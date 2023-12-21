package id.visionplus.TestCase.Visitor.Package;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_PackageAssert extends BaseTest{
	
	@Test
	public void TC_PackageAssert() throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();
		
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		Thread.sleep(3000);
		click.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		Thread.sleep(3000);
		click.lainnyaButton();
		test.pass("User berhasil Klik Pengaturan");
		Thread.sleep(3000);

		Thread.sleep(3000);
		click.clickPaketButton();
		test.pass("User berhasil Klik Button Paket");
		assertion.assertTextPremiumSport();
		click.clickBtnTextPremium();
		test.pass("User berhasil Klik Premium");
		assertion.assertTextPremium();
		test.pass("Assert sesuai");
	}
	
}
