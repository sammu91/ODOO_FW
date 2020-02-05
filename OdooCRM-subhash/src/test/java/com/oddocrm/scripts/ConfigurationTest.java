package com.oddocrm.scripts;

import org.testng.annotations.Test;

import com.oddocrm.generic.ExcelUtilities;
import com.oddocrm.generic.GenericLib;

public class ConfigurationTest extends BaseAbstractTest
{
	@Test
	public void createSalesTeam()
	{
		String filepath=GenericLib.dirPath+"\\testdata\\Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("createSalesTeam_ID", "Sheet1");
		lf.validLogin(data[1], data[2]);
		cf.createSalesTeam(data[3], data[4], data[5], filepath, "Sheet1", 3);
	}
}
