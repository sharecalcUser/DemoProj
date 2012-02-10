import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class googleTest extends SeleneseTestBase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.qa1.copyright.com/");
		selenium.start();
		//WebDriver driver = new FirefoxDriver();
		//Selenium selenium = new WebDriverBackedSelenium(driver, "http://www.qa1.copyright.com/");
		//selenium.start();
	}
	

	@Test
	public void testUntitled() throws Exception {
		selenium.open("/");
		selenium.type("isbn-issn", "blood");
		selenium.click("titlesearchbutton");
		selenium.waitForPageToLoad("30000");
		selenium.click("//img[@alt='Permission Options']");
		selenium.waitForPageToLoad("30000");
		selenium.click("radio_122820321_2");
		selenium.click("pr_1");
		selenium.click("radio_122820321_2");
		selenium.waitForPageToLoad("30000");
		selenium.type("transactionItem.publicationYearOfUse", "2011");
		selenium.type("transactionItem.pageRange", "2-4");
		selenium.type("transactionItem.numberOfStudents", "5");
		selenium.click("submitButtonImage");
		selenium.click("submitButtonImage");
		selenium.waitForPageToLoad("30000");
		selenium.waitForPageToLoad("30000");
		selenium.waitForPageToLoad("30000");
		//hi This is sukanta
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
