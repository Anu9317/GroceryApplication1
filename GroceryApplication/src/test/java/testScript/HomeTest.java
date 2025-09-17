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
		HomePage homePage;
		@Test(description ="Verify user logout")
		public void verifylogout() throws IOException {
			String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET );
			String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
			LoginPage loginpage=new LoginPage(driver);

			loginpage.enterusername(usernameValue).enterpassword(passwordValue);
			homePage=loginpage.signin(); 
			
			homePage.clicklogouticon();
			loginpage=homePage.clicklogout();
			String expected="https://groceryapp.uniqassosiates.com/admin/login";
			String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected,Message.LOGOUT_ERROR);

		}

	}
