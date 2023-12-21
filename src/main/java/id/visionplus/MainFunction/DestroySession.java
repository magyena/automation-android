package id.visionplus.MainFunction;

import org.testng.annotations.AfterClass;

public class DestroySession extends BaseTest
{
	
	@AfterClass
	public void tearDown() {
		try
		{
			extent.flush();
			android.quit();
			service.stop();
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
