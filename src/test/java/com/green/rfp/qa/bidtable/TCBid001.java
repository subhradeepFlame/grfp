package com.green.rfp.qa.bidtable;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TCBid001 extends BaseClass {

	@Test
	public void CheckBidtableFlow() {
		String rfpName = getCurrentTimeStampString();
		String prchaserColumneName1 = "Item name";
		String prchaserColumneName2 = "unit";
		String Vendorcolumnname1 = "price";
		String Vendorcolumnname2 = "item type";
		String calculatedColumn = "double price";
		String containerName1 = "container 1";
		String containerName2 = "container 2";
		String containerName3 = "container 3";
		String bidtableName1 = "bid1";
		String bidtableName2 = "bid2";
		String itemImportCsvPath = System.getProperty("user.dir")
				+ "/src/main/java/com/green/rfp/qa/testdata/Bidtable item bulk upload.csv";

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
		testStepsLog("Step " + (stepCount++), "Select pricing = Line item Pricing");
		rfpIndexPage.selectRFPPricingType("Bidtable");
		pause(2);
		testStepsLog("Step " + (stepCount++), "Create 1st bidtable");
		bidTablePage.createNewBidtable(bidtableName1, false);
		testStepsLog("Step " + (stepCount++), "Verify bid table created success message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Bid table created successfully')]"));
		testVerifyLog("Verified bid table created success message showing");
		testStepsLog("Step " + (stepCount++), "Verify Created bid table is showing int the bidtables list");
		PresenceOfElement(By.xpath("//td[text()='" + bidtableName1 + "']"));
		testVerifyLog("Verified Created bid table is showing int the bidtables list");
		testStepsLog("Step " + (stepCount++), "Create 2nd bidtable");
		bidTablePage.createNewBidtable(bidtableName2, false);
		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on the view icon of 1st bidtable");
		bidTablePage.clickOnBidtableViewIconRfpOwner(bidtableName1);
		testStepsLog("Step " + (stepCount++), "Add 1st container");
		bidTablePage.addContainer(containerName1);
		testStepsLog("Step " + (stepCount++), "Verify container created success message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Container created successfully')]"));
		testVerifyLog("Verified container created success message showing");
		testStepsLog("Step " + (stepCount++), "Add 2nd container");
		bidTablePage.addContainer(containerName2);
		testStepsLog("Step " + (stepCount++), "Add 1st purchaser column with text format");
		bidTablePage.addPurchaserColumn(prchaserColumneName1, "Text", false);
		testStepsLog("Step " + (stepCount++), "Verify purchaser column created success message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Column created successfully')]"));
		testVerifyLog("Verified purchaser column created success message showing");
		testStepsLog("Step " + (stepCount++),
				"Verify added purchaser column showing under purchaser column heading in the bidtable");
		PresenceOfElement(By.xpath("//div[contains(text(),'Purchaser Columns')]/../../..//div[contains(text(),'"
				+ prchaserColumneName1 + "')]"));
		testVerifyLog("Verified added purchaser column showing correctly");
		testStepsLog("Step " + (stepCount++), "Add 2nd purchaser column with number format");
		bidTablePage.addPurchaserColumn(prchaserColumneName2, "Number", false);
		testStepsLog("Step " + (stepCount++), "Add Vendor column with number format");
		bidTablePage.addVendorColumn(Vendorcolumnname1, "Number", "", 1);
		testStepsLog("Step " + (stepCount++), "Verify Vendor column created success message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Column created successfully')]"));
		testVerifyLog("Verified Vendor column created success message showing");
		testStepsLog("Step " + (stepCount++),
				"Verify added Vendor column showing under Vendor column heading in the bidtable");
		PresenceOfElement(By.xpath("//div[contains(text(),'Vendor Columns')]/../../..//div[contains(text(),'"
				+ Vendorcolumnname1 + "')]"));
		testVerifyLog("Verified added Vendor column showing correctly");
		testStepsLog("Step " + (stepCount++), "Add Vendor column with dropdown format");
		bidTablePage.addVendorColumn(Vendorcolumnname2, "Dropdown", "type", 3);
		testStepsLog("Step " + (stepCount++), "Add calculated column");
		bidTablePage.addCalculatedColumn(calculatedColumn, false);
		testStepsLog("Step " + (stepCount++), "Update Extended cost column formula");
		bidTablePage.updateFormulaForExtendedColumn("Extended Cost", prchaserColumneName2, Vendorcolumnname1);
		testStepsLog("Step " + (stepCount++), "Update added calculated column formula");
		bidTablePage.updateFormulaForExtendedColumnWithMultiply(calculatedColumn, Vendorcolumnname1, 2);
		testStepsLog("Step " + (stepCount++), "Add 3 items to container 1");
		for (int i = 1; i <= 3; i++) {
			bidTablePage.addItemWith2PurchaserColumn(containerName1, containerName1 + " item " + i,
					prchaserColumneName1, prchaserColumneName2);
		}
		testStepsLog("Step " + (stepCount++), "Add 2 items to container 2");
		for (int i = 1; i <= 2; i++) {
			bidTablePage.addItemWith2PurchaserColumn(containerName2, containerName2 + " item " + i,
					prchaserColumneName1, prchaserColumneName2);
		}
		testStepsLog("Step " + (stepCount++), "Verify item created success message showing");
		PresenceOfElement(By.xpath("//span[contains(text(),'Item created successfully')]"));
		testVerifyLog("Verified item created success message showing");

		testStepsLog("Step " + (stepCount++), "Refresh the page");
		driver.navigate().refresh();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Click on Section tab");
		dashboardIndexPage.clickOnRFPTemplateTab("Sections");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Click on the view icon of 2nd bidtable");
		bidTablePage.clickOnBidtableViewIconRfpOwner(bidtableName2);
		testStepsLog("Step " + (stepCount++), "Add 3rd container");
		bidTablePage.addContainer(containerName3);
		testStepsLog("Step " + (stepCount++), "Add purchaser column with text format");
		bidTablePage.addPurchaserColumn(prchaserColumneName1, "Text", false);
		testStepsLog("Step " + (stepCount++), "Add 2nd purchaser column with number format");
		bidTablePage.addPurchaserColumn(prchaserColumneName2, "Number", false);
		testStepsLog("Step " + (stepCount++), "Add Vendor column with number format");
		bidTablePage.addVendorColumn(Vendorcolumnname1, "Number", "", 1);
		testStepsLog("Step " + (stepCount++), "Update Extended cost column formula");
		bidTablePage.updateFormulaForExtendedColumn("Extended Cost", prchaserColumneName2, Vendorcolumnname1);
		try {
			testStepsLog("Step " + (stepCount++), "add items to container 3 by csv import");
			bidTablePage.addBidtableItemByCsvUpload(itemImportCsvPath);
			testStepsLog("Step " + (stepCount++), "Verify item created success message showing");
			PresenceOfElement(By.xpath("//span[contains(text(),'Item created successfully')]"));
			testVerifyLog("Verified item created success message showing");
		} catch (Exception e) {
			testStepsLog("Step " + (stepCount++), "Click on cancel button");
			bidTablePage.clickOnCancelButtonOfItemImport();
			testStepsLog("Step " + (stepCount++), "Add 3 items to container 3");
			for (int i = 1; i <= 3; i++) {
				bidTablePage.addItemWith2PurchaserColumn(containerName3, containerName3 + " item " + i,
						prchaserColumneName1, prchaserColumneName2);
			}
		}
		testStepsLog("Step " + (stepCount++), "Verify all the added items are showing");
		for (int i = 1; i < 4; i++) {
			PresenceOfElement(By.xpath("//span[contains(text(),'container 3 item " + i + "')]"));
		}

		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button");
		rfpIndexPage.clickOnContinueButton("Sections");
		waitForPageLoaded();
		pause(5);
		testStepsLog("Step " + (stepCount++), " Click on continue button on sme page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on continue button on review page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("gotoAprrovers");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on skip approval checkbox");
		pause(3);
		driver.findElement(By.xpath("//div[@class='layout-column']//md-checkbox[@aria-label='Skip Approvals']"))
				.click();
		pause(3);

		testStepsLog("Step " + (stepCount++), " Click on continue button on Approvers page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveApprovers");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 2.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender11@mailinator.com");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 3");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender12@mailinator.com");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Send RFP to Vendors");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		waitForPageLoaded();

	}
}
