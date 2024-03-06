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

public class TC_Login_As_Free_User_Facebook extends BaseTest{
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
	
	@Test(dataProvider= "freeUserFacebook", dependsOnMethods="TC_Access_to_Login_Page")
	public void TC_user_can_login_with_free_user_facebook_account(HashMap<String, String> input_data) throws InterruptedException, TimeoutException {		
		click.clickLoginByFacebook();
		test.pass("Successfully Clicked Login with Facebook button");

		Thread.sleep(5000);

		click.clickContinueAsAccountFacebook();
		test.pass("Successfully Clicked Continue as Account Button");
		
		Thread.sleep(3000);
		
		assertion.assertArriveHomePage();
		test.pass("Successfully Assert Arrived Homepage After Login");
	}
	
	@DataProvider
	public Object[][] freeUserFacebook() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/v2/TestData/Login/free_facebook.json");
		System.out.println("get User Data: "+data.get(0)); // check test data		
		return new Object[][] {{data.get(0)}};
	}
}
