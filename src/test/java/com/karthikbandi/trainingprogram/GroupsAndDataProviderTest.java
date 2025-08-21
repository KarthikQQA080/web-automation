package com.karthikbandi.trainingprogram;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupsAndDataProviderTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		/*
		 * // Setup ChromeOptions to disable password manager and popups ChromeOptions
		 * options = new ChromeOptions();
		 * 
		 * Map<String, Object> prefs = new HashMap<>();
		 * prefs.put("credentials_enable_service", false);
		 * prefs.put("profile.password_manager_enabled", false);
		 * prefs.put("profile.default_content_setting_values.notifications", 2);
		 * 
		 * options.setExperimentalOption("prefs", prefs);
		 * options.addArguments("--disable-notifications");
		 * options.addArguments("--disable-popup-blocking");
		 * options.addArguments("--disable-infobars");
		 * options.addArguments("--start-maximized");
		 * 
		 * //WebDriverManager.chromedriver().setup(); 
		 * driver = new ChromeDriver(options);
		 */
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	// Using DataProvider and passing the test data
	@DataProvider(name = "loginCreds")
	public Object[][] fetchLoginCreds() {
		return new Object[][] { 
			{ "standard_user", "secret_sauce" }, 
			{ "problem_user", "secret_sauce"},
			{ "performance_glitch_user", "secret_sauce"},
			{ "error_user", "secret_sauce"}};
	}

	@Test(groups = { "smoke", "regression"}, dataProvider = "loginCreds")
	public void validatingLoginCredsTest(String username, String password) throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		System.out.println("Validating with Username: " + username + " and Password: " + password);
		driver.findElement(By.id("user-name")).sendKeys(username + Keys.TAB + password + Keys.ENTER);
		Thread.sleep(5000);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		String ActualUrl = driver.getCurrentUrl();
		String ActualTitle = driver.getTitle();
		assertEquals(ActualUrl, "https://www.saucedemo.com/inventory.html", "Url matched!");
		assertEquals(ActualTitle, "Swag Labs", "Title matched!");		
	}
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}

	//@Test(groups = { "regression" })
	public void groupsTest() {
		System.out.println("Running regression test");
		// Add your test logic here
	}
}
