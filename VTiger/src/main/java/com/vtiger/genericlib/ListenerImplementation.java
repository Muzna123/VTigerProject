package com.vtiger.genericlib;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	
	public void onTestStart(ITestResult result) {

		
	}

	
	public void onTestSuccess(ITestResult result) {

		
	}

	
	public void onTestFailure(ITestResult itr) {
		Date d = new Date();
		String currentDate = d.toString();
		String reqDate = currentDate.replaceAll(" ", "").replaceAll(":", "");
		String TC_name = itr.getName();
		EventFiringWebDriver web = new EventFiringWebDriver(BaseClass.driver);
		File src = web.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + TC_name + reqDate + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {

		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {

		
	}

	
	public void onStart(ITestContext context) {

		
	}

	
	public void onFinish(ITestContext context) {

		
	}

}
