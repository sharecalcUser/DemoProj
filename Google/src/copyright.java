//package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class copyright {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.ps1.copyright.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("isbn-issn")).clear();
		driver.findElement(By.id("isbn-issn")).sendKeys("blood");
		driver.findElement(By.id("titlesearchbutton")).click();
		driver.findElement(By.cssSelector("img.floatright")).click();
		driver.findElement(By.id("radio_122820321_2")).click();
		driver.findElement(By.id("pr_1")).click();
		driver.findElement(By.id("radio_122820321_2")).click();
		driver.findElement(By.name("transactionItem.publicationYearOfUse")).clear();
		driver.findElement(By.name("transactionItem.publicationYearOfUse")).sendKeys("2011");
		driver.findElement(By.name("transactionItem.pageRange")).clear();
		driver.findElement(By.name("transactionItem.pageRange")).sendKeys("2-9");
		driver.findElement(By.name("transactionItem.numberOfStudents")).clear();
		driver.findElement(By.name("transactionItem.numberOfStudents")).sendKeys("5");
		driver.findElement(By.id("submitButtonImage")).click();
		driver.findElement(By.id("submitButtonImage")).click();
		driver.findElement(By.name("courseDetails.schoolCollege")).clear();
		driver.findElement(By.name("courseDetails.schoolCollege")).sendKeys("Univ");
		driver.findElement(By.cssSelector("img.ui-datepicker-trigger")).click();
		driver.findElement(By.linkText("17")).click();
		driver.findElement(By.name("courseDetails.courseName")).clear();
		driver.findElement(By.name("courseDetails.courseName")).sendKeys("couse");
		driver.findElement(By.cssSelector("img[alt=\"Add to Cart\"]")).click();
		driver.findElement(By.id("999")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
