package Parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
  @Parameters({"browser"})
  @Test(priority=1,enabled=false)
  public void TestCaseone(String browser) {
	  System.out.println("browser pass is "+browser);
  }
  
  @Parameters({"username","password"})
  @Test(priority=2,enabled=false)
  public void TestCaseTwo(String username,String password) {
	  System.out.println("username pass is "+username);
	  System.out.println("password pass is "+password);
  }
  
  @Parameters({"browser","username","password"})
  @Test(priority=3,enabled=false)
  public void TestCasethree(String browser,String username,String password)
  {
	  System.out.println("browser pass is "+browser);
	  System.out.println("username pass is "+username);
	  System.out.println("password pass is "+password);
  
  }
  @Parameters({"browser","username","password"})
  @Test(priority=4,enabled=true)
  public void TestCaseFour(String browser ,String username,String password)
  {
	  System.setProperty(browser, "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\Test\\Executable\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://demo.vtiger.com/vtigercrm/index.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
	  
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id=\"loginFormDiv\"]/form/div[3]/button")).click();
	  driver.close();
	  
	  
  }
  /**
   * 	@Parameters({"browser", "username", "password" })
	@Test(priority=4)
	public void testLoginOfVtiger(String browser,String username, String password) {
		setUp(browser, "https://demo.vtiger.com/vtigercrm/index.php");
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password,Keys.ENTER);
			cleanUp();
   */ 
}
