package test_cases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Shopping_cart_page;
import pages.add_to_cart;
import pages.main_page;

public class remove_from_cart_test {
	private static final Logger logger = LogManager.getLogger(sanity_check.class);
	private WebDriver driver;
	public static int countRemoveSuccess = 0;

	@After
	public void tearDown() {
		driver.quit();
	}

	@Before
	public void setUp() throws IOException {
		driver = base_test_class.initializeDriver();
	}

	@Test
	public void remove_() throws InterruptedException {
		main_page MainPage = new main_page(driver);
		Thread.sleep(1500);
		MainPage.clickShoppingCart();
		Thread.sleep(1500);
		Shopping_cart_page shopingCart = new Shopping_cart_page(driver);
		while (shopingCart.isEmpty()) {
			System.out.println("Cart is empty!");
			shopingCart.goBack();
			Thread.sleep(1500);
			addFromMain(MainPage);
		}
		Thread.sleep(1500);
		shopingCart.removeProduct();
		Thread.sleep(1500);
		if (shopingCart.isEmpty())
			countRemoveSuccess++;
	}

	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.info("Hello world");
		logger.info("we are in logger info mode");
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(remove_from_cart_test.class);
		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
		} else {
			System.out.println("Test finished successfully.");
		}
		if(countRemoveSuccess!=1) {
			System.out.println("Remove from cart test ---> FAILED");
		} else {
			System.out.println("Remove from cart test ---> SUCCESS");
		}
		System.exit(0);
	}

	public void addFromMain(main_page Main) throws InterruptedException {
		Main.clickAddToCart();
		Thread.sleep(1500);
		Main.clickShoppingCart();
	}

}
