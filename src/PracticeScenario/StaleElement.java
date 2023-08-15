package PracticeScenario;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElement extends BaseTestutil
{

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(10000);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class=\"oxd-sidepanel-body\"]//li"));
		
		for(WebElement link:ele)
		{
			try
			{
			link.click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			
			}
			catch(Exception e1) 
			{
			driver.get(driver.getCurrentUrl());
			driver.navigate().refresh();
			Thread.sleep(3000);
			link.click();
			Thread.sleep(3000);
			}
		}
		driver.close();
		
	}
}
