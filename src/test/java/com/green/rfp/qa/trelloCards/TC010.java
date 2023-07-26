package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC010 extends BaseClass{

	@Test
	public void templateSlider() {
		
		testStepsLog("Step " + (stepCount++), " Login as super admin");
		superAdminloginValid();
		
		testStepsLog("Step " + (stepCount++), " Click on report left menu");
		jsClick( driver.findElement(By.xpath("//span[contains(text(),'Support')]/..")));
		testStepsLog("Step " + (stepCount++), " Click on user menu under report ");
		jsClick( driver.findElement(By.xpath("//span[contains(text(),'Templates')]/..")));
		
		testStepsLog("Step " + (stepCount++), " check first template name ");
		String firstTemplateName= driver.findElement(By.xpath("//div[@class='list-name']//a")).getText();
		
		testStepsLog("Step " + (stepCount++), " Click on the right arrow to scroll ");
		jsClick( driver.findElement(By.xpath("//i[@class='icon-chevron-right']")));
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on the right arrow 2nd time to scroll ");
		jsClick( driver.findElement(By.xpath("//i[@class='icon-chevron-right']")));
		pause(3);
		
		testStepsLog("Step " + (stepCount++), " Click on the left arrow to scroll ");
		jsClick( driver.findElement(By.xpath("//i[@class='icon-chevron-left']")));
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on the left arrow 2nd time to scroll ");
		jsClick( driver.findElement(By.xpath("//i[@class='icon-chevron-left']")));
		pause(3);
		
		testStepsLog("Step " + (stepCount++), " now check the first template name showing");
		String AfterScrollFirstTemplateName= driver.findElement(By.xpath("//div[@class='list-name']//a")).getText();
		
		testStepsLog("Step " + (stepCount++), "Verify after right scroll then left scroll first template name is same");
		Assert.assertEquals(firstTemplateName, AfterScrollFirstTemplateName);
		testVerifyLog("Template slider working correctly verified");

		
	}

}
