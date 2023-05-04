package PracticeScenario;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassOperationPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(100);
		WebElement ele = driver.findElement(By.xpath("//div[text()=\"Travel\"]"));
		
		Actions act = new Actions(driver);
		
		//Mouse Hour operation
		/*******
		act.moveToElement(ele).build().perform();
		Actions a =act.moveToElement(ele);
		a.build().perform();
		Thread.sleep(3000);
		*/
		
		//right click operation
		/**********
		act.moveToElement(ele).contextClick().build().perform();
		Actions a = act.contextClick(ele);
		a.build().perform();
		*/
		
		//3 Double click operation
		
		/****
		WebElement e =driver.findElement(By.xpath("//input[@type=\"text\"]"));
		act.moveToElement(e).click().sendKeys("Shri Swami Samarth").doubleClick().build().perform();
		Actions a =act.moveToElement(e).click().sendKeys("Shri Swami Samarth").doubleClick();
		a.build().perform();
		act.doubleClick(ele).build().perform();
		*/
		
		
		//4 scroll down operation
	     /********
	     act.sendKeys(Keys.PAGE_DOWN).build().perform();
	     Thread.sleep(5000);
	     */
		//5scroll up operation
		/*****
		act.sendKeys(Keys.PAGE_UP).build().perform();
		*/
		
		//6 Drag and drop operation
		
		driver.navigate().to("https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
		driver.switchTo().frame(frame);
		
		WebElement source = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement target = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		
		act.dragAndDrop(source, target).build().perform();
		Thread.sleep(10000);
		driver.close();
		

	}

}
