package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_HubungiKami extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_HubungiKami() throws InterruptedException {
		Assertion assertion = new Assertion();
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		click.clickBtnLainnya();
		click.clickBtnHubungiKami();
		click.clickExitPopUpCCare();
		Thread.sleep(5000);
		assertion.assertTextHubungiKami();
		click.clickPertanyaanEnglish();
		assertion.assertTextContactUs();
		Thread.sleep(3000);
	}
	
}
