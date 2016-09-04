package temp;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.FileUtils;

public class ReportTest {
	ExtentReports report;
	ExtentTest log;
	WebDriver wd;
	

	@Test(priority=1)
	public  void validlogin(){
		report=new ExtentReports("D:\\DDTest\\Report\\tcreports.html");
       log =report.startTest("validlogin");
       wd=new FirefoxDriver();
       wd.get("https://www.google.co.in");
	}
	@Test(priority=2)
	public  void invalidlogin()
	{
	       log =report.startTest("invalidlogin");
	       wd.get("https://accounts.google.com");
	}
	@Test(priority=3)
	public  void partialvalidLogin()
	{
		log=report.startTest("partiallogin");
		wd.get("https://mvnrepository.com");
	}
	public String takescreenshot(String path) throws IOException
	{
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	File dst	= new File("D:\\DDTest\\Screenshot\\"+path+".jpg");
	org.apache.commons.io.FileUtils.copyFile(src, dst);
	return dst.toString();
	}
	@AfterMethod
	public void teardown(ITestResult it) throws IOException
	{
		if(it.isSuccess())
		{
			String path=takescreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "test pass");
		}else
		{
			String path=takescreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, "test fail");
		}
		report.endTest(log);
		report.flush();
	}
}
