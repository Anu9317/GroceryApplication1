package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNGbase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import constant.Constants;
import constant.Message;

public class LoginTest extends TestNGbase{
	HomePage home;
	@Test(priority = 1,description = "verify login with Valid Credentials",retryAnalyzer = retry.Retry.class,groups = {"smoke"})
	public void verifyloginwithValidCredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1,0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue);
		home=loginpage.signin();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Message.VALID_CREDENTIAL_ERROR);
		
		
		}
	@Test(priority = 2,description="verify login with Valid username invalid password")
	public void verifyloginwithValidusernameinvalidpassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue).signin();
		String expected="https://groceryapp.uniqassosiates.com/admin/login";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,expected,Message.INVALID_PASSWORD_ERROR);
		
}
	@Test(priority = 3,description="verify login with inValid username valid password")
	public void verifyloginwithinValidusernamevalidpassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue).signin();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,expected,Message.INVALID_USERNAME_ERROR);
		
	}
	@Test(priority = 4,description="verify login with inValid Credentials",dataProvider = "loginProvider")
	public void verifyloginwithinValidCredentials(String usernameValue,String passwordValue) throws IOException {
		//String usernameValue=ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);
		//String passwordValue=ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue).signin();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,expected,Message.INVALID_CREDENTIAL_ERROR);
		
		
	
	
}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"user","password"},
			new Object[] {"username","pass"},
			
		};
	}
}
