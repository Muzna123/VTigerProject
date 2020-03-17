package com.vtiger.genericlib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverCommonLib {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void moveMousePointer(WebElement element) {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}

	public void select(WebElement element, String option) {
		Select se1 = new Select(element);
		se1.selectByVisibleText(option);
	}

	public void select(WebElement element, int index) {
		Select se1 = new Select(element);
		se1.selectByIndex(index);
	}

	public void navigateToframe(WebElement element) {
		BaseClass.driver.switchTo().frame(element);
	}

	public void acceptAlert() {
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.accept();
	}

	public void rejectAlert() {
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}

	public String getAlertMsg() {
		Alert alt = BaseClass.driver.switchTo().alert();
		return alt.getText();
	}

	public void navigateToChildWindow() {
		Set<String> allSessionId = BaseClass.driver.getWindowHandles();
		Iterator<String> it = allSessionId.iterator();
		String mainID = it.next();
		String childID = it.next();
		BaseClass.driver.switchTo().window(childID);
	}

	public void navigateToParentWindow() {
		String parentId = BaseClass.driver.getWindowHandle();
		BaseClass.driver.switchTo().window(parentId);

	}

	public void waitAndCheck(WebElement element) {
		try {
			element.click();
		} catch (Throwable e) {
			System.out.println("wait......................");
		}
	}
}
