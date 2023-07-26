package com.green.rfp.qa.pages;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.csvHelper;

public class bidTablePage extends BaseClass {
	DecimalFormat df = new DecimalFormat("#,###.00");

	public bidTablePage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewBidtable(String bidtableName, Boolean allowNoBids) {
		testStepsLog("Step " + (stepCount++), "Click on the create button");
		scrollToElement(driver.findElement(By.xpath("//button[text()='Create']")));
		jsClick(driver.findElement(By.xpath("//button[text()='Create']")));
		testStepsLog("Step " + (stepCount++), "Enter bidtable name");
		driver.findElement(By.xpath("//input[contains(@ng-model,'bidtable_name')]")).sendKeys(bidtableName);
		testStepsLog("Step " + (stepCount++), "Enter bidtable description");
		driver.findElement(By.xpath("//textarea[contains(@ng-model,'bidtable_description')]"))
				.sendKeys("Description of " + bidtableName);
		if (allowNoBids.equals(true)) {
			testStepsLog("Step " + (stepCount++), "Select yes option of allow no bids");
			scrollToElement(driver.findElement(By.xpath(
					"//label[text()='Allow No Bids']/..//md-radio-button[@aria-checked='false']//div[@class='md-off']")));
			jsClick(driver.findElement(By.xpath(
					"//label[text()='Allow No Bids']/..//md-radio-button[@aria-checked='false']//div[@class='md-off']")));
		}
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveBidtable()']")));
	}

	public void clickOnBidtableViewIconRfpOwner(String bidtableName) {
		pause(6);
		jsClick(driver.findElement(
				By.xpath("//td[text()='" + bidtableName + "']/..//button[contains(@ng-click,'viewBidtableDialog')]")));
	}

	public void clickOnBidtableViewIconVendor(String bidtableName) {
		pause(6);
		jsClick(driver.findElement(By.xpath(
				"//td[text()='" + bidtableName + "']/..//button[contains(@ng-click,'viewVendorBidtableDialog')]")));
	}

	public void clickOnBidtableGroupButton(String buttonName) {
		scrollToElement(
				driver.findElement(By.xpath("//div[@class='button-group']//button[text()='" + buttonName + "']")));
		jsClick(driver.findElement(By.xpath("//div[@class='button-group']//button[text()='" + buttonName + "']")));
	}

	public void addContainer(String containerName) {
		testStepsLog("Step " + (stepCount++), "Click on Add container button");
		clickOnBidtableGroupButton("Add Container");
		testStepsLog("Step " + (stepCount++), "Enter container name");
		driver.findElement(By.xpath("//input[@ng-model='vm.container_name']")).sendKeys(containerName);
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveContainer()']")));
	}

	public void clickOnAddColumnDropdown() {
		scrollToElement(driver.findElement(By.xpath("//button[@ng-click='$mdOpenMenu($event)']")));
		jsClick(driver.findElement(By.xpath("//button[@ng-click='$mdOpenMenu($event)']")));
	}

	public void addPurchaserColumn(String purchaserColumnNmae, String format, Boolean hiddenFromVendors) {
		testStepsLog("Step " + (stepCount++), "Click on Add Column dropdown");
		clickOnAddColumnDropdown();
		pause(2);
		testStepsLog("Step " + (stepCount++), "Click on Purchaser column");
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Purchaser Column')]")));
		pause(2);
		testStepsLog("Step " + (stepCount++), "Add purchaser column title");
		driver.findElement(By.xpath("//md-dialog[@role='dialog']//input[@ng-model='vm.bidtable_column_title']"))
				.sendKeys(purchaserColumnNmae);
		switch (format) {
		case "Text":

			break;
		case "Number":
			testStepsLog("Step " + (stepCount++), "Click on format dropdown");
			jsClick(driver
					.findElement(By.xpath("//md-dialog[@role='dialog']//md-select-value[@class='md-select-value']")));
			testStepsLog("Step " + (stepCount++), "Click on Number");
			jsClick(driver.findElement(By.xpath("//div[text()='Number']/..")));
			break;
		}
		if (hiddenFromVendors.equals(true)) {
			testStepsLog("Step " + (stepCount++), "Select yes option from hidden from vendors");
			scrollToElement(driver.findElement(By.xpath(
					"//md-input-container[contains(@ng-if,'bidColumnType')]//md-radio-button//div[text()='Yes']/..")));
			jsClick(driver.findElement(By.xpath(
					"//md-input-container[contains(@ng-if,'bidColumnType')]//md-radio-button//div[text()='Yes']/..")));
		}
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveBidtableColumn()']")));

	}

