package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MediaPlayerPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public MediaPlayerPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_title_textview") 
	 public static WebElement txt_tittle_media_playerpage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_rewind_button") 
	 public static WebElement btn_rewind_media_playerpage;
	
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_fastforward_button") 
	 public static WebElement btn_forward_media_playerpage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_currenttime")
	 public static WebElement txt_currenttime_media_playerpage;
	
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_duration")
	 public static WebElement txt_duration_media_playerpage;
		
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/remoteNextEpisode")
	 public static WebElement btn_next_episode_media_playerpage;
	
	 @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.zte.iptvclient.android.idmnc:id/remotePrevEpisode\"]")
	 public static WebElement btn_previous_episode_media_playerpage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_play_pause_button")
	 public static WebElement btn_pause_play_media_playerpage;
	 
	 @AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/media_player_volume_layout_container\"]/android.widget.ImageView")
	 public static WebElement btn_volume_media_playerpage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_player_reload_button")
	 public static WebElement btn_restart_media_playerpage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_language_and_subs_button")
	 public static WebElement btn_settings_mediaplayer;
	 
	 @AndroidFindBy(id="android:id/button1")
	 public static WebElement btn_ok_settings_mediaplayer;
	 
	 @AndroidFindBy(xpath="//android.widget.RadioButton[@text=\"Indonesian\"]")
	 public static WebElement radio_btn_indonesia_language_media_playerpage;
	
	 @AndroidFindBy(xpath="//android.widget.RadioButton[@text=\"Disabled\"]")
	 public static WebElement radio_btn_disable_lang_media_playerpage;
	
	 @AndroidFindBy(xpath="//android.widget.RadioButton[@text=\"English\"]")
	 public static WebElement radio_btn_english_language_media_playerpage;
	
	 @AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/exo_subtitles\"]/android.view.View")
	 public static WebElement layout_media_player;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/media_player_progress_text")
	 public static WebElement img_buffering_media_player;
	 
	 
	 
	 
	
	 
	
}
