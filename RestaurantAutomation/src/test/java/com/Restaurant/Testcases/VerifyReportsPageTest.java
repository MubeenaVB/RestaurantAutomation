package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyReportsPageTest extends Baseclass {

	@Test
	public void SelectReportsOption() throws InterruptedException {
		Log.startTestCase("SelectReportsOption");
		Lp.ValidLogin();
		Assert.assertTrue(Rp.IsLogoPresent(), "Home page not loaded");
		Rp.Reports();
		Log.endTestCase("SelectReportsOption");
	}

	@Test
	public void ReveExpnOnPreviousYear() throws InterruptedException {
		Log.startTestCase("ReveExpnOnPreviousYear");
		Lp.ValidLogin();
		Rp.Reports();
		Assert.assertTrue(Rp.IsPreviosYear(), "Previous year data is not displayed correctly");
		Log.endTestCase("ReveExpnOnPreviousYear");
	}

	@Test
	public void ReveExpnOnNextYear() throws InterruptedException {
		Log.startTestCase("ReveExpnOnNextYear");
		Lp.ValidLogin();
		Rp.Reports();
		Assert.assertTrue(Rp.IsNextYear(), "Next year data is not displayed correctly");
		Log.endTestCase("ReveExpnOnNextYear");
	}
}
