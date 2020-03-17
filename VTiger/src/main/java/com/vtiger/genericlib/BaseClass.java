package com.vtiger.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage_POM;
import objectRepository.Login_Page;

public class BaseClass {
	public static FileLib f = new FileLib();
	public static WebDriver driver;
	public static WebdriverCommonLib wLib=new WebdriverCommonLib();

	@BeforeSuite
	public void connnectDB() {
		System.out.println("DB connection start.......");
	}

	@BeforeClass
	public void openBrowser() throws IOException {
		System.out.println("Launching  browser");
		System.getProperty("webdriver.gecko.driver", "../MavenApp1/src/test/resources/geckodriver.exe");
		String BROWSER=f.getPropertyKeyValue("browser");
		if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(f.getPropertyKeyValue("URL"));
	}

	@BeforeMethod
	public void login() throws IOException {
		System.out.println("login starts");
		String un = f.getPropertyKeyValue("Username");
		String pwd = f.getPropertyKeyValue("password");
		Login_Page l = PageFactory.initElements(driver, Login_Page.class);
		l.login_To_App(un, pwd);
	}

	@AfterMethod
	public void logout() {
		System.out.println("logout Done");
		HomePage_POM hp = PageFactory.initElements(driver, HomePage_POM.class);
		hp.logout_From_App();
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Browser close");
		driver.close();
	}

	@AfterSuite
	public void closeDB() {
		System.out.println("DB connection close....");
	}
}
