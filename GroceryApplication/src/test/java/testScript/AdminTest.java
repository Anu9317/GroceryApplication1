package testScript;

import java.io.IOException;

import org.apache.commons.compress.harmony.archive.internal.nls.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGbase;
import constant.Constants;
import constant.Message;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGbase{
@Test(description="verify add user")
 public void verifyadduser() throws IOException {
	String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
	String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterusername(usernameValue);
	loginpage.enterpassword(passwordValue);
	loginpage.signin();
	String expected="https://groceryapp.uniqassosiates.com/admin";
	String actual=driver.getCurrentUrl();
	Assert.assertEquals(actual,expected, Message.VALID_CREDENTIAL_ERROR);

	
	FakerUtility fakerUtility = new FakerUtility();
	String name=fakerUtility.createRandomUserName();
	String password=fakerUtility.createRandomPassword();
	String userTypevalue=ExcelUtility.getStringData(1, 2,Constants.ADMINSHEET);
	AdminPage adminpage=new AdminPage(driver);
    adminpage.clickadmintile();
    adminpage.clicknewbutton();
    adminpage.enterusername(usernameValue);
    adminpage.enterpassword(passwordValue);
    adminpage.selectusertype(userTypevalue);
    adminpage.clicksavebutton();
}
	
	@Test(description="verify search user")
	public void verifysearch() throws IOException{
		String usernameValue=ExcelUtility.getStringData(1, 0 ,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		Assert.assertEquals(actual,expected,Message.VALID_CREDENTIAL_ERROR);
		
		
		FakerUtility fakerUtility = new FakerUtility();
		String name=fakerUtility.createRandomUserName();
		String password=fakerUtility.createRandomPassword();
		String userTypevalue=ExcelUtility.getStringData(1, 2, Constants.LOGINSHEET);
		WebElement adminfile=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and@class='small-box-footer']"));
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickadmintile();
	    adminpage.clicksearchbutton();
	    adminpage.entersearchusername(name);
	    adminpage.selectsearchusertype(userTypevalue);
	    adminpage.clicksearchfield();
	}
	@Test(description="verify home page")
	public void verifyhomepage() throws IOException{
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		
		
		AdminPage adminpage = new AdminPage(driver);
	    adminpage.clicknewstile();
	    adminpage.clickhome();
	    Assert.assertEquals(actual,expected Message.HOMEPAGE_VERIFICATION_ERROR);
	}





	

}
