package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class base_prod_page<AddToCartBtn> implements Product_page {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public base_prod_page(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for title

	By ProdTitle = By.cssSelector("#content > div:nth-child(1) > div.col-sm-4 > h1");

	// Locator for description

	By ProdDesc = By.cssSelector("#content > div:nth-child(1) > div.col-sm-4 > ul:nth-child(3)");

	// Method for display title

	public void display_title() {
		System.out.println(driver.findElement(ProdTitle).getText());
	}

	// Method for display description

	public void display_desc() {
		System.out.println(driver.findElement(ProdDesc).getText());
	}

//	// method for click button add to cart

	public void click_add_to_cart(String YourProd) {
//		add_to_cart_opencart atcsd = new add_to_cart_opencart(driver);
//		atcsd.clickbutton(YourProd);

	}

}
