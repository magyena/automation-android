package id.visionplus.TestCase.Visitor.Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import id.visionplus.Action.*;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.Utils.Report;

public class TS_Visitor extends BaseTest
{
	public Report report = new Report();
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input_action = new Input();
	Scroll scroll = new Scroll(android);
	
	@Test(priority = 1,testName = "User Add Daftarku With Visitor")
	public void user_Add_Daftarku_With_Visitor() throws InterruptedException 
	{
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		
		click.clickBtnShowcaseTvConnect();
		test.pass("sukses lewati button showcase");
		
		click.clickBtnShowcaseOk();
		test.pass("sukses lewati button showcase");
		
		//homepage.lainnyaButton();
		
		click.clickMenuVplusOriginal();
		
		click.clickMenuVplusOriginalSelengkapnya();

		click.clickFirstVOD();
		
		scroll.scrollDownWithParameter(0.1);
		
		click.clickWatchList();
		
		assertion.assertLoginPageShouldBeDisplayed();;
		
	}
	
	@Test(priority = 2,testName = "User visitor Download VOD Series")
	public void user_Download_VOD_Series() throws InterruptedException 
	{
		android.navigate().back();
		
		scroll.scrollDownWithParameter(0.1);
				
		click.clickDownload();
		
		assertion.assertLoginPageShouldBeDisplayed();
		
	}
	
	
	@Test(priority = 3,testName = "User Visitor Watch Sport Channel")
	public void User_Visitor_Watch_Sport_Channel() throws InterruptedException 
	{
		for (int i=0 ; i<3 ;i++)
		{
			android.navigate().back();
		}
	
		click.clickLiveTv();
		Thread.sleep(3000);
		
		scroll.scrollDownWithParameter(0.1);
		
		click.clickSportStar();

		
		assertion.assertPopupLogin();
		assertion.assertLogin();
	}
	
	@Test(priority = 4,dataProvider = "wrongNumber",testName = "User Visitor Login with Wrong Number")
	public void UserVisitorLoginWithWrongNumber(HashMap<String, String> input) throws InterruptedException 
	{

		click.clickMasuk();
		
		input_action.inputPhoneNumber(input.get("phone"));
		test.info("User input nomor yang salah");
		click.clickButtonContinue();
		assertion.assertWrongPhoneNumber();
		test.pass("hasil Assert sesuai");
	}
	
	
	@Test(priority = 5,dataProvider = "wrongPassword",testName = "User Visitor Login with Wrong Password")
	public void UserVisitorLoginWithWrongPassword(HashMap<String, String> input) throws InterruptedException, IOException 
	{		
		input_action.inputPhoneNumber(input.get("phone"));
		click.clickButtonContinue();
		input_action.inputPhonePassword(input.get("password"));
		click.clickButtonContinue();
		assertion.assertWrongPhonePassword();
		test.pass("hasil Assert sesuai");
		
		
	}
	
	@DataProvider
	public Object[][] wrongNumber() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/id/visionplus/TestData/Login/TC_loginWrongPhoneNumber.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	@DataProvider
	public Object[][] wrongPassword() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/id/visionplus/TestData/Login/TC_loginWrongPhonePassword.json");
		return new Object[][] {{data.get(0)}};
		
	}
	

	@AfterClass
	public void tearDown() {
		try
		{
			extent.flush();
			android.quit();
			service.stop();
			
			report.genarateReport();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	
}
