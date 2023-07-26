package com.green.rfp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.green.rfp.qa.base.BaseClass;

public class ForgotPasswordPage extends BaseClass {


	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/forgot-password']")
	WebElement btn_forgot_password;

	public void clickOnForgotPasswordLink() {
		PresenceOfElement(By.xpath("//a[@href='/forgot-password']"));
		clickableElement(btn_forgot_password);
		jsClick( btn_forgot_password);
	}

	@FindBy(xpath = "//button[contains(text(),'SEND RESET LINK')]")
	WebElement btn_resent_link;

	public boolean verifyResetLinkBtnDisabled() {

		pause(2);

		return (!btn_resent_link.isEnabled());
	}

	public void clickOnResetLink() {
		PresenceOfElement(By.xpath("//button[contains(text(),'SEND RESET LINK')]"));
		clickableElement(btn_resent_link);
		jsClick( btn_resent_link);
	}
}
