package com.oddocrm.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.oddocrm.generic.Driver;
import com.oddocrm.generic.GenericLib;
import com.oddocrm.webutils.OdooTestNGListener;
import com.odocrm.features.ConfigurationFeatures;
import com.odocrm.features.LoginFeature;
import com.odocrm.features.SalesFeatures;

public abstract class BaseAbstractTest 
{
	//public static WebDriver driver;  //Global driver
	public static EventFiringWebDriver driver;  //global driver
	public LoginFeature lf;
	public ConfigurationFeatures cf;
	public SalesFeatures sf;
	
	@BeforeClass
	public void setUp()
	{
		lf=new LoginFeature();
		cf=new ConfigurationFeatures();
		sf=new SalesFeatures();
	}
	
	
	
	@BeforeMethod
	public void preCondition()
	{
		//driver=Driver.getDriver();
		driver=new EventFiringWebDriver(Driver.getDriver());
		driver.register(new OdooTestNGListener());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(GenericLib.getValue(GenericLib.dirPath+"\\config.properties", "baseurl"));
	}
}