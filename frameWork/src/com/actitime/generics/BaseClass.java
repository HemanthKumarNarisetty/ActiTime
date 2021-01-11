package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actitime.pom.EnterTimeTrackPage;

public class BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
	}
	public static WebDriver driver;
	public static FileLib f;
	@Parameters("browser")
	@BeforeClass
	public static void openBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public static void login() throws IOException {
		Reporter.log("login",true);
		driver.get(f.getPropertyValue("url"));
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		EnterTimeTrackPage et=new EnterTimeTrackPage(driver);
		Thread.sleep(5000);
		et.setLogout();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
