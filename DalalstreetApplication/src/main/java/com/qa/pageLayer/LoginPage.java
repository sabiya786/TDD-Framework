package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class LoginPage extends TestBase
{
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//email
	@FindBy(xpath="//input[@name='email']")
	private WebElement email_box;
	public void enterEmai(String email)
	{
		email_box.sendKeys(email);
	}
	
	//password
	@FindBy(xpath="//input[@name='password']")
	private WebElement pass_box;
	public void enterPassword(String pass)
	{
		pass_box.sendKeys(pass);
	}

	//login button
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")
	private WebElement login_btn;
	public void clickonLoginbtn()
	{
		login_btn.click();
	}

}
