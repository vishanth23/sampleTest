package com.vmetry.ntl.initializer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverFunctions extends Initializer {

	
	public static void loadURL()
    {
		wd.get(envprop.getProperty("URL"));
    }
	public static WebElement getwebelemnt(String xpath) throws InterruptedException
	{
	WebElement element=wd.findElement(By.xpath(locatorprop.getProperty(xpath)));
	highlightelement(element);
	return element;
	}
	
	
	public static void selectDropOption(String xpath,String data) throws InterruptedException
	{
		WebElement element = wd.findElement(By.xpath(locatorprop.getProperty(xpath)));
		highlightelement(element);
		Select s=new Select(element);
		s.selectByVisibleText(data);
	}
	public static void highlightelement(WebElement we) throws InterruptedException
	{
		((JavascriptExecutor)wd).executeScript("arguments[0].style.border='5px solid red'",we );
		Thread.sleep(700);
		((JavascriptExecutor)wd).executeScript("arguments[0].style.border=''",we );
		
	}
}
