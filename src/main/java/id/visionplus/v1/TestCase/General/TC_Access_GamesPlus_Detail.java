package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_Access_GamesPlus_Detail extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Access_GamesPlus_Detail() throws InterruptedException {	
		Thread.sleep(5000);
		
		click.clickGamesPlusDetailsSlider();
		test.pass("User berhasil Klik menu GamesPlus Details");
		
		Thread.sleep(5000);
		
//		Assertion assertion = new Assertion();
//		assertion.assertGamesPlusDetailsPage();
//		test.pass("GamesPlus Details Page Berhasil di Assert");
	}
	
}
