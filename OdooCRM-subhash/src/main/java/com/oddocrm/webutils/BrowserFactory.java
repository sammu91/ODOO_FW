package com.oddocrm.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.oddocrm.generic.GenericLib;

public class BrowserFactory 
{
	public static WebDriver launch(String browserName, String headless)
	{
		WebDriver driver=null;
		
		if (GenericLib.osName.contains("Windows")) 
		{
			if (browserName.equalsIgnoreCase("chrome")) 
			{
				ChromeCapabilities cap=new ChromeCapabilities();
				System.setProperty("webdriver.chrome.driver", GenericLib.dirPath+"\\exefiles\\chromedriver.exe");
				driver=new ChromeDriver(cap.getChromeCapabilities(headless));
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				FirefoxCapabilties cap=new FirefoxCapabilties();
				System.setProperty("webdriver.gecko.driver", GenericLib.dirPath+"\\exefiles\\geckodriver.exe");
				driver=new FirefoxDriver(cap.getFirefoxCapabilities(headless));
			}
		}
		else if(GenericLib.osName.contains("Linux"))
		{
			
		}
		else if(GenericLib.osName.contains("Mac"))
		{
			
		}
		return driver;
	}
}
