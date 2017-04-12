package com.basic.setup;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.basic.setup.pages.HomePage;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class BasicSetupStepDefs {
	
	protected WebDriver driver;
	
	HomePage homePage;
	
	@Before
	public void setUp(){
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);
	}
	
	@Given("^Welcome to test$")
	public void Welcome_to_test() throws Throwable {
		driver.get("http://www.google.co.in");
		Assert.assertTrue(driver.getTitle().contains("Google"));
	}

	@When("^is it ready$")
	public void is_it_ready() throws Throwable {
		homePage.search("RABOBANK");
		homePage.clickOnSearch();
		homePage.clickOnLink();
		Assert.assertTrue(driver.getTitle().contains("Rabobank"));
	}

	@Then("^yah Its ready$")
	public void yah_Its_ready() throws Throwable {
	    System.out.println("Done");
	}


	
}
