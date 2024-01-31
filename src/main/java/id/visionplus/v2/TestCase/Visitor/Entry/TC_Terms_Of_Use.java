package id.visionplus.v2.TestCase.Visitor.Entry;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Terms_Of_Use extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	
	@Test
	public void TC_Open_Terms_Of_Use() throws InterruptedException, TimeoutException {
		click.clickTerms();
		test.pass("Successfully Clicked Terms of Use Button");
		Thread.sleep(3000);
		assertion.assertTermsOfUsePageInd();
		test.pass("Successfully Assert Terms of Use Page");
		click.pressBack();
		test.pass("Successfully Clicked Back to Entry Page");
	}
}