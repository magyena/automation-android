package id.visionplus.v2.TestCase.General;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_As_Free_User_Email;

public class TC_OpenApp extends BaseTest{
	Click click = new Click();
	
	@Test
	public void TC_Open_App_as_Free_User() throws InterruptedException, TimeoutException, IOException {
	    Object[][] testData = freeUserEmail();

	    // Assuming there is only one set of username and password in the data provider
	    String username = (String) testData[0][0];
	    String password = (String) testData[0][1];
	    
	    TC_Login_As_Free_User_Email login_email = new TC_Login_As_Free_User_Email();
	    login_email.TC_Access_to_Login_By_Email_Page();
	    login_email.TC_user_can_login_with_free_user_email_account(username, password);
	    
	    click.clickFirstProfile();
	    test.pass("Successfully Clicked First Profile");
	    
	    Thread.sleep(2000);
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
