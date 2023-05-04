package PracticeScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ValidateDropdown {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//select[@id=\"Skills\"]"));
			
		
		Select se = new Select(element);
		
		se.selectByIndex(2);
		
		WebElement ele =se.getFirstSelectedOption();
		String Text=  ele.getText();
		System.out.println(Text);
		
	   String actualText=  ele.getText();
	   
	   String expectedText=  "Select Skills";
	   
	   if(expectedText.equals(actualText))
	   {
	   System.out.println("Test valid");
	   }
	   else
	   {
		   System.out.println("Test invalid");
	   }
		
		driver.close();
		

	}

}
