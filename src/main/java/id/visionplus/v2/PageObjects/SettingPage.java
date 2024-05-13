package id.visionplus.v2.PageObjects;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public SettingPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Email\"]")
	public static WebElement btn_help_email;
	
	@AndroidFindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.zte.iptvclient.android.idmnc:id/profileView\"])[8]")
	public static WebElement btn_latest_profile;
	
	@AndroidFindBy(xpath="(//*[contains(@text,'Voucher')][1])[2]")
	public static WebElement txt_settings_voucher_section_title;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Transaction History')]")
	public static WebElement txt_settings_transaction_history_section_title;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Whatsapp\"]")
	public static WebElement btn_help_whatsApp;
	
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
	public static WebElement btn_profile;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]")
	public static WebElement txt_settings_section_help_centre;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Subcription & Transaction')][1]")
	public static WebElement txt_help_section_Subcription;
	
	@AndroidFindBy(xpath="//*[contains(@text,'About Us')][1]")
	public static WebElement txt_help_section_About_Us;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"About Us\"]/android.widget.TextView")
	public static WebElement btn_help_about_us;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Image[1]")
	public static WebElement btn_back_to_help;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Subscription & Transaction\"]/android.widget.TextView")
	public static WebElement btn_help_subscription_transaction;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Help')]")
	public static WebElement btn_help;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Help Center')]")
	public static WebElement btn_help_center;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Delete profile')]")
	public static WebElement btn_delete_profile;
	
	@AndroidFindBy(xpath="//*[contains(@text,'DELETE')]")
	public static WebElement btn_delete_confirmation;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Voucher')]")
	public static WebElement btn_voucher;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Legal information')]")
	public static WebElement btn_legal_information;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Transaction history')]")
	public static WebElement btn_transaction_history;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Terms of Use')]")
	public static WebElement btn_terms_of_use;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text, 'Reedem')]")
	public static WebElement btn_redeem;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Privacy Policy')]")
	public static WebElement btn_privacy_policy;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Software Licenses')]")
	public static WebElement btn_software_licenses;
	
	@AndroidFindBy(xpath="//*/android.widget.TextView[1]")
	public static WebElement txt_software_license_title;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View")
	public static WebElement txt_warning_voucher;
	
	@AndroidFindBy(xpath="//*[contains(@text, 'Manage profiles')]")
	public static WebElement btn_manage_profile;
	
	@AndroidFindBy(xpath="//*[contains(@text, 'Notification centre')]")
	public static WebElement btn_notification_centre;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/close")
	public static WebElement btn_help_close;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/toolbar_text")
	public static WebElement txt_settings_section_title;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@hint, 'Enter Voucher Code')]")
	public static WebElement txt_fld_voucher;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.widget.TextView[1]")
	public static WebElement txt_pop_up_voucher_success;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.widget.Button")
	public static WebElement btn_see_my_status;
	
	@AndroidFindBy(xpath="(//android.view.View[2])[2]")
	public static WebElement txt_voucher_payment_success;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/back")
	public static WebElement btn_back;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/close_session_button")
	public static WebElement btn_logout;
	
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/recycler_view\"]/android.view.ViewGroup[3]")
	public static WebElement btn_account_email_handphone;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/text_view_preference_label\" and @text=\"Subscriber number\"]")
	public static WebElement txt_account_Subscriber_number;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/text_view_preference_label\" and @text=\"Change password\"]")
	public static WebElement txt_account_Change_password;
	
	@AndroidFindBy(xpath="//android.webkit.WebView[@text=\"Change Password\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.widget.EditText")
	public static WebElement field_account_Enter_current_password;

	@AndroidFindBy(xpath="//android.webkit.WebView[@text=\"Change Password\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[4]/android.widget.EditText")
	public static WebElement field_account_Enter_new_password;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Change Password\"]")
	public static WebElement txt_account_change_password_webview;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Next\"]")
	public static WebElement btn_account__change_password_next;
	
	@AndroidFindBy(xpath="//android.widget.Image[@text=\"Succes\"]")
	public static WebElement img_success_change_password;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/close")
	public static WebElement btn_back_success;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Change Password Failed\"]")
	public static WebElement txt_change_password_failed;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Close\"]")
	public static WebElement btn_Close;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"Password does not match criteria.\"]")
	public static WebElement txt_no_criteria;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/text_view_preference_label\" and @text=\"Delete account\"]")
	public static WebElement txt_delete_account;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"Delete your Vision+ Account\"]")
	public static WebElement txt_delete_account_webview;

	@AndroidFindBy(className = "android.widget.CheckBox")
	public static WebElement btn_checkbox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Keep Account\"]")
	public static WebElement btn_keep_account;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Proceed to Delete Account\"]")
	public static WebElement btn_proceed_delete_account;
	
	@AndroidFindBy(xpath = "//android.view.View[@text=\"You have to enter your password to delete your account\"]")
	public static WebElement txt_delete_account_enter_password;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	public static WebElement field_delete_account_enter_password;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Deleted Account\"]")
	public static WebElement btn_confirm_deleted_account;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Delete Account Failed\"]")
	public static WebElement txt_delete_account_failed;
	
	@AndroidFindBy(xpath = "//android.view.View[@text=\"Your account is deleted\"]")
	public static WebElement txt_success_delete_account;
	
	@AndroidFindBy(xpath = "//android.view.View[@text=\"You still have active package\"]")
	public static WebElement txt_still_have_package;
	
	@AndroidFindBy(xpath = "//android.view.View[@text=\"Please click the link we’ve sent to your email to proceed account deletion\"]")
	public static WebElement txt_google_delete_account;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Manage devices\"]")
	public static WebElement txt_Manage_Devices;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/errorTextView\"]")
	public static WebElement txt_no_devices;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/toolbar_text\"]")
	public static WebElement txt_tittle_manage_devices;
	
	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/disconnect_devices_button")
	public static WebElement btn_discconnect_manage_devices;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/deviceList\"]/android.view.ViewGroup[1]")
	public static WebElement list_connected_devices;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\"]")
	public static WebElement disconnect_devices;
	
	@AndroidFindBy(id = "android:id/button1")
	public static WebElement btn_confirm_disconnect_devices;
	
	@AndroidFindBy(xpath = "//*[contains(@text, 'Visionplus2')]")
	public static WebElement second_profile;
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
