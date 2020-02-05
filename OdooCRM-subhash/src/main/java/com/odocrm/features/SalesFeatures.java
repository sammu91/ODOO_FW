package com.odocrm.features;

import com.oddocrm.steps.ActivitySteps;
import com.oddocrm.steps.CustomersSteps;
import com.oddocrm.steps.MyPipelineSteps;

public class SalesFeatures 
{
	CustomersSteps cs;
	CommonSteps cms;
	MyPipelineSteps mps;
	ActivitySteps as;
	
	public SalesFeatures()
	{
		as=new ActivitySteps();
		cs=new CustomersSteps();
		cms=new CommonSteps();
		mps=new MyPipelineSteps();
	}
	
	public void createNewCustomer(String name, String jobposition, String street1, String street2, String city, String zip, String state, String filepath, String sheet, int row)
	{
		cms.clickCRM();
		cms.clickSales();
		cs.createCustomer(name, jobposition, street1, street2, city, zip, state, filepath, sheet, row);
	}
	
	public void createNewOpportunity(String opportunity, String customerName)
	{
		cms.clickCRM();
		cms.clickSales();
		mps.createNewOpp(opportunity, customerName);
		mps.verifyOpp(opportunity, customerName);
	}	
	
	public void ScheduleActivitywithOpp(String customerName, String ActvityName)
	{
		cms.clickCRM();
		as.ScheduleActivitywithOpp(customerName, ActvityName);
	}
	
	public void markDone(String customerName)
	{
		cms.clickCRM();
		as.MarkDoneforOpp(customerName);
	}
	
	public void moveOpptoQualified(String customerName, String stageName)
	{
		cms.clickCRM();
		as.moveOpp(customerName, stageName);
	}
	
	public void verifyOppinQualified(String customerName)
	{
		cms.clickCRM();
		as.verifyOppinQualified(customerName);
	}
	
	public void ScheduleActivityinQualified(String customerName, String ActivityName)
	{
		cms.clickCRM();
		as.ScheduleActivitywithOpp(customerName, ActivityName);
	}
	
	public void markdoneinQualified(String customerName)
	{
		cms.clickCRM();
		as.MarkDoneforOpp(customerName);
	}
	
	public void moveopptoProp(String customerName, String stageName)
	{
		cms.clickCRM();
		as.moveOpp(customerName, stageName);
	}
	
	public void providerevenue(String customerName, String amount)
	{
		cms.clickCRM();
		as.revenue(customerName, amount);
	}
	
	public void ScheduleActivityinProposition(String customerName, String ActivityName)
	{
		cms.clickCRM();
		as.scheduleActifromInsideProp(customerName, ActivityName);
	}
	
	public void markdoneinProp(String customerName)
	{
		cms.clickCRM();
		as.MarkDoneforOpp(customerName);
	}
	
	public void moveopptoWon(String customerName, String stageName)
	{
		cms.clickCRM();
		as.moveOpp(customerName, stageName);
	}
}