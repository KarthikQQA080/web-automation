package com.karthikbandi.trainingprogram;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindowsAndAlertsTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void multipleWindowHandlingTest() {
		driver.get("https://the-internet.herokuapp.com/windows");

		String parentWindow = driver.getWindowHandle();
		//System.out.println(parentWindow);
		
		// Click the link that opens a new window
		driver.findElement(By.linkText("Click Here")).click();

		// Switch to new window
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
			//System.out.println(handle);
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}

		System.out.println("Title of child window: " + driver.getTitle());

		driver.close(); // Close new window
		driver.switchTo().window(parentWindow); // Switch back
	}
	
	@Test
	public void alertTest() {
		// Navigate to alert page
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// Handle alert pop up
		// Click on JS Alert
		WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		alertButton.click();

		Alert alertPopUp = driver.switchTo().alert();
		System.out.println("Alert text: " + alertPopUp.getText());
		alertPopUp.accept();
		
		// Handle confirmation pop up
		// Click on JS Confirmation
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		
		Alert confirmPopUp = driver.switchTo().alert();
		System.out.println("Confirmation pop up text: " + confirmPopUp.getText());
		confirmPopUp.dismiss();
		//confirmPopUp.accept();
		
		// Handle entering prompt pop up
		// Click on JS prompt
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		
		Alert promptPopUp = driver.switchTo().alert();
		System.out.println("Prompt pop up text: " + promptPopUp.getText());
		promptPopUp.sendKeys("Hello");
		promptPopUp.accept();
		//promptPopUp.dismiss();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
