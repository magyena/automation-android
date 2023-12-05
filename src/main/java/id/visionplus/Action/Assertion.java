package id.visionplus.Action;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import id.visionplus.PageObjects.*;
import io.appium.java_client.android.AndroidDriver;

public class Assertion
{

	AndroidDriver android;
	WebDriverWait wait;
	HomePageVisionPlus homePage;
	LoginPageVisionPlus loginPage;
	VODPage vodPage;
	LainnyaMenuPage lainnyaPage;
	TvKUPageVisionPlus tvKuPage;

	public Assertion(AndroidDriver android) {
		this.android = android;
	    homePage = new HomePageVisionPlus(android);
	    vodPage = new VODPage(android);
	    tvKuPage = new TvKUPageVisionPlus(android);
	}
	
	//Homepage
	
    public void assertTextPencarianFalse() {
		String actual = homePage.getAssertPencarianFalse().getText();
		String expected = "Pencarian Populer";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextPencarianCorrect() {
		String actual = homePage.getAssertPencarianCorrect().getText();
		String expected = "Film & TV";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextExploreByCategories() {
		String actual = homePage.getTextExploredByCategories().getText();
		String expected = "Explore By Categories";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextVisionPlusOriginal() {
		String actual = homePage.getTextVisionPlusOriginal().getText();
		String expected = "Vision+ Originals";
		Assert.assertEquals(actual, expected);
	}
	
	//VOD
	public void assertTitleChannelNationalTV() {
		String actual = vodPage.getTextTitleChannelNationalTV().getText();
		String expected = "Nasional TV";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void assertErrorSubcriptionPremiumLinear() {
		String actual = vodPage.getTextErrorSubcriptionPremiumVOD().getText();
		String expected = "Masuk ke akunmu untuk lanjut menonton dan nikmati konten kami di Vision+";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void assertErrorChooseSchedule() {
		String actual = vodPage.getTextErrorSubcriptionPremiumLinear().getText();
		String expected = "Silakan login untuk melanjutkan nonton dan nikmati konten di Vision+";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void assertErrorSubcriptionPremiumVOD() {
		String actual = vodPage.getTextErrorSubcriptionPremiumVOD().getText();
		String expected = "Masuk ke akunmu untuk lanjut menonton dan nikmati konten kami di Vision+";
		
		Assert.assertEquals(actual, expected);
	}
	
	//Lainnya
	public void assertTextContactUs() {
		String actual = lainnyaPage.getTextHubungiKamiEnglish().getText();
		String expected = "Email to ccare@visionplus.id or contact over WhatsApp to +62-888 800 0001";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextHubungiKami() {
		String actual = lainnyaPage.getTextHubungiKami().getText();
		String expected = "Email ke ccare@visionplus.id atau melalui WhatsApp +62-888 800 0001";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextRegistration() {
		String actual = lainnyaPage.getTextRegistrasi().getText();
		String expected = "REGISTRATION";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextRegistrasi() {
		String actual = lainnyaPage.getTextRegistrasi().getText();
		String expected = "REGISTRASI";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextSyaratDanKetentuan() {
		String actual = lainnyaPage.getTextSyaratDanKetentuan().getText();
		String expected = "Syarat & Ketentuan";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextPremiumSport() {
		String actual = lainnyaPage.getTextPremiumSportAndPremium().getText();
		String expected = "V+ PREMIUM SPORTS PRIVILEGES";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextPremium() {
		String actual = lainnyaPage.getTextPremiumSportAndPremium().getText();
		String expected = "V+ PREMIUM PRIVILEGES";
		Assert.assertEquals(actual, expected);
	}
	
	//Login
	public void assertWrongPhonePassword() {
		String expected = "Invalid password";
		String actual = loginPage.getTextWrongPhonePassword().getText();
	    Assert.assertEquals(actual, expected);	
	}
	
	public void assertWrongPhoneNumber() {
		String expected = "Format nomor handphone salah";
		String actual = loginPage.getTextWrongPhoneNumber().getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void assert_LoginPageShouldBeDisplayed() throws InterruptedException 
	{
		Thread.sleep(3000);
		boolean isEditTextPhoneExist = loginPage.getEditTextPhone().isDisplayed();
		boolean isBtnLoginEmail = loginPage.getLoginEmailButton().isDisplayed();
		Assert.assertTrue(isEditTextPhoneExist);
		Assert.assertTrue(isBtnLoginEmail);
	}
	
	//TV Ku
	public void assertPopupLogin()
	{

		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(tvKuPage.getPopupLogin()));
		
		Boolean isPopupPresent =  tvKuPage.getPopupLogin().isDisplayed();
		
		Assert.assertTrue(isPopupPresent);
	}
	
	public void assertLogin()
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(tvKuPage.getLoginButton()));
		
		Boolean isBtnLoginPresent =  tvKuPage.getLoginButton().isDisplayed();
		
		Assert.assertTrue(isBtnLoginPresent);
	}
}
