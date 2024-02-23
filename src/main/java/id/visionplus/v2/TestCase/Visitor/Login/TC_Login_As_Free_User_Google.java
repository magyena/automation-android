package id.visionplus.v2.TestCase.Visitor.Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Login_As_Free_User_Google extends BaseTest{
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	
	@Test
	public void TC_Access_to_Login_Page() throws InterruptedException, TimeoutException {		
		click.clickLogin();
		test.pass("Successfully Clicked Login Button");
		
		Thread.sleep(3000);
		
		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Login Page");
	}
	
	
	@Test(dependsOnMethods="TC_Access_to_Login_Page")
	public void TC_user_can_login_with_google_single_sign_on() throws InterruptedException, TimeoutException {		
		click.clickGoogleSingleSignOn();
		test.pass("Successfully Clicked Login by Google Button");
		
		click.click_1st_google_account();
		test.pass("Successfully Clicked 1st Google Account Button");

		assertion.assertArriveHomePage();
		test.pass("Successfully Assert Arrived HomePage After Login");
	}
	
}
