package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_Pertanyaan extends BaseTest{

	@Test
	public void TC_Pertanyaan() throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();

		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		click.clickBtnLainnya();
		Thread.sleep(3000);
		click.clickBtnPertanyaan();
		Thread.sleep(8000);
		assertion.assertTextRegistrasi();
		Thread.sleep(3000);
		click.clickPertanyaanEnglish();
		assertion.assertTextRegistration();
		Thread.sleep(3000);
	}
}
