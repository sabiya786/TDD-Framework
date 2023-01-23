package com.qa.testLayer;

import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class TestLoginPage extends TestBase
{
	@Test
	public void verifyLoginPageFunctionality()
	{
		login.enterEmai("shaikh@gmail.com");
		login.enterPassword("Shaikh123@");
		login.clickonLoginbtn();
	}


}
