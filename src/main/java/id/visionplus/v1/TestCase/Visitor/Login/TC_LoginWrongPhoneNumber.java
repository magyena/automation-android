package id.visionplus.v1.TestCase.Visitor.Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.Action.Input;
import id.visionplus.v1.MainFunction.*;
import id.visionplus.v1.PageObjects.HomePageVisionPlus;
import id.visionplus.v1.PageObjects.LoginPageVisionPlus;

public class TC_LoginWrongPhoneNumber extends BaseTest {
	
	
	@Test(dataProvider="getData")
	public void TC_LoginWrongPhoneNumber(HashMap<String, String> input) throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();
		Input input_action = new Input();

		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		click.clickMasukButton();
		input_action.inputPhoneNumber(input.get("phone"));
		test.info("User input nomor yang salah");
		click.clickButtonContinue();
		assertion.assertWrongPhoneNumber();
		test.pass("hasil Assert sesuai");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/id/visionplus/TestData/Login/TC_loginWrongPhoneNumber.json");
		return new Object[][] {{data.get(0)}};
		
	}

}
