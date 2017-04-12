package com.my.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HelloWorldApp {
	public static WebDriver webDriver = new FirefoxDriver();
	
	static Integer FIVE = 5;
	static Integer TEN =10;

	public static void main(String[] args) {
		
		webDriver.get("https://www.google.co.in/");
		WebElement searchBox = webDriver.findElement(By.id("lst-ib"));
		searchBox.sendKeys("RABOBANK");
		searchBox.click();
		waitTill(webDriver,FIVE);
		WebElement rabobank = webDriver.findElement(By.linkText("Home Rabobank Group"));
		//WebElement rabobank = webDriver.findElement(By.xpath("/html/body/div/div[6]/div[4]/div[8]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div/div[1]/div/h3/a"));
		rabobank.click();
		waitTill(webDriver,FIVE);

		WebElement aboutUs = webDriver.findElement(By.xpath("/html/body/div[3]/header/noindex/div[2]/div[2]/div/div[2]/ul/li[3]/span"));
		aboutUs.click();
		
		waitTill(webDriver,FIVE);
		WebElement profile = webDriver.findElement(By.xpath("/html/body/div[3]/header/noindex/div[2]/div[2]/div/div[2]/ul/li[3]/div/div[2]/div[1]/ul/li[1]/a"));
		profile.click();
		System.out.println(profile.getText());
//		Assert.assertEquals("Profile",profile.getText());
		waitTill(webDriver,TEN);
		
		WebElement select = webDriver.findElement(By.id("secure-login"));
		List<WebElement> allOptions = select.findElements(By.tagName("option"));
		for (WebElement option : allOptions) {
		}
		waitTill(webDriver,TEN);
	}

	private static void waitTill(WebDriver webDriver, Integer sec) {
		webDriver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

}
