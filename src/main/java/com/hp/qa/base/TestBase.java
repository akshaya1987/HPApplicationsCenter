package com.hp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.ecommerce.qa.utilities.TestUtilities;

public class TestBase {

	public static WebDriver driver;
	//FileInputStream ip;
	public static Properties prop;	

	public TestBase(){
		try {
			//System.out.println("I am super class constructor");
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/akshaya/Documents/workspace/EcommerceSiteAutomation/src/main/java/com/ecommerce/qa/configurations/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file is not available!!!");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String url = prop.getProperty("url");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "/Volumes/Development/Chromedriver/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Browser launched!!!");		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.get(url);
		}
	}
}
