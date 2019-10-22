package com.Qa.TestBaseDemo;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

public static WebDriver driver;
public static Properties prop;

public TestBase() //constructor
{
	
	try
	{
		FileInputStream ip=new FileInputStream("D:\\mansi\\com.facebook\\src\\main\\java\\com\\facebook\\configuration\\config.properties");
		prop=new Properties(); // initializing prop from properties
		prop.load(ip);// loading properties from config file
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}	
}
public static void initialization()
{
	String browserName=prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty(prop.getProperty("systemproperty_1"),prop.getProperty("systemproperty_2")); //Setting the browser
		driver=new ChromeDriver(); // initializing the driver
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // implicit wait time
	driver.get(prop.getProperty("url")); //getting url		
}
	
}





