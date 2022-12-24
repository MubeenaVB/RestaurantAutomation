package com.Restaurant.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class LoginPage extends Baseclass {

	@FindBy(xpath = "//input[@type='text']")
	WebElement UserName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Submit;

	@FindBy(css = "img[alt='logo']")
	WebElement Logo;

	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	WebElement logout;

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	public WebElement DispLogo() {
		return Logo;
	}

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement Uname() {
		return UserName;
	}

	public WebElement Password() {
		return Password;
	}

	public WebElement SubmitButton() {
		return Submit;
	}

	public WebElement MenuButton() {
		return menu;
	}

	public WebElement LogoutButton() {
		return logout;
	}

	// Method to check whether the Login page is loaded properly
	// If present will get True else will get false
	public Boolean IsLogoPresent() {
		return action.isDisplayed(getDriver(), Logo);
	}

	// Created for login.This method will call at test case
	public void ValidLogin() {
		action.type(UserName, prop.getProperty("Username"));
		action.type(Password, prop.getProperty("Password"));
		action.click1(Submit, "Login button");
	}

	public void InvalidLogin(String Username, String password) {
		action.type(UserName, Username);
		action.type(Password, password);
		action.click1(Submit, "Login button");
	}

	public void logout() {
		action.click1(menu, "Menu button");
		action.click1(logout, "Logout button");
	}
}
