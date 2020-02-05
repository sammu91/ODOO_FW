package com.oddocrm.scripts;

import org.testng.annotations.Test;

import com.oddocrm.generic.ExcelUtilities;
import com.oddocrm.generic.GenericLib;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest extends BaseAbstractTest
{
	@Test (priority =1)
	@Severity(SeverityLevel.BLOCKER)
	@Story("Check login functionality with valid credentials")
	@Description("Check the fucntionality of login using valid credentials")
	public void validLogin()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("validLogin_ID", "Sheet1");
		lf.validLogin(data[1], data[2]);
	}
	
	@Test (priority =2)
	@Severity(SeverityLevel.CRITICAL)
	@Story("Check login functionality with Invalid credentials")
	@Description("Check the fucntionality of login using Invalid Password")
	public void InvalidLogin()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("invalidLogin_ID", "Sheet1");
		lf.InvalidLogin(data[1], data[2]);
	}
}