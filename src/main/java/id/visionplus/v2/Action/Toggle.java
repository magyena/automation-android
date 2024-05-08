package id.visionplus.v2.Action;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import id.visionplus.v2.MainFunction.BaseTest;

public class Toggle extends BaseTest {
	//String adbPath = "/Users/fatahalim/Library/Android/sdk/platform-tools/adb";

//	 String adbPath = "/users/visionplus/Library/Android/sdk/platform-tools/adb";
	 
	 String adbPath = "/users/michaelliong/Library/Android/sdk/platform-tools/adb";

	public void disable_data_connection() {

		try {
			Process process = Runtime.getRuntime().exec(adbPath + " shell svc data disable");
			process.waitFor();
			System.out.println("Mobile data disabled successfully.");
		} catch (Exception e) {
			System.out.println("Error disabling mobile data: " + e.getMessage());
		}
	}

	public void disable_wifi_connection() {

		try {
			Process process = Runtime.getRuntime().exec(adbPath + " shell svc wifi disable");
			process.waitFor();
			System.out.println("Wifi data disabled successfully.");
		} catch (Exception e) {
			System.out.println("Error disabling Wifi data: " + e.getMessage());
		}
	}

	public void enable_wifi_connection() {

		try {
			Process process = Runtime.getRuntime().exec(adbPath + " shell svc wifi enable");
			process.waitFor();
			System.out.println("Wifi data enable successfully.");
		} catch (Exception e) {
			System.out.println("Error enable Wifi data: " + e.getMessage());
		}
	}
}