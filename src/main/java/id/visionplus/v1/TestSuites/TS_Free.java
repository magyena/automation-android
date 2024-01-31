package id.visionplus.v1.TestSuites;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v1.MainFunction.*;
import id.visionplus.v1.Action.*;
import id.visionplus.v1.TestCase.General.*;
import id.visionplus.v1.Utils.Report;

public class TS_Free extends BaseTest
{
	public Report report = new Report();
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input_action = new Input();
	Scroll scroll = new Scroll(android);
	TC_OpenApp openApp = new TC_OpenApp();
	TC_Access_Login_Through_Lainnya access_login = new TC_Access_Login_Through_Lainnya();
	TC_Ignore_Ads_PopUp ignore_notif = new TC_Ignore_Ads_PopUp();
	

	@Test(dataProvider = "freeUser",testName = "User Visitor Login")
	public void user_login_with_phone_number(HashMap<String, String> input) throws InterruptedException, IOException, TimeoutException 
	{	
		openApp.TC_Open_App();
		
		access_login.TC_Access_Login_Through_Lainnya();

		input_action.inputPhoneNumber(input.get("username"));
		click.clickButtonContinue();
		input_action.inputPhonePassword(input.get("password"));
		click.clickButtonContinue();
		
		ignore_notif.TC_Ignore_Ads_Notif();
	}
	
	@Test(testName = "Free User Access Games Plus", dependsOnMethods = "user_login_with_phone_number" )
	public void free_user_access_games_plus() throws InterruptedException  
	{	
		try {
			TC_Access_GamesPlus gamesPlus = new TC_Access_GamesPlus();
			gamesPlus.TC_Access_GamesPlus();
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}

	}
	
	@Test(testName = "Free User Access Games Plus Detail", dependsOnMethods = "free_user_access_games_plus")
	public void free_user_access_games_plus_detail() throws InterruptedException 
	{		
		try {
			TC_Access_GamesPlus_Detail gamesPlusDetails = new TC_Access_GamesPlus_Detail();
			gamesPlusDetails.TC_Access_GamesPlus_Detail();
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}
	}
	
	@DataProvider
	public Object[][] freeUser() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/TestData/Login/login.json");
		System.out.println("get User Data: "+data.get(0)); // check test data		
		return new Object[][] {{data.get(0)}};
	}
	

	@AfterClass
	public void tearDown() {
		try
		{
			extent.flush();
			android.quit();
			service.stop();
			
			report.generateReport();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	
}
