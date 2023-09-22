package org.visionplus_android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
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
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		
		ExtentSparkReporter.config().setReportName("Web Automation Result");
		ExtentSparkReporter.config().setDocumentTitle("Test Result");
		
		extent.attachReporter(ExtentSparkReporter);
		extent.setSystemInfo("Testing", "Fadhil");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setChromedriverExecutable("/Users/fadhilmg/sellar/chromedriver/chromedriver.exe");
		options.setApp(System.getProperty("user.dir") + "/src/test/java/org/visionplus_android/Assets/visionplus.apk");
		options.setCapability("autoGrantPermissions","true");
		options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			
		android = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		Thread.sleep(3000);
	}
	
	//function agar appium ipAddress dan port tidak hardcode
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("/usr/local/bin/node"))
						.withAppiumJS(
								new File(
										"/usr/local/lib/node_modules/appium//build/lib/main.js"))
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
	
	@AfterClass
	public void tearDown() {
		extent.flush();
		android.quit();
		service.stop();
	}

}
