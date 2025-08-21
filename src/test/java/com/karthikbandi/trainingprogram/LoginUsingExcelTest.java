package com.karthikbandi.trainingprogram;

import com.karthikbandi.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginUsingExcelTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@DataProvider(name = "excelLoginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/loginCreds.xlsx";
		// System.out.println(filePath);

		return ExcelUtils.readExcelData(filePath, "Sheet1");
	}

	@Test(dataProvider = "excelLoginData")
	public void loginTest(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		System.out.println("Tried login with: " + username + " / " + password);
	}
}
