package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC006 extends BaseClass {


	@Test
	public void checkLoadingTime() {
		testStepsLog("Step " + (stepCount++), " Login as super admin");
		superAdminloginValid();
		testStepsLog("Step " + (stepCount++), " Click on report left menu");
		jsClick( driver.findElement(By.xpath("//span[contains(text(),'Support')]/..")));
		testStepsLog("Step " + (stepCount++), " Click on user menu under report ");
		jsClick( driver.findElement(By.xpath("//span[contains(text(),'Users')]/..")));
		testStepsLog("Step " + (stepCount++), " Click on USERS tab under report ");
		jsClick( driver.findElement(By.xpath("//md-tab-item[text()='users']")));
		testStepsLog("Step " + (stepCount++), " search user ");
		templateIndexPage.searchUserUnderAdministration("Shaishav");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on three dot of the user ");
		jsClick( driver.findElement(By.xpath("//button//md-icon[@ng-click='$mdOpenMenu($event)']")));
		testStepsLog("Step " + (stepCount++), " Click on edit ");
		jsClick( driver.findElement(By.xpath("//a[@aria-label='Edit']")));
		testStepsLog("Step " + (stepCount++), "Verify page loading time");
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Change Account']"))));
		
		testVerifyLog("Page loading time is under 60 seconds");
		
	}
}
