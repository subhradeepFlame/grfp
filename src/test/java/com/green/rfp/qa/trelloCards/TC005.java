package com.green.rfp.qa.trelloCards;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC005 extends BaseClass {
	
	
	
	@Test(priority=1)
	public void countEntriesOnAcceptedTaskList() {
		
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		scrollToElementTillTrue( driver.findElement(By.xpath("//div[contains(text(),'Accepted')]")));
		String perPgaeNo= driver.findElement(By.xpath("//div[contains(text(),'Accepted')]/../..//span/div")).getText();
		String totalEntriesText= driver.findElement(By.xpath("//div[contains(text(),'Accepted')]/../..//div/span[contains(text(),'Showing ') and contains(text(),'entries')]")).getText();
		System.out.println("Total entries is :" + totalEntriesText);
		System.out.println("per page no :" + perPgaeNo);
		String[] bits = totalEntriesText.split(" ");
		System.out.println("Total entries is 11111 :" +bits[5]);
		String totalEntries= bits[5];
		
		testStepsLog("Step " + (stepCount++), "Verify ACCEPTED TASK LIST section showing 5 elements");
		int a=((Integer.parseInt(perPgaeNo))< (Integer.parseInt(totalEntries))?(Integer.parseInt(perPgaeNo)):(Integer.parseInt(totalEntries)));
		{
			List<WebElement> myElements = driver.findElements(By.xpath("//div[contains(@ng-if,'vm.count.accepted')]//tbody//tr"));
			Assert.assertEquals(myElements.size(), a);
			testVerifyLog("Total 5 task is showing in ACCEPTED TASK LIST section");
		}
			
		
			
	}

}
