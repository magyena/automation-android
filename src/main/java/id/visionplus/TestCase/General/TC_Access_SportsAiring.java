package id.visionplus.TestCase.General;

import org.testng.annotations.Test;

import id.visionplus.Action.Click;
import id.visionplus.Action.Scroll;
import id.visionplus.MainFunction.BaseTest;
import id.visionplus.TestCase.General.*;

public class TC_Access_SportsAiring extends BaseTest{

	Click click = new Click();
	
	@Test
	public void TC_SportsAiring() throws InterruptedException {
		Scroll scroll = new Scroll(android);
		TC_Access_SportsPage access_sport_page = new TC_Access_SportsPage();
		access_sport_page.TC_SportsPage();
	    Thread.sleep(3000);
		test.pass("user berhasil Scrolldown SportPage");
		 // Use the existing method to scroll down
		
	    Thread.sleep(3000);
        click.clickAdsSportPage();
        System.out.println("success Click Ads");

        //load the element by scroll to random coordinate
	    Thread.sleep(3000);
    	scroll.scrollDown(0.07);
        System.out.println("success Scroll dikit");

        //scroll to exact element
	    Thread.sleep(3000);
        click.clickAiringTodaySportChannel();
        System.out.println("success Click Airing Sport");
        
	    Thread.sleep(3000);
	}
	
}
