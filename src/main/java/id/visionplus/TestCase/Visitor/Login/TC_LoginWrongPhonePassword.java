package id.visionplus.TestCase.Visitor.Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.Action.Input;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.PageObjects.HomePageVisionPlus;
import id.visionplus.PageObjects.LoginPageVisionPlus;

public class TC_LoginWrongPhonePassword extends BaseTest {

	@Test(dataProvider="getData")
	public void TC_LoginWrongPhonePassword(HashMap<String, String> input) throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();
		Input input_action = new Input();
		
		click.lewatiButton();
		test.info("User berhasil Klik skip button");
		click.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		click.clickMasukButton();
		test.pass("User berhasil Klik Button Masuk");
		input_action.inputPhoneNumber(input.get("phone"));
		test.pass("User berhasil input Phone Number");
		Thread.sleep(3000);
		click.clickButtonContinue();
		input_action.inputPhonePassword(input.get("password"));
		click.clickButtonContinue();
		assertion.assertWrongPhonePassword();
		test.pass("hasil Assert sesuai");
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/id/visionplus/TestData/Login/TC_loginWrongPhonePassword.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
}
