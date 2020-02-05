package com.oddocrm.scripts;

import org.testng.annotations.Test;

import com.oddocrm.generic.ExcelUtilities;
import com.oddocrm.generic.GenericLib;

public class SalesTest extends BaseAbstractTest
{
	@Test
	public void createCustomer()
	{
		String filepath=GenericLib.dirPath+"\\testdata\\Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createNewCustomer_ID", "Sheet1");
		lf.validLogin(data[1], data[2]);
		sf.createNewCustomer(data[3], data[4], data[5], data[6], data[7], data[8], data[9], filepath, "Sheet1", 4);	
	}
	
	@Test(dependsOnMethods= {"createCustomer"})
	public void createOpportunity()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createOpportunity_ID", "Sheet1");
		sf.createNewOpportunity(data[3], data[4]);
	}
	
	@Test(dependsOnMethods= {"createOpportunity"})
	public void ScheduleActivity()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createActivity_ID", "Sheet1");
		sf.ScheduleActivitywithOpp(data[3], data[4]);
	}
	
	@Test(dependsOnMethods= {"ScheduleActivity"})
	public void markDone()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createActivity_ID", "Sheet1");
		sf.markDone(data[3]);
	}
	
	@Test(dependsOnMethods= {"markDone"})
	public void moveOpptoQualified()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createOpportunity_ID", "Sheet1");
		sf.moveOpptoQualified(data[4], data[5]);
	}
	
	@Test(dependsOnMethods= {"moveOpptoQualified"})
	public void verifyOppinQualified()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createActivity_ID", "Sheet1");
		sf.verifyOppinQualified(data[3]);
	}
	
	@Test(dependsOnMethods= {"verifyOppinQualified"})
	public void ScheduleActivityinQualified()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createActivity_ID", "Sheet1");
		sf.ScheduleActivityinQualified(data[3], data[5]);
	}
	
	@Test(dependsOnMethods= {"ScheduleActivityinQualified"})
	public void markDoneinQualified()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createActivity_ID", "Sheet1");
		sf.markdoneinQualified(data[3]);
	}
	
	@Test(dependsOnMethods= {"markDoneinQualified"})
	public void moveopptoProp()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createOpportunity_ID", "Sheet1");
		sf.moveopptoProp(data[4], data[5]);
	}
	
	@Test(dependsOnMethods= {"moveopptoProp"})
	public void revenue()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createOpportunity_ID", "Sheet1");
		sf.providerevenue(data[4], data[8]);
	}
	
	@Test(dependsOnMethods= {"revenue"})
	public void ScheduleActivityinProposition()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createActivity_ID", "Sheet1");
		sf.ScheduleActivityinProposition(data[3], data[6]);
	}
	
	@Test(dependsOnMethods= {"ScheduleActivityinProposition"})
	public void markDoneinProp()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createActivity_ID", "Sheet1");
		sf.markdoneinProp(data[3]);
	}
	
	@Test(dependsOnMethods= {"markDoneinProp"})
	public void moveopptoWon()
	{
		ExcelUtilities eu=new ExcelUtilities(GenericLib.dirPath+"\\testdata\\Odoodata.xlsx");
		String[] data = eu.readData("createOpportunity_ID", "Sheet1");
		sf.moveopptoProp(data[4], data[5]);
	}
}
