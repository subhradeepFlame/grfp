package com.green.rfp.qa.trelloCards;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.streamlining.rating.testcases.Evaluator;

public class TC011 extends BaseClass {

	@Test
	public void evaluatorsSignupEmailCheck() {
		String rfpName = con.getEvaluatorRfpName("pending");
		String firstname = randomStringGenerate().toLowerCase();
		String lastname = randomStringGenerate().toLowerCase();
		String evaluatorEmail = firstname + lastname + "@mailinator.com";
		Evaluator eva = new Evaluator();
		testStepsLog("Step " + (stepCount++), " Login as Customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on evaluators tab");
		driver.findElement(By.xpath("//md-step-label-wrapper[@class='Evaluators']")).click();
		pause(3);
		testStepsLog("Step " + (stepCount++), "Add evaluator, select date and add section ");
		eva.addEvaluatorWithDateAndSection(evaluatorEmail, "Introduction");
		pause(90);
		testStepsLog("Step " + (stepCount++), "Logout customer admin");
		closingSession();
		logOut();
		testStepsLog("Step " + (stepCount), "redirect to the mailinator.com");
		driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?to=" + firstname + lastname);
		waitForPageLoaded();
		driver.navigate().refresh();
		pause(5);

		testStepsLog("Step " + (stepCount), "Click on greenrfp mail");
		PresenceOfElement(By.xpath("//td[contains(text(),'The Green RFP')]"));

		WebElement mail = driver.findElement(By.xpath("//td[contains(text(),'The Green RFP')]"));
		jsClick(mail);
		testStepsLog("Step " + (stepCount), " Click on login button inside the mail");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='html_msg_body']")));
		WebElement mailLoginButton = driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]"));
		jsClick(mailLoginButton);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount), "Get autofillup email fieild value");
		pause(2);
		testStepsLog("Step " + (stepCount),
				"Verify the the autofillup email field and the given evaluator email field is same ");
		Assert.assertEquals(evaluatorEmail,
				driver.findElement(By.xpath("//input[@ng-model='vm.form.email']")).getAttribute("value"));
		testVerifyLog("email auto generated verified");
	}
}
