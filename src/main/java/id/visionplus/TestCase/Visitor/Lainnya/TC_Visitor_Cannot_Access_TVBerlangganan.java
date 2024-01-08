package id.visionplus.TestCase.Visitor.Lainnya;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.TestCase.General.*;

public class TC_Visitor_Cannot_Access_TVBerlangganan extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Visitor_Cannot_Access_TvBerlangganan() throws InterruptedException {
		Assertion assertion = new Assertion();
		TC_Access_TVBerlangganan access_tv_berlangganan = new TC_Access_TVBerlangganan();
		//call test case accessing to TV Berlangganan Page
		access_tv_berlangganan.TC_TVBerlangganan();
		Thread.sleep(3000);
		assertion.assertLoginPage();
	}
}
