package com.oddocrm.pageobjects;

public class MyPipelinePage 
{
	public String pipeline="//span[text()='My Pipeline']";
	public String createBtn="//button[contains(text(),'Create')]";
	public String oppNameTxtBx="//input[@name='name']";
	public String customerTxtBx="//div[@name='partner_id']//input";
	public String customer="//a[text()=''{0}'']";
	public String addBtn="(//button[text()='Add'])[1]";
	
	public String custName = "//span[contains(text(),''{0}'')]";
	
	public String ScheduleActivity="//span[contains(text(),''{0}'')]/../following-sibling::div//span";
	public String ScheduleBtn="//strong[text()='Schedule an activity']";
	public String Activity = "(//div[@class='o_input_dropdown']//input)[2]";
	public String SelActivity = "//ul[starts-with(@class,'ui-autocomple')]//li//a[text()=''{0}'']";
	public String SchBtn = "//button//span[text()='Schedule']";
	
	public String MarkasDone="//a[@title='Mark as done']";
	public String done="(//button[contains(text(),'Done')])[2]";
	
	public String Stage="//span[text()=''{0}'']";
	
	public String QualifiedStage="(//div[@name='stage_id']//button)[3]";
	
	public String editBtn="//button[contains(text(),'Edit')]";
	public String revenuetxtBx="(//input[@class='o_input'])[2]";
	public String saveBtn="//button[contains(text(),'Save')]";
	
	public String ScheduleActiInside="//button[@title='Log or schedule an activity']";
	
}
