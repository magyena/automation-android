package id.visionplus.v2.TestCase.Premium;

/* Created Date	: 3 April 2024
 * Updated by	: Fatah
 * Updated Date	: 2 Mei 2024
 * 1. Fixing issue vod Download
 * */

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import id.visionplus.v2.PageObjects.VODDetailPage;
import id.visionplus.v2.PageObjects.VPlusOriginalsPage;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import io.appium.java_client.android.AndroidDriver;

public class TC_Premium_Download_VOD  extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM";

	@Test(priority = 1)
	public void TC_User_Can_Download_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);
		Thread.sleep(2000);

		click.clickMenuButton();
		click.clickSearchButton();
		input.clearSearch();

		click.clickSearchField();
		test.pass("Successfully Clicked Search Field");

		input.inputSearch("Cinta Di Balik Awan");
		test.pass("Successfully Input Search Field with Valid Keyword");

		click.clickVodCintaDiBalikAwan();
		test.pass("Successfully clicked VOD Eps 1");

		click.clickVodDownloadEps1();
		test.pass("Successfully clicked Eps 1 VOD");

		assertion.assertTitleVODEpisode();
		test.pass("Successfully assert title episode");
		
		click.clickEpsDownloadVOD();
		test.pass("Successfully Clicked Download VOD");

		try {
		    if (assertion.assertGPS()) {
		        click.clickTurnOnGps();
		        click.clickSwitchOnGps();
		        click.pressBack();
		        click.clickEpsDownloadVOD();
		        test.pass("Successfully Clicked Download VOD");
		        Thread.sleep(5000);
		        assertion.assertDownloadSuccessfully();
		        test.pass("Successfully assert Download VOD");
		    } else {
		        Thread.sleep(3000);
		        assertion.assertDownloadSuccessfully();
		        test.pass("Successfully assert Download VOD");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void TC_User_Cancel_DOwnload() throws IOException, InterruptedException, TimeoutException {
		click.clickCancelDownload();
		test.pass("Successfully Clicked Cancel Download");
		assertion.assertPopupConfirmDownload();
		Thread.sleep(2000);
		click.clickConfirmDownload();
		test.pass("Successfully Clicked Confirm Cancel");
		Thread.sleep(2000);
	}
}


