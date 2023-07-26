package com.green.rfp.qa.pages;

import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.green.rfp.qa.base.BaseClass;

public class RFPVerificationPage extends BaseClass {

	public RFPVerificationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPDFDownloaded(String expectedURL) {

		boolean status = false;
		try {

			URL link = new URL(expectedURL.replace("_", "-"));
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			if (httpConn.getResponseCode() == 200) {
				status = true;
			}

		} catch (Exception e) {
		}
		Assert.assertTrue(status);
		SwitchtoTab(0);
		return status;
	}

	public boolean verifyErrorMessage(String message) {
		PresenceOfElement(By.xpath("//span[contains(text(),'" + message + "')]"));
		return driver.findElement(By.xpath("//span[contains(text(),'" + message + "')]")).isDisplayed();
	}

	public boolean verifyclarificationIcon(String vsme) {

		PresenceOfElement(By.xpath("//md-content//tr[1]/td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../..//img[@alt='clarification']"));
		return driver.findElement(By.xpath("//md-content//tr[1]/td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../..//img[@alt='clarification']")).isDisplayed();
	}

	public boolean downArrowDisplay(String vsme) {

		PresenceOfElement(By.xpath("//md-content//tr[1]/td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../..//md-icon[@md-font-icon='icon-chevron-down']"));
		return driver.findElement(By.xpath("//md-content//tr[1]/td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../..//md-icon[@md-font-icon='icon-chevron-down']")).isDisplayed();
	}

	public boolean verifyClarificationNotificationformMessagecenter(String rfpName, String notificationStatus) {
		pause(3);
		List<WebElement> notification = driver.findElements(By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/a"));
		PresenceOfElement(
				By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/text()[1]/../../../../td[3]//label[contains(text(),'"
						+ notificationStatus + "')]"));
		WebElement Status = driver.findElement(
				By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/text()[1]/../../../../td[3]//label[contains(text(),'"
						+ notificationStatus + "')]"));

