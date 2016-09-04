package com.vmetry.ntl.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntl.initializer.Initializer;

public class ScreenShotGenerator extends Initializer {

	public static String takescreenshot(String path) throws IOException
	{
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	File dst	= new File("D:\\DDTest\\Screenshot\\"+path+".jpg");
	org.apache.commons.io.FileUtils.copyFile(src, dst);
	return dst.toString();
	}
	public static void getScreenshot(ITestResult it) throws IOException
		{
	Object[]	data=it.getParameters();
		if(it.isSuccess())
		{
			String path=ScreenShotGenerator.takescreenshot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, data[0].toString()+" pass");
		}else
		{
			String path=ScreenShotGenerator.takescreenshot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, data[0].toString()+" fail");
		}
		report.endTest(log);
		report.flush();
	}
}
