package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.Action.Scroll;
import id.visionplus.v1.MainFunction.*;

public class TC_Access_SportsPage extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	@Test
	public void TC_SportsPage() throws InterruptedException {
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik Skip button");
		Thread.sleep(3000);
		click.clickButtonSport();
		test.pass("user berhasil Klik Sport Button");
	}
	
}
