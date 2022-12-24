package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyUserLoginTest extends Baseclass {

	@Test(retryAnalyzer = com.Restaurant.Utilities.RerunAutomationScripts.class, groups = "smoke")
	public void VerifyValidUserLogin() throws InterruptedException {
		Log.startTestCase("VerifyValidUserLogin");
		Assert.assertTrue(Lp.IsLogoPresent(), "Login page is not loaded");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Home page is not loaded");
		Lp.logout();
		Log.endTestCase("VerifyValidUserLogin");
	}

	@Test(dataProvider = "getInvalidLoginDetails")
	public void VerifyInvalidUserLogin(String Username, String password) throws Exception {
		Log.startTestCase("VerifyInvalidUserLogin");
		Assert.assertTrue(Lp.SubmitButton().isDisplayed(), "Logout is not successful");
		Lp.InvalidLogin(Username, password);
		Log.startTestCase("VerifyInvalidUserLogin");
	}

	@DataProvider
	public Object[][] getInvalidLoginDetails() {
		Object[][] data = new Object[3][2];
		data[0][0] = "adm";
		data[0][1] = "password";
		data[1][0] = "admin";
		data[1][1] = "pass";
		data[2][0] = "adm";
		data[2][1] = "pass";
		return data;
	}
}
