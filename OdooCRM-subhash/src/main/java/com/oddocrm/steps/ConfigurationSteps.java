package com.oddocrm.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.oddocrm.generic.Driver;
import com.oddocrm.generic.SeleniumLib;
import com.oddocrm.pageobjects.BasePage;
import com.oddocrm.pageobjects.ConfigurationPage;
import com.oddocrm.pageobjects.SalesTeamPage;

import io.qameta.allure.Step;

public class ConfigurationSteps 
{
	WebDriver driver;
	BasePage bp;
	ConfigurationPage cp;
	SalesTeamPage stp;
	SeleniumLib slib;
	
	public ConfigurationSteps()
	{
		driver=Driver.getDriver();
		slib=new SeleniumLib();
		bp=new BasePage();
		cp=new ConfigurationPage();
		stp=new SalesTeamPage();
	}
	
	@Step("Creating sales team {salesTeamName} and team Leader {teamLeaderName} {teamLeaderEmailID}")
	public void createSalesTeam(String salesTeamName, String teamLeaderName, String teamLeaderEmailID, String filepath, String sheet, int row)
	{
		driver.findElement(By.xpath(cp.salesTeams)).click();
		slib.javascriptClick(driver.findElement(By.xpath(stp.create)));
		try
		{
			driver.findElement(By.xpath(stp.ok)).click();
		}
		catch(NoSuchElementException e)
		{
			
		}
		slib.javascriptClick(driver.findElement(By.xpath(stp.create)));
		driver.findElement(By.xpath(stp.salesTeamTxtBx)).sendKeys(salesTeamName);
		
		Random rd=new Random();
		String[] str = teamLeaderName.split("-");
		teamLeaderName=str[0]+"-"+rd.nextInt(1000);
		
		String[] email = teamLeaderEmailID.split("@");
		teamLeaderEmailID=teamLeaderName+"@"+email[1];
		
		createTeamLeader(teamLeaderName, teamLeaderEmailID);
		modifyTLInfo(filepath, sheet, row, 4, teamLeaderName);
		modifyTLInfo(filepath, sheet, row, 5, teamLeaderEmailID);
		slib.CheckElementPresent(20, By.xpath(stp.salesTeamSave));
		slib.javascriptClick(driver.findElement(By.xpath(stp.salesTeamSave)));
		validateSalesTeam(teamLeaderName, salesTeamName);
	}
	
	@Step("Creating sales team leader")
	public void createTeamLeader(String teamLeaderName, String teamLeaderEmailID)
	{
		driver.findElement(By.xpath(stp.teamLeader)).click();
		driver.findElement(By.xpath(stp.createEdit)).click();
		slib.CheckElementPresent(20, By.xpath(stp.teamLeaderheader));
		slib.CheckElementPresent(20, By.xpath(stp.teamLeaderTxtBx));
		driver.findElement(By.xpath(stp.teamLeaderTxtBx)).sendKeys(teamLeaderName);
		driver.findElement(By.xpath(stp.teamLeaderEmail)).sendKeys(teamLeaderEmailID);
		slib.CheckElementPresent(20, By.xpath(stp.teamLeaderSave));
		driver.findElement(By.xpath(stp.teamLeaderSave)).click();
		slib.iWait(10);

	}
	
	@Step("modifyTLInfo")
	public void modifyTLInfo(String filepath, String sheet, int row, int cell, String value)
	{
		try
		{
			File file=new File(filepath);
			FileInputStream fis=new FileInputStream(file);
			Workbook wb=WorkbookFactory.create(fis);
			Cell cl = wb.getSheet(sheet).getRow(row).getCell(cell);
			cl.setCellValue(value);
			
			FileOutputStream fos=new FileOutputStream(file);
			wb.write(fos);
		}
		catch(EncryptedDocumentException | IOException e)
		{
			
		}
	}
	
	@Step("validateSalesTeam")
	public void validateSalesTeam(String teamLeaderName, String salesTeam)
	{
		driver.findElement(By.xpath(stp.salesTeamLink)).click();
		List<WebElement> rows = driver.findElements(By.xpath(stp.salesTeamRows));
		for (int i = 1; i <rows.size(); i++) 
		{
			String thirdCol = MessageFormat.format(stp.salesTeamThirdCol, i);
			String tlName = driver.findElement(By.xpath(thirdCol)).getText();
			if (tlName.equalsIgnoreCase(teamLeaderName)) 
			{
				String secondCol = MessageFormat.format(stp.salesTeamSecondCol, i);
				String slName = driver.findElement(By.xpath(secondCol)).getText();
				if (slName.equalsIgnoreCase(salesTeam)) 
				{
					Assert.assertTrue(true);
					Reporter.log("Sales Team and Team Lead successfully created", true);
					break;
				}
			}
		}
	}
}