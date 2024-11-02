package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout_page {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public Checkout_page(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for first name field
	By firstname = By.id("input-payment-firstname");

	// Locator for last name field
	By lastname = By.id("input-payment-lastname");

	// Locator for address field
	By address = By.id("input-payment-address-1");

	// Locator for city field
	By city = By.id("input-payment-city");

	// Locator for country field
	By country = By.id("input-payment-country");
	// Locator for country field
	By israel = By.cssSelector("#input-payment-country > option:nth-child(113)");

	// Locator for region field
	By region = By.id("input-payment-zone");
	// Locator for goshDan field
	By goshDan = By.cssSelector("#input-payment-zone > option:nth-child(12)");

	// Locator for Continue Button
	By ctnu = By.id("button-payment-address");

	// Method to enter first name
	public void enterFirst(String first) {
		driver.findElement(firstname).sendKeys(first);
	}

	// Method to enter last name
	public void enterLast(String last) {
		driver.findElement(lastname).sendKeys(last);
	}

	// Method to enter address
	public void enterAddress(String adrs) {
		driver.findElement(address).sendKeys(adrs);
	}

	// Method to enter city
	public void enterCity(String cty) {
		driver.findElement(city).sendKeys(cty);
	}

	public void enterCountry() {
		driver.findElement(country).click();
		driver.findElement(israel).click();
	}

	public void enterRegion() {
		driver.findElement(region).click();
		driver.findElement(goshDan).click();
	}
}
