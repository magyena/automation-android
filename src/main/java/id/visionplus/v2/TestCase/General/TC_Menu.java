package id.visionplus.v2.TestCase.General;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_As_Free_User_Email;

public class TC_Menu extends BaseTest{
	Click click = new Click();
	Assertion assertion = new Assertion();
	@Test
	public void TC_Access_Live_Tv() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.TC_Open_App_as_Free_User();
		
		click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");
	    
	    click.clickLiveTv();
	    test.pass("Successfully Clicked Menu Button");
	}
}
