package com.green.rfp.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

public class deleteUsers2 extends BaseClass {
	String userid = "177637";
	String deleteUrl = "https://" + env + ".thegreenrfp.com/users/delete";
	String editUrl = "https://" + env + ".thegreenrfp.com/users/edit";
	String editPayload = "{old_id: " + userid + ", new_id: \"none\", check: false, user_delete: \"true\"}";
	String deletePayload = "{id: " + userid + ", check: false}";
	String requestType = "post";

	@Test
	public void deleteuser() throws UnirestException {
		superAdminloginValid();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://" + env + ".thegreenrfp.com/myaccount/support/users");
		waitForPageLoaded();
		clickOn(driver.findElement(By.xpath("//*[@id='vertical-navigation']/md-toolbar/md-icon")));
		System.out.println("Click on search icon");
		clickOn(driver.findElement(By.xpath("//md-icon[@md-font-icon='icon-magnify']")));
		clickOn(driver.findElement(
				By.xpath("//md-input-container/label[text()[contains(.,'Search')]]//following-sibling::input")));
		System.out.println("Enter search key ccqa");
		enterDataIn(
				driver.findElement(
						By.xpath("//md-input-container/label[text()[contains(.,'Search')]]//following-sibling::input")),
				"ccqa");
		waitForPageLoaded();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Updated At']")));
		System.out.println("click on update at");
		clickOn(driver.findElement(By.xpath("//span[normalize-space()='Updated At']")));
		waitForPageLoaded();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//tbody//span[contains(text(),'@mailinator.com')]/../../../..//td)[9]")));
		scrollToElementTillTrue(driver.findElement(By.xpath("//md-icon[@md-font-icon='icon-dots-vertical']")));

		do {
			try {
				pause(2);
				System.out.println("click on options for "
						+ driver.findElement(By.xpath("//tbody//span[contains(text(),'@mailinator.com')]")).getText());
				clickOn(driver.findElement(
						By.xpath("(//tbody//span[ contains(text(),'@mailinator.com')]/../../../..//td)[9]")));
				System.out.println("Click on delete");
				clickOn(driver.findElement(
						By.xpath("//md-menu-content[@class='md-default-theme']//button[@aria-label='Delete']")));
				System.out.println("Click on yes");
				clickOn(driver.findElement(By.xpath("//button[normalize-space()='Yes']")));
				//System.out.println("looking for dependent user");
				pause(1);
				WebElement ele= driver.findElement(By.xpath("//button[normalize-space()='Assign to Admin'] | //button[normalize-space()='Yes']"));
				System.out.println("Click on "+ele.getText());
				ele.click();
				pause(1);
				System.out.println("click on yes");
				clickOn(driver.findElement(By.xpath("//button[normalize-space()='Yes']")));
				
				
				System.out.println("User Deleted.");
				pause(3);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("refresh");
				driver.navigate().refresh();
				waitForPageLoaded();
				clickOn(driver.findElement(By.xpath("//*[@id='vertical-navigation']/md-toolbar/md-icon")));

				System.out.println("Click on search icon");
				clickOn(driver.findElement(By.xpath("//md-icon[@md-font-icon='icon-magnify']")));
				clickOn(driver.findElement(By
						.xpath("//md-input-container/label[text()[contains(.,'Search')]]//following-sibling::input")));
				System.out.println("Enter search key ccqa");
				enterDataIn(
						driver.findElement(By.xpath(
								"//md-input-container/label[text()[contains(.,'Search')]]//following-sibling::input")),
						"ccqa");
				waitForPageLoaded();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Updated At']")));
				System.out.println("click on update at");
				clickOn(driver.findElement(By.xpath("//span[normalize-space()='Updated At']")));
				waitForPageLoaded();
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//tbody//span[contains(text(),'@mailinator.com')]/../../../..//td)[9]")));
				scrollToElementTillTrue(driver.findElement(By.xpath("//md-icon[@md-font-icon='icon-dots-vertical']")));

			}

		} while (driver
				.findElements(By.xpath(
						"//tbody//span[contains(text(),'ccqa') and contains(text(),'@mailinator.com')]/../../../. "))
				.size() > 0);

	}

}
