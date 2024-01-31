package id.visionplus.v2.TestCase.Visitor.Register;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Register_With_Phone_Number extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	
	@Test(priority = 1)
	public void TC_access_register_page() throws InterruptedException, TimeoutException {
		click.clickRegister();
		test.pass("Successfully Clicked Register Button");
		Thread.sleep(3000);
		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Register Page");
	}
	
	@Test(priority = 2, dependsOnMethods = "TC_access_register_page")
	public void TC_user_can_search_country_code(){
		click.clickCountry();
		test.pass("Successfully Clicked Country Code");
		assertion.assertDropDownCountry();
		test.pass("Successfully Assert Country Code Section");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_can_search_country_code")
	public void TC_user_can_filter_country_by_keyword(){
		click.clickFieldCountry();
		test.pass("Successfully Clicked Text Field Country Code");
		input.inputCountryKeyword("Indonesia");
		test.pass("Successfully Input Text Field Country Code with Keyword");
		assertion.assertFilteredCountryKeyword("Indonesia");
		test.pass("Successfully Assert Filtered Country Code");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_can_search_country_code")
	public void TC_user_can_filter_country_by_code(){
		click.clickFieldCountry();
		test.pass("Successfully Clicked Text Field Country Code");
		input.inputCountryKeyword("60");
		test.pass("Successfully Input Text Field Country Code with Country Code");
		assertion.assertFilteredCountryKeyword("Malaysia");
		test.pass("Successfully Assert Filtered Country Code");
	}
}
