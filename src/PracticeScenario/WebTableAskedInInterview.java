package PracticeScenario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableAskedInInterview {
	
	
	@Test
	public void table() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\driver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/sql/sql_select.asp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class=\"ws-table-all notranslate\"]//tr"));
		
		System.out.println(rows.size());
		
		List<WebElement> col=driver.findElements(By.xpath("//table[@class=\"ws-table-all notranslate\"]//tr"));
		
		System.out.println(col.size());
		
		String tt=driver.findElement(By.xpath("//table[@class=\"ws-table-all notranslate\"]//tr[5]/td[7]")).getText();
		System.out.println(tt);
		
		for (int i = 0; i <5; i++) {
			
			
			
			
			
			try {	
		for (int r =2; r <=rows.size(); r++)
		{
			for (int c =1; c <=col.size()+1; c++) 	
			{
				String list=driver.findElement(By.xpath("//table[@class=\"ws-table-all notranslate\"]//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(list);
				System.out.print("  ");
			}
			System.out.println();
		}
		Thread.sleep(10000);
		
		
		driver.navigate().refresh();
		}
		catch (Exception e) 
		{
			driver.navigate().refresh();
			for (int r =2; r <=rows.size(); r++)
			{
				for (int c =1; c <=col.size()+1; c++) 	
				{
					String list=driver.findElement(By.xpath("//table[@class=\"ws-table-all notranslate\"]//tr["+r+"]//td["+c+"]")).getText();
					System.out.print(list);
					System.out.print("  ");
				}
				System.out.println();
			}
		}
		
		System.out.println();
		
	
		
		
		
		
			
		}
	

}
}