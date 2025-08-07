package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.ReusableBaseClass;

public class TC001_AccountRegistrationTest extends ReusableBaseClass {
	
	@Test(groups= {"Regression","master"})
	public void verify_account_registration() {
		
		logger.info("****** Starting TC001_AccountRegistrationTest ******");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickRegister();
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		logger.info("Providing customer details....");
		
		arp.setFirstName(randomeString().toUpperCase());
		arp.setlastName(randomeString().toUpperCase());
		arp.setEmail(randomeString()+"@gmail.com");
		arp.enterComp("HCL");
		String epassword = randomAlphaNumeric();
		
		arp.enterpswd(epassword);
		arp.confirmPswd(epassword);
		arp.ClickRegister();
		
		logger.info("Validating expected message....");
		String cnfrmMSg = arp.checkConfirmation();
		if(cnfrmMSg.equals("Your registration completed")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed");
			logger.debug("Debug logs...");
			Assert.assertFalse(false);
		}
		
		}
		catch(Exception e){
			Assert.fail();
					
		}
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
	}
	
	
	
	
}
