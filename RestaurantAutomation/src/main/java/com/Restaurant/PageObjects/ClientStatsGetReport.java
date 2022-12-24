package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class ClientStatsGetReport extends Baseclass {

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[1]")
	WebElement ClientStatsTitle;

	@FindBy(xpath = "//span[@id='select2-customerSelect-container']")
	WebElement clientList;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[2]")
	WebElement productList;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[3]")
	WebElement storeListForRegisterStats;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[4]")
	WebElement storeListForStockStats;

	@FindBy(xpath = "//input[@id='CustomerRange']")
	WebElement CustomerRange;

	@FindBy(xpath = "(//button[@class='applyBtn btn btn-sm btn-success'])[1]")
	WebElement ApplyButtonForClientStats;

	@FindBy(xpath = "//button[@onclick='getCustomerReport()']")
	WebElement ClientStatsReport;

	@FindBy(xpath = "//button[@class='btn btn-default hiddenpr']")
	WebElement GetReportCloseButton;

	public ClientStatsGetReport() {
		PageFactory.initElements(getDriver(), this);
	}

	public void ReportForClientStats() throws InterruptedException {
		action.click1(clientList, "Client List");
		action.selectByIndex(clientList, 0);
		action.click1(CustomerRange, "Customer Range");
		action.explicitWait(getDriver(), CustomerRange, Duration.ofSeconds(20));
		action.type(CustomerRange, "12/11/2021 - 12/11/2022");
		action.click1(ClientStatsReport, "Get Report");
		action.click1(GetReportCloseButton, "Close");
	}

	public boolean IsClientStatsDisplayed() {
		return action.isDisplayed(getDriver(), ClientStatsTitle);
	}
}
