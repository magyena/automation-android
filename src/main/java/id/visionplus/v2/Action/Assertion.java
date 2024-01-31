package id.visionplus.v2.Action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import id.visionplus.v2.MainFunction.*;
import id.visionplus.v2.PageObjects.*;

public class Assertion extends BaseTest
{
	WebDriverWait wait;
	EntryPage entryPage;
	RegisterPage registerPage;
	
	public void assertTermsOfUsePageInd() {
		WebElement txt_widget_title = entryPage.txt_widget_terms_privacy;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_widget_title));
	    
	    String actual = txt_widget_title.getText();
	    String expected = "Syarat & Ketentuan";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertPrivacyPolicyPageInd() {
		WebElement txt_widget_title = entryPage.txt_widget_terms_privacy;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_widget_title));
	    
	    String actual = txt_widget_title.getText();
	    String expected = "Kebijakan Privasi";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertRegisterLoginPage(){
		registerPage = new RegisterPage(android);
		
		WebElement txt_register_title = registerPage.txt_register_title;
		WebElement txt_fld_phone = registerPage.txt_fld_phone;
		WebElement txt_fld_password = registerPage.txt_fld_password;
		WebElement btn_register_submit = registerPage.btn_register_submit;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_register_title));

	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_phone));
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register_submit));
	    	    
	    Assert.assertTrue(txt_register_title.isDisplayed());

	    Assert.assertTrue(txt_fld_phone.isDisplayed());

	    Assert.assertTrue(txt_fld_password.isDisplayed());

	    Assert.assertTrue(btn_register_submit.isDisplayed());
	}
	
	public void assertDropDownCountry(){
		WebElement txt_country_code = registerPage.txt_country_code;
		WebElement btn_country_1 = registerPage.btn_country_1;
		WebElement btn_country_2 = registerPage.btn_country_2;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_country_code));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_1));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_2));

	    String actual1 = txt_country_code.getText();
	    String expected1 = "Country Code";
	    Assert.assertEquals(actual1, expected1);
	    
	    String actual2 = btn_country_1.getText();
	    String expected2 = "Indonesia";
	    Assert.assertEquals(actual2, expected2);
	    
	    String actual3 = btn_country_2.getText();
	    String expected3 = "Malaysia";
	    Assert.assertEquals(actual3, expected3);
	}
	
	public void assertFilteredCountryKeyword(String keyword) {
		WebElement btn_country_1 = registerPage.btn_country_1;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_1));
	    
	    String actual = btn_country_1.getText();
	    String expected = keyword;
	    Assert.assertEquals(actual, expected);
	}
	
//	HomePageVisionPlus homePage;
//	LoginPageVisionPlus loginPage;
//	VODPage vodPage;
//	LainnyaMenuPage lainnyaPage;
//	TvKuPageVisionPlus tvKuPage;
//	GamesPlusMenuPage gamesPlusPage;
	
	//Homepage
