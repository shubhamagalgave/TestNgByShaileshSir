package Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PracticeScenario.BaseTestutil;

public class Login extends BaseTestutil{
	public static WebDriver driver;
	
	@Test(priority = 1, enabled = true)
	public void identifyLogoField() {
		System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\driver.exe");
		disableNotification();
	    driver = new ChromeDriver(opt);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e = driver.findElement(By.xpath("//a[@class=\"home-redirect redbus-logo\"]"));
		explicitWait(driver, e);
		boolean logo = e.isDisplayed();
		System.out.println(logo);
		Assert.assertFalse(true);
		driver.close();
	}
	

}
