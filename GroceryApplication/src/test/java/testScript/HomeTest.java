package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGbase;
import constant.Constants;
import constant.Message;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGbase {
	@Test(description="Verify user logout")
	public void verifyLogout() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		HomePage homepage=new HomePage(driver);
		homepage.clickLogouticon();
		homepage.clickLogout();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Message.LOGOUT_ERROR);
		
		
		
	}

}
