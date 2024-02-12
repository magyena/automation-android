package id.visionplus.v2.TestCase.General;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Login.*;

public class TC_Logout extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	
	@Test(dataProvider = "freeUserEmail")
	public void TC_Access_Settings(String username, String password) throws IOException, InterruptedException, TimeoutException {
	    TC_Login_As_Free_User_Email login_email = new TC_Login_As_Free_User_Email();
	    login_email.TC_Access_to_Login_By_Email_Page();
	    login_email.TC_user_can_login_with_free_user_email_account(username, password);
	    
	    click.clickFirstProfile();
	    test.pass("Successfully Clicked First Profile");
	    
	    Thread.sleep(2000);

	    click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");
	    
	    Thread.sleep(2000);

	    click.clickSettingsButton();
	    test.pass("Successfully Clicked Settings Button");
	    
	}
	
	@Test(dependsOnMethods="TC_Access_Settings")
	public void TC_Access_Logout() throws InterruptedException{
	    Thread.sleep(2000);

	    click.clickSettingsProfile();
	    test.pass("Successfully Clicked Settings Profile Button");

	    assertion.assertAccount();
	    test.pass("Successfully Assert Account Page");
	    
	    click.clickLogout();
	    test.pass("Successfully Clicked Logout Button");
	    
	    assertion.assertEntryPage();
	    test.pass("Successfully Assert Entry Page");
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
