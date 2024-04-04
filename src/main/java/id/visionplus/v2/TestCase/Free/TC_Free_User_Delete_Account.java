package id.visionplus.v2.TestCase.Free;

import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Cluster_Film;

public class TC_Free_User_Delete_Account extends BaseTest {

	Click click = new Click();
	Input input = new Input();
	Assertion assertion = new Assertion();
	TC_Integrate_Register register = new TC_Integrate_Register();
	TC_Cluster_Film cancelsubs= new TC_Cluster_Film();
	BaseTest base = new BaseTest();
	String password = "4321Lupa";

	@Test(priority = 1)

	public void TC_User_Have_Package_Before_Deleted_Account() throws InterruptedException, TimeoutException, IOException {
		cancelsubs.TC_Cancel_Subscription_Playstore();
		base.ConfigureAppium();
		register.TC_user_input_valid_phone_number_and_password();
		register.TC_user_click_send_otp_2nd_time();
		register.TC_user_input_correct_otp();
		click.clickMenuButton();
		click.clickMyPackage();
		click.clickPremiumSports30daysPackage();
		click.clickSubscribe();
		click.clickBtnSubscriptionsPlaystoreagain();
		click.clickBtnAccept();
		Thread.sleep(2000);
	}
	@Test(priority = 2)

	public void TC_User_Cannot_Be_Deleted_Account() throws InterruptedException, TimeoutException, IOException {

		click.clickMenuButton();
		test.pass("Successfully clicked menu button");

		click.clickSettingsButton();
		test.pass("Successfully clicked settings button");

		click.clickSettingsAccountNumberorEmail();
		test.pass("Successfully clicked account");

		click.clickDeleteAccount();
		test.pass("Successfully clicked delete account");

		assertion.assertStillHavePackage();
		test.pass("Successfully assert still have package");

		click.clickCheckBoxDeleteAccount();
		test.pass("Successfully click checkbox");

		click.clickBtnProceedDeletedAccount();
		test.pass("Successfully clicked proceed deleted account button");

		input.inputPasswordDeleteAccount("SalahPassword");
		test.pass("Successfully input password delete account");

		assertion.assertDeleteAccountEnterPassword();
		test.pass("Successfully assert enter password");

		click.clickBtnConfirmationDeleteAccount();
		test.pass("Successfully clicked delete account");

		assertion.assertDeleteAccountFailed();
		test.pass("Successfully assert deleted account failed");

		click.clickBtnOKChangePasswordFailed();
		Thread.sleep(6000);
	}

	@Test(priority = 3)
	public void TC_User_Can_Be_Deleted_Account_With_Package() throws InterruptedException, TimeoutException, IOException {
		input.clearInputPasswordDeleteAccount();
		test.pass("Successfully clear input password");
		
		input.inputPasswordDeleteAccount(password);
		test.pass("Successfully input password delete account");
		
		assertion.assertDeleteAccountEnterPassword();
		test.pass("Successfully assert enter password");

		click.clickBtnConfirmationDeleteAccount();
		test.pass("Successfully clicked delete account");

		assertion.assertDeleteAccountSuccess();
		test.pass("Successfully assert deleted account failed");
		
		click.clickBtnSuccessBack();
		test.pass("Successfully clicekd close");
		
		click.clickLogout();
		Thread.sleep(6000);

	}
}