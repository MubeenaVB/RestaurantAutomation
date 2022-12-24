package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class HomePage extends Baseclass {

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	@FindBy(xpath = "//div/span[contains(@class,'store_title')]")
	WebElement StoreTitle;

	@FindBy(xpath = "//input[@id='CashinHando']")
	WebElement CashInHand;

	@FindBy(xpath = "//input[@id='waiterid']")
	WebElement WaiterCashInHand;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement CloseButton;

	@FindBy(css = "img[alt='logo']")
	WebElement Logo;

	@FindBy(xpath = "(//li[@class='flat-box waves-effect waves-block'])[1]")
	WebElement POS;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean IsLogoPresent() throws InterruptedException {
		action.explicitWait(getDriver(), Logo, Duration.ofSeconds(20));
		return action.isDisplayed(getDriver(), Logo);
	}

	public void StoresPresesnt(String name) {
		action.click1(menu, "Menu");
		action.click1(POS, "POS");
		List<WebElement> Stores = getDriver().findElements(By.xpath("//div/span[contains(@class,'store_title')]"));
		for (WebElement store : Stores) {
			String storeName = store.getText();
			if (storeName.contains(name)) {
				action.click1(store, storeName);
				break;
			}
		}
	}

	public void StoreWithWaiter() throws InterruptedException {
		StoresPresesnt("Magic Shop");
		action.explicitWait(getDriver(), CashInHand, Duration.ofSeconds(20));
		action.type(CashInHand, "200");
		action.type(WaiterCashInHand, "200");
		action.click1(SubmitButton, "Submit");
		Thread.sleep(3000);
		getDriver().switchTo().alert().accept();// accept or click ok on alert
		action.explicitWait(getDriver(), CloseButton, Duration.ofSeconds(20));
		action.click1(CloseButton, "Close button");
	}

	public void StoreWithoutWaiter() throws InterruptedException {
		StoresPresesnt("Magic Shop");
		action.explicitWait(getDriver(), CashInHand, Duration.ofSeconds(20));
		action.type(CashInHand, "200");
		action.click1(SubmitButton, "Submit");
		Thread.sleep(3000);
		getDriver().switchTo().alert().accept();// accept or click ok on alert
		action.explicitWait(getDriver(), CloseButton, Duration.ofSeconds(20));
		action.click1(CloseButton, "Close button");
	}
}
