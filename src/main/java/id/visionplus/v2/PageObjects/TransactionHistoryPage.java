package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TransactionHistoryPage extends AndroidGesture {
	AndroidDriver android;
	WebDriverWait wait;

	public TransactionHistoryPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(id = "//android.widget.TextView[@text=\"Transaction History\"]")
	public static WebElement txt_transaction_history;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"All Status\"]")
	public static WebElement btn_all_status;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Success\"]")
	public static WebElement btn_all_success;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Failed\"]")
	public static WebElement btn_all_failed;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Pending\"]")
	public static WebElement btn_all_pending;

	@AndroidFindBy(xpath="(//android.widget.Button[@text=\"Premium 30 Days 08 Januari 2024 | 21:24 Total Payment Rp 20.000 Payment Status FAILED\"])[1]")
	public static WebElement sample_all_transaction;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Premium + Sports 30 Days 23 November 2022 | 16:21 Total Payment Rp 35.000 Payment Status SUCCESS\"]")
	public static WebElement sample_success_transaction;
	
	@AndroidFindBy(xpath="(//android.widget.Button[@text=\"Premium + Sports 30 Days 09 Januari 2024 | 01:13 Total Payment Rp 35.000 Payment Status FAILED\"])[1]")
	public static WebElement sample_failed_transaction;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/close")
	public static WebElement btn_close;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Transaction Details\"]")
	public static WebElement txt_detail_transactions;
	
	@AndroidFindBy(xpath="//*[contains(@class, \"space-y-1\") and contains(@class, \"py-1.5\") and contains(@class, \"px-3\") and contains(@class, \"hover:bg-neutral-800\") and contains(@class, \"rounded-md\")]/i")
	public static WebElement btn_buy_again;

	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Payment\"]")
	public static WebElement txt_buyAgain_payment;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"EURO Vision+ Pack\"]")
	public static WebElement txt_euro_package;
	
	
	
}
