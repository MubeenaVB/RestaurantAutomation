package com.Restaurant.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class AddExpence extends Baseclass {

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	@FindBy(xpath = "(//span[@class='menu-text'])[9]")
	WebElement Expence;

	@FindBy(xpath = "//button[@data-target='#AddExpence']")
	WebElement AddExpence;

	@FindBy(id = "Date")
	WebElement Date;

	@FindBy(id = "Reference")
	WebElement Reference;

	@FindBy(id = "Category")
	WebElement Category;

	@FindBy(id = "store_id")
	WebElement store_id;

	@FindBy(id = "Amount")
	WebElement amount;

	@FindBy(xpath = "//input[@name='userfile']")
	WebElement attachment;

	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	WebElement Note;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;

	@FindBy(xpath = "(//tr[@role='row'])[2]")
	WebElement SearchResult1;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement DeleteKey;

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']")
	WebElement DeleteConfirm;

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']")
	WebElement Ok;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement SearchResult2;

	public AddExpence() {
		PageFactory.initElements(getDriver(), this);
	}

	public void AddingExpence() throws Exception {
		ArrayList list = Ex.getData("ExpenceData");
		action.click1(menu, "Menu button");
		action.click1(Expence, "Expence");
		action.click1(AddExpence, "AddExpence");
		action.explicitWait(getDriver(), Date, Duration.ofSeconds(20));
		action.type(Date, list.get(0).toString());
		action.click1(Reference, null);
		action.type(Reference, list.get(1).toString());
		action.explicitWait(getDriver(), Category, Duration.ofSeconds(20));
		action.selectByIndex(Category, 2);
		action.selectByIndex(store_id, 2);
		action.explicitWait(getDriver(), amount, Duration.ofSeconds(20));
		action.type(amount, list.get(2).toString());
		FileUpload();
		action.type(Note, list.get(3).toString());
		action.click1(SubmitButton, "Submit Button");
	}

	public void FileUpload() throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", attachment);
		Robot rb = new Robot();
		rb.delay(2000);
		// copy the path of file in clipboard.same as Ctrl+c
		StringSelection ss = new StringSelection("D:\\New folder\\doc.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public boolean IsSearchExpence() {
		action.explicitWait(getDriver(), menu, Duration.ofSeconds(20));
		action.click1(menu, "Menu button");
		action.click1(Expence, "Expence");
		action.explicitWait(getDriver(), Search, Duration.ofSeconds(20));
		action.type(Search, "Magic");
		String Result = SearchResult1.getText();
		boolean status = false;
		if (Result.contains("Magic")) {
			status = true;
		}
		return status;
	}

	public boolean IsDeleteExpence() throws InterruptedException {
		IsSearchExpence();
		// action.explicitWait(getDriver(), DeleteKey, Duration.ofSeconds(30));
		Thread.sleep(3000);
		action.click1(DeleteKey, "Delete Key");
		// action.explicitWait(getDriver(), DeleteConfirm, Duration.ofSeconds(30));
		Thread.sleep(3000);
		action.click1(DeleteConfirm, "Yes,Delete it");
		action.click1(Ok, "OK");
		action.explicitWait(getDriver(), Search, Duration.ofSeconds(20));
		action.type(Search, "Magic");
		String Result = SearchResult2.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;
	}
}
