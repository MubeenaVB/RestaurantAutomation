package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyChangeLanguageTest extends Baseclass {

	@Test
	public void ChangeToFrance() throws InterruptedException {
		Log.startTestCase("ChangeToFrance");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Cl.SelectFrance();
		Assert.assertTrue(Cl.IsCheck("Choisissez un boutique"), "language not changed");
		Cl.SelectEnglish();
		Assert.assertTrue(Cl.IsCheck("Choose a store"));
		Log.endTestCase("ChangeToFrance");
	}
}
