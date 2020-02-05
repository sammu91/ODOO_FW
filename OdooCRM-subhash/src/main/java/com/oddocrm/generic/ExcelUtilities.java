package com.oddocrm.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities 
{
	String filepath;
	String sheetname;
	
	public ExcelUtilities()   //to call writeData()
	{
		
	}
	
	public ExcelUtilities(String filepath)  //to call readData()
	{
		this.filepath=filepath;
	}
	
	//use for @DataProvider
		public ExcelUtilities(String filepath, String sheetname)
		{
			this.filepath=filepath;
			this.sheetname=sheetname;
		}
		
		public Sheet getMySheet()
		{
			Sheet sh=null;
			
			try
			{
				FileInputStream fis = new FileInputStream(new File(filepath));
				Workbook wb = WorkbookFactory.create(fis);
				sh = wb.getSheet(sheetname);
			}
			catch(EncryptedDocumentException | IOException e)
			{
				
			}
			
			return sh;
		}
		
		public int getRowCount()
		{
			int rowCount = getMySheet().getLastRowNum();
			return rowCount;
		}
		
		public int getCellCount()
		{
			int cellCount=getMySheet().getRow(0).getLastCellNum();
			return cellCount;
		}
		
		public String getExcelData(int row, int cell)
		{
			String value = getMySheet().getRow(row).getCell(cell).getStringCellValue();
			return value;
		}
	
	public String[] readData(String testcaseID, String sheetName)
	{
		String[] data=null;
		
		try
		{
			FileInputStream  fis=new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getLastRowNum();
			
			for (int i = 0; i <=rowCount; i++) 
			{
				Row rw = sh.getRow(i);
				
				if (rw.getCell(0).toString().equalsIgnoreCase(testcaseID)) 
				{
					int cellCount = rw.getLastCellNum();
					data=new String[cellCount];
					
					for (int j = 0; j < data.length; j++) 
					{
						Cell cl = rw.getCell(j);
						
						switch (cl.getCellType()) 
						{
						case STRING:
							data[j]=cl.getStringCellValue();
							break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cl)) 
							{
							SimpleDateFormat sdf=new SimpleDateFormat("");
								data[j]=sdf.format(cl.getDateCellValue());
							}
							else
							{
								long longValue=(long)cl.getNumericCellValue();
								data[j]=Long.toString(longValue);
							}
							break;
						case BOOLEAN:
							data[j]=Boolean.toString(cl.getBooleanCellValue());
							break;
						default:
							break;
						}
					}
					break;
				}	
			}
		}
		catch(EncryptedDocumentException | IOException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
/********************************************************************/
	
	public void writeData(Sheet sh, int row, String title, int data)
	{
		sh.createRow(row).createCell(0, CellType.STRING).setCellValue(title);
		sh.getRow(row).createCell(1, CellType.NUMERIC).setCellValue(data);
	}
	
	
	
	
	
	
	
	
}
