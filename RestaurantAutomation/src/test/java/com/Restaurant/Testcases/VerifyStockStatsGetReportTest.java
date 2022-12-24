package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyStockStatsGetReportTest extends Baseclass {

	@Test(groups = { "smoke" })
	public void GetReportForStockStats() throws InterruptedException {
		Log.startTestCase("GetReportForStockStats");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Rp.Reports();
		Assert.assertTrue(St.IsStockStatsDisplayed(), "Stock Stats not displayed");
		St.ReportForStockStats();
		Log.endTestCase("GetReportForStockStats");
	}
}
