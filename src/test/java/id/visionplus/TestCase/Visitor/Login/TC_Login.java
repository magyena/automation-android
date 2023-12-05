package id.visionplus.TestCase.Visitor.Login;

import id.visionplus.BaseTest;
import id.visionplus.PageObjects.LoginPageVisionPlus;
import io.appium.java_client.android.AndroidDriver;

public class TC_Login extends BaseTest {
	
	LoginPageVisionPlus loginpage;
	
	public TC_Login(AndroidDriver android) {
		this.android = android;
		loginpage = new LoginPageVisionPlus(android);
	}

	public void LoginVisionPlus(String loginWith, String username, String password) throws InterruptedException {

		if(loginWith.equalsIgnoreCase("email")) {
			loginpage.getWithEmail().click();
			loginpage.getEmailTextBox().click();
			loginpage.getEmailTextBox().sendKeys(username);
			loginpage.getContinueButton().click();
			loginpage.getPasswordEmailTextBox().click();
			loginpage.getPasswordEmailTextBox().sendKeys(password);
		} else if(loginWith.equalsIgnoreCase("google")) {
			loginpage.getWithGoogle().click();
		} else if(loginWith.equalsIgnoreCase("facebook")) {
			loginpage.getWithFacebook().click();
		} else if(loginWith.equalsIgnoreCase("phone")) {
			Thread.sleep(5000);
			loginpage.getWithPhone().click();
			loginpage.getWithPhone().sendKeys(username);
			loginpage.getContinueButton().click();
			loginpage.getPasswordPhoneTextBox().click();
			loginpage.getPasswordPhoneTextBox().sendKeys(password);
		} else {
			System.out.println("Wrong Input Method Login");
		}
		
		Thread.sleep(3000);
	}

}
