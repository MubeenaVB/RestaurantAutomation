package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyAddExpenceTest extends Baseclass {

	@Test(priority = 1)
	public void AddExpence() throws Exception {
		Log.startTestCase("AddExpence");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login page is not loaded");
		Ae.AddingExpence();
		Assert.assertTrue(Ae.IsSearchExpence(), "Expence not added");
		Log.endTestCase("AddExpence");
	}

	@Test(priority = 2)
	public void DeleteExpence() throws InterruptedException {
		Log.startTestCase("DeleteExpence");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login page is not loaded");
		Assert.assertTrue(Ae.IsDeleteExpence(), "Expence not deleted");
		Log.endTestCase("DeleteExpence");
	}
}
