package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.ReusableBaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends ReusableBaseClass{

	@Test(dataProvider="loginData", dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		try {
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
		if(exp.equalsIgnoreCase("valid")) {
			if(targetpage ==true) {
				map.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				map.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	
	}catch(Exception e) {
		Assert.fail();
	}
}
}
