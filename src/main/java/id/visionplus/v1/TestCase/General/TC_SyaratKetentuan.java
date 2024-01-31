package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_SyaratKetentuan extends BaseTest{
	
	@Test
	public void TC_SyaratKetentuan() throws InterruptedException {		
		Click click = new Click();
		Assertion assertion = new Assertion();
		
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		click.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		click.clickBtnLainnya();
		click.clickBtnSyaratDanKetentuan();
		Thread.sleep(5000);
		assertion.assertTextSyaratDanKetentuan();
		
	}

}
