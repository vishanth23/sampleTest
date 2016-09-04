package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.vmetry.ntl.initializer.DriverFunctions;
import com.vmetry.ntl.initializer.Initializer;

public class Homepage extends Initializer {

	
	public static void enterUSername(String username) throws InterruptedException
	{
		DriverFunctions.getwebelemnt("HOMEPAGE_TYPE_NAME_XPATH").sendKeys(username);
	}
	
	
	public static void entermobile(String mobile) throws InterruptedException
	{
		DriverFunctions.getwebelemnt("HOMEPAGE_TYPE_MOBILE_XPATH").sendKeys(mobile);
	}
	
	public static void enterpikadd(String pikadd) throws InterruptedException
	{
		DriverFunctions.getwebelemnt("HOMEPAGE_TYPE_PIKADD_XPATH").sendKeys(pikadd);
	}
	public static void enterdrop(String dropadd) throws InterruptedException
	{
		DriverFunctions.getwebelemnt("HOMEPAGE_TYPE_DROPADD_XPATH").sendKeys(dropadd);
	}
	
	public static void selectBasic(String data) throws InterruptedException
	{
		DriverFunctions.selectDropOption("HOMEPAGE_TYPE_BASIC_XPATH", data);
	}
}
