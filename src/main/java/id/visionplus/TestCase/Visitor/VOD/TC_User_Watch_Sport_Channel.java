package id.visionplus.TestCase.Visitor.VOD;

import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.Action.Scroll;
import id.visionplus.MainFunction.BaseTest;

public class TC_User_Watch_Sport_Channel extends BaseTest
{
	@Test
	public void TC_User_Watch_Sport_Channel() throws InterruptedException
	{
		Click click = new Click();
		Assertion assertion = new Assertion();
		Scroll scroll = new Scroll(android);
		
		try
		{
			click.lewatiButton();
			test.pass("Sukses lewati button");

			click.clickBtnShowcaseTvConnect();
			test.pass("sukses lewati button showcase");
			
			click.clickBtnShowcaseOk();
			test.pass("sukses lewati button showcase");
			
			click.lainnyaButton();
			//test.pass("Sukses lewati button");
			
			click.clickBtnTVku();
			test.pass("Sukses lewati button TVku");
			
			scroll.scrollDown(0.1);
			
			click.clickSportStar();
			test.pass("sukses klik sporstar");
			
			assertion.assertPopupLogin();
			assertion.assertLogin();
			
		} 
		catch (Exception e) 
		{
			
		}
	
		
	}

}
