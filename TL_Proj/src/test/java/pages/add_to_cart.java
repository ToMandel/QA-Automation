package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class add_to_cart {

	WebDriver driver;
	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public add_to_cart(WebDriver driver) {
		this.driver = driver;
	}

	By addBtn = By.id("button-cart");

	// Method to click on backpack button
	public void clickbutton() {
		driver.findElement(addBtn).click();
	}

}
