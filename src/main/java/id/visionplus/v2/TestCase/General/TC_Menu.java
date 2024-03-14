package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Menu extends BaseTest{
	Click click = new Click();
	Assertion assertion = new Assertion();
	
	String testCaseType = System.getProperty("testCaseType");
	
	@Test
	public void TC_Access_Live_Tv() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);
				
		click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");
	    
	    click.clickLiveTv();
	    test.pass("Successfully Clicked Menu Button");
	}
	
	@Test
	public void TC_Access_Settings() throws IOException, InterruptedException, TimeoutException {
        TC_OpenApp open_app = new TC_OpenApp();
        open_app.TC_Open_App_as_Free_User();

        Thread.sleep(2000);

        click.clickMenuButton();
        test.pass("Successfully Clicked Menu Button");

        Thread.sleep(2000);

        click.clickSettingsButton();
        test.pass("Successfully Clicked Settings Button");
	}
	
	@Test
	public void TC_Access_Search() throws IOException, InterruptedException, TimeoutException {
        Thread.sleep(2000);

        click.clickMenuButton();
        test.pass("Successfully Clicked Menu Button");

        Thread.sleep(2000);

        click.clickSearchButton();
        test.pass("Successfully Clicked Search Button");
        
        assertion.assertSearchPage();
        test.pass("Successfully Assert Search Page");
	}
	
	public void TC_Access_My_Download_As_Free_User() throws IOException, InterruptedException, TimeoutException {
        TC_OpenApp open_app = new TC_OpenApp();
        open_app.TC_Open_App_as_Free_User();

        Thread.sleep(2000);

        click.clickMenuButton();
        test.pass("Successfully Clicked Menu Button");

        Thread.sleep(2000);
        
        click.clickMyDownloads();
        test.pass("Successfully Clicked My Downloads Button");

        assertion.assertMyDownloadPageFree();
        test.pass("Successfully Assert My Downloads Page as Free User");
	}
}
