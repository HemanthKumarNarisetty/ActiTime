package com.actitime.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LoginPage;
import com.actitime.pom.TaskPage;

public class DemoTest extends BaseClass {
	@Test()
	public void testLoginPage() throws IOException {
		FileLib f=new FileLib();
		LoginPage lp=new LoginPage(driver);
		lp.setUnTB(f.getPropertyValue("username"));
		lp.setPwTB(f.getPropertyValue("password"));
		lp.setLoBTN();
		EnterTimeTrackPage et=new EnterTimeTrackPage(driver);
		et.setTask();
		TaskPage tp=new TaskPage(driver);
		tp.setAddNew();
		tp.setNewCustomer();
		tp.setEnterCustomerName(f.getPropertyValue("name"));
		tp.setDescription(f.getPropertyValue("des"));
		tp.setSelectCustomer();
		tp.setCompany();
		tp.setCreateCustomer();
		String s1=tp.getCustomer();
		String s2="Hemanth";
		String st=f.getPropertyValue("name");
		Assert.assertEquals(s1, s2);
	}

}