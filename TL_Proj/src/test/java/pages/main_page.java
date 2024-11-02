package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class main_page {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public main_page(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for Drop Down of myAccount
	By myAccount = By.cssSelector(".list-inline .dropdown-toggle");

	// Locator for login from the myAccount menu
	By chooseLogin = By.linkText("Login");

	// Locator for Register from the myAccount menu
	By chooseRegister = By.linkText("Register");

	// Locator for wish-list
	By wshlst = By.id("wishlist-total");
	// Locator for checkoutBTN
	By chkout = By.cssSelector("#top-links > ul > li:nth-child(5) > a > span");

	// Locator for shopping cart
	By shpcrt = By.cssSelector("#top-links > ul > li:nth-child(4) > a > span");

	// Locator for product
	By product = By.cssSelector("#content > div.row > div:nth-child(2) > div > div.caption > h4 > a");
	// Locator for add
	By addToCart = By
			.cssSelector("#content > div.row > div:nth-child(2) > div > div.button-group > button:nth-child(1)");

	// Method to click on Login button
	public void clickMyAccount() {
		driver.findElement(myAccount).click();
	}

	public void clickLogin() {
		driver.findElement(chooseLogin).click();
	}

	public void clickRegister() {
		driver.findElement(chooseRegister).click();
	}

	public void clickShoppingCart() {
		driver.findElement(shpcrt).click();
	}

	public void clickProduct() {
		driver.findElement(product).click();
	}

	public void clickAddToCart() {
		driver.findElement(addToCart).click();
	}

	public void clickWishList() {
		driver.findElement(wshlst).click();
	}

	public void clickCheckOut() {
		driver.findElement(chkout).click();
	}

}
