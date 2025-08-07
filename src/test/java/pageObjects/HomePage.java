package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@class='ico-register']") 
	WebElement registerLink;
	
	@FindBy(xpath="//a[@class='ico-login']")//login link added
	WebElement login;
	
	public void clickRegister() {
		registerLink.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	
	
	
	
	
	
	
	
	
}
