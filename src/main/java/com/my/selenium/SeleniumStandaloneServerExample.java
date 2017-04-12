
package com.my.selenium;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SeleniumStandaloneServerExample {
	public static WebDriver chromeWebDriver;
	public static WebDriver fireforWebDriver;
	static Integer FIVE = 5;
	static Integer TEN =10;

	public static void main(String[] args) throws MalformedURLException {
//		workingWithProxy();
		chromeWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
		
		chromeWebDriver.get("https://www.google.co.in");
		waitTill(chromeWebDriver,FIVE);
		fireforWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
		waitTill(chromeWebDriver,FIVE);
		fireforWebDriver.get("https://accounts.google.com");
		waitTill(fireforWebDriver,FIVE);
		WebElement searchBox = chromeWebDriver.findElement(By.id("lst-ib"));
		searchBox.sendKeys("RABOBANK");
		searchBox.click();
		waitTill(chromeWebDriver,FIVE);
		WebElement rabobank = chromeWebDriver.findElement(By.linkText("Home Rabobank Group"));
		rabobank.click();
		waitTill(chromeWebDriver,FIVE);
		
		 WebDriver augmentedDriver = new Augmenter().augment(chromeWebDriver);
	        File screenshot = ((TakesScreenshot)augmentedDriver).
	                            getScreenshotAs(OutputType.FILE);
	        
	}
	private static void waitTill(WebDriver webDriver, Integer sec) {
		webDriver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
//	private static void workingWithProxy(){
//		String PROXY = "localhost:8080";
//
//		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//		proxy.setHttpProxy(PROXY)
//		     .setFtpProxy(PROXY)
//		     .setSslProxy(PROXY);
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(CapabilityType.PROXY, proxy);
//
//		WebDriver driver = new InternetExplorerDriver(cap);
//		driver.get("www.google.co.in");
//	}

}
