package id.visionplus.v2.TestCase.Euro;
/* Author		: Michael Liong
 * Created Date	: 17 May 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: TC_Cluster_Euro
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
import id.visionplus.v2.TestCase.General.TC_Get_OTP;
import id.visionplus.v2.TestCase.General.TC_Homepage;
import id.visionplus.v2.TestCase.General.TC_Menu;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Integrate_Register;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Phone_Number;
import id.visionplus.v2.TestCase.PremiumSport.TC_Premium_Sport_User_Watch_Live_TV;
import io.appium.java_client.android.Activity;

public class TC_Cluster_Euro extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp = new TC_Get_OTP();
	String phone_number = epoch_random();
	BaseTest base = new BaseTest();
	Tap tap = new Tap();
	TC_Premium_Sport_User_Watch_Live_TV sport_linear_tc = new TC_Premium_Sport_User_Watch_Live_TV();

	public String epoch_random() {
		long epochTime = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		String formattedTime = dateFormat.format(new Date(epochTime));
		String result = "8990000" + formattedTime.substring(0, Math.max(0, 9 - "899".length()));
		return result;
	}

	String testcaseType = "FREE";
	
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
		
		boolean historyEuroClicked = false;

		try {
		    click.clickHistoryPremium30DaysPlaystore();
		    flag = 1;
		} catch (Exception ex) {
//		    System.out.println("Error: " + ex);
		    try {
		        click.clickHistoryPremiumSport30DaysPlaystore();
		        flag = 1;
		    } catch (Exception e) {
//		        System.out.println("Error: " + e);
		    }
		}

		if (flag == 1) {
		    try {
		        click.clickCancelSubscriptionPlaystore();
		        click.clickBtnNoThanksPlaystore();
		        click.clickRadioCancelPlaystore();
		        test.pass("Successfully clicked radio button");

		        click.clickBtnContinuePlaystore();
		        test.pass("Successfully clicked continue");

		        click.clickConfirmCancelPlaystore();
		        test.pass("Successfully clicked cancel subscription");
		        click.clickBacktoHistory();

		        if (!historyEuroClicked) {
		            click.clickHistoryPremiumSport30DaysPlaystore();
		            historyEuroClicked = true;
		            flag = 2; 
		        }
		    } catch (Exception ex) {
//		        System.out.println("Error: " + ex);
		    }
		  
		    if (flag == 2) {
		        try {
		        	click.clickCancelSubscriptionPlaystore();
			        click.clickBtnNoThanksPlaystore();
			        click.clickRadioCancelPlaystore();
			        test.pass("Successfully clicked radio button");

			        click.clickBtnContinuePlaystore();
			        test.pass("Successfully clicked continue");

			        click.clickConfirmCancelPlaystore();
			        test.pass("Successfully clicked cancel subscription");
			        click.clickBacktoHistory();
		        } catch (Exception ex) {
//		            System.out.println("Error: " + ex);
		        }
		    }
		}
	}

	@Test(priority = 1)	
	public void TC_Euro_Package_Exist_Before_Payment() throws InterruptedException, IOException, TimeoutException {
//		TC_Cancel_Subscription_Playstore();
		
		TC_Integrate_Register register = new TC_Integrate_Register();
		base.ConfigureAppium();
		Thread.sleep(5000);

		register.TC_user_input_valid_phone_number_and_password();
		register.TC_user_click_send_otp_2nd_time();
		register.TC_user_input_correct_otp();
		
		TC_Menu menu = new TC_Menu();
		menu.TC_Access_Buy_Package();
        test.pass("Successfully Access Buy Package");
		
		assertion.assertEuroPackageExist();
        test.pass("Successfully Assert Euro Package");
	}
	
	@Test(priority = 2)	
	public void TC_Euro_Package_Payment() throws InterruptedException, IOException, TimeoutException {
		click.clickEuroPackage();
		test.pass("Successfully clicked euro package");

		assertion.assertSubscriptionImage();
		test.pass("Successfully assert subscription image");

		click.clickSubscribe();
		test.pass("Successfully clicked subscribe button");
		System.out.println("Done Click Subscribe");
		
		Thread.sleep(3000);
		
		assertion.assertSubscriptionEuroPlaystore();
		test.pass("Successfully assert subscribe Euro Playstore");
		
		assertion.assertSubscriptionEuroPricePlaystore();
		test.pass("Successfully assert subscribe Euro Price Playstore");
		
		int attempt = 0;
		int flag = 0;
		int maxAttempts = 3;  // Set the maximum number of attempts as needed

		while (attempt < maxAttempts && flag == 0) {
		    try {
		        for (int i = 0; i < 10; i++) {
		            click.clickBtnGotIt();
		            test.pass("Successfully clicked 'Got It' again");
		            click.clickSubscribe();
		            flag = 1;
		            break; // Exit the for loop after a successful attempt
		        }
		    } catch (Exception e) {
		        try {
		            click.clickBtnSubscriptionsPlaystore();
		            test.pass("Successfully clicked button subscriptions playstore");
		            flag = 1;
		        } catch (Exception ex) {
		            try {
		                click.clickBtnAccept();
		                test.pass("Successfully clicked button accept pending subscription");
		                flag = 1;
		            } catch (Exception finalEx) {
		                test.fail("Failed to click the buttons in all attempts");
		            }
		        }
		    }
		    attempt++; // Increment the attempt counter inside the while loop
		}

		// Optionally, handle the case where all attempts failed
		if (flag == 0) {
		    test.fail("All attempts to click the buttons failed");
		}

		System.out.println("Done Click Subscribe in Playstore");
		
		click.pressBack();
	}
	
	@Test(priority = 3)	
	public void TC_Euro_Package_on_Current_Package() throws InterruptedException, IOException, TimeoutException {
		click.pressBack();
		
		TC_Menu menu = new TC_Menu();
		menu.TC_Access_Buy_Package();
        test.pass("Successfully Access Buy Package");
		
        Thread.sleep(3000);       
		assertion.assertCurrentEuroPackage();
        test.pass("Successfully Assert Current Euro Package");
	}
	
	@Test(priority = 4)	
	public void TC_Watch_Free_Premium_Channel() throws InterruptedException, IOException, TimeoutException {
		click.pressBack();
		
		click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");
	    
	    click.clickLiveTv();
	    test.pass("Successfully Clicked Menu Button");
		
		click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");
	    
	    click.clickLiveTv();
	    test.pass("Successfully Clicked Menu Button");
	    
		click.clickFreeLinear();
		test.pass("Successfully Clicked Free Linear Channel");

		Thread.sleep(1000);

		assertion.assertLiveTVPlayed();
		test.pass("Successfully Assert Live TV is Played");
		
		sport_linear_tc.TC_Premium_Sport_User_Watch_Premium_Linear();
	}
	
	@Test(priority = 5)	
	public void TC_Watch_Euro_Channel_1() throws InterruptedException, IOException, TimeoutException {
		Scroll scroll = new Scroll(android);
		By locatorEuro1 = By.xpath("//*[contains(@text,'1003')]");
		scroll.scrollUntilElementFound(locatorEuro1);
		System.out.println("Success Scroll and Find Euro 1 Channel");
		
		click.clickEuro1Channel();
        test.pass("Successfully Click Euro 1 Channel");
		
		assertion.assertLiveTVPlayed();
		test.pass("Successfully Assert Live TV is Played");
		
		System.out.println("Success Play Euro 1 Channel");
	}
	
	@Test(priority = 6)	
	public void TC_Watch_Euro_Channel_2() throws InterruptedException, IOException, TimeoutException {
		Scroll scroll = new Scroll(android);
		By locatorEuro2 = By.xpath("//*[contains(@text,'1004')]");
		scroll.scrollUntilElementFound(locatorEuro2);
		System.out.println("Success Scroll and Find Euro 2 Channel");
		
		click.clickEuro2Channel();
        test.pass("Successfully Click Euro 2 Channel");
		
		assertion.assertLiveTVPlayed();
		test.pass("Successfully Assert Live TV is Played");
		System.out.println("Success Play Euro 2 Channel");
	}
}