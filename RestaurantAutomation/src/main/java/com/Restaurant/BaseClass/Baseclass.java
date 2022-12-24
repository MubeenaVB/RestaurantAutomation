package com.Restaurant.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import com.Restaurant.Action.ActionClass;
import com.Restaurant.PageObjects.AddCustomer;
import com.Restaurant.PageObjects.AddExpence;
import com.Restaurant.PageObjects.AddProductCategory;
import com.Restaurant.PageObjects.AddStore;
import com.Restaurant.PageObjects.AddSupplier;
import com.Restaurant.PageObjects.AddWaiter;
import com.Restaurant.PageObjects.ChangeLanguage;
import com.Restaurant.PageObjects.ClientStatsGetReport;
import com.Restaurant.PageObjects.HomePage;
import com.Restaurant.PageObjects.LoginPage;
import com.Restaurant.PageObjects.ProductStatsGetReport;
import com.Restaurant.PageObjects.RegisterStatsGetReport;
import com.Restaurant.PageObjects.ReportsPage;
import com.Restaurant.PageObjects.StockStatsGetReport;
import com.Restaurant.Utilities.ExcelLibrary;
import com.Restaurant.Utilities.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static Properties prop;
	public static ActionClass action;
	public static LoginPage Lp;
	public static AddCustomer Ac;
	public static AddProductCategory Ap;
	public static AddSupplier Asp;
	public static ChangeLanguage Cl;
	public static ReportsPage Rp;
	public static ClientStatsGetReport Gp;
	public static AddStore As;
	public static AddWaiter Aw;
	public static HomePage Hp;
	public static ProductStatsGetReport Ps;
	public static RegisterStatsGetReport Rs;
	public static StockStatsGetReport St;
	public static ExcelLibrary Ex;
	public static AddExpence Ae;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite(groups = "smoke")
	public void beforeSuite() {
		// used to execute log4j config file(log4j.xml)
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();
	}

	// loadConfig method is to load the configuration
	@BeforeTest(groups = "smoke")
	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// testng xml file used to get browser name.
	// checks in which browser each test case is going to run
	@Parameters("Browser")
	@BeforeMethod(groups = "smoke")
	public void firstcall(String browser) {
		launchApp(browser);
		Lp = new LoginPage();
		Ac = new AddCustomer();
		Ap = new AddProductCategory();
		Asp = new AddSupplier();
		Cl = new ChangeLanguage();
		Rp = new ReportsPage();
		Gp = new ClientStatsGetReport();
		As = new AddStore();
		Aw = new AddWaiter();
		Hp = new HomePage();
		Ps = new ProductStatsGetReport();
		Rs = new RegisterStatsGetReport();
		St = new StockStatsGetReport();
		Ex = new ExcelLibrary();
		Ae = new AddExpence();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void launchApp(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		// Maximize the screen
		getDriver().manage().window().maximize();
		action = new ActionClass();
		// Implicit TimeOuts
		action.implicitWait(getDriver(), 10);
		// PageLoad TimeOuts
		action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
	}

	@AfterMethod(groups = "smoke")
	public void AfterMethod() {
		getDriver().close();
	}

	@AfterSuite(groups = "smoke")
	public void Closing() {
		ExtentReport.endReport();
	}

}
