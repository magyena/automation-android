package id.visionplus.v2.Action;

import java.time.Duration;

import java.util.Random;
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
	
	public void clickNextEpisode(){
		outsideApp = new OutsideApp(android);
		wait =new WebDriverWait(android,Duration.ofSeconds(60));
		WebElement btn_next_episode = outsideApp.btn_next_episode;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_next_episode));
		btn_next_episode.click();
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
	
	public void clickCloseHelp(){
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
	
	public void clickEps5VOD(){
		vodDetailPage = new VODDetailPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement img_eps_5_vod = vodDetailPage.img_eps_5_vod;
	    wait.until(ExpectedConditions.visibilityOfAllElements(img_eps_5_vod));
	    img_eps_5_vod.click();
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
