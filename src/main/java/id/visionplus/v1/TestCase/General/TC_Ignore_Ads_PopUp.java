package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_Ignore_Ads_PopUp extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Ignore_Ads_Notif() throws InterruptedException, TimeoutException {
		//Land on Homepage as Free User
		Thread.sleep(5000);
		click.clickIgnoreLayoutNotif();
		test.pass("User Berhasil Click Close Pop Up Package Notification");
//		click.clickCloseAdsButton();
		test.pass("User Berhasil Click Close Ads");
	}
	
}
