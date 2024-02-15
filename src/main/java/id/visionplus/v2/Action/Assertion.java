package id.visionplus.v2.Action;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import id.visionplus.v2.MainFunction.*;
import id.visionplus.v2.PageObjects.*;

public class Assertion extends BaseTest
{
	WebDriverWait wait;
	EntryPage entryPage;
	HomePage homePage = new HomePage(android);
	LoginPage loginPage;
	RegisterPage registerPage;
	SettingPage settingPage;
	VODDetailPage vodDetailPage;
	VPlusOriginalsPage vplusOriginalPage;
	LiveTVPage liveTvPage;
	
	public void assertEntryPage() {
		WebElement txt_entry_title = entryPage.txt_entry_title;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_entry_title));
	    
	    String actual = txt_entry_title.getText();
	    String expected = "All entertainment in one place";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertEmailIncorrectFormat() {
		WebElement txt_warning_incorrect_format = registerPage.txt_warning_incorrect_format;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_incorrect_format));
	    	    
	    String actual = txt_warning_incorrect_format.getText();
	    String expected = "Email address format incorrect.";
	    Assert.assertEquals(actual, expected);
	 	}
	
	public void assertPasswordVisible(){
		WebElement txt_fld_password = registerPage.txt_fld_password;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
		
        String actual = txt_fld_password.getText();
        Assert.assertEquals(actual, "4321Lupa");
	}
	
	public void assertTimer19Hours() {
		WebElement txt_timer = registerPage.txt_timer;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_timer));
	  	    
	    String actual = txt_timer.getText();
	    String expectedPrefix = "Resend in 19:";
	    Assert.assertTrue(actual.startsWith(expectedPrefix), "Timer text does not start with 'Resend in 019:'");
	}
	
	public void assertTimer5Minutes() {
		WebElement txt_timer = registerPage.txt_timer;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_timer));
	    
	    String actual = txt_timer.getText();
	    String expectedPrefix = "Resend in 04:";
	    Assert.assertTrue(actual.startsWith(expectedPrefix), "Timer text does not start with 'Resend in 04:'");	    
	}
	
	public void assertTermsOfUsePageInd() {
		WebElement txt_widget_title = entryPage.txt_widget_terms_privacy;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_widget_title));
	    
	    String actual = txt_widget_title.getText();
	    String expected = "Syarat & Ketentuan";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertPrivacyPolicyPageInd() {
		WebElement txt_widget_title = entryPage.txt_widget_terms_privacy;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_widget_title));
	    
	    String actual = txt_widget_title.getText();
	    String expected = "Kebijakan Privasi";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertRegisterLoginPage(){
		registerPage = new RegisterPage(android);
		
		WebElement txt_register_title = registerPage.txt_register_title;
		WebElement txt_fld_password = registerPage.txt_fld_password;
		WebElement btn_register_submit = registerPage.btn_register_login_submit;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_register_title));
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register_submit));
	    	    
	    Assert.assertTrue(txt_register_title.isDisplayed());

	    Assert.assertTrue(txt_fld_password.isDisplayed());

	    Assert.assertTrue(btn_register_submit.isDisplayed());
	}
	
	public void assertDropDownCountry(){
		WebElement txt_country_code = registerPage.txt_country_code;
		WebElement btn_country_1 = registerPage.btn_country_1;
		WebElement btn_country_2 = registerPage.btn_country_2;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_country_code));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_1));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_2));

	    String actual1 = txt_country_code.getText();
	    String expected1 = "Country Code";
	    Assert.assertEquals(actual1, expected1);
	    
	    String actual2 = btn_country_1.getText();
	    String expected2 = "Indonesia";
	    Assert.assertEquals(actual2, expected2);
	    
	    String actual3 = btn_country_2.getText();
	    String expected3 = "Malaysia";
	    Assert.assertEquals(actual3, expected3);
	}
	
	public void assertFilteredCountryKeyword(String keyword) {
		WebElement btn_country_1 = registerPage.btn_country_1;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_1));
	    
	    String actual = btn_country_1.getText();
	    String expected = keyword;
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertInvalidFilteredCountryKeyword() {
		WebElement txt_no_country_found = registerPage.txt_no_country_found;	
		String actual = txt_no_country_found.getText();
	    String expected = "No country code found.";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertPhoneFieldIsEmpty() {
		WebElement txt_fld_phone = registerPage.txt_fld_phone;	
		String actual = txt_fld_phone.getText();
	    String expected = "";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningPhoneNumber() {
		WebElement txt_warning_phone_number = registerPage.txt_warning_phone_number;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_phone_number));
	    
	    Assert.assertTrue(txt_warning_phone_number.isDisplayed());
	    
	    String actual = txt_warning_phone_number.getText();
	    String expected = "Phone number incorrect.";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningPasswordPhone() {
		WebElement txt_warning_password_phone = registerPage.txt_warning_password_phone;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_password_phone));
	    
	    Assert.assertTrue(txt_warning_password_phone.isDisplayed());
	    
	    String actual = txt_warning_password_phone.getText();
	    String expected = "Your password must be at least 8 characters with a mix of uppercase-lowercase letters and numbers";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningPasswordEmail() {
		WebElement txt_warning_password_email = registerPage.txt_warning_password_email;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_password_email));
	    
	    Assert.assertTrue(txt_warning_password_email.isDisplayed());
	    
	    String actual = txt_warning_password_email.getText();
	    String expected = "Password does not match the criteria.";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningOTPWrong() {
		WebElement txt_warning_otp = registerPage.txt_warning_otp;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_otp));
	    
	    Assert.assertTrue(txt_warning_otp.isDisplayed());
	    
	    String actual = txt_warning_otp.getText();
	    String expected = "Wrong OTP code";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningOTPExpired(){
		WebElement txt_warning_otp = registerPage.txt_warning_otp;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_otp));
	    
	    Assert.assertTrue(txt_warning_otp.isDisplayed());
	    
	    String actual = txt_warning_otp.getText();
	    String expected = "OTP Expired";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertPopUpExistingAccount(){
		WebElement txt_pop_up_existing_account = registerPage.txt_pop_up_existing_account;
		WebElement btn_login_pop_up = registerPage.btn_login_pop_up;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_pop_up_existing_account));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_pop_up));

	    Assert.assertTrue(txt_pop_up_existing_account.isDisplayed());
	    Assert.assertTrue(btn_login_pop_up.isDisplayed());

	    String actual = txt_pop_up_existing_account.getText();
	    String expected = "This account has been registered";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningOTPUsed(){
		WebElement txt_warning_otp = registerPage.txt_warning_otp;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_otp));
	    
	    Assert.assertTrue(txt_warning_otp.isDisplayed());
	    
	    String actual = txt_warning_otp.getText();
	    String expected = "err_otp_already_used_message";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertWelcomeText() {
		homePage = new HomePage(android);
		
		WebElement txt_welcome = homePage.txt_welcome;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_welcome));
	    
	    Assert.assertTrue(txt_welcome.isDisplayed());
	    
	    String actual = txt_welcome.getText();
	    String expected = "Hello!";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertDiscoverText(){
		homePage = new HomePage(android);
		
		WebElement txt_discover = homePage.txt_discover;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_discover));
	    
	    Assert.assertTrue(txt_discover.isDisplayed());
	    
	    String actual = txt_discover.getText();
	    String expected = "Discover profiles";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertArriveHomePage(){
		homePage = new HomePage(android);
		
		WebElement img_visionplus_logo = homePage.img_visionplus_logo;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_visionplus_logo));
	    
	    Assert.assertTrue(img_visionplus_logo.isDisplayed());
	}
	
	public void assertUnregisteredAccountText() {	
		loginPage = new LoginPage(android);

		WebElement txt_unregistered_account = loginPage.txt_unregistered_account;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_unregistered_account));
	    
	    Assert.assertTrue(txt_unregistered_account.isDisplayed());
	    
	    String actual = txt_unregistered_account.getText();
	    String expected = "This account has not been registered.";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertWrongEmailPasswordText() {	
		loginPage = new LoginPage(android);

		WebElement txt_wrong_email_password = loginPage.txt_wrong_email_password;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_wrong_email_password));
	    
	    Assert.assertTrue(txt_wrong_email_password.isDisplayed());
	    
	    String actual = txt_wrong_email_password.getText();
	    String expected = "Wrong email or password";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertManageProfile() {	
		settingPage = new SettingPage(android);

		WebElement txt_settings_section_manage_profile = settingPage.txt_settings_section_title;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_section_manage_profile));
	    
	    Assert.assertTrue(txt_settings_section_manage_profile.isDisplayed());
	    
	    String actual = txt_settings_section_manage_profile.getText();
	    String expected = "Manage profiles";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertAccount() {	
		settingPage = new SettingPage(android);

		WebElement txt_settings_section_account = settingPage.txt_settings_section_title;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_section_account));
	    
	    Assert.assertTrue(txt_settings_section_account.isDisplayed());
	    
	    String actual = txt_settings_section_account.getText();
	    String expected = "Account";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertNotificationCentre() {	
		settingPage = new SettingPage(android);

		WebElement txt_settings_section_notification_centre = settingPage.txt_settings_section_title;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_section_notification_centre));
	    
	    Assert.assertTrue(txt_settings_section_notification_centre.isDisplayed());
	    
	    String actual = txt_settings_section_notification_centre.getText();
	    String expected = "Notification centre";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertHelpCentre() {	
		settingPage = new SettingPage(android);

		WebElement txt_settings_section_help_centre = settingPage.txt_settings_section_help_centre;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_section_help_centre));
	    
	    Assert.assertTrue(txt_settings_section_help_centre.isDisplayed());
	    
	    String actual = txt_settings_section_help_centre.getText();
	    String expected = "Help Center";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertAboutUs() {	
		settingPage = new SettingPage(android);

		WebElement txt_help_section_About_Us = settingPage.txt_help_section_About_Us;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_help_section_About_Us));

	    Assert.assertTrue(txt_help_section_About_Us.isDisplayed());

	    String actual = txt_help_section_About_Us.getText();
	    String expected = "About Us";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertSubscriptionTransaction() {	
		settingPage = new SettingPage(android);

		WebElement txt_help_section_Subcription = settingPage.txt_help_section_Subcription;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_help_section_Subcription));
		
	    Assert.assertTrue(txt_help_section_Subcription.isDisplayed());
	    
	    String actual = txt_help_section_Subcription.getText();
	    String expected = "Subcription & Transaction";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertVisionPlusOriginalsList() {	
		vplusOriginalPage = new VPlusOriginalsPage(android);

		WebElement img_cinlock = vplusOriginalPage.img_cinlock;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_cinlock));
		
	    Assert.assertTrue(img_cinlock.isDisplayed());
	}
	
	public void assertVODIsNotPlayable() {	
		vodDetailPage = new VODDetailPage(android);

		WebElement btn_subscribe = vodDetailPage.btn_subscribe;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_subscribe));
		
	    Assert.assertTrue(btn_subscribe.isDisplayed());
	}
	
	public void assertLiveTVPlayed() {
	    liveTvPage = new LiveTVPage(android);
	    WebElement btn_subscribe = liveTvPage.btn_subscribe;
	   

	    Assert.assertFalse(isElementPresent(btn_subscribe));
	}

	public boolean isElementPresent(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

	
	public void assertLiveTVNotPlayed(){
			liveTvPage = new LiveTVPage(android);
			wait = new WebDriverWait(android, Duration.ofSeconds(90));
			WebElement btn_subscribe = liveTvPage.btn_subscribe;
		    wait.until(ExpectedConditions.visibilityOf(btn_subscribe));
			Assert.assertTrue(btn_subscribe.isDisplayed());
	}
	
	public void assertVODDetails() {	
		vodDetailPage = new VODDetailPage(android);

		WebElement btn_dislike = vodDetailPage.btn_dislike;
		WebElement btn_like = vodDetailPage.btn_like;
		WebElement btn_save = vodDetailPage.btn_save;
		WebElement btn_share = vodDetailPage.btn_share;
		WebElement btn_watch = vodDetailPage.btn_watch;
		WebElement img_rating_bar = vodDetailPage.img_rating_bar;
		WebElement txt_content_description = vodDetailPage.txt_content_description;
		WebElement txt_content_title = vodDetailPage.txt_content_title;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_content_title));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_content_description));
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_rating_bar));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_watch));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_share));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_save));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_like));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_dislike));

		
	    Assert.assertTrue(txt_content_title.isDisplayed());
	    Assert.assertTrue(txt_content_description.isDisplayed());
	    Assert.assertTrue(img_rating_bar.isDisplayed());
	    Assert.assertTrue(btn_watch.isDisplayed());
	    Assert.assertTrue(btn_share.isDisplayed());
	    Assert.assertTrue(btn_save.isDisplayed());
	    Assert.assertTrue(btn_like.isDisplayed());
	    Assert.assertTrue(btn_dislike.isDisplayed());
	}
}
