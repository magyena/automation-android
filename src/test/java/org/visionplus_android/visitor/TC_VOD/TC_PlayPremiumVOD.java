package org.visionplus_android.visitor.TC_VOD;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;


public class TC_PlayPremiumVOD extends BaseTest {

	@Test
	public void TC_PlayPremiumVOD() throws InterruptedException {
		
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		homepage.scrollDown(0.37);
		VODPage vod = new VODPage(android);
		vod.clickPremiumVOD();
		Thread.sleep(2000);
		homepage.scrollDown(0.18);
	    vod.clickEps3VOD();
	    vod.assertErrorSubcriptionPremiumVOD();
	    Thread.sleep(3000);
		}
	
}
