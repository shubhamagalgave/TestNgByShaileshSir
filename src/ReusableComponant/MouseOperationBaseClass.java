package ReusableComponant;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOperationBaseClass 
{
	
	public static void mouseHovreCord(Actions action,List<WebElement> listElement) throws InterruptedException 
	{
		for (int i = 0; i < listElement.size(); i++) 
		{
		WebElement ele =listElement.get(i);
		action.moveToElement(ele).build().perform();
		System.out.println(ele.getText());
		
		Thread.sleep(5000);
		}
	}
	public static void mouseHover(Actions action,WebElement element) throws InterruptedException
	{
             Actions act = action.moveToElement(element);
             System.out.println(element.getText());
             act.build().perform(); 
             Thread.sleep(5000);
	}
	public static void rightClick(Actions action,WebElement element) throws InterruptedException
	{
		action.moveToElement(element).contextClick().build().perform();
		action.contextClick(element).build().perform();	
		System.out.println(element.getText());
		Thread.sleep(5000);
	}

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNG\\brouser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/");
		driver.manage().window().maximize();
		
		List<WebElement> listElement = driver.findElements(By.xpath("(//div[@id=\"menu\"])"));
		WebElement element =driver.findElement(By.xpath("//li[@id=\"menu-item-2822\"]"));
		Actions action = new Actions(driver);
		
		
		//mouseHovreCord(action,listElement);
		//mouseHover(action,element);
		rightClick(action,element);
		
		driver.close();
	}
}
