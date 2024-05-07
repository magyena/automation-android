package id.visionplus.v2.Action;
/* Created Date	: 21 March 2024
 * Updated by	: Michael
 * Updated Date	: 4 April 2024
 * Summary		: Add Click Watchlist
 * 1. Adding Click Watchlist, only for watchlist Content
 * */


import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Media;

import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.PageObjects.BuyPackagePage;
import id.visionplus.v2.PageObjects.CategoryPage;
import id.visionplus.v2.PageObjects.EntryPage;
import id.visionplus.v2.PageObjects.HomePage;
import id.visionplus.v2.PageObjects.LiveTVPage;
import id.visionplus.v2.PageObjects.LoginPage;
import id.visionplus.v2.PageObjects.MediaPlayerPage;
import id.visionplus.v2.PageObjects.OutsideApp;
import id.visionplus.v2.PageObjects.PopUpPage;
import id.visionplus.v2.PageObjects.ProgramGuidePage;
import id.visionplus.v2.PageObjects.RegisterPage;
import id.visionplus.v2.PageObjects.SearchPage;
import id.visionplus.v2.PageObjects.SettingPage;
import id.visionplus.v2.PageObjects.TransactionHistoryPage;
import id.visionplus.v2.PageObjects.VODDetailPage;
import id.visionplus.v2.PageObjects.VPlusOriginalsPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Click extends BaseTest {
	WebDriverWait wait;
	Scroll scroll;
	EntryPage entryPage;
	RegisterPage registerPage;
	LoginPage loginPage;
	HomePage homePage;
	SettingPage settingPage;
	VODDetailPage vodDetailPage;
	LiveTVPage liveTvPage;
	VPlusOriginalsPage vplusOriginalPage;
	OutsideApp outsideApp;
	SearchPage searchPage;
	TransactionHistoryPage transactionhistoryPage;
	ProgramGuidePage programguidepage;
	CategoryPage categorypage ;
	PopUpPage popuppage;
	BuyPackagePage buypackage;
	MediaPlayerPage mediaplayerpage;

	public void pressBack(){
        (android).pressKey(new KeyEvent(AndroidKey.BACK));
	}
  
	public void clickRandom() {
		// Get the dimensions of the browser window
		long window_width = (long) android.executeScript("return window.innerWidth");
		long window_height = (long) android.executeScript("return window.innerHeight");

		// Create an instance of the Random class
		Random random = new Random();

		// Generate random coordinates within the window boundaries
		int x = random.nextInt((int) window_width);
		int y = random.nextInt((int) window_height);

		// Perform a click action at the random coordinates
		Actions action = new Actions(android);
		action.moveByOffset(x, y).click().perform();
	}

	public void clickSearchField() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_fld_search = searchPage.txt_fld_search;

		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_search));
		txt_fld_search.click();
	}

	public void clickSearchLiveTv() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_search_live_tv_rcti = searchPage.img_search_live_tv_rcti;

		wait.until(ExpectedConditions.visibilityOfAllElements(img_search_live_tv_rcti));
		img_search_live_tv_rcti.click();
	}

	public void clickSearchVOD() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_search_vod_arab_maklum = searchPage.img_search_vod_arab_maklum;

		wait.until(ExpectedConditions.visibilityOfAllElements(img_search_vod_arab_maklum));
		img_search_vod_arab_maklum.click();
	}

	public void clickNextEpisode() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_next_episode = outsideApp.btn_next_episode;

		wait.until(ExpectedConditions.visibilityOfAllElements(btn_next_episode));
		btn_next_episode.click();
	}

	public void clickLoginByFacebook() {
		loginPage = new LoginPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_login_by_facebook = loginPage.btn_login_by_facebook;

		wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_by_facebook));
		btn_login_by_facebook.click();
	}
	
	public void clickForgotPassword(){
		loginPage = new LoginPage(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement btn_forgot_password = loginPage.btn_forgot_password;

		wait.until(ExpectedConditions.visibilityOfAllElements(btn_forgot_password));
		btn_forgot_password.click();
	}
	public void clickPhoneNumberFieldForgot(){
		WebDriverWait wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    int attempts = 0;
	    while (attempts < 3) {
	        try {
	            WebElement phoneNumberElement = android.findElement(By.xpath("//android.widget.TextView[@text='Phone Number']/following::android.widget.EditText[1]"));
	            wait.until(ExpectedConditions.visibilityOf(phoneNumberElement));
	            phoneNumberElement.click();
	            break; // If successfully clicked, exit the loop
	        } catch (StaleElementReferenceException e) {
	            attempts++;
	        }
	    }
	}
	
	public void clickFacebookLoginButton(){
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_login_facebook = outsideApp.btn_login_facebook;

		if (btn_login_facebook.isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_facebook));
			btn_login_facebook.click();
		}
	}

	public void clickContinueAsAccountFacebook() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_continue_as_facebook = outsideApp.btn_continue_as_facebook;

		wait.until(ExpectedConditions.visibilityOfAllElements(btn_continue_as_facebook));
		btn_continue_as_facebook.click();
	}

	public void clickLogin() {
		entryPage = new EntryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_login = entryPage.btn_login;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_login));
		btn_login.click();
	}

	public void clickGoogleSingleSignOn() {
		loginPage = new LoginPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_login_by_google = loginPage.btn_login_by_google;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_by_google));
		btn_login_by_google.click();
	}

	public void click_1st_google_account() {
		loginPage = new LoginPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_google_account_1 = loginPage.btn_google_account_1;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_google_account_1));
		btn_google_account_1.click();
	}

	public void clickTerms() {
		entryPage = new EntryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_terms_of_use = entryPage.btn_terms_of_use;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_terms_of_use));
		btn_terms_of_use.click();
	}

	public void clickPrivacy() {
		entryPage = new EntryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_privacy_policy = entryPage.btn_privacy_policy;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_privacy_policy));
		btn_privacy_policy.click();
	}

	public void clickRegister() {
		entryPage = new EntryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_register = entryPage.btn_register;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_register));
		btn_register.click();
	}

	public void clickCountry() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement icon_country_code = registerPage.icon_country_code;
		wait.until(ExpectedConditions.visibilityOfAllElements(icon_country_code));
		icon_country_code.click();
	}

	public void clickFieldCountry() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_fld_country_code = registerPage.txt_fld_country_code;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_country_code));
		txt_fld_country_code.click();
	}

	public void clickCloseCountry() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_close_country = registerPage.btn_close_country_code;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_close_country));
		btn_close_country.click();
	}

	public void clickFieldPhoneNumber() {
		WebDriverWait wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    int attempts = 0;
	    while (attempts < 3) {
	        try {
	            WebElement phoneNumberElement = android.findElement(By.xpath("//android.widget.TextView[@text='Phone Number']/following::android.widget.EditText[1]"));
	            wait.until(ExpectedConditions.visibilityOf(phoneNumberElement));
	            phoneNumberElement.click();
	            break; // If successfully clicked, exit the loop
	        } catch (StaleElementReferenceException e) {
	            attempts++;
	        }
	    }
	}

	public void clickFieldEmail() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_fld_email = registerPage.txt_fld_email;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_email));
		txt_fld_email.click();
	}

	public void clickFieldPassword() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_fld_password = registerPage.txt_fld_password;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
		txt_fld_password.click();
	}

	public void clickSendOTP() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_send_otp = registerPage.btn_send_otp;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_send_otp));
		btn_send_otp.click();
	}

	public void clickPasswordVisible() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_password_visible = registerPage.img_password_visible;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_password_visible));
		img_password_visible.click();
	}

	public void clickOtpFld() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement fld_otp = registerPage.fld_otp;
		wait.until(ExpectedConditions.visibilityOfAllElements(fld_otp));
		fld_otp.click();
	}

	public void clickLoginPopUp() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_login_pop_up = registerPage.btn_login_pop_up;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_pop_up));
		btn_login_pop_up.click();
	}

	public void clickRegisterLoginSubmitButton() {
		registerPage = new RegisterPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_register_login_submit = registerPage.btn_register_login_submit;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_register_login_submit));
		btn_register_login_submit.click();
	}

	public void clickRegisterLoginByEmailSection() {
		loginPage = new LoginPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_login_by_email_section = loginPage.btn_login_by_email_section;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_by_email_section));
		btn_login_by_email_section.click();
	}
	
	public void clickChangeAvatar() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_change_avatar = homePage.img_change_avatar;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_change_avatar));
		img_change_avatar.click();
	}
	
	public void click2ndAvatar() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_avatar_2 = homePage.img_avatar_2;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_avatar_2));
		img_avatar_2.click();
	}

	public void clickFirstProfile() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_1st_profile = homePage.img_1st_profile;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_1st_profile));
		img_1st_profile.click();
	}
	
	public void clickLastProfile() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_last_profile = homePage.img_last_profile;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_last_profile));
		img_last_profile.click();
	}

	public void clickSkip() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_skip = homePage.btn_skip;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_skip));
		btn_skip.click();
	}

	public void clickContinue() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_continue = homePage.btn_continue;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_continue));
		btn_continue.click();
	}

	public void clickMenuButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_menu = homePage.btn_menu;

		wait.until(ExpectedConditions.visibilityOfAllElements(btn_menu));
		btn_menu.click();
	}

	public void clickSettingsButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_settings = homePage.btn_settings;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_settings));
		btn_settings.click();
	}

	public void clickProfileButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_profile = homePage.btn_profile;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_profile));
		btn_profile.click();
	}

	public void clickAddProfileButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_add_profile = homePage.btn_add_profile;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile));
		btn_add_profile.click();
	}

	public void clickAddProfileOKButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_add_profile_ok = homePage.btn_add_profile_ok;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile_ok));
		btn_add_profile_ok.click();
	}

	public void clickMyDownloads() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_my_download = homePage.btn_my_download;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_my_download));
		btn_my_download.click();
	}

	public void clickAddProfileDoneButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_add_profile_done = homePage.btn_add_profile_done;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile_done));
		btn_add_profile_done.click();
	}

	public void clickTextFieldProfileName() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_fld_add_profile_name = homePage.txt_fld_add_profile_name;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_add_profile_name));
		txt_fld_add_profile_name.click();
	}

	public void clickAddProfileCancelButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_add_profile_cancel = homePage.btn_add_profile_cancel;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile_cancel));
		btn_add_profile_cancel.click();
	}

	public void clickProfileWarningOkButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_existing_profile_ok = homePage.btn_existing_profile_ok;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_existing_profile_ok));
		btn_existing_profile_ok.click();
	}

	public void clickProfileAlmostDoneCancelButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_cancel_almost_done = homePage.btn_cancel_almost_done;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_cancel_almost_done));
		btn_cancel_almost_done.click();
	}

	public void clickLatestProfile(By locator) {
		settingPage = new SettingPage(android);
		WebElement btn_latest_profile = android.findElement(locator);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_latest_profile));
		btn_latest_profile.click();
	}

	public void clickDeleteProfile() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_delete_profile = settingPage.btn_delete_profile;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_delete_profile));
		btn_delete_profile.click();
	}

	public void clickConfirmationDeleteProfile(){
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_delete_confirmation = settingPage.btn_delete_confirmation;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_delete_confirmation));
		btn_delete_confirmation.click();
	}

	public void clickSearchButton() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_search = homePage.btn_search;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_search));
		btn_search.click();
	}

	public void clickHelpButton() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_help = settingPage.btn_help;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_help));
		btn_help.click();
	}
	
	public void clickHelpCenterButton() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_help_center = settingPage.btn_help_center;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_help_center));
		btn_help_center.click();
	}

	public void clickManageProfile() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_manage_profile = settingPage.btn_manage_profile;

		wait.until(ExpectedConditions.visibilityOf(btn_manage_profile));
		btn_manage_profile.click();
	}

	public void clickNotificationCentre() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_notification_centre = settingPage.btn_notification_centre;

		wait.until(ExpectedConditions.visibilityOf(btn_notification_centre));
		btn_notification_centre.click();
	}

	public void clickLegalInformation() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_legal_information = settingPage.btn_legal_information;

		wait.until(ExpectedConditions.visibilityOf(btn_legal_information));
		btn_legal_information.click();
	}

	public void clickTermsOfUse() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_terms_of_use = settingPage.btn_terms_of_use;

		wait.until(ExpectedConditions.visibilityOf(btn_terms_of_use));
		btn_terms_of_use.click();
	}

	public void clickVoucher() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_voucher = settingPage.btn_voucher;

		wait.until(ExpectedConditions.visibilityOf(btn_voucher));
		btn_voucher.click();
	}

	public void clickVoucherField() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_fld_voucher = settingPage.txt_fld_voucher;

		wait.until(ExpectedConditions.visibilityOf(txt_fld_voucher));
		txt_fld_voucher.click();
	}

	public void clickRedeemVoucher() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_redeem = settingPage.btn_redeem;

		wait.until(ExpectedConditions.visibilityOf(btn_redeem));
		btn_redeem.click();
	}

	public void clickPrivacyPolicy() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_privacy_policy = settingPage.btn_privacy_policy;

		wait.until(ExpectedConditions.visibilityOf(btn_privacy_policy));
		btn_privacy_policy.click();
	}

	public void clickSoftwareLicenses() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_software_licenses = settingPage.btn_software_licenses;

		wait.until(ExpectedConditions.visibilityOf(btn_software_licenses));
		btn_software_licenses.click();
	}

	public void clickEmailInHelp() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_help_email = settingPage.btn_help_email;

		wait.until(ExpectedConditions.visibilityOf(btn_help_email));
		btn_help_email.click();
	}

	public void clickWhatsAppInHelp() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_help_whatsApp = settingPage.btn_help_whatsApp;

		wait.until(ExpectedConditions.visibilityOf(btn_help_whatsApp));
		btn_help_whatsApp.click();
	}

	public void clickSettingsBackButton() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_back = settingPage.btn_back;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_back));
		btn_back.click();
	}

	public void clickAboutUs() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_help_about_us = settingPage.btn_help_about_us;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_help_about_us));
		btn_help_about_us.click();
	}

	public void clickSubscriptionTransaction() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_help_subscription_transaction = settingPage.btn_help_subscription_transaction;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_help_subscription_transaction));
		btn_help_subscription_transaction.click();
	}

	public void clickBackToHelp() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_back_to_help = settingPage.btn_back_to_help;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_back_to_help));
		btn_back_to_help.click();
	}

	public void clickCloseToSettings() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_help_close = settingPage.btn_help_close;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_help_close));
		btn_help_close.click();
	}

	public void clickSettingsProfile() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_profile = settingPage.btn_profile;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_profile));
		btn_profile.click();
	}

	public void clickTransactionHistory() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_transaction_history = settingPage.btn_transaction_history;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_transaction_history));
		btn_transaction_history.click();
	}

	public void clickLogout() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_logout = settingPage.btn_logout;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_logout));
		btn_logout.click();
	}

	public void clickVODBanner() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_banner_info = homePage.img_banner_info;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_banner_info));
		img_banner_info.click();
	}

	public void clickBack() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_back = vodDetailPage.btn_back;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_back));
		btn_back.click();
	}

	public void clickViewAll() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_view_all = homePage.btn_view_all;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_view_all));
		btn_view_all.click();
	}

	public void clickSeriesInTop60() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_top_60_series = homePage.img_top_10_series;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_top_60_series));
		img_top_60_series.click();
	}

	public void clickVisionPlusOriginalsSeries() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_visionplus_originals_content = homePage.img_visionplus_originals_content;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_visionplus_originals_content));
		img_visionplus_originals_content.click();
	}
	
	public void clickVisionPlusOriginals() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_visionplus_originals_cluster_content = homePage.img_visionplus_originals_cluster_content;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_visionplus_originals_cluster_content));
		img_visionplus_originals_cluster_content.click();
	}
	
	public void clickWatchlist() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_watchlist_content = homePage.img_watchlist_content;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_watchlist_content));
		img_watchlist_content.click();
	}
	
	public void clickVisionPlusTop1Series() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_visionplus_originials_top_1_content = homePage.img_visionplus_originials_top_1_content;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_visionplus_originials_top_1_content));
		img_visionplus_originials_top_1_content.click();
	}

	public void clickVisionPlusOriginalSeriesContent() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_vod_1 = vplusOriginalPage.img_vod_1;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_vod_1));
		img_vod_1.click();
	}	
	public void clickTvLoveCinemaContent(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_tv_love_cinema_content = homePage.img_tv_love_cinema_content;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_tv_love_cinema_content));
	    img_tv_love_cinema_content.click();
	}

	public void clickSubscribe() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(30));
		WebElement btn_subscribe = vodDetailPage.btn_subscribe;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_subscribe));
		btn_subscribe.click();
	}

	public void clickLikeVOD() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_like = vodDetailPage.btn_like;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_like));
		btn_like.click();
	}

	public void clickDislikeVOD() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_dislike = vodDetailPage.btn_dislike;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_dislike));
		btn_dislike.click();
	}

	public void clickShareVOD() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_share = vodDetailPage.btn_share;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_share));
		btn_share.click();
	}

	public void clickWatchTrailer() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_trailer = vodDetailPage.btn_trailer;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_trailer));
		btn_trailer.click();
	}

	public void clickSynopsis() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_content_description = vodDetailPage.txt_content_description;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_content_description));
		txt_content_description.click();
	}

	public void clickSaveToWatchlist() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_save = vodDetailPage.btn_save;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_save));
	
		//If Already Saved don't Click
		WebElement txt_btn_save = vodDetailPage.txt_btn_save;
		String actual = txt_btn_save.getText();
		
		if (actual.equals("Add to List")) {
	        btn_save.click();
	    } else {
	        System.out.println("The Save button is already turned on. No action taken.");
	    }
	}
	
	public void clickAddWatchlist() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_save = vodDetailPage.btn_save;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_save));
		btn_save.click();
	}
	
	public void clickDeleteToWatchlist() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_save = vodDetailPage.btn_save;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_save));
	
		//If Already Saved Click
		WebElement txt_btn_save = vodDetailPage.txt_btn_save;
		String actual = txt_btn_save.getText();
		
		if (actual.equals("Remove from List")) {
	        btn_save.click();
	    } else {
	        System.out.println("The Save button is already turned off. No action taken.");
	    }
	}

	public void clickCopyLink() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_copy_link = vodDetailPage.btn_copy_link;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_copy_link));
		btn_copy_link.click();
	}

	public void clickEps1VOD() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_eps_1_vod = vodDetailPage.img_eps_1_vod;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_eps_1_vod));
		img_eps_1_vod.click();
	}
	
	public void clickSeasonSpinner() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_season = vodDetailPage.btn_season;

		wait.until(ExpectedConditions.visibilityOf(btn_season));
		btn_season.click();
	}
	
	public void clickSeason1() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_ddl_season_1 = vodDetailPage.btn_ddl_season_1;

		wait.until(ExpectedConditions.visibilityOf(btn_ddl_season_1));
		btn_ddl_season_1.click();
	}

	public void clickEpsDownloadVOD() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_download = vodDetailPage.btn_download;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_download));
		btn_download.click();
	}

	public void clickEpsPremiumVOD() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_eps_premium_vod = vodDetailPage.img_eps_premium_vod;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_eps_premium_vod));
		img_eps_premium_vod.click();
	}

	public void clickWatchVOD() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_watch = vodDetailPage.btn_watch;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_watch));
		btn_watch.click();
	}

	public void clickLiveTv() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_live_tv = homePage.btn_live_tv;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_live_tv));
		btn_live_tv.click();
	}

	public void clikDetailChannel() {  
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_detail_channel = liveTvPage.btn_detail_channel;
		wait.until(ExpectedConditions.visibilityOf(btn_detail_channel));
		btn_detail_channel.click();
	}

	public void clickSampleVod() {  
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement sampleVod = vplusOriginalPage.sample_vod;
		wait.until(ExpectedConditions.visibilityOf(sampleVod));
		sampleVod.click();
	}

	public void clickSampleVodEps1() {  
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement sampleVodeps1 = vodDetailPage.sample_the_one_eps1;
		wait.until(ExpectedConditions.visibilityOf(sampleVodeps1));
		sampleVodeps1.click();
	}

	public void clickConfirmDownload() {  
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement confirm_download = vodDetailPage.btn_confirm_download;
		wait.until(ExpectedConditions.visibilityOf(confirm_download));
		confirm_download.click();
	}

	public void clickCancelDownload() { 
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement cancel_download = vodDetailPage.btn_cancel_download;
		wait.until(ExpectedConditions.visibilityOf(cancel_download));
		cancel_download.click();
	}

	public void clickfilterAllStatusTransactionHistory() { 
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement filter_all_status = transactionhistoryPage.btn_all_status;
		wait.until(ExpectedConditions.visibilityOf(filter_all_status));
		filter_all_status.click();
	}

	public void clickfilterSuccessTransactionHistory() {  
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement filter_success = transactionhistoryPage.btn_all_success;
		wait.until(ExpectedConditions.visibilityOf(filter_success));
		filter_success.click();
	}

	public void clickfilterFailedTransactionHistory() {  
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement filter_failed = transactionhistoryPage.btn_all_failed;
		wait.until(ExpectedConditions.visibilityOf(filter_failed));
		filter_failed.click();
	}

	public void clickfilterPendingTransactionHistory() { 
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement filter_pending = transactionhistoryPage.btn_all_pending;
		wait.until(ExpectedConditions.visibilityOf(filter_pending));
		filter_pending.click();
	}

	public void clickCloseSettings() {  
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_close = transactionhistoryPage.btn_close;
		wait.until(ExpectedConditions.visibilityOf(btn_close));
		btn_close.click();
	}

	public void clickAllTransactions() {  
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement All_Transaction = transactionhistoryPage.sample_all_transaction;
		wait.until(ExpectedConditions.visibilityOf(All_Transaction));
		All_Transaction.click();
	}

	public void clickSuccessTransactions() { 
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement Success_Transaction = transactionhistoryPage.sample_success_transaction;
		wait.until(ExpectedConditions.visibilityOf(Success_Transaction));
		Success_Transaction.click();
	}

	public void clickFailedTransactions() {  
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement Failed_Transaction = transactionhistoryPage.sample_failed_transaction;
		wait.until(ExpectedConditions.visibilityOf(Failed_Transaction));
		Failed_Transaction.click();
	}

	public void clickBuyAgainSuccess() { 
		transactionhistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement buy_again_success = transactionhistoryPage.btn_buy_again;
		wait.until(ExpectedConditions.visibilityOf(buy_again_success));
		buy_again_success.click();
	}

	public void clickInewsTv() {  
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_inews = liveTvPage.img_inews_tv;
		wait.until(ExpectedConditions.visibilityOf(img_inews));
		img_inews.click();
	}

	public void clickBtnPlayBanner() { 
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(3));
		WebElement btn_play = homePage.btn_play_lastBanner;
		wait.until(ExpectedConditions.visibilityOf(btn_play));
		btn_play.click();
	}

	public void clickBtnProgramGuide() { 
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(3));
		WebElement btn_program_guide = homePage.btn_program_guide;
		wait.until(ExpectedConditions.visibilityOf(btn_program_guide));
		btn_program_guide.click();
	}
	
	public void clickguide3() { 
		programguidepage = new ProgramGuidePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(3));
		WebElement disable_guide3 = programguidepage.disable_guide3;
		wait.until(ExpectedConditions.visibilityOf(disable_guide3));
		disable_guide3.click();
	}

	public void clickbtnBackGuide() {  
		programguidepage = new ProgramGuidePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(3));
		WebElement btn_back = programguidepage.btn_back;
		wait.until(ExpectedConditions.visibilityOf(btn_back));
		btn_back.click();
	}

	public void clickBtnWatchGuide() { 
		programguidepage = new ProgramGuidePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(3));
		WebElement btn_watch = programguidepage.btn_watch;
		wait.until(ExpectedConditions.visibilityOf(btn_watch));
		btn_watch.click();
	}
	
	public void clickLinearChannelCluster() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_live_tv = homePage.img_live_tv_cluster;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_live_tv));
		img_live_tv.click();
	}
	
	public void clickBtnProfilePlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_profile_playstore = outsideApp.btn_profile_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_profile_playstore));
		btn_profile_playstore.click();
	}
	
	public void clickBtnPaymentandSubscriptionsPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_payments_subscriptions = outsideApp.btn_Payment_Subscriptions_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_payments_subscriptions));
		btn_payments_subscriptions.click();
	}

	public void clickBtnSubscriptionsPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(30));
		WebElement btn_subscriptions = outsideApp.btn_subscriptions_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_subscriptions));
		btn_subscriptions.click();
	}
	
	public void clickBtnSubscriptionsPlaystoreagain() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_subscriptions_again = outsideApp.btn_subscriptions_playstore_again;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_subscriptions_again));
		btn_subscriptions_again.click();
	}

	public void clickHistoryPremium30DaysPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement history_Premium = outsideApp.history_premium_30_days_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(history_Premium));
		history_Premium.click();
	}

	public void clickHistoryPremiumSport30DaysPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement history_Premium_sports = outsideApp.history_premium_sports_30_days_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(history_Premium_sports));
		history_Premium_sports.click();
	}
	
	public void clickCancelSubscriptionPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement btn_cancel_subscriptions = outsideApp.btn_cancel_subscription_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_cancel_subscriptions));
		btn_cancel_subscriptions.click();
	}
	
	public void clickBtnNoThanksPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement btn_no_thanks = outsideApp.btn_no_thanks;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_no_thanks));
		btn_no_thanks.click();
	}
	
	public void clickRadioCancelPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement radio_btn = outsideApp.btn_radio_cancel_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(radio_btn));
		radio_btn.click();
	}
	
	public void clickBtnContinuePlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement btn_continue = outsideApp.btn_continue_play_store;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_continue));
		btn_continue.click();
	}
	
	public void clickConfirmCancelPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement btn_confirm_cancel = outsideApp.btn_confirm_cancel_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_confirm_cancel));
		btn_confirm_cancel.click();
	}
	
	public void clickBacktoHistory() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_back = outsideApp.btn_back_to_list_history_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_back));
		btn_back.click();
	}
	
	public void clickClusterSlideMovies() {
		categorypage = new CategoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement movies = categorypage.slide_cluster_movies_categorypage;
		wait.until(ExpectedConditions.visibilityOfAllElements(movies));
		movies.click();
	}
	
	public void clickActionCategory() {
		categorypage = new CategoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement action_category = categorypage.action_category_categorypage;
		wait.until(ExpectedConditions.visibilityOfAllElements(action_category));
		action_category.click();
	}
	
	public void clickContentActionCategoryPage() {
		categorypage = new CategoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement content_action_category = categorypage.content_below_cluster_Best_Korean_Action;
		wait.until(ExpectedConditions.visibilityOfAllElements(content_action_category));
		content_action_category.click();
	}
	
	public void clickPremium30daysPckages() {
		popuppage = new PopUpPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement premium_30days = popuppage.txt_package_premium30days;
		wait.until(ExpectedConditions.visibilityOfAllElements(premium_30days));
		premium_30days.click();
	}
	
	public void clickBtnSubscribePlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_subscribe = outsideApp.btn_subscribe_playstore;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_subscribe));
		btn_subscribe.click();
	}
	
	public void clickBtnAccept() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(30));
		WebElement btn_accept = outsideApp.btn_accept;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_accept));
		btn_accept.click();
	}
	
	public void clickBtnBack() {
		categorypage = new CategoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_back = categorypage.btn_back_categorypage;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_back));
		btn_back.click();
	}
	
	public void clickMyPackage() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_mypackage = homePage.btn_buy_package;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_mypackage));
		btn_mypackage.click();
	}
	
	public void clickPremiumSports30daysPackage() {
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement premium_sports = buypackage.txt_package_premiumsports30_days;
		wait.until(ExpectedConditions.visibilityOfAllElements(premium_sports));
		premium_sports.click();
	}
	
	public void clickMenuHome() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement menu_home = homePage.img_home;
		wait.until(ExpectedConditions.visibilityOfAllElements(menu_home));
		menu_home.click();
	}
	
	public void clickBtnGotIt() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(30));
		WebElement btn_gotit = outsideApp.btn_got_it;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_gotit));
		btn_gotit.click();
	}
	
	public void clickSettingsAccountNumberorEmail() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_account_number_email = settingPage.btn_account_email_handphone;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_account_number_email));
		btn_account_number_email.click();
	}
	
	public void clickChangePassword() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_change_password = settingPage.txt_account_Change_password;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_change_password));
		txt_change_password.click();
	}
	
	public void clickNextChangePassword() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_next = settingPage.btn_account__change_password_next;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_next));
		btn_next.click();
	}
	
	public void clickBtnSuccessBack() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_back_success = settingPage.btn_back_success;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_back_success));
		btn_back_success.click();
	}
	
	public void clickBtnOKChangePasswordFailed() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_close = settingPage.btn_Close;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_close));
		btn_close.click();
	}
	
	public void clickProfilesHaveBeenDeleted() {
		popuppage = new PopUpPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_ok = popuppage.txt_profiles_have_been_deleted;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_ok));
		btn_ok.click();
	}
	
	public void clickDeleteAccount() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_delete_account = settingPage.txt_delete_account;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_delete_account));
		txt_delete_account.click();
	}

	public void clickCheckBoxDeleteAccount() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement checkbox_delete_account = settingPage.btn_checkbox;
		wait.until(ExpectedConditions.visibilityOfAllElements(checkbox_delete_account));
		checkbox_delete_account.click();
	}

	public void clickBtnKeepAccount() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_keep_account = settingPage.btn_keep_account;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_keep_account));
		btn_keep_account.click();
	}
	

	public void clickBtnProceedDeletedAccount() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_proceed_delete_account = settingPage.btn_proceed_delete_account;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_proceed_delete_account));
		btn_proceed_delete_account.click();
	}
	
	public void clickBtnConfirmationDeleteAccount() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement btn_confirm_delete = settingPage.btn_confirm_deleted_account;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_confirm_delete));
		btn_confirm_delete.click();
	}
	
	public void clickVODComingSoon1() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement coming_soon_1 = vplusOriginalPage.coming_soon_vod_1;
		wait.until(ExpectedConditions.visibilityOfAllElements(coming_soon_1));
		coming_soon_1.click();
	}
	
	public void clickVODComingSoon2() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement coming_soon_2 = vplusOriginalPage.coming_soon_vod_2;
		wait.until(ExpectedConditions.visibilityOfAllElements(coming_soon_2));
		coming_soon_2.click();
	}
	
	public void clickVODComingSoon3() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement coming_soon_3 = vplusOriginalPage.coming_soon_vod_3;
		wait.until(ExpectedConditions.visibilityOfAllElements(coming_soon_3));
		coming_soon_3.click();
	}
	
	public void clickVODSinners() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_sinners = vplusOriginalPage.img_sinners;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_sinners));
		img_sinners.click();
	}
	
	public void clickVODRadio() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_radio = vplusOriginalPage.img_radio;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_radio));
		img_radio.click();
	}
	
	public void clickVOD12Hari() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_12hari = vplusOriginalPage.img_12Hari;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_12hari));
		img_12hari.click();
	}
	
	public void clickVODPrince() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_prince = vplusOriginalPage.img_prince;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_prince));
		img_prince.click();
	}
	
	public void clickVODPiknik() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_piknik = vplusOriginalPage.img_piknik;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_piknik));
		img_piknik.click();
	}
	
	public void clickVODKatanya() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_katanya = vplusOriginalPage.img_katanya;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_katanya));
		img_katanya.click();
	}
	
	public void clickVODadaDewa() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_dewa = vplusOriginalPage.img_Ada_dewa;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_dewa));
		img_dewa.click();
	}
	
	public void clickVODCatatanAkhirSekolah() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_catatan_akhir_sekolah = vplusOriginalPage.img_catatan_akhir_sekolah;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_catatan_akhir_sekolah));
		img_catatan_akhir_sekolah.click();
	}
	
	public void clickVODComic() {
		vplusOriginalPage = new VPlusOriginalsPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_comic = vplusOriginalPage.img_comic;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_comic));
		img_comic.click();
	}
	
	public void clickManageDevices() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_manage_devices = settingPage.txt_Manage_Devices;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_manage_devices));
		txt_manage_devices.click();
	}
	
	public void clickListDevices() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement list_devices = settingPage.list_connected_devices;
		wait.until(ExpectedConditions.visibilityOfAllElements(list_devices));
		list_devices.click();
	}
	
	public void clickDisconnectDevices() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement disconnect_devices = settingPage.disconnect_devices;
		wait.until(ExpectedConditions.visibilityOfAllElements(disconnect_devices));
		disconnect_devices.click();
	}
	
	public void clickConfirmDisconnectDevices() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement btn_disconnect_devices = settingPage.btn_confirm_disconnect_devices;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_disconnect_devices));
		btn_disconnect_devices.click();
	}
	
	public void clickVodCintaDiBalikAwan() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement vod_cinta = searchPage.vod_cinta_di_balik_awan;
		wait.until(ExpectedConditions.visibilityOfAllElements(vod_cinta));
		vod_cinta.click();
	}
	
	public void clickContentClusterNewRelease() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement content_cluster_new_release = homePage.content_cluster_new_release;
		wait.until(ExpectedConditions.visibilityOfAllElements(content_cluster_new_release));
		content_cluster_new_release.click();
	}
	
	public void clickFirstContentClusterVPlusOriginals() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement FirstContent = homePage.img_First_Vod_VPlusOriginals;
		wait.until(ExpectedConditions.visibilityOfAllElements(FirstContent));
		FirstContent.click();
	}
	
	public void clickFastForwardMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement forward = mediaplayerpage.btn_forward_media_playerpage;
		wait.until(ExpectedConditions.visibilityOfAllElements(forward));
		forward.click();
	}
	
	public void clickRewinddMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement rewind = mediaplayerpage.btn_rewind_media_playerpage;
		wait.until(ExpectedConditions.visibilityOfAllElements(rewind));
		rewind.click();
	}
	
	public void clickLayoutMediaPLayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement layout_mediaplayer = mediaplayerpage.layout_media_player;
		wait.until(ExpectedConditions.visibilityOfAllElements(layout_mediaplayer));
		layout_mediaplayer.click();
	}
	
	public void clickRestartMediaPlayer() {
	    mediaplayerpage = new MediaPlayerPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(10));
	    WebElement restart_mediaplayer = mediaplayerpage.btn_restart_media_playerpage;
	    
	    try {
	        wait.until(ExpectedConditions.visibilityOfAllElements(restart_mediaplayer));
	        restart_mediaplayer.click();
	        System.out.println("Successfully clicked restart button.");
	    } catch (Exception e) {
	        System.out.println("Failed to click restart button: " + e.getMessage());
	    }
	}
	
	public void clickDisableGuide() {
	    programguidepage = new ProgramGuidePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(10));
	    WebElement disable_guide = programguidepage.disable_guide4;
	    
	    try {
	        wait.until(ExpectedConditions.visibilityOfAllElements(disable_guide));
	        disable_guide.click();
	        System.out.println("Channel program disable");
	    } catch (Exception e) {
	        System.out.println("Channel program not disable " + e.getMessage());
	    }
	}

	
	public void clickSettingsMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement settings = mediaplayerpage.btn_settings_mediaplayer;
		wait.until(ExpectedConditions.visibilityOfAllElements(settings));
		settings.click();
	}
	
	public void clickConfirmOKMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement btn_ok = mediaplayerpage.btn_ok_settings_mediaplayer;
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_ok));
		btn_ok.click();
	}
	
	public void clickDisableLanguageMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement disable_language = mediaplayerpage.radio_btn_disable_lang_media_playerpage;
		wait.until(ExpectedConditions.visibilityOfAllElements(disable_language));
		disable_language.click();
	}
	
	public void clickEnglishLanguageMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement english_language = mediaplayerpage.radio_btn_english_language_media_playerpage;
		wait.until(ExpectedConditions.visibilityOfAllElements(english_language));
		english_language.click();
	}
	
	public void clickNextEpisodeMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement next_episode = mediaplayerpage.btn_next_episode_media_playerpage;
		wait.until(ExpectedConditions.visibilityOfAllElements(next_episode));
		next_episode.click();
	}
	
	public void clickPreviousEpisodeMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement previous_episode = mediaplayerpage.btn_previous_episode_media_playerpage;
		wait.until(ExpectedConditions.visibilityOfAllElements(previous_episode));
		previous_episode.click();
	}
	

	public void clickVodDownloadEps1() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement vod_eps1 = vodDetailPage.vod_download_eps1;
		wait.until(ExpectedConditions.visibilityOfAllElements(vod_eps1));
		vod_eps1.click();
	}
	
	public void clickTurnOnGps() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement turn_on_gps = outsideApp.btn_confirm_turn_on_gps;
		wait.until(ExpectedConditions.visibilityOfAllElements(turn_on_gps));
		turn_on_gps.click();
	}
	
	public void clickSwitchOnGps() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement switch_on = outsideApp.switch_gps_on;
		wait.until(ExpectedConditions.visibilityOfAllElements(switch_on));
		switch_on.click();
	}
	
	public void clickFreeLinear() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_gtv = liveTvPage.img_gtv;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_gtv));
		img_gtv.click();
	}

	public void clickPremiumLinear() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_trans_tv = liveTvPage.img_trans_tv;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_trans_tv));
		img_trans_tv.click();
	}

	public void clickPremiumSportLinear() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_soccer_channel = liveTvPage.img_soccer_channel;

		wait.until(ExpectedConditions.visibilityOfAllElements(img_soccer_channel));
		img_soccer_channel.click();
	}
	
	public void clickComedyContent(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_comedy_content = homePage.img_comedy_content;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_comedy_content));
	    img_comedy_content.click();
	}
	
	public void clickPopularActorsSeries(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_popular_actors_series = homePage.img_popular_actors_series;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_popular_actors_series));
	    img_popular_actors_series.click();
	}
	
	public void clickPopularActors(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_popular_actors_1 = homePage.img_popular_actors_1;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_popular_actors_1));
	    img_popular_actors_1.click();
	}
}
