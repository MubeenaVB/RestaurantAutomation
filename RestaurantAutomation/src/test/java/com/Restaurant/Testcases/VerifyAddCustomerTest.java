package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.BaseClass.Baseclass;
import com.Restaurant.Utilities.Log;

public class VerifyAddCustomerTest extends Baseclass {

	@Parameters({"Name","Phone","Email","Discount"})
	@Test(priority = 1)
	public void AddCustomer(String Name,String Phone,String Email,String Discount) throws Exception {
		Log.startTestCase("AddCustomer");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ac.AddCutomer(Name, Phone, Email, Discount);
		Assert.assertTrue(Ac.IsSearchCustomer(), "Customer Not Added");
		Log.endTestCase("AddCustomer");
	}

	@Parameters({ "EditPhone", "EditEmail" })
	@Test(priority = 2)
	public void EditCustomer(String EditPhone, String EditEmail) {
		Log.startTestCase("EditCustomer");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Ac.EditCustomerDetails(EditPhone, EditEmail);
		Assert.assertTrue(Ac.IsConfirmEdit(), "Edit is not successfull");
		Log.endTestCase("EditCustomer");
	}

	@Test(priority = 3)
	public void DeleteCustomer() {
		Log.startTestCase("DeleteCustomer");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Login not successfull");
		Assert.assertTrue(Ac.IsDeleteCustomer(), "Delete Customer failed");
		Log.endTestCase("DeleteCustomer");
	}
}
