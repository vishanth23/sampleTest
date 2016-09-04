package com.vmetry.ntl.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.apache.xpath.operations.Equals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntl.util.ReportGenerator;

public class Initializer {
	//archive initialization
	public static boolean isArchive=true;
	//reports initialization
public static ExtentReports report;
public static ExtentTest log;
//env prop declaration
	public static FileInputStream envfis=null;
	public static Properties envprop=null;
//locator prop declaration
	public static FileInputStream locatorfis=null;
	public static Properties locatorprop=null;
	
//driver declaration
	public static WebDriver wd;
	
	public static void intialize() throws IOException
	{
		ReportGenerator.archiveFile() ;
		report=new ExtentReports("D:\\DDTest\\Report\\tcreports.html");

		envfis=new FileInputStream(new File("D:\\DDTest\\src\\test\\java\\com\\vmetry\\ntl\\config\\env.properties"));
	   envprop=new Properties();
		envprop.load(envfis);
		
		
		locatorfis=new FileInputStream(new File("D:\\DDTest\\src\\test\\java\\com\\vmetry\\ntl\\config\\locator.properties"));
		   locatorprop=new Properties();
			locatorprop.load(locatorfis);
			
			if(envprop.getProperty("BROWSER").equals("firefox"))
			{
				 wd=new FirefoxDriver();
			}else if(envprop.getProperty("BROWSER").equals("chrome"))
			{
				wd=new ChromeDriver();
				//System.setProperties(WebDriver.chrome.driver);
			}
			wd.manage().window().maximize();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			
		}
	}

//content in properties file ll b initialized by intializer