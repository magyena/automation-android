package id.visionplus.v2.TestCase.General;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Profile extends BaseTest{
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	
	public String username_random_15_char(){
		long epochTime = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String formattedTime = dateFormat.format(new Date(epochTime));
        String result = "Visionplus" + formattedTime.substring(0, Math.max(0, 15 - "visionplus".length()));
        return result;
	}
	
	String random_name = username_random_15_char();
	
	public void TC_Access_Add_Profile_Section() throws IOException, InterruptedException, TimeoutException {
	    click.clickAddProfileButton();
	    test.pass("Successfully Clicked Add Profile Button");
	    
	    assertion.assertAddProfileSection();
	    test.pass("Successfully Assert Add Profile Section");
	}
	
	@Test
	public void TC_Access_Profile() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.TC_Open_App_as_Free_User();
		
	    click.clickProfileButton();
	    test.pass("Successfully Clicked Profile Button");
	    
		assertion.assertWelcomeText();
		test.pass("Successfully Assert Welcome Text After Login");
	}
	
	@Test(priority=2, dependsOnMethods="TC_Access_Profile")
	public void TC_Cancel_Add_Profile() throws IOException, InterruptedException, TimeoutException {
		TC_Access_Add_Profile_Section();
		
		click.clickAddProfileCancelButton();
	    test.pass("Successfully Clicked Cancel Add Profile");
	    
		assertion.assertWelcomeText();
		test.pass("Successfully Assert Welcome Text After Login");
	}
	
	@Test(priority=2, dependsOnMethods="TC_Access_Profile")
	public void TC_Cannot_Add_Profile_With_Long_Username() throws IOException, InterruptedException, TimeoutException {
		TC_Access_Add_Profile_Section();
		
		click.clickTextFieldProfileName();
	    test.pass("Successfully Clicked Text Field Profile Name");
	    
	    //this is more than 15 digits
	    input.inputProfileName("visionplus7654321");
	    test.pass("Successfully Input Text Field Profile Name");
	    
	    //even though i've input more than 15 digits, but still return true
	    assertion.assertAddProfileNameFieldIs15Char();
		test.pass("Successfully Assert Profile Name is 15 Characters");
	}
//	
	@Test(priority=3, dependsOnMethods="TC_Cannot_Add_Profile_With_Long_Username")
	public void TC_Add_Existing_Profile() throws IOException, InterruptedException, TimeoutException {
		input.clearProfileName();
	    test.pass("Successfully Clear Text Field Profile Name");
	    
		click.clickTextFieldProfileName();
	    test.pass("Successfully Clicked Text Field Profile Name");
	    
	    input.inputProfileName("Kids");
	    test.pass("Successfully Input Text Field Profile Name");
	    
		click.clickAddProfileOKButton();
	    test.pass("Successfully Clicked Submit Profile Button");
	    
	    click.clickAddProfileDoneButton();
	    test.pass("Successfully Clicked Done Profile Button");

	    assertion.assertProfile_Already_Exist();
		test.pass("Successfully Assert Profile Name is Already Exist");
		
		click.clickProfileWarningOkButton();
	    test.pass("Successfully Clicked OK in Profile Warning Pop Up");

		click.clickProfileAlmostDoneCancelButton();
	    test.pass("Successfully Clicked Cancel in Profile Submission");
	}
//	
	@Test(priority=4, dependsOnMethods="TC_Add_Existing_Profile")
	public void TC_Add_Profile() throws IOException, InterruptedException, TimeoutException {
		TC_Access_Add_Profile_Section();
		
	    input.clearProfileName();
	    test.pass("Successfully Clear Text Field Profile Name");
	    
		click.clickTextFieldProfileName();
	    test.pass("Successfully Clicked Text Field Profile Name");
	    
	    input.inputProfileName(random_name);
	    test.pass("Successfully Input Text Field Profile Name");
	    
	    assertion.assertAddProfileNameFieldIs15Char();
		test.pass("Successfully Assert Profile Name is 15 Characters");
		
		click.clickAddProfileOKButton();
	    test.pass("Successfully Clicked Submit Profile Button");
	    
	    click.clickAddProfileDoneButton();
	    test.pass("Successfully Clicked Done Profile Button");
	}
		
	@Test(priority=5, dependsOnMethods="TC_Add_Profile")
	public void TC_User_cannot_add_more_more_than_8_profile() throws IOException, InterruptedException, TimeoutException {
		assertion.assertAddProfileNotShown();
		test.pass("Successfully Assert Add Profile Button not Shown");		
	}
	
	@Test(priority=6, dependsOnMethods="TC_User_cannot_add_more_more_than_8_profile")
	public void TC_Back_to_Homepage() throws IOException, InterruptedException, TimeoutException {	
	    click.clickFirstProfile();
	    test.pass("Successfully Clicked First Profile");
	    
		assertion.assertArriveHomePage();
	    test.pass("Successfully Assert Arrived at Homepage");
	}
	
	@Test(priority=7, dependsOnMethods="TC_Back_to_Homepage")
	public void TC_Access_Manage_Profile() throws IOException, InterruptedException, TimeoutException {
	    click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");

	    Thread.sleep(2000);

	    click.clickSettingsButton();
	    test.pass("Successfully Clicked Settings Button");
	    
	    click.clickManageProfile();
        test.pass("Successfully Clicked Manage Profile Button");

        assertion.assertManageProfile();
        test.pass("Successfully Assert Manage Profile Page");
	}

	@Test(priority=8, dependsOnMethods="TC_Access_Manage_Profile")
	public void TC_Delete_Profile() throws IOException, InterruptedException, TimeoutException {
		click.clickLatestProfile();
        test.pass("Successfully Clicked Latest Profile");

        click.clickDeleteProfile();
        test.pass("Successfully Clicked Delete Profile");
        
        click.clickConfirmationDeleteProfile();
        test.pass("Successfully Clicked Confirmation Delete Profile");
	}
}
