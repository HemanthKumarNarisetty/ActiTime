package com.actitime.generics;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listenersimplementation extends BaseClass implements ITestListener{
	
	public void onTestFailure(ITestResult result)
	{
		String res=result.getName();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
			File des=new File("./screenshots/"+res+".png");
			try {
				FileUtils.copyFile(src, des);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
	}
}
