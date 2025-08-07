package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement gender;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirmPswd;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement registerBtn;
	
	@FindBy(xpath="//div[@class='result']") 
	WebElement successRegistrationmsg;
	
	public void setFirstName(String fname) {
		Firstname.sendKeys(fname);
	}
	public void setlastName(String lname) {
		Lastname.sendKeys(lname);
	}
	public void setEmail(String emailadr) {
		email.sendKeys(emailadr);
	}
	public void selectGender() {
		gender.click();
	}
	public void enterComp(String com) {
		company.sendKeys(com);
	}
	public void enterpswd(String epassword) {
		password.sendKeys(epassword);
	}
	public void confirmPswd(String epassword) {
		confirmPswd.sendKeys(epassword);
	}
	public void ClickRegister() {
		registerBtn.click();
	}
	
	public String checkConfirmation() {
		try {
			return(successRegistrationmsg.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
