package id.visionplus.v1.TestCase.Visitor.Lainnya;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Assertion;
import id.visionplus.v1.Action.Click;
import id.visionplus.v1.MainFunction.*;
import id.visionplus.v1.TestCase.General.*;

public class TC_Visitor_Cannot_Access_Ebooks extends BaseTest{

	Click click = new Click();
	@Test
	public void TC_Visitor_Cannot_Access_EBooks() throws InterruptedException {
		Assertion assertion = new Assertion();
		TC_Access_EBooks access_eBooks = new TC_Access_EBooks();
		//call test case accessing to Ebooks Page
		access_eBooks.TC_EBooks();
		Thread.sleep(3000);
		assertion.assertLoginPage();
		
		click.clickBtnCloseLogin();
	}
}
