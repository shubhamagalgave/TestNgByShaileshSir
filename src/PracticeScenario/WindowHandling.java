package PracticeScenario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("(//*[@class=\"oxd-icon orangehrm-sm-icon\"])[3]"));
		ele.click();
		
		String handle=driver.getWindowHandle();
		System.out.println("ParentWindowHandle"+handle);
		
		Set<String> allHandle=driver.getWindowHandles();
		
		
		/*****
		 * 1 Way to handle the window with help of iterator
		Iterator<String> itr = allHandle.iterator();
		String parentId=itr.next();
		String childId=itr.next();
		Thread.sleep(5000);
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		*/
		
		
		
		
		
	    /*****
		// * 2 Way to handle the window with help of for each loop
		for(String wind:allHandle)
		{
			if(handle.equals(wind))
			{
				driver.switchTo().window(wind);
				Thread.sleep(5000);
				System.out.println(driver.getTitle());
			}
		}
		
	
		//driver.quit();*/
		
		/*****
		 //* 3 Way to handle the window with help of for each loop
	    List<String> list=new ArrayList<String>(allHandle);
		String parentId=list.get(0);
		String childId=list.get(1);
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		driver.switchTo().window(childId);
		//driver.close();
		Thread.sleep(10000);
		System.out.println("child id   "+driver.getTitle());
		*/
		
		/*****
		//to switch specific window then use above technique
		for(String wind:allHandle)
		{
			String title=driver.switchTo().window(wind).getTitle();
			if(title.equals("OrangeHRM")||title.equals("Twitter"))
			{
				Thread.sleep(5000);
				driver.close();
			}
		}*/
	
		
		

	}

}