		return notification.get(0).getText().equals(rfpName) && Status.isDisplayed();

	}

	public boolean verifyClarificationisDisplayed(String clarification) {

		PresenceOfElement(By.xpath("//tr[@ng-repeat='clarification in question.clarification']//div[contains(text(),'"
				+ clarification + "')]/../../td[5]/span/button[contains(text(),'Reply')]"));
		scrollToElement(driver.findElement(
				By.xpath("//tr[@ng-repeat='clarification in question.clarification']//div[contains(text(),'"
						+ clarification + "')]/../../td[5]/span/button[contains(text(),'Reply')]")));
		return driver
				.findElement(
						By.xpath("//tr[@ng-repeat='clarification in question.clarification']//div[contains(text(),'"
								+ clarification + "')]/../../td[5]/span/button[contains(text(),'Reply')]"))
				.isDisplayed();
	}

	public boolean verifyDisplayatReportsTab(String rfpName) {

		PresenceOfElement(By.xpath("//h3/a[contains(text(),'" + rfpName + "')]"));
		WebElement Status = driver.findElement(By.xpath("//h3/a[contains(text(),'" + rfpName + "')]"));
		return Status.isDisplayed();

	}

	public boolean verifyChartIsDisplayed(String chartName) {
		PresenceOfElement(By.xpath("//*[@id='" + chartName + "']"));
		return driver.findElement(By.xpath("//*[@id='" + chartName + "']")).isDisplayed();
	}

	public boolean verifyDeleteChartIconIsDisplayed(String st) {
		pause(5);
		PresenceOfElement(
				By.xpath("//md-tab-item[contains(text(),'" + st + "')]//md-icon[@aria-label='Delete Graph']"));
		return driver
				.findElement(
						By.xpath("//md-tab-item[contains(text(),'" + st + "')]//md-icon[@aria-label='Delete Graph']"))
				.isDisplayed();
	}

	public boolean verifyDiagramDisplayAtReportsTab() {
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'Company Implementation Diagram')]")));
		PresenceOfElement(By.xpath("//div[contains(text(),'Company Implementation Diagram')]"));
		return visibilityOfElementLocated(By.xpath("//div[contains(text(),'December.png')]"));
	}

	public boolean verifyRFPTemplateOptionIsDisabled(String Option) {
		Boolean bool;
		PresenceOfElement(By.xpath("//md-radio-button[contains(@aria-label,'" + Option + "')]"));
		if (driver.findElement(By.xpath("//md-radio-button[contains(@aria-label,'" + Option + "')]")).isEnabled()) {
			bool = false;
		} else {
			bool = true;
		}
		return bool;
	}

	@FindBy(xpath = "//div[contains(text(),'Login to your account')]")
	WebElement loginScreen;

	public boolean verifyLoginScreenPresent() {
		PresenceOfElement(By.xpath("//div[contains(text(),'Login to your account')]"));
		clickableElement(loginScreen);
		pause(2);
		return loginScreen.isDisplayed();
	}

	public boolean sectionPercentageBtnIsDisplayed() {
		PresenceOfElement(By.xpath("//button[contains(text(),'Section Percentage')]"));
		return driver.findElement(By.xpath("//button[contains(text(),'Section Percentage')]")).isDisplayed();
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

	public boolean verifySectionsDisplay(String questionName, String sectionOne, String sectionTwo,
			String sectionThree) {
		PresenceOfElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../..//md-tab-item[contains(text(),'" + sectionOne + "')]"));
		PresenceOfElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../..//md-tab-item[contains(text(),'" + sectionTwo + "')]"));
		PresenceOfElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../..//md-tab-item[contains(text(),'" + sectionThree + "')]"));
		return driver
				.findElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
						+ "')]/../../../..//md-tab-item[contains(text(),'" + sectionOne + "')]"))
				.isDisplayed()
				&& driver.findElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
						+ "')]/../../../..//md-tab-item[contains(text(),'" + sectionTwo + "')]")).isDisplayed()
				&& driver
						.findElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
								+ "')]/../../../..//md-tab-item[contains(text(),'" + sectionThree + "')]"))
						.isDisplayed();
	}

	public boolean verifySectionAdded(String sectionName) {
		PresenceOfElement(By.xpath("//span[contains(text(),'" + sectionName + "')]"));
		return driver.findElement(By.xpath("//span[contains(text(),'" + sectionName + "')]")).isDisplayed();
	}

	public boolean verifyDownArrow(String questionName) {
		PresenceOfElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../td[5]//md-icon[@md-font-icon='icon-chevron-down']"));
		return driver.findElement(By.xpath("//tr//td[1]//span[contains(text(),'" + questionName
				+ "')]/../../../td[5]//md-icon[@md-font-icon='icon-chevron-down']")).isDisplayed();
	}

	public boolean verifyDeleteIconDisplay(String sectionName) {
		PresenceOfElement(By
				.xpath("//span[contains(text(),'" + sectionName + "')]/../../..//md-icon[@md-font-icon='icon-trash']"));
		return driver
				.findElement(By.xpath(
						"//span[contains(text(),'" + sectionName + "')]/../../..//md-icon[@md-font-icon='icon-trash']"))
				.isDisplayed();

	}

	public boolean verifyStartanAmendmentBtnEnabled() {
		PresenceOfElement(By.xpath("//button[contains(text(),'Start an amendment')]"));
		return driver.findElement(By.xpath("//button[contains(text(),'Start an amendment')]")).isDisplayed();
	}

	@FindBy(xpath = "//button[contains(text(),'Publish amendment')]")
	WebElement publishBtn;
	@FindBy(xpath = "//button[contains(text(),'Discard changes')]")
	WebElement discardBtn;

	public boolean verifyPublishAndDiscardBtnEnabled() {
		PresenceOfElement(By.xpath("//button[contains(text(),'Publish amendment')]"));
		PresenceOfElement(By.xpath("//button[contains(text(),'Discard changes')]"));
		return publishBtn.isDisplayed() & publishBtn.isEnabled() & discardBtn.isDisplayed() & discardBtn.isEnabled();
	}

	@FindBy(xpath = "//div[contains(text(),'New Section')]")
	WebElement newSection;

	public boolean verifyNewAddedSectionDisplayed(String sectionname) {
		PresenceOfElement(By.xpath("//div[contains(text(),'" + sectionname + "')]"));
		return driver.findElement(By.xpath("//div[contains(text(),'" + sectionname + "')]")).isDisplayed();
	}

	public boolean verifyApproverTask() {
		pause(2);
		boolean bool = false;
		if (visibilityOfElementLocated(By.xpath(
				"//a[@title='Go to RFP'][contains(text(),'\"+rfpName+\"')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']")))
			;
		{
			bool = true;
		}

		return bool;
	}

	public boolean verifyNewlyAddedSectionNotDisplayed(String sectionName) {
		return invisibilityOfElementLocated(By.xpath("//span[contains(text(),'" + sectionName + "')]"), 7);
	}

	public boolean verifyTimeZoneUpdated(String timeZone) {
		pause(3);
		WebElement time = driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']"));
		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']"));
		WebElement Status = driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']"));

		return time.getText().equals(timeZone) && Status.isDisplayed();
	}

	public boolean verifySaveAllButtonIsDisplay(String question) {
		return driver
				.findElement(
						By.xpath("//md-content//div/span[contains(text(),'" + question + "')]//following::button[3]"))
				.isDisplayed();
	}

	public boolean verifyDelegantRfpTaskNotDisplayed(String description, String rfpName) {
		return invisibilityOfElementLocated(By.xpath(
				"//a[contains(text(),'" + description + "')]/ancestor::tr//a[contains(text(),'" + rfpName + "')]"), 7);

	}

	public boolean verifyclarificationIconNot(String vsme) {

		return invisibilityOfElementLocated(By.xpath("//md-content//tr[1]/td[2]/div/span[contains(text(),'" + vsme
				+ "')]/../../../..//img[@alt='clarification']"), 7);

	}

}
