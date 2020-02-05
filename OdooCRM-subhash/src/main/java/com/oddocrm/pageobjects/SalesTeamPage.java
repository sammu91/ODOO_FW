package com.oddocrm.pageobjects;

public class SalesTeamPage 
{
	public String create="//button[contains(text(),'Create')]";
	public String salesTeamTxtBx="//input[@name='name']";
	public String teamLeader="//div[@name='user_id']/div/input";
	public String createEdit="//a[starts-with(text(),'Create and Edit')]";
	public String teamLeaderTxtBx="//label[text()='Name']/following-sibling::h1/input";
	public String teamLeaderEmail="//input[@name='login']";
	public String teamLeaderSave="//span[text()='Save']/parent::button";
	public String salesTeamSave="(//button[contains(text(),'Save')])[1]";
	public String ok="//span[text()='Ok']";
	public String teamLeaderheader="//h4[text()='Create: Team Leader']";
	public String salesTeamLink="//a[text()='Sales Teams']";
	public String salesTeamRows="//table//tr";
	public String salesTeamCols="//table//tr[{0}]/td";
	public String salesTeamThirdCol="//table//tr[{0}]/td[3]";
	public String salesTeamSecondCol="//table//tr[{0}]/td[2]";
	public String salesTeamCol="//table//tr[{0}]/td[{1}]";
}
