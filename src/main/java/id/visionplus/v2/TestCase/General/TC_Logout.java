package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Logout extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	
	@Test
	public void TC_Access_Settings() throws IOException, InterruptedException, TimeoutException {
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
}
