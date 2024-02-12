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

public class TC_Login_As_Free_User_Phone extends BaseTest{
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
	
	@Test(dataProvider= "unregisteredPhone")
	public void TC_user_cannot_login_with_unregistered_number(HashMap<String, String> input_data) throws InterruptedException, TimeoutException {		
		click.clickFieldPhoneNumber();
		test.pass("Successfully Clicked Text Field Phone Number");
		
		input.inputPhoneNumber(input_data.get("username"));
		test.pass("Successfully Input Text Field Phone Number with Valid Unegistered Numbers");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword(input_data.get("password"));
		test.pass("Successfully Input Text Field Password with Valid Unegistered Password");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Login Submit Button");
		
		Thread.sleep(3000);
		
		assertion.assertUnregisteredAccountText();
		test.pass("Successfully Assert Unregistered Account Text After Submit");
		
		click.pressBack();
		test.pass("Successfully Press Back");
	}
	
	@Test(dataProvider= "freeUserPhone", dependsOnMethods="TC_user_cannot_login_with_unregistered_number")
	public void TC_user_can_login_with_free_user_phone_account(HashMap<String, String> input_data) throws InterruptedException, TimeoutException {		
		click.clickFieldPhoneNumber();
		test.pass("Successfully Clicked Text Field Phone Number");
		
		input.inputPhoneNumber(input_data.get("username"));
		test.pass("Successfully Input Text Field Phone Number with Valid Registered Numbers");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword(input_data.get("password"));
		test.pass("Successfully Input Text Field Password with Valid Registered Password");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Login Submit Button");
		
		Thread.sleep(3000);
		
		assertion.assertWelcomeText();
		test.pass("Successfully Assert Welcome Text After Login");
	}
	
	@DataProvider
	public Object[][] freeUserPhone() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/v2/TestData/Login/free_phone.json");
		System.out.println("get User Data: "+data.get(0)); // check test data		
		return new Object[][] {{data.get(0)}};
	}
	
	@DataProvider
	public Object[][] unregisteredPhone() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/v2/TestData/Login/unregistered_phone.json");
		System.out.println("get User Data: "+data.get(0)); // check test data		
		return new Object[][] {{data.get(0)}};
	}
}
