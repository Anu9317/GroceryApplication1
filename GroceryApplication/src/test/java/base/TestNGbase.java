package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class TestNGbase {
	public WebDriver driver;
	@BeforeMethod
	public void initializeBrowser()
	{
	

	     driver=new FirefoxDriver();
		//driver=new ChromeDriver();
	 
	 driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	// driver.manage().window().minimize();
	 
	}
	@AfterMethod
	public void closeBrowser()
	{
	//	driver.close();
	//	driver.quit();
		
	}
	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtility screenShot=new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}

}
