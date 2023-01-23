package com.qa.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.pageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver;
	public static Logger logger;
	public LoginPage login;


	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("Dalalstreet Application");
		PropertyConfigurator.configure("Log4j.properties");

		logger.info("Framework Execution start successfully");
	}

	@AfterTest
	public void end()
	{
		logger.info("Framework Execution stop successfully");
	}

	@Parameters("Browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			logger.info("Edge browser is ready for execution");
		}
		else if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			logger.info("Chrome browser is ready for execution");

		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			logger.info("Firefox browser is ready for execution");
		}
		else
		{
			logger.info("Browser not found");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.apps.dalalstreet.ai/login");

		login = new LoginPage();
	}

	@AfterClass
	public void close()
	{
		driver.close();
	}
}
