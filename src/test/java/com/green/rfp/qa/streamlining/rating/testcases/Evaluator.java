package com.green.rfp.qa.streamlining.rating.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.pages.RFPVerificationPage;
import com.green.rfp.qa.utility.TestUtil;

public class Evaluator extends BaseClass {
	TestUtil testutil = new TestUtil();
	public RFPVerificationPage rfpVerificationPage;

	@Test(priority = 1)
	public void verifyEvaluatorsTabColor() {
		String rfpName = "Evaluator rfp";
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(3);

		testStepsLog("Step " + (stepCount++), " verifys color status of Evaluators Tab");
		Assert.assertEquals("pending", getStepperTabStatus("Evaluators"));
		System.out.println("Evaluator status is : pending ");
	}

	/*
	 * add new evaluator then set password and add ratings
	 */

	@Test(priority = 2)
	public void addEvaluatorRating() {
		Evaluator eva = new Evaluator();
		String rfpName = "QA RFP 27";
		String firstname = randomStringGenerate();
		String lastname = randomStringGenerate();
		System.out.println("random firstname and last name is :" + firstname + " &" + lastname);
		String evaluatorEmail = firstname + lastname + "@mailinator.com";
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		loginValid(con.getconfigdData("Username"), con.getconfigdData("Password"));
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(2);
		testStepsLog("Step " + (stepCount++), " Click on evaluators tab");
		driver.findElement(By.xpath("//md-step-label-wrapper[@class='Evaluators']")).click();
		pause(2);
		testStepsLog("Step " + (stepCount++), "Add evaluator, select date and add section ");
		eva.addEvaluatorWithDateAndSection(evaluatorEmail);
		testStepsLog("Step " + (stepCount++), "Logout customer admin");
		logOut();
		testStepsLog("Step " + (stepCount++), "set password for the evaluator ");
		eva.setEvaluatorPassword(firstname, lastname, rfpName);
	}

