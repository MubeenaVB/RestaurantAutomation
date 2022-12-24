package com.Restaurant.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class ChangeLanguage extends Baseclass {

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	@FindBy(xpath = "//li[@class='dropdown language']")
	WebElement Language;

	@FindBy(xpath = "(//li/ul[@class='dropdown-menu'])[3]/li[2]")
	WebElement France;

	@FindBy(xpath = "(//li/ul[@class='dropdown-menu'])[3]/li[1]")
	WebElement English;

	@FindBy(xpath = "//h1[@class='text-center choose_store']")
	WebElement ChoseStore;

	public ChangeLanguage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void SelectFrance() {
		action.click1(menu, "Menu");
		action.click1(Language, "Language");
		action.click1(France, "Francais");
	}

	public boolean IsCheck(String value) throws InterruptedException {
		action.explicitWait(getDriver(), ChoseStore, Duration.ofSeconds(20));
		boolean status = false;
		String s = ChoseStore.getText();
		if (s.equalsIgnoreCase(value)) {
			status = true;
		}
		return status;
	}

	public void SelectEnglish() throws InterruptedException {
		action.explicitWait(getDriver(), menu, Duration.ofSeconds(20));
		action.click1(menu, "Menu");
		action.click1(Language, "Language");
		action.click1(English, "English");
	}
}
