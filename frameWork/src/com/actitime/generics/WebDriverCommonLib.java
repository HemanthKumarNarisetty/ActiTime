package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Hemanth
 *
 */
public class WebDriverCommonLib {
	/**
	 * 
	 * @param driver
	 */
	public void waitForElementIntGui(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 */
	public void customWait(WebElement element)
	{
		int i=0;
		while(i<100)
		{
			try {
				element.isDisplayed();
				break;
			}catch(Exception e)
			{
				i++;
			}
		}
	}
	/**
	 * 
	 * @param element
	 * @param i
	 */
	public void selectoption(WebElement element,int i)
	{
		Select s=new Select(element);
		s.selectByIndex(i);
	}
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public void selectOption(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}

}
