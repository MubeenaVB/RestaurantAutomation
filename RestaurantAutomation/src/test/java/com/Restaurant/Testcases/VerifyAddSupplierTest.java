package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyAddSupplierTest extends Baseclass {

	@Parameters({ "Name", "Phone", "Email", "Notes" })
	@Test(priority = 1)
	public void AddSupplier(String Name, String Phone, String Email, String Notes) throws InterruptedException {
		Log.startTestCase("AddSupplier");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Asp.AddingSupplier(Name, Phone, Email, Notes);
		Assert.assertTrue(Asp.IsSearchSupplier(), "Customer Not Added");
		Log.endTestCase("AddSupplier");
	}

	@Parameters({ "EditPhone", "EditEmail" })
	@Test(priority = 2)
	public void EditSupplier(String EditPhone, String EditEmail) {
		Log.startTestCase("EditSupplier");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Asp.EditSupplierDetails(EditPhone, EditEmail);
		Assert.assertTrue(Asp.IsConfirmEdit(), "Edit is not successfull");
		Log.endTestCase("EditSupplier");
	}

	@Test(priority = 3)
	public void DeleteSupplier() {
		Log.startTestCase("DeleteSupplier");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Assert.assertTrue(Asp.IsDeleteSupplier(), "Delete Customer failed");
		Log.endTestCase("DeleteSupplier");
	}

}
