package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wishlist_page {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public Wishlist_page(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for product remove
	By wshrmv = By.cssSelector("#content > div.table-responsive > table > tbody > tr > td:nth-child(6) > a.");

	// Locator for checkout Button
	By addCart = By.cssSelector("#content > div.table-responsive > table > tbody > tr > td:nth-child(6) > button");

	// Locator for Continue Button
	By homePage = By.cssSelector("#logo > h1 > a");

	// Method to click checkout
	public void removeProduct() {
		driver.findElement(wshrmv).click();
	}

	// Method to click checkout
	public void clickAddCart() {
		driver.findElement(addCart).click();
	}

	// Method to click continue shopping
	public void clickHomePage() {
		driver.findElement(homePage).click();
	}

}
