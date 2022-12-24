package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class ProductStatsGetReport extends Baseclass {

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[2]")
	WebElement ProductStatsTitle;

	@FindBy(xpath = "//span[@id='select2-productSelect-container']")
	WebElement ProductList;

	@FindBy(xpath = "//input[@id='ProductRange']")
	WebElement ProductRange;

	@FindBy(xpath = "(//button[@class='applyBtn btn btn-sm btn-success'])[1]")
	WebElement ApplyButtonForProductStats;

	@FindBy(xpath = "//button[@class='btn btn-default hiddenpr']")
	WebElement GetReportCloseButton;

	@FindBy(xpath = "//button[@onclick='getProductReport()']")
	WebElement ProductStatsReport;

	public ProductStatsGetReport() {
		PageFactory.initElements(getDriver(), this);
	}

	public void ReportForProductStats() throws InterruptedException {
		action.click1(ProductList, "Product List");
		List<WebElement> list = getDriver().findElements(By.xpath("//li[@class='select2-results__option']"));
		action.selectByIndex(ProductList, 0);
		action.click1(ProductRange, "Product Range");
		action.explicitWait(getDriver(), ProductRange, Duration.ofSeconds(20));
		action.type(ProductRange, "12/11/2021 - 12/11/2022");
		action.click1(ProductStatsReport, "Get Report");
		action.click1(GetReportCloseButton, "Close");
	}

	public boolean IsProductStatsDisplayed() {
		return action.isDisplayed(getDriver(), ProductStatsTitle);
	}
}
