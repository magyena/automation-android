package org.visionplus_android.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
	public void genarateReport() throws IOException
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
        	System.out.println("done");
        }
    }
}

