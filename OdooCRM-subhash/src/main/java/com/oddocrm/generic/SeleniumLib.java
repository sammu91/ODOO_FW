package com.oddocrm.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumLib {
	WebDriver driver;
	
	
	public SeleniumLib(){
		driver=Driver.getDriver();
	}
	
	
	
////////	
	
	public void clearEnterDataTxtBx(String xpath, String input)
	{
		WebElement txtBx = driver.findElement(By.xpath(xpath));
		txtBx.clear();
		txtBx.sendKeys(input);
	}
	
	public void javascriptClick(WebElement ele)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", ele);
	}
	
	public void CheckElementPresent(int seconds, By xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
	}
/*******************************************************/	
	public void iWait(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
/*********************************************************/
	public void clickChkOrRadio(By xpath)
	{
		WebElement ele = driver.findElement(xpath);
		if (ele.isSelected()!=true) 
		{
			ele.click();
		}
		
	}

}