	public void addVendorColumn(String vendorColumnNmae, String format, String dropdownOptionName,
			int dropdownOptionNumber) {
		testStepsLog("Step " + (stepCount++), "Click on Add Column dropdown");
		clickOnAddColumnDropdown();
		testStepsLog("Step " + (stepCount++), "Click on Vendor column");
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Vendor Column')]")));
		testStepsLog("Step " + (stepCount++), "Add vendor column title");
		driver.findElement(By.xpath("//md-dialog[@role='dialog']//input[@ng-model='vm.bidtable_column_title']"))
				.sendKeys(vendorColumnNmae);
		switch (format) {
		case "Number":
			testStepsLog("Step " + (stepCount++), "Click on format fropdown");
			jsClick(driver.findElement(
					By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.bidtable_column_format']")));
			testStepsLog("Step " + (stepCount++), "Click on Number");
			jsClick(driver.findElement(By.xpath("//div[text()='Number']/..")));
			break;
		case "Dropdown":
			for (int i = 1; i <= dropdownOptionNumber; i++) {
				testStepsLog("Step " + (stepCount++), "Click on format fropdown");
				jsClick(driver.findElement(
						By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.bidtable_column_format']")));
				testStepsLog("Step " + (stepCount++), "Click on Dropdown option");
				jsClick(driver.findElement(By.xpath("//div[text()='Dropdown']/..")));
				testStepsLog("Step " + (stepCount++), "Click on option");
				jsClick(driver.findElement(By.xpath("//input[@ng-focus='$mdChipsCtrl.onInputFocus()']")));
				testStepsLog("Step " + (stepCount++), "Enter dropdown value: " + i);
				driver.findElement(By.xpath("//input[@ng-focus='$mdChipsCtrl.onInputFocus()']"))
						.sendKeys(dropdownOptionName + ": " + i);

			}
			break;
		}
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveBidtableColumn()']")));

	}

	public void addCalculatedColumn(String CalculatedColumnNmae, Boolean hiddenFromVendors) {
		testStepsLog("Step " + (stepCount++), "Click on Add Column dropdown");
		clickOnAddColumnDropdown();
		testStepsLog("Step " + (stepCount++), "Click on calculated column");
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Calculated Column')]")));
		pause(2);
		testStepsLog("Step " + (stepCount++), "Add calculated column title");
		driver.findElement(By.xpath("//md-dialog[@role='dialog']//input[@ng-model='vm.bidtable_column_title']"))
				.sendKeys(CalculatedColumnNmae);
		if (hiddenFromVendors.equals(true)) {
			testStepsLog("Step " + (stepCount++), "Select yes option from hidden from vendors");
			scrollToElement(driver.findElement(By.xpath(
					"//md-input-container[contains(@ng-if,'vm.bidColumnType')]//md-radio-button[@aria-checked='false']//div[@class='md-off']")));
			jsClick(driver.findElement(By.xpath(
					"//md-input-container[contains(@ng-if,'vm.bidColumnType')]//md-radio-button[@aria-checked='false']//div[@class='md-off']")));
		}
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveBidtableColumn()']")));

	}

	public void clickOnCalculatedColumnEditIcon(String calculatedColumnName) {
		pause(3);
		scrollToElement(driver.findElement(
				By.xpath("//div[text()='" + calculatedColumnName + "']/..//button[@aria-label='Edit Column']")));
		pause(5);
		driver.findElement(
				By.xpath("//div[text()='" + calculatedColumnName + "']/..//button[@aria-label='Edit Column']")).click();
	}

	public void updateFormulaForExtendedColumn(String calculatedColumnName, String PurchaserColumnName,
			String VendorColumnName) {
		testStepsLog("Step " + (stepCount++), "Click on Edit Icon of caculated column");
		clickOnCalculatedColumnEditIcon(calculatedColumnName);
		testStepsLog("Step " + (stepCount++), "Click on Purchaser Column Name button");
		scrollToElement(driver.findElement(By.xpath("//button[text()='" + PurchaserColumnName + "']")));
		jsClick(driver.findElement(By.xpath("//button[text()='" + PurchaserColumnName + "']")));
		testStepsLog("Step " + (stepCount++), "Enter * to formula field");
		scrollToElement(driver.findElement(By.xpath("//input[@ng-model='vm.bidtable_column_formula']")));
		driver.findElement(By.xpath("//input[@ng-model='vm.bidtable_column_formula']")).sendKeys("*");
		testStepsLog("Step " + (stepCount++), "Click on Vendor Column Name button");
		scrollToElement(driver.findElement(By.xpath("//button[text()='" + VendorColumnName + "']")));
		jsClick(driver.findElement(By.xpath("//button[text()='" + VendorColumnName + "']")));
		testStepsLog("Step " + (stepCount++), "Click on the update button");
		jsClick(driver.findElement(
				By.xpath("//md-dialog-actions[@class='layout-row']//button[@ng-click='vm.updateBidtableColumn()']")));

	}

	public void updateFormulaForExtendedColumnWithMultiply(String calculatedColumnName, String VendorColumnName,
			int multipleNumber) {
		testStepsLog("Step " + (stepCount++), "Click on Edit Icon of caculated column");
		clickOnCalculatedColumnEditIcon(calculatedColumnName);
		testStepsLog("Step " + (stepCount++), "Click on Purchaser Column Name button");
		scrollToElement(driver.findElement(By.xpath("//button[text()='" + VendorColumnName + "']")));
		jsClick(driver.findElement(By.xpath("//button[text()='" + VendorColumnName + "']")));
		testStepsLog("Step " + (stepCount++), "Enter * to formula field");
		scrollToElement(driver.findElement(By.xpath("//input[@ng-model='vm.bidtable_column_formula']")));
		driver.findElement(By.xpath("//input[@ng-model='vm.bidtable_column_formula']")).sendKeys("*" + multipleNumber);
		testStepsLog("Step " + (stepCount++), "Click on the update button");
		jsClick(driver.findElement(
				By.xpath("//md-dialog-actions[@class='layout-row']//button[@ng-click='vm.updateBidtableColumn()']")));

	}

	public void addItemWith2PurchaserColumn(String containerName, String itemName, String purchaserColumnName1,
			String purchaserColumnName2) {
		int min = 1;
		int max = 10;
		Random random = new Random();
		int value = random.nextInt(max - min + 1) + min;

		testStepsLog("Step " + (stepCount++), "Click on Add Item button");
		clickOnBidtableGroupButton("Add Item");
		testStepsLog("Step " + (stepCount++), "Select Container");
		scrollToElement(
				driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.container_id']")));
		jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.container_id']")));
		jsClick(driver.findElement(By.xpath("//md-option//div[text()='" + containerName + "']")));
		testStepsLog("Step " + (stepCount++), "Enter item name");
		scrollToElement(driver
				.findElement(By.xpath("//label[text()='" + purchaserColumnName1 + "']/following-sibling::input")));
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName1 + "']/following-sibling::input"))
				.sendKeys(itemName);
		testStepsLog("Step " + (stepCount++), "Enter unit number");
		scrollToElement(driver
				.findElement(By.xpath("//label[text()='" + purchaserColumnName2 + "']/following-sibling::input")));
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName2 + "']/following-sibling::input"))
				.sendKeys(Integer.toString(value));

		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveLineitem()']")));

	}

	public void addItemWith3PurchaserColumn(String containerName, String itemName, String purchaserColumnName1,
			String purchaserColumnName2, String purchaserColumnName3) {
		int min = 1;
		int max = 10;
		Random random = new Random();
		int value = random.nextInt(max - min + 1) + min;

		testStepsLog("Step " + (stepCount++), "Click on Add Item button");
		clickOnBidtableGroupButton("Add Item");
		testStepsLog("Step " + (stepCount++), "Select Container");
		scrollToElement(
				driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.container_id']")));
		jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.container_id']")));
		jsClick(driver.findElement(By.xpath("//md-option//div[text()='" + containerName + "']")));
		testStepsLog("Step " + (stepCount++), "Enter item name");
		scrollToElement(driver
				.findElement(By.xpath("//label[text()='" + purchaserColumnName1 + "']/following-sibling::input")));
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName1 + "']/following-sibling::input"))
				.sendKeys(itemName);
		testStepsLog("Step " + (stepCount++), "Enter unit number");
		scrollToElement(driver
				.findElement(By.xpath("//label[text()='" + purchaserColumnName2 + "']/following-sibling::input")));
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName2 + "']/following-sibling::input"))
				.sendKeys(Integer.toString(value));
		testStepsLog("Step " + (stepCount++), "Enter 3rd purchaser column value");
		scrollToElement(driver
				.findElement(By.xpath("//label[text()='" + purchaserColumnName3 + "']/following-sibling::input")));
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName3 + "']/following-sibling::input"))
				.sendKeys(Integer.toString(value));

		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveLineitem()']")));

	}

	public void editBidTable(String BidtableName, String newNameOfBidtable, String newDescriptionOfBidtable) {
		testStepsLog("Step " + (stepCount++), "Scroll to the bidtable");
		scrollToElement(driver.findElement(By.xpath("//td[contains(text(),'" + BidtableName
				+ "')]/..//button[contains(@ng-click,'openEditBidtableDialog')]")));
		testStepsLog("Step " + (stepCount++), "Click on the edit icon of the bidtable");
		driver.findElement(By.xpath("//td[contains(text(),'" + BidtableName
				+ "')]/..//button[contains(@ng-click,'openEditBidtableDialog')]")).click();
		testStepsLog("Step " + (stepCount++), "Enter bidtable new name");
		driver.findElement(By.xpath("//input[contains(@ng-model,'bidtable_name')]")).clear();
		driver.findElement(By.xpath("//input[contains(@ng-model,'bidtable_name')]")).sendKeys(newNameOfBidtable);
		testStepsLog("Step " + (stepCount++), "Enter bidtable new description");
		driver.findElement(By.xpath("//textarea[contains(@ng-model,'bidtable_description')]")).clear();
		driver.findElement(By.xpath("//textarea[contains(@ng-model,'bidtable_description')]"))
				.sendKeys(newDescriptionOfBidtable);
		testStepsLog("Step " + (stepCount++), "Click on update button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.updateBidtable()']")));

	}

	public void deleteBidtable(String BidtableName) {
		testStepsLog("Step " + (stepCount++), "Scroll to the bidtable");
		scrollToElement(driver.findElement(
				By.xpath("//td[text()='" + BidtableName + "']/..//md-icon[@md-font-icon='icon-trash']/..")));
		testStepsLog("Step " + (stepCount++), "Click on the delete icon of the bidtable");
		jsClick(driver.findElement(
				By.xpath("//td[text()='" + BidtableName + "']/..//md-icon[@md-font-icon='icon-trash']/..")));
		testStepsLog("Step " + (stepCount++), "Click on yes");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));
	}

	public void editContainer(String containerNumber, String updatedContainerName) {
		testStepsLog("Step " + (stepCount++), "Scroll to the container");
		scrollToElement(driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='#" + containerNumber
				+ "']/..//button[@aria-label='Edit Container']")));
		testStepsLog("Step " + (stepCount++), "Click on the edit icon of the container");
		jsClick(driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='#" + containerNumber
				+ "']/..//button[@aria-label='Edit Container']")));
		testStepsLog("Step " + (stepCount++), "Enter new container name");
		driver.findElement(By.xpath("//input[@ng-model='vm.container_name']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='vm.container_name']")).sendKeys(updatedContainerName);
		testStepsLog("Step " + (stepCount++), "Click on the update button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.updateContainer()']")));
	}

	public void deleteContainer(String containerNumber) {

		testStepsLog("Step " + (stepCount++), "Scroll to the container");
		scrollToElement(driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='#" + containerNumber
				+ "']/..//button[@aria-label='Delete Container']")));
		testStepsLog("Step " + (stepCount++), "Click on the deete icon of the container");
		jsClick(driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='#" + containerNumber
				+ "']/..//button[@aria-label='Delete Container']")));
		testStepsLog("Step " + (stepCount++), "Click on yes");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));

	}

	public void editPurchaserColumn(String purchaserColumnName, String UpdatedPurchaserColumnName, String format,
			Boolean hiddenFromVendors, Boolean currentlyHiddenFromVendor) {

		testStepsLog("Step " + (stepCount++), "Click on edit icon of the purchaser column");
		scrollToElement(driver.findElement(
				By.xpath("//div[text()='" + purchaserColumnName + "']/..//md-icon[@aria-label='icon-pencil']")));
		jsClick(driver.findElement(
				By.xpath("//div[text()='" + purchaserColumnName + "']/..//md-icon[@aria-label='icon-pencil']")));
		testStepsLog("Step " + (stepCount++), "Edit purchaser column title");
		driver.findElement(By.xpath("//md-dialog[@role='dialog']//input[@ng-model='vm.bidtable_column_title']"))
				.clear();
		driver.findElement(By.xpath("//md-dialog[@role='dialog']//input[@ng-model='vm.bidtable_column_title']"))
				.sendKeys(UpdatedPurchaserColumnName);
		testStepsLog("Step " + (stepCount++), "Click on format fropdown");
		jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-select-value[@class='md-select-value']")));
		switch (format) {
		case "Text":
			testStepsLog("Step " + (stepCount++), "Click on Text");
			jsClick(driver
					.findElement(By.xpath("//md-option[contains(@ng-if,'bidColumnType')]//div[text()='Text']/..")));

			break;
		case "Number":
			testStepsLog("Step " + (stepCount++), "Click on Number");
			jsClick(driver.findElement(By.xpath("//div[text()='Number']/..")));
			break;
		}
		if (hiddenFromVendors.equals(currentlyHiddenFromVendor)) {

		} else {
			if (hiddenFromVendors.equals(true)) {
				testStepsLog("Step " + (stepCount++), "Select yes option from hidden from vendors");
				scrollToElement(driver.findElement(By.xpath(
						"//md-input-container[contains(@ng-if,'bidColumnType')]//md-radio-button//div[text()='Yes']/..")));
				jsClick(driver.findElement(By.xpath(
						"//md-input-container[contains(@ng-if,'bidColumnType')]//md-radio-button//div[text()='Yes']/..")));
			} else if (hiddenFromVendors.equals(false)) {
				testStepsLog("Step " + (stepCount++), "Select no option from hidden from vendors");
				scrollToElement(driver.findElement(By.xpath(
						"//md-input-container[contains(@ng-if,'bidColumnType')]//md-radio-button//div[text()='No']/..")));
				jsClick(driver.findElement(By.xpath(
						"//md-input-container[contains(@ng-if,'bidColumnType')]//md-radio-button//div[text()='No']/..")));
			}

		}
		testStepsLog("Step " + (stepCount++), "Click on update button");
		jsClick(driver.findElement(By.xpath(
				"//h2[text()='Edit Purchaser Column']/../../..//button[@ng-click='vm.updateBidtableColumn()']")));

	}

	public void closePurchaserColumnEditModal() {
		scrollToElement(driver
				.findElement(By.xpath("//h2[text()='Edit Purchaser Column']/../../..//button[@ng-click='cancel()']")));
		jsClick(driver
				.findElement(By.xpath("//h2[text()='Edit Purchaser Column']/../../..//button[@ng-click='cancel()']")));
	}

	public void deletePurchaserColumn(String purchaserColumnName) {

		scrollToElement(driver.findElement(By.xpath("//div[text()='" + purchaserColumnName + "']")));
		testStepsLog("Step " + (stepCount++), "Click on the delete icon of the purchaser column");
		jsClick(driver.findElement(By.xpath("//div[text()='" + purchaserColumnName
				+ "']/..//button[contains(@ng-click,'openDeleteColumnDialog')]")));
		testStepsLog("Step " + (stepCount++), "Click on yes");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));
	}

	public void editVendorColumn(String vendorColumnName, String updatedVendorColumnName, String format,
			String dropdownOptionName, int dropdownOptionNumber) {
		testStepsLog("Step " + (stepCount++), "Click on edit icon of the vendor column");
		scrollToElement(driver.findElement(
				By.xpath("//div[text()='" + vendorColumnName + "']/..//md-icon[@aria-label='icon-pencil']")));
		jsClick(driver.findElement(
				By.xpath("//div[text()='" + vendorColumnName + "']/..//md-icon[@aria-label='icon-pencil']")));
		testStepsLog("Step " + (stepCount++), "Edit vendor column title");
		driver.findElement(By.xpath("//md-dialog[@role='dialog']//input[@ng-model='vm.bidtable_column_title']"))
				.clear();
		driver.findElement(By.xpath("//md-dialog[@role='dialog']//input[@ng-model='vm.bidtable_column_title']"))
				.sendKeys(updatedVendorColumnName);

		switch (format) {
		case "Number":
			testStepsLog("Step " + (stepCount++), "Click on format dropdown");
			jsClick(driver
					.findElement(By.xpath("//md-dialog[@role='dialog']//md-select-value[@class='md-select-value']")));
			testStepsLog("Step " + (stepCount++), "Click on Text");
			jsClick(driver
					.findElement(By.xpath("//md-option[contains(@ng-if,'bidColumnType')]//div[text()='Text']/..")));

			break;
		case "Dropdown":
			for (int i = 1; i <= dropdownOptionNumber; i++) {
				testStepsLog("Step " + (stepCount++), "Click on format dropdown");
				jsClick(driver.findElement(
						By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.bidtable_column_format']")));
				testStepsLog("Step " + (stepCount++), "Click on Dropdown option");
				jsClick(driver.findElement(By.xpath("//div[text()='Dropdown']/..")));
				testStepsLog("Step " + (stepCount++), "Click on option");
				jsClick(driver.findElement(By.xpath("//input[@ng-focus='$mdChipsCtrl.onInputFocus()']")));
				testStepsLog("Step " + (stepCount++), "Enter dropdown value: " + i);
				driver.findElement(By.xpath("//input[@ng-focus='$mdChipsCtrl.onInputFocus()']"))
						.sendKeys(dropdownOptionName + ": " + i);

			}
			break;
		}
		testStepsLog("Step " + (stepCount++), "Click on update button");
		jsClick(driver.findElement(
				By.xpath("//h2[text()='Edit Vendor Column']/../../..//button[@ng-click='vm.updateBidtableColumn()']")));
	}

	public void closeVendorColumnEditModal() {
		scrollToElement(driver
				.findElement(By.xpath("//h2[text()='Edit Vendor Column']/../../..//button[@ng-click='cancel()']")));
		jsClick(driver
				.findElement(By.xpath("//h2[text()='Edit Vendor Column']/../../..//button[@ng-click='cancel()']")));
	}

	public void editCalculatedColumnName(String calculatedColumnName, String updatedcalculatedColumnName) {
		testStepsLog("Step " + (stepCount++), "Click on edit icon of the calculated column");
		scrollToElement(driver.findElement(
				By.xpath("//div[text()='" + calculatedColumnName + "']/..//md-icon[@aria-label='icon-pencil']")));
		jsClick(driver.findElement(
				By.xpath("//div[text()='" + calculatedColumnName + "']/..//md-icon[@aria-label='icon-pencil']")));
		pause(5);
		testStepsLog("Step " + (stepCount++), "Edit calculated column title");
		driver.findElement(By.xpath(
				"//md-dialog[@class='_md md-default-theme md-transition-in']//input[@ng-model='vm.bidtable_column_title']"))
				.clear();
		driver.findElement(By.xpath(
				"//md-dialog[@class='_md md-default-theme md-transition-in']//input[@ng-model='vm.bidtable_column_title']"))
				.sendKeys(updatedcalculatedColumnName);
		testStepsLog("Step " + (stepCount++), "Click on the update button");
		jsClick(driver.findElement(By.xpath(
				"//md-dialog[@class='_md md-default-theme md-transition-in']//button[@ng-click='vm.updateBidtableColumn()']")));
	}

	public void deleteCalculatedColumn(String calculatedColumnName) {
		scrollToElement(driver.findElement(By.xpath("//div[text()='" + calculatedColumnName + "']")));
		testStepsLog("Step " + (stepCount++), "Click on the delete icon of the Calculated column");
		driver.findElement(By.xpath("//div[text()='" + calculatedColumnName
				+ "']/..//button[contains(@ng-click,'openDeleteColumnDialog')]")).click();
		testStepsLog("Step " + (stepCount++), "Click on yes");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));
	}

	public void editItem(String itemName, String UpdatedItemName, String containerName, String purchaserColumnName1,
			String purchaserColumnName2, String updatedUnitNumber) {
		testStepsLog("Step " + (stepCount++), "Click on the edit icon of the item");
		scrollToElement(driver.findElement(By
				.xpath("//span[text()='" + itemName + "']//..//..//button[contains(@ng-click,'openEditItemDialog')]")));
		jsClick(driver.findElement(By
				.xpath("//span[text()='" + itemName + "']//..//..//button[contains(@ng-click,'openEditItemDialog')]")));
		testStepsLog("Step " + (stepCount++), "update Container");
		scrollToElement(
				driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.container_id']")));
		jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-select[@ng-model='vm.container_id']")));
		jsClick(driver.findElement(By.xpath("//md-option//div[text()='" + containerName + "']")));
		testStepsLog("Step " + (stepCount++), "Edit item name");
		scrollToElement(driver
				.findElement(By.xpath("//label[text()='" + purchaserColumnName1 + "']/following-sibling::input")));
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName1 + "']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName1 + "']/following-sibling::input"))
				.sendKeys(UpdatedItemName);
		testStepsLog("Step " + (stepCount++), "Edit unit number");
		scrollToElement(driver
				.findElement(By.xpath("//label[text()='" + purchaserColumnName2 + "']/following-sibling::input")));
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName2 + "']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[text()='" + purchaserColumnName2 + "']/following-sibling::input"))
				.sendKeys(updatedUnitNumber);

		testStepsLog("Step " + (stepCount++), "Click on update button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.updateLineitem()']")));
	}

	public void expandContainer(String containerSerialNumber) {
		scrollToElement(driver.findElement(By.xpath(
				"//td[text()='#" + containerSerialNumber + "']/..//button[contains(@ng-click,'containerAccordion')]")));
		jsClick(driver.findElement(By.xpath(
				"//td[text()='#" + containerSerialNumber + "']/..//button[contains(@ng-click,'containerAccordion')]")));
	}

	public void delteItem(String itemName) {
		scrollToElement(driver.findElement(By.xpath(
				"//span[text()='" + itemName + "']//..//..//button[contains(@ng-click,'openDeleteItemDialog')]")));
		testStepsLog("Step " + (stepCount++), "Click on the delete icon of the item");
		jsClick(driver.findElement(By.xpath(
				"//span[text()='" + itemName + "']//..//..//button[contains(@ng-click,'openDeleteItemDialog')]")));
		testStepsLog("Step " + (stepCount++), "Click on yes");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));

	}

	public void SelectContainerCheckbox(String containerSerialNumber) {
		scrollToElement(driver.findElement(By.xpath("//td[text()='#" + containerSerialNumber
				+ "']/..//md-checkbox[@aria-invalid='false']//div[@class='md-icon']")));
		testStepsLog("Step " + (stepCount++), "Click on the container checkbox");
		jsClick(driver.findElement(By.xpath("//td[text()='#" + containerSerialNumber
				+ "']/..//md-checkbox[@aria-invalid='false']//div[@class='md-icon']")));
	}

	public void BulkMoveContainerItems(String containerName) {
		scrollToElement(driver.findElement(By.xpath("//button[@ng-click='vm.moveItemsDialog()']")));
		testStepsLog("Step " + (stepCount++), "Click on the Move button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.moveItemsDialog()']")));
		testStepsLog("Step " + (stepCount++), "Click on the container dropdown");
		jsClick(driver.findElement(By.xpath(
				"//md-dialog[@class='_md md-default-theme md-transition-in']//md-select[@ng-model='vm.container_id']")));
		testStepsLog("Step " + (stepCount++), "Select container");
		jsClick(driver.findElement(By.xpath(
				"//div[@class='md-select-menu-container md-default-theme md-active md-clickable']//div[contains(text(),'"
						+ containerName + "')]")));
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.moveItems()']")));
	}

	public void BulkDeleteContainerItems() {
		scrollToElement(driver.findElement(By.xpath("//button[@ng-click='vm.moveItemsDialog()']")));
		testStepsLog("Step " + (stepCount++), "Click on the delete button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.deleteItemsDialog()']")));
		testStepsLog("Step " + (stepCount++), "Click on yes");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));

	}

	public void clickOnAdditionalResponse(String containerName, String itemName) {

		jsClick(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//a[contains(@ng-click,'addMoreVendorResponse')]")));
	}

	public void deleteAdditionalResponse(String containerName, String itemName) {

		driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//span[contains(@ng-click,'removeAdditionalResponse')]")).click();
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));
	}

	public void addNumericVendorResponce(String containerName, String itemName) {
		int min = 1;
		int max = 100;
		Random random = new Random();
		int value = random.nextInt(max - min + 1) + min;

		scrollToElement(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')]")));
		driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')]"))
				.sendKeys(Integer.toString(value));
	}

	public void addNumericVendorResponceHigh(String containerName, String itemName) {
		int min = 100;
		int max = 1000;
		Random random = new Random();
		int value = random.nextInt(max - min + 1) + min;

		scrollToElement(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')]")));
		driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')]"))
				.sendKeys(Integer.toString(value));
	}

	public void addNumericAdditionalVendorResponce(String containerName, String itemName,
			String additionalResponceNumber) {
		int min = 1;
		int max = 100;
		Random random = new Random();
		int value = random.nextInt(max - min + 1) + min;

		scrollToElement(driver.findElement(By.xpath("(//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')])[" + additionalResponceNumber
				+ "]")));
		driver.findElement(By.xpath("(//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')])[" + additionalResponceNumber
				+ "]")).sendKeys(Integer.toString(value));
	}

	public void addDropdownVendorResponce(String containerName, String itemName, String dropdownOptionName) {
		int dropdownOptionNumber = new Random().nextBoolean() ? 1 : 2;
		testStepsLog("Step " + (stepCount++), "Scroll to the dropdown");
		scrollToElement(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//select[contains(@ng-model,'vm.items')]")));
		testStepsLog("Step " + (stepCount++), "Select dropdown value");
		Select dropdown = new Select(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//select[contains(@ng-model,'vm.items')]")));
		dropdown.selectByVisibleText(dropdownOptionName + ": " + dropdownOptionNumber);

	}

	public void addAdditionalDropdownVendorResponce(String containerName, String itemName, String dropdownOptionName,
			String additionalResponceNumber) {
		int dropdownOptionNumber = new Random().nextBoolean() ? 1 : 2;
		testStepsLog("Step " + (stepCount++), "Scroll to the dropdown");
		scrollToElement(driver.findElement(By.xpath("(//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//select[contains(@ng-model,'vm.items')])[" + additionalResponceNumber
				+ "]")));
		testStepsLog("Step " + (stepCount++), "Select dropdown value");
		Select dropdown = new Select(driver.findElement(By.xpath("(//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//select[contains(@ng-model,'vm.items')])[" + additionalResponceNumber
				+ "]")));
		dropdown.selectByVisibleText(dropdownOptionName + ": " + dropdownOptionNumber);
	}

	public void clickOnNoBid(String containerName, String itemName) {

		jsClick(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//a[contains(@ng-click,'vm.saveNoBid')]")));
		pause(4);
	}

	public void clickOnClearNoBid(String containerName, String itemName) {

		jsClick(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//a[contains(@ng-click,'vm.saveNoBid')]")));
		pause(4);
	}

	public void clickOnBulkNoBidButton() {

		scrollToElement(driver.findElement(By.xpath("//button[text()='No Bid']")));
		jsClick(driver.findElement(By.xpath("//button[text()='No Bid']")));
		pause(4);
	}

	public void clickOnBulkClearNoBidButton() {

		scrollToElement(driver.findElement(By.xpath("//button[text()='Clear No Bid']")));
		jsClick(driver.findElement(By.xpath("//button[text()='Clear No Bid']")));
		pause(4);
	}

	public void addNoteForItem(String containerName, String itemName) {
		scrollToElement(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//a[contains(@ng-click,'openAddNoteDialog')]")));
		testStepsLog("Step " + (stepCount++), "Click on the Add note");
		jsClick(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//a[contains(@ng-click,'openAddNoteDialog')]")));
		testStepsLog("Step " + (stepCount++), "Add note");
		driver.findElement(By.xpath("//input[@ng-model='dialog.result']"))
				.sendKeys("Note for " + containerName + " : " + itemName);
		testStepsLog("Step " + (stepCount++), "Click on add button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));
	}

	public void editNoteForItem(String containerName, String itemName) {
		scrollToElement(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//a[contains(@ng-click,'openAddNoteDialog')]")));
		testStepsLog("Step " + (stepCount++), "Click on the Add note");
		jsClick(driver.findElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName
				+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + itemName
				+ "']/../following-sibling::td//a[contains(@ng-click,'openAddNoteDialog')]")));
		testStepsLog("Step " + (stepCount++), "update note");
		driver.findElement(By.xpath("//input[@ng-model='dialog.result']")).sendKeys(" updated");
		testStepsLog("Step " + (stepCount++), "Click on add button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='dialog.hide()']")));
	}

	public void clickOnVendorResponceBidtableSaveButton() {

		scrollToElement(
				driver.findElement(By.xpath("//md-step-content//button[@ng-click='vm.saveLineitemVendorResponse()']")));
		jsClick(driver.findElement(By.xpath("//md-step-content//button[@ng-click='vm.saveLineitemVendorResponse()']")));
	}

	public void clickOnContinueButtonOnPricingTab() {
		scrollToElement(driver.findElement(By.xpath("//button[contains(@ng-click,'vm.validateVendorResponse(')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'vm.validateVendorResponse(')]")));
	}

	public void clickOnExpandAllIcon() {
		try {
			scrollToElement(driver.findElement(By.xpath(
					"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.expandAllContainer()']")));
			jsClick(driver.findElement(By.xpath(
					"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.expandAllContainer()']")));
		} catch (Exception e) {
			driver.navigate().refresh();
			scrollToElement(driver.findElement(By.xpath(
					"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.expandAllContainer()']")));
			jsClick(driver.findElement(By.xpath(
					"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.expandAllContainer()']")));

		}
		pause(2);
	}

	public void clickOnHeatMapIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.toggleHeatMap()']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.toggleHeatMap()']")));
		pause(2);
	}

	public void generateReport() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'downloadBidtableReport')]")));
		testStepsLog("Step " + (stepCount++), "Click on Download report icon");
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'downloadBidtableReport')]")));
		pause(2);
		testStepsLog("Step " + (stepCount++), "Click on generate report button");
		jsClick(driver.findElement(By.xpath("//button[text()='Generate Report']")));
	}

	public void clickOnCloseIconOfDowonloadReportModal() {
		testStepsLog("Step " + (stepCount++), "Click on cross icon of the report modal");
		jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//button[@ng-click='cancel()']")));
	}

	public void downloadGeneratedReport() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'downloadBidtableReport')]")));
		testStepsLog("Step " + (stepCount++), "Click on Download report icon");
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'downloadBidtableReport')]")));
		pause(2);
		testStepsLog("Step " + (stepCount++), "Click on download icon");
		jsClick(driver.findElement(By.xpath("//button[@aria-label='Download']")));
	}

	public void clickOnSelectionSummaryIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.selectionSummary($event)']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.selectionSummary($event)']")));
		pause(2);
	}

	public void clickOnHideVendorIcon(String vendorName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@ng-click,'vm.hideVendors(vendors.id)')]")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@ng-click,'vm.hideVendors(vendors.id)')]")));
		pause(3);
	}

	public void clickOnHiddenVendorListIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.hiddenVendorsList($event)']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@ng-click='vm.hiddenVendorsList($event)']")));
		pause(2);
	}

	public void unhideHiddenVendor(String vendorName) {
		testStepsLog("Step " + (stepCount++), "Click on Hidden Vendors list icon");
		clickOnHiddenVendorListIcon();
		testStepsLog("Step " + (stepCount++), "Click on the checkbox of the vendor");
		jsClick(driver.findElement(
				By.xpath("//h2[text()='Hidden Vendors']/../../following-sibling::md-dialog-content//td[text()='"
						+ vendorName + "']/..//md-checkbox")));
		testStepsLog("Step " + (stepCount++), "Click on show on report button");
		jsClick(driver.findElement(By.xpath("//button[text()='Show On Report']")));
		pause(2);
	}

	public void clickOnSelectAllResponsesVendorIcon(String vendorName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@ng-click,'vm.selectVendorResponse(vendors.id)')]")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@ng-click,'vm.selectVendorResponse(vendors.id)')]")));
		pause(3);
	}

	public void openSelectionSummaryVendorTab(String vendorName) {
		testStepsLog("Step " + (stepCount++), "Click on selection summary icon");
		clickOnSelectionSummaryIcon();
		testStepsLog("Step " + (stepCount++), "Click on the vendor tab");
		jsClick(driver.findElement(By.xpath("//md-tab-item[contains(text(),'" + vendorName + "')]")));
		pause(3);
	}

	public void clickOnRemoveAllResponsesVendorIcon(String vendorName) {
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@aria-label,'Remove All Resposes')]")));
		pause(3);
	}

	public void clickOnAddBackAllResponsesVendorIcon(String vendorName) {
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@aria-label,'Add Back All Responses')]")));
		pause(3);
	}

	public void clickOnExpandVendorDetailsIcon(String vendorName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@aria-label,'Expand Vendor Details')]")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[text()='"
						+ vendorName + "']/..//button[contains(@aria-label,'Expand Vendor Details')]")));
		pause(3);
	}

	public void clickOnPreviousVendorOnExpandVendorDetailsModal() {
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'Previous Vendor')]/..")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'Previous Vendor')]/..")));
		pause(5);
	}

	public void clickOnNextVendorOnExpandVendorDetailsModal() {
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'Next Vendor ')]/..")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'Next Vendor ')]/..")));
		pause(3);
	}

	public void clickOnRemoveAllItemOfContainer(String containerNumber) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[text()='"
						+ containerNumber + "']/..//button[@aria-label='Remove All Items']")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[text()='"
						+ containerNumber + "']/..//button[@aria-label='Remove All Items']")));
		pause(3);
	}

	public void clickOnAddBackAllItemOfContainer(String containerNumber) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[text()='"
						+ containerNumber + "']/..//button[@aria-label='Add Back Items']")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[text()='"
						+ containerNumber + "']/..//button[@aria-label='Add Back Items']")));
		pause(3);
	}

	public void ClickOnEvaluatorNoteIconForItem(String itemName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../..//button[@aria-label='Evaluator Note']")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../..//button[@aria-label='Evaluator Note']")));
		pause(3);
	}

	public void AddEvaluatorNote(String itemName) {
		testStepsLog("Step " + (stepCount++), "Click on Evaluator note icon for the item");
		ClickOnEvaluatorNoteIconForItem(itemName);
		testStepsLog("Step " + (stepCount++), "Enter note");
		driver.findElement(By.xpath("//textarea[@ng-model='vm.report_note']")).sendKeys("Note for: " + itemName);
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveReportNote()']")));
		pause(3);
	}

	public void ClickOnRemoveItemIconForItem(String itemName) {
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../..//button[@aria-label='Remove Item']")));
		pause(3);
	}

	public void ClickOnAddBackItemIconForItem(String itemName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../..//button[@aria-label='Add Back Item']")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../..//button[@aria-label='Add Back Item']")));
		pause(3);
	}

	public void ClickOnItemDetailsIconOfItem(String itemName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../..//button[@aria-label='Item Details']")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../..//button[@aria-label='Item Details']")));
		pause(3);
	}

	public void ClickOnHideButtonOfItemDetailsModal() {
		scrollToElement(
				driver.findElement(By.xpath("//md-dialog[@role='dialog']//button[@ng-click='vm.closeItemPopup();']")));
		jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//button[@ng-click='vm.closeItemPopup();']")));
		pause(3);
	}

	public void lockItem(String itemName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../../../..//button[@aria-label='Lock Item']")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../../../..//button[@aria-label='Lock Item']")));
		pause(3);
	}

	public void unlockItem(String itemName) {
		scrollToElement(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../../../..//button[@aria-label='Unlock Item']")));
		jsClick(driver
				.findElement(By.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='"
						+ itemName + "']/../../../..//button[@aria-label='Unlock Item']")));
		pause(3);
	}

	public void changePurchaserColumnFilterName(String PurchaserColumnName) {
		testStepsLog("Step " + (stepCount++), "Click on purchaser column filter");
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//md-select[@ng-model='vm.purchaser_field']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//md-select[@ng-model='vm.purchaser_field']")));
		testStepsLog("Step " + (stepCount++), "Select purchaser column name");
		jsClick(driver.findElement(By.xpath(
				"//div[@class='md-scroll-mask']/following-sibling::div//div[text()='" + PurchaserColumnName + "']")));
		pause(3);
	}

	public void clickOnBulkEliminateItemsIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Eliminate Items']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Eliminate Items']")));
		pause(3);
	}

	public void clickOnBulkUnEliminateItemsIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Uneliminate Items']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Uneliminate Items']")));
		pause(3);
	}

	public void SelectAllContainerCheckbox() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//md-checkbox[contains(@ng-model,'all_container_checked')]")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//md-checkbox[contains(@ng-model,'all_container_checked')]")));
		pause(3);
	}

	public void clickOnBulkLockItemsIcon() {
		scrollToElement(driver.findElement(By
				.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Lock']")));
		jsClick(driver.findElement(By
				.xpath("//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Lock']")));
		pause(3);
	}

	public void clickOnBulkUnLockItemsIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Unlock']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Unlock']")));
		pause(3);
	}

	public void clickOnClearSelectionIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Clear Selection']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Clear Selection']")));
		pause(3);
	}

	public void changeActiveColumnFilter(String columnName) {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//md-select[@ng-model='vm.auto_select_field']")));
		testStepsLog("Step " + (stepCount++), "Click on the active column filter");
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//md-select[@ng-model='vm.auto_select_field']")));
		testStepsLog("Step " + (stepCount++), "Select column name");
		jsClick(driver.findElement(
				By.xpath("//div[@class='md-scroll-mask']/following-sibling::div//md-option//div[contains(text(),'"
						+ columnName + "')]")));
		pause(3);
	}

	public void clickOnFilterIcon() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Filter']")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[@aria-label='Filter']")));
		pause(3);
	}

	public void enterFilterSearchValue(String value) {
		scrollToElement(driver.findElement(By.xpath("//input[contains(@ng-model,'m.filter_options')]")));
		driver.findElement(By.xpath("//input[contains(@ng-model,'m.filter_options')]")).sendKeys(value);
		pause(3);
	}

	public void clickOnFilterSearchPreviewButton() {
		scrollToElement(driver.findElement(By.xpath("//button[contains(@ng-click,'vm.filterPreview')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'vm.filterPreview')]")));
		pause(3);
	}

	public void filterSearchChangePurchaserColumnValue(String purchaserColumnName) {
		scrollToElement(driver.findElement(By.xpath("//md-select[contains(@ng-model,'vm.purchaser_filter_field')]")));
		testStepsLog("Step " + (stepCount++), "Click on the purchaser column filter");
		jsClick(driver.findElement(By.xpath("//md-select[contains(@ng-model,'vm.purchaser_filter_field')]")));
		testStepsLog("Step " + (stepCount++), "select purhaser column value");
		jsClick(driver.findElement(
				By.xpath("//h2[text()='Filter Responses']/../../../../following-sibling::div//div[contains(text(),'"
						+ purchaserColumnName + "')]")));
		pause(3);
	}

	public void clickOnFilterEliminateButton() {
		scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Eliminate')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Eliminate')]")));
		pause(3);
	}

	public void clickOnFilterUneliminateButton() {
		scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Uneliminate')]")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Uneliminate')]")));
		pause(3);
	}

	public void changeAutoSelectValueOfFilter(String value) {
		testStepsLog("Step " + (stepCount++), "Click on the value filter");
		scrollToElement(driver.findElement(By.xpath("//md-select[contains(@aria-label,'Value: Value')]")));
		jsClick(driver.findElement(By.xpath("//md-select[contains(@aria-label,'Value: Value')]")));
		testStepsLog("Step " + (stepCount++), "select value");
		jsClick(driver.findElement(By.xpath("//div[text()='" + value + "']/..")));
		testStepsLog("Step " + (stepCount++), "Click on the go button");
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'vm.filterResponseSelect')]")));
		pause(3);
	}

	public void clickOnSaveAndSubmitButton() {
		scrollToElement(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'saveAssignedTask')]")));
		jsClick(driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//button[contains(@ng-click,'saveAssignedTask')]")));
		pause(3);
	}

	public void clickOnActiveAdditionalResponseIcon(String additionalResponceNumber) {
		scrollToElement(driver
				.findElement(By.xpath("(//button[@aria-label='Make active'])[" + additionalResponceNumber + "]")));
		jsClick(driver
				.findElement(By.xpath("(//button[@aria-label='Make active'])[" + additionalResponceNumber + "]")));
		testStepsLog("Step " + (stepCount++), "Click on yes");
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'dialog.hide')]")));
		pause(3);
	}

	public void clickOnDetailsModalSelectIcon(String itemName) {
		scrollToElement(
				driver.findElement(By.xpath("//p[text()='" + itemName + "']/../../..//button[@aria-label='Select']")));
		jsClick(driver.findElement(By.xpath("//p[text()='" + itemName + "']/../../..//button[@aria-label='Select']")));
		pause(3);
	}

	public void clickOnDetailsModalLockIcon(String itemName) {
		jsClick(driver
				.findElement(By.xpath("//p[text()='" + itemName + "']/../../..//button[@aria-label='Lock Item']")));
		pause(3);
	}

	public WebElement getVendorResponseCell(String vendorName, String containerName, String itemName) {
		int venCol = 0;
		int count = 1;
		List<WebElement> vendors = driver.findElements(
				By.xpath("(//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//table)[4]//th/div"));
		for (WebElement e : vendors) {

			if (e.getText().trim().contentEquals(vendorName)) {
				venCol = count;

			}

			count++;
		}

		count = 1;
		int containerRow = 0;
		List<WebElement> containers = driver.findElements(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[contains(@class,'order-box')]//tr//a/.."));
		for (WebElement e : containers) {
			if (e.getText().contains(containerName)) {
				containerRow = count;
				break;

			}
			count++;

		}
		count = 1;
		int itemRow = 0;
		List<WebElement> items = driver.findElements(By.xpath(
				"(//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[contains(@class,'order-box')]//tr//a)["
						+ containerRow + "]/../../../../following-sibling::tr//td[4]//span"));
		for (WebElement e : items) {
			if (e.getText().contentEquals(itemName)) {
				count++;
				itemRow = count;
				break;

			}
			count++;
		}

		return driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//div[contains(@class,'vendors-box')]//table[@id='vendor_report_table']//tbody["
						+ containerRow + "]//tr[" + itemRow + "]/td[" + venCol + "]"));
	}

	public String getVendorResponse(String vendorName, String containerName, String itemName) {
		return getVendorResponseCell(vendorName, containerName, itemName).findElement(By.xpath(".//span")).getText();

	}

	public double getVendorResponseValue(String vendorName, String containerName, String itemName) {
		String value = getVendorResponseCell(vendorName, containerName, itemName).findElement(By.xpath(".//span"))
				.getText().substring(1);
		value = value.replaceAll(",", "");
		return Double.parseDouble(value);
	}

	public boolean isCellSelected(String vendorName, String containerName, String itemName) {
		pause(3);
		WebElement cell = getVendorResponseCell(vendorName, containerName, itemName);
		boolean status = false;

		if (cell.getAttribute("class").contains("selected-td")) {
			status = true;
		}
		return status;

	}

	public boolean isCellResponceRemoved(String vendorName, String containerName, String itemName) {
		WebElement cell = getVendorResponseCell(vendorName, containerName, itemName)
				.findElement(By.xpath(".//div//div"));
		boolean status = false;

		if (cell.getAttribute("class").contains("strikethrough-txt")) {
			status = true;
		}
		return status;
	}

	public boolean isItemRemoved(String itemName) {
		WebElement cell = driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//span[text()='" + itemName + "']/.."));
		boolean status = false;

		if (cell.getAttribute("class").contains("strikethrough-txt")) {
			status = true;
		}
		return status;
	}

	public String biggestOfThree(double x, double y, double z) {
		double biggestNum = z > (x > y ? x : y) ? z : ((x > y) ? x : y);
		System.out.println("all numbers are:" + x + " , " + y + " , " + z + " and biggest is :" + biggestNum);
		return "$" + df.format(biggestNum);
	}

	public String smallestOfThree(double x, double y, double z) {
		double smallestNum = (x < y) ? (x < z ? x : z) : (y < z ? y : z);
		System.out.println("small 1111 :" + smallestNum);
		return "$" + df.format(smallestNum);
	}

	public String smallestOfTwo(double x, double y) {
		double smallestNum;
		if (x > y) {
			smallestNum = y;
		} else {
			smallestNum = x;
		}
		System.out.println("smallest of two number is :" + smallestNum);
		return "$" + df.format(smallestNum);
	}

	public String middleOfThree(double x, double y, double z) {

		if ((x < y && y < z) || (z < y && y < x))
			return "$" + df.format(y);
		else if ((y < x && x < z) || (z < x && x < y))
			return "$" + df.format(x);
		else
			return "$" + df.format(z);
	}

	public void VerifyCellColors(double Vendor1Response, double Vendor2Response, double Vendor3Response) {
		String biggestNum = biggestOfThree(Vendor1Response, Vendor2Response, Vendor3Response);
		PresenceOfElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[@style='background: rgb(252, 228, 225);']//span[contains(text(),'"
						+ biggestNum + "')]"));
		testVerifyLog("Biggest number cell color is pink");
		System.out.println("Biggest number cell color is pink");
		String smallestNum = smallestOfThree(Vendor1Response, Vendor2Response, Vendor3Response);
		PresenceOfElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[@style='background: rgb(193, 250, 190);']//span[contains(text(),'"
						+ smallestNum + "')]"));
		testVerifyLog("Smallest number cell color is green");
		System.out.println("Smallest number cell color is green");
		String middleNum = middleOfThree(Vendor1Response, Vendor2Response, Vendor3Response);
		PresenceOfElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[@style='background: rgb(255, 253, 189);']//span[contains(text(),'"
						+ middleNum + "')]"));
		testVerifyLog("Middle number cell color is orange");
		System.out.println("Middle number cell color is orange");
	}

	public boolean isSmallestVendorResponseIsSelectedAmong2Responces(double Vendor1Response, double Vendor2Response) {
		String smallestNum = smallestOfTwo(Vendor1Response, Vendor2Response);
		WebElement cell = driver.findElement(By.xpath(
				"//md-tab-content[@class='_md ng-scope md-no-scroll md-active']//td[contains(@ng-if,'vm.hidden_vendors.indexOf')]//span[contains(text(),'"
						+ smallestNum + "')]/../../.."));
		boolean status = false;
		if (cell.getAttribute("class").contains("selected-td")) {
			status = true;
		}
		return status;
	}

	public void clickOnVendorResponse(String vendorName, String containerName, String itemName) {
		WebElement vRes = getVendorResponseCell(vendorName, containerName, itemName).findElement(By.xpath(".//span"));
		jsClick(vRes);
		pause(3);
	}

	public void clickOnViewAdditionalResponseButton(String vendorName, String containerName, String itemName) {
		WebElement additionalIcon = getVendorResponseCell(vendorName, containerName, itemName)
				.findElement(By.xpath(".//md-icon[contains(@ng-if,'v_all_response')]"));
		jsClick(additionalIcon);
		pause(3);
	}

	public void VerifyExpandVendorModuleAllItemsAreShowingCorrectly() {

		for (int i = 1; i < 5; i++) {
			PresenceOfElement(By.xpath("//p[text()='item " + i + "']"));
		}

	}

	public void clickOnExpandItemModalSelectResponseIcon(String vendorName) {
		jsClick(driver.findElement(
				By.xpath("//td[text()='" + vendorName + "']/..//td//button[@aria-label='Select Response']")));
		pause(3);
	}

	public void clickOnExpandItemModalRemoveResponseIcon(String vendorName) {
		jsClick(driver.findElement(
				By.xpath("//td[text()='" + vendorName + "']/..//td//button[@aria-label='Remove Response']")));
		pause(3);
	}

	public void clickOnExpandItemModalAddBackResponseIcon(String vendorName) {
		jsClick(driver.findElement(
				By.xpath("//td[text()='" + vendorName + "']/..//td//button[@aria-label='Add Back Response']")));
		pause(3);
	}

	public void clickOnExpandItemModalRemoveItemIcon() {
		jsClick(driver.findElement(By.xpath("//md-dialog//button[@aria-label='Remove Item']")));
		pause(3);
	}

	public void clickOnExpandItemModalAddBackItemIcon() {
		jsClick(driver.findElement(By.xpath("//md-dialog//button[@aria-label='Add Back Item']")));
		pause(3);
	}

	public void clickOnExpandItemModalLockItemIcon() {
		jsClick(driver.findElement(By.xpath("//md-dialog//button[@aria-label='Lock Item']")));
		pause(3);
	}


	public String getFilefromDirectory(String directory, String CsvContainsName) {
		File dir = new File(directory);
		String[] children = dir.list();
		if (children == null) {
			return "";
		} else {
			int i = 0;
			String filename = children[i];
			while (i < children.length && !filename.contains(CsvContainsName)) {
				i++;
				filename = children[i];
			}
			return filename;
		}
	}

	public void addBidtableItemByCsvUpload(String csvFilePath) {
		testStepsLog("Step " + (stepCount++), "Click on the Bulk Upload button");
		scrollToElement(driver.findElement(By.xpath("//button[@aria-label='Import Items']")));
		jsClick(driver.findElement(By.xpath("//button[@aria-label='Import Items']")));
		testStepsLog("Step " + (stepCount++), "Upload the csv");
		WebElement chooseFile = driver.findElement(By.xpath(
				"//md-dialog[@role='dialog']//h2[contains(text(),'Import Items')]/../../following-sibling::md-dialog-content//input"));
		System.out.println("full file path: " + csvFilePath);
		chooseFile.sendKeys(csvFilePath);
		testStepsLog("Step " + (stepCount++), "Click on Data has headers checkbox");
		jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-input-container//div[@class='md-icon']")));
		testStepsLog("Step " + (stepCount++), "Click on Map Column button");
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'mapItems')]")));
		waitForElement(driver
				.findElement(By.xpath("//*[@id='importItemsMapDialog']//h2[contains(text(),'Map CSV Columns')]")));
		testStepsLog("Step " + (stepCount++), "Select first dropdown value as item name");
		Select dropdown1 = new Select(driver.findElement(
				By.xpath("(//md-dialog[@role='dialog']//select[contains(@ng-model,'import_item_headers')])[1]")));
		dropdown1.selectByValue("Item name");
		testStepsLog("Step " + (stepCount++), "Select second dropdown value as unit");
		Select dropdown2 = new Select(driver.findElement(
				By.xpath("(//md-dialog[@role='dialog']//select[contains(@ng-model,'import_item_headers')])[2]")));
		dropdown2.selectByValue("unit");
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'vm.importItems()')]")));

	}

	public void clickOnCancelButtonOfItemImport() {
		PresenceOfElement(driver.findElement(
				By.xpath("//button[contains(@ng-click,'mapItems')]/..//button[contains(@ng-click,'cancel()')]")));
		jsClick(driver.findElement(
				By.xpath("//button[contains(@ng-click,'mapItems')]/..//button[contains(@ng-click,'cancel()')]")));
	}

}
