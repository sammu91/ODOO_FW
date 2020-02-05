package com.odocrm.features;

import com.oddocrm.steps.ConfigurationSteps;

import io.qameta.allure.Feature;

public class ConfigurationFeatures 
{
	ConfigurationSteps cs;
	CommonSteps cms;
	
	public ConfigurationFeatures()
	{
		cs=new ConfigurationSteps();
		cms=new CommonSteps();
	}
	
	@Feature("Feature to create Sales Team and Sales Team Leader")
	public void createSalesTeam(String salesTeamName, String teamLeaderName, String teamLeaderEmailID, String filepath, String sheet, int row)
	{
		cms.clickCRM();
		cms.clickConfiguration();
		cs.createSalesTeam(salesTeamName, teamLeaderName, teamLeaderEmailID, filepath, sheet, row);
	}
	
	
	
}
