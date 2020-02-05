package com.oddocrm.webutils;

import org.openqa.selenium.firefox.FirefoxOptions;

import com.oddocrm.generic.GenericLib;

public class FirefoxCapabilties 
{
	public FirefoxOptions getFirefoxCapabilities(String headless)
	{
		FirefoxOptions options=new FirefoxOptions();
		options.setCapability("APPLICATION_NAME", GenericLib.getValue(GenericLib.dirPath+"\\config.properties", "applicationName"));
		options.setCapability("BROWSER_NAME", GenericLib.getValue(GenericLib.dirPath+"\\config.properties", "browserName"));
		options.setCapability("PLATFORM_NAME", GenericLib.osName);
		options.setHeadless(Boolean.parseBoolean(headless));
		
		return options;
	}
}