	/*
	 * working on rfpcreate to evaluator add flow
	 */
	public void evaluatorFlow() {

		String rfpName = getCurrentTimeStampString();
		String answerType = "newQuestion";
		String questionWeight = "Medium";

		superAdminloginValid();
		loginAsFor("Customer RFP owner 1");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create button");

		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		// rfpVerificationPage = rfpIndexPage.selectRFPType(stepCount,"KIS");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		logger.info("Verifiyed RFP type is selected");

		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		logger.info("Rfp created");

		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");
		logger.info("Section created");

		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on sme page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		logger.info("Clicked on Continue");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickNewQuestion();
		logger.info("Clicked on New Question");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestion(answerType, "Introduction section question 1",
				questionWeight);
		logger.info("Added question");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Save Question");

		testStepsLog("Step " + (stepCount++), " Scroll till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtnObj();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickNewQuestion();
		logger.info("Clicked on New Question");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestion(answerType, "Introduction section question 2",
				questionWeight);
		logger.info("Added question");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Save Question");

		pause(3);
		WebElement objectiveTab = driver.findElement(By.xpath("//md-tab-item[text()='Objectives']"));
		scrollToElement(objectiveTab);
		objectiveTab.click();
		pause(2);

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickNewQuestion();
		logger.info("Clicked on New Question");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestion(answerType, "Objectives section question 1",
				questionWeight);
		logger.info("Question added");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on save");

		testStepsLog("Step " + (stepCount++), " Scroll till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtnObj();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickNewQuestion();
		logger.info("Clicked on New Question");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestion(answerType, "Objectives section question 2",
				questionWeight);
		logger.info("Added question");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Save Question");

		pause(3);
		WebElement pricingTab = driver.findElement(By.xpath("//md-tab-item[text()='Pricing']"));
		scrollToElement(pricingTab);
		pricingTab.click();
		pause(2);

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickNewQuestion();
		logger.info("Clicked on new questioned");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestion(answerType, "Pricing section question 1",
				questionWeight);
		logger.info("Question added");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on save");

		testStepsLog("Step " + (stepCount++), " Scroll till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtnObj();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickNewQuestion();
		logger.info("Clicked on new questioned");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestion(answerType, "Pricing section question 2",
				questionWeight);
		logger.info("Question added");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on save");

		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
		logger.info("Clicked on Continue");
		waitForPageLoaded();

		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Review page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("gotoAprrovers");
		logger.info("Clicked on Continue");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on skip approval checkbox");
		pause(3);
		driver.findElement(By.xpath("//div[@class='layout-column']//md-checkbox[@aria-label='Skip Approvals']"))
				.click();
		pause(3);

		testStepsLog("Step " + (stepCount++), " Click on continue button on Approvers page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveApprovers");
		logger.info("Clicked on Continue");
		waitForPageLoaded();

	}

	/*
	 * This method return the status of the given tabname depending on its colour
	 * completed= green pending = orange disabled= default
	 */
	public String getStepperTabStatus(String tabNmae) {
		WebElement tab = driver.findElement(By.xpath("//md-step-label-wrapper[@class='" + tabNmae + "']"));
		String colorRGB = ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", tab)
				.toString();
		String status = "disabled";
		if (colorRGB.equals("rgb(25, 165, 30)"))
			status = "completed";
		else if (colorRGB.equals("rgb(255, 165, 0)"))
			status = "pending";
		return status;
	}

	public void addEvaluatorWithDateAndSection(String email) {
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(findNextDay(currentDate));

		WebElement emailfield = driver.findElement(By.xpath("//tbody//input[@type='search']"));
		WebElement selectDate = driver
				.findElement(By.xpath("//tr[position()=last()]//button[@aria-label='Open calendar']"));
		WebElement selectSection = driver
				.findElement(By.xpath("//tr[position()=last()]//md-select[@aria-label='Section']"));
		WebElement introductionSection = driver
				.findElement(By.xpath("(//md-option[contains(@value,'Introduction')]//div)[13]"));
		WebElement saveButton = driver.findElement(By.xpath("(//button[contains(@ng-click,'saveSelfEvaluators')])[1]"));

		testStepsLog("Step " + (stepCount), ".1. scroll to email field ");
		scrollToElement(emailfield);
		testStepsLog("Step " + (stepCount), ".2. Enter evaluator email ");
		emailfield.sendKeys(email);
		saveButton.click();
		testStepsLog("Step " + (stepCount), ".3. select date ");
		selectDate.click();
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
		pause(1);
		testStepsLog("Step " + (stepCount), ".4. select section: introduction ");
		jsClick(selectSection);
		jsClick(introductionSection);
		testStepsLog("Step " + (stepCount), ".5. click on save button ");
		jsClick(saveButton);
	}

	public void addEvaluatorWithDateAndSection(String email, String Section) {
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(findNextDay(currentDate));

		WebElement emailfield = driver.findElement(By.xpath("//tbody//input[@type='search']"));
		WebElement selectDate = driver
				.findElement(By.xpath("//tr[position()=last()]//button[@aria-label='Open calendar']"));
		WebElement selectSection = driver
				.findElement(By.xpath("//tr[position()=last()]//md-select[@aria-label='Section']"));
		WebElement saveButton = driver.findElement(By.xpath("(//button[contains(@ng-click,'saveSelfEvaluators')])[1]"));

		testStepsLog("Step " + (stepCount), ".1. scroll to email field ");
		scrollToElement(emailfield);
		testStepsLog("Step " + (stepCount), ".2. Enter evaluator email ");
		emailfield.sendKeys(email);
		try {
			saveButton.click();
		} catch (Exception e) {
			jsClick(driver.findElement(By.xpath("//li[contains(@ng-click,'$mdAutocompleteCtrl.select($index)')]")));
			saveButton.click();
		}
		pause(3);
		testStepsLog("Step " + (stepCount), ".3. select date ");
		clickableElement(selectDate);
		selectDate.click();
		System.out.println("sme date:" + smeDate);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
		pause(1);
		testStepsLog("Step " + (stepCount), ".4. select section ");
		jsClick(selectSection);
		pause(1);
		WebElement introductionSection = driver.findElement(By.xpath(
				"//div[@class='md-scroll-mask']/following-sibling::div[@class='md-select-menu-container md-default-theme md-active md-clickable']//div[contains(text(),'"
						+ Section + "')]/.."));
		jsClick(introductionSection);
		testStepsLog("Step " + (stepCount), ".5. click on save button ");
		jsClick(saveButton);
	}

	/*
	 * This method helps to generate next date of given date
	 */
	private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

	private static Date findNextDay(Date date) {
		return new Date(date.getTime() + MILLIS_IN_A_DAY);
	}

	/*
	 * set evaluator password and login as evaluator to give rating
	 */
	public void setEvaluatorPassword(String firtname, String lastname, String rfpName) {
		testStepsLog("Step " + (stepCount), ".1. redirect to the mailinator.com");
		driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?to=qarfpevaluator1");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount), ".2. Click on greenrfp mail");
		WebElement mail = driver.findElement(By.xpath("//td[contains(text(),'The Green RFP')]"));
		jsClick(mail);

		testStepsLog("Step " + (stepCount), ".3. Click on login button inside the mail");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='html_msg_body']")));
		WebElement mailLoginButton = driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]"));
		jsClick(mailLoginButton);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount), ".4. enter firstname and lastname");
		WebElement firstnamefield = driver.findElement(By.xpath("//input[contains(@ng-model,'first_name')]"));
		WebElement lastnamefield = driver.findElement(By.xpath("//input[contains(@ng-model,'last_name')]"));
		firstnamefield.sendKeys(firtname);
		lastnamefield.sendKeys(lastname);
		pause(5);
		WebElement tcCheckbox = driver.findElement(By.xpath("//div[@class='md-icon']"));
		WebElement createMyAccountButton = driver
				.findElement(By.xpath("//button[contains(text(),'CREATE MY ACCOUNT')]"));
		testStepsLog("Step " + (stepCount), ".5. click on the checkbox");
		jsClick(tcCheckbox);
		testStepsLog("Step " + (stepCount), ".6. Click on Create my account button");
		jsClick(createMyAccountButton);
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount), ".7. set password for the account");
		waitforElementClickable(driver.findElement(By.xpath("//input[@ng-model='vm.form.password']")));
		pause(3);
		rfpVerificationPage = rfpIndexPage.setPassword();
		pause(3);
		testStepsLog("Step " + (stepCount), ".8. Enter title and phone number then login to the account");
		WebElement titlefield = driver.findElement(By.xpath("//input[contains(@ng-model,'title')]"));
		titlefield.sendKeys("MR.");
		rfpVerificationPage = rfpIndexPage.enterPhone("1234517538");
		waitForPageLoaded();

	}

	public void deleteEvaluator(String evaluatorEmail) {
		WebElement deleteIcon = driver.findElement(By.xpath("//span[contains(text(),'" + evaluatorEmail
				+ "')]/../../../following-sibling::td//md-icon[@md-font-icon='icon-trash']"));
		scrollToElement(deleteIcon);
		clickableElement(deleteIcon);
		deleteIcon.click();
		pause(3);
		jsClick(driver.findElement(By.xpath("//button[text()='Yes']")));

	}
}
