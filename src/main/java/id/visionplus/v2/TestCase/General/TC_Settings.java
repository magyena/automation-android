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

public class TC_Settings extends BaseTest {

    Click click = new Click();
    Assertion assertion = new Assertion();
    Input input = new Input();
    SettingPage settingsPage = new SettingPage(android);
    
// 	Get the test case type from TestNG parameters
  String testCaseType = "FREE";
//	String testCaseType = System.getProperty("testCaseType");

    
    @Test(priority = 1)
    public void TC_Access_Settings() throws IOException, InterruptedException, TimeoutException {
    	System.out.println("Arrived at TC_Access_Settings");
        TC_OpenApp open_app = new TC_OpenApp();

        if ("PREMIUM_SPORT".equals(testCaseType)) {
            open_app.Choose_Login_As("PREMIUM_SPORT");
        } else if ("FREE".equals(testCaseType)) {
            open_app.Choose_Login_As("FREE");
        }
         
        click.clickMenuButton();
        test.pass("Successfully Clicked Menu Button");

        Thread.sleep(2000);

        click.clickSettingsButton();
        test.pass("Successfully Clicked Settings Button");
    }

    @Test(priority = 2, dependsOnMethods = "TC_Access_Settings")
    public void TC_Access_Transaction_History() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Transaction_History");

