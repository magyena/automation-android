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
	
	@Test(priority = 2,testName = "Visitor Cannot Access EBooks")
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

	@Test(priority = 3,testName = "Visitor Cannot Access Pengaturan")
	public void visitor_cannot_access_pengaturan() throws InterruptedException 
	{
		Assertion assertion = new Assertion();
		TC_Access_Pengaturan access_Pengaturan = new TC_Access_Pengaturan();
		//Call test case accessing to DaftarKu Page
		access_Pengaturan.TC_Access_Pengaturan();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();
		
//		for (int i=0 ; i<3 ;i++)
//		{
//			android.navigate().back();
//		}
//	
//		click.clickLiveTv();
//		Thread.sleep(3000);
//		
//		scroll.scrollDownWithParameter(0.1);
//		
//		click.clickSportStar();
//
//		
//		assertion.assertPopupLogin();
//		assertion.assertLogin();
	}
	
	@Test(priority = 4,testName = "Visitor Cannot Access Tv Berlangganan")
	public void visitor_cannot_access_Tv_Berlangganan() throws InterruptedException 
	{
		Assertion assertion = new Assertion();
		TC_Access_TVBerlangganan access_tv_berlangganan = new TC_Access_TVBerlangganan();
		//call test case accessing to TV Berlangganan Page
		access_tv_berlangganan.TC_TVBerlangganan();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();
		
	}
	
	@Test(priority = 5,dataProvider = "wrongNumber",testName = "User Visitor Login with Wrong Number")
	public void UserVisitorLoginWithWrongNumber(HashMap<String, String> input) throws InterruptedException 
	{

		click.clickMasuk();
		
		input_action.inputPhoneNumber(input.get("phone"));
		test.info("User input nomor yang salah");
		click.clickButtonContinue();
		assertion.assertWrongPhoneNumber();
		test.pass("hasil Assert sesuai");
	}
	
	@Test(priority = 6,dataProvider = "wrongPassword",testName = "User Visitor Login with Wrong Password")
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
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/TestData/Login/TC_loginWrongPhoneNumber.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	@DataProvider
	public Object[][] wrongPassword() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/id/visionplus/TestData/Login/TC_loginWrongPhonePassword.json");
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
