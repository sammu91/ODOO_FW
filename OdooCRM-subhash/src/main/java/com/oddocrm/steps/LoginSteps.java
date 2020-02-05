package com.oddocrm.steps;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.oddocrm.generic.Driver;
import com.oddocrm.generic.SeleniumLib;
import com.oddocrm.pageobjects.BasePage;
import com.oddocrm.pageobjects.LoginPage;

import io.qameta.allure.Step;

public class LoginSteps 
{
	WebDriver driver;
	LoginPage lp;
	SeleniumLib slib;
	BasePage bp;
	
	public LoginSteps()
	{
		driver=Driver.getDriver();
		slib=new SeleniumLib();
		lp=new LoginPage();
		bp=new BasePage();
	}
	
	@Step("Perform login steps {username} and {password}")
	public void login(String username, String password)
	{
		driver.findElement(By.xpath(lp.emailTxtBx)).sendKeys(username);
		driver.findElement(By.xpath(lp.pwdTxtBx)).sendKeys(password);
		driver.findElement(By.xpath(lp.loginBtn)).click();
	}
	
	@Step("verifying valid login {emailID}")
	public void verifyValidLogin(String emailID)
	{
		boolean flag = driver.findElement(By.xpath(bp.crm)).isDisplayed();
		Assert.assertTrue(flag);
		String xp = MessageFormat.format(bp.emailID, emailID);
		boolean flag2 = driver.findElement(By.xpath(xp)).isDisplayed();
		Assert.assertTrue(flag2);
		Reporter.log("Valid Login is verified", true);
	}	
	

	@Step("Perform logout for {username}")
	public void logout(String emailID)
	{
		driver.findElement(By.xpath(MessageFormat.format(bp.emailID, emailID))).click();
		driver.findElement(By.xpath(bp.lgout)).click();
	}
	
	@Step("verifying invalid login {emailID}")
	public void verifyinValidLogin()
	{
		boolean flag = driver.findElement(By.xpath(lp.TxtMsg)).isDisplayed();
		Assert.assertTrue(flag);
		Reporter.log("Invalid Login is verified", true);
	}

	@Step("verifying InValid login")
	public void verifyInValidLogin()
	{
	 String ExpectedErrMsg="Wrong login/password";
	 String ActualErrMsg=driver.findElement(By.xpath(lp.errormsg)).getText();
	 Assert.assertEquals(ExpectedErrMsg, ActualErrMsg);
	 System.out.println("actual msg: "+ActualErrMsg);
	 Reporter.log("InValid Login is verified", true);
	 
	 // or
	 boolean flag=ActualErrMsg.contains(ExpectedErrMsg); 
	 Assert.assertTrue(flag);
	 Reporter.log("InValid Login error message is verified", true);
	}
}