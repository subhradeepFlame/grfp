package com.green.rfp.qa.bidtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
public class TCBid002 extends BaseClass {

	@Test
	public void editDeleteBidTable() {

		String rfpName = getCurrentTimeStampString();
		String purchaserColumneName1 = "Item name";
		String purchaserColumneName2 = "Item name 2";
		String updatedpPurchaserColumneName2 = "Item name 2 updated";
		String purchaserColumneName3 = "Unit";
		String Vendorcolumnname1 = "price";
		String Vendorcolumnname2 = "type";
		String updatedVendorcolumnname2 = "item type";
		String calculatedColumnName = "double";
		String updatedCalculatedColumnName = "double price";
		String containerName1 = "container 1";
		String containerName2 = "container 2";
		String containerName3 = "container 3";
		String bidtableName1 = "bid1";
		String bidtableName2 = "bid2";
		String bidtable2NewName = "bidtable 2 updated name";
		String bidtable2NewDescription = "bidtable 2 updated description";
		String container2UpdatedName = "container 2 updated name";
		String ItemName1 = "item 1";
		String ItemName2 = "item 2";
		String updatedItemName2 = "item 2 updated";
		String updatedItem2UnitNumber = "100";

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();

		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");

		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, "Introduction");
		testStepsLog("Step " + (stepCount++), "Select pricing = Line item Pricing");
		rfpIndexPage.selectRFPPricingType("Bidtable");
		pause(2);
		testStepsLog("Step " + (stepCount++), "Create 1st bidtable");
		bidTablePage.createNewBidtable(bidtableName1, false);
		testStepsLog("Step " + (stepCount++), "Create 2nd bidtable");
		bidTablePage.createNewBidtable(bidtableName2,false);
		pause(5);
		testStepsLog("Step " + (stepCount++), "update 2nd bidtable");
		bidTablePage.editBidTable(bidtableName2, bidtable2NewName, bidtable2NewDescription);
		testStepsLog("Step " + (stepCount++), "Verify bidtable updated success message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Bid table updated successfully')]"));
		testVerifyLog("Verified bidtable updated success message showing");
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify bidtablename and description is changed");
		Assert.assertEquals(bidtable2NewName, driver
				.findElement(By.xpath("//td[text()='#02']/following-sibling::td[@class='ng-binding']")).getText());
		Assert.assertEquals(bidtable2NewDescription,
				driver.findElement(
						By.xpath("//td[text()='#02']/following-sibling::td[@class='border-left ng-binding']"))
						.getText());
		testVerifyLog("Bidtable name and description is changed");
		testStepsLog("Step " + (stepCount++), "Delete the 2nd bidtable");
		bidTablePage.deleteBidtable(bidtable2NewName);
		testStepsLog("Step " + (stepCount++), "Verify bidtable delete message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Bidtable deleted successfully')]"));
		testVerifyLog("Verified bidtable delete message showing");
		testStepsLog("Step " + (stepCount++), "Verify 2nd bidtble is deleted");
		try {
			pause(3);
			PresenceOfElement(By.xpath("//td[text()='" + bidtable2NewName + "']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified 2nd bidtable is deleted");
		}
		testStepsLog("Step " + (stepCount++), "Click on the view icon of 1st bidtable");
		bidTablePage.clickOnBidtableViewIconRfpOwner("bid1");
		testStepsLog("Step " + (stepCount++), "Add 1st container");
		bidTablePage.addContainer(containerName1);
		testStepsLog("Step " + (stepCount++), "Add 2nd container");
		bidTablePage.addContainer(containerName2);
		testStepsLog("Step " + (stepCount++), "Add 3rd container");
		bidTablePage.addContainer(containerName3);
		testStepsLog("Step " + (stepCount++), "Edit and update the 2nd container");
		bidTablePage.editContainer("01", container2UpdatedName);
		pause(5);

		testStepsLog("Step " + (stepCount++), "Delete 2nd container");
		bidTablePage.deleteContainer("01");
		testStepsLog("Step " + (stepCount++), "Verify container delete message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Container deleted successfully')]"));
		testVerifyLog("Verified bidtable delete message showing");
		testStepsLog("Step " + (stepCount++), "Add 1st purchaser column with text format");
		bidTablePage.addPurchaserColumn(purchaserColumneName1, "Text", false);
		testStepsLog("Step " + (stepCount++), "Add 2nd purchaser column with text format");
		bidTablePage.addPurchaserColumn(purchaserColumneName2, "Text", false);
		testStepsLog("Step " + (stepCount++), "Add 3rd purchaser column with Number format");
		bidTablePage.addPurchaserColumn(purchaserColumneName3, "Number", false);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Edit 2nd purchaser column name and format to number value");
		bidTablePage.editPurchaserColumn(purchaserColumneName2, updatedpPurchaserColumneName2, "Number", false, false);
		testStepsLog("Step " + (stepCount++), "Verify the 2nd purchaser column name updated successfully");
		PresenceOfElement(By.xpath("//div[text()='" + updatedpPurchaserColumneName2 + "']"));
		testVerifyLog("Verified 2nd purchaser column name updated successfully");
		testStepsLog("Step " + (stepCount++), "Click on the edit icon of 2nd purchaser column");
		pause(3);
		scrollToElement( driver.findElement(By.xpath(
				"//div[text()='" + updatedpPurchaserColumneName2 + "']/..//md-icon[@aria-label='icon-pencil']")));
		driver.findElement(By
				.xpath("//div[text()='" + updatedpPurchaserColumneName2 + "']/..//md-icon[@aria-label='icon-pencil']"))
				.click();
		testStepsLog("Step " + (stepCount++), "Verify the purchaser column format updated successfully");
		Assert.assertEquals(driver
				.findElement(By.xpath("//h2[text()='Edit Purchaser Column']/../../..//span//div[@class='md-text']"))
				.getText(), "Number");
		testVerifyLog("Verified that purchaser column format updated successfully");
		testStepsLog("Step " + (stepCount++), "Close the purchaser column edit modal");
		bidTablePage.closePurchaserColumnEditModal();
		testStepsLog("Step " + (stepCount++), "Delete 2nd purchaser column");
		bidTablePage.deletePurchaserColumn(updatedpPurchaserColumneName2);
		testStepsLog("Step " + (stepCount++), "Verify 2nd purchaser column deleted successfully");
		pause(3);
		try {
			PresenceOfElement(By.xpath("//div[text()='" + updatedpPurchaserColumneName2 + "']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified that purchaser column deleted successfully");
		}
		testStepsLog("Step " + (stepCount++), "Add vendor column 1");
		bidTablePage.addVendorColumn(Vendorcolumnname1, "Number", "", 1);
		testStepsLog("Step " + (stepCount++), "Add vendor column 2");
		bidTablePage.addVendorColumn(Vendorcolumnname2, "Number", "", 1);
		testStepsLog("Step " + (stepCount++), "Edit 2nd vendor column name and format to dropdown value");
		bidTablePage.editVendorColumn(Vendorcolumnname2, updatedVendorcolumnname2, "Dropdown", "type", 3);
		pause(5);
		testStepsLog("Step " + (stepCount++), "Verify the 2nd vendor column name updated successfully");
		PresenceOfElement(By.xpath("//div[text()='" + updatedVendorcolumnname2 + "']"));
		testVerifyLog("Verified 2nd vendor column name updated successfully");
		pause(3);
		testStepsLog("Step " + (stepCount++), "Click on the edit icon of 2nd vendor column");
		scrollToElement( driver.findElement(
				By.xpath("//div[text()='" + updatedVendorcolumnname2 + "']/..//md-icon[@aria-label='icon-pencil']")));
		driver.findElement(
				By.xpath("//div[text()='" + updatedVendorcolumnname2 + "']/..//md-icon[@aria-label='icon-pencil']"))
				.click();
		testStepsLog("Step " + (stepCount++), "Verify the vendor column format updated successfully");
		Assert.assertEquals(
				driver.findElement(By.xpath("//h2[text()='Edit Vendor Column']/../../..//span//div[@class='md-text']"))
						.getText(),
				"Dropdown");
		testVerifyLog("Verified that vendor column format updated successfully");
		testStepsLog("Step " + (stepCount++), "Close the vendor column edit modal");
		bidTablePage.closeVendorColumnEditModal();
		testStepsLog("Step " + (stepCount++), "Delete 2nd vendor column");
		bidTablePage.deletePurchaserColumn(updatedVendorcolumnname2);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify 2nd Vendor column deleted successfully");
		try {
			PresenceOfElement(By.xpath("//div[text()='" + updatedVendorcolumnname2 + "']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified that Vendor column deleted successfully");
		}

		testStepsLog("Step " + (stepCount++), "Add a calculated column");
		bidTablePage.addCalculatedColumn(calculatedColumnName, false);
		testStepsLog("Step " + (stepCount++), "Update calculated column name");
		bidTablePage.editCalculatedColumnName(calculatedColumnName, updatedCalculatedColumnName);
		testStepsLog("Step " + (stepCount++), "Verify that calculated column name updated successfully");
		PresenceOfElement(By.xpath("//div[text()='" + updatedCalculatedColumnName + "']"));
		testVerifyLog("Verified that calculated column name updated successfully");
		pause(3);
		testStepsLog("Step " + (stepCount++), "Delete that calculated column");
		bidTablePage.deleteCalculatedColumn(updatedCalculatedColumnName);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify that calculated column deleted successfully");
		try {
			PresenceOfElement(By.xpath("//div[text()='" + updatedCalculatedColumnName + "']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified that calculated column deleted successfully");
		}
		testStepsLog("Step " + (stepCount++), "Add 2 items to container 1");
		bidTablePage.addItemWith2PurchaserColumn(containerName1, ItemName1, purchaserColumneName1, purchaserColumneName3);
		bidTablePage.addItemWith2PurchaserColumn(containerName1, ItemName2, purchaserColumneName1, purchaserColumneName3);
		testStepsLog("Step " + (stepCount++), "Edit 2nd item name,container and unit");
		bidTablePage.editItem(ItemName2, updatedItemName2, containerName3, purchaserColumneName1, purchaserColumneName3,
				updatedItem2UnitNumber);
		testStepsLog("Step " + (stepCount++), "Expand 2nd container");
		bidTablePage.expandContainer("01");
		testStepsLog("Step " + (stepCount++), "Verify that the item name,unit number is changed");
		PresenceOfElement(By.xpath("//span[text()='" + updatedItemName2 + "']"));
		PresenceOfElement(By.xpath("//span[text()='" + updatedItem2UnitNumber + "']"));
		testVerifyLog("Item name and unit number changed successfully verified");
		testStepsLog("Step " + (stepCount++), "Verify that the item 2 is moved to the 2nd container");
		try {
			System.out.println("trying to find the item in under first container");
			PresenceOfElement(
					By.xpath("//td[text()='#00']//../following-sibling::tr//span[text()='" + updatedItemName2 + "']"));
			Assert.fail();
		} catch (Exception e) {
			System.out.println("trying to find the item in under 2nd container");
			PresenceOfElement(
					By.xpath("//td[text()='#01']//../following-sibling::tr//span[text()='" + updatedItemName2 + "']"));
			testVerifyLog("item 2 is moved to the 2nd container is verified");
		}
		testStepsLog("Step " + (stepCount++), "Delete 1st item of container 1");
		bidTablePage.delteItem(ItemName1);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify that item 1 is deleted");
		try {
			PresenceOfElement(By.xpath("//span[text()='" + ItemName1 + "']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified that Vendor column deleted successfully");
		}
		testStepsLog("Step " + (stepCount++), "Add 3 items to container 1");
		for (int i = 1; i <= 3; i++) {
			bidTablePage.addItemWith2PurchaserColumn(containerName1, containerName1 + " item " + i, purchaserColumneName1,
					purchaserColumneName3);
		}
		testStepsLog("Step " + (stepCount++),
				"Click on the 1st container checkbox for select all items under the container");
		bidTablePage.SelectContainerCheckbox("00");
		testStepsLog("Step " + (stepCount++), "Bulk move container 1 all items to the 3rd container");
		bidTablePage.BulkMoveContainerItems(containerName3);
		testStepsLog("Step " + (stepCount++), "Verify success message is showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Items moved successfully ')]"));
		testVerifyLog("success message showing verified");
		testStepsLog("Step " + (stepCount++), "Verify all the items moved to the 3rd container successfully");
		for (int i = 1; i < 4; i++) {
			try {
				// checking all items are present in the container 1
				PresenceOfElement(
						By.xpath("//td[text()='#00']/../..//span[text()='" + containerName1 + " item " + i + "']"));
				Assert.fail();
			} catch (Exception e) {
				// checking all items are present in the container 3
				PresenceOfElement(
						By.xpath("//td[text()='#01']/../..//span[text()='" + containerName1 + " item " + i + "']"));
				testVerifyLog("Item moved to container 3 successfully verified");
			}
		}
		testStepsLog("Step " + (stepCount++),
				"Click on the 3rd container checkbox for select all items under the container");
		bidTablePage.SelectContainerCheckbox("01");
		testStepsLog("Step " + (stepCount++), "Bulk Delete all the items under the container");
		bidTablePage.BulkDeleteContainerItems();
		testStepsLog("Step " + (stepCount++), "Verify success message is showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Item deleted successfully')]"));
		testVerifyLog("success message showing verified");
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify all the items are deleted under the container");
		for (int i = 1; i < 4; i++) {
			try {
				// checking all items are present in the container 2, if not then it is deleted
				PresenceOfElement(
						By.xpath("//td[text()='#01']/../..//span[text()='" + containerName1 + " item " + i + "']"));
				Assert.fail();
			} catch (Exception e) {
				testVerifyLog("Item deleted verified");
			}
		}
		
		
		
				
	}

}
