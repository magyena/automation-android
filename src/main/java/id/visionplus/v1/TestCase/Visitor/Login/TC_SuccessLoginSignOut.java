package id.visionplus.v1.TestCase.Visitor.Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_SuccessLoginSignOut extends BaseTest{
	
	
	@Test(dataProvider="getData")
	public void TC_SuccessLoginSignOut (HashMap<String, String> input) throws InterruptedException{
		Click click = new Click();
		TC_Login tc_login = new TC_Login();
		
		Thread.sleep(3000);	
		click.lewatiButton();
		test.info("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		Thread.sleep(3000);
		click.clickMasukButton();
		test.info("User berhasil Klik Button Masuk");
		Thread.sleep(3000);
		tc_login.LoginVisionPlus(input.get("loginWith"), input.get("username"), input.get("password"));
		click.clickButtonContinue();
		test.pass("User memilih login dengan Phone");
		click.removePopupSub();
		click.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		click.clickPengaturanLainnya();
		click.signOut();;
		test.info("User berhasil Sign out dari Aplikasi");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/id/visionplus/TestData/Login/login.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	
}
