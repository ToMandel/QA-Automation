package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base_category_page {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public Base_category_page(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for add to compare button 1
	By addToComp1 = By.cssSelector(
			"#content > div:nth-child(3) > div:nth-child(1) > div > div:nth-child(2) > div.button-group > button:nth-child(3)");

	// Locator for add to compare button 2
	By addToComp2 = By.cssSelector(
			"#content > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div.button-group > button:nth-child(3)");

	// Locator for compare products button
	By comp = By.id("compare-total");

	// Locator for sort menu
	By sortMenu = By.id("input-sort");
	// Locator for currency
	By currencyMenu = By.cssSelector("#form-currency > div > button > span");

	public By setCurr(int num) {

		return By.cssSelector("#form-currency > div > ul > li:nth-child(" + num + ") > button");
	}

	public By setSort(int num) {
		return By.cssSelector("#input-sort > option:nth-child(" + num + ")");
	}

	// Method to click checkout
	public void clickSort(int n) {
		driver.findElement(setSort(n)).click();
	}

	public void clickCurr(int n) {
		driver.findElement(setCurr(n)).click();
	}

	// Method to click continue shopping
	public void clickCompare() {
		driver.findElement(addToComp1).click();
		driver.findElement(addToComp2).click();
		driver.findElement(comp).click();
	}

}
