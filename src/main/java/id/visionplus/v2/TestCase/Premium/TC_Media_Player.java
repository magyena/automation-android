package id.visionplus.v2.TestCase.Premium;

import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;

public class TC_Media_Player extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();

	@Test(priority = 1)
	public void TC_Forward_Backward_VOD() throws IOException, TimeoutException, InterruptedException {

		TC_OpenApp open_app = new TC_OpenApp();
		open_app.TC_Open_app_as_Premium_User();

		click.clickFirstContentClusterVPlusOriginals();
		click.clickWatchVOD();

		assertion.assertMediaPlayerPlayed();
		test.pass("Succesfully assert media player played normally");

		for (int i = 0; i < 2; i++) {
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
		for (int i = 0; i < 2; i++) {
			try {
				click.clickRewinddMediaPlayer();
				System.out.println("Success: Success Clicked Rewind");
			} catch (Exception e) {
				System.out.println("Failed: Failed Clicked Rewind");
			}
		}
		Thread.sleep(3000);
	}

	@Test(priority = 2, dependsOnMethods = "TC_Forward_Backward_VOD")
	public void TC_User_Click_Setting_Player() throws IOException, TimeoutException, InterruptedException {

		click.clickLayoutMediaPLayer();

		click.clickRestartMediaPlayer();
		test.pass("Successfully clicked restart player");

		click.clickSettingsMediaPlayer();
		test.pass("Successfully clicked settings player");

		Thread.sleep(2000);

		assertion.assertSettingsAudioMediaPlayer();
		Thread.sleep(3000);

		click.clickConfirmOKMediaPlayer();

		Thread.sleep(10000);
		click.pressBack();
		click.pressBack();
	}

	@Test(priority = 3, dependsOnMethods = "TC_User_Click_Setting_Player")
	public void TC_User_Choose_Disabled_Language() throws IOException, TimeoutException, InterruptedException {
		click.clickMenuButton();
		click.clickSearchButton();
		input.clearSearch();

		click.clickSearchField();
		test.pass("Successfully Clicked Search Field");

		input.inputSearch("Cinta Di Balik Awan");
		test.pass("Successfully Input Search Field with Valid Keyword");

		click.clickVodCintaDiBalikAwan();

		click.clickWatchVOD();

		click.clickSettingsMediaPlayer();
		Thread.sleep(2000);

		assertion.assertSettingsLanguageMediaPlayer();

		click.clickDisableLanguageMediaPlayer();

	}

	@Test(priority = 4, dependsOnMethods = "TC_User_Choose_Disabled_Language")
	public void TC_User_Choose_English_Language() throws IOException, TimeoutException, InterruptedException {

		click.clickEnglishLanguageMediaPlayer();

		Thread.sleep(3000);
		click.clickConfirmOKMediaPlayer();
		Thread.sleep(5000);
	}

	@Test(priority = 5, dependsOnMethods = "TC_User_Choose_English_Language")
	public void TC_User_Next_Episode() throws IOException, TimeoutException, InterruptedException {

		click.clickLayoutMediaPLayer();
		Thread.sleep(5000);
		click.clickLayoutMediaPLayer();
		click.clickNextEpisodeMediaPlayer();

		Thread.sleep(3000);
		click.clickLayoutMediaPLayer();
		Thread.sleep(5000);
		click.clickLayoutMediaPLayer();
		assertion.assertNextEpisodeMediaPlayer();
		Thread.sleep(3000);

	}

	@Test(priority = 6, dependsOnMethods = "TC_User_Next_Episode")
	public void TC_User_Previous_Episode() throws IOException, TimeoutException, InterruptedException {

		click.clickLayoutMediaPLayer();
		Thread.sleep(5000);
		click.clickLayoutMediaPLayer();
		click.clickPreviousEpisodeMediaPlayer();

		Thread.sleep(5000);

		click.clickLayoutMediaPLayer();
		assertion.assertPreviousEpisodeMediaPlayer();

		click.pressBack();
		Thread.sleep(10000);

	}
}
