package id.visionplus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageVisionPlus extends AndroidGesture{

	AndroidDriver android;
	WebDriverWait wait;
	
	public LoginPageVisionPlus(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	public WebElement getMasukButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_sign_in"));
    }

	public WebElement getWithEmail() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_register"));
    }

	public WebElement getWithGoogle() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_google"));
    }

	public WebElement getWithFacebook() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_facebook"));
    }

	public WebElement getWithPhone() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/et_phone"));
    }

	public WebElement getEmailTextBox() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/et_email"));
    }

	public WebElement getPasswordEmailTextBox() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/et_password"));
    }

	public WebElement getContinueButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_continue"));
    }

	public WebElement getPasswordPhoneTextBox() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/et_password"));
    }

	public WebElement getTextWrongPhoneNumber(){
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_error_message"));
    }

	public WebElement getTextWrongPhonePassword() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_msg_popup"));
    }

	public WebElement getInputOtp1() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/edit_text_1"));
    }
	
	public WebElement getInputOtp2() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/edit_text_2"));
    }
	
	public WebElement getInputOtp3() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/edit_text_3"));
    }
	
	public WebElement getInputOtp4() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/edit_text_4"));
    }

	public WebElement getEditTextPhone() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/et_phone"));
    }

	public WebElement getLoginEmailButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_register"));
    }
}
