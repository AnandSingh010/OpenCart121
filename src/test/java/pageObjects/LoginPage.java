package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement paswd;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginBtn;
	
	public void enterEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void enterPswd(String pwd) {
		paswd.sendKeys(pwd);
	}
	
	public void clickLoginbtn() {
		loginBtn.click();
	}
	
}
