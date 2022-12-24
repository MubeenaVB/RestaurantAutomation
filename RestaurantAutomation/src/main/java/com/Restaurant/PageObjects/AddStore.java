package com.Restaurant.PageObjects;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.BaseClass.Baseclass;

public class AddStore extends Baseclass{

	public static String Phone1="7560989903";
	public static String Email1="mubeenavb001@gmail.com";
	
	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;
	
	@FindBy(xpath="(//span[@class='menu-text'])[3]")
	WebElement Stores;
	
	@FindBy(xpath="//button[@data-target='#AddStore']")
	WebElement AddStores;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement StoreNameField;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement EmailIdField;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement PhoneField;
	
	@FindBy(xpath="//input[@name='country']")
	WebElement CountryField;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement CityField;
	
	@FindBy(xpath="//input[@name='adresse']")
	WebElement AddressField;
	
	@FindBy(xpath="//input[@name='footer_text']")
	WebElement FooterTextField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SubmitButton;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement Search;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement DeleteKey;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement Message;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	WebElement SearchResult1;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement SearchResult2;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement EditButton;
	
	@FindBy(xpath="(//tbody/tr/td)[2]")
	WebElement EditEmail;
	
	@FindBy(xpath="(//tbody/tr/td)[3]")
    WebElement EditPhone;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[3]")
	WebElement ManageTable;
	
	@FindBy(xpath="//span[@class='zone']")
	WebElement AddZone;
	
	@FindBy(id="ZonesName")
	WebElement ZoneName;
	
	@FindBy(xpath="//button[@data-target='#Addtable']")
	WebElement AddTable;
	
	@FindBy(id="TableName")
	WebElement TableName;
	
	@FindBy(xpath="//select[@id='Zones']")
	WebElement SelectZone;
	
	@FindBy(xpath="//tbody/tr/td")
	WebElement TableAdded;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement ZoneSubmit;
	
	public AddStore() {
		PageFactory.initElements(getDriver(), this);
	}
	public WebElement Addzone()
	{
		return AddZone;
	}
	
	public void AddingNewStore() throws Exception
	{
		ArrayList list=Ex.getData("StoreData");
		action.click1(menu, "Menu button");
		action.click1(Stores, "Stores Option");
		action.click1(AddStores, "Add stores");
		action.explicitWait(getDriver(), StoreNameField, Duration.ofSeconds(20));
		action.type(StoreNameField, list.get(0).toString());
		action.type(EmailIdField, list.get(1).toString());
		action.type(PhoneField, list.get(2).toString());
		action.type(CountryField, list.get(3).toString());
		action.type(CityField, list.get(4).toString());
		action.type(AddressField, list.get(5).toString());
		action.type(FooterTextField, list.get(6).toString());
		action.click1(SubmitButton, "Submit Button");
	}
	
	public boolean IsSearchStore()
	{
		action.click1(menu, "Menu button");
		action.click1(Stores, "Stores Option");
		action.type(Search, "Magic Shop");
		String Result=SearchResult1.getText();
		boolean status=false;
		if(Result.equalsIgnoreCase("Magic Shop"))
		{
			status=true;
		}
		return status;
	}
	
	public boolean IsDeleteStore()
	{
		IsSearchStore();
		action.click1(DeleteKey, "Delete Key");
		action.type(Search, "Magic Shop");
		String Result=SearchResult2.getText();
		boolean status=false;
		if(Result.equalsIgnoreCase("No matching records found"))
		{
			status=true;
		}
		return status;
	}
	public void EditStoreDetails()
	{
		IsSearchStore();
		action.click1(EditButton, "Edit");
		action.type(PhoneField, Phone1);
		action.type(EmailIdField, Email1);
		action.click1(SubmitButton, "Submit");
	}
	public boolean IsConfirmEdit()
	{
		boolean status=false;
		IsSearchStore();
		if((EditPhone.getText().equalsIgnoreCase(Phone1)) && (EditEmail.getText().equalsIgnoreCase(Email1)))
		{
			status=true;
		}
		return status;
	}
	public void AddZone() throws InterruptedException
	{
		IsSearchStore();
		action.click1(ManageTable, "Manage Table");
		action.explicitWait(getDriver(), AddZone, Duration.ofSeconds(30));
		action.click1(AddZone, "Add Zone");
		action.type(ZoneName, "Delhi");
		action.click1(ZoneSubmit, "Submit");
	}
	public void AddTable()
	{
		action.click1(AddTable, "Add Table");
		action.type(TableName, "Customer");
		action.selectByVisibleText("Delhi", SelectZone);
		action.click1(SubmitButton, "Submit");
	}
	public boolean IsTableValidation()
	{
		return action.isDisplayed(getDriver(), TableAdded);
	}

}
