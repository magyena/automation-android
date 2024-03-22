package id.visionplus.v2.TestCase.General;
/* Author		: Fatah Alim
 * Created Date	: 22 Maret 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: TC_Cluster_Film
 * 1. Click Cluster Movies
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
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Phone_Number;

public class TC_Cluster_Film extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp = new TC_Get_OTP();
	String phone_number = epoch_random();

	public String epoch_random() {
		long epochTime = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		String formattedTime = dateFormat.format(new Date(epochTime));
		String result = "899" + formattedTime.substring(0, Math.max(0, 13 - "899".length()));
		return result;
	}
	
//	String testcaseType = "FREE";

	@Test(priority = 1)

	public void TC_User_Can_Slide_List_Cluster_Films() throws InterruptedException, IOException, TimeoutException {
		TC_Register_With_Phone_Number register = new TC_Register_With_Phone_Number();
		register.TC_user_input_valid_phone_number_and_password();
		
		Thread.sleep(2000);
		register.TC_user_input_correct_otp();
		
		Thread.sleep(2000);
		Point start = new Point(1017, 1029);
		Point end = new Point(133, 1033);
		Swipe swipe = new Swipe(android);
		swipe.swipeLeftProgramGuide(start, end);
		test.pass("Successfully Swipe ");

		click.clickTxtClusterMovies();
		test.pass("Successfully clicked Movies");

		assertion.assertBannerInfo();
		test.pass("Successfully assert banner info");

		swipe.swipeLeftProgramGuide(start, end);
		test.pass("Successfully Swipe ");

		swipe.swipeLeftProgramGuide(start, end);
		test.pass("Successfully Swipe ");

		Thread.sleep(2000);

		Scroll scroll = new Scroll(android);
		By locator = By.xpath(
				"//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripTitle\" and @text=\"Asian Action Movies\"]");
		scroll.scrollUntilElementFound(locator);

		scroll.scrollUp(100);

		Thread.sleep(2000);
	}

	@Test(priority = 2)

	public void TC_User_Can_Upgrade_to_Premium() throws InterruptedException, IOException, TimeoutException {
	}
}
