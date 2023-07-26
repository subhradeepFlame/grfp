package com.green.rfp.qa.pages;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.green.rfp.qa.base.BaseClass;

public class MyProfilePage extends BaseClass {
	// WebDriver driver;
	@FindBy(css = "md-menu-bar#user-menu>md-menu>button>div>div>img")
	WebElement btn_my_profile_menu;

	@FindBy(xpath = "(//button[@role='menuitem'])[1]")
	WebElement btn_my_profile;

	@FindBy(name = "title")
	WebElement txt_title;

	@FindBy(name = "first_name")
	WebElement txt_first_name;

	@FindBy(name = "last_name")
	WebElement txt_last_name;

	@FindBy(name = "phone")
	WebElement txt_phone;

	@FindBy(name = "email")
	WebElement txt_email;

	@FindBy(xpath = "(//a[@href='/myaccount/dashboard'])[2]")
	WebElement btn_cancel;

	@FindBy(xpath = "(//button[text()='Update'])[1]")
	WebElement btn_update;

	@FindBy(xpath = "//*[text()='Dashboard']")
	WebElement btn_dashboard;

	@FindBy(xpath = "(//*[text()='Change Password'])[1]")
	WebElement btn_change_password;

	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(name = "passwordConfirm")
	WebElement txt_password_confirm;

	@FindBy(xpath = "//*[text()='Cancel']")
	WebElement btn_password_cancel;

	@FindBy(css = "form#setPasswordForm>md-dialog-actions>button:nth-of-type(2)")
	WebElement btn_password_update;

	@FindBy(xpath = "//button[text()='SKIP']")
	WebElement btn_skip;

	public MyProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyProfileMenu() {
		waitForElement( btn_my_profile_menu);
		clickOn(btn_my_profile_menu);
	}

	public void clickOnMyProfile() {
		waitForElement( btn_my_profile);
		clickOn(btn_my_profile);
	}

	public void clearTitleText() {
		waitforElementClickable( btn_update, 30);
		txt_title.clear();

	}

	public void enterTitle() {
		waitForElement( txt_title);
		pause(2);
		txt_title.sendKeys("Admin");
	}

	public void clearFirstName() {
		waitForElement( txt_first_name);
		txt_first_name.clear();
	}

	public void enterFirstName() {
		waitForElement( txt_first_name);
		pause(2);
		txt_first_name.sendKeys("Shaishav");
	}

	public void clearLastName() {
		waitForElement( txt_last_name);
		txt_last_name.clear();
	}

	public void enterLastName() {
		waitForElement( txt_last_name);
		pause(3);
		txt_last_name.sendKeys("N");
	}

	public void clearPhone() {
		waitForElement( txt_phone);
		txt_phone.clear();
	}

	public void enterPhone() {
		waitForElement( txt_phone);
		pause(3);
		txt_phone.sendKeys("1234567890");
	}

	public void clearEmail() {
		waitForElement( txt_email);
		txt_email.clear();
	}

	public void clickOnCancelButton() {
		waitForElement( btn_cancel);
		clickOn(btn_cancel);
	}

	public void clickOnUpdate() {
		waitforElementClickable( btn_update, 30);
		clickOn(btn_update);

	}

	public boolean verifyUpdateButtonDisabled() {

		pause(2);
		System.out.println(!btn_update.isEnabled());
		return (!btn_update.isEnabled());

	}

	public void clickOnChangePassword() {
		waitForElement( btn_change_password);
		clickOn(btn_change_password);
	}

	public void enterPassword(String pass) {
		waitForElement( txt_password);
		txt_password.clear();
		txt_password.sendKeys(pass);
	}

	public void enterPasswordConfirmation(String passC) {
		waitForElement( txt_password_confirm);
		txt_password_confirm.clear();
		txt_password_confirm.sendKeys(passC);
	}


	public boolean verifyPasswordUpdateButtonDisabled() {

		pause(2);
		System.out.println(!btn_password_update.isEnabled());
		return (!btn_password_update.isEnabled());

	}


	public void uploadPhoto() throws AWTException {
		pause(3);
		Actions actions = new Actions(driver);
		pause(3);
		actions.moveToElement(driver.findElement(By.xpath("//img[@class='add-file-button']"))).perform();
		PresenceOfElement(By.xpath("//md-icon[@md-font-icon='icon-pencil']"));
		String dataFilePath = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/nature.jpg";
		WebElement editIcon= driver.findElement(By.xpath("//md-icon[@md-font-icon='icon-pencil']//input"));
		editIcon.sendKeys(dataFilePath);
		PresenceOfElement(By.xpath("//span[contains(text(),'success')]"));
		testVerifyLog("success message verified");
	}

	public void inValidFormatuploadPhoto() throws AWTException {
		pause(3);
		Actions actions = new Actions(driver);
		pause(3);
		actions.moveToElement(driver.findElement(By.xpath("//img[@class='add-file-button']"))).perform();
		PresenceOfElement(By.xpath("//md-icon[@md-font-icon='icon-pencil']"));
		String dataFilePath = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/login.xlsx";
		WebElement editIcon= driver.findElement(By.xpath("//md-icon[@md-font-icon='icon-pencil']//input"));
		editIcon.sendKeys(dataFilePath);
		PresenceOfElement(By.xpath("//span[contains(text(),'Please upload image of PNG or JPG or JPEG')]"));
		testVerifyLog("error message verified");

	}

}
