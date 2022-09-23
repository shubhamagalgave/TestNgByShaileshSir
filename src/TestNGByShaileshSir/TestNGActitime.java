package TestNGByShaileshSir;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGActitime {
  @Test
  public void TestCase1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\Test\\ee\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.id("username"));
		Assert.assertTrue(username.isDisplayed());
		username.sendKeys("admin",Keys.TAB);
		
	//	WebElement pass = driver.findElement(By.name("pwd"));
	//	pass.sendKeys("manager",Keys.TAB);
	//	pass.sendKeys(Keys.ENTER);
	//	Thread.sleep(2000);
	//	System.out.println(driver.getTitle());
	//	Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		//Assert.assertEquals(driver.getTitle(), "actiTIME - Login", "Either logout is not done or login page title got changed");
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//WebElement logout = driver.findElement(By.id("logoutLink"));
		//wait.until(ExpectedConditions.elementToBeClickable(logout));
		
		//logout.click();
		
		
		WebElement checkBox  = driver.findElement(By.id("keepLoggedInCheckBox"));
		Assert.assertTrue(checkBox.isDisplayed());
		Assert.assertTrue(checkBox.isEnabled(),"Checkbox is not functional");
		Assert.assertFalse(checkBox.isSelected(),"Checkbox is by defualt selected");
		
		checkBox.click();
		Assert.assertTrue(checkBox.isSelected(),"Checkbox is not functional");
		driver.close();

		
		
		

	  
  }
}
