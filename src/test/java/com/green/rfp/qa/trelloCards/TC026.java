package com.green.rfp.qa.trelloCards;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC026 extends BaseClass {

	@Test
	public void adminstrationWebPortal() throws ParseException {

		String rfpName = getCurrentTimeStampString();
		String answerType = "freeForm";
		String questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();

		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");

		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, "Introduction");

		testStepsLog("Step " + (stepCount++), "Select pricing = Don't Request Pricing");
		rfpIndexPage.selectRFPPricingType("NoPricing");
		pause(2);
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button");
		rfpIndexPage.clickOnContinueButton("Sections");
		stepCount++;

		waitForPageLoaded();
		pause(5);
		testStepsLog("Step " + (stepCount++), " Click on continue button on sme page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		waitForPageLoaded();

		String section1 = "Introduction";
		String q1 = section1 + " section question 1";

		createQuestion(answerType, questionWeight, section1, q1);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on continue button on review page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("gotoAprrovers");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on skip approval checkbox");
		pause(3);
		driver.findElement(By.xpath("//div[@class='layout-column']//md-checkbox[@aria-label='Skip Approvals']"))
				.click();
		pause(3);

		testStepsLog("Step " + (stepCount++), " Click on continue button on Approvers page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveApprovers");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");

		pause(3);
		scrollToElement(driver.findElement(By.xpath("//div[@style='padding:12px;']")));
		String SubmissionDueDate = driver
				.findElement(By.xpath("//strong[contains(text(),'Submission Due Date : ')]/..")).getText();
		String QuestionCutOffDate = driver
				.findElement(By.xpath("//strong[contains(text(),'Question Cut Off Date : ')]/..")).getText();
		String ReleaseDate = driver.findElement(By.xpath("//strong[contains(text(),'Release Date : ')]/..")).getText();

		String[] SubDueDate = SubmissionDueDate.split(": ");
		String[] QuesCutOffDate = QuestionCutOffDate.split(": ");
		String[] RelDate = ReleaseDate.split(": ");

		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat formatter1 = new SimpleDateFormat("MMM dd yyyy");
		System.out.println("aaaaaa: " + formatter1.format(formatter.parse(RelDate[1])));

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Last look tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");

		testStepsLog("Step " + (stepCount++), " Click on 'Publish' button ");
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'PUBLISH')]")));

		testStepsLog("Step " + (stepCount++), " Click on 'Publish' ");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveNote()']")));

		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on administration ");
		dashboardIndexPage.clickOnLeftMenu("Administration");
		pause(1);
		testStepsLog("Step " + (stepCount++), " Click on the webportal link ");
		jsClick(driver.findElement(By.xpath("//li[@class='ng-scope']//a")));
		testStepsLog("Step " + (stepCount++), " Click on the rfp name ");
		// search
		pause(3);
		driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")).sendKeys(rfpName);
		pause(3);
		jsClick(driver.findElement(By.xpath("//td//a[contains(text(),'" + rfpName + "')]")));

		String webQuestionsCutOffDate = driver
				.findElement(
						By.xpath("//strong[contains(text(),'Questions Cut Off Date')]/../..//td[@class='ng-binding']"))
				.getText();
		String webSubmissionDueDate = driver
				.findElement(By.xpath(
						"//strong[contains(text(),'RFP/BID Submission Due Date')]/../..//td[@class='ng-binding']"))
				.getText();
		String webReleaseDate = driver
				.findElement(
						By.xpath("//strong[contains(text(),'RFP/BID Release Date')]/../..//td[@class='ng-binding']"))
				.getText();
		String status = driver.findElement(By.xpath("//strong[contains(text(),'Status')]/../..//td//span")).getText();
		String rfpNameWebortal = driver
				.findElement(By.xpath("//strong[contains(text(),'RFP/BID Name')]/../..//td[@class='ng-binding']"))
				.getText();

		testStepsLog("Step " + (stepCount++), " Verify RFP/BID Release Date matches in webportal ");
		Assert.assertEquals(formatter1.format(formatter.parse(RelDate[1])).toString(), webReleaseDate);
		testVerifyLog("Veried RFP/BID Release Date matches in webportal");
		testStepsLog("Step " + (stepCount++), " Verify Questions Cut Off Date matches in webportal ");
		Assert.assertEquals(QuesCutOffDate[1], webQuestionsCutOffDate);
		testVerifyLog("Veried Questions Cut Off Date matches in webportal");
		testStepsLog("Step " + (stepCount++), " Verify RFP/BID Submission Due Date matches in webportal ");
		Assert.assertEquals(SubDueDate[1], webSubmissionDueDate);
		testVerifyLog("Veried RFP/BID Submission Due Date matches in webportal");
		testStepsLog("Step " + (stepCount++), " Verify status is showing open ");
		Assert.assertEquals(status, "Open");
		testVerifyLog("Veried status is showing open");
		testStepsLog("Step " + (stepCount++), " Verify rfp name matches ");
		Assert.assertEquals(rfpNameWebortal, rfpName);
		testVerifyLog("Veried rfp name matches");

		testStepsLog("Step " + (stepCount++), " Get current url ");
		String curUrl = driver.getCurrentUrl();
		testStepsLog("Step " + (stepCount++), " click on back to grfp button ");
		jsClick(driver.findElement(By.xpath("//button[text()='Back to GRFP']")));

		testStepsLog("Step " + (stepCount++), "Login as vendor 2 ");
		closingSession();
		loginAsFor("Vendor2");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "hit the copied ur");
		driver.get(curUrl);
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "click on 'Click here to respond to the RFP/Bid'");
		jsClick(driver.findElement(By.xpath("//div[@class='p-16']//a")));
		pause(3);
		testStepsLog("Step " + (stepCount++), "Switch to new tab");
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		pause(3);

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

		testStepsLog("Step " + (stepCount++), " Answer the questions");
		rfpIndexPage.answeraquestion(q1, section1);

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");

		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Click on continue button on pricing tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoCompanyAudit");
		testStepsLog("Step " + (stepCount++), " Click on continue button on review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorAprrovers");

		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();

		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorSendStep");

		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

	}

}
