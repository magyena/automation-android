package org.visionplus_android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.Desktop;
import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.asynchttpclient.Request;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.visionplus_android.TestUtils.ExtentReporterNG;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;
import org.visionplus_android.utils.AppiumUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver android;
	public AppiumDriverLocalService service;
	public static String timeStampDate = new SimpleDateFormat("yyyy.MM.dd-HH.mm").format(new Date());
	
	protected ExtentReports extent = new ExtentReports();
	protected ExtentTest test = extent.createTest("Automation Test");
	protected ExtentSparkReporter ExtentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Automation Report.html");

	@BeforeClass
	public void ConfigureAppium() throws InterruptedException, IOException {
		
		//mengambil data dari global properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/org/visionplus_android/resources/data.properties");
		prop.load(fis);		
		//properties cuma bisa String
		String ipAddress = prop.getProperty("ipAdress");
		String port = prop.getProperty("port");
		String path = prop.getProperty("pathAppium");
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port), path);
		
		ExtentSparkReporter.config().setReportName("Web Automation Result");
		ExtentSparkReporter.config().setDocumentTitle("Test Result");
		
		extent.attachReporter(ExtentSparkReporter);
		extent.setSystemInfo("Testing", "Fadhil");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/java/org/visionplus_android/Assets/chromedriver.exe");
		options.setApp(System.getProperty("user.dir") + "/src/test/java/org/visionplus_android/Assets/visionplus.apk");
		options.setCapability("autoGrantPermissions","true");
		options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		options.setCapability("waitForQuietness", false);
		options.setCapability("waitForQuiescence", false);
		options.setCapability("wdaEventloopIdleDelay", 7);
		options.setCapability("eventLoopIdleDelaySec", 4);
		options.setCapability("startIWDP", true);
			
		android = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		//android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	//function agar appium ipAddress dan port tidak hardcode
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port, String path) {
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("/usr/local/bin/node"))
						.withAppiumJS(
								new File(
										path))
						.withIPAddress(ipAddress).usingPort(port));
		
		return service;
	}
	
	//untuk mengambil data dari TestData json
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
		});
		
		return data;	
	}
	
	//membuat function screenshot
	public String getScreenshotPath(String testcaseName, AndroidDriver android) throws IOException {
		File source = android.getScreenshotAs(OutputType.FILE);
//		String destinationFile = System.getProperty("user.dir")+"/reports/Automation Report " + timeStampDate + "\\" + testcaseName + ".png";
		String destinationFile = System.getProperty("user.dir")+"/reports/"+ timeStampDate + "/Automation Report" + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	
	
	public static void linkSendFinishTotalTestCaseFailed(int totalTestCases,int totalTestCasesFailed) {
		// String webhookUrl = "https://discord.com/api/webhooks/1164099789248532521/pR8xIn9U8aCP_Cb4YM8xwlie2OZ8XWDzI0_mtAX-Bum97ZGud_Qh67lQkgJHugX1vgwD";
		String webhookUrl = "https://discord.com/api/webhooks/1161592534989033472/i9HteOw7kw7XE_HzJ_tnYGKgN2K4E-6iipoLPbmgaWQ7gJO6qXDrWd8Ksfv60todbUMg";
		String message = "Total Test Cases Run: " + totalTestCases;

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonMessage = "{\"content\": \"" + message + "\"}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonMessage.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response : " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
       
		String message2 = "Total Test Cases Failed: " + totalTestCasesFailed;

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonMessage = "{\"content\": \"" + message2 + "\"}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonMessage.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response : " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
       
		String message3 = "cc: <@1077483182942863470>";

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonMessage = "{\"content\": \"" + message3 + "\"}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonMessage.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response : " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=\"boundary123\"");
            connection.setDoOutput(true);

            //String path = System.getProperty("user.dir") + "/reports/" + timeStampDate + "/Automation Report"  + ".html";
            String filePath = "/Users/fadhilmg/eclipse-workspace/visionplus-android/automation-android/reports/2023.10.18-15.44/Automation Report.html";

            File file = new File(filePath);

            try (FileInputStream fis = new FileInputStream(file);
                 OutputStream os = connection.getOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("File HTML berhasil dikirim ke Discord.");
            } else {
                System.out.println("Gagal mengirim file HTML ke Discord. Response Code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void linkSendFailed(String path) {
		String webhookUrl = "https://discord.com/api/webhooks/1161592534989033472/i9HteOw7kw7XE_HzJ_tnYGKgN2K4E-6iipoLPbmgaWQ7gJO6qXDrWd8Ksfv60todbUMg";
		String message = "Your Script for: " + path;

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonMessage = "{\"content\": \"" + message + "\"}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonMessage.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@AfterClass
	public void tearDown() {
		extent.flush();
		android.quit();
		service.stop();
	}

}
