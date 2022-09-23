package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OrangeHrmLoginPageTest {
  @Test
  public void verifyLogin() {
	  System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\Test\\Executable\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  OrangeHrmLoginPage page = new OrangeHrmLoginPage(driver);
	  PageFactory.initElements(driver, page);   //initialization of page object with help of page factory
	  //here page is object of page object s
	  
	  page.setUserName("Admin");
	  page.setPassWord("admin123");
	  page.clickLoginButton();
	  
	  
	  driver.close();
	   
  }
  
 
  
  
  
  
  
}
