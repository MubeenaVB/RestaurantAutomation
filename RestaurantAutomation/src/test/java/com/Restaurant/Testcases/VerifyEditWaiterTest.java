package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyEditWaiterTest extends Baseclass {

	@Parameters({ "EditPhone", "EditEmail" })
	@Test
	public void AddingWaiter(String EditPhone, String EditEmail) throws Exception {
		Log.startTestCase("AddingWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Aw.AddingNewWaiter(1);
		Assert.assertTrue(Aw.IsSearchWaiter(), "Add new waiter failed");
		Aw.EditWaiterDetails(EditPhone, EditEmail);
		Assert.assertTrue(Aw.IsConfirmEdit(), "Edit is not successfull");
		Log.endTestCase("AddingWaiter");
	}

	@Test
	public void DeleteWaiter() {
		Log.startTestCase("DeleteWaiter");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Assert.assertTrue(Aw.IsDeleteWaiter(), "Delete waiter failed");
		Log.endTestCase("DeleteWaiter");
	}
}
