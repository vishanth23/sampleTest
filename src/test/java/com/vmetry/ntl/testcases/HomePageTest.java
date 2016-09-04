package com.vmetry.ntl.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Homepage;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntl.initializer.DriverFunctions;
import com.vmetry.ntl.initializer.Initializer;
import com.vmetry.ntl.util.ReportGenerator;
import com.vmetry.ntl.util.ScreenShotGenerator;

public class HomePageTest extends Initializer {

	@Test(dataProvider="HomePageTest")
	public void testhomepage(String testdata,String username,String mobilenumber,String pickadd,String dropadd,String basic) throws IOException, InterruptedException
	{
		
	       log =report.startTest(testdata);

		DriverFunctions.loadURL();
		Homepage.enterUSername("abc");
		Homepage.entermobile("1234");
		Homepage.enterpikadd("ADYAR");
		Homepage.enterdrop("ADYAR");
		Homepage.selectBasic("Sedan");
		
		
	}
	@BeforeClass()
	public void beforeclass() throws IOException 
	{
		intialize();
	}
	@DataProvider(name="HomePageTest")
	public static Object[][] gethomepagedata()
			{
		Object[][] data=new Object[3][6];
		//First data
		data[0][0]="HomePageTest_data1";
		data[0][1]="ab";
		data[0][2]="12345";
		data[0][3]="ADYAR";
		data[0][4]="ADYAR";
		data[0][5]="Sedan";
		//second data
		data[1][0]="HomePageTest_data2";

		data[1][1]="abc";
		data[1][2]="123456";
		data[1][3]="ADYAR";
		data[1][4]="ADYAR";
		data[1][5]="Sedan";
		//third data
		data[2][0]="HomePageTest_data3";

		data[2][1]="abc";
		data[2][2]="1234567";
		data[2][3]="ADYAR";
		data[2][4]="ADYAR";
		data[2][5]="Sedan";
				return data;
		
		
			}
	@AfterMethod()
	public void teardown(ITestResult it) throws IOException
	{
		ScreenShotGenerator.getScreenshot(it);
	}
}
