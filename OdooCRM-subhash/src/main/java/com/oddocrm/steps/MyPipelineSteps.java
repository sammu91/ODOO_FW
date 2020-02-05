package com.oddocrm.steps;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.oddocrm.generic.Driver;
import com.oddocrm.generic.SeleniumLib;
import com.oddocrm.pageobjects.MyPipelinePage;

public class MyPipelineSteps 
{
	WebDriver driver;
	SeleniumLib slib;
	MyPipelinePage mpp;
	
	public MyPipelineSteps()
	{
		driver=Driver.getDriver();
		slib=new SeleniumLib();
		mpp=new MyPipelinePage();
	}
	
	public void clickMyPipeline()
	{
		driver.findElement(By.xpath(mpp.pipeline)).click();
	}
	
	public void createNewOpp(String oppName, String customerName)
	{
		slib.javascriptClick(driver.findElement(By.xpath(mpp.createBtn)));
		driver.findElement(By.xpath(mpp.oppNameTxtBx)).sendKeys(oppName);
		driver.findElement(By.xpath(mpp.customerTxtBx)).sendKeys(customerName);
		String custName = MessageFormat.format(mpp.customer, customerName);
		driver.findElement(By.xpath(custName)).click();
		driver.findElement(By.xpath(mpp.addBtn)).click();
		slib.iWait(5);
	}
	
	public void verifyOpp(String oppName, String custName)
	{
		
		driver.findElement(By.xpath(MessageFormat.format(mpp.custName, custName))).click();	
		slib.iWait(3);
		String[] str = driver.getTitle().split(" - ");
		Assert.assertEquals(str[0], oppName);
		Reporter.log("Opportunity "+oppName+" successfully created", true);
	}
}
