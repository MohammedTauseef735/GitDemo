package resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		String projectPath = System.getProperty("user.dir");  //project path
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		// Use equals in this case instead of "==" else it will fail.
		if (browserName.equals("chrome")){
			//execute in chrome browser
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//Proxy proxy = new Proxy();
			//proxy.setHttpProxy("194.138.0.25" + ":" + "9400");
			//capabilities.setCapability("proxy", proxy);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=C:/Users/Z003K6TD/AppData/Local/Google/Chrome/User Data");
		    options.setExperimentalOption("useAutomationExtension", false);
		    options.addArguments("--disable-notifications");
		    options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		    options.addArguments("--disable-extensions");
		    options.addArguments("--start-maximized");
		    //options.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		else if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\Gecko_Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			//execute in internet explorer
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public void getScreenshot(String result, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}

}
