package PracticeScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

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
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement el =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()=\"Selenium\"]")));
		
		BaseTestutil.explicitWait(driver, el,1);//created reusable method
		BaseTestutil.explicitWait(driver, el);//created reusable method  --->>Here we utilize method overloading concept
		el.click();		
	}
}
