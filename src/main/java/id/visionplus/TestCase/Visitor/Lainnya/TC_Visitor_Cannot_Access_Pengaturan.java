package id.visionplus.TestCase.Visitor.Lainnya;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.TestCase.General.*;

public class TC_Visitor_Cannot_Access_Pengaturan extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Visitor_Cannot_Access_Pengaturan() throws InterruptedException {
		Assertion assertion = new Assertion();
		TC_Access_Pengaturan access_Pengaturan = new TC_Access_Pengaturan();
		//Call test case accessing to DaftarKu Page
		access_Pengaturan.TC_Access_Pengaturan();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();
	}
}
