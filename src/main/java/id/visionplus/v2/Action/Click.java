package id.visionplus.v2.Action;

import java.time.Duration;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.PageObjects.EntryPage;
import id.visionplus.v2.PageObjects.HomePage;
import id.visionplus.v2.PageObjects.LiveTVPage;
import id.visionplus.v2.PageObjects.LoginPage;
import id.visionplus.v2.PageObjects.OutsideApp;
import id.visionplus.v2.PageObjects.RegisterPage;
import id.visionplus.v2.PageObjects.SearchPage;
import id.visionplus.v2.PageObjects.SettingPage;
import id.visionplus.v2.PageObjects.VODDetailPage;
import id.visionplus.v2.PageObjects.VPlusOriginalsPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Click extends BaseTest
{
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
	
	public void clickSearchField(){
		searchPage = new SearchPage(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement txt_fld_search = searchPage.txt_fld_search;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_search));
		txt_fld_search.click();
	}
	
	public void clickSearchLiveTv(){
		searchPage = new SearchPage(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement img_search_live_tv_rcti = searchPage.img_search_live_tv_rcti;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(img_search_live_tv_rcti));
		img_search_live_tv_rcti.click();
	}
	
	public void clickSearchVOD(){
		searchPage = new SearchPage(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement img_search_vod_arab_maklum = searchPage.img_search_vod_arab_maklum;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(img_search_vod_arab_maklum));
		img_search_vod_arab_maklum.click();
	}
	
	public void clickNextEpisode(){
		outsideApp = new OutsideApp(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement btn_next_episode = outsideApp.btn_next_episode;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_next_episode));
		btn_next_episode.click();
	}
	
	public void clickLoginByFacebook(){
		loginPage = new LoginPage(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement btn_login_by_facebook = loginPage.btn_login_by_facebook;

		wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_by_facebook));
		btn_login_by_facebook.click();
	}
	
	public void clickFacebookLoginButton(){
		outsideApp = new OutsideApp(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement btn_login_facebook = outsideApp.btn_login_facebook;
		
		if(btn_login_facebook.isDisplayed()){
			wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_facebook));
			btn_login_facebook.click();
		}
	}
	
	public void clickContinueAsAccountFacebook(){
		outsideApp = new OutsideApp(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement btn_continue_as_facebook = outsideApp.btn_continue_as_facebook;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_continue_as_facebook));
		btn_continue_as_facebook.click();
	}

	public void pressBack(){
        (android).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void clickLogin(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_login = entryPage.btn_login;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_login));
	    btn_login.click();
	}
	
	public void clickGoogleSingleSignOn(){
		loginPage = new LoginPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_login_by_google = loginPage.btn_login_by_google;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_by_google));
	    btn_login_by_google.click();
	}
	
	public void click_1st_google_account(){
		loginPage = new LoginPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_google_account_1 = loginPage.btn_google_account_1;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_google_account_1));
	    btn_google_account_1.click();
	}
	
	public void clickTerms(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_terms_of_use = entryPage.btn_terms_of_use;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_terms_of_use));
	    btn_terms_of_use.click();
	}
	
	public void clickPrivacy(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_privacy_policy = entryPage.btn_privacy_policy;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_privacy_policy));
	    btn_privacy_policy.click();
	}
	
	public void clickRegister(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_register = entryPage.btn_register;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register));
	    btn_register.click();
	}
	
	public void clickCountry(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement icon_country_code = registerPage.icon_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(icon_country_code));
	    icon_country_code.click();
	}
	
	public void clickFieldCountry(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_country_code = registerPage.txt_fld_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_country_code));
	    txt_fld_country_code.click();
	}
	
	public void clickCloseCountry(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_close_country = registerPage.btn_close_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_close_country));
	    btn_close_country.click();
	}
	
	public void clickFieldPhoneNumber(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_phone = registerPage.txt_fld_phone;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_phone));
	    txt_fld_phone.click();
	}
	
	public void clickFieldEmail(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_email = registerPage.txt_fld_email;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_email));
	    txt_fld_email.click();
	}
	
	public void clickFieldPassword(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
	    txt_fld_password.click();
	}
	
	public void clickSendOTP(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_send_otp = registerPage.btn_send_otp;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_send_otp));
	    btn_send_otp.click();
	}
	
	public void clickPasswordVisible(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_password_visible = registerPage.img_password_visible;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_password_visible));
	    img_password_visible.click();
	}
	
	public void clickOtpFld(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement fld_otp = registerPage.fld_otp;
	    wait.until(ExpectedConditions.visibilityOfAllElements(fld_otp));
	    fld_otp.click();
	 }
	
	public void clickLoginPopUp(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_login_pop_up = registerPage.btn_login_pop_up;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_pop_up));
	    btn_login_pop_up.click();
	}
	
	public void clickRegisterLoginSubmitButton(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_register_login_submit = registerPage.btn_register_login_submit;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register_login_submit));
	    btn_register_login_submit.click();
	}
	
	public void clickRegisterLoginByEmailSection(){
		loginPage = new LoginPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_login_by_email_section = loginPage.btn_login_by_email_section;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_login_by_email_section));
	    btn_login_by_email_section.click();
	}
	
	public void clickFirstProfile(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_1st_profile = homePage.img_1st_profile;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_1st_profile));
	    img_1st_profile.click();
	}
	
	public void clickSkip(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_skip = homePage.btn_skip;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_skip));
	    btn_skip.click();
	}
	
	public void clickContinue(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_continue = homePage.btn_continue;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_continue));
	    btn_continue.click();
	}
	
	public void clickMenuButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_menu = homePage.btn_menu;
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_menu));
	    btn_menu.click();
	}
	
	public void clickSettingsButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_settings = homePage.btn_settings;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_settings));
	    btn_settings.click();
	}
	
	public void clickProfileButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_profile = homePage.btn_profile;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_profile));
	    btn_profile.click();
	}
	
	public void clickAddProfileButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_add_profile = homePage.btn_add_profile;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile));
	    btn_add_profile.click();
	}
	
	public void clickAddProfileOKButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_add_profile_ok = homePage.btn_add_profile_ok;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile_ok));
	    btn_add_profile_ok.click();
	}
	
	public void clickMyDownloads(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_my_download = homePage.btn_my_download;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_my_download));
	    btn_my_download.click();
	}
	
	public void clickAddProfileDoneButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_add_profile_done = homePage.btn_add_profile_done;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile_done));
	    btn_add_profile_done.click();
	}
	
	public void clickTextFieldProfileName(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_add_profile_name = homePage.txt_fld_add_profile_name;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_add_profile_name));
	    txt_fld_add_profile_name.click();
	}
	
	public void clickAddProfileCancelButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_add_profile_cancel = homePage.btn_add_profile_cancel;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile_cancel));
	    btn_add_profile_cancel.click();
	}
	
	public void clickProfileWarningOkButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_existing_profile_ok = homePage.btn_existing_profile_ok;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_existing_profile_ok));
	    btn_existing_profile_ok.click();
	}
	
	public void clickProfileAlmostDoneCancelButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_cancel_almost_done = homePage.btn_cancel_almost_done;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_cancel_almost_done));
	    btn_cancel_almost_done.click();
	}

	public void clickLatestProfile(){
		settingPage = new SettingPage(android);
        WebElement btn_latest_profile = settingPage.btn_latest_profile;
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_latest_profile));
	    btn_latest_profile.click();
	}
	
	public void clickDeleteProfile(){
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
	
	public void clickSearchButton(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_search = homePage.btn_search;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_search));
	    btn_search.click();
	}	
	
	public void clickHelpButton(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_help = settingPage.btn_help;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_help));
	    btn_help.click();
	}
	
	public void clickManageProfile() {
	    settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_manage_profile = settingPage.btn_manage_profile;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_manage_profile));
	    btn_manage_profile.click();
	}

	public void clickNotificationCentre(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_notification_centre = settingPage.btn_notification_centre;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_notification_centre));
	    btn_notification_centre.click();
	}
	
	public void clickLegalInformation(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_legal_information = settingPage.btn_legal_information;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_legal_information));
	    btn_legal_information.click();
	}
	
	public void clickTermsOfUse(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_terms_of_use = settingPage.btn_terms_of_use;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_terms_of_use));
	    btn_terms_of_use.click();
	}
	
	public void clickVoucher(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_voucher = settingPage.btn_voucher;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_voucher));
	    btn_voucher.click();
	}
	
	public void clickVoucherField(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_voucher = settingPage.txt_fld_voucher;
	    
	    wait.until(ExpectedConditions.visibilityOf(txt_fld_voucher));
	    txt_fld_voucher.click();
	}
	
	public void clickRedeemVoucher(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_redeem = settingPage.btn_redeem;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_redeem));
	    btn_redeem.click();
	}
	
	public void clickPrivacyPolicy(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_privacy_policy = settingPage.btn_privacy_policy;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_privacy_policy));
	    btn_privacy_policy.click();
	}
	
	public void clickSoftwareLicenses(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_software_licenses = settingPage.btn_software_licenses;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_software_licenses));
	    btn_software_licenses.click();
	}
	
	public void clickEmailInHelp(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_help_email = settingPage.btn_help_email;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_help_email));
	    btn_help_email.click();
	}
	
	public void clickWhatsAppInHelp(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_help_whatsApp = settingPage.btn_help_whatsApp;
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_help_whatsApp));
	    btn_help_whatsApp.click();
	}
	
	public void clickSettingsBackButton(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_back = settingPage.btn_back;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_back));
	    btn_back.click();
	}
	
	public void clickAboutUs(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_help_about_us = settingPage.btn_help_about_us;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_help_about_us));
	    btn_help_about_us.click();
	}
	
	public void clickSubscriptionTransaction(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_help_subscription_transaction = settingPage.btn_help_subscription_transaction;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_help_subscription_transaction));
	    btn_help_subscription_transaction.click();
	}
	
	public void clickBackToHelp(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_back_to_help = settingPage.btn_back_to_help;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_back_to_help));
	    btn_back_to_help.click();
	}
	
	public void clickCloseToSettings(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_help_close = settingPage.btn_help_close;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_help_close));
	    btn_help_close.click();
	}
	
	public void clickSettingsProfile(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_profile = settingPage.btn_profile;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_profile));
	    btn_profile.click();
	}
	
	public void clickTransactionHistory(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_transaction_history = settingPage.btn_transaction_history;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_transaction_history));
	    btn_transaction_history.click();
	}
	
	public void clickLogout(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_logout = settingPage.btn_logout;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_logout));
	    btn_logout.click();
	}
	
	public void clickVODBanner(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_banner_info = homePage.img_banner_info;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_banner_info));
	    img_banner_info.click();
	}
	
	public void clickBack(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_back = vodDetailPage.btn_back;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_back));
	    btn_back.click();
	}
	
	public void clickViewAll(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_view_all = homePage.btn_view_all;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_view_all));
	    btn_view_all.click();
	}
	
	public void clickPopularActors(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_popular_actors_1 = homePage.img_popular_actors_1;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_popular_actors_1));
	    img_popular_actors_1.click();
	}
	
	public void clickAsianActionMoviesContent(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_asian_action_movies = homePage.img_asian_action_movies;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_asian_action_movies));
	    img_asian_action_movies.click();
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
	
	public void clickSeriesInTop10(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_top_10_series = homePage.img_top_10_series;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_top_10_series));
	    img_top_10_series.click();
	}
	
	public void clickVisionPlusOriginalsSeries(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_visionplus_originals_content = homePage.img_visionplus_originals_content;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_visionplus_originals_content));
	    img_visionplus_originals_content.click();
	}
	
	public void clickVisionPlusOriginalSeriesContent(){
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
	
	public void clickSubscribe(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_subscribe = vodDetailPage.btn_subscribe;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_subscribe));
	    btn_subscribe.click();
	}
	
	public void clickLikeVOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_like = vodDetailPage.btn_like;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_like));
	    btn_like.click();
	}
	
	public void clickDislikeVOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_dislike = vodDetailPage.btn_dislike;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_dislike));
	    btn_dislike.click();
	}
	
	public void clickShareVOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_share = vodDetailPage.btn_share;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_share));
	    btn_share.click();
	}
	
	public void clickWatchTrailer(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_trailer = vodDetailPage.btn_trailer;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_trailer));
	    btn_trailer.click();
	}
	
	public void clickSynopsis(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_content_description = vodDetailPage.txt_content_description;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_content_description));
	    txt_content_description.click();
	}
	
	public void clickSaveToWatchlist(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_save = vodDetailPage.btn_save;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_save));
	    btn_save.click();
	}
	
	public void clickCopyLink(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_copy_link = vodDetailPage.btn_copy_link;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_copy_link));
	    btn_copy_link.click();
	}
	
	public void clickEps1VOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_eps_1_vod = vodDetailPage.img_eps_1_vod;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_eps_1_vod));
	    img_eps_1_vod.click();
	}
	
	public void clickEpsDownloadVOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_download = vodDetailPage.btn_download;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_download));
	    btn_download.click();
	}
	
	public void clickEps7VOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_eps_7_vod = vodDetailPage.img_eps_7_vod;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_eps_7_vod));
	    img_eps_7_vod.click();
	}
	
	public void clickWatchVOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_watch = vodDetailPage.btn_watch;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_watch));
	    btn_watch.click();
	}
	
	public void clickLiveTv(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_live_tv = homePage.btn_live_tv;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_live_tv));
	    btn_live_tv.click();
	}
	
	public void clickLinearChannelCluster(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_live_tv = homePage.img_live_tv;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_live_tv));
	    img_live_tv.click();
	}
	
	public void clickFreeLinear(){
		liveTvPage = new LiveTVPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_gtv = liveTvPage.img_gtv;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_gtv));
	    img_gtv.click();
	}
	
	public void clickPremiumLinear(){
		liveTvPage = new LiveTVPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_trans_tv = liveTvPage.img_trans_tv;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_trans_tv));
	    img_trans_tv.click();
	}
	
	public void clickPremiumSportLinear(){
		liveTvPage = new LiveTVPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_soccer_channel = liveTvPage.img_soccer_channel;
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_soccer_channel));
	    img_soccer_channel.click();
	}
}
