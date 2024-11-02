package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_page {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public login_page(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for email address field
	By email = By.id("input-email");

	// Locator for password field
	By pswd = By.id("input-password");

	// Locator for login button
	By loginBtn = By.cssSelector(".btn:nth-child(3)");

	// Method to enter email address
	public void enterEmail(String Email) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(Email);
	}

	// Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(pswd).clear();
		driver.findElement(pswd).sendKeys(pass);
	}

	// Method to click on Login button
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

}
