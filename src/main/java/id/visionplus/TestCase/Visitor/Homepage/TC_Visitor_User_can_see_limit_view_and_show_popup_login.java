package id.visionplus.TestCase.Visitor.Homepage;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_Visitor_User_can_see_limit_view_and_show_popup_login extends BaseTest
{
	
	
	@Test
	public void TC_Visitor_User_can_see_limit_view_and_show_popup_login() throws InterruptedException
	{
		try
		{
			Click click = new Click();
			Assertion assertion = new Assertion();
			
			Thread.sleep(3000);
			click.lewatiButton();
			test.pass("Sukses lewati button");

			Thread.sleep(3000);
			click.clickBtnShowcaseTvConnect();
			test.pass("User berhasil Klik Button Showcase TV Connect");
			
			click.clickBtnShowcaseOk();
			test.pass("User berhasil Klik Button Showcase OK");

			click.lainnyaButton();
			test.pass("Sukses lewati button");
			
			click.clickBtnTVku();
			test.pass("Sukses lewati button TVku");
			
		
			click.clickBtnFreeLinearAntv();
			
			click.clickBtnChromeCast();
			test.pass("User berhasil Klik Button Chromecast");
			click.clickBtnDataSaver();
			test.pass("User berhasil Klik Button Data Saver");
			for (int i = 0; i < 10; i++) 
			{
				Thread.sleep(60000);
				System.out.println("loop");
			}
			assertion.assertErrorSubcriptionPremiumLinear();
		} 
		catch (Exception e) 
		{
			
		}
	
		
		
	}

}
