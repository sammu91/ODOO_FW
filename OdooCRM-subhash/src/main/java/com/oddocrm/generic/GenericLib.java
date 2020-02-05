package com.oddocrm.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericLib 
{
	public static String dirPath=System.getProperty("user.dir");
	public static String osName=System.getProperty("os.name");
	
	public static String getValue(String filepath, String key)
	{
		String value=null;
		
		try
		{
			FileInputStream fis=new FileInputStream(new File(filepath));
			Properties prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
}
