package com.green.rfp.qa.pages;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.green.rfp.qa.base.BaseClass;

public class RFPIndexPage extends BaseClass {

	public RFPIndexPage() {

		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@ng-model='vm.name']")
	WebElement name_field;
	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
	WebElement release_Date_Calender;
	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	WebElement que_cutOff_date;
	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[3]")
	WebElement submission_due_date;
	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[4]")
	WebElement ven_due_date;
	@FindBy(xpath = "//button[@aria-label='Duplicate']")
	WebElement duplicate_btn;
	@FindBy(xpath = "//button[@aria-label='Download']")
	WebElement download_btn;
	@FindBy(xpath = "//button[@aria-label='Send As Email']")
	WebElement sendasEmail_btn;
	@FindBy(xpath = "//button[@aria-label='Delete']")
	WebElement delete_btn;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yes_btn;
	@FindBy(name = "section_name")
	WebElement section_name_field;
	@FindBy(xpath = "//button[contains(@ng-click,'section_name')]")
	WebElement section_plus_btn;

	@FindBy(xpath = "//md-radio-button[@value=1]")
	WebElement rfpPricingOption1;
	@FindBy(xpath = "//md-radio-button[@value=2]")
	WebElement rfpPricingOption2;
	@FindBy(xpath = "//md-radio-button[@value=3]")
	WebElement rfpPricingOption3;
	@FindBy(xpath = "//md-radio-button[@value=4]")
	WebElement rfpPricingOption4;
	@FindBy(xpath = "//button[contains(text(),'Help my SME')]")
	WebElement help_my_sme_btn;
	@FindBy(className = "icon-window-close")
	WebElement remote_close_btn;
	@FindBy(xpath = "//md-option/div[text()='QA-Testing']")
	WebElement qa_testing_btn;
	@FindBy(xpath = "//md-select[@placeholder='Select User']")
	WebElement select_user_btn;
	@FindBy(xpath = "//md-option/div[text()='QaNarola Sme1']")
	WebElement qa_csme1_btn;
	@FindBy(xpath = "//md-option/div[text()='QaNarola Sme2']")
	WebElement qa_csme2_btn;
	@FindBy(xpath = "//button[text()[normalize-space()='Go']]")
	WebElement go_btn;
	@FindBy(xpath = "//md-step-label-wrapper[@class='Approvers']")
	WebElement approver_bubble;
	@FindBy(xpath = "//md-step-label-wrapper[@class='Summary']")
	WebElement summary_bubble;
	@FindBy(xpath = "//md-option/div[text()='QA RFPowner1']")
	WebElement qa_RFP_Owner1_btn;
	@FindBy(xpath = "//div[@id='suggestive_pop']/md-content[1]/md-list[1]/md-list-item[1]/div[1]/button[1]")
	WebElement qa_testing_btnn;
	@FindBy(xpath = "//input[@ng-model='vm.user_email']")
	WebElement txt_user_mailid;
	@FindBy(xpath = "//iframe[@id='html_msg_body']")
	WebElement mailinator_iframe;

