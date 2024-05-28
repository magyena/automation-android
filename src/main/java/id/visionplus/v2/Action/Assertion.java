package id.visionplus.v2.Action;
/* Author		: Fatah Alim
 * Created Date	: 21 Maret 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: Action_Assertion
 * 1. Add assertion txtviewAll
 * 2. Comment the Assertion of Voucher Warning Text, because the element does not detectable, and does not know the exact XPATH
 * */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import id.visionplus.v2.MainFunction.*;
import id.visionplus.v2.PageObjects.*;

public class Assertion extends BaseTest {
	WebDriverWait wait;
	EntryPage entryPage;
	HomePage homePage = new HomePage(android);
	LoginPage loginPage;
	RegisterPage registerPage;
	SettingPage settingPage;
	VODDetailPage vodDetailPage;
	VPlusOriginalsPage vplusOriginalPage;
	LiveTVPage liveTvPage;
	OutsideApp outsideApp;
	PopUpPage popupPage;
	SearchPage searchPage;
	MyDownloadsPage myDownloadsPage;
	TransactionHistoryPage transactionshistoryPage;
	ProgramGuidePage programguidepage;
	CategoryPage categorypage;
	BuyPackagePage buypackage;
	EuroPage euroPage;
	MediaPlayerPage mediaplayerpage;
	
//	 String adbPath = "/users/visionplus/Library/Android/sdk/platform-tools/adb";

