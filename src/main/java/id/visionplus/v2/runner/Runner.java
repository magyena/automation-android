package id.visionplus.v2.runner;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner 
{
	
	public static void main(String[] args) 
	{
		TestNG testNG = new TestNG();
	    XmlSuite suite = new XmlSuite();
	    XmlTest test = new XmlTest(suite);
	}

}