	public RFPVerificationPage selectUser(String rfpOwner) {
		PresenceOfElement(By.xpath("//md-option/div[text()='" + rfpOwner + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + rfpOwner + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + rfpOwner + "']")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[text()='Create']")
	WebElement create_btn;

	public RFPVerificationPage clickOnCreateButton() {
		PresenceOfElement(By.xpath("//button[text()='Create']"));
		clickableElement(create_btn);
		jsClick(create_btn);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-radio-button[@value=0]")
	WebElement rfpCreationOption1;
	@FindBy(xpath = "//md-radio-button[@value=1]")
	WebElement rfpCreationOption2;
	@FindBy(xpath = "//md-radio-button[@value=2]")
	WebElement rfpCreationOption3;
	@FindBy(xpath = "//md-radio-button[@value=3]")
	WebElement rfpCreationOption4;

	public boolean selectRFPType(int stepCount, String type) {
		pause(5);
		Boolean isRFPTypeSelected = false;
		switch (type) {
		case "KIS":
			PresenceOfElement(
					By.xpath("//md-radio-button[@aria-label='Start From Scratch' and @aria-disabled='false']"));
			if (driver
					.findElement(
							By.xpath("//md-radio-button[@aria-label='Start From Scratch' and @aria-disabled='false']"))
					.isDisplayed()) {
				PresenceOfElement(By.xpath("//md-radio-button[@value=0]"));
				clickableElement(rfpCreationOption1);
				jsClick(rfpCreationOption1);
				isRFPTypeSelected = true;
			} else {
				isRFPTypeSelected = false;
			}
			break;

		case "CompanyTemplate":
			PresenceOfElement(
					By.xpath("//md-radio-button[@aria-label='Start From Scratch' and @aria-disabled='false']"));
			if (driver
					.findElement(
							By.xpath("//md-radio-button[@aria-label='Start From Scratch' and @aria-disabled='false']"))
					.isDisplayed()) {
				PresenceOfElement(By.xpath("//md-radio-button[@value=1]"));
				clickableElement(rfpCreationOption2);
				jsClick(rfpCreationOption2);
				isRFPTypeSelected = true;
			} else {
				isRFPTypeSelected = false;
			}
			break;

		case "GRFP":
			PresenceOfElement(By.xpath("//md-radio-button[@aria-label='GRFP templates:' and @aria-disabled='false']"));
			if (driver
					.findElement(
							By.xpath("//md-radio-button[@aria-label='GRFP templates:' and @aria-disabled='false']"))
					.isDisplayed()) {
				PresenceOfElement(By.xpath("//md-radio-button[@value=2]"));
				clickableElement(rfpCreationOption3);
				jsClick(rfpCreationOption3);
				isRFPTypeSelected = true;
			} else {
				isRFPTypeSelected = false;
			}
			break;

		case "Scratch":

			PresenceOfElement(
					By.xpath("//md-radio-button[@aria-label='Start From Scratch' and @aria-disabled='false']"));
			if (driver
					.findElement(
							By.xpath("//md-radio-button[@aria-label='Start From Scratch' and @aria-disabled='false']"))
					.isDisplayed()) {
				PresenceOfElement(By.xpath("//md-radio-button[@value=3]"));
				clickableElement(rfpCreationOption4);
				jsClick(rfpCreationOption4);
				isRFPTypeSelected = true;
			} else {
				isRFPTypeSelected = false;
			}
			break;

		}
		testStepsLog("Step " + (stepCount), " b-: Click on 'Continue' button");
		clickOnContinueButton("Rfp");
		return isRFPTypeSelected;
	}

	public RFPVerificationPage clickOnContinueButton(String sectionTab) {
		pause(3);
		switch (sectionTab) {
		case "Rfp":
			scrollToElementTillTrue(driver.findElement(
					By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]")));
			PresenceOfElement(
					By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]"));
			clickableElement(driver.findElement(
					By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]")));
			pause(1);
			jsClick(driver.findElement(
					By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]")));
			break;
		case "Sections":
			scrollToElementTillTrue(driver.findElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
			PresenceOfElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]"));
			clickableElement(driver.findElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
			pause(1);
			jsClick(driver.findElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
			break;
		case "SelfSme":
			scrollToElementTillTrue(driver.findElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
			PresenceOfElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]"));
			clickableElement(driver.findElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
			pause(1);
			jsClick(driver.findElement(
					By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
			break;
		}
		return new RFPVerificationPage();
	}

	public RFPVerificationPage fillRFPSummary(int stepCount, String typeOfRFP, String rfpName) {

		
		testStepsLog("Step " + (stepCount), " c-: Fill Basic Information");
		testStepsLog("", "RFP name=" + rfpName);
		testStepsLog("", "RFP description= Description of " + rfpName);
		testStepsLog("", "RFP BID Number= " + "123456");
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		System.out.println(dateFormat.format(currentDate));
		PresenceOfElement(By.xpath("//input[@ng-model='vm.name']"));
		driver.findElement(By.xpath("//input[@ng-model='vm.name']")).clear();
		globalMap.put("vendorRFPName", rfpName);
		enterRFAData(rfpName, "Description of " + rfpName, "123456", typeOfRFP);

		testStepsLog("Step " + (stepCount), " d-: Click on 'Continue' button");
		stepCount++;
		clickOnContinueButton("Rfp");

		return new RFPVerificationPage();
	}

	public RFPVerificationPage fillRFPSummaryWithCurrentDate(int stepCount, String typeOfRFP, String rfpName) {
		testStepsLog("Step " + (stepCount), " c-: Fill Basic Information");
		testStepsLog("", "RFP name=" + rfpName);
		testStepsLog("", "RFP description= Description of " + rfpName);
		testStepsLog("", "RFP BID Number= " + "123456");
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		System.out.println(dateFormat.format(currentDate));
		PresenceOfElement(By.xpath("//input[@ng-model='vm.name']"));
		driver.findElement(By.xpath("//input[@ng-model='vm.name']")).clear();
		globalMap.put("vendorRFPName", rfpName);
		enterRFADataWithCurrentDateSubmissionDate(rfpName, "Description of " + rfpName, "123456", typeOfRFP);
		testStepsLog("Step " + (stepCount), " d-: Click on 'Continue' button");
		stepCount++;
		clickOnContinueButton("Rfp");
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//iframe[@tabindex='0']")
	WebElement frame;
	@FindBy(xpath = "//input[@ng-model='vm.reference_number']")
	WebElement bid_field;
	@FindBy(xpath = "//*[@ng-model='vm.question_cut_off_time']//span")
	WebElement que_cutOff_time;
	@FindBy(xpath = "//*[@ng-model='vm.submission_due_time']//span")
	WebElement sub_due_time;

	/**
	 * @param rfaName
	 * @param description
	 * @param bidNumber
	 * @param typeOfRFP
	 * @return
	 */
	public RFPVerificationPage enterRFAData(String rfaName, String description, String bidNumber, String typeOfRFP) {
		enterDataIn(name_field, rfaName);
		driver.switchTo().frame(frame);
		pause(3);

		PresenceOfElement(By.xpath("//html/body[@contenteditable='true']"));
		pause(3);
		enterDataIn(driver.findElement(By.xpath("//html/body[@contenteditable='true']")), description);
		pause(2);
		driver.switchTo().defaultContent();
		pause(2);
		scrollToElement(bid_field);
		// bid_field.click();
		enterDataIn(bid_field, bidNumber);

		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String releaseDate = dateFormat.format(currentDate);
		System.out.println(releaseDate);
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DAY_OF_MONTH, 7);

		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		clickableElement(release_Date_Calender);
		jsClick(release_Date_Calender);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));

		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[2]"));
		clickableElement(que_cutOff_date);
		jsClick(que_cutOff_date);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));
		pause(2);
		clickableElement(sub_due_time);
		jsClick(sub_due_time);
		pause(2);
		jsClick(sub_due_time.findElement(By.xpath("//md-option//div[contains(text(),'11:45 PM')]")));
		pause(2);
		jsClick(bid_field);

		clickableElement(que_cutOff_time);
		jsClick(que_cutOff_time);
		pause(2);
		clickableElement(que_cutOff_time);
		jsClick(que_cutOff_time.findElement(By.xpath("//md-option//div[contains(text(),'11:45 PM')]")));
		pause(2);
		jsClick(bid_field);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterRFADataWithCurrentDateSubmissionDate(String rfaName, String description,
			String bidNumber, String typeOfRFP) {
		enterDataIn(name_field, rfaName);
		driver.switchTo().frame(frame);
		pause(3);
		PresenceOfElement(By.xpath("//html/body[@contenteditable='true']"));
		pause(3);
		enterDataIn(driver.findElement(By.xpath("//html/body[@contenteditable='true']")), description);
		pause(2);
		driver.switchTo().defaultContent();
		pause(2);
		scrollToElement(bid_field);
		// bid_field.click();
		enterDataIn(bid_field, bidNumber);
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String releaseDate = dateFormat.format(currentDate);
		System.out.println(releaseDate);
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DAY_OF_MONTH, 7);
		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		clickableElement(release_Date_Calender);
		jsClick(release_Date_Calender);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));
		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[2]"));
		clickableElement(que_cutOff_date);
		jsClick(que_cutOff_date);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));
		pause(2);
		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[3]"));
		clickableElement(submission_due_date);
		jsClick(submission_due_date);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));
		pause(2);
		clickableElement(que_cutOff_time);
		jsClick(que_cutOff_time);
		pause(2);
		clickableElement(que_cutOff_time);
		jsClick(que_cutOff_time.findElement(By.xpath("(//md-option//div[contains(text(),'11:30 PM')])[2]")));
		jsClick(bid_field);
		clickableElement(sub_due_time);
		jsClick(sub_due_time);
		pause(2);
		jsClick(sub_due_time.findElement(By.xpath("(//md-option//div[contains(text(),'11:45 PM')])[2]")));
		pause(2);
		jsClick(bid_field);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage createRFPSections(int stepCount, String rfpType, String rfpName, String pricing) {
		pause(5);
		PresenceOfElement(By.xpath("//div[contains(text(),'Define Your Content Sections')]"));
		try {
			pause(5);
			if (rfpType.equalsIgnoreCase("Scratch")) {
				PresenceOfElement(By.xpath("//div[contains(text(),'Define Your Content Sections')]"));
				testStepsLog("Step " + (stepCount), " a- :  Enter section name.");
				enterSectionName("Introduction");
				System.out.println("Introduction task is going to be add");

				testStepsLog("Step " + (stepCount), " b- :  Click on plus button.");
				clickOnPlusButtonInSections();

				testStepsLog("Step " + (stepCount), " c- : Enter section name.");
				enterSectionName("Objectives");
				System.out.println("Objectives task is going to be add");
				testStepsLog("Step " + (stepCount), " b- :  Click on plus button.");
				clickOnPlusButtonInSections();
			} else {
				System.out.println("No need to add section.");
			}

			switch (pricing) {
			case "DetailedPricing":
				testStepsLog("Step " + (stepCount),
						" e- : Select pricing = Detailed Pricing (CapEx, OpEx, Annual Maintenance)");
				selectRFPPricingType("DetailedPricing");
				System.out.println("DetailedPricing task is going to be add");
				break;
			case "TotalPricing":
				testStepsLog("Step " + (stepCount), " e- : Select pricing = Total Pricing");
				selectRFPPricingType("TotalPricing");
				break;
			case "NoPricing":
				testStepsLog("Step " + (stepCount), " e- : Select pricing = Don't Request Pricing");
				selectRFPPricingType("NoPricing");
				break;
			}
			testStepsLog("Step " + (stepCount), " f-: Click on 'Continue' button");
			clickOnContinueButton("Sections");
			stepCount++;

		} catch (Exception e) {
			System.out.println("RFP section is not created.");
		}
		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterSectionName(String sectionName) {
		PresenceOfElement(By.name("section_name"));
		enterDataIn(section_name_field, sectionName);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnPlusButtonInSections() {
		PresenceOfElement(By.xpath("//button[contains(@ng-click,'section_name')]"));
		clickableElement(section_plus_btn);
		jsClick(section_plus_btn);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectRFPPricingType(String type) {
		pause(5);
		switch (type) {
		case "DetailedPricing":
			PresenceOfElement(By.xpath("//md-radio-button[@value=1]"));
			clickableElement(rfpPricingOption1);
			jsClick(rfpPricingOption1);
			break;
		case "TotalPricing":
			PresenceOfElement(By.xpath("//md-radio-button[@value=2]"));
			clickableElement(rfpPricingOption2);
			jsClick(rfpPricingOption2);
			break;
		case "NoPricing":
			PresenceOfElement(By.xpath("//md-radio-button[@value=3]"));
			clickableElement(rfpPricingOption3);
			jsClick(rfpPricingOption3);
			break;
		case "Bidtable":
			PresenceOfElement(By.xpath("//md-radio-button[@value=4]"));
			clickableElement(rfpPricingOption4);
			jsClick(rfpPricingOption4);
			break;
		}
		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterSME(String sectionName, String smeName, String permission, int rowNumber,
			String date) {
		waitForPageLoaded();
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div[" + rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));
		pause(1);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div[" + rowNumber
				+ "]//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div[" + rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));

		jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));

		pause(2);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div[" + rowNumber
				+ "]//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div[" + rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));

		driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")).sendKeys(smeName);
		pause(3);
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(currentDate);
		switch (sectionName) {
		case "Introduction":

			PresenceOfElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]"));
			clickableElement(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));

			jsClick(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));

			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));

			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			pause(1);

			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));

			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			pause(1);

			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));

			jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));
			pause(3);
			if (rowNumber == 1) {
				PresenceOfElement(By.xpath("(//md-option[@value='" + permission + "'])[3]"));
				clickableElement(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[3]")));
				jsClick(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[3]")));
			} else {
				PresenceOfElement(By.xpath("(//md-option[@value='" + permission + "'])[4]"));
				clickableElement(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[4]")));
				jsClick(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[4]")));
			}
			System.out.println("1");
			break;
		case "Objectives":
			if (rowNumber == 1) {
				PresenceOfElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]"));
				clickableElement(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
				jsClick(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
			} else {
				pause(2);
				scrollToElementTillTrue(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
				pause(1);
				PresenceOfElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]"));
				clickableElement(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
				jsClick(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
			}

			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));

			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));

			pause(1);
			enterDataIn(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]/parent::tr//input[@aria-label='Enter date'])[" + rowNumber + "]")), date);
			pause(1);

			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));

			pause(1);

			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));
			jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));

			pause(2);

			if (rowNumber == 1) {
				PresenceOfElement(By.xpath("(//md-option[@value='" + permission + "'])[4]"));
				clickableElement(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[4]")));
				jsClick(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[4]")));
			}
			else {
				PresenceOfElement(By.xpath("(//md-option[@value='" + permission + "'])[5]"));
				clickableElement(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[5]")));
				jsClick(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[5]")));
			}
			System.out.println("1");
			break;

		case "New Section":
			PresenceOfElement(By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[2]"));
			clickableElement(
					driver.findElement(By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[2]")));
			jsClick(driver.findElement(By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[2]")));

			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			pause(1);

			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			pause(1);

			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));
			jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));

			pause(3);
			if (rowNumber == 1) {
				PresenceOfElement(By.xpath("(//md-option[@value='" + permission + "'])[4]"));
				clickableElement(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[4]")));
				jsClick(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[4]")));
			}
			else {
				PresenceOfElement(By.xpath("//md-option[@value='" + permission + "']"));
				clickableElement(driver.findElement(By.xpath("//md-option[@value='" + permission + "']")));
				jsClick(driver.findElement(By.xpath("//md-option[@value='" + permission + "']")));
			}
			System.out.println("1");
			break;
		case "Pricing":
			if (rowNumber == 1) {
				PresenceOfElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 2) + "]"));
				clickableElement(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 2) + "]")));
				jsClick(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 2) + "]")));
			}
			else {

				PresenceOfElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]"));
				clickableElement(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
				pause(2);
				scrollToElementTillTrue(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
				pause(1);
				PresenceOfElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]"));
				clickableElement(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
				jsClick(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
			}

			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));

			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			pause(1);
			enterDataIn(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]/parent::tr//input[@aria-label='Enter date'])[" + rowNumber + "]")), date);
			pause(1);

			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			pause(1);
			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));
			jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));

			pause(2);
			if (rowNumber == 1) {
				PresenceOfElement(By.xpath("(//md-option[@value='" + permission + "'])[5]"));
				clickableElement(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[5]")));
				jsClick(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[5]")));
			}
			else {
				PresenceOfElement(By.xpath("(//md-option[@value='" + permission + "'])[6]"));
				clickableElement(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[6]")));
				jsClick(driver.findElement(By.xpath("(//md-option[@value='" + permission + "'])[6]")));
			}
			System.out.println("1");
			break;
		}

		if (rowNumber != 2) {
			PresenceOfElement(By.xpath(
					"//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']"));
			clickableElement(driver.findElement(By.xpath(
					"//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']")));
			jsClick(driver.findElement(By.xpath(
					"//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']")));

		}
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnContinueButtonOnSMETab(String sectionTab) {
		PresenceOfElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]"));
		scrollToElementTillTrue(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		pause(1);
		PresenceOfElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]"));
		jsClick(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnDropdown(String nameOfDrodown) {
		PresenceOfElement(By.xpath("//md-select[@ng-model='" + nameOfDrodown + "']"));
		scrollToElement(driver.findElement(By.xpath("//md-select[@ng-model='" + nameOfDrodown + "']")));
		PresenceOfElement(By.xpath("//md-select[@ng-model='" + nameOfDrodown + "']"));
		clickableElement(driver.findElement(By.xpath("//md-select[@ng-model='" + nameOfDrodown + "']")));
		jsClick(driver.findElement(By.xpath("//md-select[@ng-model='" + nameOfDrodown + "']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnHelpMySmes() {
		PresenceOfElement(By.xpath("//button[contains(text(),'Help my SME')]"));
		clickableElement(help_my_sme_btn);
		jsClick(help_my_sme_btn);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnCloseRemoteButton() {
		pause(3);
		PresenceOfElement(By.className("icon-window-close"));
		clickableElement(remote_close_btn);
		jsClick(remote_close_btn);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnYesButton() {
		PresenceOfElement(By.xpath("//button[text()='Yes']"));
		clickableElement(yes_btn);
		jsClick(yes_btn);
		pause(5);

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//*[@placeholder='Log In As']")
	WebElement log_in_as_btn;

	public RFPVerificationPage clickOnLogInAsButton() {
		pause(5);
		waitforElementClickable(log_in_as_btn, con.getExplicitTime());
		PresenceOfElement(By.xpath("//*[@placeholder='Log In As']"));
		clickableElement(log_in_as_btn);
		clickOn(log_in_as_btn);
		pause(5);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//*[@placeholder='Search']")
	WebElement search;

	public RFPVerificationPage clickOnQATestingButton(String user) {
		pause(2);
		pause(2);
		type(search, user);
		pause(8);
		clickOn(qa_testing_btnn);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnSelectUserButton() {
		pause(5);
		PresenceOfElement(By.xpath("//md-select[@placeholder='Select User']"));
		clickableElement(select_user_btn);
		jsClick(select_user_btn);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectQACsme1(String smeUser) {
		PresenceOfElement(By.xpath("//md-option/div[text()='" + smeUser + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + smeUser + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + smeUser + "']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnGoButton() {
		PresenceOfElement(By.xpath("//button[text()[normalize-space()='Go']]"));
		clickableElement(go_btn);
		jsClick(go_btn);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnAcceptButton(String rfpName, String sectionName) {
		pause(10);
		String acceptButton = "//a[contains(text(),'#Description')]/ancestor::tr//a[contains(text(),'#rfpName')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']";
		acceptButton = acceptButton.replace("#rfpName", rfpName);
		acceptButton = acceptButton.replace("#Description", "SME for RFP " + rfpName + " " + "for" + " " + sectionName);
		scrollToElement(driver.findElement(By.xpath(acceptButton)));
		PresenceOfElement(By.xpath(acceptButton));
		clickableElement(driver.findElement(By.xpath(acceptButton)));
		jsClick(driver.findElement(By.xpath(acceptButton)));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterDueDate() {
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(currentDate);

		scrollToElement(driver.findElement(By.xpath("//button[@aria-label='Open calendar']")));
		PresenceOfElement(By.xpath("//button[@aria-label='Open calendar']"));
		clickableElement(driver.findElement(By.xpath("//button[@aria-label='Open calendar']")));
		jsClick(driver.findElement(By.xpath("//button[@aria-label='Open calendar']")));

		pause(2);
		PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
		clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnSendbtn() {
		pause(3);
		waitforElementClickable(driver.findElement(
				By.xpath("//button[contains(text(),'Send') and @ng-click='vm.saveVendorTask($event)']")), 30);

		PresenceOfElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.saveVendorTask($event)']"));
		clickableElement(driver
				.findElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.saveVendorTask($event)']")));

		jsClick(driver
				.findElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.saveVendorTask($event)']")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnSend() {
		pause(3);
		waitforElementClickable(driver.findElement(By.xpath("//button[contains(text(),'SEND')]")), 30);

		PresenceOfElement(By.xpath("//button[contains(text(),'SEND')]"));
		clickableElement(driver.findElement(By.xpath("//button[contains(text(),'SEND')]")));

		jsClick(driver.findElement(By.xpath("//button[contains(text(),'SEND')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnYesbtn() {
		pause(3);
		waitforElementClickable(
				driver.findElement(By.xpath("//button[contains(text(),'Yes') and @ng-click='dialog.hide()']")), 30);

		PresenceOfElement(By.xpath("//button[contains(text(),'Yes') and @ng-click='dialog.hide()']"));
		clickableElement(
				driver.findElement(By.xpath("//button[contains(text(),'Yes') and @ng-click='dialog.hide()']")));

		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Yes') and @ng-click='dialog.hide()']")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectRFP(String rfpName) {
		pause(3);
		PresenceOfElement(By.xpath("//a[contains(text(),'" + rfpName + "') and @aria-label='" + rfpName + "']"));
		clickableElement(driver
				.findElement(By.xpath("//a[contains(text(),'" + rfpName + "') and @aria-label='" + rfpName + "']")));
		jsClick(driver
				.findElement(By.xpath("//a[contains(text(),'" + rfpName + "') and @aria-label='" + rfpName + "']")));
		waitForPageLoaded();
		return new RFPVerificationPage();
	}

	public RFPVerificationPage rfpClickDashboardAccBtnForApprover(String rfpName) {
		pause(1);
		PresenceOfElement(By.xpath("//a[@title='Go to RFP'][contains(text(),'" + rfpName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']"));
		clickableElement(driver.findElement(By.xpath("//a[@title='Go to RFP'][contains(text(),'" + rfpName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']")));
		jsClick(driver.findElement(By.xpath("//a[@title='Go to RFP'][contains(text(),'" + rfpName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnApproverBubble() {
		scrollToElement(approver_bubble);
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Approvers']"));
		clickableElement(driver.findElement(By.xpath("//md-step-label-wrapper[@class='Approvers']")));
		jsClick(approver_bubble);
		pause(5);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-icon[@md-font-icon='icon-file-pdf-box']")
	WebElement pdfIcon;

	public RFPVerificationPage clickOnPDFIcon() {
		PresenceOfElement(By.xpath("//md-icon[@md-font-icon='icon-file-pdf-box']"));
		clickableElement(pdfIcon);
		jsClick(pdfIcon);
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage addRFPVendor(String vendorName) {
		pause(3);
		PresenceOfElement(By.xpath("//input[@name='vendor']"));
		jsClick(driver.findElement(By.xpath("//input[@name='vendor']")));
		driver.findElement(By.xpath("//input[@name='vendor']")).sendKeys(vendorName);
		pause(1);
		PresenceOfElement(
				By.xpath("//button[@ng-click='vm.addVendorRow(vm.vendor)']//md-icon[@aria-label='icon-plus']"));
		clickableElement(driver.findElement(
				By.xpath("//button[@ng-click='vm.addVendorRow(vm.vendor)']//md-icon[@aria-label='icon-plus']")));
		jsClick(driver.findElement(
				By.xpath("//button[@ng-click='vm.addVendorRow(vm.vendor)']//md-icon[@aria-label='icon-plus']")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickRFPVendorSendBtn(String sectionTab) {
		pause(3);
		PresenceOfElement(By.xpath("//button[contains(text(),'SEND') and contains(@ng-click,'" + sectionTab + "')]"));
		clickableElement(driver.findElement(
				By.xpath("//button[contains(text(),'SEND') and contains(@ng-click,'" + sectionTab + "')]")));
		jsClick(driver.findElement(
				By.xpath("//button[contains(text(),'SEND') and contains(@ng-click,'" + sectionTab + "')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[@aria-label='Resend Invitation']")
	WebElement resendBtn;

	public RFPVerificationPage clickResendBtn(String rownumber) {
		pause(3);
		PresenceOfElement(By.xpath("(//button[@aria-label='Resend Invitation'])[" + rownumber + "]"));
		clickableElement(
				driver.findElement(By.xpath("(//button[@aria-label='Resend Invitation'])[" + rownumber + "]")));

		jsClick(driver.findElement(By.xpath("(//button[@aria-label='Resend Invitation'])[" + rownumber + "]")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "(//md-icon[@md-font-icon='icon-trash' and @aria-label='icon-trash'])[5]")
	WebElement deleteBtn;

	public RFPVerificationPage clickDeleteBtn(String vendor) {
		pause(3);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + vendor
				+ "')]/../..//md-icon[@md-font-icon='icon-trash' and @aria-label='icon-trash']"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + vendor
				+ "')]/../..//md-icon[@md-font-icon='icon-trash' and @aria-label='icon-trash']")));

		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + vendor
				+ "')]/../..//md-icon[@md-font-icon='icon-trash' and @aria-label='icon-trash']")));
		return new RFPVerificationPage();
	}
	
	
	public void waitForDashboardToBeReady()
	{
		int totalDashboardWidget=driver.findElements(By.xpath("//ms-widget")).size();
		try {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ms-widget/ms-widget-front/div/span"), totalDashboardWidget));
		}
		catch(TimeoutException e) {
			driver.navigate().refresh();
			waitForPageLoaded();
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ms-widget/ms-widget-front/div/span"), totalDashboardWidget));
		}
	}
	public RFPVerificationPage searchRfpFromDashboardTaskList(String sectionName, String RFPname) {
		waitForDashboardToBeReady();
		PresenceOfElement(By.xpath("//div[contains(text(),'Completed RFP')]/../../../../..//div[@ng-if='vm.count.crfp > 0']"));
		jsClick(driver.findElement(By.xpath("//div[contains(text(),'"+sectionName+"')]/..//md-icon")));
		WebElement searchRfpBar = driver.findElement(By.xpath("//div[contains(text(),'"+sectionName+"')]/..//input"));
		jsClick(searchRfpBar);
		searchRfpBar.sendKeys(RFPname);
		PresenceOfElement(By.xpath("//div[contains(text(),'Completed RFP')]/../..//tr"));
		return new RFPVerificationPage();
	}
	
	public RFPVerificationPage selectVendorAcceptBtnFromDashboard(String rfpName, String sectionName) {
		pause(3);
		String acceptButton = "//tr[1]//a[contains(text(),'" + rfpName + "')]/ancestor::tr//a[contains(text(),'"
				+ rfpName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']//md-icon";
		PresenceOfElement(By.xpath(acceptButton));
		clickableElement(driver.findElement(By.xpath(acceptButton)));
		jsClick(driver.findElement(By.xpath(acceptButton)));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage AssigntoUser(String sectionnumber) {
		pause(2);
		PresenceOfElement(
				By.xpath("(//md-checkbox[contains(@aria-label,'Select All')]/div[contains(@class,'md-container')])["
						+ sectionnumber + "]"));
		scrollToElement(driver.findElement(
				By.xpath("(//md-checkbox[contains(@aria-label,'Select All')]/div[contains(@class,'md-container')])["
						+ sectionnumber + "]")));
		pause(1);
		waitforElementClickable(driver.findElement(
				By.xpath("(//md-checkbox[contains(@aria-label,'Select All')]/div[contains(@class,'md-container')])["
						+ sectionnumber + "]")),
				con.getExplicitTime());
		jsClick(driver.findElement(
				By.xpath("(//md-checkbox[contains(@aria-label,'Select All')]/div[contains(@class,'md-container')])["
						+ sectionnumber + "]")));
		pause(3);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[contains(text(),'Assign') and @aria-label='Assign']")
	WebElement assignbtn;

	public RFPVerificationPage clickOnAssignBtn() {
		pause(2);
		PresenceOfElement(By.xpath("//button[contains(text(),'Assign') and @aria-label='Assign']"));
		scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Assign') and @aria-label='Assign']")));
		pause(1);
		waitforElementClickable(
				driver.findElement(By.xpath("//button[contains(text(),'Assign') and @aria-label='Assign']")),
				con.getExplicitTime());
		jsClick(assignbtn);
		pause(3);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage addRFPVendorCSME1(String vendorCSME1Name) {
		pause(3);
		PresenceOfElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']"));
		clickableElement(
				driver.findElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']")));
		jsClick(driver.findElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']")));
		driver.findElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']"))
				.sendKeys(vendorCSME1Name);

		PresenceOfElement(By.xpath("//span[contains(text(),'" + vendorCSME1Name + "')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + vendorCSME1Name + "')]")));

		visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + vendorCSME1Name + "')]"));
		pause(3);
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + vendorCSME1Name + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectRFPCheckbox(String rfpName) {
		pause(3);
		PresenceOfElement(By.xpath("//a[contains(text(),'" + rfpName + "')]/../../../../..//md-checkbox"));
		clickableElement(
				driver.findElement(By.xpath("//a[contains(text(),'" + rfpName + "')]/../../../../..//md-checkbox")));
		jsClick(driver.findElement(By.xpath("//a[contains(text(),'" + rfpName + "')]/../../../../..//md-checkbox")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectActionsFromHeader(String action) {
		pause(3);
		switch (action) {
		case "Delete":
			PresenceOfElement(By.xpath("//button[@aria-label='Delete']"));
			clickableElement(delete_btn);
			jsClick(delete_btn);
			break;
		case "Duplicate":
			PresenceOfElement(By.xpath("//button[@aria-label='Duplicate']"));
			clickableElement(duplicate_btn);
			jsClick(duplicate_btn);
			break;
		case "Print":
			break;
		case "Download":
			PresenceOfElement(By.xpath("//button[@aria-label='Download']"));
			clickableElement(download_btn);
			jsClick(download_btn);
			break;
		case "SendAsEmail":
			PresenceOfElement(By.xpath("//button[@aria-label='Send As Email']"));
			clickableElement(sendasEmail_btn);
			jsClick(sendasEmail_btn);
			break;
		}
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage scrollToAssignedQuestions() {

		pause(5);
		PresenceOfElement(By.xpath("//div[contains(text(),'Assigned Questions for Introduction')]"));
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'Assigned Questions for Introduction')]")));
		pause(3);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage scrollToAssignedQuestionsFornewSection() {

		pause(5);
		PresenceOfElement(By.xpath("//div[contains(text(),'Assigned Questions for New Section')]"));
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'Assigned Questions for New Section')]")));
		pause(3);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage useCreatedTemplateKIS() {
		pause(5);
		String templateName = con.getKisTemplateName();
		clickableElement(driver.findElement(
				By.xpath("(//md-input-container//label[contains(text(),'Search')]//following-sibling::input)[1]")));
		jsClick(driver.findElement(
				By.xpath("(//md-input-container//label[contains(text(),'Search')]//following-sibling::input)[1]")));
		driver.findElement(
				By.xpath("(//md-input-container//label[contains(text(),'Search')]//following-sibling::input)[1]"))
				.sendKeys(templateName);
		waitForPageLoaded();
		PresenceOfElement(By.xpath("//a[contains(text(),'" + templateName + "')]"));
		clickableElement(driver.findElement(By.xpath("//a[contains(text(),'" + templateName + "')]")));
		jsClick(driver.findElement(By.xpath("//a[contains(text(),'" + templateName + "')]")));
		pause(5);
		clickOnYesButton();
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "(//button[contains(text(),'Create')])[7]")
	WebElement grfpTemplateCreate_btn;

	public RFPVerificationPage clickGRFPTemplateCreateButton() {
		PresenceOfElement(By.xpath("(//button[contains(text(),'Create')])[7]"));
		clickableElement(grfpTemplateCreate_btn);
		jsClick(grfpTemplateCreate_btn);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage useCreatedTemplate() {
		pause(5);
		String templateName = globalMap.get("created_templateName");

		visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + templateName + "')]"));
		waitforElementClickable(driver.findElement(By.xpath("//a[contains(text(),'" + templateName + "')]")), 30);
		jsClick(driver.findElement(By.xpath("//a[contains(text(),'" + templateName + "')]")));
		pause(5);
		clickOnYesButton();
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnPricingTab(String tabName) {
		String xpath = "//md-tab-item[contains(@ng-click,'mdTabsCtrl')]//span[contains(text(),'" + tabName + "')]";
		clickableElement(driver.findElement(By.xpath(xpath)));
		jsClick(driver.findElement(By.xpath(xpath)));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnClarificationbtn(String question) {
		pause(3);
		waitforElementClickable(
				driver.findElement(By.xpath(
						"//td//span[contains(text(),'" + question + "')]/..//button[@aria-label='Clarification']")),
				con.getExplicitTime());

		PresenceOfElement(
				By.xpath("//td//span[contains(text(),'" + question + "')]/..//button[@aria-label='Clarification']"));
		clickableElement(driver.findElement(
				By.xpath("//td//span[contains(text(),'" + question + "')]/..//button[@aria-label='Clarification']")));

		jsClick(driver.findElement(
				By.xpath("//td//span[contains(text(),'" + question + "')]/..//button[@aria-label='Clarification']")));
		pause(2);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//textarea[@required='required' and @name='qtba_answer']")
	WebElement clarificationTextarea;

	public String askForClarification() {
		String askClarification = randomStringGenerate();
		PresenceOfElement(By.xpath("//textarea[@required='required' and @name='qtba_answer']"));
		clarificationTextarea.sendKeys(askClarification);
		pause(2);
		return askClarification;
	}

	public RFPVerificationPage clickOnDownArrow(String vsme) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//md-content//tr[1]//div/span[contains(text(),'" + vsme
				+ "')]/../../../..//md-icon[@md-font-icon='icon-chevron-down']")));
		waitforElementClickable(driver.findElement(By.xpath("//md-content//tr[1]//div/span[contains(text(),'" + vsme
				+ "')]/../../../..//md-icon[@md-font-icon='icon-chevron-down']")), 30);

		PresenceOfElement(By.xpath("//md-content//tr[1]//div/span[contains(text(),'" + vsme
				+ "')]/../../../..//md-icon[@md-font-icon='icon-chevron-down']"));
		clickableElement(driver.findElement(By.xpath("//md-content//tr[1]//div/span[contains(text(),'" + vsme
				+ "')]/../../../..//md-icon[@md-font-icon='icon-chevron-down']")));

		jsClick(driver.findElement(By.xpath("//md-content//tr[1]//div/span[contains(text(),'" + vsme
				+ "')]/../../../..//md-icon[@md-font-icon='icon-chevron-down']")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage addRFPVendorCSME2(String vendorCSME2Name) {
		pause(3);

		PresenceOfElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']"));
		clickableElement(
				driver.findElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']")));

		jsClick(driver.findElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']")));
		driver.findElement(By.xpath("//label[contains(text(),'Assign users')]/../input[@type='search']"))
				.sendKeys(vendorCSME2Name);
		visibilityOfElementLocated(By.xpath("//span[contains(.,'" + vendorCSME2Name + "')]"));
		pause(3);
		PresenceOfElement(By.xpath("//span[contains(.,'" + vendorCSME2Name + "')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(.,'" + vendorCSME2Name + "')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(.,'" + vendorCSME2Name + "')]")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveAnswersFromVendor(String vsme, String Answer) {
		pause(3);
		PresenceOfElement(By.xpath("//md-content//td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../td[4]//button[contains(text(),'" + Answer + "')]"));
		pause(3);
		clickableElement(driver.findElement(By.xpath("//md-content//td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../td[4]//button[contains(text(),'" + Answer + "')]")));
		pause(3);
		jsClick(driver.findElement(By.xpath("//md-content//td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../td[4]//button[contains(text(),'" + Answer + "')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnRFPlink(String rfpName) {
		pause(3);
		PresenceOfElement(By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/a[contains(text(),'" + rfpName + "')]"));
		clickableElement(driver.findElement(
				By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/a[contains(text(),'" + rfpName + "')]")));

		jsClick(driver.findElement(
				By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/a[contains(text(),'" + rfpName + "')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage gotoIntroductionTab() {
		pause(3);
		PresenceOfElement(By.xpath("//md-tab-item[@tabindex='-1' and contains(text(),'Introduction')]"));
		clickableElement(
				driver.findElement(By.xpath("//md-tab-item[@tabindex='-1' and contains(text(),'Introduction')]")));
		jsClick(driver.findElement(By.xpath("//md-tab-item[@tabindex='-1' and contains(text(),'Introduction')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnReplyBtn(String clarification) {
		pause(3);

		PresenceOfElement(By.xpath("//tr[@ng-repeat='clarification in question.clarification']//div[contains(text(),'"
				+ clarification + "')]/../../td[5]/span/button[contains(text(),'Reply')]"));
		clickableElement(driver.findElement(
				By.xpath("//tr[@ng-repeat='clarification in question.clarification']//div[contains(text(),'"
						+ clarification + "')]/../../td[5]/span/button[contains(text(),'Reply')]")));

		jsClick(driver.findElement(
				By.xpath("//tr[@ng-repeat='clarification in question.clarification']//div[contains(text(),'"
						+ clarification + "')]/../../td[5]/span/button[contains(text(),'Reply')]")));
		pause(5);
		return new RFPVerificationPage();
	}


	public String giveClarification() {
		String giveClarification = randomStringGenerate();
		PresenceOfElement(By.xpath("//textarea[@required='required' and @name='qtba_answer']"));
		clarificationTextarea.sendKeys(giveClarification);
		pause(2);
		return giveClarification;
	}

	@FindBy(xpath = "//input[@name='company_name']")
	WebElement name;
	@FindBy(xpath = "//input[@name='company_title']")
	WebElement title;
	@FindBy(xpath = "//input[@name='company_phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@name='company_email']")
	WebElement email;
	@FindBy(xpath = "//html/body[@contenteditable='true']")
	WebElement description;

	public RFPVerificationPage enterCompanyDetails(String Name, String Title, String Phone, String Email,
			String CompanyDescription) {

		pause(2);
		name.clear();
		name.sendKeys(Name);
		title.clear();
		title.sendKeys(Title);
		phone.clear();
		phone.sendKeys(Phone);
		email.clear();
		email.sendKeys(Email);

		scrollToElement(frame);
		driver.switchTo().frame(frame);
		description.clear();
		description.sendKeys(CompanyDescription);

		driver.switchTo().defaultContent();

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnAnswer(String vsme) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'"+vsme+"')]/../../..//button[contains(text(),'Answer')]")));
		PresenceOfElement(By.xpath("//span[contains(text(),'"+vsme+"')]/../../..//button[contains(text(),'Answer')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'"+vsme+"')]/../../..//button[contains(text(),'Answer')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'"+vsme+"')]/../../..//button[contains(text(),'Answer')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//textarea[@required='required' and @ng-model='vm.qtba_answer']")
	WebElement answerTextarea;

	public RFPVerificationPage giveAnswer(String Answer) {
		pause(3);

		PresenceOfElement(By.xpath("//textarea[@required='required' and @ng-model='vm.qtba_answer']"));
		answerTextarea.sendKeys(Answer);

		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage acceptTaskFromDashboard(String rfpName, String rownumber) {
		pause(3);
		String acceptButton = "//tr//a[contains(text(),'" + rfpName + "')]/ancestor::tr//a[contains(text(),'" + rfpName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']";

		PresenceOfElement(By.xpath(acceptButton));
		clickableElement(driver.findElement(By.xpath(acceptButton)));
		jsClick(driver.findElement(By.xpath(acceptButton)));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//h2[contains(text(),'QUESTIONS')]")
	WebElement Question;

	public RFPVerificationPage scrollToQuestions() {
		pause(3);
		scrollToElement(Question);
		pause(3);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnTaskBubbletab(String taskNumber) {
		pause(3);

		PresenceOfElement(By.xpath("//md-tab-item[contains(text(),'" + taskNumber + "')]"));
		clickableElement(driver.findElement(By.xpath("//md-tab-item[contains(text(),'" + taskNumber + "')]")));
		jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'" + taskNumber + "')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.capex']")
	WebElement capEx;
	@FindBy(xpath = "//input[@ng-model='vm.opex']")
	WebElement opEx;
	@FindBy(xpath = "//input[@ng-model='vm.annual_maintainence']")
	WebElement annualMaintenance;

	public RFPVerificationPage enterPricingDetails(String CapEx, String OpEx, String AnnualMaintenance) {

		pause(3);
		capEx.clear();
		capEx.sendKeys(CapEx);
		opEx.clear();
		opEx.sendKeys(OpEx);
		annualMaintenance.clear();
		annualMaintenance.sendKeys(AnnualMaintenance);
		pause(2);

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']")
	WebElement approver1Search;

	public RFPVerificationPage addv1Approver(String type, String approverName) {
		pause(3);
		PresenceOfElement(By.xpath("//md-radio-button[@aria-label='" + type + "']"));
		clickableElement(driver.findElement(By.xpath("//md-radio-button[@aria-label='" + type + "']")));
		jsClick(driver.findElement(By.xpath("//md-radio-button[@aria-label='" + type + "']")));
		pause(3);
		PresenceOfElement(
				By.xpath("//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']"));
		clickableElement(driver.findElement(
				By.xpath("//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']")));
		jsClick(driver.findElement(
				By.xpath("//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']")));

		enterDataIn(approver1Search, approverName);

		PresenceOfElement(By.xpath("//span[contains(text(),'v1approver')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'v1approver')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'v1approver')]")));

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']")
	WebElement approver2Search;

	public RFPVerificationPage addv2Approver(String type, String approverName) {
		pause(3);
		PresenceOfElement(By.xpath("//md-radio-button[@aria-label='" + type + "']"));
		clickableElement(driver.findElement(By.xpath("//md-radio-button[@aria-label='" + type + "']")));
		jsClick(driver.findElement(By.xpath("//md-radio-button[@aria-label='" + type + "']")));
		pause(3);

		PresenceOfElement(
				By.xpath("//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']"));
		clickableElement(approver2Search);
		jsClick(driver.findElement(
				By.xpath("//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']")));
		enterDataIn(approver2Search, approverName);

		PresenceOfElement(By.xpath("//span[contains(text(),'v2approver')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'v2approver')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'v2approver')]")));

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-step-item[6]/md-step-label-wrapper[contains(text(),'Approvers')]")
	WebElement approversTab;

	public RFPVerificationPage gotoApproversBubbletab() {
		pause(5);
		PresenceOfElement(By.xpath("//md-step-item[6]/md-step-label-wrapper[contains(text(),'Approvers')]"));
		clickableElement(
				driver.findElement(By.xpath("//md-step-item[6]/md-step-label-wrapper[contains(text(),'Approvers')]")));
		jsClick(driver.findElement(By.xpath("//md-step-item[6]/md-step-label-wrapper[contains(text(),'Approvers')]")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-step-label-wrapper[@class='Send']")
	WebElement sendTab;

	public RFPVerificationPage gotoSendBubbletab() {
		pause(5);
		scrollToElement(sendTab);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Send']"));
		clickableElement(driver.findElement(By.xpath("//md-step-label-wrapper[@class='Send']")));
		jsClick(driver.findElement(By.xpath("//md-step-label-wrapper[@class='Send']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnSendResponseButton() {
		pause(3);
		scrollToElementTillTrue(driver.findElement(By.xpath("//button[contains(text(),'SEND RESPONSE')]")));
		pause(1);
		PresenceOfElement(By.xpath("//button[contains(text(),'SEND RESPONSE')]"));
		clickableElement(driver.findElement(By.xpath("//button[contains(text(),'SEND RESPONSE')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'SEND RESPONSE')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnEvaluatorsBubble() {
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Evaluators']"));
		clickableElement(driver.findElement(By.xpath("//md-step-label-wrapper[@class='Evaluators']")));
		jsClick(driver.findElement(By.xpath("//md-step-label-wrapper[@class='Evaluators']")));
		pause(5);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-step-label-wrapper[contains(text(),'Review')]")
	WebElement ReviewTab;

	public RFPVerificationPage gotoReviewBubbletab() {
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[contains(text(),'Review')]"));
		clickableElement(ReviewTab);
		jsClick(ReviewTab);
		pause(2);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage gotoRatingTab() {
		pause(5);
		PresenceOfElement(By.xpath("//md-tab-item[contains(text(),'Rating')]"));
		clickableElement(driver.findElement(By.xpath("//md-tab-item[contains(text(),'Rating')]")));
		jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'Rating')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage gotoRatingTab1() {
		pause(5);
		PresenceOfElement(By.xpath("(//md-tab-item[contains(text(),'Rating')])[2]"));
		jsClick(driver.findElement(By.xpath("(//md-tab-item[contains(text(),'Rating')])[2]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage gotoRatingTab2() {
		pause(5);
		PresenceOfElement(By.xpath("(//md-tab-item[contains(text(),'Rating')])[3]"));
		jsClick(driver.findElement(By.xpath("(//md-tab-item[contains(text(),'Rating')])[3]")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//textarea[@ng-model='vm.evaluation_note']")
	WebElement evaluationNote;
	@FindBy(xpath = "//button[@ng-click='vm.questionScoreChange(true)']")
	WebElement saveNote;

	public RFPVerificationPage addEvaluationNote() {
		pause(3);
		PresenceOfElement(By.xpath("//textarea[@ng-model='vm.evaluation_note']"));
		evaluationNote.clear();
		evaluationNote.sendKeys("evaluation Note");
		PresenceOfElement(By.xpath("//button[@ng-click='vm.questionScoreChange(true)']"));
		clickableElement(saveNote);
		jsClick(saveNote);
		pause(3);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatings(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')]"));
		clickableElement(driver.findElement(
				By.xpath("//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')]")));
		jsClick(driver.findElement(
				By.xpath("//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatings2(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[2]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[2]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[2]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatings3(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[3]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[3]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[3]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i"));
		clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i")));
		jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings2(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[2]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[2]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[2]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings3(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatingsForNewSection(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//span[text()='Reports']")
	WebElement reports_link;

	public RFPVerificationPage clickOnReportsLeftLink() {
		pause(5);
		PresenceOfElement(By.xpath("//span[text()='Reports']"));
		clickableElement(reports_link);
		jsClick(reports_link);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//span[text()='Administration']")
	WebElement administration_link;

	public RFPVerificationPage clickOnAdministartionLeftLink() {
		pause(5);
		PresenceOfElement(By.xpath("//span[text()='Administration']"));
		clickableElement(administration_link);
		jsClick(administration_link);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage switchSection(String sectionName) {

		pause(2);
		scrollToElement(driver.findElement(By.xpath("//md-tab-item[contains(text(),'" + sectionName + "')]")));
		PresenceOfElement(By.xpath("//md-tab-item[contains(text(),'" + sectionName + "')]"));
		clickableElement(driver.findElement(By.xpath("//md-tab-item[contains(text(),'" + sectionName + "')]")));

		jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'" + sectionName + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage switchSectionToVendor(String sectionName, String number) {

		pause(2);
		PresenceOfElement(By.xpath("(//md-tab-item[contains(text(),'" + sectionName + "')])[" + number + "]"));
		clickableElement(driver
				.findElement(By.xpath("(//md-tab-item[contains(text(),'" + sectionName + "')])[" + number + "]")));
		scrollToElement(driver
				.findElement(By.xpath("(//md-tab-item[contains(text(),'" + sectionName + "')])[" + number + "]")));
		jsClick(driver
				.findElement(By.xpath("(//md-tab-item[contains(text(),'" + sectionName + "')])[" + number + "]")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-tab-item[text()='USERS']")
	WebElement usersTab;

	public RFPVerificationPage clickOnUsersTab() {
		pause(5);
		scrollToElement(usersTab);
		PresenceOfElement(By.xpath("//md-tab-item[text()='USERS']"));
		clickableElement(usersTab);
		jsClick(usersTab);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[text()='Create']")
	WebElement createbtn;

	public RFPVerificationPage clickOnCreatebtn() {
		pause(5);
		PresenceOfElement(By.xpath("//button[text()='Create']"));
		clickableElement(createbtn);
		jsClick(createbtn);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.user_first_name']")
	WebElement firstname;
	@FindBy(xpath = "//input[@ng-model='vm.user_last_name']")
	WebElement lastname;
	@FindBy(xpath = "//input[@ng-model='vm.user_email']")
	WebElement userMailid;
	@FindBy(xpath = "//input[@ng-model='vm.user_title']")
	WebElement Title;
	@FindBy(xpath = "(//button[text()='Save'])[2]")
	WebElement saveBtn;

	public RFPVerificationPage enterUserdetails(String firstName, String lastName, String userMailId, String role,
			String title) {
		testStepsLog("", userMailId);

		pause(5);
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		scrollToElement(userMailid);
		userMailid.sendKeys(userMailId);

		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.user_role']"));
		clickableElement(driver.findElement(By.xpath("//md-select[@ng-model='vm.user_role']")));
		jsClick(driver.findElement(By.xpath("//md-select[@ng-model='vm.user_role']")));

		PresenceOfElement(By.xpath("//button[text()='Create']"));
		clickableElement(driver.findElement(By.xpath("(//md-option//div[text()='" + role + "'])")));
		jsClick(driver.findElement(By.xpath("(//md-option//div[text()='" + role + "'])")));

		jsClick(driver.findElement(By.xpath("//md-backdrop")));
		PresenceOfElement(By.xpath("//input[@ng-model='vm.user_title']"));
		Title.sendKeys(title);

		PresenceOfElement(By.xpath("//button[@ng-disabled='newuserform.$invalid']"));
		clickableElement(saveBtn);
		jsClick(saveBtn);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage LoginWithRFPlink(String link) {
		pause(3);
		driver.get(link);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnMail() {

		PresenceOfElement(
				By.xpath("//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'New Account Creation')]"));
		clickableElement(driver.findElement(
				By.xpath("//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'New Account Creation')]")));

		jsClick(driver.findElement(
				By.xpath("//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'New Account Creation')]")));
		return new RFPVerificationPage();
	}

	

	public RFPVerificationPage clickOnSetPasswordBtn() {
		pause(2);
		scrollToElement(mailinator_iframe);
		driver.switchTo().frame(mailinator_iframe);

		PresenceOfElement(By.xpath("//a[contains(text(),'SET PASSWORD')]"));
		clickableElement(driver.findElement(By.xpath("//a[contains(text(),'SET PASSWORD')]")));

		jsClick(driver.findElement(By.xpath("//a[contains(text(),'SET PASSWORD')]")));

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[contains(.,'Manual Bid')]")
	WebElement menualBidBtn;

	public RFPVerificationPage clickMenualBidBtn() {
		PresenceOfElement(By.xpath("//button[contains(.,'Manual Bid')]"));
		clickableElement(menualBidBtn);
		jsClick(menualBidBtn);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_company_name']")
	WebElement compName;

	public RFPVerificationPage enterCompanyname(String compname) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_company_name']"));
		clickableElement(compName);
		compName.sendKeys(compname);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_no_of_employees']")
	WebElement noOfEmp;

	public RFPVerificationPage enterNumberOfEmp(String nos) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_company_name']"));
		clickableElement(compName);
		noOfEmp.sendKeys(nos);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_website']")
	WebElement webAdd;

	public RFPVerificationPage enterWebAddress(String web) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_website']"));
		clickableElement(webAdd);
		webAdd.sendKeys(web);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_street_address']")
	WebElement streetAdd;

	public RFPVerificationPage enterStreetAdd(String stretAdd) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_street_address']"));
		clickableElement(streetAdd);
		streetAdd.sendKeys(stretAdd);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_city']")
	WebElement city;

	public RFPVerificationPage entercity(String cityName) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_city']"));
		clickableElement(city);
		city.sendKeys(cityName);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_state']")
	WebElement state;

	public RFPVerificationPage enterState(String stateName) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_state']"));
		clickableElement(state);
		state.sendKeys(stateName);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_zip']")
	WebElement zip;

	public RFPVerificationPage enterZip(String zipName) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_zip']"));
		clickableElement(zip);
		zip.sendKeys(zipName);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_country']")
	WebElement country;

	public RFPVerificationPage enterCountry(String countryName) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_country']"));
		clickableElement(country);
		country.sendKeys(countryName);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_anual_revenue']")
	WebElement anual_revenue;

	public RFPVerificationPage enterAnualRevenue(String AnualRevenue) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_anual_revenue']"));
		clickableElement(anual_revenue);
		anual_revenue.sendKeys(AnualRevenue);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-select[@ng-model='vm.vendor_industry']")
	WebElement industry;

	public RFPVerificationPage selectIndustry() {
		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.vendor_industry']"));
		clickableElement(industry);
		jsClick(industry);
		PresenceOfElement(By.xpath("//div[contains(text(),'Retailer/Distributor/Wholesaler(Computer-related)')]"));
		jsClick(driver
				.findElement(By.xpath("//div[contains(text(),'Retailer/Distributor/Wholesaler(Computer-related)')]")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.form.password']")
	WebElement setPassword;
	@FindBy(xpath = "//input[@ng-model='vm.form.passwordConfirm']")
	WebElement confirmPassword;
	@FindBy(xpath = "//button[@aria-label='SET MY PASSWORD']")
	WebElement clickOnSetPasswordbtn;

	public RFPVerificationPage setPassword() {
		String password = "Test@123";
		pause(3);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.password']"));
		setPassword.sendKeys(password);
		setPassword.sendKeys(Keys.TAB);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.passwordConfirm']"));
		confirmPassword.sendKeys(password);
		PresenceOfElement(By.xpath("//button[@aria-label='SET MY PASSWORD']"));
		clickableElement(clickOnSetPasswordbtn);
		jsClick(clickOnSetPasswordbtn);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.form.title']")
	WebElement enterTitle;
	@FindBy(xpath = "//input[@ng-model='vm.form.phone']")
	WebElement enterPhone;
	@FindBy(xpath = "//md-checkbox[@ng-model='vm.form.terms']")
	WebElement acceptterms;
	@FindBy(xpath = "//button[contains(text(),'CREATE MY PROFILE')]")
	WebElement clickOnCreateProfile;

	public RFPVerificationPage enterTitleAndPhone(String title, String number) {
		waitforElementClickable(enterTitle, con.getExplicitTime());
		enterTitle.sendKeys("Title");
		waitforElementClickable(enterPhone, con.getExplicitTime());
		scrollToElement(enterPhone);
		enterPhone.sendKeys(number);
		PresenceOfElement(By.xpath("//md-checkbox[@ng-model='vm.form.terms']"));

		scrollToElement(acceptterms);
		jsClick(acceptterms);
		pause(1);

		scrollToElement(clickOnCreateProfile);
		PresenceOfElement(By.xpath("//button[contains(text(),'CREATE MY PROFILE')]"));
		clickableElement(clickOnCreateProfile);
		jsClick(clickOnCreateProfile);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterPhone(String number) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//input[@ng-model='vm.form.phone']")));
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.phone']"));
		enterPhone.sendKeys(number);
		PresenceOfElement(By.xpath("//md-checkbox[@ng-model='vm.form.terms']"));
		scrollToElement(acceptterms);
		jsClick(acceptterms);
		pause(1);
		scrollToElement(clickOnCreateProfile);
		PresenceOfElement(By.xpath("//button[contains(text(),'CREATE MY PROFILE')]"));
		jsClick(clickOnCreateProfile);

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.form.company_name']")
	WebElement companyName;
	@FindBy(xpath = "//input[@ng-model='vm.form.sic_code']")
	WebElement SICcode;
	@FindBy(xpath = "//input[@ng-model='vm.form.number_of_employees']")
	WebElement numberOfEmployees;
	@FindBy(xpath = "//input[@ng-model='vm.form.street_address']")
	WebElement streetAddress;
	@FindBy(xpath = "//input[@ng-model='vm.form.city']")
	WebElement cityName;
	@FindBy(xpath = "//input[@ng-model='vm.form.state']")
	WebElement stateName;
	@FindBy(xpath = "//input[@ng-model='vm.form.country']")
	WebElement countryName;
	@FindBy(xpath = "//input[@ng-model='vm.form.annual_revenue']")
	WebElement annualRevenue;
	@FindBy(xpath = "//input[@ng-model='vm.form.website']")
	WebElement websiteName;
	@FindBy(xpath = "//md-select[@ng-model='vm.form.industry_id']")
	WebElement industryID;
	@FindBy(xpath = "(//md-option[@value='1'])[2]")
	WebElement industryType;
	@FindBy(xpath = "//md-select[@ng-model='vm.form.ownership']")
	WebElement ownership;
	@FindBy(xpath = "//md-option[@value='Public']/div")
	WebElement ownershipType;
	@FindBy(xpath = " //*[@ng-model='vm.vendor_business_type']")
	WebElement businessType;
	@FindBy(xpath = "//button[contains(text(),'View NIGP *')]")
	WebElement viewNigp;

	@FindBy(xpath = "//*[text()='Done']")
	WebElement done;

	@FindBy(xpath = "//button[contains(text(),'COMPLETE MY PROFILE')]")
	WebElement completeMyProfileBtn;

	public RFPVerificationPage enterCompanyDetails(String companyname, String sicCode, String numberOfemployees,
			String streetaddress, String cityname, String statename, String countryname, String annualrevenue,
			String websitename) {
		pause(3);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.company_name']"));
		companyName.sendKeys(companyname);
		pause(3);
		scrollToElement(SICcode);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.sic_code']"));
		SICcode.sendKeys(sicCode);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.number_of_employees']"));
		numberOfEmployees.sendKeys(numberOfemployees);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.street_address']"));
		streetAddress.sendKeys(streetaddress);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.city']"));
		cityName.sendKeys(cityname);
		scrollToElement(stateName);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.state']"));
		stateName.sendKeys(statename);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.country']"));
		countryName.sendKeys(countryname);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.annual_revenue']"));
		annualRevenue.sendKeys(annualrevenue);
		scrollToElement(websiteName);
		PresenceOfElement(By.xpath("//input[@ng-model='vm.form.website']"));
		websiteName.sendKeys(websitename);

		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.form.industry_id']"));
		clickableElement(industryID);
		jsClick(industryID);

		PresenceOfElement(By.xpath("(//md-option[@value='1'])[2]"));
		clickableElement(industryType);
		jsClick(industryType);
		pause(1);

		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.form.ownership']"));
		clickableElement(ownership);
		jsClick(ownership);

		PresenceOfElement(By.xpath("//md-option[@value='Public']/div"));
		clickableElement(ownershipType);
		jsClick(ownershipType);

		PresenceOfElement(By.xpath("//*[@ng-model='vm.vendor_business_type']"));
		clickableElement(businessType);
		jsClick(businessType);
		pause(3);
		jsClick(driver.findElement(By.xpath("//*[text()='Minority Business Enterprise (MBE)']")));
		pause(3);

		businessType.sendKeys(Keys.ENTER);
		businessType.sendKeys(Keys.TAB);

		PresenceOfElement(By.xpath("//button[contains(text(),'View NIGP *')]"));
		clickableElement(viewNigp);
		jsClick(viewNigp);
		pause(2);
		jsClick(driver.findElement(By.xpath("(//*[@aria-label='icon-checkbox-blank-outline'])[1]")));

		PresenceOfElement(By.xpath("//*[text()='Done']"));
		clickableElement(done);
		jsClick(done);
		pause(3);
		scrollToElement(completeMyProfileBtn);
		pause(1);

		PresenceOfElement(By.xpath("//button[contains(text(),'COMPLETE MY PROFILE')]"));
		clickableElement(completeMyProfileBtn);
		jsClick(completeMyProfileBtn);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnGetRFPlink() {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Get RFP link')]")));

		PresenceOfElement(By.xpath("//button[contains(text(),'Get RFP link')]"));
		clickableElement(driver.findElement(By.xpath("//button[contains(text(),'Get RFP link')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Get RFP link')]")));

		return new RFPVerificationPage();
	}

	public String getRFPlink() {
		String link = driver.findElement(By.xpath("//textarea[@id='selfRegistrationLink']")).getText();
		pause(3);

		PresenceOfElement(By.xpath("//div[@id='selfRegistrationLinkDailog']//button/i"));
		clickableElement(driver.findElement(By.xpath("//div[@id='selfRegistrationLinkDailog']//button/i")));
		jsClick(driver.findElement(By.xpath("//div[@id='selfRegistrationLinkDailog']//button/i")));
		return link;
	}

	@FindBy(xpath = "//a[contains(text(),'Create an account')]")
	WebElement createNewAccountLink;

	public RFPVerificationPage createNewAccountLink() {
		pause(5);
		PresenceOfElement(By.xpath("//a[contains(text(),'Create an account')]"));
		clickableElement(createNewAccountLink);
		jsClick(createNewAccountLink);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[ @ng-model='vm.form.first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[ @ng-model='vm.form.last_name']")
	WebElement lastName;
	@FindBy(xpath = "//input[ @ng-model='vm.form.email']")
	WebElement emailID;
	@FindBy(xpath = "//md-checkbox[@name='terms']")
	WebElement acceptTerms;

	public RFPVerificationPage enterVendorDetails(String firstname, String lastname, String emailid) {
		pause(3);
		PresenceOfElement(By.xpath("//input[ @ng-model='vm.form.first_name']"));
		type(firstName, firstname);
		PresenceOfElement(By.xpath("//input[ @ng-model='vm.form.last_name']"));
		type(lastName, lastname);
		PresenceOfElement(By.xpath("//input[ @ng-model='vm.form.email']"));
		type(emailID, emailid);
		pause(3);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage acceptTerms() {
		PresenceOfElement(By.xpath("//md-checkbox[@name='terms']"));
		clickableElement(acceptTerms);
		acceptTerms.click();
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[text()='CREATE MY ACCOUNT']")
	WebElement createBtn;

	public RFPVerificationPage clickOnCreateBtn() {
		pause(3);
		PresenceOfElement(By.xpath("//button[text()='CREATE MY ACCOUNT']"));
		clickableElement(createBtn);
		createBtn.click();
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectVendors(String vendorName) {
		PresenceOfElement(By.xpath("//div//h3[contains(text(),'Select Data to Compare')]/..//span[contains(text(),'"
				+ vendorName + "')]//md-checkbox"));
		clickableElement(driver
				.findElement(By.xpath("//div//h3[contains(text(),'Select Data to Compare')]/..//span[contains(text(),'"
						+ vendorName + "')]//md-checkbox")));
		jsClick(driver
				.findElement(By.xpath("//div//h3[contains(text(),'Select Data to Compare')]/..//span[contains(text(),'"
						+ vendorName + "')]//md-checkbox")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectRequirementFromDropdown(String requirement) {
		waitforElementClickable(driver.findElement(By.xpath("//md-option[@value='" + requirement + "']")), 10);
		PresenceOfElement(By.xpath("//md-option[@value='" + requirement + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option[@value='" + requirement + "']")));
		jsClick(driver.findElement(By.xpath("//md-option[@value='" + requirement + "']")));
		jsClick(driver.findElement(By.xpath("//html/body/md-backdrop")));
		jsClick(driver.findElement(By.xpath("//*[@id='templates-list']/div[1]/div[2]/div/label/md-icon")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectChartFromDropdown(String chartName) {
		scrollToElement(driver.findElement(By.xpath(
				"//md-option[@ng-repeat='relates in vm.as_it_relates']//div[contains(text(),'" + chartName + "')]")));
		PresenceOfElement(By.xpath(
				"//md-option[@ng-repeat='relates in vm.as_it_relates']//div[contains(text(),'" + chartName + "')]"));
		clickableElement(driver.findElement(By.xpath(
				"//md-option[@ng-repeat='relates in vm.as_it_relates']//div[contains(text(),'" + chartName + "')]")));
		jsClick(driver.findElement(By.xpath(
				"//md-option[@ng-repeat='relates in vm.as_it_relates']//div[contains(text(),'" + chartName + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage scrollToGraph(String chartName) {
		PresenceOfElement(By.xpath("//h3[contains(text(),'" + chartName + "')]"));
		scrollToElement(driver.findElement(By.xpath("//h3[contains(text(),'" + chartName + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage scrollToResultsSection() {

		pause(2);
		PresenceOfElement(By.xpath("//md-tab-item[contains(text(),'Results')]"));
		scrollToElement(driver.findElement(By.xpath("//md-tab-item[contains(text(),'Results')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage switchToResultsSection() {

		pause(2);
		scrollToElement(driver.findElement(By.xpath("//md-tab-item[contains(text(),'Results')]")));
		PresenceOfElement(By.xpath("//md-tab-item[contains(text(),'Results')]"));
		clickableElement(driver.findElement(By.xpath("//md-tab-item[contains(text(),'Results')]")));

		jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'Results')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveGraph() {

		pause(2);
		scrollToElement(
				driver.findElement(By.xpath("//div[@ng-if='vm.edit_permission']//button[contains(text(),'save')]")));
		PresenceOfElement(By.xpath("//div[@ng-if='vm.edit_permission']//button[contains(text(),'save')]"));
		clickableElement(
				driver.findElement(By.xpath("//div[@ng-if='vm.edit_permission']//button[contains(text(),'save')]")));
		jsClick(driver.findElement(By.xpath("//div[@ng-if='vm.edit_permission']//button[contains(text(),'save')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickonPercentageBtn() {
		PresenceOfElement(By.xpath("//button[contains(text(),'Section Percentage')]"));
		clickableElement(driver.findElement(By.xpath("//button[contains(text(),'Section Percentage')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Section Percentage')]")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage changePercentage(String sectionName, String Percentage) {
		PresenceOfElement(By.xpath("//h3[contains(text(),'" + sectionName + "')]/../..//input"));
		clickableElement(driver.findElement(By.xpath("//h3[contains(text(),'" + sectionName + "')]/../..//input")));
		type(driver.findElement(By.xpath("//h3[contains(text(),'" + sectionName + "')]/../..//input")), Percentage);
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage savePercentage() {
		PresenceOfElement(By.xpath("//button[@ng-click='vm.changeAllSectionPercentage($event)']"));
		clickableElement(driver.findElement(By.xpath("//button[@ng-click='vm.changeAllSectionPercentage($event)']")));
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.changeAllSectionPercentage($event)']")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage scrollToAddNewSection(String sectionName) {

		pause(2);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]"));
		scrollToElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage gotoDetailsSection() {

		pause(4);
		PresenceOfElement(By.xpath("//md-tab-item[text()='Details']"));
		clickableElement(driver.findElement(By.xpath("//md-tab-item[text()='Details']")));
		visibilityOfElementLocated(By.xpath("//md-tab-item[text()='Details']"));
		jsClick(driver.findElement(By.xpath("//md-tab-item[text()='Details']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage scrollToSectionName(String sectionName) {

		pause(2);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + sectionName + "')]"));
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'" + sectionName + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickonDownArrow(String questionName) {

		pause(2);
		scrollToElement(driver.findElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../td[5]//md-icon[@md-font-icon='icon-chevron-down']")));
		PresenceOfElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../td[5]//md-icon[@md-font-icon='icon-chevron-down']"));
		clickableElement(driver.findElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../td[5]//md-icon[@md-font-icon='icon-chevron-down']")));
		jsClick(driver.findElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../td[5]//md-icon[@md-font-icon='icon-chevron-down']")));
		return new RFPVerificationPage();
	}

	public String getPriority(String questionName) {

		PresenceOfElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[2]"));
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[2]")));
		pause(2);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[2]"));
		String priority = driver.findElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[2]"))
				.getText();
		System.out.println("==========Priority of the Question ===================" + priority);
		return priority;
	}

	public String getTotalNumberOfque(String sectionName) {
		PresenceOfElement(By.xpath("//span[contains(text(),'" + sectionName + "')]"));
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'" + sectionName + "')]")));
		pause(2);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + sectionName
				+ "')]/../../../../../../..//table[@class='dataTable row-border no-footer']//tbody//tr"));
		int number = driver
				.findElements(By.xpath("//span[contains(text(),'" + sectionName
						+ "')]/../../../../../../..//table[@class='dataTable row-border no-footer']//tbody//tr"))
				.size();
		String numberOfQue = Integer.toString(number);
		return numberOfQue;
	}

	public String getVendor1Rating(String questionName) {
		PresenceOfElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[3]"));
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[3]")));
		pause(2);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[3]"));
		String vendor1Rating = driver
				.findElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[3]")).getText();
		return vendor1Rating;
	}

	public String getVendor2Rating(String questionName) {

		PresenceOfElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[4]"));
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[4]")));
		pause(2);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[4]"));
		String vendor2Rating = driver
				.findElement(By.xpath("//span[contains(text(),'" + questionName + "')]/../../../td[4]")).getText();
		return vendor2Rating;
	}

	public RFPVerificationPage changeReferenceMarksFrame(String priority, String setValue) {

		pause(2);
		PresenceOfElement(By.xpath("//label[text()='" + priority + "']/..//input"));
		type(driver.findElement(By.xpath("//label[text()='" + priority + "']/..//input")), setValue);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage addRuntimeSection(String sectionName) {

		pause(2);
		PresenceOfElement(By.xpath("//input[@placeholder='Enter Section Name']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter Section Name']")).sendKeys(sectionName);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveChangeInReferenceMarks() {

		pause(2);

		PresenceOfElement(By.xpath("//button[@ng-click='vm.saveReportScore($event)']"));
		clickableElement(driver.findElement(By.xpath("//button[@ng-click='vm.saveReportScore($event)']")));
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveReportScore($event)']")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-select[@ng-model='vm.selected_users']")
	WebElement selectuser;
	@FindBy(xpath = "//button[@ng-click='vm.saveDelegate(vm.selected_users)']")
	WebElement sendBTN;

	public RFPVerificationPage selectDelegateUser(String user) {
		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.selected_users']"));
		scrollToElement(selectuser);

		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.selected_users']"));
		clickableElement(selectuser);
		jsClick(selectuser);

		PresenceOfElement(By.xpath("//div[text()='" + user + "']/../div"));
		clickableElement(driver.findElement(By.xpath("//div[text()='" + user + "']/../div")));
		jsClick(driver.findElement(By.xpath("//div[text()='" + user + "']/../div")));
		PresenceOfElement(By.xpath("//md-backdrop"));
		jsClick(driver.findElement(By.xpath("//md-backdrop")));

		PresenceOfElement(By.xpath("//button[@ng-click='vm.saveDelegate(vm.selected_users)']"));
		clickableElement(sendBTN);
		sendBTN.click();

		return new RFPVerificationPage();
	}

	public String percentageCalculation(String Priority, String Rating) {

		float RatingInt = Float.parseFloat(Rating);
		float per = 0;

		switch (Priority) {
		case "Critical":
			per = ((RatingInt * 100) / 20);
			break;
		case "High":
			per = ((RatingInt * 100) / 15);
			break;
		case "Medium":
			per = ((RatingInt * 100) / 10);
			break;
		case "Low":
			per = ((RatingInt * 100) / 5);
			break;
		}
		String string1 = "" + Math.round(per);
		return string1;
	}

	public RFPVerificationPage clickOnAddSectionBtn() {

		pause(2);

		PresenceOfElement(By.xpath("//button[contains(text(),'Add Section')]"));
		clickableElement(driver.findElement(By.xpath("//button[contains(text(),'Add Section')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Add Section')]")));

		return new RFPVerificationPage();
	}

	public boolean verifyAddQueAndSavebtnDisplay(String sectionName) {

		PresenceOfElement(
				By.xpath("//span[contains(text(),'" + sectionName + "')]/..//button[contains(text(),'Add Question')]"));
		PresenceOfElement(By.xpath(
				"//span[contains(text(),'" + sectionName + "')]/../../..//md-icon[@md-font-icon='icon-content-save']"));
		return driver
				.findElement(By.xpath(
						"//span[contains(text(),'" + sectionName + "')]/..//button[contains(text(),'Add Question')]"))
				.isDisplayed()
				&& driver.findElement(By.xpath("//span[contains(text(),'" + sectionName
						+ "')]/../../..//md-icon[@md-font-icon='icon-content-save']")).isDisplayed();
	}

	public RFPVerificationPage clickOnEditPricingBtn(String vendorNumber) {
		pause(3);
		scrollToElement(
				driver.findElement(By.xpath("(//button[contains(text(),'Edit Pricing')])[" + vendorNumber + "]")));
		PresenceOfElement(By.xpath("(//button[contains(text(),'Edit Pricing')])[" + vendorNumber + "]"));
		clickableElement(
				driver.findElement(By.xpath("(//button[contains(text(),'Edit Pricing')])[" + vendorNumber + "]")));

		jsClick(driver.findElement(By.xpath("(//button[contains(text(),'Edit Pricing')])[" + vendorNumber + "]")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage changePricingValue(String nameTextbox, String value) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//input[@ng-model='" + nameTextbox + "']")));
		type(driver.findElement(By.xpath("//input[@ng-model='" + nameTextbox + "']")), value);

		PresenceOfElement(
				By.xpath("//button[contains(text(),'Save') and @ng-if='!vm.vendor_price_edit[vendor_index]']"));
		clickableElement(driver.findElement(
				By.xpath("//button[contains(text(),'Save') and @ng-if='!vm.vendor_price_edit[vendor_index]']")));
		scrollToElement(driver.findElement(
				By.xpath("//button[contains(text(),'Save') and @ng-if='!vm.vendor_price_edit[vendor_index]']")));

		jsClick(driver.findElement(
				By.xpath("//button[contains(text(),'Save') and @ng-if='!vm.vendor_price_edit[vendor_index]']")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage checkItemToDownloadReport(String itemName) {

		pause(3);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + itemName + "')]/../md-checkbox"));
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'" + itemName + "')]/../md-checkbox")));

		PresenceOfElement(By.xpath("//span[contains(text(),'" + itemName + "')]/../md-checkbox"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + itemName + "')]/../md-checkbox")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + itemName + "')]/../md-checkbox")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnGenerateReportBtn() {

		pause(3);
		scrollToElement(driver.findElement(By.xpath(
				"//button[contains(text(),'Generate Report') and @class='md-raised md-accent md-button md-default-theme md-ink-ripple']")));
		PresenceOfElement(By.xpath(
				"//button[contains(text(),'Generate Report') and @class='md-raised md-accent md-button md-default-theme md-ink-ripple']"));
		clickableElement(driver.findElement(By.xpath(
				"//button[contains(text(),'Generate Report') and @class='md-raised md-accent md-button md-default-theme md-ink-ripple']")));
		jsClick(driver.findElement(By.xpath(
				"//button[contains(text(),'Generate Report') and @class='md-raised md-accent md-button md-default-theme md-ink-ripple']")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnDownloadReportIcon() {

		pause(3);
		scrollToElement(driver.findElement(By.xpath("//tr//md-icon[@aria-label='icon-download']")));
		PresenceOfElement(By.xpath("//tr//md-icon[@aria-label='icon-download']"));
		clickableElement(driver.findElement(By.xpath("//tr//md-icon[@aria-label='icon-download']")));
		jsClick(driver.findElement(By.xpath("//tr//md-icon[@aria-label='icon-download']")));

		return new RFPVerificationPage();
	}

	public String avgpercentageCalculation(String Per1, String Per2) {
		int RatingInt1 = Integer.parseInt(Per1);
		int RatingInt2 = Integer.parseInt(Per2);

		int avg = (RatingInt1 + RatingInt2) / 2;

		String string1 = "" + avg;
		return string1;
	}


	@FindBy(xpath = "//md-step-label-wrapper[contains(text(),'Needs')]")
	WebElement NeedsTab;

	public RFPVerificationPage gotoNeedsBubbletab() {
		pause(5);
		scrollToElement(NeedsTab);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[contains(text(),'Needs')]"));
		clickableElement(NeedsTab);
		jsClick(NeedsTab);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-step-label-wrapper[contains(text(),'Sections')]")
	WebElement SectionsTab;

	public RFPVerificationPage gotoSectionsBubbletab() {
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[contains(text(),'Sections')]"));
		clickableElement(SectionsTab);
		jsClick(SectionsTab);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-select[@ng-model='vm.vendor_ownership']")
	WebElement ownershipSelect;

	public RFPVerificationPage selectOwnership() {
		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.vendor_ownership']"));
		clickableElement(ownershipSelect);
		jsClick(ownershipSelect);
		PresenceOfElement(By.xpath("//div[@class='md-text' and contains(text(),'Public')]"));
		jsClick(driver.findElement(By.xpath("//div[@class='md-text' and contains(text(),'Public')]")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_primary_contact']")
	WebElement primaryContact;

	public RFPVerificationPage enterPrimaryContact(String PrimayContact) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_primary_contact']"));
		clickableElement(primaryContact);
		primaryContact.sendKeys(PrimayContact);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_primary_title']")
	WebElement primaryTitle;

	public RFPVerificationPage enterPrimaryTitle(String PrimayTitle) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_primary_title']"));
		clickableElement(primaryTitle);
		primaryTitle.sendKeys(PrimayTitle);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@ng-model='vm.vendor_primary_phone_number']")
	WebElement phoneNumber;

	public RFPVerificationPage enterPrimaryPhoneNumber(String PhoneNumber) {
		PresenceOfElement(By.xpath("//input[@ng-model='vm.vendor_primary_phone_number']"));
		clickableElement(phoneNumber);
		phoneNumber.sendKeys(PhoneNumber);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-select[@ng-model='vm.vendor_business_type']")
	WebElement bussinessType;

	public RFPVerificationPage selectBussinessType() {
		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.vendor_business_type']"));
		clickableElement(bussinessType);
		jsClick(bussinessType);
		PresenceOfElement(
				By.xpath("//div[@class='md-text ng-binding' and contains(text(),'Small Business Enterprise (SBE)')]"));
		jsClick(driver.findElement(
				By.xpath("//div[@class='md-text ng-binding' and contains(text(),'Small Business Enterprise (SBE)')]")));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(primaryTitle).click().build();
		seriesOfActions.perform();
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//*[contains(text(),'View NIGP*')]")
	WebElement ViewNAICS;

	public RFPVerificationPage clickOnViewNAICSBtn() {
		scrollToElement(ViewNAICS);
		PresenceOfElement(By.xpath("//*[contains(text(),'View NIGP*')]"));
		clickableElement(ViewNAICS);
		jsClick(ViewNAICS);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "(//*[@aria-label='icon-checkbox-blank-outline'])[1]")
	WebElement naics11;

	@FindBy(xpath = "(//*[@aria-label='icon-checkbox-blank-outline'])[2]")
	WebElement naics111;
	@FindBy(xpath = "(//*[@aria-label='icon-checkbox-blank-outline'])[3]")
	WebElement naics1111;

	public RFPVerificationPage clickOn11and111and1111() {
		clickableElement(naics11);
		jsClick(naics11);
		clickableElement(naics111);
		jsClick(naics111);
		clickableElement(naics1111);
		jsClick(naics1111);
		scrollToElement(driver.findElement(By.xpath("//*[text()='00500--ABRASIVES']")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[@ng-click='vm.saveNaics();']")
	WebElement doneBtn;

	public RFPVerificationPage clickOnDone() {
		PresenceOfElement(By.xpath("//button[@ng-click='vm.saveNaics();']"));
		clickableElement(doneBtn);
		jsClick(doneBtn);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[@ng-click='vm.createVendorAccount()']")
	WebElement saveVendorBtn;

	public RFPVerificationPage clickOnSaveButtonOfvendor() {
		PresenceOfElement(By.xpath("//button[@ng-click='vm.createVendorAccount()']"));
		clickableElement(saveVendorBtn);
		jsClick(saveVendorBtn);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//label[contains(.,'CapEx')]/../input")
	WebElement CapExInput;

	public RFPVerificationPage enterCapEx() {
		PresenceOfElement(By.xpath("//label[contains(.,'CapEx')]/../input"));
		clickableElement(CapExInput);
		CapExInput.clear();
		CapExInput.sendKeys("100");
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//label[contains(.,'OpEx')]/../input")
	WebElement OpExInput;

	public RFPVerificationPage enterOpEx() {
		PresenceOfElement(By.xpath("//label[contains(.,'OpEx')]/../input"));
		clickableElement(OpExInput);
		OpExInput.clear();
		OpExInput.sendKeys("100");
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//label[contains(.,'Annual Maintenance')]/../input")
	WebElement AnualMainInput;

	public RFPVerificationPage enterAnualMain() {
		PresenceOfElement(By.xpath("//label[contains(.,'Annual Maintenance')]/../input"));
		clickableElement(AnualMainInput);
		AnualMainInput.clear();
		AnualMainInput.sendKeys("100");
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[@ng-click='vm.savePaperBidPricing()']")
	WebElement saveBId;

	public RFPVerificationPage clickOnSaveButtonOfBId() {
		PresenceOfElement(By.xpath("//button[@ng-click='vm.savePaperBidPricing()']"));
		clickableElement(saveBId);
		jsClick(saveBId);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage createRFPSectionAsAddendment( String sectionname) {

		testStepsLog("Step " + (stepCount++), "Enter section name.");
		enterSectionName(sectionname);

		testStepsLog("Step " + (stepCount++), "Click on plus button.");
		clickOnPlusButtonInSections();

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[@ng-click='vm.saveSections(false)']")
	WebElement saveButton;

	public RFPVerificationPage clickOnSaveButton() {
		pause(5);
		scrollToElement(saveButton);
		PresenceOfElement(By.xpath("//button[@ng-click='vm.saveSections(false)']"));
		clickableElement(saveButton);
		scrollToElement(saveButton);
		jsClick(saveButton);

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[contains(text(),'Discard changes')]")
	WebElement discardBtn;

	public RFPVerificationPage clickOnDiscardChangesBtn() {
		pause(2);
		PresenceOfElement(By.xpath("//button[contains(text(),'Discard changes')]"));
		clickableElement(discardBtn);
		jsClick(discardBtn);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnDotsIcon(String que) {
		pause(3);
		PresenceOfElement(By.xpath(
				"//span[contains(text(),'" + que + "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical']"));
		clickableElement(driver.findElement(By.xpath(
				"//span[contains(text(),'" + que + "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical']")));
		jsClick(driver.findElement(By.xpath(
				"//span[contains(text(),'" + que + "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical']")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectEditOption(String option) {

		PresenceOfElement(By.xpath("//md-menu-content[@class='md-default-theme']"));
		clickableElement(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));

		jsClick(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));
		pause(2);

		PresenceOfElement(By.xpath("(//button[@aria-label='" + option + "'])[2]"));
		clickableElement(driver.findElement(By.xpath("(//button[@aria-label='" + option + "'])[2]")));

		jsClick(driver.findElement(By.xpath("(//button[@aria-label='" + option + "'])[2]")));
		pause(2);
		PresenceOfElement(By.xpath("//md-backdrop"));
		clickableElement(driver.findElement(By.xpath("//md-backdrop")));
		jsClick(driver.findElement(By.xpath("//md-backdrop")));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//textarea[@ng-model='vm.question_text']")
	WebElement questionTextArea;

	public RFPVerificationPage editQuestionData(String question) {
		enterDataIn(questionTextArea, question);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//button[contains(text(),'Publish amendment')]")
	WebElement publishBtn;

	public RFPVerificationPage clickOnPublishBtn() {
		pause(5);

		scrollToElement(publishBtn);
		PresenceOfElement(By.xpath("//button[contains(text(),'Publish amendment')]"));
		clickableElement(publishBtn);

		jsClick(publishBtn);
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//input[@name='version_title']")
	WebElement versionTitle;
	@FindBy(xpath = "//textarea[@name='version_description']")
	WebElement versionDescription;
	@FindBy(xpath = "//button[text()='Save and Publish']")
	WebElement saveAndpublishBtn;

	public RFPVerificationPage enterAmendmentDetails(String Title, String Description) {
		PresenceOfElement(driver.findElement(By.xpath("//input[@name='version_title']")));
		versionTitle.sendKeys(Title);
		PresenceOfElement(By.xpath("//textarea[@name='version_description']"));
		scrollToElement(versionDescription);
		versionDescription.sendKeys(Description);

		PresenceOfElement(By.xpath("//button[text()='Save and Publish']"));
		clickableElement(saveAndpublishBtn);
		testStepsLog("Step " + (stepCount++)," Click on 'saveAndpublishBtn' button.");

		jsClick(saveAndpublishBtn);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage switchToNewSection(String tabName) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'" + tabName + "')]")));

		PresenceOfElement(By.xpath("//span[contains(text(),'" + tabName + "')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + tabName + "')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + tabName + "')]")));
		pause(2);

		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatingsForNewSection(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[3]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[3]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[3]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnAcceptButtonDelegate(String rfpName, String sectionName) {
		String acceptButton = "//a[contains(text(),'#Description')]/ancestor::tr//a[contains(text(),'#rfpName')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']";
		acceptButton = acceptButton.replace("#rfpName", rfpName);
		acceptButton = acceptButton.replace("#Description", "Delegate for RFP " + rfpName);
		scrollToElement(driver.findElement(By.xpath(acceptButton)));
		PresenceOfElement(By.xpath(acceptButton));
		clickableElement(driver.findElement(By.xpath(acceptButton)));
		jsClick(driver.findElement(By.xpath(acceptButton)));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectVendorAcknowledgeBtnFromDashboardADDENDUMLIST(String rfpName, String sectionName) {
		pause(2);
		driver.findElement(By.xpath("//div[@type='amendmenttasksearchhtml']//md-icon[@aria-label='icon-magnify']"))
				.click();
		pause(1);
		driver.findElement(By.xpath("//div[@type='amendmenttasksearchhtml']//input")).sendKeys(rfpName);
		pause(2);
		String acknowledgeButton = "//a[contains(text(),'" + sectionName + "')]/ancestor::tr//a[contains(text(),'"
				+ rfpName + "')]/../..//button[@aria-label='Acknowledge']";
		PresenceOfElement(By.xpath(acknowledgeButton));
		clickableElement(driver.findElement(By.xpath(acknowledgeButton)));
		jsClick(driver.findElement(By.xpath(acknowledgeButton)));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatingsForNewSectionVendorOne(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[4]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[4]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[4]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatingsForNewSectionVendorOne(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[4]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[4]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[4]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatingsVendorOne(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[2]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[2]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatingsOne(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[2]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[2]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[2]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveAnswersFromVendor1(String vsme, String Answer) {
		pause(6);
		scrollToElement(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'vm.gotoComapny()')]")));
		pause(6);
		PresenceOfElement(By.xpath("//md-content//td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../td[4]//button[contains(text(),'" + Answer + "')]"));
		pause(6);
		clickableElement(driver.findElement(By.xpath("//md-content//td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../td[4]//button[contains(text(),'" + Answer + "')]")));
		pause(6);
		jsClick(driver.findElement(By.xpath("//md-content//td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../td[4]//button[contains(text(),'" + Answer + "')]")));
		pause(6);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings4(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[4]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[4]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[4]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatings4(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[4]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[4]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[4]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings5(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[6]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[6]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[6]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatings5(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[6]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[6]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[6]")));
		return new RFPVerificationPage();
	}


	public RFPVerificationPage clickOnDownArrowForRating(String question) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../td[7]//*[@class='md-icon-button md-default-theme nopadding-button md-button ng-scope md-ink-ripple']")));
		PresenceOfElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../td[7]//*[@class='md-icon-button md-default-theme nopadding-button md-button ng-scope md-ink-ripple']"));
		pause(3);
		WebElement text = driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../td[7]//*[@class='md-icon-button md-default-theme nopadding-button md-button ng-scope md-ink-ripple']"));
		String textOfmenu = text.getAttribute("aria-label");

		if (textOfmenu.equals("Collapse")) {
			System.out.println("Down ArroW Enable");
		} else {

			scrollToElement(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
					+ "')]/../../../td[7]//md-icon[@md-font-icon='icon-chevron-down']")));
			PresenceOfElement(By.xpath("//md-content//div/span[contains(text(),'" + question
					+ "')]/../../../td[7]//md-icon[@md-font-icon='icon-chevron-down']"));
			clickableElement(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
					+ "')]/../../../td[7]//md-icon[@md-font-icon='icon-chevron-down']")));

			jsClick(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
					+ "')]/../../../td[7]//md-icon[@md-font-icon='icon-chevron-down']")));
			pause(5);

		}
		return new RFPVerificationPage();
	}




	public RFPVerificationPage giveRatings7(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[7]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[7]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[7]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings8(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[8]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[8]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[8]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings9(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[9]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[9]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[9]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings10(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[10]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[10]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[10]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatingss7(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[7]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[7]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[7]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatingss8(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[8]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[8]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[8]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatingss9(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[9]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[9]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[9]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage saveRatingss10(String Vendor) {
		pause(5);
		PresenceOfElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[10]"));
		clickableElement(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[10]")));
		jsClick(driver.findElement(
				By.xpath("(//td[contains(text(),'" + Vendor + "')]/../td[7]//button[contains(text(),'Save')])[10]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterRFADataRfp(String rfaName, String bidNumber, String typeOfRFP) {
		enterDataIn(name_field, rfaName);
		pause(2);
		scrollToElement(bid_field);
		enterDataIn(bid_field, bidNumber);

		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String releaseDate = dateFormat.format(currentDate);
		System.out.println(releaseDate);
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DAY_OF_MONTH, 7);
		String currentDatePlusSevenDays = dateFormat.format(c.getTime());

		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		clickableElement(release_Date_Calender);
		jsClick(release_Date_Calender);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));

		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[2]"));
		clickableElement(que_cutOff_date);

		jsClick(que_cutOff_date);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + currentDatePlusSevenDays + "']")));
		pause(2);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage scrollToSaveGraph() {

		pause(2);
		scrollToElement(
				driver.findElement(By.xpath("//div[@ng-if='vm.edit_permission']//button[contains(text(),'save')]")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterEvaluator(String email, String date) {
		scrollToElement(driver.findElement(By.xpath("//*[@placeholder='Add User or Email ID']//input")));
		pause(1);
		PresenceOfElement(By.xpath("//*[@placeholder='Add User or Email ID']//input"));
		clickableElement(driver.findElement(By.xpath("//*[@placeholder='Add User or Email ID']//input")));
		pause(1);
		WebElement emailEnter = driver.findElement(By.xpath("//*[@placeholder='Add User or Email ID']//input"));
		emailEnter.sendKeys(email);
		emailEnter.sendKeys(Keys.TAB);

		scrollToElement(driver.findElement(By.xpath(
				"//*[@placeholder='Add User or Email ID']//input/../../parent::td//following-sibling::td//*[@aria-label='Enter date']")));
		pause(1);
		PresenceOfElement(By.xpath(
				"//*[@placeholder='Add User or Email ID']//input/../../parent::td/following-sibling::td//button[@aria-label='Open calendar']"));
		clickableElement(driver.findElement(By.xpath(
				"//*[@placeholder='Add User or Email ID']//input/../../parent::td/following-sibling::td//button[@aria-label='Open calendar']")));

		jsClick(driver.findElement(By.xpath(
				"//*[@placeholder='Add User or Email ID']//input/../../parent::td/following-sibling::td//button[@aria-label='Open calendar']")));
		pause(1);
		pause(3);
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String releaseDate = dateFormat.format(currentDate);
		System.out.println(releaseDate);
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DAY_OF_MONTH, 1);
		String currentDatePlusOneDays = dateFormat.format(c.getTime());

		PresenceOfElement(By.xpath("//td[@aria-label='" + currentDatePlusOneDays + "']"));
		clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + currentDatePlusOneDays + "']")));

		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + currentDatePlusOneDays + "']")));

		PresenceOfElement(By.xpath(
				"//*[@placeholder='Add User or Email ID']//input/../../parent::td//following-sibling::td//*[@placeholder='Section']"));
		clickableElement(driver.findElement(By.xpath(
				"//*[@placeholder='Add User or Email ID']//input/../../parent::td//following-sibling::td//*[@placeholder='Section']")));
		pause(1);
		jsClick(driver.findElement(By.xpath(
				"//*[@placeholder='Add User or Email ID']//input/../../parent::td//following-sibling::td//*[@placeholder='Section']")));
		pause(1);
		WebElement d = driver.findElement(By.xpath("(//*[@ng-repeat='sections in vm.temp_sections'])[3]"));
		d.click();

		return new RFPVerificationPage();
	}

	public RFPVerificationPage fillRFPSummaryEvaluator(int stepCount, String typeOfRFP, String rfpName) {
		testStepsLog("Step " + (stepCount), " c-: Fill Basic Information");
		testStepsLog("", "RFP name=" + rfpName);
		testStepsLog("", "RFP description= Description of " + rfpName);
		testStepsLog("", "RFP BID Number= " + "123456");
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		System.out.println(dateFormat.format(currentDate));
		PresenceOfElement(By.xpath("//input[@ng-model='vm.name']"));
		driver.findElement(By.xpath("//input[@ng-model='vm.name']")).clear();
		globalMap.put("vendorRFPName", rfpName);
		enterRFADataEvaluator(rfpName, "Description of " + rfpName, "123456", typeOfRFP);
		testStepsLog("Step " + (stepCount), " d-: Click on 'Continue' button");
		stepCount++;
		clickOnContinueButton("Rfp");
		return new RFPVerificationPage();
	}

	public RFPVerificationPage enterRFADataEvaluator(String rfaName, String description, String bidNumber,
			String typeOfRFP) {
		enterDataIn(name_field, rfaName);
		driver.switchTo().frame(frame);
		pause(3);
		PresenceOfElement(By.xpath("//html/body[@contenteditable='true']"));
		pause(3);
		enterDataIn(driver.findElement(By.xpath("//html/body[@contenteditable='true']")), description);
		pause(2);
		driver.switchTo().defaultContent();
		pause(2);
		scrollToElement(bid_field);
		enterDataIn(bid_field, bidNumber);

		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String releaseDate = dateFormat.format(currentDate);
		System.out.println(releaseDate);
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DAY_OF_MONTH, 1);
		String currentDatePlusOneDays = dateFormat.format(c.getTime());

		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		clickableElement(release_Date_Calender);
		jsClick(release_Date_Calender);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));

		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[2]"));
		clickableElement(que_cutOff_date);

		jsClick(que_cutOff_date);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));
		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[3]"));
		clickableElement(submission_due_date);

		jsClick(submission_due_date);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + releaseDate + "']")));
		pause(2);
		PresenceOfElement(By.xpath("(//button[@aria-label='Open calendar'])[4]"));
		clickableElement(ven_due_date);

		jsClick(ven_due_date);
		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + currentDatePlusOneDays + "']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnResend() {
		scrollToElement(driver.findElement(By.xpath("(//*[@aria-label='Resend'])[2]")));
		PresenceOfElement(By.xpath("(//*[@aria-label='Resend'])[2]"));
		clickableElement(driver.findElement(By.xpath("(//*[@aria-label='Resend'])[2]")));

		jsClick(driver.findElement(By.xpath("(//*[@aria-label='Resend'])[2]")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnMailEvaluator() {

		PresenceOfElement(By
				.xpath("//td[contains(text(),'The Green RFP')]/..//td/a[contains(text(),'evaluate vendor response')]"));
		clickableElement(driver.findElement(By.xpath(
				"//td[contains(text(),'The Green RFP')]/..//td/a[contains(text(),'evaluate vendor response')]")));

		jsClick(driver.findElement(By.xpath(
				"//td[contains(text(),'The Green RFP')]/..//td/a[contains(text(),'evaluate vendor response')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnLoginBtn() {
		pause(2);
		scrollToElement(mailinator_iframe);
		driver.switchTo().frame(mailinator_iframe);

		PresenceOfElement(By.xpath("//*[text()='LOGIN']"));
		clickableElement(driver.findElement(By.xpath("//*[text()='LOGIN']")));

		jsClick(driver.findElement(By.xpath("//*[text()='LOGIN']")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectTemplateRfp(String rfpName) {
		pause(3);
		PresenceOfElement(By.xpath("//a[contains(text(),'" + rfpName + "') or @aria-label='" + rfpName + "']"));
		clickableElement(driver
				.findElement(By.xpath("//a[contains(text(),'" + rfpName + "') or @aria-label='" + rfpName + "']")));
		jsClick(driver
				.findElement(By.xpath("//a[contains(text(),'" + rfpName + "') or @aria-label='" + rfpName + "']")));
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage selectVendorAcceptBtnFromDashboardVendor(String rfpName) {
		pause(3);
		String acceptButton = "//tr[1]//a[contains(text(),'" + rfpName + "')]/ancestor::tr//a[contains(text(),'"
				+ rfpName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']";
		PresenceOfElement(By.xpath(acceptButton));
		clickableElement(driver.findElement(By.xpath(acceptButton)));
		jsClick(driver.findElement(By.xpath(acceptButton)));
		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-tab-item[text()='USERS']")
	WebElement btn_users_tab;

	public RFPVerificationPage clickOnAdmistrtionUsersTab() {
		pause(5);
		scrollToElement(btn_users_tab);
		PresenceOfElement(By.xpath("//md-tab-item[text()='USERS']"));
		clickableElement(btn_users_tab);
		jsClick(btn_users_tab);
		return new RFPVerificationPage();

	}

	@FindBy(xpath = "//*[contains(@ng-click,'usersearchhtmltoggle()')]")
	WebElement btn_search_tab;
	@FindBy(xpath = "//*[contains(@data-ng-model,'vm.search_user')]")
	WebElement txt_serch_user;

	public RFPVerificationPage clickOnAdmistrtionSearchUser(String email) {
		pause(5);

		PresenceOfElement(By.xpath("//*[contains(@ng-click,'usersearchhtmltoggle()')]"));
		clickableElement(btn_search_tab);
		jsClick(btn_search_tab);

		PresenceOfElement(By.xpath("//*[contains(@data-ng-model,'vm.search_user')]"));
		pause(5);
		txt_serch_user.sendKeys(email);
		pause(5);
		return new RFPVerificationPage();

	}

	public RFPVerificationPage clickOnEditTab() {

		pause(3);

		PresenceOfElement(By.xpath("//span[contains(text(),'Edit')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'Edit')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'Edit')]")));
		return new RFPVerificationPage();

	}

	@FindBy(xpath = "//md-select[@ng-model='vm.edit_user_role']")
	WebElement btn_edit_role;
	@FindBy(xpath = "//button[@ng-disabled='newuserform.$invalid']")
	WebElement saveBtnn;

	public RFPVerificationPage clickOnDots() {

		pause(3);
		PresenceOfElement(By.xpath("(//md-icon[@md-font-icon='icon-dots-vertical'])[1]"));
		driver.findElement(By.xpath("(//md-icon[@md-font-icon='icon-dots-vertical'])[1]")).click();
		return new RFPVerificationPage();

	}

	public RFPVerificationPage deleteRunTimeSection(String sectionName) {

		pause(2);
		PresenceOfElement(By
				.xpath("//span[contains(text(),'" + sectionName + "')]/../../..//md-icon[@md-font-icon='icon-trash']"));
		clickableElement(driver.findElement(By.xpath(
				"//span[contains(text(),'" + sectionName + "')]/../../..//md-icon[@md-font-icon='icon-trash']")));
		jsClick(driver.findElement(By.xpath(
				"//span[contains(text(),'" + sectionName + "')]/../../..//md-icon[@md-font-icon='icon-trash']")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage RateAll(String question) {

		pause(2);
		PresenceOfElement(
				By.xpath("//md-content//div/span[contains(text(),'" + question + "')]//following::button[3]"));
		clickableElement(driver.findElement(
				By.xpath("//md-content//div/span[contains(text(),'" + question + "')]//following::button[3]")));
		jsClick(driver.findElement(
				By.xpath("//md-content//div/span[contains(text(),'" + question + "')]//following::button[3]")));
		return new RFPVerificationPage();
	}

	

	public RFPVerificationPage giveRatings44(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[3]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatings55(String Vendor, String numberofStars) {
		pause(5);
		PresenceOfElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[5]"));
		clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[5]")));
		jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + Vendor
				+ "')]/../td[6]//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a["
				+ numberofStars + "]/i)[5]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickOnSummaryBubble() {
		scrollToElement(approver_bubble);
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Summary']"));
		clickableElement(driver.findElement(By.xpath("//md-step-label-wrapper[@class='Summary']")));
		jsClick(summary_bubble);
		pause(5);
		return new RFPVerificationPage();
	}

	public RFPVerificationPage ChangeTimeZone(String timeZone) {
		pause(5);
		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']"));
		jsClick(driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']")));
		pause(5);
		jsClick(driver.findElement(By.xpath("//*[contains(text(),'" + timeZone + "')]")));

		return new RFPVerificationPage();
	}

	public RFPVerificationPage ClickOnSummaryContinue(String sectionTab) {
		scrollToElementTillTrue(driver.findElement(
				By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]")));
		PresenceOfElement(
				By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]"));
		clickableElement(driver.findElement(
				By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]")));
		pause(1);
		jsClick(driver.findElement(
				By.xpath("//button[contains(text(),'Continue') and contains(@ng-click,'" + sectionTab + "')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage verifyExpandedorNot(String question) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../td[7]//*[@class='md-icon-button md-default-theme nopadding-button md-button ng-scope md-ink-ripple']")));
		PresenceOfElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../td[7]//*[@class='md-icon-button md-default-theme nopadding-button md-button ng-scope md-ink-ripple']"));
		pause(3);
		WebElement text = driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../td[7]//*[@class='md-icon-button md-default-theme nopadding-button md-button ng-scope md-ink-ripple']"));
		String textOfmenu = text.getAttribute("aria-label");


		if (textOfmenu.equals("Collapse")) {
			System.out.println("Rating is not given hence it is expanded");
			Assert.assertTrue(true);
		} else {
			System.out.println("Rating is not given hence it is Not expanded");
			Assert.assertTrue(false);
		}

		return new RFPVerificationPage();
	}

	@FindBy(xpath = "//md-checkbox[contains(@ng-model,'vm.clarification')]")
	WebElement checkbox;

	public RFPVerificationPage deseableInlineAddendums() {
		{
			scrollToElement(driver.findElement(By.xpath("//md-checkbox[contains(@ng-model,'vm.clarification')]")));
			PresenceOfElement(By.xpath("//md-checkbox[contains(@ng-model,'vm.clarification')]"));
			pause(3);
			jsClick(checkbox);
			return new RFPVerificationPage();
		}
	}

	public RFPVerificationPage enterEvaluatorsDetails(String evaluatorName) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//input[@placeholder = 'Add User or Email ID']")));
		pause(1);
		PresenceOfElement(By.xpath("//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//input[@placeholder = 'Add User or Email ID']")));

		jsClick(driver.findElement(By.xpath("//input[@placeholder = 'Add User or Email ID']")));
		pause(2);
		PresenceOfElement(By.xpath("//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//input[@placeholder = 'Add User or Email ID']")));

		driver.findElement(By.xpath("//input[@placeholder = 'Add User or Email ID']")).sendKeys(evaluatorName);
		pause(3);
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(currentDate);
		PresenceOfElement(By.xpath("//span[@md-highlight-text='vm.searchTextEvaluator']"));
		clickableElement(driver.findElement(By.xpath("//span[@md-highlight-text='vm.searchTextEvaluator']")));

		jsClick(driver.findElement(By.xpath("//span[@md-highlight-text='vm.searchTextEvaluator']")));

		PresenceOfElement(By.xpath(
				"//input[@placeholder = 'Add User or Email ID']/../../../..//button[@aria-label='Open calendar']"));
		clickableElement(driver.findElement(By.xpath(
				"//input[@placeholder = 'Add User or Email ID']/../../../..//button[@aria-label='Open calendar']")));

		jsClick(driver.findElement(By.xpath(
				"//input[@placeholder = 'Add User or Email ID']/../../../..//button[@aria-label='Open calendar']")));

		pause(1);

		System.out.println(smeDate);
		PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
		clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));

		jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));

		PresenceOfElement(By.xpath(
				"//input[@placeholder = 'Add User or Email ID']/../../../..//md-select[@placeholder='Section']"));
		clickableElement(driver.findElement(By.xpath(
				"//input[@placeholder = 'Add User or Email ID']/../../../..//md-select[@placeholder='Section']")));

		jsClick(driver.findElement(By.xpath(
				"//input[@placeholder = 'Add User or Email ID']/../../../..//md-select[@placeholder='Section']")));
		pause(1);

		PresenceOfElement(By.xpath("//md-option[contains(@ng-repeat,'sections in vm.temp')]"));
		clickableElement(driver.findElement(By.xpath("//md-option[contains(@ng-repeat,'sections in vm.temp')]")));

		jsClick(driver.findElement(By.xpath("//md-option[contains(@ng-repeat,'sections in vm.temp')]")));
		pause(1);

		PresenceOfElement(By.xpath("//*[contains(@aria-label,'Add New')]"));
		clickableElement(driver.findElement(By.xpath("//*[contains(@aria-label,'Add New')]")));

		jsClick(driver.findElement(By.xpath("//*[contains(@aria-label,'Add New')]")));
		pause(1);

		return new RFPVerificationPage();

	}

	public RFPVerificationPage createSection(int stepCount, String sectionName) {
		pause(3);
		PresenceOfElement(By.xpath("//div[contains(text(),'Define Your Content Sections')]"));
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'Define Your Content Sections')]")));
		testStepsLog("Step " + (stepCount), " a- :  Enter section name.");
		enterSectionName(sectionName);
		testStepsLog("Step " + (stepCount), " b- :  Click on plus button.");
		clickOnPlusButtonInSections();
		return new RFPVerificationPage();
	}

	public void answeraquestion(String Ques, String sectionName) {
		testStepsLog("Step " + (stepCount++), " Click on the answer button for question " + Ques);
		WebElement answerButton = driver.findElement(
				By.xpath("//th[contains(text(),'" + sectionName + "')]/../../..//tr//span[normalize-space()='" + Ques
						+ "']/../../..//span[contains(@ng-if,'response_answer')]//button"));
		scrollToElementTillTrue(answerButton);
		jsClick(answerButton);
		testStepsLog("Step " + (stepCount++), " Give answer.");
		giveAnswer("Answer for" + Ques);
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");

		PresenceOfElement(By.xpath("//button[contains(text(),'Submit')]"));
		clickableElement(driver.findElement(By.xpath("//button[contains(text(),'Submit')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Submit')]")));

	}

	public void answeraquestion(String Ques, String sectionName, String vName) {
		testStepsLog("Step " + (stepCount++), " Click on the answer button for question " + Ques);
		WebElement answerButton = driver.findElement(
				By.xpath("//th[contains(text(),'" + sectionName + "')]/../../..//tr//span[normalize-space()='" + Ques
						+ "']/../../..//span[contains(@ng-if,'response_answer')]//button"));
		scrollToElementTillTrue(answerButton);
		jsClick(answerButton);
		testStepsLog("Step " + (stepCount++), " Give answer.");

		giveAnswer(vName + " Answer for" + Ques);
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");

		PresenceOfElement(By.xpath("//button[contains(text(),'Submit')]"));
		clickableElement(driver.findElement(By.xpath("//button[contains(text(),'Submit')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Submit')]")));

	}

	public RFPVerificationPage gotoRatingTab(String question) {
		pause(5);
		PresenceOfElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../following-sibling::tr//md-tab-item[contains(text(),'Rating')]"));
		clickableElement(driver.findElement(By.xpath("//div//span[contains(text(),'" + question
				+ "')]//..//..//../following-sibling::tr//md-tab-item[contains(text(),'Rating')]")));
		jsClick(driver.findElement(By.xpath("//div//span[contains(text(),'" + question
				+ "')]//..//..//../following-sibling::tr//md-tab-item[contains(text(),'Rating')]")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage giveRatingsToQuestions(String numberofStars, String question, String vendor) {
		pause(5);
		PresenceOfElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../following-sibling::tr[1]//div//tbody//td[normalize-space()='" + vendor
				+ "']/..//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a[" + numberofStars
				+ "]/i"));
		clickableElement(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../following-sibling::tr[1]//div//tbody//td[normalize-space()='" + vendor
				+ "']/..//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a[" + numberofStars
				+ "]/i")));
		jsClick(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../following-sibling::tr[1]//div//tbody//td[normalize-space()='" + vendor
				+ "']/..//div[@class='jk-rating-stars-container ng-isolate-scope layout-row']//a[" + numberofStars
				+ "]/i")));
		return new RFPVerificationPage();
	}

	public RFPVerificationPage clickSaveAllButton(String question) {
		pause(5);
		PresenceOfElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../following-sibling::tr//div//button[contains(text(),'Save All')]"));
		clickableElement(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../following-sibling::tr//div//button[contains(text(),'Save All')]")));
		jsClick(driver.findElement(By.xpath("//md-content//div/span[contains(text(),'" + question
				+ "')]/../../../following-sibling::tr//div//button[contains(text(),'Save All')]")));
		return new RFPVerificationPage();
	}

	public void stpcnt() {
		System.out.println("stepCount : " + stepCount++);

	}
}
