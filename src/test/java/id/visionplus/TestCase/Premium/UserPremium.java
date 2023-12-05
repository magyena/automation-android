package id.visionplus.TestCase.Premium;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import id.visionplus.BaseTest;
import id.visionplus.Action.Click;
import id.visionplus.Action.Input;
import id.visionplus.Action.Scroll;

public class UserPremium extends BaseTest
{
	Click click = new Click(android);
	Input action_input = new Input(android);
	Scroll scroll = new Scroll(android);
	
	@Test(dataProvider="getData",priority = 1,testName = "Login ke account premium")
	public void loginToPremiumAccount(HashMap<String, String> input) throws InterruptedException 
	{
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
	
		Thread.sleep(3000);
		click.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		
		click.clickMasukButton();
		action_input.inputPhoneNumber(input.get("phone"));
		
		test.info("User input nomor yang salah");
		click.clickButtonContinue();
		test.pass("hasil Assert sesuai");
		action_input.inputPhonePassword(input.get("password"));
		click.clickButtonContinue();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/id/visionplus/TestData/Login/loginPremium.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	@Test(priority = 2)	
	public void playSportChannel() throws InterruptedException
	{
		click.clickBtnTVku();
		test.pass("Sukses lewati button TVku");
		
		Thread.sleep(3000);
		scroll.scrollDown(0.1);
		
		click.clickSportStar();
	}
	
	/*
	 * @Test(priority = 3) public void playSportContent() throws
	 * InterruptedException { TvKUPageVisionPlus tvKUPageVisionPlus = new
	 * TvKUPageVisionPlus(android); HomePageVisionPlus homepage = new
	 * HomePageVisionPlus(android);
	 * 
	 * homepage.clickBtnTVku(); test.pass("Sukses lewati button TVku");
	 * 
	 * Thread.sleep(3000); tvKUPageVisionPlus.scrollDown(0.1);
	 * 
	 * tvKUPageVisionPlus.clickSportStar(); }
	 */
	
	
	
}
