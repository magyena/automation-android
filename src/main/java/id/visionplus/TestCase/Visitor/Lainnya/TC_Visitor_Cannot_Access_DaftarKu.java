package id.visionplus.TestCase.Visitor.Lainnya;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.TestCase.General.*;

public class TC_Visitor_Cannot_Access_DaftarKu extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Visitor_Cannot_Access_DaftarKu() throws InterruptedException {
		Assertion assertion = new Assertion();
		TC_Access_DaftarKu access_DaftarKu = new TC_Access_DaftarKu();
		//Call test case accessing to DaftarKu Page
		access_DaftarKu.TC_Access_DaftarKu();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();
	}
}
