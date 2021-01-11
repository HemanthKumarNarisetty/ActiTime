package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

		@FindBy(xpath="//div[text()='Add New']")
		private WebElement addNew;
		
		@FindBy(xpath="//div[contains(text(),\"+ New Customer\")]")
		private WebElement newCustomer;
		
		@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
		private WebElement enterCustomerName;
		
		@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
		private WebElement description;
		
		@FindBy(xpath="//div[text()='- Select Customer -']")
		private WebElement selectCustomer;
		
		@FindBy(xpath="(//div[text()='Our company'])[10]")
		private WebElement company;
		
		@FindBy(xpath="//div[text()='Create Customer']")
		private WebElement createCustomer;
		
		@FindBy(xpath="(//div[text()='Hemanthkumar'])[2]")
		private WebElement customer;
		
		
		public TaskPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public void setAddNew() {
			addNew.click();
		}


		public void setNewCustomer() {
			newCustomer.click();
		}


		public void setEnterCustomerName(String s1) {
			enterCustomerName.sendKeys(s1);
		}


		public void setDescription(String s2) {
			description.sendKeys(s2);
		}

		public void setSelectCustomer()
		{
			selectCustomer.click();
		}
		
		public void setCompany()
		{
			company.click();
		}
		
		public void setCreateCustomer() {
			createCustomer.click();
		}
		
		public String getCustomer() {
			String value1 = customer.getText();
			return value1;
		}
		

}
