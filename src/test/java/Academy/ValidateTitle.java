package Academy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.ITestContext;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{
	
	private static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void before() {}
	
	@AfterTest
	public void after() {}
	
	@BeforeClass
	public void initialize(ITestContext context) throws IOException {
		log.info("Driver is initialized");
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		log.info("Navigated to homepage");
		context.setAttribute("WebDriver", driver);
	}
	
	@Test
	public void validateAppTitle() throws IOException {
		
		LandingPage l = new LandingPage(driver);
		//Comparing text from the browser with the actual value
		JOptionPane.showMessageDialog(null, "before test in title");
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("successfully validated text message");
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
