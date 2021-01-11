package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loBTN;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setUnTB(String str1) {
		unTB.sendKeys(str1);
	}
	public void setPwTB(String str2 ) {
		pwTB.sendKeys(str2);
		
	}
	public void setLoBTN() {
		loBTN.click();
	}
	
}
