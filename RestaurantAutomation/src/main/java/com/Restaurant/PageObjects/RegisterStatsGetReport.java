package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class RegisterStatsGetReport extends Baseclass {

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[3]")
	WebElement RegisterStatsTitle;

	@FindBy(xpath = "//span[@id='select2-StoresSelect-container']")
	WebElement RegisterList;

	@FindBy(xpath = "//input[@id='RegisterRange']")
	WebElement RegisterRange;

	@FindBy(xpath = "(//button[@class='applyBtn btn btn-sm btn-success'])[1]")
	WebElement ApplyButtonForRegisterStats;

	@FindBy(xpath = "//button[@class='btn btn-default hiddenpr']")
	WebElement GetReportCloseButton;

	@FindBy(xpath = "//button[@onclick='getRegisterReport()']")
	WebElement RegisterStatsReport;

	public RegisterStatsGetReport() {
		PageFactory.initElements(getDriver(), this);
	}

	public void ReportForRegisterStats() throws InterruptedException {
		action.click1(RegisterList, "Register List");
		action.selectByIndex(RegisterList, 0);
		action.click1(RegisterRange, "Register Range");
		action.explicitWait(getDriver(), RegisterRange, Duration.ofSeconds(20));
		action.type(RegisterRange, "12/11/2021 - 12/11/2022");
		action.click1(RegisterStatsReport, "Get Report");
		action.click1(GetReportCloseButton, "Close");
	}

	public boolean IsRegisterStatsDisplayed() {
		return action.isDisplayed(getDriver(), RegisterStatsTitle);
	}
}
