package com.oddocrm.pageobjects;

public class BasePage 
{
	public String crm="//div[text()='CRM']";
	public String emailID="//span[text()=''{0}'']";
	
	public String lgout = "//a[text()='Log out']";	

	public String configuration="//a[contains(text(),'Configuration')]";
	public String sales="//ul[@role='menu']//a[contains(text(),'Sales')]";
}

