package Academy;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base {

	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void before() {
	}

	@AfterTest
	public void after() {
	}

	@BeforeClass
	public void initialize(ITestContext context) throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		context.setAttribute("WebDriver", driver);
	}

	@Test
	public void validateAppNavigationBar() throws IOException {

		LandingPage l = new LandingPage(driver);
		// Comparing text from the browser with the actual value
		JOptionPane.showMessageDialog(null, "before test in navigation");
		AssertJUnit.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation bar successfully verified as displayed");
	}

	@AfterClass
	public void tearDown() {

		driver.close();
	}
}
