package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signin = By.xpath("//a[contains(@href,'sign_in')]");
	private By title = By.xpath("//div[@class='text-center']/h2"); //  or By.cssSelector(".text-center>h2");
	private By navbar = By.cssSelector(".navbar-right>li>a");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navbar);
	}
}
