//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.lang.Object;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shareCalc {
	private WebDriver driver;
	public int xpath;
	public int count;
	public int rowCount;
	
	public String text;
	private String baseUrl;
	 
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();

		baseUrl = "http://dev1appin1.copyright.com:8980/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		
		
		driver.get(baseUrl + "/ShareCalcJ/login.jsp");
		driver.findElement(By.name("j_username")).clear();
		driver.findElement(By.name("j_username")).sendKeys("dsc-qa-specialist@copyright.com");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("123456");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//*[@id='MNU_MAIN']/span[2]")).click();
		driver.findElement(By.xpath("//div[@class='v-menubar-popup']/div[@class='popupContent']/div/span")).click();
		Thread.sleep(5000);
		
		//Column count
		//xpath = driver.findElements(By.xpath("//html/body/div[@id='ShareCalcJui-294445354']/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div/div[@id='TAB_MAIN']/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div[2]/div/div/div[1]/div[1]/div/table/tbody/tr/td")).size();
		xpath = driver.findElements(By.xpath("//div[@class='v-table']/div[@class='v-table-header-wrap']/div[@class='v-table-header']/div/table/tbody/tr/td")).size();
		System.out.println("Column count is :"+ xpath);
		//text = driver.findElement(By.xpath("//html/body/div[@id='ShareCalcJui-294445354']/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div/div[@id='TAB_MAIN']/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div[2]/div/div/div[1]/div[1]/div/table/tbody/tr/td/div[3]")).getText();
		text = driver.findElement(By.xpath("//div[@class='v-table']/div[@class='v-table-header-wrap']/div[@class='v-table-header']/div/table/tbody/tr/td/div[3]")).getText();
		//System.out.println("Column count is :"+ text);
		
		for(count=1;count<=xpath;count++)
		{
			System.out.println("Value of count is :"+count);
			//text = driver.findElement(By.xpath("//html/body/div[@id='ShareCalcJui-294445354']/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div/div[@id='TAB_MAIN']/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div[2]/div/div/div[1]/div[1]/div/table/tbody/tr/td["+count+"]/div[3]")).getText();
			text = driver.findElement(By.xpath("//div[@class='v-table']/div[@class='v-table-header-wrap']/div[@class='v-table-header']/div/table/tbody/tr/td["+count+"]/div[3]")).getText();
			System.out.println("Column count is :"+ text);
		}
		
		//row Count
		//rowCount = driver.findElements(By.xpath("//html/body/div[@id='ShareCalcJui-294445354']/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div/div[@id='TAB_MAIN']/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/table/tbody/tr")).size();
		rowCount = driver.findElements(By.xpath("//div[@class='v-table']/div[@class='v-table-body']/div/table[@class='v-table-table']/tbody/tr")).size();
		System.out.println("Number of rows is :"+ rowCount);
		
		
		for(count=1;count<=rowCount;count++)
		{
		
			System.out.println("Value of Indivieual Column");
			System.out.println("Value of row num is :"+count);
			text = driver.findElement(By.xpath("//div[@class='v-table']/div[@class='v-table-body']/div/table[@class='v-table-table']/tbody/tr["+count+"]/td[1]")).getText();
			System.out.println("Column count is :"+ text);
		
		}	
		
		//Dropdown values 		
		driver.findElement(By.xpath("//*[@id='SEL_PERIOD']/*[@class='v-filterselect-button']")).click();
		Thread.sleep(2000);
		
		rowCount = driver.findElements(By.xpath("//*[@id='VAADIN_COMBOBOX_OPTIONLIST']/*[@class='popupContent']/*[@class='v-filterselect-suggestmenu']/table/tbody/tr")).size();
		System.out.println("Drp option count is :"+ rowCount);
		System.out.println("Drp down value is :");
		String Period ="Corporate January - June 2012";
		//driver.findElement(By.xpath("//*[@id='VAADIN_COMBOBOX_OPTIONLIST']/*[@class='popupContent']/*[@class='v-filterselect-suggestmenu']/table/tbody/tr[2]/td/span")).click();
		driver.findElement(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[5]/td/span")).click();
		
		Thread.sleep(5000);
		
	/*	for (count=1;count<=rowCount;count++)
		{
			text = driver.findElement(By.xpath("//*[@id='VAADIN_COMBOBOX_OPTIONLIST']/*[@class='popupContent']/*[@class='v-filterselect-suggestmenu']/table/tbody/tr["+count+"]/td/span")).getText();
			System.out.println("Value is :"+text);			
			if(Period.trim() == text.trim() )
			{
				System.out.println("Match found");
				driver.findElement(By.xpath("//*[@id='VAADIN_COMBOBOX_OPTIONLIST']/*[@class='popupContent']/*[@class='v-filterselect-suggestmenu']/table/tbody/tr["+count+"]/td/span")).click();
				Thread.sleep(5000);
				break;
			}
			
		}		
		*/
		
		//String Period = "Corporate January - June 2012";
		
		
		//driver.findElement(By.xpath("//*[@id='SEL_PERIOD']")).selectByValue("Corporate January - June 2011");
		//selectByValue("2008")
		//text = driver.findElement(By.xpath("//div[@class='v-table']/div[@class='v-table-header-wrap']/div[@class='v-table-header']/div/table/tbody/tr/td/div[3]")).getText();
		
		Thread.sleep(2000);
		
		
		driver.quit();
		//driver.findElement(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td/span")).click();
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
