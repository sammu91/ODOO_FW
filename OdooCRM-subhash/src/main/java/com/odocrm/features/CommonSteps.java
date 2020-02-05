package com.odocrm.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oddocrm.generic.Driver;
import com.oddocrm.generic.SeleniumLib;
import com.oddocrm.pageobjects.BasePage;

import io.qameta.allure.Step;

public class CommonSteps 
{
	WebDriver driver;
	SeleniumLib slib;
	BasePage bp;
	
	public CommonSteps()
	{
		driver=Driver.getDriver();
		slib=new SeleniumLib();
		bp=new BasePage();
	}
	
	@Step("Clicking CRM")
	public void clickCRM()
	{
		driver.findElement(By.xpath(bp.crm)).click();
	}
	
	@Step("Clicking Configuration")
	public void clickConfiguration()
	{
		driver.findElement(By.xpath(bp.configuration)).click();
	}
	
	@Step("Clicking Sales")
	public void clickSales()
	{
		driver.findElement(By.xpath(bp.sales)).click();
	}
}
