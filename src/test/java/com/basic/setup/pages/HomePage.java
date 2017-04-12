package com.basic.setup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(id = "lst-ib")
	WebElement searchData;

	@FindBy(linkText = "Home Rabobank Group")
	WebElement link;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\selenium-server-standalone\\chromedriver.exe");
	}

	public void search(String searchText) {
		searchData.sendKeys(searchText);
	}

	public void clickOnSearch() {
		searchData.click();
	}

	public void clickOnLink() {
		link.click();
	}

}
