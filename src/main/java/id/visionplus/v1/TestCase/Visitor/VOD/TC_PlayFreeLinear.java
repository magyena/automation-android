package id.visionplus.v1.TestCase.Visitor.VOD;

import java.time.Duration;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;
import id.visionplus.v1.PageObjects.HomePageVisionPlus;
import id.visionplus.v1.PageObjects.VODPage;
import io.appium.java_client.android.AndroidDriver;

public class TC_PlayFreeLinear extends BaseTest{

	@Test
	public void TC_PlayFreeLinear() throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();

		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		click.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		click.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		click.clickBtnTVku();
		test.pass("User berhasil Klik Button TV ku");

		click.clickBtnFreeLinearAntv();
		assertion.assertTitleChannelNationalTV();
		Thread.sleep(15000);
		click.clickBtnChromeCast();
		test.pass("User berhasil Klik Button Chromecast");
		click.clickBtnDataSaver();
		test.pass("User berhasil Klik Button Data Saver");
		android.manage().timeouts().implicitlyWait(Duration.ofMinutes(7));
		assertion.assertErrorSubcriptionPremiumLinear();
	}
	
}
