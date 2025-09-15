package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;

public class LoginPage {
	    public WebDriver driver;
	    Pageutility pageutility=new Pageutility();
    public LoginPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@name='username']")WebElement usernamefield;
    public void enterusername(String usernameValue) {
    	pageutility.sendDataToElement(usernamefield, usernameValue);
		//usernamefield.sendKeys(usernameValue);
		
    }
    @FindBy(xpath="//input[@name='password']")WebElement passwordfield;
    public void enterpassword(String passwordValue) {
    	pageutility.sendDataToElement(passwordfield, passwordValue);
		//passwordfield.sendKeys(passwordValue);
    }
    @FindBy(xpath="//button[@type='submit']")WebElement signin;
    public void signin() {
    	pageutility.clickonelement(signin);
		//signin.click();
		}
    }
    

