package com.oddocrm.webutils;

import org.openqa.selenium.chrome.ChromeOptions;

import com.oddocrm.generic.GenericLib;

public class ChromeCapabilities 
{
	public ChromeOptions getChromeCapabilities(String headless)
	{
		ChromeOptions options=new ChromeOptions();
		options.setCapability("APPLICATION_NAME", 
		GenericLib.getValue(GenericLib.dirPath+"\\config.properties", "applicationName"));
		options.setCapability("BROWSER_NAME", 
		GenericLib.getValue(GenericLib.dirPath+"\\config.properties", "browserName"));
		options.setCapability("PLATFORM_NAME", GenericLib.osName);
		options.setHeadless(Boolean.parseBoolean(headless));
		
		return options;
	}
}
