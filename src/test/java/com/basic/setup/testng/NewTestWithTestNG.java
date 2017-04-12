package com.basic.setup.testng;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.basic.setup.pages.HomePage;

public class NewTestWithTestNG {
	protected WebDriver driver;

	HomePage homePage;

	@Test
	public void f() {
		driver.get("http://www.google.co.in");
		Assert.assertTrue(driver.getTitle().contains("Google"));
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\selenium-server-standalone\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);
	}

	@AfterTest
	public void afterTest() {
		homePage.search("RABOBANK");
		homePage.clickOnSearch();
		homePage.clickOnLink();
		Assert.assertTrue(driver.getTitle().contains("Rabobank"));
		driver.close();
	}

}
