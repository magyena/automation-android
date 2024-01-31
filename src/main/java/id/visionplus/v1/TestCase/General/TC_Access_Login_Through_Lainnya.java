package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_Access_Login_Through_Lainnya extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Access_Login_Through_Lainnya() throws InterruptedException {
		Assertion assertion = new Assertion();
		click.lainnyaButton();
		test.pass("User berhasil ke Halaman Lainnya");
		click.clickMasukButton();
		test.pass("User berhasil ke Halaman Login");
		
		//In Login Page
		Thread.sleep(3000);
		assertion.assertLoginPage();
		test.pass("Assert Halaman Login Berhasil");

	}
	
}
