package com.oddocrm.steps;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.oddocrm.generic.Driver;
import com.oddocrm.generic.SeleniumLib;
import com.oddocrm.pageobjects.MyPipelinePage;

public class ActivitySteps
{
	WebDriver driver;
	SeleniumLib slib;
	MyPipelinePage mpp;
	
	public ActivitySteps()
	{
		driver = Driver.getDriver();
		slib = new SeleniumLib();
		mpp=new MyPipelinePage();
	}
	
	public void ScheduleActivitywithOpp(String custName, String ActivityName)
	{
		driver.findElement(By.xpath(MessageFormat.format(mpp.ScheduleActivity, custName))).click();
		slib.javascriptClick(driver.findElement(By.xpath(mpp.ScheduleBtn)));
		slib.iWait(2);
		driver.findElement(By.xpath(mpp.Activity)).click();
		driver.findElement(By.xpath(MessageFormat.format(mpp.SelActivity, ActivityName))).click();
		driver.findElement(By.xpath(mpp.SchBtn)).click();
	}
	
	public void MarkDoneforOpp(String custName)
	{
		slib.iWait(3);
		driver.findElement(By.xpath(MessageFormat.format(mpp.ScheduleActivity, custName))).click();
		slib.iWait(3);
		slib.javascriptClick(driver.findElement(By.xpath(mpp.MarkasDone)));
		driver.findElement(By.xpath(mpp.done)).click();
	}
	
	public void moveOpp(String custName, String stageName)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(driver.findElement(By.xpath(MessageFormat.format(mpp.custName, custName)))).perform();
		Point pt = driver.findElement(By.xpath(MessageFormat.format(mpp.Stage, stageName))).getLocation();
		int x = pt.getX();
		int y = pt.getY();
		act.dragAndDropBy(driver.findElement(By.xpath(MessageFormat.format(mpp.custName, custName))), x, y).perform();
		act.release().perform();
	}
	
	public void verifyOppinQualified(String custName)
	{
		driver.findElement(By.xpath(MessageFormat.format(mpp.custName, custName))).click();
		slib.iWait(2);
		String actualstage="QUALIFIED";
		String expectedStage=driver.findElement(By.xpath(mpp.QualifiedStage)).getText();
		Assert.assertEquals(actualstage, expectedStage);
		Reporter.log("Stage in "+expectedStage+" is verified", true);
		String acttitle="Current state";
		String expectitle=driver.findElement(By.xpath(mpp.QualifiedStage)).getAttribute("title");
		boolean flag = acttitle.contains(expectitle);
		Assert.assertTrue(flag);
	}
	
	public void revenue(String custName, String revenueAmount)
	{
		driver.findElement(By.xpath(MessageFormat.format(mpp.custName, custName))).click();
		slib.iWait(2);
		slib.javascriptClick(driver.findElement(By.xpath(mpp.editBtn)));
		slib.iWait(2);
		driver.findElement(By.xpath(mpp.revenuetxtBx)).clear();
		driver.findElement(By.xpath(mpp.revenuetxtBx)).sendKeys(revenueAmount);
		driver.findElement(By.xpath(mpp.saveBtn)).click();
	}
	
	public void scheduleActifromInsideProp(String custName, String ActivityName)
	{
		driver.findElement(By.xpath(MessageFormat.format(mpp.custName, custName))).click();
		
		JavascriptExecutor je= (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(mpp.ScheduleActiInside)));
		slib.iWait(2);
		je.executeScript("arguments[0].click()", driver.findElement(By.xpath(mpp.ScheduleActiInside)));

		driver.findElement(By.xpath(mpp.Activity)).click();
		driver.findElement(By.xpath(MessageFormat.format(mpp.SelActivity, ActivityName))).click();
		driver.findElement(By.xpath(mpp.SchBtn)).click();
	}
}