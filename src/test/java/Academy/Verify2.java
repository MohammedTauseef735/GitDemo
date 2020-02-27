package Academy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.ITestContext;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import resources.base;

public class Verify2 extends base{
	
	private static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void before() {}
	
	@AfterTest
	public void after() {}
	
	@BeforeClass
	public void initialize(ITestContext context) throws IOException {
		System.out.println("start of class Verify 2 Thread id is:" + Thread.currentThread().getId());
	}
	
	@Test
	public void validateAppTitle1() throws IOException {
		
		System.out.println("test of class Verify 2-1 ");
		System.out.println("After test-class. Thread id is: " + Thread.currentThread().getId());
	}
	
	@Test
	public void validateAppTitle2() throws IOException {
		
		System.out.println("test of class Verify 2-2");
		System.out.println("After test-class. Thread id is: " + Thread.currentThread().getId());
	}
	@Test
	public void validateAppTitle3() throws IOException {
		
		System.out.println("test of class Verify 2-3");
		System.out.println("After test-class. Thread id is: " + Thread.currentThread().getId());
	}
	@AfterClass
	public void tearDown() {
		System.out.println("end of class Verify 2");
		System.out.println("After test-class. Thread id is: " + Thread.currentThread().getId());
	}

}
