package com.green.rfp.qa.base;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/ReportNew/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setReportName(getReportName());
		sparkReporter.config().setTimeStampFormat("HH:mm:ss");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setProtocol(Protocol.HTTPS);
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		return extent;

	}

	public static String getReportName() {
		return "AutomationReport";
	}
}
