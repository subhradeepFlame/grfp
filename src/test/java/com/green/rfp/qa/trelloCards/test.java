package com.green.rfp.qa.trelloCards;

import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class test extends BaseClass {

	@Test
	public void DateTimeOfTheReportRequestAreNotAccurate() {
waitForPageLoaded();
System.out.println(driver.getCurrentUrl());
		con.setKeyValue("testKey", "t5");

	}
}