package id.visionplus.TestCase.Visitor.Lainnya;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.TestCase.General.*;

public class TC_Visitor_Cannot_Access_SportsAiring extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Visitor_Cannot_Access_SportsAiring() throws InterruptedException {
		Assertion assertion = new Assertion();
		TC_Access_SportsAiring access_sports_airing = new TC_Access_SportsAiring();
		//call test case accessing to TV Berlangganan Page
		access_sports_airing.TC_SportsAiring();
		Thread.sleep(5000);
		assertion.assertLoginPopUp();
	}
}
