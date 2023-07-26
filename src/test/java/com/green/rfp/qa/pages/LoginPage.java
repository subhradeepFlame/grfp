package com.green.rfp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class LoginPage extends BaseClass {
	//public WebDriver driver;
	TestUtil testutil = new TestUtil();

	@FindBy(name = "email")
	WebElement txt_email;

	@FindBy(css = "div#login-form>form>div>md-icon")
	WebElement btn_arrow;

	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(xpath = "//*[text()='LOG IN']")
	WebElement btn_log_in;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {

		waitForElement( txt_email);
		txt_email.clear();
		txt_email.sendKeys(email);
	}

	public void clickOnArrow() {
		waitForElement( btn_arrow);
		clickOn(btn_arrow);
	}

	public void enterPassword(String password) {
		waitForElement( txt_password);
		txt_password.clear();
		txt_password.sendKeys(password);
	}

	public void clickOnLogin() {
		waitForElement( btn_log_in);
		clickOn(btn_log_in);
	}

	public String varifyPageTitle() {
		return driver.getTitle();

	}

	public boolean verifyErrorMessage(String error) {

		pause(2);

		return driver.findElement(By.xpath("//span[contains(text(),'" + error + "')]")).isDisplayed();
	}

	public boolean verifyLoginButtonDisabled() {

		pause(2);
		System.out.println(!btn_log_in.isEnabled());
		return (!btn_log_in.isEnabled());

	}
	
	public String verifyColorOfLogInButton()
	{
		String color =  btn_log_in.getCssValue("color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");	 
		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]); 
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		System.out.println(actualColor);
		return actualColor;
	}

}
