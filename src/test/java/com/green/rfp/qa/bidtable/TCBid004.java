package com.green.rfp.qa.bidtable;


import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.csvHelper;


public class TCBid004 extends BaseClass {

	@Test
	public void checkBidtableEvaluatorFlow() {

		String cellval = com.green.rfp.qa.utility.XLUtils.getCellValue(datafile, "testdata", 1, 2);
		String rfpstatus = com.green.rfp.qa.utility.XLUtils.getCellValue(datafile, "testdata", 1, 3);
		LocalDate dateObj = LocalDate.now();
		LocalDate rfpDate = LocalDate.parse(cellval);
		if (rfpDate.isBefore(dateObj) &&rfpstatus.equals("1")&& !rfpstatus.equals(null)) {			
		String rfpName = com.green.rfp.qa.utility.XLUtils.getCellValue(datafile, "testdata", 1, 1);
			String Vendor3Name = "vendor 1";
			testStepsLog("Step " + (stepCount++), "Clear download folder");
			csvHelper.deleteDownloadedFiles();
			testStepsLog("Step " + (stepCount++), " Login as customer admin");
			superAdminloginValid();
			loginAsFor("Customer Admin");
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
			templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
			testStepsLog("Step " + (stepCount++), " Search the rfp from pending task list");
			rfpVerificationPage = rfpIndexPage.searchRfpFromDashboardTaskList("Pending Task List",rfpName);
			testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
			rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
			testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
			templateVerificationPage = templateIndexPage.clickOnYesButton();
			waitForPageLoaded();

			testStepsLog("Step " + (stepCount++), "Click on save all button");
			scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Save All')]")));
			jsClick(driver.findElement(By.xpath("//button[contains(text(),'Save All')]")));
			testStepsLog("Step " + (stepCount++), "Click on save and submit button");
			scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'SAVE & SUBMIT')]")));
			jsClick(driver.findElement(By.xpath("//button[contains(text(),'SAVE & SUBMIT')]")));
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			testStepsLog("Step " + (stepCount++), " Click on Accept");
			jsClick(driver.findElement(By.xpath(" //button[contains(text(),'ACCEPT')]")));
			testStepsLog("Step " + (stepCount++), " Click on yes");
			jsClick(driver.findElement(By.xpath(" //button[contains(text(),'Yes')]")));
			waitForPageLoaded();
			pause(3);
			testStepsLog("Step " + (stepCount++), "Verify bidtable task is accepted");
			try {
				PresenceOfElement(By.xpath("//button[contains(text(),'ACCEPT')]"));
				Assert.fail();
			} catch (Exception e) {
				testVerifyLog("Bidtable task is accepted");
			}
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			testStepsLog("Step " + (stepCount++), " Verify all the container items are now showing");
			for (int i = 1; i < 5; i++) {
				try {
					PresenceOfElement(By.xpath("(//span[text()='item " + i + "'])[1]"));
					testVerifyLog("Item : " + i + " is showing");
				} catch (Exception e) {

					Assert.fail();
				}
			}
			testStepsLog("Step " + (stepCount++), " Get total items count");
			List<WebElement> totalItems = driver.findElements(By.xpath(
					"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//p[contains(@ng-class,'all_items')]//span[contains(text(),'item')]"));

			testStepsLog("Step " + (stepCount++), " Click on Heatmap icon");
			bidTablePage.clickOnHeatMapIcon();
			testStepsLog("Step " + (stepCount++), "Verify there is no vendor responce cell color showing");
			try {
				PresenceOfElement(By.xpath("//td[@style='background: rgb(193, 250, 190);']"));
				Assert.fail();
			} catch (Exception e) {
				testVerifyLog("price tab colors are not showing");

			}
			testStepsLog("Step " + (stepCount++), "Click on the heatmap icon again");
			bidTablePage.clickOnHeatMapIcon();
			testStepsLog("Step " + (stepCount++),
					"Verify for every item the lowest vendor responce is showing green, 2nd lowest is showing orange and 3rd lowest is showing pink color");
			testStepsLog("Step " + (stepCount++), " Get container 1 items all 3 vendors responses");
			for (int i = 1; i < 4; i++) {
				double vendor2Responce = bidTablePage.getVendorResponseValue("QaNarola Vendor1", "container 1(3)",
						"item " + i);
				System.out.println("aaaaaa: " + vendor2Responce);
				double vendor3Responce = bidTablePage.getVendorResponseValue("QaNarola Vendor", "container 1(3)",
						"item " + i);
				System.out.println("bbbbbb: " + vendor3Responce);
				double vendor1Responce = bidTablePage.getVendorResponseValue("vendor 1", "container 1(3)", "item " + i);
				System.out.println("cccccc: " + vendor1Responce);
				testStepsLog("Step " + (stepCount++),
						"Verify for every item the lowest vendor responce is showing green, 2nd lowest is showing orange and 3rd lowest is showing pink color");
				bidTablePage.VerifyCellColors(vendor2Responce, vendor3Responce, vendor1Responce);
				testVerifyLog("Item " + i + " all vendor responces colors are showing correctly");
				System.out.println("Item " + i + " all vendor responces colors are showing correctly");
			}

