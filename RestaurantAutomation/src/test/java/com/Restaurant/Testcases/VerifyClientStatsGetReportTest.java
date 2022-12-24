package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyClientStatsGetReportTest extends Baseclass {

	@Test
	public void GetReportForClientStats() throws InterruptedException {
		Log.startTestCase("GetReportForClientStats");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Rp.Reports();
		Gp.ReportForClientStats();
		Assert.assertTrue(Gp.IsClientStatsDisplayed(), "Client Stats not displayed");
		Log.endTestCase("GetReportForClientStats");
	}

}
