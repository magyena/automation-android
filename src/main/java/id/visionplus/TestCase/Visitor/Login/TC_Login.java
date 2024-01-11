package id.visionplus.TestCase.Visitor.Login;

import org.testng.annotations.Test;

import id.visionplus.MainFunction.BaseTest;
import id.visionplus.PageObjects.LoginPageVisionPlus;

public class TC_Login extends BaseTest {
	
	LoginPageVisionPlus loginpage;

	@Test
	public void LoginVisionPlus(String loginWith, String username, String password) throws InterruptedException {
		loginpage = new LoginPageVisionPlus(android);
		if(loginWith.equalsIgnoreCase("email")) {
			
			loginpage.btnLoginEmail.click();
			loginpage.txtEmailTextBox.click();
			loginpage.txtEmailTextBox.sendKeys(username);
			loginpage.btnContinue.click();
			loginpage.txtPasswordEmailTextBox.click();
			loginpage.txtPasswordEmailTextBox.sendKeys(password);
			
		} else if(loginWith.equalsIgnoreCase("google")) {
			loginpage.btnWithGoogle.click();
		} else if(loginWith.equalsIgnoreCase("facebook")) {
			loginpage.btnWithFacebook.click();
		} else if(loginWith.equalsIgnoreCase("phone")) {
			Thread.sleep(5000);
			loginpage.btnWithPhone.click();
			loginpage.btnWithPhone.sendKeys(username);
			loginpage.btnContinue.click();
			loginpage.txtPasswordPhoneTextBox.click();
			loginpage.txtPasswordPhoneTextBox.sendKeys(password);
		} else {
			System.out.println("Wrong Input Method Login");
		}
		
		Thread.sleep(3000);
	}

}
