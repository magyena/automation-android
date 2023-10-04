package org.visionplus_android.visitor.TC_Homepage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;

public class TC_SearchFilm extends BaseTest {
	
	@Test(dataProvider="getData")
	public void TC_SearchFilm(HashMap<String, String> input) throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		homepage.clickBtnSearch();
		homepage.clickTextViewSearchCorrect(input.get("correct"));
		homepage.assertTextPencarianCorrect();
		homepage.clickTextViewSearchFalse(input.get("false"));
		homepage.assertTextPencarianFalse();
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/visionplus_android/TestData/LoginTestdata/search.json");
		return new Object[][] {{data.get(0)}};
		
	}
}
