package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyProductStatsGetReportTest extends Baseclass {

	@Test
	public void GetReportForProductStats() throws InterruptedException {
		Log.startTestCase("GetReportForProductStats");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Rp.Reports();
		Assert.assertTrue(Ps.IsProductStatsDisplayed(), "Product Stats not displayed");
		Ps.ReportForProductStats();
		Log.endTestCase("GetReportForProductStats");
	}
}
