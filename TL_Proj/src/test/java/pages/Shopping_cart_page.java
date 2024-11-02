package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shopping_cart_page {

	WebDriver driver;
	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public Shopping_cart_page(WebDriver driver) {
		this.driver = driver;
	}

	//Locator for cart is empty text
	By empty =By.cssSelector("#content > p") ;
	// Locator for product remove
	By crtrmv = By.cssSelector(
			"#content > form > div > table > tbody > tr > td:nth-child(4) > div > span > button.btn.btn-danger");

	// Locator for checkout Button
	By chckoutBtn = By.cssSelector("#content > div.buttons.clearfix > div.pull-right > a");

	// Locator for Continue Button
	By ctnushop = By.cssSelector("#content > div.buttons.clearfix > div.pull-left > a");

	// Method to check if cart is empty
		public boolean isEmpty() {
			return driver.findElement(empty).getText().contentEquals("Your shopping cart is empty!");
		}
	//go to mane page
		public void goBack() {
			driver.findElement(By.cssSelector("#logo > h1 > a")).click();;
		}
	// Method to click checkout
	public void removeProduct() {
		driver.findElement(crtrmv).click();
	}

	// Method to click checkout
	public void clickCheckOut() {
		driver.findElement(chckoutBtn).click();
	}

	// Method to click continue shopping
	public void clickCotinueShop() {
		driver.findElement(ctnushop).click();
	}

}
