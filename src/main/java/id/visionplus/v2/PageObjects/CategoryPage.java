package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class CategoryPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public CategoryPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	 @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripTitle\" and @text=\"Asian Action Movies\"]") 
	 public static WebElement txt_cluster_movies_categorypage;
	 
	 @AndroidFindBy(xpath="(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripRecyclerView\"])[1]/android.view.View[2]") 
	 public static WebElement slide_cluster_movies_categorypage;
	 
	 @AndroidFindBy(xpath="(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripRecyclerView\"])[1]/android.view.View[1]") 
	 public static WebElement action_category_categorypage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/subscriptionImage") 
	 public static WebElement img_subscription_categorypage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/backButton") 
	 public static WebElement btn_back_categorypage;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Best Korean Action']/following::android.view.View[1]") 
	 public static WebElement content_below_cluster_Best_Korean_Action;
	 
	
	 
	
	 
	 
	 
}
