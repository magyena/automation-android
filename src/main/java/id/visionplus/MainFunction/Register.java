package id.visionplus.MainFunction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;

import org.testng.annotations.Test;

import id.visionplus.Action.Click;
import id.visionplus.Action.Input;

public class Register extends BaseTest
{
	@Test(priority = 1, testName = "Test case register")	
	public void register() throws InterruptedException
	{
		try
		{
			Click click = new Click();
			Input input_action = new Input();
			
			Thread.sleep(3000);
			click.lewatiButton();
			test.pass("User berhasil Klik skip button");
			
			Thread.sleep(3000);
			click.clickBtnShowcaseTvConnect();
			test.pass("sukses lewati button showcase");
			
			click.clickBtnShowcaseOk();
			test.pass("sukses lewati button showcase");
			
			click.clickButtonSignin();
			
            Long currentTimestamp = Instant.now().getEpochSecond();
				
			String prefix = "0800"+currentTimestamp;
			 
			input_action.inputPhoneNumber(prefix);
			
			click.clickButtonContinue();
			
			input_action.inputPhonePassword("4321lupa");
			
			click.clickButtonContinue();
			
			Process p = Runtime.getRuntime().exec("./src/main/java/id/visionplus/Utils/connectSMSGatewayDB.sh"+" "+ prefix.substring(1));
			p.waitFor();
	
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
			String otp;
			while ((otp = reader.readLine()) != null) 
			{
			    System.out.println(otp);
			    char charOtp1 = otp.charAt(0);			  
					
				char charOtp2 = otp.charAt(1);
			
				char charOtp3 = otp.charAt(2);
									
				char charOtp4 = otp.charAt(3);
					
				input_action.inputOtp1(String.valueOf(charOtp1));
				input_action.inputOtp2(String.valueOf(charOtp2));
				input_action.inputOtp3(String.valueOf(charOtp3));
				input_action.inputOtp4(String.valueOf(charOtp4));
			}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

}
