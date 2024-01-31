package id.visionplus.v1.TestCase.General;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;

public class TC_OpenApp extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Open_App() throws InterruptedException, TimeoutException {		
		
		Thread.sleep(3000);
	}
	
}
