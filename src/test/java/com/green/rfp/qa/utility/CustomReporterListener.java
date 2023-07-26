package com.green.rfp.qa.utility;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import org.testng.*;

public class CustomReporterListener  implements IReporter 
{public static ConfigReader con = new ConfigReader();
 String env=con.getEnv();
	//@Override
	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) 
	{
		
	}
	
}
