package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyRegisterStatsGetReportTest extends Baseclass {

	@Test
	public void GetReportForRegisterStats() throws InterruptedException {
		Log.startTestCase("GetReportForRegisterStats");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Rp.Reports();
		Assert.assertTrue(Rs.IsRegisterStatsDisplayed(), "Register Stats not displayed");
		Rs.ReportForRegisterStats();
		Log.endTestCase("GetReportForRegisterStats");
	}
}
