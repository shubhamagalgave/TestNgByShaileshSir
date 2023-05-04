package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import PracticeScenario.BaseTestutil;

public class Listeners extends TestListenerAdapter{
	WebDriver driver;
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		ChromeOptions option = new ChromeOptions();// here we are exicuting browser on headless mode
		option.addArguments("--headless");//   it is not part of  screenshot capture
		driver=new ChromeDriver(option);// here we are initializing webdriver if we are not initializing then we will get nullpointer exception
	    
		
		String filename=result.getMethod().getMethodName()+".png";
		System.out.println(filename);
			
			try {
				BaseTestutil.screenShot(filename, driver);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			driver.close();
	}
	
	
	

}
