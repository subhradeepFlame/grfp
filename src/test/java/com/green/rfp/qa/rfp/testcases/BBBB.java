package com.green.rfp.qa.rfp.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BBBB {
	static WebDriver driver;

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
	{
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		String destination = System.getProperty("user.dir") + "\\Report\\Images" + screenshotName + dateName + ".png";
		System.out.println("path"+destination);
		File finalDestination = new File(destination);
		return destination;
	}
	
	@Test
	public void demmm() throws IOException
	{
		System.out.println("kjcdjcjd");
		getScreenshot(driver, "screenshotName");
	}
	
}