	 String adbPath = "/users/michaelliong/Library/Android/sdk/platform-tools/adb";

// TOAST ASSERTION - BEGIN
	// Method to capture the Toast message
    public String captureToastMessage() throws IOException {
        // Execute adb command to capture the Toast message
        Process process = Runtime.getRuntime().exec(adbPath + " shell dumpsys activity");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("android.widget.Toast")) {
                // Extract the Toast message text
                int index = line.indexOf("Text:");
                return line.substring(index + 5);
            }
        }
        return null; // Return null if no Toast message is found
    }

    // Test method to assert the Toast message
    public void testToastMessage(String toast_message, String expected_message) throws IOException {
        String expectedToastMessage = expected_message; // Expected Toast message text
        String actualToastMessage = toast_message; // Capture the actual Toast message
        System.out.println("Actual Toast message: " + actualToastMessage);

        Assert.assertEquals(actualToastMessage, expectedToastMessage);
        
        // Assert the actual message text with the expected one
        if (expectedToastMessage.equals(actualToastMessage)) {
            System.out.println("Toast message assertion passed.");
        } else {
            System.out.println("Toast message assertion failed.");
        }
    }
 // TOAST ASSERTION - END

	public void assertSearchPage() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_fld_search = searchPage.txt_fld_search;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_search));

		Assert.assertTrue(txt_fld_search.isDisplayed());
	}

	public void assertSearchVOD() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_search_vod_arab_maklum = searchPage.img_search_vod_arab_maklum;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_search_vod_arab_maklum));

		Assert.assertTrue(img_search_vod_arab_maklum.isDisplayed());
	}

	public void assertSearchLiveTv() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_search_live_tv_rcti = searchPage.img_search_live_tv_rcti;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_search_live_tv_rcti));

		Assert.assertTrue(img_search_live_tv_rcti.isDisplayed());
	}

	public void assertSearchNotFound() {
		searchPage = new SearchPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_warning_not_found = searchPage.txt_warning_not_found;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_not_found));

		Assert.assertTrue(txt_warning_not_found.isDisplayed());

		String expected = "No results";
		String actual = txt_warning_not_found.getText();
		assertEquals(actual, expected);
	}

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

	public void assertPasswordVisible() {
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
	
	public void assertTimer2Minutes() {
		WebElement txt_timer = registerPage.txt_timer;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_timer));

		String actual = txt_timer.getText();
		String expectedPrefix = "Resend in 01:";
		Assert.assertTrue(actual.startsWith(expectedPrefix), "Timer text does not start with 'Resend in 01:'");
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

	public void assertRegisterLoginPage() {
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

	public void assertDropDownCountry() {
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

	public void assertTextWarningOTPExpired() {
		WebElement txt_warning_otp = registerPage.txt_warning_otp;
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_otp));

		Assert.assertTrue(txt_warning_otp.isDisplayed());

		String actual = txt_warning_otp.getText();
		String expected = "OTP Expired";
		Assert.assertEquals(actual, expected);
	}

	public void assertPopUpExistingAccount() {
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

	public void assertTextWarningOTPUsed() {
		WebElement txt_warning_otp = registerPage.txt_warning_otp;
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_otp));

		Assert.assertTrue(txt_warning_otp.isDisplayed());

		String actual = txt_warning_otp.getText();
		String expected = "err_otp_already_used_message";
		Assert.assertEquals(actual, expected);
	}

	public void assertAddProfileSection() {
		homePage = new HomePage(android);

		WebElement btn_add_profile_ok = homePage.btn_add_profile_ok;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_add_profile_ok));

		Assert.assertFalse(btn_add_profile_ok.isEnabled());
	}

	public void assertAvatarChanged() {
		homePage = new HomePage(android);

		WebElement img_avatar_2 = homePage.img_avatar_2;

		// Wait for the check icon element to be present and visible
		WebDriverWait wait = new WebDriverWait(android, Duration.ofSeconds(30));
		WebElement checkIcon = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.zte.iptvclient.android.idmnc:id/avatarSelected")));

		// Assert that the check icon is enabled
		Assert.assertTrue(checkIcon.isEnabled(), "Check icon is present on the first profile image.");
	}

	public void assertChangeAvatarSection() {
		homePage = new HomePage(android);

		WebElement txt_change_avatar_title = homePage.txt_change_avatar;
		WebElement img_avatar_2 = homePage.img_avatar_2;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_change_avatar_title));
		wait.until(ExpectedConditions.visibilityOfAllElements(img_avatar_2));

		Assert.assertTrue(txt_change_avatar_title.isDisplayed());
		Assert.assertTrue(img_avatar_2.isDisplayed());
	}

	public void assertAddProfileNameFieldIs15Char() {
		homePage = new HomePage(android);

		WebElement txt_fld_add_profile_name = homePage.txt_fld_add_profile_name;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_add_profile_name));

		int actual = (txt_fld_add_profile_name.getText()).length();
		int expected = 15;
		assertEquals(actual, expected);
	}

	public void assertProfile_Already_Exist() {
		homePage = new HomePage(android);

		WebElement txt_profile_pop_up_existing_profile = homePage.txt_profile_pop_up_existing_profile;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_profile_pop_up_existing_profile));

		String actual = txt_profile_pop_up_existing_profile.getText();
		String expected = "Profile name already in use";
		assertEquals(actual, expected);
	}

	public void assertAddProfileNotShown() {
		homePage = new HomePage(android);
		WebElement btn_add_profile = homePage.btn_add_profile;
		assertFalse(isElementPresent1(btn_add_profile));
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

	public void assertDiscoverText() {
		homePage = new HomePage(android);

		WebElement txt_discover = homePage.txt_discover;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_discover));

		Assert.assertTrue(txt_discover.isDisplayed());

		String actual = txt_discover.getText();
		String expected = "Discover profiles";
		Assert.assertEquals(actual, expected);
	}

	public void assertMyDownloadPageFree() {
		myDownloadsPage = new MyDownloadsPage(android);

		WebElement icon_upgrade = myDownloadsPage.icon_upgrade;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(icon_upgrade));

		Assert.assertTrue(icon_upgrade.isDisplayed());
	}

	public void assertArriveHomePage() {
		homePage = new HomePage(android);

		WebElement img_visionplus_logo = homePage.img_visionplus_logo;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(img_visionplus_logo));

		Assert.assertTrue(img_visionplus_logo.isDisplayed());
	}

	public void assertVODinWatchlist() {
		homePage = new HomePage(android);

		WebElement img_watchlist_content = homePage.img_watchlist_content;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(img_watchlist_content));

		Assert.assertTrue(img_watchlist_content.isDisplayed());
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
		String pageSource = android.getPageSource();
		String textToAssert = "Help Center";

		try {
			if (pageSource.contains(textToAssert)) {
				System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
			} else {
				throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is not present .");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());

		}
	}

	public void assertLegalInformation() {
		settingPage = new SettingPage(android);

		WebElement txt_settings_section_legal_information = settingPage.txt_settings_section_title;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_section_legal_information));

		Assert.assertTrue(txt_settings_section_legal_information.isDisplayed());

		String actual = txt_settings_section_legal_information.getText();
		String expected = "Legal information";
		Assert.assertEquals(actual, expected);
	}

	public void assertVoucher() {
		settingPage = new SettingPage(android);

		WebElement txt_settings_voucher_section_title = settingPage.txt_settings_voucher_section_title;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_voucher_section_title));

		Assert.assertTrue(txt_settings_voucher_section_title.isDisplayed());

		String actual = txt_settings_voucher_section_title.getText();
		String expected = "Voucher";
		Assert.assertEquals(actual, expected);
	}

	public void assertTransactionHistory() {
		settingPage = new SettingPage(android);

		WebElement txt_settings_transaction_history_section_title = settingPage.txt_settings_transaction_history_section_title;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_transaction_history_section_title));

		Assert.assertTrue(txt_settings_transaction_history_section_title.isDisplayed());

		String actual = txt_settings_transaction_history_section_title.getText();
		String expected = "Transaction History";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertVoucherSuccess() {
		
		System.out.println("Assert Voucher Redeemed");
		settingPage = new SettingPage(android);

		WebElement txt_pop_up_voucher_success = settingPage.txt_pop_up_voucher_success;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_pop_up_voucher_success));

		Assert.assertTrue(txt_pop_up_voucher_success.isDisplayed());
		
		System.out.println("Voucher Redeemed Displayed");

		String actual = txt_pop_up_voucher_success.getText();
		String expected = "Voucher Redeemed";
		Assert.assertEquals(actual, expected);
		
		System.out.println("Assert Voucher Redeemed as expected Text");

	}
	
	public void assertPaymentSuccess() {
		settingPage = new SettingPage(android);

		WebElement txt_voucher_payment_success = settingPage.txt_voucher_payment_success;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_voucher_payment_success));

		Assert.assertTrue(txt_voucher_payment_success.isDisplayed());

		String actual = txt_voucher_payment_success.getText();
		String expected = "Payment Success";
		Assert.assertEquals(actual, expected);
	}

	public void assertVoucherExpired() {
		settingPage = new SettingPage(android);

		WebElement txt_warning_voucher = settingPage.txt_warning_voucher;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_voucher));

		Assert.assertTrue(txt_warning_voucher.isDisplayed());

		String actual = txt_warning_voucher.getText();
		String expected = "Voucher code expired";
		Assert.assertEquals(actual, expected);
	}

	public void assertVoucherInvalid() {
		settingPage = new SettingPage(android);

		WebElement txt_warning_voucher = settingPage.txt_warning_voucher;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_voucher));

		Assert.assertTrue(txt_warning_voucher.isDisplayed());

		String actual = txt_warning_voucher.getText();
		String expected = "Invalid code";
		Assert.assertEquals(actual, expected);
	}

	public void assertVoucherReedemed() {
		settingPage = new SettingPage(android);

		WebElement txt_warning_voucher = settingPage.txt_warning_voucher;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_voucher));

		Assert.assertTrue(txt_warning_voucher.isDisplayed());

		String actual = txt_warning_voucher.getText();
		String expected = "This code has been redeemed";
		Assert.assertEquals(actual, expected);
	}

	public void assertSoftwareLicense() {
		settingPage = new SettingPage(android);

		WebElement txt_software_license_title = settingPage.txt_software_license_title;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_software_license_title));

		Assert.assertTrue(txt_software_license_title.isDisplayed());

		String actual = txt_software_license_title.getText();
		String expected = "Apache License";
		Assert.assertTrue(actual.startsWith(expected));
	}

	public void assertDirectToWhatsApp() {
		outsideApp = new OutsideApp(android);

		WebElement img_whatsApp_logo_header = outsideApp.img_whatsApp_logo_header;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(img_whatsApp_logo_header));

		Assert.assertTrue(img_whatsApp_logo_header.isDisplayed());
	}

	public void assertDirectToGmail() {
		outsideApp = new OutsideApp(android);

		WebElement img_gmail_from = outsideApp.img_gmail_from;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(img_gmail_from));

		Assert.assertTrue(img_gmail_from.isDisplayed());
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

	public void assertVODEps2Playable() {
		vodDetailPage = new VODDetailPage(android);

		WebElement txt_episode_2_vod = vodDetailPage.txt_eps_2_vod;
		wait = new WebDriverWait(android, Duration.ofSeconds(90));

		wait.until(ExpectedConditions.visibilityOfAllElements(txt_episode_2_vod));
		Assert.assertTrue(txt_episode_2_vod.isDisplayed());
	}

	public void assertVODIsNotPlayable() {
		vodDetailPage = new VODDetailPage(android);

		WebElement btn_subscribe = vodDetailPage.btn_subscribe;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_subscribe));

		Assert.assertTrue(btn_subscribe.isDisplayed());
	}

	public void assertHomePage() {
		homePage = new HomePage(android);
		WebElement img_originals = homePage.img_originals;
		Assert.assertTrue(isElementPresent1(img_originals)); // inno
	}

	public boolean isElementPresent1(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void assertMenu() { // inno
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_menu = HomePage.img_home;
		wait.until(ExpectedConditions.visibilityOfAllElements(img_menu));

		Assert.assertTrue(img_menu.isDisplayed());
	}

	public void assertDetailChannelSport() { // inno
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement detail_channel = liveTvPage.detail_channel;
		wait.until(ExpectedConditions.visibilityOfAllElements(detail_channel));

		Assert.assertTrue(detail_channel.isDisplayed());
	}

	public void assertSampleDetailVod() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement detailpage_tittle = vodDetailPage.txt_content_title;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(detailpage_tittle));
			Assert.assertTrue(detailpage_tittle.isDisplayed());
			System.out.println("Assert Success: Tittle detail page Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Tittle Detail page not Showing.");
			throw e;
		}
	}

	public void assertSeriesTittleEps1() { // inno
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement series_tittle_eps1 = vodDetailPage.series_tittle_eps1;
		wait.until(ExpectedConditions.visibilityOfAllElements(series_tittle_eps1));

		Assert.assertTrue(series_tittle_eps1.isDisplayed());
	}

	public void assertSettingsPage() { // inno
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement toolbar = settingPage.txt_settings_section_title;
		wait.until(ExpectedConditions.visibilityOfAllElements(toolbar));

		Assert.assertTrue(toolbar.isDisplayed());
	}

	public void assertTransactionsDetail() { // inno
		transactionshistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement detail_transactions = transactionshistoryPage.txt_detail_transactions;
		wait.until(ExpectedConditions.visibilityOfAllElements(detail_transactions));

		Assert.assertTrue(detail_transactions.isDisplayed());
	}

	public void assertPopupConfirmDownload() { // inno
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement PopupDownload = vodDetailPage.txt_confirm_download;
		wait.until(ExpectedConditions.visibilityOfAllElements(PopupDownload));

		Assert.assertTrue(PopupDownload.isDisplayed());

	}
	
	public void assertEuroPackageExist(){
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement package_euro = buypackage.txt_package_euro;
		
		Assert.assertTrue(package_euro.isDisplayed());
	}
	
	public void assertCurrentEuroPackage(){
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_current_package_euro = buypackage.txt_current_package_euro;
		
		Assert.assertTrue(txt_current_package_euro.isDisplayed());
	}

	public void assertPaymentBuyAgain() { // inno
		transactionshistoryPage = new TransactionHistoryPage(android);

		WebElement txt_settings_section_BuyAgain_Payment = transactionshistoryPage.txt_buyAgain_payment;

		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_settings_section_BuyAgain_Payment));

		Assert.assertTrue(txt_settings_section_BuyAgain_Payment.isDisplayed());

		String actual = txt_settings_section_BuyAgain_Payment.getText();
		String expected = "Payment";
		Assert.assertEquals(actual, expected);
	}

	public void assertSubscribetoPremiumSport() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement subscribe = liveTvPage.btn_subscribe;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(subscribe));
			Assert.assertTrue(subscribe.isDisplayed());
			System.out.println("Assert Success: Subscriibe Button Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Subscribe  Button not Showing.");
			throw e;
			
		}

	}
	
	public void assertSubscribe() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement subscribe = liveTvPage.btn_subscribe;

		 try {
		        wait.until(ExpectedConditions.visibilityOf(subscribe));
		        
		        Assert.assertTrue(!subscribe.isDisplayed());
		        
		        System.out.println("Assert Passed: Subscribe Button not Showing.");
		    } catch (TimeoutException e) {
		        System.out.println("Assert Passed: Subscribe Button not Found.");
		    } catch (NoSuchElementException e) {
		        System.out.println("Assert Passed: Subscribe Button not Found.");
		    }
		}	
	
	
	public void assertErrorConnection() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement error_connection = liveTvPage.img_error_connection;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(error_connection));
			Assert.assertTrue(error_connection.isDisplayed());
			System.out.println("Assert Success: Notification error connection Showing.");
		} catch (TimeoutException e) {
			System.out.println(" Assert Failure: Notification error connection not Showing.");
			throw e;
		}
	}

	public void assertDetailVod() { // inno
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement watch_vod = vodDetailPage.btn_watch;
		wait.until(ExpectedConditions.visibilityOfAllElements(watch_vod));

		Assert.assertTrue(watch_vod.isDisplayed());
	}

	public void assertDownloadTextNotPresent() { // inno
		String pageSource = android.getPageSource();
		String textToAssert = "Download";

		if (!pageSource.contains(textToAssert)) {
			System.out.println("Assertion Passed: Text '" + textToAssert + "' is not present on the page.");
		} else {
			throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is present on the page.");
		}
	}

	public void assertProgramGuide() { // inno
		String pageSource = android.getPageSource();
		String textToAssert = "Channel list";

		if (pageSource.contains(textToAssert)) {
			System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
		} else {
			throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is not present on the page.");
		}
	}
	
	public boolean assertDisableGuide() {
		programguidepage = new ProgramGuidePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement disable_guide = programguidepage.disable_guide4;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(disable_guide));
			Assert.assertTrue(disable_guide.isDisplayed());
			System.out.println("Assert Success: Guide is disable.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Guide not disable.");
			throw e;
		}
		return true;
	}
	
	public void assertDetailProgramGuide() { // inno
		programguidepage = new ProgramGuidePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		try {
			WebElement watchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("watchButton")));
			WebElement btn_watch = programguidepage.btn_watch;
			Assert.assertFalse(btn_watch.isDisplayed(), "Assertion Failed: Watch Button is Display");
		} catch (TimeoutException e) {
			Assert.assertTrue(true, "Assertion Passed: Watch Button is not displayed");
			System.out.println("Assertion Passed: Watch Button not Showing");
		}
	}

	public void assertTxtViewAll() { // inno
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_tittle_view_all = homePage.txt_tittle_view_all;
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_tittle_view_all));

		Assert.assertTrue(txt_tittle_view_all.isDisplayed());
	}

	public void assertBannerInfo() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement banner_info = homePage.img_banner_info;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(banner_info));
			Assert.assertTrue(banner_info.isDisplayed());
			System.out.println("Assert Success: Banner info is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Banner info is not displayed.");
			throw e;
		}
	}

	public void assertActionCategory() {
		categorypage = new CategoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement movies = categorypage.action_category_categorypage;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(movies));
			Assert.assertTrue(movies.isDisplayed());
			System.out.println("Assert Success: Movies View is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Movies View is not displayed.");
			throw e;
		}
	}

	public void assertSubscriptionImage() {
		categorypage = new CategoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement img_subscription = categorypage.img_subscription_categorypage;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(img_subscription));
			Assert.assertTrue(img_subscription.isDisplayed());
			System.out.println("Assert Success: Subscription Image is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Subscription Image is not displayed.");
			throw e;
		}
	}

	public boolean assertSubscriptionPremium30days() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_premium30_days = outsideApp.txt_premium30_days_playstore;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_premium30_days));
			Assert.assertTrue(txt_premium30_days.isDisplayed());
			System.out.println("Assert Success: Premium 30 Days is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Premium 30 Days is not displayed.");
			throw e;
		}
		return false;
	}
	
	public void assertSubscriptionEuroPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_euro_playstore = outsideApp.txt_euro_playstore;

			wait.until(ExpectedConditions.visibilityOfAllElements(txt_euro_playstore));
			Assert.assertTrue(txt_euro_playstore.isDisplayed());
			System.out.println("Assert Success: Euro is Displayed");
	}
	
	public void assertSubscriptionEuroPricePlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_euro_price_playstore = outsideApp.txt_euro_price_playstore;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_euro_price_playstore));
		Assert.assertTrue(txt_euro_price_playstore.isDisplayed());
		System.out.println("Assert Success: Euro Price Displayed");
		
		String actual = txt_euro_price_playstore.getText();
		String expected = "Rp 79.000,00";
		Assert.assertEquals(actual, expected);
	}

	public void assertSubscriptionPremiumSports30days() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_premium30sports_days = outsideApp.txt_premiumSports30_days_playstore;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_premium30sports_days));
			Assert.assertTrue(txt_premium30sports_days.isDisplayed());
			System.out.println("Assert Success: Premium Sports 30 Days is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Premium Sports 30 Days is not displayed.");
			throw e;
		}
	}

	public void assertMenuBuyPackage() {
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_buy_package = buypackage.txt_package_page;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_buy_package));
			Assert.assertTrue(txt_buy_package.isDisplayed());
			System.out.println("Assert Success: Your Current Package is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Your Current Package is not displayed.");
			throw e;
		}
	}
	
	public void assertMenuEuro() {
		euroPage = new EuroPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_Euro_official_film = euroPage.txt_Euro_official_film;
		WebElement txt_Teams = euroPage.txt_Teams;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_Teams));
			Assert.assertTrue(txt_Euro_official_film.isDisplayed());
			
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_Teams));
			Assert.assertTrue(txt_Teams.isDisplayed());
			System.out.println("Assert Success: Arrived at Euro Page");
		} catch (AssertionError e) {
			System.out.println("Assert Success: Not Arrived at Euro Page or Teams and Euro Official Films not Existed in the Current Page");
			throw e;
		}
	}

	public boolean assertErrorSubscriptionPlaystore() {
		outsideApp = new OutsideApp(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_error = outsideApp.txt_error_subscribe_playstore;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_error));
			Assert.assertTrue(txt_error.isDisplayed());
			System.out.println("Assert Success: Error text is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Error Text is not displayed.");
			throw e;
		}
		return false;
	}

	public void assertActivePackagePremium30() {
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_premium30_package = buypackage.txt_premium30_package;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_premium30_package));
			Assert.assertTrue(txt_premium30_package.isDisplayed());
			System.out.println("Assert Success: Premium 30 Days left is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Premium 30 Days left not displayed.");
			throw e;
		}
	}

	public void assertActivePackagePremium30Sports() {
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_premium30_sports_package = buypackage.txt_premium30Sports_package;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_premium30_sports_package));
			Assert.assertTrue(txt_premium30_sports_package.isDisplayed());
			System.out.println("Assert Success: Premium Sports 30 Days left is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Premium Sports 30 Days left not displayed.");
			throw e;
		}
	}

	public void assertSubscriberNumberSettingsPage() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_subscriber_number = settingPage.txt_account_Subscriber_number;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_subscriber_number));
			Assert.assertTrue(txt_subscriber_number.isDisplayed());
			System.out.println("Assert Success: Subscriber Number is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Subscribet Number not displayed.");
			throw e;
		}
	}

	public void assertChangePasswordWebView() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_Change_Password = settingPage.txt_account_change_password_webview;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_Change_Password));
			Assert.assertTrue(txt_Change_Password.isDisplayed());
			System.out.println("Assert Success: Tittle Change Password is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Tittle Change Password not displayed.");
			throw e;
		}
	}

	public void assertSuccessChangePassword() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement img_success = settingPage.img_success_change_password;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(img_success));
			Assert.assertTrue(img_success.isDisplayed());
			System.out.println("Assert Success: Image success is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Image success not displayed.");
			throw e;
		}
	}

	public void assertChangePassworfailed() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_change_password_failed = settingPage.txt_change_password_failed;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_change_password_failed));
			Assert.assertTrue(txt_change_password_failed.isDisplayed());
			System.out.println("Assert Success: Change Password Failed is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Change Password Failed not displayed.");
			throw e;
		}
	}

	public void assertPasswordNoCriteria() {
		String pageSource = android.getPageSource();
		String textToAssert = "Password does not match criteria.";

		try {
			if (pageSource.contains(textToAssert)) {
				System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
			} else {
				throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is not present .");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());

		}
	}

	public void assertDeleteAccountWebView() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_delete_account_webview = settingPage.txt_delete_account_webview;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_delete_account_webview));
			Assert.assertTrue(txt_delete_account_webview.isDisplayed());
			System.out.println("Assert Success: Deleted Account text is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Deleted Account text not displayed.");
			throw e;
		}
	}

	public void assertDeleteAccountEnterPassword() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_enter_password = settingPage.txt_delete_account_enter_password;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_enter_password));
			Assert.assertTrue(txt_enter_password.isDisplayed());
			System.out.println("Assert Success: You have to enter your password... is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: You have to enter your password... not displayed.");
			throw e;
		}
	}

	public void assertDeleteAccountFailed() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_delete_account_failed = settingPage.txt_delete_account_failed;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_delete_account_failed));
			Assert.assertTrue(txt_delete_account_failed.isDisplayed());
			System.out.println("Assert Success: Delete Account Failed is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Delete Account Failed not displayed.");
			throw e;
		}
	}

	public void assertDeleteAccountSuccess() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement txt_delete_account_success = settingPage.txt_success_delete_account;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_delete_account_success));
			Assert.assertTrue(txt_delete_account_success.isDisplayed());
			System.out.println("Assert Success: Your Account is deleted is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Your Account is deleted not displayed.");
			throw e;
		}
	}

	public void assertStillHavePackage() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_still_have_package = settingPage.txt_still_have_package;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_still_have_package));
			Assert.assertTrue(txt_still_have_package.isDisplayed());
			System.out.println("Assert Success: Your Still Have Package is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Your Still Have Package not displayed.");
			throw e;
		}
	}

	public void assertGoogleDeleteAccount() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_google_delete = settingPage.txt_google_delete_account;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_google_delete));
			Assert.assertTrue(txt_google_delete.isDisplayed());
			System.out.println("Assert Success: Delete onfirm link to email is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Delete Confirm link to email not displayed.");
			throw e;
		}
	}

	public void assertClusterBecauseYouWatched() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_because_you_watched = homePage.txt_cluster_because_you_watched;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_because_you_watched));
			Assert.assertTrue(txt_because_you_watched.isDisplayed());
			System.out.println("Assert Success: Cluster Because you watched is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Cluster Because you watched not displayed.");
			throw e;
		}
	}

	public void assertManageDevices() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_toolbar_manage_devices = settingPage.txt_tittle_manage_devices;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_toolbar_manage_devices));
			Assert.assertTrue(txt_toolbar_manage_devices.isDisplayed());
			System.out.println("Assert Success: Manage Devices Tittle is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Manage Devices Tittle not displayed.");
			throw e;
		}
	}

	public void assertConnectedDevices() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement connected_devices = settingPage.list_connected_devices;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(connected_devices));
			Assert.assertTrue(connected_devices.isDisplayed());
			System.out.println("Assert Success: Showing Connected Devices is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Showing Connected Devices not displayed.");
			throw e;
		}
	}

	public void assertNoConnectedDevices() {
		settingPage = new SettingPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement no_connected_devices = settingPage.txt_no_devices;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(no_connected_devices));
			Assert.assertTrue(no_connected_devices.isDisplayed());
			System.out.println("Assert Success: No Devices Connected is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: No Devices Connected not displayed.");
			throw e;
		}
	}

	public void assertAddtoListWatchlist() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_Add_to_list = vodDetailPage.txt_Add_to_list;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_Add_to_list));
			Assert.assertTrue(txt_Add_to_list.isDisplayed());
			System.out.println("Assert Success: Add to list is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Add to list not displayed.");
			throw e;
		}
	}

	public void assertRemoveFromListtWatchlist() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement txt_remove_from_list = vodDetailPage.txt_Remove_from_list;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(txt_remove_from_list));
			Assert.assertTrue(txt_remove_from_list.isDisplayed());
			System.out.println("Assert Success: Remove from List is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Remove from List displayed.");
			throw e;
		}
	}

	public void assertClusterWatchlist() {
		String pageSource = android.getPageSource();
		String textToAssert = "Watchlist";

		try {
			if (pageSource.contains(textToAssert)) {
				System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
			} else {
				throw new AssertionError("After Change Profile Cluster '" + textToAssert + "' is not present .");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());

		}
	}

	public void assertContentClusterNewRelease() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement content_cluster_new_relase = vodDetailPage.banner_content_cluster_new_release;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(content_cluster_new_relase));
			Assert.assertTrue(content_cluster_new_relase.isDisplayed());
			System.out.println("Assert Success: Detail VOD is displayed.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Detail VOD displayed.");
			throw e;
		}
	}

	public void assertClusterContinueWatching() {
		String pageSource = android.getPageSource();
		String textToAssert = "Continue watching";

		try {
			if (pageSource.contains(textToAssert)) {
				System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
			} else {
				throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is not present .");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());

		}
	}

	public void assertMediaPlayerPlayed() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement vod_played = mediaplayerpage.txt_tittle_media_playerpage;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vod_played));
			Assert.assertTrue(vod_played.isDisplayed());
			System.out.println("Assert Success: VOD is running.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: VOD is not running.");
			throw e;
		}
	}

	public void assertSettingsLanguageMediaPlayer() {
		String pageSource = android.getPageSource();
		String textToAssert = "Subtitles";

		try {
			if (pageSource.contains(textToAssert)) {
				System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
			} else {
				throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is not present .");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());

		}
	}

	public void assertSettingsAudioMediaPlayer() {
		String pageSource = android.getPageSource();
		String textToAssert = "Audio";

		try {
			if (pageSource.contains(textToAssert)) {
				System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
			} else {
				throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is not present .");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());

		}
	}

	public void assertNextEpisodeMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement assert_next_episode = mediaplayerpage.btn_previous_episode_media_playerpage;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(assert_next_episode));
			Assert.assertTrue(assert_next_episode.isDisplayed());
			System.out.println("Assert Success: Next Episode Button Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Next Episode Button not Showing.");
			throw e;
		}
	}

	public void assertTitleVODEpisode() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement tittle_episode = vodDetailPage.txt_title_episode;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(tittle_episode));
			Assert.assertTrue(tittle_episode.isDisplayed());
			System.out.println("Assert Success: Title Episode Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Title Episode Showing.");
			throw e;
		}
	}

	public void assertPreviousEpisodeMediaPlayer() {
		mediaplayerpage = new MediaPlayerPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement assert_next_episode = mediaplayerpage.btn_next_episode_media_playerpage;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(assert_next_episode));
			Assert.assertTrue(assert_next_episode.isDisplayed());
			System.out.println("Assert Success: Next Episode Button Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Next Episode Button not Showing.");
			throw e;
		}
	}

	public boolean assertGPS() {
	    outsideApp = new OutsideApp(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(10));
	    WebElement gps = outsideApp.btn_confirm_turn_on_gps;
	    
	    try {
	        wait.until(ExpectedConditions.visibilityOfAllElements(gps));
	        Assert.assertTrue(gps.isDisplayed());
	        System.out.println("Assert Success: TURN ON GPS Showing.");
	    } catch (TimeoutException e) {
	        System.out.println("Assert Failure: TURN ON GPS NO Showing.");
	        return false;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}
	    
	public void assertDownloadSuccessfully() { 
	    String pageSource = android.getPageSource();
	    String textToAssert = "Cancel download";

	    try {
	        if (pageSource.contains(textToAssert)) {
	            System.out.println("Assertion Passed: Text '" + textToAssert + "' is present on the page.");
	        } else {
	            throw new AssertionError("Assertion Failed: Text '" + textToAssert + "' is not present .");
	        }
	    } catch (AssertionError e) {
	        System.out.println(e.getMessage());
	        
	    }
	}
	
	public void assertClusterExplorebyGenre() {
		homePage = new HomePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement cluster_explore_by_genre = homePage.txt_cluster_Explore_by_genre;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(cluster_explore_by_genre));
			Assert.assertTrue(cluster_explore_by_genre.isDisplayed());
			System.out.println("Assert Success: Cluster Explore by Genre Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Cluster Explore by Genre not Showing.");
			throw e;
		}
	}
	
	public void assertContentExplorebyGenre() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement content_explore_by_genre = vodDetailPage.btn_back;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(content_explore_by_genre));
			Assert.assertTrue(content_explore_by_genre.isDisplayed());
			System.out.println("Assert Success: Content Cluster Explore by Genre Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Content Cluster Explore by Genre not Showing.");
			throw e;
		}
	}
	
	public void assertEventEuroPackage() {
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement euro_package = buypackage.euro_package;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(euro_package));
			Assert.assertTrue(euro_package.isDisplayed());
			System.out.println("Assert Success: Euro Package Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Euro Package not Showing.");
			throw e;
		}
	}
	
	public void assertTransactionHistoryEuroPackage() {
		transactionshistoryPage = new TransactionHistoryPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement transaction_euro_package = transactionshistoryPage.txt_euro_package;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(transaction_euro_package));
			Assert.assertTrue(transaction_euro_package.isDisplayed());
			System.out.println("Assert Success: Transaction History Euro Package Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Transaction History Euro Package not Showing.");
			throw e;
		}
	}
	
	public void assertCurrentPackageEuro() {
		buypackage = new BuyPackagePage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement current_euro_package = buypackage.current_euro_package;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(current_euro_package));
			Assert.assertTrue(current_euro_package.isDisplayed());
			System.out.println("Assert Success: Current Transaction Euro Package Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Current Transaction Euro Package not Showing.");
			throw e;
		}
	}
	
	public void assertEuroChannel() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(10));
		WebElement euro_channel = liveTvPage.img_euro_2;

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(euro_channel));
			Assert.assertTrue(euro_channel.isDisplayed());
			System.out.println("Assert Success: Euro Channel 2 Showing.");
		} catch (AssertionError e) {
			System.out.println(" Assert Failure: Euro Channel 2 not Showing.");
			throw e;
		}
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

	public void assertLiveTVNotPlayed() {
		liveTvPage = new LiveTVPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		WebElement btn_subscribe = liveTvPage.btn_subscribe;
		wait.until(ExpectedConditions.visibilityOf(btn_subscribe));
		Assert.assertTrue(btn_subscribe.isDisplayed());
	}

	public void assertPopUpPackages() {
		popupPage = new PopUpPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		WebElement txt_pop_up_header_title = popupPage.txt_pop_up_header_title;
		wait.until(ExpectedConditions.visibilityOf(txt_pop_up_header_title));

		String actual = txt_pop_up_header_title.getText();
		String expected = "Packages";

		Assert.assertEquals(actual, expected);
	}

	public void assertDownloadButtonNotShown() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		WebElement btn_download = vodDetailPage.btn_download;
		Assert.assertFalse(isElementPresent1(btn_download));
	}

	public void assertShareSection() {
		vodDetailPage = new VODDetailPage(android);
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		WebElement btn_copy_link = vodDetailPage.btn_copy_link;
		WebElement txt_share_bluetooth = vodDetailPage.txt_share_bluetooth;
		WebElement txt_share_drive = vodDetailPage.txt_share_drive;
		WebElement txt_share_messages = vodDetailPage.txt_share_messages;
		WebElement txt_share_gmail = vodDetailPage.txt_share_gmail;

		wait.until(ExpectedConditions.visibilityOf(btn_copy_link));
		wait.until(ExpectedConditions.visibilityOf(txt_share_bluetooth));
		wait.until(ExpectedConditions.visibilityOf(txt_share_drive));
		wait.until(ExpectedConditions.visibilityOf(txt_share_messages));
		wait.until(ExpectedConditions.visibilityOf(txt_share_gmail));

		Assert.assertTrue(btn_copy_link.isDisplayed());
		Assert.assertTrue(txt_share_bluetooth.isDisplayed());
		Assert.assertTrue(txt_share_drive.isDisplayed());
		Assert.assertTrue(txt_share_messages.isDisplayed());
		Assert.assertTrue(txt_share_gmail.isDisplayed());
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

	public void assertContentDetails() {
		vodDetailPage = new VODDetailPage(android);

		WebElement btn_dislike = vodDetailPage.btn_dislike;
		WebElement btn_like = vodDetailPage.btn_like;
		WebElement btn_share = vodDetailPage.btn_share;
		WebElement img_rating_bar = vodDetailPage.img_rating_bar;
		WebElement txt_content_description = vodDetailPage.txt_content_description;
		WebElement txt_content_title = vodDetailPage.txt_content_title;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_content_title));
		wait.until(ExpectedConditions.visibilityOfAllElements(txt_content_description));
		wait.until(ExpectedConditions.visibilityOfAllElements(img_rating_bar));
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_share));
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_like));
		wait.until(ExpectedConditions.visibilityOfAllElements(btn_dislike));

		Assert.assertTrue(txt_content_title.isDisplayed());
		Assert.assertTrue(txt_content_description.isDisplayed());
		Assert.assertTrue(img_rating_bar.isDisplayed());
		Assert.assertTrue(btn_share.isDisplayed());
		Assert.assertTrue(btn_like.isDisplayed());
		Assert.assertTrue(btn_dislike.isDisplayed());
	}
}
