package org.visionplus_android.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LainnyaMenuPage extends AndroidGesture{
	
	AndroidDriver android;
	
	public LainnyaMenuPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_setting")
	private WebElement pengaturanButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_package")
	private WebElement paketButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_privileges")
	private WebElement textPremiumSportAndPremium;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_more")
	private WebElement btnLainnya;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_term")
	private WebElement btnSyaratDanKetentuan;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_faq")
	private WebElement btnPertanyaan;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Premium\"]")
	private WebElement btnTextPremium;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_contact_us")
	private WebElement btnHubungiKami;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_title_toolbar")
	private WebElement textSyaratDanKetentuan;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[3]")
	private WebElement textHubungiKami;
	
	@AndroidFindBy(xpath="//android.widget.TabWidget/android.view.View/android.view.View[1]")
	private WebElement textRegistrasi;
	
	@AndroidFindBy(xpath="//android.widget.TextView[2]")
	private WebElement btnPertanyaanEnglish;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[3]")
	private WebElement textHubungiKamiEnglish;
	
	public void assertTextContactUs() {
		String actual = textHubungiKamiEnglish.getText();
		String expected = "Email to ccare@visionplus.id or contact over WhatsApp to +62-888 800 0001";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextHubungiKami() {
		String actual = textHubungiKami.getText();
		String expected = "Email ke ccare@visionplus.id atau melalui WhatsApp +62-888 800 0001";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextRegistration() {
		String actual = textRegistrasi.getText();
		String expected = "REGISTRATION";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextRegistrasi() {
		String actual = textRegistrasi.getText();
		String expected = "REGISTRASI";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextSyaratDanKetentuan() {
		String actual = textSyaratDanKetentuan.getText();
		String expected = "Syarat & Ketentuan";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextPremiumSport() {
		String actual = textPremiumSportAndPremium.getText();
		String expected = "V+ PREMIUM SPORTS PRIVILEGES";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextPremium() {
		String actual = textPremiumSportAndPremium.getText();
		String expected = "V+ PREMIUM PRIVILEGES";
		Assert.assertEquals(actual, expected);
	}
	
	public void clickBtnHubungiKami() {
		btnHubungiKami.click();
	}
	
	public void clickPertanyaanEnglish() {
		btnPertanyaanEnglish.click();
	}
	
	public void clickBtnPertanyaan() {
		btnPertanyaan.click();
	}
	
	public void clickBtnSyaratDanKetentuan() {
		btnSyaratDanKetentuan.click();
	}
	
	public void clickBtnLainnya() {
		btnLainnya.click();
	}
	
	public void clickBtnTextPremium() {
		btnTextPremium.click();
	}
	
	public void clickPaketButton() {
		paketButton.click();
	}
	
	public void pengaturanLainnya() {
		pengaturanButton.click();
	}

}
