package id.visionplus.TestCase.Visitor.Homepage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import id.visionplus.Action.Assertion;
import id.visionplus.Action.Click;
import id.visionplus.MainFunction.BaseTest;

public class TC_SearchFilm extends BaseTest {
	
	@Test(dataProvider="getData")
	public void TC_SearchFilm(HashMap<String, String> input) throws InterruptedException {
		Click click = new Click();
		Assertion assertion = new Assertion();
		
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		
		Thread.sleep(3000);
		click.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		
		click.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		
		click.clickBtnSearch();
		
		Thread.sleep(3000);
		click.clickTextViewSearchCorrect(input.get("correct"));
		
		Thread.sleep(1000);
		assertion.assertTextPencarianCorrect();
		
		click.clickTextViewSearchFalse(input.get("false"));
		
		Thread.sleep(1000);
		assertion.assertTextPencarianFalse();
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/id/visionplus/TestData/Login/search.json");
		return new Object[][] {{data.get(0)}};
		
	}
}
