package com.Restaurant.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunAutomationScripts implements IRetryAnalyzer {

	private int retrycount = 0;
	private static final int maxcount = 3;

	public boolean retry(ITestResult result) {
		if (retrycount < maxcount) {
			retrycount++;
			return true;
		}
		return false;
	}
}
