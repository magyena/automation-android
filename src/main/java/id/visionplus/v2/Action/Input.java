package id.visionplus.v2.Action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.PageObjects.HomePage;
import id.visionplus.v2.PageObjects.RegisterPage;
import id.visionplus.v2.PageObjects.SearchPage;
import id.visionplus.v2.PageObjects.SettingPage;

public class Input extends BaseTest
{
	WebDriverWait wait;
	RegisterPage registerPage;
	SettingPage settingPage;
	SearchPage searchPage;
	HomePage homePage;
	
	Click click = new Click();

	public void inputProfileName(String keyword){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_add_profile_name = homePage.txt_fld_add_profile_name;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_add_profile_name));
	    txt_fld_add_profile_name.sendKeys(keyword);
	}
	
	public void clearProfileName(){
		homePage = new HomePage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_add_profile_name = homePage.txt_fld_add_profile_name;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_add_profile_name));
	    txt_fld_add_profile_name.clear();
	}
	
	public void inputSearch(String keyword){
		searchPage = new SearchPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_search = searchPage.txt_fld_search;
	    txt_fld_search.sendKeys(keyword);
	}
	
	public void clearSearch(){
		searchPage = new SearchPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_search = searchPage.txt_fld_search;
	    txt_fld_search.clear();
	}
	
	public void inputPhoneNumber(String keyword){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_phone = registerPage.txt_fld_phone;
	    txt_fld_phone.sendKeys(keyword);
	}
	
	public void inputPhoneNumberForgot(String keyword){
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement phoneNumberElement = android.findElement(By.xpath("//android.widget.TextView[@text='Phone Number']/following::android.widget.EditText[1]"));
		phoneNumberElement.sendKeys(keyword);
	}
	
	public void inputEmail(String keyword){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_email = registerPage.txt_fld_email;
	    txt_fld_email.sendKeys(keyword);
	}
	
	public void inputPassword(String keyword){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    txt_fld_password.sendKeys(keyword);
	}
	
	public void inputCountryKeyword(String keyword){
	    registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_country_code = registerPage.txt_fld_country_code;
	    txt_fld_country_code.sendKeys(keyword);
	}
	
	public void clearCountryCodeField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_country_code = registerPage.txt_fld_country_code;
	    txt_fld_country_code.clear();
	}
	
	public void clearPhoneNumberField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_phone = registerPage.txt_fld_phone;
	    txt_fld_phone.clear();
	}
	
	public void clearEmailField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_email = registerPage.txt_fld_email;
	    txt_fld_email.clear();
	}
	
	public void clearPasswordField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    txt_fld_password.clear();
	}
	
	public void inputOTP(String otp) throws InterruptedException{
	    registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement fld_otp = registerPage.fld_otp;

	    String existingText = fld_otp.getAttribute("text");
	   	    
	    // Loop through each character of the OTP string
	    for (int i = 0; i < 4; i++) {
	        // Get the digit at position i
	        char digit = otp.charAt(i);

	        // Append the current digit to the existing text
	        existingText += digit;	        
	        fld_otp.sendKeys(existingText);
	    }
	    
	    System.out.println("Inputed: "+otp);
	}
	
	public void clearOTP(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement fld_otp = registerPage.fld_otp;
	    fld_otp.clear();;
	}
	
	public void inputVoucher(String voucher){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_voucher = settingPage.txt_fld_voucher;
	    
	    wait.until(ExpectedConditions.visibilityOf(txt_fld_voucher));
	    txt_fld_voucher.sendKeys(voucher);
	}
	
	public void clearVoucherField(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_voucher = settingPage.txt_fld_voucher;
	    txt_fld_voucher.clear();
	}
	
	public void ClearCurrentPasswordChangePassword(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_current_password = settingPage.field_account_Enter_current_password;
	    txt_fld_current_password.clear();
	}
	
	public void ClearNewPasswordChangePassword(){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_new_password = settingPage.field_account_Enter_new_password;
	    txt_fld_new_password.clear();
	}
	
	public void inputCurrentPasswordChangePassword(String keyword){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_current_password = settingPage.field_account_Enter_current_password;
	    txt_current_password.sendKeys(keyword);
	}
	
	public void inputNewPasswordChangePassword(String keyword){
		settingPage = new SettingPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_new_password = settingPage.field_account_Enter_new_password;
	    txt_new_password.sendKeys(keyword);
	    
	
	}
}