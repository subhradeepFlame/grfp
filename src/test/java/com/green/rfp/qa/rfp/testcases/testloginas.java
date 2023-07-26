package com.green.rfp.qa.rfp.testcases;

import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class testloginas extends BaseClass {
	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void deleteRFP() {
		superAdminloginValid();
		loginAsFor("Narola Infotech", "sdf N");

		closingSession();
	}
}
