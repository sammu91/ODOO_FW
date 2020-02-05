package com.oddocrm.pageobjects;

public class CustomersPage
{
	public String customers="//span[text()='Customers']";
	public String createBtn="//button[contains(text(),'Create')]";
	public String individualRadioBtn="//label[text()='Individual']/preceding-sibling::input";
	public String nameTxtBx="//input[@placeholder='Name']";
	public String jobPosTxtBx="//input[@name='function']";
	public String streetTxtBx="//input[@name='street']";
	public String street2TxtBx="//input[@name='street2']";
	public String citytxtbx="//input[@name='city']";
	public String ziptxtbx="//input[@name='zip']";
	public String stateTxtBx="//div[@name='state_id']//input";
	public String titleTxtBx="//div[@name='title']//input";
	public String mister="//a[text()='Mister']";
	public String state="//a[contains(text(),''{0}'')]";
	public String saveBtn="(//button[contains(text(),'Save')])[1]";
	
}
