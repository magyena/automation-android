package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_Access_TVBerlangganan extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_TVBerlangganan() throws InterruptedException {
		click.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		click.clickBtnTvBerlangganan();
		test.pass("Accessing Tv Berlangganan Successful");
	}
	
}
