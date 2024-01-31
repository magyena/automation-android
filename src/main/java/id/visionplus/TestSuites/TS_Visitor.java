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

public class TS_Visitor extends BaseTest
{
	public Report report = new Report();
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input_action = new Input();
	Scroll scroll = new Scroll(android);
	TC_OpenApp openApp = new TC_OpenApp();

	
	@Test(priority = 1,testName = "Visitor Cannot Access DaftarKu")
	public void visitor_cannot_access_daftarKu() throws InterruptedException, TimeoutException 
	{
		openApp.TC_Open_App();

		Assertion assertion = new Assertion();
		TC_Access_DaftarKu access_DaftarKu = new TC_Access_DaftarKu();
		//Call test case accessing to DaftarKu Page
		access_DaftarKu.TC_Access_DaftarKu();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();
	}
	
	@Test(priority = 2,testName = "Visitor Cannot Access EBooks", dependsOnMethods = "visitor_cannot_access_daftarKu")
	public void visitor_cannot_access_EBooks() throws InterruptedException 
	{
		Assertion assertion = new Assertion();
		TC_Access_EBooks access_eBooks = new TC_Access_EBooks();
		//call test case accessing to Ebooks Page
		access_eBooks.TC_EBooks();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();	
	}

	@Test(priority = 3,testName = "Visitor Cannot Access Pengaturan", dependsOnMethods = "visitor_cannot_access_EBooks")
	public void visitor_cannot_access_pengaturan() throws InterruptedException 
	{
		Assertion assertion = new Assertion();
		TC_Access_Pengaturan access_Pengaturan = new TC_Access_Pengaturan();
		//Call test case accessing to DaftarKu Page
		access_Pengaturan.TC_Access_Pengaturan();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();
	}
	
	@Test(priority = 4,testName = "Visitor Cannot Access Tv Berlangganan", dependsOnMethods = "visitor_cannot_access_pengaturan")
	public void visitor_cannot_access_Tv_Berlangganan() throws InterruptedException, TimeoutException 
	{	
		Assertion assertion = new Assertion();
		TC_Access_TVBerlangganan access_tv_berlangganan = new TC_Access_TVBerlangganan();
	//call test case accessing to TV Berlangganan Page
		access_tv_berlangganan.TC_TVBerlangganan();
		Thread.sleep(3000);
		assertion.assertLoginPage();
	}
	
	@Test(priority = 5,dataProvider = "wrongNumber",testName = "User Visitor Login with Wrong Number",dependsOnMethods = "visitor_cannot_access_Tv_Berlangganan")
	public void UserVisitorLoginWithWrongNumber(HashMap<String, String> input) throws InterruptedException 
	{
		input_action.inputPhoneNumber(input.get("phone"));
		test.info("User input nomor yang salah");
		
		click.clickButtonContinue();
		
		assertion.assertWrongPhoneNumber();
	}
	
	@Test(priority = 6,dataProvider = "wrongPassword",testName = "User Visitor Login with Wrong Password", dependsOnMethods = "UserVisitorLoginWithWrongNumber")
	public void UserVisitorLoginWithWrongPassword(HashMap<String, String> input) throws InterruptedException, IOException 
	{		
		input_action.inputPhoneNumber(input.get("phone"));
		click.clickButtonContinue();
		input_action.inputPhonePassword(input.get("password"));
		test.info("User input password yang salah");
		click.clickButtonContinue();
		assertion.assertWrongPhonePassword();
	}
	
	@DataProvider
	public Object[][] wrongNumber() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/TestData/Login/TC_loginWrongPhoneNumber.json");
		System.out.println("Wrong Numb: "+data.get(0));
		return new Object[][] {{data.get(0)}};
		
	}
	
	@DataProvider
	public Object[][] wrongPassword() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/TestData/Login/TC_loginWrongPhonePassword.json");
		System.out.println("Wrong Pass: "+data.get(0));
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
