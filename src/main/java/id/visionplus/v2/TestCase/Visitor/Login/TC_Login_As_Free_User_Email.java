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

public class TC_Login_As_Free_User_Email extends BaseTest{
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	
	@Test
	public void TC_Access_to_Login_By_Email_Page() throws InterruptedException, TimeoutException {		
		click.clickLogin();
		test.pass("Successfully Clicked Login Button");
		
		click.clickRegisterLoginByEmailSection();
		test.pass("Successfully Clicked Login by Email Section Button");
		
		Thread.sleep(3000);
		
		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Login Page");
	}
	
	@Test(dataProvider= "unregisteredEmail")
	public void TC_user_cannot_login_with_unregistered_email(HashMap<String, String> input_data) throws InterruptedException, TimeoutException {		
		click.clickFieldEmail();
		test.pass("Successfully Clicked Text Field Email");
		
		input.inputEmail(input_data.get("username"));
		test.pass("Successfully Input Text Field Email with Valid Unregistered Email");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword(input_data.get("password"));
		test.pass("Successfully Input Text Field Password with Valid Unregistered Password");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Login Submit Button");
		
		Thread.sleep(3000);
		
		assertion.assertUnregisteredAccountText();
		test.pass("Successfully Assert Unregistered Account Text After Submit");
		
		click.pressBack();
		test.pass("Successfully Press Back");
		
		click.clickFieldEmail();
		test.pass("Successfully Clear Email Field");
	}
	
	@Test(dataProvider= "freeUserEmailWrongPassword",dependsOnMethods="TC_user_cannot_login_with_unregistered_email")
	public void TC_user_login_using_wrong_password(HashMap<String, String> input_data) throws InterruptedException, TimeoutException {		
		click.clickFieldEmail();
		test.pass("Successfully Clicked Text Field Email");
		
		input.inputEmail(input_data.get("username"));
		test.pass("Successfully Input Text Field Email with Valid Registered Email");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword(input_data.get("password"));
		test.pass("Successfully Input Text Field Password with Invalid Unregistered Password");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Login Submit Button");
		
		Thread.sleep(3000);
		
		assertion.assertWrongEmailPasswordText();
		test.pass("Successfully Assert Wrong Email or Password Text After Submit");
		
		click.pressBack();
		test.pass("Successfully Press Back");
		
		click.clickFieldEmail();
		test.pass("Successfully Clear Email Field");
	}
	
	@Test(dataProvider="freeUserEmail", dependsOnMethods="TC_user_login_using_wrong_password")
	public void TC_user_can_login_with_free_user_email_account(String username, String password) throws InterruptedException, TimeoutException {		
		click.clickFieldEmail();
		test.pass("Successfully Clicked Text Field Email");
		
		input.inputEmail(username);
		test.pass("Successfully Input Text Field Email with Valid Registered Email");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword(password);
		test.pass("Successfully Input Text Field Password with Valid Registered Password");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Login Submit Button");
		
		Thread.sleep(3000);
		
		assertion.assertWelcomeText();
		test.pass("Successfully Assert Welcome Text After Login");
	}
	
	
	@DataProvider
	public Object[][] freeUserEmailWrongPassword() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/v2/TestData/Login/free_email_wrong_password.json");
		System.out.println("get User Data: "+data.get(0)); // check test data		
		return new Object[][] {{data.get(0)}};
	}
	
	@DataProvider
	public Object[][] unregisteredEmail() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/v2/TestData/Login/unregistered_email.json");
		System.out.println("get User Data: "+data.get(0)); // check test data		
		return new Object[][] {{data.get(0)}};
	}
	
	@DataProvider
	public Object[][] freeUserEmail() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/v2/TestData/Login/free_email.json");
		System.out.println("get User Data: "+data.get(0)); // check test data		
		Object[][] testData = new Object[data.size()][2];
	    for (int i = 0; i < data.size(); i++) {
	        testData[i][0] = data.get(i).get("username");
	        testData[i][1] = data.get(i).get("password");
	    }
	    return testData;
	}
}
