package com.hp.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hp.qa.base.TestBase;

public class Utilities extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 100;

	public Select selectDropdownItem(WebElement element){
		Select sel = new Select(element);
		return sel;
	}

	public void scrollWebPage(String xPixels, String yPixels){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" +xPixels+"," +yPixels+")");
	}

	public void clickOn(WebDriver driver, WebElement element, int time){
		new WebDriverWait(driver, time).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public JavascriptExecutor javascriptExecutor(WebDriver driver){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		return je;
	}

}
