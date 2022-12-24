package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class AddSupplier extends Baseclass {

	public static String Phone1 = "";
	public static String Email1 = "";

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	@FindBy(xpath = "(//a[@data-toggle='dropdown'])[1]")
	WebElement PeopleDropDown;

	@FindBy(xpath = "(//span[@class='menu-text'])[7]")
	WebElement Supplier;

	@FindBy(xpath = "//button[@data-target='#AddSupplier']")
	WebElement AddSupplier;

	@FindBy(id = "SupplierName")
	WebElement SupplierName;

	@FindBy(id = "SupplierPhone")
	WebElement SupplierPhone;

	@FindBy(id = "SupplierEmail")
	WebElement SupplierEmail;

	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	WebElement Note;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;

	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement SearchResult1;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement EditButton;

	@FindBy(xpath = "(//tbody/tr/td)[2]")
	WebElement EditPhone;

	@FindBy(xpath = "(//tbody/tr/td)[3]")
	WebElement EditEmail;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement DeleteKey;

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement DeleteConfirm;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement SearchResult2;

	public AddSupplier() {
		PageFactory.initElements(getDriver(), this);
	}

	public void AddingSupplier(String Name, String Phone, String Email, String Notes) throws InterruptedException {
		action.click1(menu, "Menu button");
		action.click1(PeopleDropDown, "People drop down");
		action.click1(Supplier, "Supplier");
		action.click1(AddSupplier, "Add Supplier");
		action.explicitWait(getDriver(), SupplierName, Duration.ofSeconds(20));
		action.type(SupplierName, Name);
		action.type(SupplierPhone, Phone);
		action.type(SupplierEmail, Email);
		action.type(Note, Notes);
		action.click1(SubmitButton, "Submit");
	}

	public boolean IsSearchSupplier() {
		action.click1(menu, "Menu button");
		action.click1(PeopleDropDown, "People drop down");
		action.click1(Supplier, "Supplier");
		action.type(Search, "Kannan");
		String Result = SearchResult1.getText();
		boolean status = false;
		if (Result.contains("Kannan")) {
			status = true;
		}
		return status;
	}

	public void EditSupplierDetails(String EditPhone, String EditEmail) {
		Phone1 = EditPhone;
		Email1 = EditEmail;
		IsSearchSupplier();
		action.click1(EditButton, "Edit");
		action.type(SupplierPhone, EditPhone);
		action.type(SupplierEmail, EditEmail);
		action.click1(SubmitButton, "Submit");
	}

	public boolean IsConfirmEdit() {
		boolean status = false;
		IsSearchSupplier();
		if ((EditPhone.getText().equalsIgnoreCase(Phone1)) && (EditEmail.getText().equalsIgnoreCase(Email1))) {
			status = true;
		}
		return status;
	}

	public boolean IsDeleteSupplier() {
		IsSearchSupplier();
		action.click1(DeleteKey, "Delete Key");
		action.click1(DeleteConfirm, "Yes,Delete it");
		action.type(Search, "Kannan");
		String Result = SearchResult2.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;
	}
}
