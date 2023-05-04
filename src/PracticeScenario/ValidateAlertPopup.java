package PracticeScenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateAlertPopup 
{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		/********
		// 1 Alert window handling with accept and getText() method
		driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		*/
		
		/*******
		// 1 Alert window handling with accept, Dissmiss and getText() method
		driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();//to click on accept button
		System.out.println(text);
		Thread.sleep(3000);
		//alert.accept();  //to click on accept button
		//alert.dismiss(); //to click on cancel button
		*/
		
		/******
		// 1 Alert window handling with accept, Sendkeys and getText() method
		driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]")).click();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Shri Swami Samarth");
		Thread.sleep(3000);
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		*/
		Thread.sleep(3000);
		driver.close();
		

	}

}
