package PracticeScenario;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SynchronizationFluentwait {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Selenium");
		//driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys(Keys.ENTER);
		                           //or
		
		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys(Keys.RETURN);
		
		
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		WebElement el =mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()=\"Selenium\"]")));
		el.click();	
		
		driver.close();
	}

	}