//	
//	public void assertTextPencarianFalse() {
//	    String actual = homePage.txtAssertPencarianFalse.getText();
//	    String expected = "Pencarian Populer";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextPencarianCorrect() {
//	    String actual = homePage.txtAssertPencarianCorrect.getText();
//	    String expected = "Film & TV";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextExploreByCategories() {
//	    String actual = homePage.txtExploredByCategories.getText();
//	    String expected = "Explore By Categories";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextVisionPlusOriginal() {
//	    String actual = homePage.txtVisionPlusOriginal.getText();
//	    String expected = "Vision+ Originals";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	// VOD
//	public void assertTitleChannelNationalTV() {
//	    String actual = vodPage.txtTitleChannelNationalTV.getText();
//	    String expected = "Nasional TV";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertErrorSubcriptionPremiumLinear() {
//	    String actual = vodPage.txtErrorSubcriptionPremiumVOD.getText();
//	    String expected = "Masuk ke akunmu untuk lanjut menonton dan nikmati konten kami di Vision+";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertErrorChooseSchedule() {
//	    String actual = vodPage.txtErrorSubcriptionPremiumLinear.getText();
//	    String expected = "Silakan login untuk melanjutkan nonton dan nikmati konten di Vision+";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertErrorSubcriptionPremiumVOD() {
//	    String actual = vodPage.txtErrorSubcriptionPremiumVOD.getText();
//	    String expected = "Masuk ke akunmu untuk lanjut menonton dan nikmati konten kami di Vision+";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	// Lainnya
//	public void assertTextContactUs() {
//	    String actual = lainnyaPage.txtHubungiKamiEnglish.getText();
//	    String expected = "Email to ccare@visionplus.id or contact over WhatsApp to +62-888 800 0001";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextHubungiKami() {
//	    String actual = lainnyaPage.txtHubungiKami.getText();
//	    String expected = "Email ke ccare@visionplus.id atau melalui WhatsApp +62-888 800 0001";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextRegistration() {
//	    String actual = lainnyaPage.txtRegistrasi.getText();
//	    String expected = "REGISTRATION";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextRegistrasi() {
//	    String actual = lainnyaPage.txtRegistrasi.getText();
//	    String expected = "REGISTRASI";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextSyaratDanKetentuan() {
//	    String actual = lainnyaPage.txtSyaratDanKetentuan.getText();
//	    String expected = "Syarat & Ketentuan";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextPremiumSport() {
//	    String actual = lainnyaPage.txtPremiumSportAndPremium.getText();
//	    String expected = "V+ PREMIUM SPORTS PRIVILEGES";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	public void assertTextPremium() {
//	    String actual = lainnyaPage.txtPremiumSportAndPremium.getText();
//	    String expected = "V+ PREMIUM PRIVILEGES";
//	    Assert.assertEquals(actual, expected);
//	}
//
//	// Login
//	public void assertLoginPage() {
//		loginPage = new LoginPageVisionPlus(android);
//		wait = new WebDriverWait(android, Duration.ofSeconds(90));
//	    wait.until(ExpectedConditions.visibilityOfAllElements(loginPage.txtDaftarMasuk));
//	    
//	    Boolean txtDaftarMasukPresent = loginPage.txtDaftarMasuk.isDisplayed();
//	    Boolean txtPhoneEditPresent = loginPage.txtEditTextPhone.isDisplayed();
//	    Boolean btnContinuePresent = loginPage.btnContinue.isDisplayed();
//	    Boolean btnLoginEmailPresent = loginPage.btnLoginEmail.isDisplayed();
//	    Boolean btnWithFacebookPresent = loginPage.btnWithFacebook.isDisplayed();
//	    Boolean btnWithGooglePresent = loginPage.btnWithGoogle.isDisplayed();
//	    
//	    Assert.assertTrue(txtDaftarMasukPresent);
//	    Assert.assertTrue(txtPhoneEditPresent);
//	    Assert.assertTrue(btnContinuePresent);
//	    Assert.assertTrue(btnLoginEmailPresent);
//	    Assert.assertTrue(btnWithFacebookPresent);
//	    Assert.assertTrue(btnWithGooglePresent);
//	    
//		test.pass("Assertion in Login Page Successful");
//	}
//	
//	public void assertLoginPopUp() {
//		loginPage = new LoginPageVisionPlus(android);
//		wait = new WebDriverWait(android, Duration.ofSeconds(90));
//	    wait.until(ExpectedConditions.visibilityOfAllElements(loginPage.txtDaftarMasukPopUp));
//	    
//	    Boolean txtDaftarMasukPresent = loginPage.txtDaftarMasukPopUp.isDisplayed();
//	    Assert.assertTrue(txtDaftarMasukPresent);
//	}
//	
//	public void assertWrongPhonePassword() {
//	    String expected = "Invalid password";
//	    String actual = loginPage.txtWrongPhonePassword.getText();
//	    Assert.assertEquals(actual, expected);
//	    
//		test.pass("Assertion Wrong Password Number is Expected");
//	}
//
//	public void assertWrongPhoneNumber() {
//	    String expected = "Format nomor handphone salah";
//	    String actual = loginPage.txtWrongPhoneNumber.getText();
//	    Assert.assertEquals(actual, expected);
//	    
//		test.pass("Assertion Wrong Phone Number is Expected");
//	}
//
//	public void assertLoginPageShouldBeDisplayed() throws InterruptedException {
//	    Thread.sleep(3000);
//	    boolean isEditTextPhoneExist = loginPage.txtEditTextPhone.isDisplayed();
//	    boolean isBtnLoginEmail = loginPage.btnLoginEmail.isDisplayed();
//	    Assert.assertTrue(isEditTextPhoneExist);
//	    Assert.assertTrue(isBtnLoginEmail);
//	}
//
//	// TV Ku
//	public void assertPopupLogin() {
//	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
//	    wait.until(ExpectedConditions.visibilityOfAllElements(tvKuPage.btnPopupLogin));
//
//	    Boolean isPopupPresent = tvKuPage.btnPopupLogin.isDisplayed();
//	    Assert.assertTrue(isPopupPresent);
//	}
//
//	public void assertLogin() {
//	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
//	    wait.until(ExpectedConditions.visibilityOfAllElements(tvKuPage.btnLogin));
//
//	    Boolean isBtnLoginPresent = tvKuPage.btnLogin.isDisplayed();
//	    Assert.assertTrue(isBtnLoginPresent);
//	}
//	
//	//Games Plus
//	public void assertGamesPlusPage() {
//	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
//	    wait.until(ExpectedConditions.visibilityOfAllElements(gamesPlusPage.txtTitleGamesPlus));
//
//	    Boolean istxtTitleGamesPlusPresent = gamesPlusPage.txtTitleGamesPlus.isDisplayed();
//	    Assert.assertTrue(istxtTitleGamesPlusPresent);
//	}
//	
//	public void assertGamesPlusDetailsPage() {
//	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
//	    wait.until(ExpectedConditions.visibilityOfAllElements(gamesPlusPage.txtTitleGamesPlusDetails));
//
//	    Boolean istxtTitleGamesPlusDetailsPresent = gamesPlusPage.txtTitleGamesPlusDetails.isDisplayed();
//	    Assert.assertTrue(istxtTitleGamesPlusDetailsPresent);
//	}
//
}
