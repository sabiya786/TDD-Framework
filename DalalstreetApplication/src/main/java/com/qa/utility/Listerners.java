package com.qa.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.testBase.TestBase;

public class Listerners extends TestBase implements ITestListener
{

	
	public void onTestStart(ITestResult result) 
	{
		logger.info("Test case execution start successfully");
	}


	public void onTestSuccess(ITestResult result) 
	{
		logger.info("Test case execution done successfully");
		
	}

	
	public void onTestFailure(ITestResult result) 
	{
		logger.info("Test case execution failed ");
		UtilityClass.getScreenshot(result.getName());
		logger.info("Screenshot taken successfully");

	}

	


}
