package id.visionplus.v1.TestCase.Visitor.VOD;

import java.time.Duration;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.Action.Scroll;
import id.visionplus.v1.MainFunction.*;
import id.visionplus.v1.PageObjects.HomePageVisionPlus;
import id.visionplus.v1.PageObjects.VODPage;

public class TC_PlayFreeVOD extends BaseTest{
	
	@Test
	public void TC_PlayFreeVOD() throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();
		Scroll scroll = new Scroll(android);

		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		click.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		scroll.scrollDown(0.37);

		click.clickPremiumVOD();
		Thread.sleep(2000);
		scroll.scrollDown(0.3);
		click.clickEps1VOD();
		Thread.sleep(15000);
		click.clickBtnChromeCast();
		test.pass("User berhasil Klik Button Chromecast");
		click.clickBtnDataSaver();
		test.pass("User berhasil Klik Button Data Saver");
		android.manage().timeouts().implicitlyWait(Duration.ofMinutes(11));
		Thread.sleep(5000);
		assertion.assertErrorSubcriptionPremiumLinear();
		test.pass("Assert sesuai");
	}

}
