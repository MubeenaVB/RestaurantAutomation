package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyEditStoreTest extends Baseclass {

	@Test(priority = 1)
	public void AddingStore() throws Exception {
		Log.startTestCase("AddingStore");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		As.AddingNewStore();
		Assert.assertTrue(As.IsSearchStore(), "Add new store failed");
		As.EditStoreDetails();
		Assert.assertTrue(As.IsConfirmEdit(), "Edit is not successfull");
		Log.endTestCase("AddingStore");
	}

	@Test(priority = 2, dependsOnMethods = { "AddingStore" })
	public void AddTableInStore() throws InterruptedException {
		Log.startTestCase("AddTableInStore");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		As.AddZone();
		As.AddTable();
		Assert.assertTrue(As.IsTableValidation(), "Table Not created");
		Log.endTestCase("AddTableInStore");

	}

	@Test(priority = 3)
	public void DeleteStore() {
		Log.startTestCase("DeleteStore");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Assert.assertTrue(As.IsDeleteStore(), "Delete Store failed");
		Log.endTestCase("DeleteStore");
	}
}
