package id.visionplus.v2.TestCase.Premium;

import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;

public class TC_Media_Player extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();

	@Test(priority = 1)
	public void TC_Forward_Backward_VOD() throws IOException, TimeoutException, InterruptedException {

		TC_OpenApp open_app = new TC_OpenApp();
		open_app.TC_Open_app_as_Premium_User();

		click.clickFirstContentClusterVPlusOriginals();
		click.clickWatchVOD();

		assertion.assertMediaPlayerPlayed();
		test.pass("Succesfully assert media player played normally");

		for (int i = 0; i < 3; i++) {
			try {
				click.clickFastForwardMediaPlayer();
				System.out.println("Success: Success Clicked Forward");
			} catch (Exception e) {
				System.out.println("Failed: Failed Clicked Forward");
			}
		}

		test.pass("Successfully clicked fastforward");
		Thread.sleep(3000);

		click.clickLayoutMediaPLayer();
		for (int i = 0; i < 3; i++) {
			try {
				click.clickRewinddMediaPlayer();
				System.out.println("Success: Success Clicked Rewind");
			} catch (Exception e) {
				System.out.println("Failed: Failed Clicked Rewind");
			}
		}
		Thread.sleep(3000);
	}

		@Test(priority = 2, dependsOnMethods ="TC_Forward_Backward_VOD" )
		public void TC_User_Click_Setting_Player() throws IOException, TimeoutException, InterruptedException {

		click.clickLayoutMediaPLayer();
		
		click.clickRestartMediaPlayer();
		test.pass("Successfully clicked restart player");
		
//		click.pressBack();
		Thread.sleep(10000);
	}
	
}
