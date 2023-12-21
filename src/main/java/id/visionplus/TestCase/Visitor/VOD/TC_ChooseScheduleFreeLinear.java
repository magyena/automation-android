package id.visionplus.TestCase.Visitor.VOD;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_ChooseScheduleFreeLinear extends BaseTest {
	
	@Test
	public void TC_ChooseScheduleFreeLinear() throws InterruptedException {
		
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
		click.clickBtnFreeLinearAntv();
		test.pass("User berhasil Klik Button ANTV");
		Thread.sleep(20000);
		
		click.clickBtnChromeCast();
		test.pass("User berhasil Klik Button Chromecast");
		click.clickBtnDataSaver();
		test.pass("User berhasil Klik Button Data Saver");
		click.clickBtnSchedule();
		test.pass("User berhasil Klik Button Schedule");
		Thread.sleep(3000);
		click.clickBtnScheduleCatchup();
		test.pass("User berhasil Choose Schedule");
		Thread.sleep(3000);
		assertion.assertErrorChooseSchedule();
	}

}
