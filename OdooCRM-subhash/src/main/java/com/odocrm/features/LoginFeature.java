package com.odocrm.features;

import com.oddocrm.steps.LoginSteps;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class LoginFeature 
{
	LoginSteps ls;
	
	public LoginFeature()
	{
		ls=new LoginSteps();
	}
	@Epic("Login epic")
	@Feature("performing and validating valid login {username} and {password}")
	public void validLogin(String username, String password)
	{
		ls.login(username, password);
		ls.verifyValidLogin(username);
		//ls.logout(username);
	}

	@Epic("Invalid Login epic")
	@Feature("performing and validating invalid login {username} and {password}")
	public void invalidLogin(String username, String password)
	{
		ls.login(username, password);
		ls.verifyinValidLogin();
	}

	@Epic("Login epic")
	@Feature("performing and validating Invalid login {username} and {password}")
	public void InvalidLogin(String username, String password)
	{
		ls.login(username, password);
		ls.verifyInValidLogin();
	}
}