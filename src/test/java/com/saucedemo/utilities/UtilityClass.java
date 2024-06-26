package com.saucedemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.saucedemo.testCases.BaseClass;

public class UtilityClass extends BaseClass{

	public static String readPFData(String key) throws IOException
	{
		FileInputStream file= new FileInputStream (System.getProperty("user.dir")+"//com.saucedemo.testData//config.properties");
		Properties prop=new Properties();
		prop.load(file);
		String value=prop.getProperty(key);
		return value;
	}
	public static void captureSS(int TCID) throws IOException
	{
		File dest=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src = new File(System.getProperty("user.dir")+"//Screenshots//TestCase_"+TCID+".jpg");
		FileHandler.copy(dest, src);
	}
}
