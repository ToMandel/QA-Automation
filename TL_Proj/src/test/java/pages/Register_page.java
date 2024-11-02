package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_page {

	WebDriver driver;
	
	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public Register_page(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for first name field
	By firstname = By.id("input-firstname");

	// Locator for last name field
	By lastname = By.id("input-lastname");

	// Locator for email field
	By email = By.id("input-email");// Locator for first name field

	// Locator for telephone field
	By telephone = By.id("input-telephone");

	// Locator for password field
	By passwrd = By.id("input-password");

	// Locator for confirm password field
	By passwrdcomfirm = By.id("input-confirm");

	// Locator for agreements check-box
	By agreements = By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)");

	// Locator for Continue Button
	By ctnu = By.cssSelector("#content > form > div > div > input.btn.btn-primary");

	// Method to enter email address
	public void enterEmail(String Email) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(Email);
	}

	// Method to enter first name address
	public void enterFirst(String name) {
		driver.findElement(firstname).clear();
		driver.findElement(firstname).sendKeys(name);
	}

	// Method to enter last name address
	public void enterPhone(String number) {
		driver.findElement(telephone).clear();
		driver.findElement(telephone).sendKeys(number);
	}

	// Method to enter last name address
	public void enterLast(String surname) {
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys(surname);
	}

	// Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(passwrd).clear();
		driver.findElement(passwrd).sendKeys(pass);
		driver.findElement(passwrdcomfirm).clear();
		driver.findElement(passwrdcomfirm).sendKeys(pass);
	}

	public void clickCotinue() {
		if(!driver.findElement(agreements).isSelected())
			driver.findElement(agreements).click();
		driver.findElement(ctnu).click();

	}

}
