package id.visionplus.TestSuites;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.Action.*;
import id.visionplus.TestCase.General.*;
import id.visionplus.Utils.Report;

public class TS_Free extends BaseTest
{
	public Report report = new Report();
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input_action = new Input();
	Scroll scroll = new Scroll(android);

	@Test(dataProvider = "freeUser",testName = "User Visitor Login")
	public void user_login_with_phone_number(HashMap<String, String> input) throws InterruptedException, IOException, TimeoutException 
	{	
		TC_OpenApp openApp = new TC_OpenApp();
		TC_Access_Login_Through_Lainnya access_login = new TC_Access_Login_Through_Lainnya();
		TC_Ignore_Ads_PopUp ignore_notif = new TC_Ignore_Ads_PopUp();
		
		openApp.TC_Open_App();
		
		access_login.TC_Access_Through_Lainnya();

		input_action.inputPhoneNumber(input.get("username"));
		click.clickButtonContinue();
		input_action.inputPhonePassword(input.get("password"));
		click.clickButtonContinue();
		
		ignore_notif.TC_Ignore_Ads_Notif();
	}
	
	@Test(testName = "Free User Access Games Plus", dependsOnMethods = "user_login_with_phone_number")
	public void free_user_access_games_plus() throws InterruptedException 
	{		
		Thread.sleep(5000);
		TC_Access_GamesPlus gamesPlus = new TC_Access_GamesPlus();
		gamesPlus.TC_Access_GamesPlus();
		Thread.sleep(2000);
	}
	
	@Test(testName = "Free User Access Games Plus Detail", dependsOnMethods = "free_user_access_games_plus")
	public void free_user_access_games_plus_detail() throws InterruptedException 
	{		
		Thread.sleep(5000);
		TC_Access_GamesPlus_Detail gamesPlusDetails = new TC_Access_GamesPlus_Detail();
		gamesPlusDetails.TC_Access_GamesPlus_Detail();
		Thread.sleep(2000);
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