        try {
            Thread.sleep(2000);

            click.clickTransactionHistory();
            test.pass("Successfully Clicked Transaction History Button");

            assertion.assertTransactionHistory();
            test.pass("Successfully Assert Transaction History Page");

        } catch (Throwable e) {
            test.fail("Script TC_Access_Transaction_History Failed: " + e.getMessage());
            throw e;
        }
    	//Even though the test may failed, its still need to go back to Setting page
        click.clickCloseToSettings();
        test.pass("Successfully Clicked Close to Settings Button");
    }

    @Test(priority = 2, dependsOnMethods = "TC_Access_Settings")
    public void TC_Access_Manage_Profile() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Manage_Profile");

        try {
            Thread.sleep(2000);

            click.clickManageProfile();
            test.pass("Successfully Clicked Manage Profile Button");

            assertion.assertManageProfile();
            test.pass("Successfully Assert Manage Profile Page");

        } catch (Throwable e) {
            test.fail("Script TC_Access_Manage_Profile Failed: " + e.getMessage());
            throw e;
        }
    	//Even though the test may failed, its still need to go back to Setting page
        click.clickSettingsBackButton();
        test.pass("Successfully Clicked Back to Settings Button");
    }

    @Test(priority = 2, dependsOnMethods = "TC_Access_Settings")
    public void TC_Access_Notification_Centre() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Notification_Centre");

        try {
            Thread.sleep(2000);

            click.clickNotificationCentre();
            test.pass("Successfully Clicked Notification Centre Button");

            assertion.assertNotificationCentre();
            test.pass("Successfully Assert Notification Centre Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_Notification_Centre Failed: " + e.getMessage());
            throw e;
        }
        
    	//Even though the test may failed, its still need to go back to Setting page
        click.clickSettingsBackButton();
        test.pass("Successfully Clicked Back to Settings Button");
    }

    @Test(priority = 3, dependsOnMethods = "TC_Access_Settings")
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

    @Test(priority = 4, dependsOnMethods = "TC_Access_Voucher")
    public void TC_User_input_Expired_Voucher() throws InterruptedException {
    	System.out.println("Arrived at TC_User_input_Expired_Voucher");

        try {
	        Thread.sleep(2000);
	
	        click.clickVoucherField();
	        test.pass("Successfully Clicked Voucher Field");
	
	        input.clearVoucherField();
	        test.pass("Successfully Clear Voucher Code Field");
	
	        input.inputVoucher("PRODWTF8U8MZ1WEXP");
	        test.pass("Successfully Input Expired Voucher Code");
	
	        android.hideKeyboard();
	
	        click.clickRedeemVoucher();
	        test.pass("Successfully Clicked Redeem Button");
	
	        Thread.sleep(2000);
	
	        assertion.assertVoucherExpired();
	        test.pass("Successfully Assert Voucher Expired Warning Text");
        } catch (Throwable e) {
            test.fail("Script TC_User_input_Expired_Voucher Failed:" + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 5)
    public void TC_User_input_Invalid_Voucher() throws InterruptedException {
    	System.out.println("Arrived at TC_User_input_Invalid_Voucher");

    	try{
	        Thread.sleep(2000);
	
	        click.clickVoucherField();
	        test.pass("Successfully Clicked Voucher Field");
	
	        input.clearVoucherField();
	        test.pass("Successfully Clear Voucher Code Field");
	
	        input.inputVoucher("ASDFWKJHWK");
	        test.pass("Successfully Input Invalid Voucher Code");
	
	        android.hideKeyboard();
	
	        click.clickRedeemVoucher();
	        test.pass("Successfully Clicked Redeem Button");
	
	        Thread.sleep(2000);
	
	        assertion.assertVoucherInvalid();
	        test.pass("Successfully Assert Voucher Invalid Warning Text");
	    } catch (Throwable e) {
	        test.fail("Script TC_User_input_Expired_Voucher Failed:" + e.getMessage());
	        throw e;
	    }
    }

    @Test(priority = 6)
    public void TC_User_input_Redeemed_Voucher() throws InterruptedException {
    	System.out.println("Arrived at TC_User_input_Redeemed_Voucher");

    	try {
	        Thread.sleep(2000);
	
	        click.clickVoucherField();
	        test.pass("Successfully Clicked Voucher Field");
	
	        input.clearVoucherField();
	        test.pass("Successfully Clear Voucher Code Field");
	
	//        input.inputVoucher("TP3011165333");
	        input.inputVoucher("TP3098349246");
	
	        test.pass("Successfully Input Redeemed Voucher Code");
	
	        android.hideKeyboard();
	
	        click.clickRedeemVoucher();
	        test.pass("Successfully Clicked Redeem Button");
	
	        Thread.sleep(2000);
	
	        assertion.assertVoucherReedemed();
	        test.pass("Successfully Assert Voucher Redeemed Warning Text");	
        } catch (Throwable e) {
            test.fail("Script TC_User_input_Redeemed_Voucher Failed:" + e.getMessage());
            throw e;
        }
    	//Even though the test may failed, its still need to go back to Setting page
        click.pressBack();
    }

    @Test(priority = 7, dependsOnMethods = "TC_User_input_Redeemed_Voucher")
    public void TC_Access_Help_Centre() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Help_Centre");

        try {
            Thread.sleep(2000);

            Scroll scroll = new Scroll(android);
            
    		By locator = By.xpath("//*[contains(@text,'Help')]");
            scroll.scrollUntilElementFound(locator);
            
            scroll.scrollDown(0.2);

            click.clickHelpButton();
            test.pass("Successfully Clicked Help Centre Button");

            assertion.assertHelpCentre();
            test.pass("Successfully Assert Help Centre Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_Help_Centre Failed: " + e.getMessage());
        	//If the test its still need to go back to Setting page
            click.clickCloseToSettings();
            test.pass("Successfully Clicked Close Help Center Page");
            throw e;
        }
    }

    @Test(priority = 8, dependsOnMethods = "TC_Access_Help_Centre")
    public void TC_Access_About_Us() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_About_Us");

    	try {
	        click.clickAboutUs();
	        test.pass("Successfully Clicked About Us Button in Help Center Page");
	
	        Thread.sleep(2000);
	
	        assertion.assertAboutUs();
	        test.pass("Successfully Assert About Us Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_About_Us Failed: " + e.getMessage());
            throw e;
        }
    	
    	//Even though the test may failed, its still need to go back to help page
        click.pressBack();
        test.pass("Successfully Press Back Button");
    }

    @Test(priority = 9, dependsOnMethods = "TC_Access_About_Us()")
    public void TC_Access_WhatsApp() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_WhatsApp");

    	try {
	        Thread.sleep(2000);
	
	        click.clickWhatsAppInHelp();
	        test.pass("Successfully Clicked WhatsApp Button in Help Center Page");
	
	        Thread.sleep(5000);
	
	        assertion.assertDirectToWhatsApp();
	        test.pass("Successfully Assert WhatsApp Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_WhatsApp Failed: " + e.getMessage());
            throw e;
        }
    	
    	//Even though the test may failed, its still need to go back to help page
        click.pressBack();
        test.pass("Successfully Press Back Button");
    }
    
    @Test(priority = 10, dependsOnMethods = "TC_Access_WhatsApp()")
    public void TC_Access_Subscription_Transaction() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Subscription_Transaction");

    	try {
	        Thread.sleep(2000);
	
	        click.clickSubscriptionTransaction();
	        test.pass("Successfully Clicked Subscription and Transaction Button in Help Center Page");
	
	        Thread.sleep(2000);
	
	        assertion.assertSubscriptionTransaction();
	        test.pass("Successfully Assert Subscription and Transaction Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_Subscription_Transaction Failed: " + e.getMessage());
            throw e;
        }
    	
        click.pressBack();
        test.pass("Successfully Press Back Button");
    }

    @Test(priority = 11, dependsOnMethods = "TC_Access_Subscription_Transaction()")
    public void TC_Access_Email() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Email");

    	try {
	        Thread.sleep(2000);
	
	        click.clickEmailInHelp();
	        test.pass("Successfully Clicked Email Button in Help Center Page");
	
	        Thread.sleep(5000);
	
	        assertion.assertDirectToGmail();
	        test.pass("Successfully Assert Gmail Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_Email Failed: " + e.getMessage());
            throw e;
        }
    	
        android.hideKeyboard();
    	
        click.pressBack();
        test.pass("Successfully Press Back Button");
    }

    @Test(priority = 12, dependsOnMethods = "TC_Access_Subscription_Transaction()")
    public void TC_Access_Legal_Information() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Legal_Information");

        try {
            Thread.sleep(2000);
            
            Scroll scroll = new Scroll(android);

    		By locator = By.xpath("//*[contains(@text,'Legal information')]");
            scroll.scrollUntilElementFound(locator);

            click.clickLegalInformation();
            test.pass("Successfully Clicked Legal Information Button");

            Thread.sleep(2000);

            assertion.assertLegalInformation();
            test.pass("Successfully Assert Legal Information Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_Legal_Information Failed: " + e.getMessage());
            
            //if failed, then go back to settings
            click.pressBack();
            test.pass("Successfully Press Back Button to Legal Information Page");
            throw e;
        }
    }

    @Test(priority = 13, dependsOnMethods = "TC_Access_Legal_Information")
    public void TC_Access_Software_Licenses() throws InterruptedException {
    	System.out.println("Arrived at TC_Access_Software_Licenses");

    	try {
	        Thread.sleep(2000);
	
	        click.clickSoftwareLicenses();
	        test.pass("Successfully Clicked Software License Button");
	
	        Thread.sleep(2000);
	
	        assertion.assertSoftwareLicense();
	        test.pass("Successfully Assert Software License Page");
        } catch (Throwable e) {
            test.fail("Script TC_Access_Software_Licenses Failed: " + e.getMessage());
            throw e;
        }
    	
        click.pressBack();
        test.pass("Successfully Press Back Button to Legal Information Page");
        
        click.pressBack();
        test.pass("Successfully Press Back Button to Setting Page");
    }
}
