package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GuruTest {
	public static WebDriver driver;
	@Test
	public void guruLogin() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\driver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V1/index.php");
		Thread.sleep(3000);
	    guruLogin gl = new guruLogin(driver);
	    Thread.sleep(3000);
	    gl.setUserName("mngr495350");
	    Thread.sleep(3000);
	    gl.setPassWord("YvygUbE");
	    Thread.sleep(3000);
	    gl.clickOnLoginButton();
	    
	    String t=driver.getTitle();
	    System.out.println(t);
	    driver.close();
	
	
	
	}
	

}
