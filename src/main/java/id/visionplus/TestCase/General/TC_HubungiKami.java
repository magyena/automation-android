package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_HubungiKami extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_HubungiKami() throws InterruptedException {
		
		Assertion assertion = new Assertion();
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
//		click.lainnyaButton();
//		test.pass("User berhasil Klik menu Lainnya");
//		click.clickBtnLainnya();
//		click.clickBtnHubungiKami();
//		Thread.sleep(3000);
//		assertion.assertTextHubungiKami();
//		click.clickPertanyaanEnglish();
//		assertion.assertTextContactUs();
//		Thread.sleep(3000);
		
	}
	
}
