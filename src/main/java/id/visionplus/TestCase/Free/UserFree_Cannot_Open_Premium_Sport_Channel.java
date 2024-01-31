package id.visionplus.TestCase.Free;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import id.visionplus.Action.Click;
import id.visionplus.Action.Input;
import id.visionplus.Action.Scroll;
import id.visionplus.MainFunction.BaseTest;

public class UserFree_Cannot_Open_Premium_Sport_Channel extends BaseTest
{
	Click click = new Click();
	Input action_input = new Input();
	Scroll scroll = new Scroll(android);
	
	public void TC_Visitor_Cannot_Access_DaftarKu(HashMap<String, String> input) throws InterruptedException 
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
}