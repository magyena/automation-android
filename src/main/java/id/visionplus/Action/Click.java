package id.visionplus.Action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.PageObjects.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Click
{

	AndroidDriver android;
	WebDriverWait wait;
	
	HomePageVisionPlus homePage;
	LainnyaMenuPage lainnyaPage;
	VODPage vodPage;
	LoginPageVisionPlus loginPage;
	PengaturanPage pengaturanPage;
	MenuFooterPage menuFooter;
	MenuHeaderPage menuHeader;
	VplusOriPage vPlusOriPage;
	TvKUPageVisionPlus tvKuPage;
	
	public Click(AndroidDriver android) {
		this.android = android;
	    homePage = new HomePageVisionPlus(android);
	    lainnyaPage = new LainnyaMenuPage(android);
	    loginPage = new LoginPageVisionPlus(android);
	    vodPage = new VODPage(android);
	    pengaturanPage = new PengaturanPage(android);
	    menuHeader = new MenuHeaderPage(android);
	    vPlusOriPage = new VplusOriPage(android);
	    tvKuPage = new TvKUPageVisionPlus(android);
	}
	
	//Search
	public void clickBtnClear() {
		homePage.getClearButton().click();
	}
	
	public void clickTextViewSearchCorrect(String input){
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		
		WebElement textViewSearch = homePage.getTextViewSearch();
		wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearch));
		textViewSearch.click();

		WebElement textViewSearchInside = homePage.getTextViewSearchInside();
		wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearchInside));
		textViewSearchInside.sendKeys(input);

		((AndroidDriver) android).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void clickTextViewSearchFalse(String input) {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		
		WebElement textViewSearch = homePage.getTextViewSearch();
		wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearch));
		textViewSearch.click();

		WebElement textViewSearchInside = homePage.getTextViewSearchInside();
		wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearchInside));
		textViewSearchInside.sendKeys(input);

		((AndroidDriver) android).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	//Search END
	
	//Homepage
	public void clickBtnSearch() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement searchButton = homePage.getSearchButton();
		wait.until(ExpectedConditions.visibilityOfAllElements(searchButton));
		searchButton.click();
	}
	
	public void clickBtnTVku() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement tvKuButton = homePage.getTvKuButton();
		wait.until(ExpectedConditions.elementToBeClickable(tvKuButton));
		tvKuButton.click();
	}
	
	public void clickBtnShowcaseTvConnect() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement showcaseTvConnectButton = homePage.getShowcaseTvConnectButton();
		wait.until(ExpectedConditions.elementToBeClickable(showcaseTvConnectButton));
		showcaseTvConnectButton.click();
	}
	
	public void clickBtnSelengkapnya() {
		homePage.getSelengkapnyaButton().click();
	}
	
	public void clickBanner() {
		homePage.getBannerHomepage().click();
	}
	
	public void clickBtnShowcaseOk() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement showcaseOkButton = homePage.getShowcaseOkButton();
		wait.until(ExpectedConditions.visibilityOfAllElements(showcaseOkButton));
		showcaseOkButton.click();
	}
	
	public void removePopupSub() {
		homePage.getRemovePopupSub().click();
	}
	
	public void lainnyaButton() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement lainnyaButton = homePage.getLainnyaButton();
		wait.until(ExpectedConditions.visibilityOfAllElements(lainnyaButton));
		lainnyaButton.click();
	}
	
	public void lewatiButton() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement lewatiButton = homePage.getSkipButton();
		wait.until(ExpectedConditions.elementToBeClickable(lewatiButton));
		lewatiButton.click();
	}
	
	public void clickButtonSignin()
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement signInButton = homePage.getSignInButton();
		wait.until(ExpectedConditions.visibilityOfAllElements(signInButton));
		signInButton.click();
	}
	//Homepage END
	
	//Lainnya Menu Page
	public void clickBtnHubungiKami() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement hubungiKamiButton = lainnyaPage.getHubungiKamiButton();
		wait.until(ExpectedConditions.visibilityOfAllElements(hubungiKamiButton));
		lainnyaPage.getHubungiKamiButton().click();
	}
	
	public void clickPertanyaanEnglish() {
		lainnyaPage.getPertanyaanEnglishButton().click();
	}
	
	public void clickBtnPertanyaan() {
		lainnyaPage.getPertanyaanButton().click();
	}
	
	public void clickBtnSyaratDanKetentuan() {
		lainnyaPage.getSyaratDanKetentuanButton().click();
	}
	
	public void clickBtnLainnya() {
		lainnyaPage.getLainnyaButton().click();
	}
	
	public void clickBtnTextPremium() {
		lainnyaPage.getTextPremiumButton().click();
	}
	
	public void clickPaketButton() {
		lainnyaPage.getPaketButton().click();
	}
	
	public void pengaturanLainnya() {
		lainnyaPage.getPengaturanButton().click();
	}
	//Lainnya Menu Page END
	
	//VOD Page
	public void clickBtnScheduleCatchup() {
		vodPage.getScheduleCatchup().click();
	}
	
	public void clickBtnSchedule() {
		vodPage.getScheduleButton().click();
	}
	
	public void clickBtnDataSaver() {
		vodPage.getDataSaverButton().click();
	}
	
	public void clickBtnChromeCast() {
		vodPage.getChromeCastButton().click();
	}
	
	public void clickBtnPremiumLinearTransTV() {
		vodPage.getPremiumLinearTransTvButton().click();
	}
	
	public void clickBtnFreeLinearAntv() {
		vodPage.getFreeLinearAntvButton().click();
	}
	
	public void clickEps3VOD() {
		vodPage.getMoviePremiumOriginalEps3().click();
	}
	
	public void clickEps1VOD() {
		vodPage.getMoviePremiumOriginalEps1().click();
	}
	
	public void clickPremiumVOD() {
		vodPage.getMoviePremiumOriginal().click();
	}
	
	public void clickWatchList() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(vodPage.getWatchListButton()));
		vodPage.getWatchListButton().click();
	}
	
	public void clickDownload() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(vodPage.getDownloadButton()));
		vodPage.getDownloadButton().click();
	}
	//VOD Page END
	
	//Login
	public void clickLoginWithEmail() {
		loginPage.getWithEmail().click();
	}
	
	public void clickMasukButton() {
		loginPage.getMasukButton().click();
	}
	
	public void clickButtonContinue() {
		loginPage.getContinueButton().click();
	}
	//Login END
	
	//Pengaturan
	public void SignOut() {
		pengaturanPage.getKeluarButton().click();
		pengaturanPage.getAcceptKeluarButton().click();
	}
	//Pengaturan END
	
	//Menu Footer
	public void clickMenuBeranda() {
		menuFooter.getMenuBeranda().click();
	}
	
	public void clickliveTv()
	{
		menuFooter.getTvKu().click();
	}
	//Menu Footer END
	
	//Menu Header
	public void clickMenuVplusOriginal() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(menuHeader.getMenuHeaderVPlusOriginal()));
		menuHeader.getMenuHeaderVPlusOriginal().click();
	}
	//Menu Header END
	
	//VPlus Ori Page
	public void clickMenuVplusOriginalSelengkapnya() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(vPlusOriPage.getMenuVplusOriginalSelengkapnya()));
		vPlusOriPage.getMenuVplusOriginalSelengkapnya().click();
	}

	public void clickFirstVOD() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(vPlusOriPage.getFirstVOD()));
		vPlusOriPage.getFirstVOD().click();
	}
	//VPlus Ori Page END
	
	//TV Ku
	public void clickSportStar() {
		
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(tvKuPage.getChannelSportStarButton()));
		tvKuPage.getChannelSportStarButton().click();
	}
	
	public void clickCancelLogin() {
		
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(tvKuPage.getCancelOnPopupLoginButton()));
		tvKuPage.getCancelOnPopupLoginButton().click();
	}
	
	public void clickMasuk()
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(tvKuPage.getMasukButton()));
		tvKuPage.getMasukButton().click();
	}
	//TV Ku END
	
}
