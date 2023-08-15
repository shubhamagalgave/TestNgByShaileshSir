package CrossBrowserTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestScript {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	
	public void crossBrowser(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {	
			System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\Test\\ee\\chromedriver.exe");
			driver=new FirefoxDriver();
	    }
		else if (browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\IEDriverServerLatest.exe");
			driver=new InternetExplorerDriver();
		}
		else {
			throw  new Exception("Incorrect Browser");
		}
	}
  @Test(priority=1)
  public void TC1() throws InterruptedException
  {
	  driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e = driver.findElement(By.xpath("//a[@class=\"home-redirect redbus-logo\"]"));
		Thread.sleep(5000);
		boolean logo = e.isDisplayed();
		System.out.println(logo);
  }
  @AfterTest
  public void endTest()
  {
	  driver.quit();
  }
  
  //Shri Swami Samarth
	
}
