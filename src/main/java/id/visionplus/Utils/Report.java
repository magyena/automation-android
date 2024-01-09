package id.visionplus.Utils;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Report 
{
	public void generateReport() throws IOException, InterruptedException
    {
		String name = System.getProperty("user.name");

		String webhookUrl = "https://discord.com/api/webhooks/1164099789248532521/pR8xIn9U8aCP_Cb4YM8xwlie2OZ8XWDzI0_mtAX-Bum97ZGud_Qh67lQkgJHugX1vgwD";
        String pdfFilePath = "/Users/"+name+"/Desktop/REPORT/REPORT_.PDF";
        
        try {
        	Thread.sleep(5000);
        	createPDF();
        	Thread.sleep(5000);
            sendPDF(webhookUrl, pdfFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	private static void createPDF() throws FileNotFoundException, IOException
	{
		String path = System.getProperty("user.dir");
		String name = System.getProperty("user.name");

        File htmlFile = new File(path+"/test-output/emailable-report.html");
        Document doc = Jsoup.parse(htmlFile,"UTF-8");
        doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        
        DateFormat df = new SimpleDateFormat();
        

        Date today = Calendar.getInstance()
                         .getTime();

        String dateToString = df.format(today);
        
        try (OutputStream os = new FileOutputStream("/Users/"+name+"/Desktop/REPORT/REPORT_.PDF")){
        	ITextRenderer renderer = new ITextRenderer();
        	SharedContext cntxt = renderer.getSharedContext();
        	cntxt.setPrint(true);
        	cntxt.setInteractive(false);
        	String baseUrl = FileSystems.getDefault().getPath("/Users/"+name+"/Desktop/REPORT/REPORT_.PDF")
        			         .toUri().toURL().toString();
        	renderer.setDocumentFromString(doc.html(), baseUrl);
        	renderer.layout();
        	renderer.createPDF(os);
        	System.out.println("File path: " + baseUrl);
        }
    }
	

    private static void sendPDF(String webhookUrl, String pdfFilePath) throws IOException {
        URL url = new URL(webhookUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=boundary");

        connection.setDoOutput(true);

        // Create a FileInputStream for the PDF file
        try (FileInputStream fileInputStream = new FileInputStream(pdfFilePath);
             DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {

            // Send the file as a part of the POST request
            outputStream.writeBytes("--boundary\r\n");
            outputStream.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + new File(pdfFilePath).getName() + "\"\r\n");
            outputStream.writeBytes("Content-Type: application/pdf\r\n\r\n");

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.writeBytes("\r\n--boundary--\r\n");

            // Get the response from the server
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + response.toString());
        } finally {
            // Close the connection
            connection.disconnect();
        }
    }
}