			testStepsLog("Step " + (stepCount++), " Click on the hide icon of vendor 1");
			bidTablePage.clickOnHideVendorIcon("vendor 1");
			testStepsLog("Step " + (stepCount++), " Verify that vendor1 is not showing in the bidtable");
			try {
				PresenceOfElement(
						By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
								+ Vendor3Name + "']"));
				Assert.fail();
			} catch (Exception e) {
				testVerifyLog("Vendor1 not showing in the bidtable");
			}
			testStepsLog("Step " + (stepCount++), "Click on the Hidden vendors list icon");
			bidTablePage.clickOnHiddenVendorListIcon();
			testStepsLog("Step " + (stepCount++), " Verify that vendor1 is showing in the Hidden vendors modal");
			try {
				PresenceOfElement(
						By.xpath("//h2[text()='Hidden Vendors']/../../following-sibling::md-dialog-content//td[text()='"
								+ Vendor3Name + "']"));
				testVerifyLog("Vendor1 is showing in the hidden vendors list");
			} catch (Exception e) {
				Assert.fail();
			}
			testStepsLog("Step " + (stepCount++), "Close Hidden Vendors modal");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Unhide the vendor 1");
			bidTablePage.unhideHiddenVendor(Vendor3Name);
			testStepsLog("Step " + (stepCount++), "Verify vendor 1 is showing back to the bidtable");
			try {
				PresenceOfElement(
						By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
								+ Vendor3Name + "']"));
				testVerifyLog("Vendor 1 is showing in the bidtable");
			} catch (Exception e) {
				Assert.fail();
			}

			testStepsLog("Step " + (stepCount++), " Click on the Select all responce icon of vendor 1");
			bidTablePage.clickOnSelectAllResponsesVendorIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++), " Click on the selcetion summary icon");
			bidTablePage.clickOnSelectionSummaryIcon();
			testStepsLog("Step " + (stepCount++), " Verify other vendors selection item count should show 0");
			PresenceOfElement(By.xpath("//md-tab-item[text()='QaNarola Vendor1(0)']"));
			PresenceOfElement(By.xpath("//md-tab-item[text()='QaNarola Vendor(0)']"));
			testVerifyLog("other vendors selection item count showing 0");
			testStepsLog("Step " + (stepCount++), " Verify vendor 1 tab item count should show as total items count");
			PresenceOfElement(By.xpath("//md-tab-item[text()='vendor 1(" + totalItems.size() + ")']"));
			testStepsLog("Step " + (stepCount++), "Close the selection summary modal");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Open selection summary vendor 1 tab");
			bidTablePage.openSelectionSummaryVendorTab(Vendor3Name);
			List<WebElement> vendor1items = driver.findElements(By.xpath(
					"//h2[text()='Selection Summary']/../../following-sibling::md-dialog-content//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[contains(text(),'item')]"));
			testStepsLog("Step " + (stepCount++), "Verify all items are showing under vendor 1 tab");
			Assert.assertEquals(totalItems.size(), vendor1items.size());
			testVerifyLog("all items are showing under vendor 1 tab");
			testStepsLog("Step " + (stepCount++), "Close the selection summary modal");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Verify that al the responses are showing tickmarked of that vendor");
			for (int i = 1; i < 4; i++) {
				boolean status = bidTablePage.isCellSelected("vendor 1", "container 1(3)", "item " + i);
				Assert.assertEquals(status, true);
				testVerifyLog("item " + i + " is tickmarked");
			}
			for (int j = 4; j < 5; j++) {
				boolean status = bidTablePage.isCellSelected("vendor 1", "container 2(1)", "item " + j);
				Assert.assertEquals(status, true);
				testVerifyLog("item " + j + " is tickmarked");
			}

			testStepsLog("Step " + (stepCount++), "Click on the Remove all responses icon of vendor 1");
			bidTablePage.clickOnRemoveAllResponsesVendorIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++),
					"Verify that all the prices tickmarked are removed now and the prices are showing crossed");
			for (int i = 1; i < 4; i++) {
				boolean status = bidTablePage.isCellResponceRemoved("vendor 1", "container 1(3)", "item " + i);
				Assert.assertEquals(status, true);
				testVerifyLog("item " + i + " vendor1 response is crossed");
			}
			for (int j = 4; j < 5; j++) {
				boolean status = bidTablePage.isCellResponceRemoved("vendor 1", "container 2(1)", "item " + j);
				Assert.assertEquals(status, true);
				testVerifyLog("item " + j + " vendor1 response is crossed");
			}
			testStepsLog("Step " + (stepCount++), "Click on the Add back all responses icon of vendor 1");
			bidTablePage.clickOnAddBackAllResponsesVendorIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++), "Verify that all the responses of vendor 1 is not crossed now");
			for (int i = 1; i < 4; i++) {
				boolean status = bidTablePage.isCellResponceRemoved("vendor 1", "container 1(3)", "item " + i);
				Assert.assertEquals(status, false);
				testVerifyLog("item " + i + " vendor1 response is not crossed");
			}
			for (int j = 4; j < 5; j++) {
				boolean status = bidTablePage.isCellResponceRemoved("vendor 1", "container 2(1)", "item " + j);
				Assert.assertEquals(status, false);
				testVerifyLog("item " + j + " vendor1 response is not crossed");
			}

			testStepsLog("Step " + (stepCount++), "Click on the expand vendor details icon of vendor 1");
			bidTablePage.clickOnExpandVendorDetailsIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++), "Verify all the items are showing correctly");
			bidTablePage.VerifyExpandVendorModuleAllItemsAreShowingCorrectly();
			testStepsLog("Step " + (stepCount++), "Click on select icon of item 1 ");
			bidTablePage.clickOnDetailsModalSelectIcon("item 1");
			testStepsLog("Step " + (stepCount++), "Click on lock icon of item 1");
			bidTablePage.clickOnDetailsModalLockIcon("item 1");
			testStepsLog("Step " + (stepCount++), "Click on previous vendor button");
			bidTablePage.clickOnPreviousVendorOnExpandVendorDetailsModal();
			testStepsLog("Step " + (stepCount++), "Verify all the items are showing correctly for the vendor");
			bidTablePage.VerifyExpandVendorModuleAllItemsAreShowingCorrectly();
			testStepsLog("Step " + (stepCount++), "Click on select icon of item 2 ");
			bidTablePage.clickOnDetailsModalSelectIcon("item 2");
			testStepsLog("Step " + (stepCount++), "Click on lock icon of item 2");
			bidTablePage.clickOnDetailsModalLockIcon("item 2");
			testStepsLog("Step " + (stepCount++), "Click on next vendor button");
			bidTablePage.clickOnNextVendorOnExpandVendorDetailsModal();
			testStepsLog("Step " + (stepCount++), "Click on hide button");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Verify item 1 is locked");
			testStepsLog("Step " + (stepCount++), "Click on the remove item icon of item 3");
			bidTablePage.ClickOnRemoveItemIconForItem("item 1");
			boolean statusofitem1 = bidTablePage.isItemRemoved("item 1");
			Assert.assertEquals(statusofitem1, false);
			testVerifyLog("item 1 is locked");
			testStepsLog("Step " + (stepCount++), "Verify item 2 is locked");
			testStepsLog("Step " + (stepCount++), "Click on the remove item icon of item 3");
			bidTablePage.ClickOnRemoveItemIconForItem("item 2");
			boolean statusofitem2 = bidTablePage.isItemRemoved("item 2");
			Assert.assertEquals(statusofitem2, false);
			testVerifyLog("item 2 is locked");
			testStepsLog("Step " + (stepCount++), "Verify item 1 vendor 1 response is selected");
			driver.navigate().refresh();
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			boolean statuss1 = bidTablePage.isCellSelected("vendor 1", "container 1(3)", "item 1");
			Assert.assertEquals(statuss1, true);
			testVerifyLog("item 1 vendor 1 response is selected");
			pause(3);
			testStepsLog("Step " + (stepCount++), "Verify for item 2 previous vendor response is selected");
			boolean statuss2 = bidTablePage.isCellSelected("QaNarola Vendor1", "container 1(3)", "item 2");
			Assert.assertEquals(statuss2, true);
			testVerifyLog("item 2 vendor 3 response is selected");
			testStepsLog("Step " + (stepCount++), " Unlock item 1");
			bidTablePage.unlockItem("item 1");
			testStepsLog("Step " + (stepCount++), " Unlock item 2");
			bidTablePage.unlockItem("item 2");

			testStepsLog("Step " + (stepCount++), "Click on the Remove all item icon of 2nd container");
			bidTablePage.clickOnRemoveAllItemOfContainer("1");
			testStepsLog("Step " + (stepCount++),
					"Verify all the items of 2nd container is now removed and their is no tickmarked of the prices");
			for (int j = 4; j < 5; j++) {
				boolean status = bidTablePage.isItemRemoved("item " + j);
				Assert.assertEquals(status, true);
				testVerifyLog("item " + j + " Container 2 items are removed");
			}
			testStepsLog("Step " + (stepCount++), "Click on the Add back items of 2nd container");
			bidTablePage.clickOnAddBackAllItemOfContainer("1");
			testStepsLog("Step " + (stepCount++),
					"Verify that all the items are now back and user can tick mark the prices");
			for (int j = 4; j < 5; j++) {
				boolean status = bidTablePage.isItemRemoved("item " + j);
				Assert.assertEquals(status, false);
				testVerifyLog("item " + j + " Container 2 items are back");
			}
			testStepsLog("Step " + (stepCount++), "Add evaluator Note for 1st item");
			bidTablePage.AddEvaluatorNote("item 1");
			testStepsLog("Step " + (stepCount++), "Verify success message is showing");
			PresenceOfElement(By.xpath("//span[contains(text(),'Note Added')]"));
			testStepsLog("Step " + (stepCount++), "Click on the Remove item icon of item 1");
			bidTablePage.ClickOnRemoveItemIconForItem("item 1");
			testStepsLog("Step " + (stepCount++), "Verify item 1 is now removed");
			boolean status1 = bidTablePage.isItemRemoved("item 1");
			Assert.assertEquals(status1, true);
			testVerifyLog("item 1 is removed");
			testStepsLog("Step " + (stepCount++), "Click on the Add back item icon of item 1");
			bidTablePage.ClickOnAddBackItemIconForItem("item 1");
			testStepsLog("Step " + (stepCount++), "Verify item 1 is now back");
			boolean status2 = bidTablePage.isItemRemoved("item 1");
			Assert.assertEquals(status2, false);
			testVerifyLog("item 1 is back");

			testStepsLog("Step " + (stepCount++), "Click on item details icon of item 1");
			bidTablePage.ClickOnItemDetailsIconOfItem("item 1");
			testStepsLog("Step " + (stepCount++), "Click on Select response icon of vendor 3");
			bidTablePage.clickOnExpandItemModalSelectResponseIcon("QaNarola Vendor1");
			testStepsLog("Step " + (stepCount++), "Click on the hide button of the item details modal");
			bidTablePage.ClickOnHideButtonOfItemDetailsModal();
			driver.navigate().refresh();
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			testStepsLog("Step " + (stepCount++), "Verify vendor 3 of item 1 response is selected");
			boolean item1Vendor3ResponceSelected = bidTablePage.isCellSelected("QaNarola Vendor1", "container 1(3)",
					"item 1");
			Assert.assertEquals(item1Vendor3ResponceSelected, true);
			testVerifyLog("vendor 3 of item 1 response is selected");
			testStepsLog("Step " + (stepCount++), "Click on item details icon of item 1");
			bidTablePage.ClickOnItemDetailsIconOfItem("item 1");
			testStepsLog("Step " + (stepCount++), "Click on Remove response icon of vendor 3");
			bidTablePage.clickOnExpandItemModalRemoveResponseIcon("QaNarola Vendor1");
			testStepsLog("Step " + (stepCount++), "Click on the hide button of the item details modal");
			bidTablePage.ClickOnHideButtonOfItemDetailsModal();
			driver.navigate().refresh();
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			testStepsLog("Step " + (stepCount++), "Verify vendor 3 of item 1 response is removed");
			boolean item1Vendor3ResponceRemoved = bidTablePage.isCellResponceRemoved("QaNarola Vendor1",
					"container 1(3)", "item 1");
			Assert.assertEquals(item1Vendor3ResponceRemoved, true);
			testVerifyLog("vendor 3 of item 1 response is removed");
			testStepsLog("Step " + (stepCount++), "Click on item details icon of item 1");
			bidTablePage.ClickOnItemDetailsIconOfItem("item 1");
			testStepsLog("Step " + (stepCount++), "Click on Add Back response icon of vendor 3");
			bidTablePage.clickOnExpandItemModalAddBackResponseIcon("QaNarola Vendor1");
			testStepsLog("Step " + (stepCount++), "Click on the hide button of the item details modal");
			bidTablePage.ClickOnHideButtonOfItemDetailsModal();
			driver.navigate().refresh();
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			testStepsLog("Step " + (stepCount++), "Verify vendor 3 of item 1 response is added back");
			boolean item1Vendor3ResponceAddedBack = bidTablePage.isCellResponceRemoved("QaNarola Vendor1",
					"container 1(3)", "item 1");
			Assert.assertEquals(item1Vendor3ResponceAddedBack, false);
			testVerifyLog("vendor 3 of item 1 response is added back");
			testStepsLog("Step " + (stepCount++), "Click on item details icon of item 1");
			bidTablePage.ClickOnItemDetailsIconOfItem("item 1");
			testStepsLog("Step " + (stepCount++), "Click on Remove Item icon of item 1");
			bidTablePage.clickOnExpandItemModalRemoveItemIcon();
			testStepsLog("Step " + (stepCount++), "Click on the hide button of the item details modal");
			bidTablePage.ClickOnHideButtonOfItemDetailsModal();
			driver.navigate().refresh();
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			testStepsLog("Step " + (stepCount++), "Verify item 1 is removed");
			boolean item1Status = bidTablePage.isItemRemoved("item 1");
			Assert.assertEquals(item1Status, true);
			testVerifyLog(" item 1 is removed");
			testStepsLog("Step " + (stepCount++), "Click on item details icon of item 1");
			bidTablePage.ClickOnItemDetailsIconOfItem("item 1");
			testStepsLog("Step " + (stepCount++), "Click on Add BACK Item icon of item 1");
			bidTablePage.clickOnExpandItemModalAddBackItemIcon();
			testStepsLog("Step " + (stepCount++), "Click on the hide button of the item details modal");
			bidTablePage.ClickOnHideButtonOfItemDetailsModal();
			driver.navigate().refresh();
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			testStepsLog("Step " + (stepCount++), "Verify item 1 is ADDED BACK");
			boolean item1Status1 = bidTablePage.isItemRemoved("item 1");
			Assert.assertEquals(item1Status1, false);
			testVerifyLog(" item 1 is added back");
			testStepsLog("Step " + (stepCount++), "Click on item details icon of item 1");
			bidTablePage.ClickOnItemDetailsIconOfItem("item 1");
			testStepsLog("Step " + (stepCount++), "Get Item 1 unit value");
			String Item1UnitValue = driver.findElement(By.xpath("//td[contains(@ng-class,'item_all_response')]//span"))
					.getText();
			testStepsLog("Step " + (stepCount++), "Click on lock icon of item 1");
			bidTablePage.clickOnExpandItemModalLockItemIcon();
			testStepsLog("Step " + (stepCount++), "Click on the hide button of the item details modal");
			bidTablePage.ClickOnHideButtonOfItemDetailsModal();
			driver.navigate().refresh();
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on Bidtable 1");
			jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'bid1')]")));
			pause(3);
			testStepsLog("Step " + (stepCount++), " Click on Expand all icon");
			bidTablePage.clickOnExpandAllIcon();
			testStepsLog("Step " + (stepCount++), "Verify item 1 is Locked");
			testStepsLog("Step " + (stepCount++), "Click on the remove item icon of item 1");
			bidTablePage.ClickOnRemoveItemIconForItem("item 1");
			boolean item1Status2 = bidTablePage.isItemRemoved("item 1");
			Assert.assertEquals(item1Status2, false);
			testVerifyLog("item 1 is locked");
			testStepsLog("Step " + (stepCount++), " Unlock item 1");
			bidTablePage.unlockItem("item 1");

			testStepsLog("Step " + (stepCount++), "Click on the lock icon of item 3");
			bidTablePage.lockItem("item 3");
			testStepsLog("Step " + (stepCount++), "Verify that the lock icon color is now red");
			PresenceOfElement(By.xpath(
					"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='item 3']/../../../..//button[@style='color: rgb(255, 0, 0);']"));
			testVerifyLog("Lock icon color of item 3 is now red");
			testStepsLog("Step " + (stepCount++), "Verify user can not change that locked item row");
			testStepsLog("Step " + (stepCount++), "Click on the remove item icon of item 3");
			bidTablePage.ClickOnRemoveItemIconForItem("item 3");
			boolean status3 = bidTablePage.isItemRemoved("item 3");
			Assert.assertEquals(status3, false);
			testVerifyLog("item 1 row is not changable");
			testStepsLog("Step " + (stepCount++), "Unlock item 3");
			bidTablePage.unlockItem("item 3");
			testStepsLog("Step " + (stepCount++),
					"Verify that the icon is now unlocked and user can change in that item row");
			testStepsLog("Step " + (stepCount++), "Click on the remove item icon of item 3");
			bidTablePage.ClickOnRemoveItemIconForItem("item 3");
			boolean status4 = bidTablePage.isItemRemoved("item 3");
			Assert.assertEquals(status4, true);
			testVerifyLog("item 3 is unlocked");

			testStepsLog("Step " + (stepCount++),
					"Click on the purchaser column filter and select different purchaser column name");
			bidTablePage.changePurchaserColumnFilterName("unit");
			testStepsLog("Step " + (stepCount++),
					"Verify that all the items are now showing as selected purchaser column name");
			try {
				PresenceOfElement(By.xpath(
						"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//p[contains(@ng-class,'all_items')]//span[contains(text(),'item')]"));
				Assert.fail();
			} catch (Exception e) {
				PresenceOfElement(By.xpath(
						"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//p[contains(@ng-class,'all_items')]//span[contains(text(),'"
								+ Item1UnitValue + "')]"));
				testVerifyLog("Items names are not showing, items unit is showing");
			}
			testStepsLog("Step " + (stepCount++),
					"Click on the purchaser column filter and select previous purchaser column name");
			bidTablePage.changePurchaserColumnFilterName("name");
			testStepsLog("Step " + (stepCount++), "Click on the left top bidtable checkbox");
			bidTablePage.SelectAllContainerCheckbox();
			testStepsLog("Step " + (stepCount++), "Click on eliminate items icon");
			bidTablePage.clickOnBulkEliminateItemsIcon();
			testStepsLog("Step " + (stepCount++), "Verify that all the items are now showing as eliminated now");
			for (int j = 1; j < 5; j++) {
				boolean status = bidTablePage.isItemRemoved("item " + j);
				Assert.assertEquals(status, true);
				testVerifyLog("item " + j + " is removed");
			}
			testStepsLog("Step " + (stepCount++), "Click on uneliminate items icon");
			bidTablePage.clickOnBulkUnEliminateItemsIcon();
			testStepsLog("Step " + (stepCount++), "Verify that all the items are now showing as uneliminated now");
			for (int j = 1; j < 5; j++) {
				boolean status = bidTablePage.isItemRemoved("item " + j);
				Assert.assertEquals(status, false);
				testVerifyLog("item " + j + " is uneliminated");
			}
			testStepsLog("Step " + (stepCount++), "Click on the lock icon");
			bidTablePage.clickOnBulkLockItemsIcon();
			testStepsLog("Step " + (stepCount++),
					"Verify that all the items are now locked and user can't change in them");
			testStepsLog("Step " + (stepCount++), "Verify items lock color is showing red");
			for (int i = 1; i < 5; i++) {
				PresenceOfElement(
						By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='item "
								+ i + "']/../../../..//button[@style='color: rgb(255, 0, 0);']"));
				testVerifyLog("Lock icon color of item " + i + " is now red");
			}
			testStepsLog("Step " + (stepCount++), "Click on eliminate items icon");
			bidTablePage.clickOnBulkEliminateItemsIcon();
			testStepsLog("Step " + (stepCount++), "Verify that all the items are now showing as uneliminated now");
			for (int j = 1; j < 5; j++) {
				boolean status = bidTablePage.isItemRemoved("item " + j);
				Assert.assertEquals(status, false);
			}
			testVerifyLog("all the items are now locked and user can't change in them");

			testStepsLog("Step " + (stepCount++), "Click on the unlock icon");
			bidTablePage.clickOnBulkUnLockItemsIcon();
			testStepsLog("Step " + (stepCount++),
					"Verify that all the items are now unlocked and user can change in them");
			testStepsLog("Step " + (stepCount++), "Click on eliminate items icon");
			bidTablePage.clickOnBulkEliminateItemsIcon();
			testStepsLog("Step " + (stepCount++), "Verify that all the items are now showing as eliminated now");
			for (int j = 1; j < 5; j++) {
				boolean status = bidTablePage.isItemRemoved("item " + j);
				Assert.assertEquals(status, true);
			}
			testVerifyLog("all the items are now unlocked and user can change in them");
			testStepsLog("Step " + (stepCount++), "Click on uneliminate items icon");
			bidTablePage.clickOnBulkUnEliminateItemsIcon();

			testStepsLog("Step " + (stepCount++), " Click on the Select all responce icon of vendor 1");
			bidTablePage.clickOnSelectAllResponsesVendorIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++), "Click on clear selection icon");
			bidTablePage.clickOnClearSelectionIcon();
			testStepsLog("Step " + (stepCount++),
					"Verify that all the vendor response selection is now clear and there is no tickmark showing");
			for (int i = 1; i < 4; i++) {
				boolean statusVendor1 = bidTablePage.isCellSelected("vendor 1", "container 1(3)", "item " + i);
				Assert.assertEquals(statusVendor1, false);
				boolean statusVendor2 = bidTablePage.isCellSelected("QaNarola Vendor", "container 1(3)", "item " + i);
				Assert.assertEquals(statusVendor2, false);
				boolean statusVendor3 = bidTablePage.isCellSelected("QaNarola Vendor1", "container 1(3)", "item " + i);
				Assert.assertEquals(statusVendor3, false);
			}
			for (int j = 4; j < 5; j++) {
				boolean statusVendor1 = bidTablePage.isCellSelected("vendor 1", "container 2(1)", "item " + j);
				Assert.assertEquals(statusVendor1, false);
				boolean statusVendor2 = bidTablePage.isCellSelected("QaNarola Vendor", "container 2(1)", "item " + j);
				Assert.assertEquals(statusVendor2, false);
				boolean statusVendor3 = bidTablePage.isCellSelected("QaNarola Vendor1", "container 2(1)", "item " + j);
				Assert.assertEquals(statusVendor3, false);
			}
			testStepsLog("Step " + (stepCount++), "Change active filter column name");
			bidTablePage.changeActiveColumnFilter("price");
			testStepsLog("Step " + (stepCount++), "Verify that the data are showing as selected column ");
			testStepsLog("Step " + (stepCount++), "Get vendor1 item 1 response");
			String newV1Response = bidTablePage.getVendorResponse(Vendor3Name, "container 1(3)", "item 1");
			testStepsLog("Step " + (stepCount++), "open vendor 1 expand vendor details modal");
			bidTablePage.clickOnExpandVendorDetailsIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++), "Get item 1 price");
			String v1Item1Price = driver
					.findElement(By.xpath("(//tr[contains(@ng-if,'container_items')])[1]//td[7]//span")).getText();
			testStepsLog("Step " + (stepCount++), "Compare both responses are same");
			Assert.assertEquals(newV1Response, v1Item1Price);
			testVerifyLog("data are showing as selected column in active column");
			testStepsLog("Step " + (stepCount++), "Click on hide button");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Change active filter column name to previous column name");
			bidTablePage.changeActiveColumnFilter("Extended Cost");

			testStepsLog("Step " + (stepCount++), "Get vendor 1 item 1 responce");
			String V1Item1Response = bidTablePage.getVendorResponse(Vendor3Name, "container 1(3)", "item 1");
			testStepsLog("Step " + (stepCount++), "Get vendor 1 item 1 unit value");
			testStepsLog("Step " + (stepCount++), "open vendor 1 expand vendor details modal");
			bidTablePage.clickOnExpandVendorDetailsIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++), "Get item 1 price");
			String v1Item1Unit = driver
					.findElement(By.xpath("(//tr[contains(@ng-if,'container_items')])[1]//td[6]//span")).getText();
			testStepsLog("Step " + (stepCount++), "Click on hide button");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Click on the filter icon");
			bidTablePage.clickOnFilterIcon();
			testStepsLog("Step " + (stepCount++), "Enter a vendor responce number to the filter equals field");
			bidTablePage.enterFilterSearchValue(V1Item1Response);
			testStepsLog("Step " + (stepCount++), "Click on Preview ");
			bidTablePage.clickOnFilterSearchPreviewButton();
			testStepsLog("Step " + (stepCount++), "Change purchaser column filter value");
			bidTablePage.filterSearchChangePurchaserColumnValue("unit");
			testStepsLog("Step " + (stepCount++), "Get the seach response unit value");
			String SearchedResponseUnitValue = driver
					.findElement(By.xpath("(//tr[contains(@ng-if,'vm.filter_response')])[1]//td[2]//span")).getText();
			testStepsLog("Step " + (stepCount++), "Verfy that all the data showing as selected purchaser column name");
			Assert.assertEquals(v1Item1Unit, SearchedResponseUnitValue);
			testVerifyLog("data showing as selected purchaser column name");

			testStepsLog("Step " + (stepCount++), "Click on eliminate icon");
			bidTablePage.clickOnFilterEliminateButton();
			testStepsLog("Step " + (stepCount++), "Close the filter");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Verify that the vendor responce is showing as eliminated now");
			boolean statusItem1IsEliminated = bidTablePage.isCellResponceRemoved("vendor 1", "container 1(3)",
					"item 1");
			Assert.assertEquals(statusItem1IsEliminated, true);
			testVerifyLog("item 1 vendor responce is eliminated");
			testStepsLog("Step " + (stepCount++), "Click on the filter icon");
			bidTablePage.clickOnFilterIcon();
			testStepsLog("Step " + (stepCount++), "Search by same item price again");
			bidTablePage.enterFilterSearchValue(V1Item1Response);
			testStepsLog("Step " + (stepCount++), "Click on Preview ");
			bidTablePage.clickOnFilterSearchPreviewButton();
			testStepsLog("Step " + (stepCount++), "Click on uneliminate icon");
			bidTablePage.clickOnFilterUneliminateButton();
			testStepsLog("Step " + (stepCount++), "Close the filter");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Verify that the item price is showing now as uneliminated");
			boolean statusItem1IsUneliminated = bidTablePage.isCellResponceRemoved("vendor 1", "container 1(3)",
					"item 1");
			Assert.assertEquals(statusItem1IsUneliminated, false);
			testVerifyLog("item 1 vendor responce is uneliminated");

			testStepsLog("Step " + (stepCount++), " Click on the Select all responce icon of vendor 1");
			bidTablePage.clickOnSelectAllResponsesVendorIcon(Vendor3Name);
			testStepsLog("Step " + (stepCount++), "Click on the filter icon");
			bidTablePage.clickOnFilterIcon();
			testStepsLog("Step " + (stepCount++), "Apply 2 vendors filter on auto select filter");
			bidTablePage.changeAutoSelectValueOfFilter("2 Vendors");
			testStepsLog("Step " + (stepCount++),
					"Verify auto select is showing correctly depending on first 2 vendors");
			for (int i = 1; i < 4; i++) {
				double vendor2Responce = bidTablePage.getVendorResponseValue("QaNarola Vendor", "container 1(3)",
						"item " + i);
				double vendor1Responce = bidTablePage.getVendorResponseValue("vendor 1", "container 1(3)", "item " + i);
				boolean isSelected = bidTablePage.isSmallestVendorResponseIsSelectedAmong2Responces(vendor2Responce,
						vendor1Responce);
				Assert.assertEquals(isSelected, true);
			}
			testVerifyLog("auto select is showing correctly depending on first 2 vendors");

			testStepsLog("Step " + (stepCount++), "Click on clear selection icon");
			bidTablePage.clickOnClearSelectionIcon();
			testStepsLog("Step " + (stepCount++), "Click on the vendor 2 1st item response");
			bidTablePage.clickOnVendorResponse("QaNarola Vendor", "container 1(3)", "item 1");
			pause(3);
			testStepsLog("Step " + (stepCount++), "Verify that vendor 2 1st item response is tickmarked");
			boolean vendor1Item1IsSelected = bidTablePage.isCellSelected("QaNarola Vendor", "container 1(3)", "item 1");
			Assert.assertEquals(vendor1Item1IsSelected, true);

			testStepsLog("Step " + (stepCount++), "Get vendor 1 item 1 response");
			String vendor1Item1Response = bidTablePage.getVendorResponse(Vendor3Name, "container 1(3)", "item 1");
			testStepsLog("Step " + (stepCount++), "Click on view additional responce icon of vendor 1 item 1 response");
			bidTablePage.clickOnViewAdditionalResponseButton(Vendor3Name, "container 1(3)", "item 1");
			testStepsLog("Step " + (stepCount++), "Click on Active icon of first additional responce");
			bidTablePage.clickOnActiveAdditionalResponseIcon("1");
			testStepsLog("Step " + (stepCount++), "Get vendor 1 item 1 new response");
			String vendor1Item1NewResponse = bidTablePage.getVendorResponse(Vendor3Name, "container 1(3)", "item 1");
			testStepsLog("Step " + (stepCount++), "Verify the responce is changed");
			if (!vendor1Item1Response.equals(vendor1Item1NewResponse)) {
				testVerifyLog("vendor 1 item 1 response is changed");
			}

			testStepsLog("Step " + (stepCount++), "Click on view additional responce icon of any vendor responce");
			bidTablePage.clickOnViewAdditionalResponseButton(Vendor3Name, "container 1(3)", "item 1");
			testStepsLog("Step " + (stepCount++), "Click on select icon ");
			bidTablePage.clickOnDetailsModalSelectIcon("item 1");
			testStepsLog("Step " + (stepCount++), "Click on lock icon ");
			bidTablePage.clickOnDetailsModalLockIcon("item 1");
			testStepsLog("Step " + (stepCount++), "Close the additional responce modal");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			testStepsLog("Step " + (stepCount++), "Verify item 1 is locked");
			testStepsLog("Step " + (stepCount++), "Click on the remove item icon of item 3");
			bidTablePage.ClickOnRemoveItemIconForItem("item 1");
			boolean statusofitemm1 = bidTablePage.isItemRemoved("item 1");
			Assert.assertEquals(statusofitemm1, false);
			testVerifyLog("item 1 is locked");
			testStepsLog("Step " + (stepCount++), "Verify the response is selected");
			boolean status = bidTablePage.isCellSelected("vendor 1", "container 1(3)", "item 1");
			Assert.assertEquals(status, true);
			testVerifyLog("item 1 vendor 1 response is selected");

			testStepsLog("Step " + (stepCount++), " Generate report");
			bidTablePage.generateReport();
			testStepsLog("Step " + (stepCount++), " Verify report is in progress text is showing");
			try {
				PresenceOfElement(By.xpath("//th[contains(text(),'Report is in progress. Please come back later')]"));
				testVerifyLog("Report is in progress text is showing");
			} catch (Exception e) {
				Assert.fail();
			}
			testStepsLog("Step " + (stepCount++), "Close the report modal");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();
			pause(5);
			testStepsLog("Step " + (stepCount++), "Downlaod the generated report");
			bidTablePage.downloadGeneratedReport();
			pause(5);
			String CSV_PATH = System.getProperty("user.dir") +"/downloads/"+bidTablePage.getFilefromDirectory("downloads", "bid1-ShaishavN");
			System.out.println("csv path is:" + CSV_PATH);
			testStepsLog("Step " + (stepCount++), "Close the report modal");
			bidTablePage.clickOnCloseIconOfDowonloadReportModal();

			testStepsLog("Step " + (stepCount++), "Verify all details are showing correctly in the csv");
			testStepsLog("Step " + (stepCount++), "Verify all items are showing correctly in the csv");
			Assert.assertEquals(csvHelper.readCSV(CSV_PATH, 3, 1).replaceAll("\"", ""), "item 1");
			Assert.assertEquals(csvHelper.readCSV(CSV_PATH, 4, 1).replaceAll("\"", ""), "item 2");
			Assert.assertEquals(csvHelper.readCSV(CSV_PATH, 5, 1).replaceAll("\"", ""), "item 3");
			testStepsLog("Step " + (stepCount++), "Verify all the vendor names are showing correctly");
			Assert.assertEquals(csvHelper.readCSV(CSV_PATH, 0, 5).replaceAll("\"", ""), "vendor 1");
			Assert.assertEquals(csvHelper.readCSV(CSV_PATH, 0, 10).replaceAll("\"", ""), "QaNarola Vendor");
			Assert.assertEquals(csvHelper.readCSV(CSV_PATH, 0, 15).replaceAll("\"", ""), "QaNarola Vendor1");
			testStepsLog("Step " + (stepCount++), "Verify vendor 1 all items extended costs are showing correctly");
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 3, 8).replaceAll("\"", ""),
					bidTablePage.getVendorResponse(Vendor3Name, "container 1(3)", "item 1").replaceAll(",", ""));
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 4, 8).replaceAll("\"", ""),
					bidTablePage.getVendorResponse(Vendor3Name, "container 1(3)", "item 2").replaceAll(",", ""));
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 5, 8).replaceAll("\"", ""),
					bidTablePage.getVendorResponse(Vendor3Name, "container 1(3)", "item 3").replaceAll(",", ""));
			testStepsLog("Step " + (stepCount++), "Verify vendor 2 all items extended costs are showing correctly");
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 3, 13).replaceAll("\"", ""),
					bidTablePage.getVendorResponse("QaNarola Vendor", "container 1(3)", "item 1").replaceAll(",", ""));
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 4, 13).replaceAll("\"", ""),
					bidTablePage.getVendorResponse("QaNarola Vendor", "container 1(3)", "item 2").replaceAll(",", ""));
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 5, 13).replaceAll("\"", ""),
					bidTablePage.getVendorResponse("QaNarola Vendor", "container 1(3)", "item 3").replaceAll(",", ""));
			testStepsLog("Step " + (stepCount++), "Verify vendor 3 all items extended costs are showing correctly");
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 3, 18).replaceAll("\"", ""),
					bidTablePage.getVendorResponse("QaNarola Vendor1", "container 1(3)", "item 1").replaceAll(",", ""));
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 4, 18).replaceAll("\"", ""),
					bidTablePage.getVendorResponse("QaNarola Vendor1", "container 1(3)", "item 2").replaceAll(",", ""));
			Assert.assertEquals("$" + csvHelper.readCSV(CSV_PATH, 5, 18).replaceAll("\"", ""),
					bidTablePage.getVendorResponse("QaNarola Vendor1", "container 1(3)", "item 3").replaceAll(",", ""));
			testVerifyLog("all details are showing correctly in the csv");

			testStepsLog("Step " + (stepCount++),
					"Verify that for every item there should 1 vendor response selected to submit the bidtable");
			testStepsLog("Step " + (stepCount++), "Click on Save and submit button");
			bidTablePage.clickOnSaveAndSubmitButton();
			try {
				PresenceOfElement(By.xpath(
						"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'saveAssignedTask')]"));
				testVerifyLog("bidtable not submited");
			} catch (Exception e) {
				Assert.fail();
			}
			testStepsLog("Step " + (stepCount++), " Click on the Select all responce icon of vendor 2");
			bidTablePage.clickOnSelectAllResponsesVendorIcon("QaNarola Vendor");
			testStepsLog("Step " + (stepCount++), "Click on Save and submit button");
			bidTablePage.clickOnSaveAndSubmitButton();
			try {
				PresenceOfElement(By.xpath(
						"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'saveAssignedTask')]"));
				Assert.fail();
			} catch (Exception e) {
				testVerifyLog("bidtable submited");
			}
			testStepsLog("Step " + (stepCount++), "Clear download folder");
			csvHelper.deleteDownloadedFiles();
			try {
				com.green.rfp.qa.utility.XLUtils.setCellData(datafile, "testdata","0", 1, 3);
			} catch (Exception e) {
			testInfoLog("test data status not cleared");
			}
		} else
		{
			testSkipLog("Test Case Skipped as Ref RFP not Found.");
		//	throw new SkipException("Ref RFP is not created yet.");
		}
		

	}

}
