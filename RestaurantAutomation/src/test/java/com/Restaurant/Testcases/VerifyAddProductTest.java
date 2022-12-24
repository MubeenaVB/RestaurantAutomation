package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyAddProductTest extends Baseclass {

	@Test(priority = 1)
	public void AddingProduct() {
		Log.startTestCase("AddingProduct");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ap.AddNewProductCategory();
		Assert.assertTrue(Ap.IsSearchProduct("Chocolate"), "Add new product failed");
		Log.endTestCase("AddingProduct");
	}

	@Test(priority = 2)
	public void EditProduct() {
		Log.startTestCase("EditProduct");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ap.EditProductDetails();
		Assert.assertTrue(Ap.IsConfirmEdit(), "Edit is not successfull");
		Log.endTestCase("EditProduct");
	}

	@Test(priority = 3)
	public void DeleteProduct() {
		Log.startTestCase("DeleteProduct");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Assert.assertTrue(Ap.IsDeleteProduct(), "Delete Product failed");
		Log.endTestCase("DeleteProduct");
	}
}
