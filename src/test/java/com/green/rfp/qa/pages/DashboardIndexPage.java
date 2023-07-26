package com.green.rfp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.green.rfp.qa.base.BaseClass;

public class DashboardIndexPage extends BaseClass {

	public DashboardIndexPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Template']")
	WebElement template_link;
	@FindBy(xpath = "//a[@href='/myaccount/rfps']//span[1]")
	static WebElement rfp_link;
	@FindBy(xpath = "//span[text()='Support']")
	WebElement support_leftlink;


	public DashboardVerificationPage clickOnTemplateLeftLink() {
		pause(3);
		PresenceOfElement(By.xpath("//span[text()='Template']"));
		clickableElement(template_link);
		jsClick(template_link);
		return new DashboardVerificationPage();
	}

	public DashboardVerificationPage clickOnRFPLeftLink() {
		pause(5);
		scrollToElement(rfp_link);
		PresenceOfElement(By.xpath("//a[@href='/myaccount/rfps']//span[1]"));
		jsClick(rfp_link);
		return new DashboardVerificationPage();
	}

	public DashboardVerificationPage clickOnLeftMenu(String st) {
		pause(5);
		scrollToElement(rfp_link);
		scrollToElement(driver.findElement(By.xpath("//div[@ms-navigation-item]//span[contains(.,'" + st + "')]")));
		PresenceOfElement(By.xpath("//div[@ms-navigation-item]//span[contains(.,'" + st + "')]"));
		jsClick(driver.findElement(By.xpath("//div[@ms-navigation-item]//span[contains(.,'" + st + "')]")));
		return new DashboardVerificationPage();
	}

	public DashboardVerificationPage clickSupportLeftLink() {
		pause(5);
		PresenceOfElement(By.xpath("//span[text()='Support']"));
		clickableElement(support_leftlink);
		jsClick(support_leftlink);
		return new DashboardVerificationPage();
	}

	@FindBy(xpath = "//span[text()='Content']")
	WebElement content_leftlink;

	public DashboardVerificationPage clickContentLeftLink() {
		pause(5);
		PresenceOfElement(By.xpath("//span[text()='Content']"));
		clickableElement(content_leftlink);
		jsClick(content_leftlink);
		return new DashboardVerificationPage();
	}

	@FindBy(xpath = "//span[text()='Templates']")
	WebElement template_from_support_leftlink;

	public DashboardVerificationPage clickTemplateLinkFromSupportLeftLink() {
		waitForPageLoaded();
		PresenceOfElement(By.xpath("//span[text()='Templates']"));
		clickableElement(template_from_support_leftlink);
		jsClick(template_from_support_leftlink);
		return new DashboardVerificationPage();
	}


}
