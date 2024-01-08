package id.visionplus.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageVisionPlus extends AndroidGesture{

	AndroidDriver android;
	WebDriverWait wait;
	
	public LoginPageVisionPlus(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/tv_titleLimited")
    public static WebElement txtDaftarMasukPopUp;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
    public static WebElement txtDaftarMasuk;
	
	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_sign_in")
    public static WebElement btnMasuk;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_register")
    public static WebElement btnWithEmail;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_google")
    public static WebElement btnWithGoogle;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_facebook")
    public static WebElement btnWithFacebook;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/et_phone")
    public static WebElement btnWithPhone;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/et_email")
    public static WebElement txtEmailTextBox;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/et_password")
    public static WebElement txtPasswordEmailTextBox;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_continue")
    public static WebElement btnContinue;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/et_password")
    public static WebElement txtPasswordPhoneTextBox;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/tv_error_message")
    public static WebElement txtWrongPhoneNumber;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/tv_msg_popup")
    public static WebElement txtWrongPhonePassword;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/edit_text_1")
    public static WebElement txtInputOtp1;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/edit_text_2")
    public static WebElement txtInputOtp2;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/edit_text_3")
    public static WebElement txtInputOtp3;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/edit_text_4")
    public static WebElement txtInputOtp4;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/et_phone")
    public static WebElement txtEditTextPhone;

    @AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_register")
    public static WebElement btnLoginEmail;
}
