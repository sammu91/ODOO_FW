package com.oddocrm.webutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import com.google.common.io.Files;
import com.oddocrm.generic.Driver;
import com.oddocrm.generic.ExcelUtilities;
import com.oddocrm.generic.GenericLib;

public class OdooTestNGListener implements ISuiteListener, ITestListener, WebDriverEventListener
{
	public static int executionCount, passCount, failCount, skipCount=0;
	public long startTime;
	Logger log;

	public void onTestStart(ITestResult result) 
	{
		executionCount++;
		log.info(result.getName()+" script execution starts "+new Date());
	}

	public void onTestSuccess(ITestResult result) 
	{
		passCount++;
		log.info(result.getName()+" script is passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		failCount++;
		log.error(result.getName()+" script is failed");
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(GenericLib.dirPath+"\\screenshots\\"+
							  result.getName()+sdf.format(new Date())+".png");
		
		try 
		{
			Files.copy(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		log.info("Screenshot has been taken");
	}

	public void onTestSkipped(ITestResult result) 
	{
		skipCount++;
		log.info(result.getName()+" script is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

	 
	public void onStart(ISuite suite) 
	{
		File srcFile=new File(GenericLib.dirPath+"\\config.properties");
		File destFile=new File(GenericLib.dirPath+"\\allure-results\\environment.properties");
		try 
		{
			Files.copy(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		System.setProperty("ttccFilePath", GenericLib.dirPath+
				"\\reports\\logs\\Report"+sdf.format(new Date())+".log");
		System.setProperty("htmlFilePath", GenericLib.dirPath+
			"\\reports\\log4jhtml\\Report"+sdf.format(new Date())+".html");
		
		startTime=System.currentTimeMillis();
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(this.getClass());
		log.info("Suite execution starts "+new Date());
		
//		//when we provide parameters in test runner
//		List<XmlTest> tests = suite.getXmlSuite().getTests();
//		XmlTest test = tests.get(0);
//		Map<String, String> all = test.getAllParameters();
//		String browserName = all.get("browserName");
//		String headless = all.get("headless");
		
		String filepath=GenericLib.dirPath+"\\config.properties";
		
		WebDriver driver = BrowserFactory.launch(GenericLib.getValue(filepath, "browserName"), GenericLib.getValue(filepath, "headless"));
		Driver.setDriver(driver);
	}

	 
	public void onFinish(ISuite suite) 
	{
		long endTime=System.currentTimeMillis();
		double totalTime=(endTime-startTime)/1000;
		//Driver.getDriver().quit();
		log.info("Suite Execution ends "+new Date());
		log.info("Total execution time: "+totalTime+"seconds");
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		  String filepath = GenericLib.dirPath+
					   "\\reports\\excelreport\\Report"+sdf.format(new Date())+".xlsx";
		try
		{
			FileOutputStream fos=new FileOutputStream(new File(filepath));
			XSSFWorkbook wb = XSSFWorkbookFactory.createWorkbook();
			Sheet sh = wb.createSheet();
			ExcelUtilities eu=new ExcelUtilities();
			sh.createRow(0).createCell(0).setCellValue("Result Summary");
			sh.getRow(0).createCell(1).setCellValue("Execution Count");
		eu.writeData(sh, 1, "Total scripts Executed", passCount+failCount);
			eu.writeData(sh, 2, "Total scripts passed", passCount);
			eu.writeData(sh, 3, "Total scripts failed", failCount);
			eu.writeData(sh, 4, "Total scripts skipped", skipCount);
			
			wb.write(fos);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	 
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	 
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	 
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	 
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	 
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	 
	public void onException(Throwable t, WebDriver arg1) 
	{
		log.fatal(t.getMessage());
	}

}