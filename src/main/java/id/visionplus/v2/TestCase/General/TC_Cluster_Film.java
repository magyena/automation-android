package id.visionplus.v2.TestCase.General;
/* Author		: Fatah Alim
 * Created Date	: 1 April 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: TC_Cluster_Film
 * 1. Update validation after buy package
 * */

import java.awt.Point;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Free.TC_Integrate_Register;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Phone_Number;
import io.appium.java_client.android.Activity;

public class TC_Cluster_Film extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp = new TC_Get_OTP();
	String phone_number = epoch_random();
	BaseTest base = new BaseTest();
	Tap tap = new Tap();

	public String epoch_random() {
		long epochTime = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		String formattedTime = dateFormat.format(new Date(epochTime));
		String result = "899" + formattedTime.substring(0, Math.max(0, 13 - "899".length()));
		return result;
	}

//	String testcaseType = "FREE";

	@Test(priority = 1)

	public void TC_Cancel_Subscription_Playstore() throws InterruptedException, IOException, TimeoutException {
		click.pressBack();
		Thread.sleep(2000);
		Activity activity = new Activity("com.android.vending", "com.google.android.finsky.activities.MainActivity");
		android.startActivity(activity);

		click.clickBtnProfilePlaystore();
		test.pass("Successfully clicked profile playstore");

		click.clickBtnPaymentandSubscriptionsPlaystore();
		test.pass("Successfully clicked payments and subscriptions playstore");

		click.clickBtnSubscriptionsPlaystore();
		test.pass("Successfully clicked subcsriptions playstore");

		int flag = 0;
		boolean historyPremium30DaysClicked = false;
		boolean historyPremiumSport30DaysClicked = false;
		try {
			while (true) {
				if (flag == 0 && !historyPremium30DaysClicked) {
					click.clickHistoryPremium30DaysPlaystore();
					historyPremium30DaysClicked = true;
				} else if (flag == 1 && !historyPremiumSport30DaysClicked) {
					click.clickHistoryPremiumSport30DaysPlaystore();
					historyPremiumSport30DaysClicked = true;
				}

				if (!historyPremium30DaysClicked && !historyPremiumSport30DaysClicked) {
					System.out.println("Error: Neither action performed.");
					break;
				}

				click.clickCancelSubscriptionPlaystore();
				click.clickBtnNoThanksPlaystore();
				click.clickRadioCancelPlaystore();
				test.pass("Successfully clicked radio button");

				click.clickBtnContinuePlaystore();
				test.pass("Successfully clicked continue");

				click.clickConfirmCancelPlaystore();
				test.pass("Successfully clicked cancel subscription");
				click.clickBacktoHistory();
				Thread.sleep(2000);

				flag = (flag == 0) ? 1 : 0;

			}
		} catch (Exception e) {
			Thread.sleep(2000);
		}
	}

	@Test(priority = 2)

	public void TC_User_Can_Upgrade_to_Premium() throws InterruptedException, IOException, TimeoutException {
		TC_Integrate_Register register = new TC_Integrate_Register();
		base.ConfigureAppium();
		Thread.sleep(5000);

		register.TC_user_input_valid_phone_number_and_password();
		register.TC_user_click_send_otp_2nd_time();
		register.TC_user_input_correct_otp();

		Point start = new Point(988, 1028);
		Point end = new Point(79, 1018);
		Swipe swipe = new Swipe(android);
		swipe.swipetoLeft(start, end);
		test.pass("Successfully Swipe ");

		click.clickClusterSlideMovies();
		test.pass("Successfully clicked Movies");
		Thread.sleep(5000);

		assertion.assertBannerInfo();
		test.pass("Successfully assert banner info");

		Point start2 = new Point(109, 1022);
		Point end2 = new Point(1000, 1028);
		swipe.swipetoLeft(start2, end2);
		test.pass("Successfully Swipe ");

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'Asian Action Movies')]");
		scroll.scrollUntilElementFound(locator);

		scroll.scrollUp(100);

		click.clickActionCategory();
		test.pass("Succesfully clicked action category");

		assertion.assertActionCategory();
		test.pass("Successfully assert movies");

		click.clickActionCategory();
		test.pass("Succesfully clicked action category");

		try {
			assertion.assertSubscribetoPremiumSport();
			System.out.println("Assert Success: Subscription Button Is Display.");
		} catch (AssertionError e) {
			System.out.println("Assert Failure:  Subscription Button Is not  Display.");
			System.out.println("Error message: " + e.getMessage());
		}

		Thread.sleep(2000);
		click.clickSubscribe();
		test.pass("Successfully clicked subscribe button");

		assertion.assertPopUpPackages();
		test.pass("Successfully assert popup packages");

		Point start3 = new Point(537, 1506);
		Point end3 = new Point(537, 1128);
		swipe.swipetoLeft(start3, end3);
		test.pass("Successfully Swipe ");

		click.clickPremium30daysPckages();
		test.pass("Successfully clicked premium 30 days");

		assertion.assertSubscriptionImage();
		test.pass("Successfully assert subscription image");
		click.clickSubscribe();
		test.pass("Successfully clicked button subscribe");
		int flag = 0;
		int maxAttempts = 10;
		int attempt = 0;

		while (attempt < maxAttempts && flag == 0) {
		    try {
		        for (int i = 0; i < 10; i++) {
		            click.clickBtnGotIt();
		            test.pass("Successfully clicked 'Got It' again");
		            click.clickSubscribe();
		            flag = 1;
		        }
		    } catch (Exception e) {
		        try {
		        	 click.clickBtnSubscriptionsPlaystore();
		             test.pass("Successfully clicked button subscriptions playstore");
		        } catch (Exception ex) {
		        	click.clickBtnAccept(); 
		            test.pass("Successfully clicked button accept pending subscription");
		            flag = 1;
		            break; 
		        }
		    }
		}
	    attempt++;
	    Thread.sleep(5000);
	    
	    click.clickWatchVOD();
		test.pass("Successfully clicked watch vod");
		
		Thread.sleep(10000);
		click.pressBack();
		test.pass("Successfully clicked back button");

		click.clickBack();
		test.pass("Successfully clicked back button");

		click.clickBack();
		test.pass("Successfully clicked back button");
		click.clickBack();
		test.pass("Successfully clicked back button");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void TC_User_Can_Upgrade_Premium_to_Premium_Sports()
			throws InterruptedException, IOException, TimeoutException {
		Thread.sleep(2000);
		click.clickMenuButton();
		test.pass("Successfully clicked menu");

		assertion.assertMenu();
		test.pass("Successfully assert menu");

		click.clickMyPackage();
		test.pass("Successfully clicked My Package");

		assertion.assertMenuBuyPackage();
		test.pass("Successfully assert menu buy package");

		assertion.assertActivePackagePremium30();
		test.pass("Successfully assert active package 30 days");
		
		click.clickPremiumSports30daysPackage();
		test.pass("Successfully clicked premium sports 30 days");
		
		assertion.assertSubscriptionImage();
		test.pass("Successfully assert subscription image");

		click.clickSubscribe();
		test.pass("Successfully clicked subscribe button");

		assertion.assertSubscriptionPremiumSports30days();
		test.pass("Successfully assert subscribe premium sports 30 days");
		
		click.clickBtnSubscriptionsPlaystoreagain();
        test.pass("Successfully clicked button subscriptions playstore");
		
		click.clickBtnAccept();
		test.pass("Successfully clicked accept");
		Thread.sleep(5000);
		click.clickMenuButton();
		click.clickMyPackage();
		assertion.assertActivePackagePremium30Sports();
		test.pass("Successfully assert active package premium sports 30 days");
		
		click.clickMenuButton();
		click.clickMenuHome();
		click.clickVisionPlusOriginalsSeries();
		click.clickWatchVOD();
		Thread.sleep(10000);
		click.pressBack();
		click.clickSaveToWatchlist();

		Thread.sleep(2000);
	}
}