package com.green.rfp.qa.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.base.ExtentManager;

public class TestListeners extends BaseClass implements ITestListener {
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	String directory = System.getProperty("user.dir") + "/ReportNew/Images";

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	private String getFileName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test method :: " + result.getMethod().getMethodName() + " : Passed";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String logText = "<b>Test method :: " + result.getMethod().getMethodName() + " : Failed";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);//
		extentTest.get().log(Status.FAIL, result.getThrowable()); //
		try {
			extentTest.get().log(Status.FAIL, "Snapshot below: " + extentTest.get().addScreenCaptureFromPath(
					directory + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test method :: " + result.getMethod().getMethodName() + " : Skipped";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null)
			extent.flush();

	}
}
