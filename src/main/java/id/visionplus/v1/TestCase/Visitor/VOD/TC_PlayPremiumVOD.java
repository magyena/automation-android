package id.visionplus.v1.TestCase.Visitor.VOD;

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

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.Action.Scroll;
import id.visionplus.v1.MainFunction.*;
import id.visionplus.v1.PageObjects.HomePageVisionPlus;
import id.visionplus.v1.PageObjects.VODPage;


public class TC_PlayPremiumVOD extends BaseTest {

	@Test
	public void TC_PlayPremiumVOD() throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();
		Scroll scroll = new Scroll(android);
		
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		click.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		click.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		scroll.scrollDown(0.37);

		click.clickPremiumVOD();
		Thread.sleep(2000);
		scroll.scrollDown(0.18);
		click.clickEps3VOD();
		assertion.assertErrorSubcriptionPremiumVOD();
	    Thread.sleep(3000);
		}
	
}
