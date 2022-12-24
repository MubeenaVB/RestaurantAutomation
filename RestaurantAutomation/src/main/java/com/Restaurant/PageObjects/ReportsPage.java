package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class ReportsPage extends Baseclass {

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	@FindBy(xpath = "//i[@class='fa fa-line-chart']")
	WebElement Reports;

	@FindBy(xpath = "//h1[@class='statYear']")
	WebElement CurrentYear;

	@FindBy(xpath = "(//button[@class='btn btn-Year'])[1]")
	WebElement PrevYearArrow;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement NextYearArrow;

	@FindBy(css = "img[alt='logo']")
	WebElement Logo;

	@FindBy(xpath = "//div[@class='statCart Statcolor01']")
	WebElement TotalCustomers;

	@FindBy(xpath = "//div[@class='statCart Statcolor02']")
	WebElement TotalProducts;

	@FindBy(xpath = "//div[@class='statCart Statcolor03']")
	WebElement TotalRupees;

	@FindBy(xpath = "(//div[@class='statCart'])[1]")
	WebElement MonthlyStats;

	@FindBy(xpath = "(//div[@class='statCart'])[2]")
	WebElement Top5Products;

	@FindBy(xpath = "(//div[@class='statCart'])[3]")
	WebElement StatCart;

	public ReportsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void Reports() throws InterruptedException {
		action.explicitWait(getDriver(), menu, Duration.ofSeconds(20));
		action.click1(menu, "Menu option");
		action.click1(Reports, "REports option");
	}

	public int Currentyear() throws InterruptedException {
		action.explicitWait(getDriver(), CurrentYear, Duration.ofSeconds(20));
		String CY = CurrentYear.getText();
		int cy = Integer.parseInt(CY);
		return cy;
	}

	public boolean IsPreviosYear() throws InterruptedException {
		boolean status = false;
		int currentYear = Currentyear();

		action.click1(PrevYearArrow, "Previous Year");
		Thread.sleep(3000);
		String PY = CurrentYear.getText();
		int py = Integer.parseInt(PY);
		if (py == (currentYear - 1)) {
			status = true;
		}
		return status;
	}

	public boolean IsNextYear() throws InterruptedException {
		boolean status = false;
		int currentYear = Currentyear();

		action.click1(NextYearArrow, "Next Year");
		Thread.sleep(3000);
		String NY = CurrentYear.getText();
		int ny = Integer.parseInt(NY);
		if (ny == (currentYear + 1)) {
			status = true;
		}
		return status;
	}

	public boolean IsLogoPresent() throws InterruptedException {
		action.explicitWait(getDriver(), Logo, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), Logo);
	}
}
