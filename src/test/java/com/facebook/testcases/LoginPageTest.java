package com.facebook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Qa.TestBaseDemo.TestBase;
import com.facebook.pages.LoginPage;

public class LoginPageTest extends TestBase {
LoginPage loginpage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeSuite
	public void setup()
	{
		initialization();
		loginpage= new LoginPage();
	}
	@Test
	public void verifytitle()
	{
		String title=loginpage.verifyTitle();
		Assert.assertEquals(title,"Facebook - log in or sign up");
	}
	@Test
	public void verifyLoginTest()
	{
		loginpage.verifyLogin();
	}
	@AfterSuite
	public void close()
	{
		driver.close();
		
	}
}
