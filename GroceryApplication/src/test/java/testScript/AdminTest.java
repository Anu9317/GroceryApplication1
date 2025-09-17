package testScript;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGbase;
import constant.Constants;
import constant.Message;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGbase {
	HomePage homePage;
	AdminPage adminpage;
	@Test(description = "Verify add user")
	public void verifyadduser() throws IOException {
        String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
        String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername(usernameValue).enterpassword(passwordValue);
		homePage=loginpage.signin();

        FakerUtility fakerUtility = new FakerUtility();
        String newUser = fakerUtility.createRandomUserName();
        String newPassword = fakerUtility.createRandomPassword();
        String userTypevalue = ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);

        
        adminpage=homePage.clickadmintile();
        adminpage.clicknewbutton().enterusername(usernameValue).enterpassword(newPassword).selectusertype(userTypevalue).clicksavebutton();
        
        Assert.assertTrue(adminpage.isAlertDisplayed(),Message.USER_CREATION_ERROR);
    }

    @Test(description = "Verify search user")
    public void verifysearch() throws IOException {
        String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
        String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername(usernameValue).enterpassword(passwordValue);
		homePage=loginpage.signin();
		
        FakerUtility fakerUtility = new FakerUtility();
        String newUser = fakerUtility.createRandomUserName();
        String newPassword = fakerUtility.createRandomPassword();
        String userTypevalue = ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);

        
        adminpage=homePage.clickadmintile();

        
        adminpage.clicksearchbutton().enterusername(usernameValue).enterpassword(newPassword).selectusertype(userTypevalue).clicksavebutton();
        
        Assert.assertTrue(adminpage.isAlertDisplayed(),Message.USER_SEARCH_ERROR);
        
        
    }

    @Test(description = "Verify home page")
    public void verifyhomepage() throws IOException {
        String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
        String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername(usernameValue).enterpassword(passwordValue);
		homePage=loginpage.signin();

        
        adminpage=homePage.clickadmintile();
        adminpage.clickhome();

        Assert.assertTrue(driver.getCurrentUrl().contains("home"),Message.HOMEPAGE_VERIFICATION_ERROR);
    }
}
