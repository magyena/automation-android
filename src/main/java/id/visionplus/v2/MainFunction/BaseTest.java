package id.visionplus.v2.MainFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public static AndroidDriver android;
	public AppiumDriverLocalService service;
	public static String timeStampDate = new SimpleDateFormat("yyyy.MM.dd-HH.mm").format(new Date());
	
	protected ExtentReports extent = new ExtentReports();
	protected ExtentTest test = extent.createTest("Automation Test");
	protected ExtentSparkReporter ExtentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Automation Report.html");
	String webhookUrl = "https://discord.com/api/webhooks/1164099789248532521/pR8xIn9U8aCP_Cb4YM8xwlie2OZ8XWDzI0_mtAX-Bum97ZGud_Qh67lQkgJHugX1vgwD";
	//String webhookUrl = "https://discord.com/api/webhooks/1161592534989033472/i9HteOw7kw7XE_HzJ_tnYGKgN2K4E-6iipoLPbmgaWQ7gJO6qXDrWd8Ksfv60todbUMg";

	@BeforeClass
	public void ConfigureAppium() throws InterruptedException, IOException {
		
		//mengambil data dari global properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/id/visionplus/v2/Resources/data.properties");
		prop.load(fis);		
		//properties cuma bisa String
		String ipAddress = prop.getProperty("ipAdress");
		String port = prop.getProperty("port");
		String path = prop.getProperty("pathAppium");
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port), path);
		
		ExtentSparkReporter.config().setReportName("Web Automation Result");
		ExtentSparkReporter.config().setDocumentTitle("Test Result");
		
		extent.attachReporter(ExtentSparkReporter);
		extent.setSystemInfo("Testing", "Michael");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/main/java/id/visionplus/v2/Assets/chromedriver.exe");
		options.setApp(System.getProperty("user.dir") + "/src/main/java/id/visionplus/v2/Assets/mirada.apk");
		options.setCapability("autoGrantPermissions","true");
		options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		options.setCapability("waitForQuietness", false);
		options.setCapability("waitForQuiescence", false);
		options.setCapability("wdaEventloopIdleDelay", 7);
		options.setCapability("eventLoopIdleDelaySec", 4);
		options.setCapability("startIWDP", true);
		options.setCapability("newCommandTimeout", 600);
		
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
	//	String destinationFile = System.getProperty("user.dir")+"/reports/Automation Report " + timeStampDate + "\\" + testcaseName + ".png";
		String destinationFile = System.getProperty("user.dir")+"/reports/"+ timeStampDate + "/Automation Report" + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	public static void sendMessageToWebhook(String webhookUrl, String contentType, String message) {
	    try {
	        URL url = new URL(webhookUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Content-Type", contentType);
	        connection.setDoOutput(true);

	        // Escape double quotes in the message to prevent JSON parsing issues
	        message = message.replace("\"", "\\\"");

	        // Construct the JSON message with newline characters
	        String jsonMessage = "{\"content\": \"" + message.replace("\n", "\\n") + "\"}";

	        try (OutputStream os = connection.getOutputStream()) {
	            byte[] input = jsonMessage.getBytes("utf-8");
	            os.write(input, 0, input.length);
	        }

	        int responseCode = connection.getResponseCode();
	        System.out.println("Response Code: " + responseCode);
	        
	        String responseMessage = connection.getResponseMessage();
	        System.out.println("Response Message: " + responseMessage);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void sendTestSuitesName(String testSuiteName) {
	    System.out.println(testSuiteName);
	    String message = "==================================================================\n" +
	                     "**Test Suite Name:** **" + testSuiteName + "**\n \n";
	    System.out.println(message);
	    sendMessageToWebhook(webhookUrl, "application/json", message);
	}
	
	public void sendCustomMessage(String text){
		System.out.println(text);
		String message = "**"+text+"**\n";
	    System.out.println(message);
	    sendMessageToWebhook(webhookUrl, "application/json", message);
	}

	public void sendSummaryTestCases(int totalTestCases, int totalTestCasesPassed, int totalTestCasesFailed, int totalTestCasesSkipped) {
	    String message = "**Test Suites Summary:**\n" +
	    				"Total: " + totalTestCases + ", \n" +
	    				"Passed: " + totalTestCasesPassed + ", \n" +
	    				"Failed: " + totalTestCasesFailed + ", \n" +
	    				"Skipped: " + totalTestCasesSkipped + "\n\n";
	    
	    System.out.println(message);
	    
	    sendMessageToWebhook(webhookUrl, "application/json", message);
	}
	
	public void sendListFailedTestCases(String failedTestCasesList) {
	    String message = "**List Of Failed Test Cases** \n" + failedTestCasesList;
	    sendMessageToWebhook(webhookUrl, "application/json", message);
	}
	
	public void sendListSkippedTestCases(String skippedTestCasesList) {
	    String message = "**List Of Skipped Test Cases** \n" + skippedTestCasesList;
	    sendMessageToWebhook(webhookUrl, "application/json", message);
	}

	public void sendCcMessage() {
	    String message = "cc: <@1161584629011197972> <@1077483182942863470>";
	    sendMessageToWebhook(webhookUrl, "application/json", message);
	}
	
	public void sendTestCasesFailed(String path) {
		String message = path;
		sendMessageToWebhook(webhookUrl, "application/json", message);
	}
}

