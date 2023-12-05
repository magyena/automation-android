package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.BaseTest;
import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;

public class TC_SyaratKetentuan extends BaseTest{
	
	@Test
	public void TC_SyaratKetentuan() throws InterruptedException {		
		Click click = new Click(android);
		Assertion assertion = new Assertion(android);
		
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
