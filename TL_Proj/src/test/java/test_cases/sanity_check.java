package test_cases;

import org.junit.Test;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import test_cases.base_test_class;
import pages.Register_page;
import pages.login_page;
import pages.main_page;
import pages.add_to_cart;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class sanity_check {
	private static final Logger logger = LogManager.getLogger(sanity_check.class);
	private WebDriver driver;
	public static int countRegSuccess = 0;
	public static int countLogInSuccess = 0;
	public static int countAddSuccess = 0;

	public base_test_class readObeject = new base_test_class();

	@After
	public void tearDown() {
		driver.quit();
	}

	@Before
	public void setUp() throws IOException {
		driver = base_test_class.initializeDriver();

	}

	@Test
	public void register() throws InterruptedException, IOException {
		readObeject.readExcel("C:\\Users\\shir6\\Downloads", "qa users sheet.xls", "Register");
		main_page MainPage = new main_page(driver);
		MainPage.clickMyAccount();
		Thread.sleep(1500);
		MainPage.clickRegister();
		Register_page registerPage = new Register_page(driver);
		int rowCount = base_test_class.getRowcount();
		Sheet thsSheet = base_test_class.getsheet();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = thsSheet.getRow(i);
			registerPage.enterFirst(row.getCell(0).getStringCellValue());
			Thread.sleep(1500);
			registerPage.enterLast(row.getCell(1).getStringCellValue());
			Thread.sleep(1500);
			registerPage.enterEmail(row.getCell(2).getStringCellValue());
			Thread.sleep(1500);
			registerPage.enterPhone(row.getCell(3).getStringCellValue());
			Thread.sleep(1500);
			registerPage.enterPassword(row.getCell(4).getStringCellValue());
			Thread.sleep(1500);
			registerPage.clickCotinue();
			if (driver.getCurrentUrl()
					.compareToIgnoreCase("http://tutorialsninja.com/demo/index.php?route=account/success") == 0) {
				countRegSuccess++;
			}
		}
	}

	@Test
	public void login() throws InterruptedException, IOException {
		readObeject.readExcel("C:\\Users\\shir6\\Downloads", "qa users sheet.xls", "Login");
		main_page MainPage = new main_page(driver);
		MainPage.clickMyAccount();
		Thread.sleep(1500);
		MainPage.clickLogin();
		login_page loginPage = new login_page(driver);
		int rowCount = base_test_class.getRowcount();
		Sheet thsSheet = base_test_class.getsheet();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = thsSheet.getRow(i);
			loginPage.enterEmail(row.getCell(0).getStringCellValue());
			Thread.sleep(1500);
			loginPage.enterPassword(row.getCell(1).getStringCellValue());
			Thread.sleep(1500);
			loginPage.clickLogin();
			Thread.sleep(1500);
			if (driver.getCurrentUrl()
					.compareToIgnoreCase("http://tutorialsninja.com/demo/index.php?route=account/account") == 0) {
				countLogInSuccess++;
			}
		}
	}

	@Test
	public void add_to_cart() throws InterruptedException {
		main_page MainPage = new main_page(driver);
		MainPage.clickProduct();
		Thread.sleep(1500);
		add_to_cart addToCart = new add_to_cart(driver);
		addToCart.clickbutton();
		Thread.sleep(1500);
		if (driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible"))
				.isDisplayed())
			countAddSuccess++;
	}

	public static void main(String args[]) {
		BasicConfigurator.configure();
		logger.info("Hello world");
		logger.info("we are in logger info mode");
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(sanity_check.class);
		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			// System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			// System.exit(0);
		}
		System.out.println(
				"register:" + countRegSuccess + " login:" + countLogInSuccess + " addToCart:" + countAddSuccess);
		if (countAddSuccess != 1 || countLogInSuccess != 1 || countRegSuccess != 1) {
			System.out.println("sanity check failed!");
		} else {
			System.out.println("Sanity check passed!");
		}
		System.exit(0);
	}
}