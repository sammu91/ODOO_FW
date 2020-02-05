package com.oddocrm.steps;

import java.text.MessageFormat;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.oddocrm.generic.Driver;
import com.oddocrm.generic.SeleniumLib;
import com.oddocrm.pageobjects.BasePage;
import com.oddocrm.pageobjects.CustomersPage;

import io.qameta.allure.Step;

public class CustomersSteps 
{
	WebDriver driver;
	SeleniumLib slib;
	BasePage bp;
	CustomersPage cp;
	ConfigurationSteps cs;
	
	public CustomersSteps()
	{
		driver=Driver.getDriver();
		slib=new SeleniumLib();
		bp=new BasePage();
		cp=new CustomersPage();
		cs=new ConfigurationSteps();
	}
	
	@Step("Create New Customer")
	public void createCustomer(String name, String jobposition, String street1, String street2, String city, String zip, String state, String filepath, String sheet, int row)
	{
		driver.findElement(By.xpath(cp.customers)).click();
		slib.iWait(5);
		slib.javascriptClick(driver.findElement(By.xpath(cp.createBtn)));
		slib.clickChkOrRadio(By.xpath(cp.individualRadioBtn));
		
		Random rd=new Random();
		String[] str = name.split("-");
		name=str[0]+"-"+rd.nextInt(1000);
		
		driver.findElement(By.xpath(cp.nameTxtBx)).sendKeys(name);
		
		cs.modifyTLInfo(filepath, sheet, row, 3, name);
		cs.modifyTLInfo(filepath, sheet, 5, 4, name);
		cs.modifyTLInfo(filepath, sheet, 6, 3, name);
		
		driver.findElement(By.xpath(cp.jobPosTxtBx)).sendKeys(jobposition);
		driver.findElement(By.xpath(cp.titleTxtBx)).click();
		driver.findElement(By.xpath(cp.mister)).click();
		driver.findElement(By.xpath(cp.streetTxtBx)).sendKeys(street1);
		driver.findElement(By.xpath(cp.street2TxtBx)).sendKeys(street2);
		driver.findElement(By.xpath(cp.citytxtbx)).sendKeys(city);
		driver.findElement(By.xpath(cp.ziptxtbx)).sendKeys(zip);
		driver.findElement(By.xpath(cp.stateTxtBx)).sendKeys(state);
		String stateXp = MessageFormat.format(cp.state, state);
		driver.findElement(By.xpath(stateXp)).click();
		driver.findElement(By.xpath(cp.saveBtn)).click();
		
		slib.iWait(5);
		String[] str1 = driver.getTitle().split(" - ");
		Assert.assertEquals(str1[0], name);
		Reporter.log("Customer "+name+" successfully created", true);
	}
	
}
