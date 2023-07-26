package com.green.rfp.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.green.rfp.qa.base.BaseClass;

public class AdministrationPage extends BaseClass {

	public AdministrationPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[text()='Administration'])[1]")
	WebElement btn_administration;

	public void clickOnAdmnitrationLink() {
		scrollToElement(btn_administration);
		PresenceOfElement(By.xpath("(//*[text()='Administration'])[1]"));
		clickableElement(btn_administration);
		jsClick(btn_administration);
	}

	@FindBy(xpath = "//md-tab-item[contains(.,'COMPANY')]")
	WebElement btn_company;

	public void clickOnCompanyTab() {
		PresenceOfElement(By.xpath("//md-tab-item[contains(.,'COMPANY')]"));
		clickableElement(btn_company);
		jsClick(btn_company);

	}

	@FindBy(xpath = "//button[contains(text(),'Edit Company Profile')]")
	WebElement btn_edit__company_Profile;

	public void clickOnEditProfile() {

		pause(3);
		scrollToElement(btn_edit__company_Profile);
		PresenceOfElement(By.xpath("//button[contains(text(),'Edit Company Profile')]"));
		clickableElement(btn_edit__company_Profile);
		jsClick(btn_edit__company_Profile);
	}

	@FindBy(xpath = "(//label[text()='Alternate Phone No']/following::input)[1]")
	WebElement txt_edit_Phone;

	public void editPhoneNumber(String phonenumber) {

		pause(3);
		scrollToElement(txt_edit_Phone);
		pause(3);
		driver.findElement(By.xpath("(//label[text()='Alternate Phone No']/following::input)[1]")).clear();
		driver.findElement(By.xpath("(//label[text()='Alternate Phone No']/following::input)[1]"))
				.sendKeys(phonenumber);
		pause(3);
		jsClick(driver.findElement(By.xpath("//button[text()='SAVE']")));

	}

	@FindBy(xpath = "(//button[@ng-if='vm.edit_enabled'])[2]")
	WebElement btn_save;

	public void clickSavebutton() {
		pause(7);
		PresenceOfElement(By.xpath("(//button[@ng-if='vm.edit_enabled'])[2]"));
		clickableElement(btn_save);
		clickOn(btn_save);
	}

	// User Tab
	@FindBy(xpath = "//md-tab-item[text()='USERS']")
	WebElement btn_users_tab;

	public void clickOnUsersTab() {
		pause(5);
		scrollToElement(btn_users_tab);
		PresenceOfElement(By.xpath("//md-tab-item[text()='USERS']"));
		clickableElement(btn_users_tab);
		jsClick(btn_users_tab);

	}

	@FindBy(xpath = "//button[text()='Create']")
	WebElement btn_create;

	public void clickOnCreatebtn() {
		pause(5);
		PresenceOfElement(By.xpath("//button[text()='Create']"));
		clickableElement(btn_create);
		jsClick(btn_create);

	}

	@FindBy(xpath = "//input[@ng-model='vm.user_first_name']")
	WebElement txt_first_name;
	@FindBy(xpath = "//input[@ng-model='vm.user_last_name']")
	WebElement txt_last_name;
	@FindBy(xpath = "//input[@ng-model='vm.user_email']")
	WebElement txt_user_mailid;
	@FindBy(xpath = "//input[@ng-model='vm.user_title']")
	WebElement txt_title;
	@FindBy(xpath = "//button[@ng-disabled='newuserform.$invalid']")
	WebElement btn_savee;

	public void enterUserdetails(String firstName, String lastName, String userMailId, String role, String title) {
		pause(5);
		txt_first_name.sendKeys(firstName);
		txt_last_name.sendKeys(lastName);
		scrollToElement(txt_user_mailid);
		txt_user_mailid.sendKeys(userMailId);

		PresenceOfElement(By.xpath("//md-select[@ng-model='vm.user_role']"));
		clickableElement(driver.findElement(By.xpath("//md-select[@ng-model='vm.user_role']")));
		jsClick(driver.findElement(By.xpath("//md-select[@ng-model='vm.user_role']")));

		PresenceOfElement(By.xpath("//button[text()='Create']"));
		clickableElement(driver.findElement(By.xpath("//md-option//div[text()='" + role + "']")));
		jsClick(driver.findElement(By.xpath("//md-option//div[text()='" + role + "']")));

		PresenceOfElement(By.xpath("//input[@ng-model='vm.user_title']"));
		txt_title.sendKeys(title);

		PresenceOfElement(By.xpath("//button[@ng-disabled='newuserform.$invalid']"));
		clickableElement(btn_savee);
		jsClick(btn_savee);
		pause(5);

	}

	public void clickOnDots() {

		pause(2);
		PresenceOfElement(By.xpath("(//md-icon[@md-font-icon='icon-dots-vertical'])[1]"));
		driver.findElement(By.xpath("(//md-icon[@md-font-icon='icon-dots-vertical'])[1]")).click();
		pause(2);
	}

	public void contentClickOnDotsOptions(String option) {

		clickableElement(driver.findElement(By.xpath("//button//span[normalize-space()='" + option + "']")));
		jsClick(driver.findElement(By.xpath("//button//span[normalize-space()='" + option + "']")));
	}

	public boolean verifyChecbox(String checkboxName) {

		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'" + checkboxName + "')]")));
		PresenceOfElement(By.xpath("//div[contains(text(),'" + checkboxName + "')]"));
		return driver.findElement(By.xpath("//div[contains(text(),'" + checkboxName + "')]")).isDisplayed();
	}

	public boolean verifyKISChecbox(String checkboxName) {

		scrollToElement(driver.findElement(By.xpath("//div[@class='ml-5' and contains(.,'" + checkboxName + "')]")));
		PresenceOfElement(By.xpath("//div[@class='ml-5' and contains(.,'" + checkboxName + "')]"));
		return driver.findElement(By.xpath("//div[@class='ml-5' and contains(.,'" + checkboxName + "')]"))
				.isDisplayed();
	}

	public boolean verifyEditCompanyProfileBtn() {

		scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Edit Company Profile')]")));
		PresenceOfElement(By.xpath("//button[contains(text(),'Edit Company Profile')]"));
		return driver.findElement(By.xpath("//button[contains(text(),'Edit Company Profile')]")).isDisplayed();
	}

	public boolean verifyUser(String userFirstname, String userLastname, String emailId, String group) {

		pause(2);
		return driver.findElement(By.xpath("//a[contains(text(),'" + userFirstname + "')]")).isDisplayed()
				&& driver.findElement(By.xpath("//a[contains(text(),'" + userLastname + "')]")).isDisplayed();
	}

	public boolean verifyEditUser(String userFirstname, String userLastname, String emailId, String group) {

		pause(2);
		return driver.findElement(By.xpath("//a[contains(text(),'" + userFirstname + "')]")).isDisplayed()
				&& driver.findElement(By.xpath("//a[contains(text(),'" + userLastname + "')]")).isDisplayed();
	}

	public boolean verifyEditAndDeleteBtn() {

		pause(2);
		return driver.findElement(By.xpath("(//span[contains(text(),'Edit')])[5]")).isDisplayed();
	}

	@FindBy(xpath = "(//button[text()='Save'])[2]")
	WebElement btn_saved;

	public boolean verifySaveButtonDisabled() {

		pause(2);
		System.out.println(!btn_saved.isEnabled());
		return (!btn_saved.isEnabled());

	}

	public boolean verifySearchEditAndDeleteBtn() {

		pause(2);
		return driver.findElement(By.xpath("//span[@translate='Edit']")).isDisplayed()
				&& driver.findElement(By.xpath("//span[@translate='Delete']")).isDisplayed();
	}

	public void clickOnEditTab() {

		pause(3);

		PresenceOfElement(By.xpath("(//span[contains(text(),'Edit')])[5]"));
		clickableElement(driver.findElement(By.xpath("(//span[contains(text(),'Edit')])[5]")));
		jsClick(driver.findElement(By.xpath("(//span[contains(text(),'Edit')])[5]")));

	}

	@FindBy(xpath = "//button[@ng-click='vm.updateUser()']")
	WebElement btn_saveBtn;

	public void editFirstName(String firstName) {
		pause(5);
		txt_edit_first_name.clear();
		txt_edit_first_name.sendKeys(firstName);

		PresenceOfElement(By.xpath("//button[@ng-click='vm.updateUser()']"));
		clickableElement(btn_saveBtn);
		// jsClick( btn_save);
		btn_saveBtn.click();
		pause(3);

	}

	@FindBy(xpath = "(//button[text()='Cancel'])[4]")
	WebElement btn_cancel;

	public void clickOnCancelButton() {
		PresenceOfElement(By.xpath("(//button[text()='Cancel'])[4]"));
		clickableElement(driver.findElement(By.xpath("(//button[text()='Cancel'])[4]")));
		jsClick(driver.findElement(By.xpath("(//button[text()='Cancel'])[4]")));
	}

	public void clickYesButtonOfAlert() {
		PresenceOfElement(By.xpath("//button[@md-autofocus]"));
		clickableElement(driver.findElement(By.xpath("//button[@md-autofocus]")));
		jsClick(driver.findElement(By.xpath("//button[@md-autofocus]")));

	}

	public void clickOnUseAssocialtion() {

		pause(2);

		PresenceOfElement(
				By.xpath("(//md-radio-button[@ng-repeat='new_user_assignment in vm.new_user_assignment_array'])[1]"));
		clickableElement(driver.findElement(
				By.xpath("(//md-radio-button[@ng-repeat='new_user_assignment in vm.new_user_assignment_array'])[1]")));
		jsClick(driver.findElement(
				By.xpath("(//md-radio-button[@ng-repeat='new_user_assignment in vm.new_user_assignment_array'])[1]")));

	}

	@FindBy(xpath = "(//button[text()='Assign'])[2]")
	WebElement btn_assign;

	public void clickOnAssign() {
		pause(2);

		PresenceOfElement(By.xpath("(//button[text()='Assign'])[2]"));
		clickableElement(driver.findElement(By.xpath("(//button[text()='Assign'])[2]")));
		jsClick(driver.findElement(By.xpath("(//button[text()='Assign'])[2]")));
	}
	public boolean verifyEditEmail(String changeEmailID) {
		pause(3);
		PresenceOfElement(By.xpath("//span[text()[normalize-space()='" + changeEmailID + "']]"));
		return driver.findElement(By.xpath("//span[text()[normalize-space()='" + changeEmailID + "']]")).isDisplayed();
	}

	public boolean verifyActiveRFP(String rfpName) {
		pause(3);
		PresenceOfElement(By.xpath("//table/tbody/tr[@class='ng-scope']/td/a[contains(.,'" + rfpName + "')]"));
		return driver.findElement(By.xpath("//table/tbody/tr[@class='ng-scope']/td/a[contains(.,'" + rfpName + "')]"))
				.isDisplayed();
	}

	public boolean verifyChangesInPopup(String Discription) {
		pause(3);
		boolean flag = false;
		List<WebElement> el = driver.findElements(By.xpath("//p[contains(.,'" + Discription + "')]"));
		int count = el.size();
		if (count == 1) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	@FindBy(xpath = "//span[text()[normalize-space()='Updated Rfp']]")
	WebElement CreateLabel;
	@FindBy(xpath = "(//md-icon[@md-font-icon='icon-eye'])[1]")
	WebElement ViewChangeIcon;

	public boolean verifyCreateLabel() {
		boolean flag = CreateLabel.isDisplayed();
		return flag;
	}

	@FindBy(xpath = "(//label[@class='md-green-600-bg label ng-scope'])[1]")
	WebElement UpdateLabel;

	public boolean verifyUpdateLabel() {
		boolean flag = UpdateLabel.isDisplayed();
		return flag;
	}

	public boolean verifyErrorMessage(String message) {

		PresenceOfElement(By.xpath("//span[contains(text(),'" + message + "')]"));
		return driver.findElement(By.xpath("//span[contains(text(),'" + message + "')]")).isDisplayed();

	}

	@FindBy(xpath = "//*[@ng-model='vm.edit_user_first_name']")
	WebElement txt_edit_first_name;

	public void removeFirstNameValue() {
		txt_edit_first_name.clear();
	}

	@FindBy(xpath = "//*[@ng-model='vm.edit_user_last_name']")
	WebElement txt_edit_last_name;

	public void removeLastNameValue() {
		txt_edit_last_name.clear();
	}

	@FindBy(xpath = "//*[@ng-model='vm.edit_user_email']")
	WebElement txt_edit_email;

	public void removeEmail() {
		txt_edit_email.clear();
	}

	@FindBy(xpath = "//*[@ng-model='vm.edit_user_title']")
	WebElement txt_edit_title;

	public void clearTitle() {
		txt_edit_title.clear();
	}

	@FindBy(xpath = "(//md-select-value[@class='md-select-value']//span)[1]")
	WebElement pagignation;
	@FindBy(xpath = "(//md-option[@value='100'])[3]")
	WebElement pagignation_value;
	@FindBy(xpath = "//iframe[@tabindex='0']")
	WebElement frame;
	@FindBy(xpath = "//button[@ng-click='vm.updateRfp(false)']")
	WebElement SaveBtn;

	public void changeValueInDiscription(String description) {

		driver.switchTo().frame(frame);
		PresenceOfElement(By.xpath("//html/body[@contenteditable='true']"));
		driver.findElement(By.xpath("//html/body[@contenteditable='true']")).clear();
		enterDataIn(driver.findElement(By.xpath("//html/body[@contenteditable='true']")), description);
		driver.switchTo().defaultContent();
		PresenceOfElement(By.xpath("//button[@ng-click='vm.updateRfp(false)']"));
		jsClick(SaveBtn);

	}

	@FindBy(xpath = "//md-tab-item[contains(.,'ACTIVE RFPs')]")
	WebElement ActiveRFPTab;

	public void clickOnActiveRFPTab() {

		PresenceOfElement(By.xpath("//md-tab-item[contains(.,'ACTIVE RFPs')]"));
		clickableElement(ActiveRFPTab);
		jsClick(ActiveRFPTab);

	}

	@FindBy(xpath = "//md-tab-item[contains(.,'CHANGE LOG')]")
	WebElement changeLogTab;

	public void clickOnChangeLogTab() {

		PresenceOfElement(By.xpath("//md-tab-item[contains(.,'CHANGE LOG')]"));
		clickableElement(changeLogTab);
		jsClick(changeLogTab);

	}

	@FindBy(xpath = "(//md-icon[@md-font-icon='icon-eye'])[1]")
	WebElement viewChangeIcon;

	public void clickOnViewChangeIconAtFirstRow() {

		PresenceOfElement(By.xpath("(//md-icon[@md-font-icon='icon-eye'])[1]"));
		clickableElement(viewChangeIcon);
		jsClick(viewChangeIcon);

	}

	@FindBy(xpath = "//*[text()='Got It']")
	WebElement btn_gotit;

	public void clickOnGotIt() {
		scrollToElement(btn_administration);
		PresenceOfElement(By.xpath("//*[text()='Got It']"));
		clickableElement(btn_gotit);
		jsClick(btn_gotit);
	}

	@FindBy(xpath = "//md-tab-item[contains(.,'REPORTS')]")
	WebElement ReportTab;

	public void clickOnReportsab() {

		PresenceOfElement(By.xpath("//md-tab-item[contains(.,'REPORTS')]"));
		clickableElement(ReportTab);
		jsClick(ReportTab);

	}

	public void rfpDetailsCount() {

		scrollToElement(driver.findElement(By.xpath("//*[text()='RFPs']")));
		pause(3);
		List<WebElement> rfpsCount = driver.findElements(By.xpath(
				"//*[@class='ph-16 pv-24 border-bottom layout-column']//*[contains(text(),'RFPs')]/../..//following-sibling::tr[@ng-repeat='(key, value) in vm.rfp_data']"));
		int size = rfpsCount.size();
		for (int i = 0; i < size; i++) {
			String text = rfpsCount.get(i).getText();
			System.out.println(text + "\n");
			pause(3);
		}
	}

	public void templateDetailsCount() {

		scrollToElement(driver.findElement(By.xpath("//div[text()='Templates']")));
		pause(3);
		List<WebElement> templateCount = driver.findElements(By.xpath(
				"//*[@class='ph-16 pv-24 border-bottom layout-column']//*[contains(text(),'Templates')]/../..//following-sibling::tr[@ng-repeat='(key, value) in vm.template_data']"));
		int size = templateCount.size();
		for (int i = 0; i < size; i++) {
			String text = templateCount.get(i).getText();
			System.out.println(text + "\n");
			pause(3);
		}

	}

	public void tasksDetailsCount() {

		scrollToElement(driver.findElement(By.xpath("//div[text()='Tasks']")));
		pause(3);
		List<WebElement> tasksCount = driver.findElements(By.xpath(
				"//*[@class='ph-16 pv-24 border-bottom layout-column']//*[contains(text(),'Tasks')]/../..//following-sibling::tr[@ng-repeat='(key, value) in vm.task_data']"));
		int size = tasksCount.size();
		for (int i = 0; i < size; i++) {
			String text = tasksCount.get(i).getText();
			System.out.println(text + "\n");
			pause(3);
		}

	}

	@FindBy(xpath = "//*[@ng-click='usersearchhtmltoggle()']")
	WebElement search;
	@FindBy(xpath = "//input[@data-ng-model='vm.search_user']")
	WebElement searchUser;

	public void clickOnSearchIcon() {
		PresenceOfElement(By.xpath("//*[@ng-click='usersearchhtmltoggle()']"));
		clickableElement(search);
		jsClick(search);
		pause(5);

	}

	public void searchUser(String enterInput) {
		PresenceOfElement(By.xpath("//input[@data-ng-model='vm.search_user']"));
		type(searchUser, enterInput);
		pause(5);
		List<WebElement> result = driver.findElements(By.xpath("//*[@ng-repeat='(field, val) in vm.data.user']"));
		int size = result.size();
		for (int i = 0; i < size; i++) {
			String resultText = result.get(i).getText();
			System.out.println(resultText);
		}

	}

	public void inValidsearchUser(String enterInput) {
		PresenceOfElement(By.xpath("//input[@data-ng-model='vm.search_user']"));
		driver.findElement(By.xpath("//input[@data-ng-model='vm.search_user']")).sendKeys(enterInput);
		pause(3);

	}

	public boolean verifySearchUserIsDiaplay() {
		pause(3);
		boolean bool = false;
		if (visibilityOfElementLocated(By.xpath("//*[@ng-repeat='(field, val) in vm.data.user']"))) {
			bool = true;
		}
		return bool;
	}

	public boolean verifyNoUserFoundMessageDisplays() {
		pause(5);
		System.out.println(driver.findElement(By.xpath("(//div[text()='No Data Found'])[1]")).getText());
		return driver.findElement(By.xpath("(//div[text()='No Data Found'])[1]")).getText().contains("NO DATA FOUND");

	}

	public void userAccountText(String user, String account) {
		PresenceOfElement(
				By.xpath("//a[contains(text(),'" + user + "')]/../../../..//*[contains(text(),'" + account + "')]"));

		WebElement accountText = driver.findElement(
				By.xpath("//a[contains(text(),'" + user + "')]/../../../..//*[contains(text(),'" + account + "')]"));

		String actualAccountText = accountText.getText();
		System.out.println("Actual account text is ====>" + actualAccountText);

	}

	public boolean verifyUserAccountText(String user, String account) {
		pause(5);
		PresenceOfElement(
				By.xpath("//a[contains(text(),'" + user + "')]/../../../..//*[contains(text(),'" + account + "')]"));

		WebElement accountText = driver.findElement(
				By.xpath("//a[contains(text(),'" + user + "')]/../../../..//*[contains(text(),'" + account + "')]"));

		String actualAccountText = accountText.getText();
		System.out.println("Actual account text is ====>" + actualAccountText);

		return driver
				.findElement(By.xpath(
						"//a[contains(text(),'" + user + "')]/../../../..//*[contains(text(),'" + account + "')]"))
				.getText().contains(account);

	}

	public void clickOnSearchEditTab() {
		pause(3);
		PresenceOfElement(By.xpath("//span[@translate='Edit']"));
		clickableElement(driver.findElement(By.xpath("//span[@translate='Edit']")));
		jsClick(driver.findElement(By.xpath("//span[@translate='Edit']")));

	}

	public void clickSearchDeletetab() {
		PresenceOfElement(By.xpath("//span[@translate='Delete']"));
		clickableElement(driver.findElement(By.xpath("//span[@translate='Delete']")));
		jsClick(driver.findElement(By.xpath("//span[@translate='Delete']")));

	}
}
