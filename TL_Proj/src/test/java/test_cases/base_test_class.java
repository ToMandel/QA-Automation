package test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class base_test_class {

	public static int rowCount;
	public static Sheet guru99Sheet;

	public static WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shir6\\Desktop\\chromedriver_win32\\chromedriver.exe");

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bored\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.tutorialsninja.com/demo/");
		driver.manage().window().setSize(new Dimension(1004, 724));

		return driver;
	}

	public static void readExcel(String filePath, String fileName, String sheetName) throws IOException {
		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		// Check condition if the file is xls file
		if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of HSSFWorkbook class
			guru99Workbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		guru99Sheet = guru99Workbook.getSheet(sheetName);
		// Find number of rows in excel file
		rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
	}

	public static int getRowcount() {
		return rowCount;
	}

	public static Sheet getsheet() {
		return guru99Sheet;
	}

}
