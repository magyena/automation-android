package id.visionplus.v2.TestCase.Visitor.Entry;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Privacy_Policy extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	
	@Test
	public void TC_Open_Privacy_Policy() throws InterruptedException, TimeoutException {
		click.clickPrivacy();
		test.pass("Successfully Clicked Privacy Policy Button");
		Thread.sleep(3000);
		assertion.assertPrivacyPolicyPageInd();
		test.pass("Successfully Assert Privacy Policy Page");
		click.pressBack();
		test.pass("Successfully Clicked Back to Entry Page");
	}
}
