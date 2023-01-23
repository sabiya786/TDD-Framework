package com.qa.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class UtilityClass extends TestBase
{

	public UtilityClass()
	{
		PageFactory.initElements(driver, this);
	}

	//Screenshot
	public static void getScreenshot(String nameOfScreenshot)
	{
		String path = "D:\\TDD-Framework-\\DalalstreetApplication\\Screenshot\\";

		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path+nameOfScreenshot+System.currentTimeMillis()+".png");

		try
		{
			FileHandler.copy(src, dest);

		}
		catch(IOException e)
		{
			logger.info("File not found");
		}
	}
}
