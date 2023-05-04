package PracticeScenario;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDownByJavascriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/all-countries.html");
		driver.manage().window().maximize();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scroll by using pixel
		//Thread.sleep(5000);
		//js.executeScript("window.scrollBy(0,1000)","");
		WebElement el=driver.findElement(By.xpath("//li[text()='Ethiopia']"));
		
		//scrolling page till we find element
	//	js.executeScript("arguments[0].scrollIntoView();",el);
		//Thread.sleep(5000);
		
		
		
		driver.close();
		
		
		

	}

}
