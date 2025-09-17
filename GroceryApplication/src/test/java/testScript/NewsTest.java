package testScript;

import java.io.IOException;

import org.apache.commons.compress.harmony.archive.internal.nls.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGbase;
import constant.Constants;
import constant.Message;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGbase{
	HomePage homePage;
	NewsPage newspage;
@Test(description="verify add news")
public void verifyaddnews() throws IOException {
	String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET );
	String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterusername(usernameValue).enterpassword(passwordValue);
	homePage=loginpage.signin(); 
	
	newspage=homePage.clicknewstile();
	newspage.clickaddnewsbutton().enternews("This is a sample news").clicksavenews();
	
	boolean isAlertDisplayed = newspage.isnewsadded();
	Assert.assertTrue(isAlertDisplayed, Message.NEWS_CREATION_ERROR);
}
@Test(description="verify reset news")
public void verifyresetnews() throws IOException {
	String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET);
	String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterusername(usernameValue).enterpassword(passwordValue);
	homePage=loginpage.signin();
	newspage=homePage.clicknewstile();
	
			newspage.clickresetbutton();
			String expectedUrl = "https://groceryapp.uniqassosiates.com/admin/list-news";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl, Message.NEWS_RESET_ERROR);

	
}

}
