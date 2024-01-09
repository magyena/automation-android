package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_Access_GamesPlus_Detail extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Access_GamesPlus_Detail() throws InterruptedException {	
		click.clickGamesPlusDetailsSlider();
		test.pass("User berhasil Klik menu GamesPlus Details");
		
		Thread.sleep(5000);
		
		Assertion assertion = new Assertion();
		assertion.assertGamesPlusDetailsPage();
	}
	
}
