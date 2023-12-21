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
	LainnyaMenuPage LainnyaMenuPage;
	VODPage vodPage;
	LoginPageVisionPlus loginPage;
	PengaturanPage pengaturanPage;
	MenuFooterPage menuFooter;
	MenuHeaderPage menuHeader;
	VplusOriPage vPlusOriPage;
	TvKuPageVisionPlus tvKuPage;
	
	//Search
	public void clickBtnClear() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btnClear = homePage.btnClear;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btnClear));
	    btnClear.click();
	}
	
	public void clickTextViewSearchCorrect(String input) {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement textViewSearch = homePage.txtViewSearch;
	    wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearch));
	    textViewSearch.click();

	    WebElement textViewSearchInside = homePage.txtViewSearchInside;
	    wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearchInside));
	    textViewSearchInside.sendKeys(input);

	    ((AndroidDriver) android).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void clickTextViewSearchFalse(String input) {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement textViewSearch = homePage.txtViewSearch;
	    wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearch));
	    textViewSearch.click();

	    WebElement textViewSearchInside = homePage.txtViewSearchInside;
	    wait.until(ExpectedConditions.visibilityOfAllElements(textViewSearchInside));
	    textViewSearchInside.sendKeys(input);

	    ((AndroidDriver) android).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	//Search END
	
	//Homepage
	public void clickBtnSearch() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement searchButton = homePage.btnSearch;
	    wait.until(ExpectedConditions.visibilityOfAllElements(searchButton));
	    searchButton.click();
	}

	public void clickBtnTVku() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement tvKuButton = homePage.getTvKuButton();
	    wait.until(ExpectedConditions.elementToBeClickable(tvKuButton));
	    tvKuButton.click();
	}

	public void clickBtnShowcaseTvConnect() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement showcaseTvConnectButton = homePage.btnShowcaseTvConnect;
	    wait.until(ExpectedConditions.elementToBeClickable(showcaseTvConnectButton));
	    showcaseTvConnectButton.click();
	}

	public void clickBtnSelengkapnya() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement selengkapnyaButton = homePage.btnSelengkapnya;
	    wait.until(ExpectedConditions.visibilityOfAllElements(selengkapnyaButton));
	    selengkapnyaButton.click();
	}

	public void clickBanner() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement bannerButton = homePage.btnBannerHomepage;
	    wait.until(ExpectedConditions.visibilityOfAllElements(bannerButton));
	    bannerButton.click();
	}

	public void clickBtnShowcaseOk() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement showcaseOkButton = homePage.btnShowCaseOK;
	    wait.until(ExpectedConditions.visibilityOfAllElements(showcaseOkButton));
	    showcaseOkButton.click();
	}

	public void removePopupSub() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement removePopupButton = homePage.removePopUpSub;
	    wait.until(ExpectedConditions.visibilityOfAllElements(removePopupButton));
	    removePopupButton.click();
	}

	public void lainnyaButton() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement lainnyaButton = homePage.btnMenuLainnya;
	    wait.until(ExpectedConditions.visibilityOfAllElements(lainnyaButton));
	    lainnyaButton.click();
	}

	public void lewatiButton() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement lewatiButton = homePage.btnSkip;
	    wait.until(ExpectedConditions.elementToBeClickable(lewatiButton));
	    lewatiButton.click();
	}

	public void clickButtonSignin() {
	    homePage = new HomePageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    
	    WebElement signInButton = homePage.btnSignIn;
	    wait.until(ExpectedConditions.visibilityOfAllElements(signInButton));
	    signInButton.click();
	}

	//Homepage END
	
	//Lainnya Menu Page
	public void clickBtnHubungiKami() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement hubungiKamiButton = LainnyaMenuPage.btnHubungiKami;
	    wait.until(ExpectedConditions.visibilityOfAllElements(hubungiKamiButton));
	    hubungiKamiButton.click();
	}

	public void clickPertanyaanEnglish() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement pertanyaanEnglishButton = LainnyaMenuPage.btnPertanyaanEnglish;
	    wait.until(ExpectedConditions.visibilityOfAllElements(pertanyaanEnglishButton));
	    pertanyaanEnglishButton.click();
	}

	public void clickBtnPertanyaan() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement pertanyaanButton = LainnyaMenuPage.btnPertanyaan;
	    wait.until(ExpectedConditions.visibilityOfAllElements(pertanyaanButton));
	    pertanyaanButton.click();
	}

	public void clickBtnSyaratDanKetentuan() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement syaratDanKetentuanButton = LainnyaMenuPage.btnSyaratDanKetentuan;
	    wait.until(ExpectedConditions.visibilityOfAllElements(syaratDanKetentuanButton));
	    syaratDanKetentuanButton.click();
	}

	public void clickBtnLainnya() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement lainnyaButton = LainnyaMenuPage.btnLainnya;
	    wait.until(ExpectedConditions.visibilityOfAllElements(lainnyaButton));
	    lainnyaButton.click();
	}

	public void clickBtnTextPremium() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement textPremiumButton = LainnyaMenuPage.btnPremium;
	    wait.until(ExpectedConditions.visibilityOfAllElements(textPremiumButton));
	    textPremiumButton.click();
	}

	public void clickPaketButton() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement paketButton = LainnyaMenuPage.btnPaket;
	    wait.until(ExpectedConditions.visibilityOfAllElements(paketButton));
	    paketButton.click();
	}

	public void pengaturanLainnya() {
	    LainnyaMenuPage = new LainnyaMenuPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement pengaturanButton = LainnyaMenuPage.btnPengaturan;
	    wait.until(ExpectedConditions.visibilityOfAllElements(pengaturanButton));
	    pengaturanButton.click();
	}

	//Lainnya Menu Page END
	
	//VOD Page
	public void clickBtnScheduleCatchup() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement scheduleCatchupButton = vodPage.btnScheduleCatchup;
	    wait.until(ExpectedConditions.visibilityOfAllElements(scheduleCatchupButton));
	    scheduleCatchupButton.click();
	}

	public void clickBtnSchedule() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement scheduleButton = vodPage.btnSchedule;
	    wait.until(ExpectedConditions.visibilityOfAllElements(scheduleButton));
	    scheduleButton.click();
	}

	public void clickBtnDataSaver() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement dataSaverButton = vodPage.btnDataSaver;
	    wait.until(ExpectedConditions.visibilityOfAllElements(dataSaverButton));
	    dataSaverButton.click();
	}

	public void clickBtnChromeCast() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement chromeCastButton = vodPage.btnChromeCast;
	    wait.until(ExpectedConditions.visibilityOfAllElements(chromeCastButton));
	    chromeCastButton.click();
	}

	public void clickBtnPremiumLinearTransTV() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement premiumLinearTransTvButton = vodPage.btnPremiumLinearTransTv;
	    wait.until(ExpectedConditions.visibilityOfAllElements(premiumLinearTransTvButton));
	    premiumLinearTransTvButton.click();
	}

	public void clickBtnFreeLinearAntv() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement freeLinearAntvButton = vodPage.btnFreeLinearAntv;
	    wait.until(ExpectedConditions.visibilityOfAllElements(freeLinearAntvButton));
	    freeLinearAntvButton.click();
	}

	public void clickEps3VOD() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement movieEps3Button = vodPage.btnMoviePremiumOriginalEps3;
	    wait.until(ExpectedConditions.visibilityOfAllElements(movieEps3Button));
	    movieEps3Button.click();
	}

	public void clickEps1VOD() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement movieEps1Button = vodPage.btnMoviePremiumOriginalEps1;
	    wait.until(ExpectedConditions.visibilityOfAllElements(movieEps1Button));
	    movieEps1Button.click();
	}

	public void clickPremiumVOD() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement premiumVODButton = vodPage.btnMoviePremiumOriginal;
	    wait.until(ExpectedConditions.visibilityOfAllElements(premiumVODButton));
	    premiumVODButton.click();
	}

	public void clickWatchList() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement watchListButton = vodPage.btnWatchList;
	    wait.until(ExpectedConditions.visibilityOfAllElements(watchListButton));
	    watchListButton.click();
	}

	public void clickDownload() {
	    vodPage = new VODPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement downloadButton = vodPage.btnDownload;
	    wait.until(ExpectedConditions.visibilityOfAllElements(downloadButton));
	    downloadButton.click();
	}

	//VOD Page END
	
	//Login
	public void clickLoginWithEmail() {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement withEmailButton = loginPage.btnWithEmail;
	    wait.until(ExpectedConditions.visibilityOfAllElements(withEmailButton));
	    withEmailButton.click();
	}

	public void clickMasukButton() {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement masukButton = loginPage.btnMasuk;
	    wait.until(ExpectedConditions.visibilityOfAllElements(masukButton));
	    masukButton.click();
	}

	public void clickButtonContinue() {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement continueButton = loginPage.btnContinue;
	    wait.until(ExpectedConditions.visibilityOfAllElements(continueButton));
	    continueButton.click();
	}

	//Login END
	
	//Pengaturan
	public void signOut() {
	    pengaturanPage = new PengaturanPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement keluarButton = pengaturanPage.btnKeluar;
	    wait.until(ExpectedConditions.visibilityOfAllElements(keluarButton));
	    keluarButton.click();

	    WebElement acceptKeluarButton = pengaturanPage.btnAcceptKeluar;
	    wait.until(ExpectedConditions.visibilityOfAllElements(acceptKeluarButton));
	    acceptKeluarButton.click();
	}

	//Pengaturan END
	
	//Menu Footer
	public void clickMenuBeranda() {
	    menuFooter = new MenuFooterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement menuBeranda = menuFooter.imgMenuBeranda;
	    wait.until(ExpectedConditions.visibilityOfAllElements(menuBeranda));
	    menuBeranda.click();
	}

	public void clickLiveTv() {
	    menuFooter = new MenuFooterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement tvKu = menuFooter.imgTvKu;
	    wait.until(ExpectedConditions.visibilityOfAllElements(tvKu));
	    tvKu.click();
	}

	//Menu Footer END
	
	//Menu Header
	public void clickMenuVplusOriginal() {
	    menuHeader = new MenuHeaderPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement menuVplusOriginal = menuHeader.txtMenuHeaderVPlusOriginal;
	    wait.until(ExpectedConditions.visibilityOfAllElements(menuVplusOriginal));
	    menuVplusOriginal.click();
	}
	//Menu Header END

	
	//VPlus Ori Page
	public void clickMenuVplusOriginalSelengkapnya() {
	    vPlusOriPage = new VplusOriPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement menuVplusOriginalSelengkapnya = vPlusOriPage.imgMenuVplusOriginalSelengkapnya;
	    wait.until(ExpectedConditions.visibilityOfAllElements(menuVplusOriginalSelengkapnya));
	    menuVplusOriginalSelengkapnya.click();
	}

	public void clickFirstVOD() {
	    vPlusOriPage = new VplusOriPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement firstVOD = vPlusOriPage.imgFirstVOD;
	    wait.until(ExpectedConditions.visibilityOfAllElements(firstVOD));
	    firstVOD.click();
	}
	//VPlus Ori Page END

	
	//TV Ku
	public void clickSportStar() {
	    tvKuPage = new TvKuPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement channelSportStar = tvKuPage.btnChannelSportStar;
	    wait.until(ExpectedConditions.visibilityOfAllElements(channelSportStar));
	    channelSportStar.click();
	}

	public void clickCancelLogin() {
	    tvKuPage = new TvKuPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement cancelLogin = tvKuPage.btnCancelOnPopupLogin;
	    wait.until(ExpectedConditions.visibilityOfAllElements(cancelLogin));
	    cancelLogin.click();
	}

	public void clickMasuk() {
	    tvKuPage = new TvKuPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));

	    WebElement masukButton = tvKuPage.btnMasuk;
	    wait.until(ExpectedConditions.visibilityOfAllElements(masukButton));
	    masukButton.click();
	}
	//TV Ku END

	
}
