package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_Access_GamesPlus extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Access_GamesPlus() throws InterruptedException, TimeoutException {
		System.out.println("TC Access GamesPlus");
		click.clickIgnoreLayoutNotif();
		Thread.sleep(5000);
		click.clickGamesPlus();
		test.pass("User berhasil Klik menu GamesPlus");
		
		click.clickIgnoreLayoutNotif();
		Thread.sleep(7000);
		Assertion assertion = new Assertion();
		assertion.assertGamesPlusPage();
		test.pass("User berhasil Assert Halaman GamesPlus");				
	}
	
}
