package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.Action.Scroll;
import id.visionplus.MainFunction.BaseTest;

public class TC_SportsAiring extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	@Test
	public void TC_SportsAiring() throws InterruptedException {
		Scroll scroll = new Scroll(android);
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik Skip button");
		Thread.sleep(3000);
		click.clickButtonSport();
		test.pass("user berhasil Klik Sport Button");
		scroll.scrollDown(0.04);
	    Thread.sleep(3000);
		test.pass("user berhasil Scrolldown SportPage");
		click.clickAdsSportPage();
	    Thread.sleep(3000);
		click.clickAiringTodaySportChannel();
	}
	
}
