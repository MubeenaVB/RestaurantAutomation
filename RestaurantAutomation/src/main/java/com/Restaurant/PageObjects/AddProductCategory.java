package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class AddProductCategory extends Baseclass {

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	@FindBy(xpath = "(//span[@class='menu-text'])[10]")
	WebElement Categories;

	@FindBy(xpath = "(//span[@class='menu-text'])[11]")
	WebElement Product;

	@FindBy(xpath = "//button[@data-target='#Addcategory']")
	WebElement AddCategory;

	@FindBy(id = "CategoryName")
	WebElement CategoryName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;

	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;

	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement SearchResult1;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement EditButton;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement DeleteKey;

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement DeleteConfirm;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement SearchResult2;

	public AddProductCategory() {
		PageFactory.initElements(getDriver(), this);
	}

	public void AddNewProductCategory() {
		action.click1(menu, "Menu");
		action.click1(Categories, "Categories");
		action.click1(Product, "Product");
		action.click1(AddCategory, "AddCategory");
		action.explicitWait(getDriver(), CategoryName, Duration.ofSeconds(20));
		action.type(CategoryName, "Chocolate");
		action.click1(Submit, "Submit");
	}

	public boolean IsSearchProduct(String value) {
		action.click1(menu, "Menu button");
		action.click1(Categories, "Categories");
		action.click1(Product, "Product");
		action.type(Search, value);
		String Result = SearchResult1.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase(value)) {
			status = true;
		}
		return status;
	}

	public void EditProductDetails() {
		IsSearchProduct("Chocolate");
		action.click1(EditButton, "Edit");
		action.type(CategoryName, "Chocolates");
		action.click1(Submit, "Submit");
	}

	public boolean IsConfirmEdit() {
		boolean status = false;
		IsSearchProduct("Chocolates");
		if ((SearchResult1.getText().equalsIgnoreCase("Chocolates"))) {
			status = true;
		}
		return status;
	}

	public boolean IsDeleteProduct() {
		IsSearchProduct("Chocolates");
		action.click1(DeleteKey, "Delete Key");
		action.click1(DeleteConfirm, "Yes,Delete it");
		action.type(Search, "Chocolates");
		String Result = SearchResult2.getText();
		boolean status = false;
		if (Result.equalsIgnoreCase("No matching records found")) {
			status = true;
		}
		return status;
	}
}
