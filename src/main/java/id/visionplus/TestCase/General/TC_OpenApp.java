package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_OpenApp extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Open_App() throws InterruptedException, TimeoutException {		
		
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		
	    Thread.sleep(3000);
		test.pass("Open App Success");
	}
	
}
