package Academy;

import org.testng.annotations.Test;
import java.io.IOException;
import javax.swing.JOptionPane;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	@BeforeClass
	public void initialize() throws IOException {
		//JOptionPane.showMessageDialog(null, "before test in homepage");
		driver = initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName , String passWord , String text) throws IOException {
		driver.get("http://www.qaclickacademy.com/");
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(passWord);
	
		lp.getLogin().click();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		//Rows stand for different sets of data
		//Columns stand for how many values per each test
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@23.com";
		data[0][1] = "pass1";
		data[0][2] = "restricted user";
	
		data[1][0] = "restricteduser@45.com";
		data[1][1] = "pass2";
		data[1][2] = "non restricted user";
		
		return data;
		
		
	}
		
	@AfterClass
	public void tearDown() {
		driver.close();
		driver=null; 
	}

}
