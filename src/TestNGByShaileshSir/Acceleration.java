package TestNGByShaileshSir;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Acceleration {
	@Test(priority=0,enabled=false)
	public void Tc1()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\driver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		System.out.println(title);
		if (title.contains("Online Shopping Site for Mobile")) 
		{
			System.out.println("Home page Validate successfully");
		}
		else {
			System.out.println("Home page not Validate");
		}
	}
	@Test(priority=1,enabled=true)
	public void TC2()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\driver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		System.out.println(title);
		if (title.equals("Today's Cricket Match | Cricket Update | Cricket News | ESPNcricinfo")) 
		{
			System.out.println("validate");
		}
		else {
			System.out.println("not validate");
		}
	}
	
}
