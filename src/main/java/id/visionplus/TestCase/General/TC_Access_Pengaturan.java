package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_Access_Pengaturan extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Access_Pengaturan() throws InterruptedException {
		click.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		click.clickPengaturanLainnya();
	}
	
}
