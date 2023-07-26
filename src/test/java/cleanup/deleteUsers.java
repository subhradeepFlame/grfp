package cleanup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class deleteUsers extends BaseClass {
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
				System.out.println("looking for dependent user");
				int size = driver.findElements(By.xpath("//button[normalize-space()='Assign to Admin']")).size();
				System.out.println("size : " + size);
				if (size >= 1
						&& driver.findElement(By.xpath("//button[normalize-space()='Assign to Admin']")).isEnabled()) {
					System.out.println("Found dependent user popup");
					try {
						System.out.println("Click on assign to admin");
						clickOn(driver.findElement(By.xpath("//button[normalize-space()='Assign to Admin']")));
						System.out.println("Click on yes");
						clickOn(driver.findElement(By.xpath("//button[normalize-space()='Yes']")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("No dependent user");
						pause(2);
						wait.until(
								ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']")));
						System.out.println("Click on yes");
						clickOn(driver.findElement(By.xpath("//button[normalize-space()='Yes']")));

					}

				} else {
					System.out.println("No dependent user");
					pause(2);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']")));
					System.out.println("Click on yes");
					clickOn(driver.findElement(By.xpath("//button[normalize-space()='Yes']")));

				}

				try {
					System.out.println((driver.findElement(By.xpath("//md-toast")).getText()));
				} catch (Exception e) {
					System.out.println("no toast msg");
				}
				pause(2);
				try {
					System.out.println((driver.findElement(By.xpath("//md-toast")).getText()));
				} catch (Exception e) {
					System.out.println("no toast msg");
				}
				pause(5);
			} catch (Exception e) {
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
