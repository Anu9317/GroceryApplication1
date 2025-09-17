package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;
import utilities.WaitUtility;

public class LoginPage {
	    public WebDriver driver;
	    Pageutility pageutility=new Pageutility();
	    WaitUtility waitutility= new WaitUtility();
    public LoginPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@name='username']")WebElement usernamefield;
    public LoginPage enterusername(String usernameValue) {
    	pageutility.sendDataToElement(usernamefield, usernameValue);
    	return this;
		//usernamefield.sendKeys(usernameValue);
		
    }
    @FindBy(xpath="//input[@name='password']")WebElement passwordfield;
    public LoginPage enterpassword(String passwordValue) {
    	pageutility.sendDataToElement(passwordfield, passwordValue);
    	return this;
		//passwordfield.sendKeys(passwordValue);
    }
    @FindBy(xpath="//button[@type='submit']")WebElement signin;
    public HomePage signin() {
    	waitutility.waitUntilClickable(driver, signin);
    	pageutility.clickonelement(signin);
    	return new HomePage(driver);
		//signin.click();
		}
    }
    

