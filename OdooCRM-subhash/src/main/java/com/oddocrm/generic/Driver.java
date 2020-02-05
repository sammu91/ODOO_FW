package com.oddocrm.generic;

import org.openqa.selenium.WebDriver;

public class Driver 
{
	private static WebDriver driver;
	
	public static void setDriver(WebDriver wdriver)
	{
		driver=wdriver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	
}
