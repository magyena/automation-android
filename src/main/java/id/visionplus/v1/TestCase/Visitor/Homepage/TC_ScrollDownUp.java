package id.visionplus.v1.TestCase.Visitor.Homepage;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.Action.Scroll;
import id.visionplus.v1.MainFunction.*;

public class TC_ScrollDownUp extends BaseTest{
	
	@Test
	public void TC_ScrollDownUp() throws InterruptedException {
	Click click = new Click();
	Scroll scroll = new Scroll(android);
	Assertion assertion = new Assertion();
	
	Thread.sleep(3000);
	click.lewatiButton();
	test.pass("User berhasil Klik skip button");
	
	Thread.sleep(3000);
	click.clickBtnShowcaseTvConnect();
	test.pass("User berhasil Klik Button Showcase TV Connect");
	
	click.clickBtnShowcaseOk();
	test.pass("User berhasil Klik Button Showcase OK");
	
	scroll.scrollDown(0.04);
    Thread.sleep(3000);
	test.pass("user berhasil Scrolldown Homepage");
	
	scroll.scrollUpNoParameter(0.0);
	
	Thread.sleep(1000);
	assertion.assertTextVisionPlusOriginal();
    Thread.sleep(3000);
    test.pass("user berhasil Scrollup Homepage");
	}

}
