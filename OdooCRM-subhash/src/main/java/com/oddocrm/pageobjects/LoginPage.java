package com.oddocrm.pageobjects;

public class LoginPage 
{
	public String emailTxtBx="//input[@id='login']";
	public String pwdTxtBx="//input[@id='password']";
	public String loginBtn="//button[text()='Log in']";
	
	public String TxtMsg = "//p[contains(text(),'Wrong login/password')]";
	public String errormsg="//p[contains (text(),'Wrong login/password')]";
	
}
