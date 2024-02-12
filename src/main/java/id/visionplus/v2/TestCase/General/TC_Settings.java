package id.visionplus.v2.TestCase.General;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Settings extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	
	@Test(dataProvider = "freeUserEmail")
	public void TC_Access_Settings(String username, String password) throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.TC_Open_App_as_Free_User();
	    
	    Thread.sleep(2000);

	    click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");
	    
	    Thread.sleep(2000);

	    click.clickSettingsButton();
	    test.pass("Successfully Clicked Settings Button");
	    
	}
	
	@Test(dependsOnMethods="TC_Access_Settings")
	public void TC_Access_Manage_Profile() throws InterruptedException{
	    Thread.sleep(2000);

	    click.clickManageProfile();
	    test.pass("Successfully Clicked Manage Profile Button");

	    assertion.assertManageProfile();
	    test.pass("Successfully Assert Manage Profile Page");
	    
	    click.clickSettingsBackButton();
	    test.pass("Successfully Clicked Back to Settings Button");
	}
	
	@Test(dependsOnMethods="TC_Access_Manage_Profile")
	public void TC_Access_Notification_Centre() throws InterruptedException{
	    Thread.sleep(2000);

	    click.clickNotificationCentre();
	    test.pass("Successfully Clicked Notification Centre Button");
	    
	    assertion.assertNotificationCentre();
	    test.pass("Successfully Assert Notification Centre Page");
	    
	    click.clickSettingsBackButton();
	    test.pass("Successfully Clicked Back to Settings Button");
	}
	
	@Test(dependsOnMethods="TC_Access_Notification_Centre")
	public void TC_Access_Help_Centre() throws InterruptedException{
	    Thread.sleep(2000);
	    
		Scroll scroll = new Scroll(android);
		scroll.scrollDown(0.2);
		
	    click.clickHelpButton();
	    test.pass("Successfully Clicked Help Centre Button");
	    
	    assertion.assertHelpCentre();
	    test.pass("Successfully Assert Help Centre Page");
	}
	
	@Test(dependsOnMethods="TC_Access_Help_Centre")
	public void TC_Access_About_Us() throws InterruptedException{
	    Thread.sleep(2000);

	    click.clickAboutUs();
	    test.pass("Successfully Clicked About Us Button in Help Center Page");
	    
	    assertion.assertAboutUs();
	    test.pass("Successfully Assert About Us Page");
	    
	    click.clickBackToHelp();
	    test.pass("Successfully Clicked Back to Help Center Page");
	}
	
	@Test(dependsOnMethods="TC_Access_About_Us")
	public void TC_Access_Subscription_Transaction() throws InterruptedException{
	    Thread.sleep(2000);

	    click.clickSubscriptionTransaction();
	    test.pass("Successfully Clicked Subscription and Transaction Button in Help Center Page");
	    
	    assertion.assertSubscriptionTransaction();
	    test.pass("Successfully Assert Subscription and Transaction Page");
	    
	    click.clickCloseHelp();
	    test.pass("Successfully Clicked Close Help Center Page");
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
