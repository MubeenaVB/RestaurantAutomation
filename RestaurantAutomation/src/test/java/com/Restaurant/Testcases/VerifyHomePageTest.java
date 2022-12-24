package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyHomePageTest extends Baseclass {

	@Test(priority = 1)
	public void ShopWithWaiter() throws Exception {
		Log.startTestCase("ShopWithWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		As.AddingNewStore();
		Assert.assertTrue(As.IsSearchStore(), "Add new store failed");
		Log.endTestCase("ShopWithWaiter");
	}

	@Test(priority = 2)
	public void AddingWaiter() throws Exception {
		Log.startTestCase("AddingWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Aw.AddingNewWaiter(2);
		Assert.assertTrue(Aw.IsSearchWaiter(), "Add new waiter failed");
		Hp.StoreWithWaiter();
		Log.endTestCase("AddingWaiter");
	}

	@Test(priority = 3)
	public void DeleteWaiter() {
		Log.startTestCase("DeleteWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Assert.assertTrue(Aw.IsDeleteWaiter(), "Delete waiter failed");
		Log.endTestCase("DeleteWaiter");
	}

	@Test(priority = 4)
	public void ShopWithoutWaiter() throws InterruptedException {
		Log.startTestCase("ShopWithoutWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Hp.IsLogoPresent(), "Home page is not loaded");
		Hp.StoreWithoutWaiter();
		Log.endTestCase("ShopWithoutWaiter");
	}

	@Test(priority = 5)
	public void DeleteStore() {
		Log.startTestCase("DeleteStore");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Assert.assertTrue(As.IsDeleteStore(), "Delete Store failed");
		Log.endTestCase("DeleteStore");
	}

}
