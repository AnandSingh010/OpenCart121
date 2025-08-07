package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.ReusableBaseClass;

public class TC002_LoginTest extends ReusableBaseClass {

	@Test(groups={"sanity","master"})
	public void verify_login() {
		logger.info("****Starting TC002_LoginTest *****");
		
		try {
		//homepage
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		
		//loginpage
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPswd(p.getProperty("password"));
		lp.clickLoginbtn();
		
		//myaccountpage
		MyAccountPage map= new MyAccountPage(driver);
		boolean targetpage = map.isMyAccountPageExists();
		
		Assert.assertTrue(targetpage);
		}
		catch(Exception e) {
			Assert.fail();
			logger.info("***Finished TC002_LoginTest*****");
		}
	}
	
	
	
	
	
}
