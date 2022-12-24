package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class StockStatsGetReport extends Baseclass {

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[4]")
	WebElement StockStatsTitle;

	@FindBy(xpath = "//span[@id='select2-StockSelect-container']")
	WebElement StockList;

	@FindBy(xpath = "//button[@class='btn btn-default hiddenpr']")
	WebElement GetReportCloseButton;

	@FindBy(xpath = "//button[@onclick='getStockReport()']")
	WebElement StockStatsReport;

	@FindBy(xpath = "(//input[@class='form-control'])[4]")
	WebElement DaterRange;

	public StockStatsGetReport() {
		PageFactory.initElements(getDriver(), this);
	}

	public void ReportForStockStats() throws InterruptedException {
		action.explicitWait(getDriver(), StockList, Duration.ofSeconds(20));
		action.click1(StockList, "Stock List");
		action.selectByIndex(StockList, 0);
		action.isEnabled(getDriver(), DaterRange);// should be disables
		action.click1(StockStatsReport, "Get Report");
		action.click1(GetReportCloseButton, "Close");
	}

	public boolean IsStockStatsDisplayed() {
		return action.isDisplayed(getDriver(), StockStatsTitle);
	}
}
