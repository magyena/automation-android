package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.PageObjects.SettingPage;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Integrate_Register_Email;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Email;

public class TC_Redeem_Voucher extends BaseTest {

    Click click = new Click();
    Assertion assertion = new Assertion();
    Input input = new Input();
    SettingPage settingsPage = new SettingPage(android);
	TC_Get_OTP get_otp= new TC_Get_OTP();
    String registeredEmail;
    
    @Test(priority = 1)
    public void TC_Access_Settings() throws IOException, InterruptedException, TimeoutException {
    	TC_Integrate_Register_Email integrate_register_email = new TC_Integrate_Register_Email();
		TC_Register_With_Email register_with_email = new TC_Register_With_Email();
				
		System.out.println("Done Access Register Page");
		register_with_email.TC_user_input_valid_email_and_password();
		
		System.out.println("Done input email and password");
		registeredEmail=register_with_email.TC_user_input_correct_otp();
		
		System.out.println(registeredEmail);
		
        click.clickMenuButton();
        test.pass("Successfully Clicked Menu Button");

        Thread.sleep(2000);

        click.clickSettingsButton();
        test.pass("Successfully Clicked Settings Button");
    }

    @Test(priority = 2, dependsOnMethods = "TC_Access_Settings")
    public void TC_Access_Voucher() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Voucher");

        try {
            Thread.sleep(2000);

            click.clickVoucher();
            test.pass("Successfully Clicked Voucher Button");

            Thread.sleep(2000);

            assertion.assertVoucher();
            test.pass("Successfully Assert Voucher Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_Help_Centre Failed:" + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3, dependsOnMethods = "TC_Access_Voucher")
    public void TC_User_input_Success_Voucher() throws InterruptedException {
    	System.out.println("Arrived at TC_User_input_Valid_Voucher");

	        Thread.sleep(2000);
	
	        click.clickVoucherField();
	        test.pass("Successfully Clicked Voucher Field");
	
	        input.clearVoucherField();
	        test.pass("Successfully Clear Voucher Code Field");
	
	        input.inputVoucher("IKINGGH2WFXO3PREM");
	        test.pass("Successfully Input Valid Voucher Code");
	
	        android.hideKeyboard();
	
	        click.clickRedeemVoucher();
	        test.pass("Successfully Clicked Redeem Button");
	
	        Thread.sleep(2000);
	
//	        assertion.assertVoucherSuccess();
//	        test.pass("Successfully Assert Voucher Success Redeemed");
    }
}
