package ParllelTestingByShaileshSir;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParllelTestingWithHelpOfXML {
	@Test
	public void TestCase1() {
		System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://demo.actitime.com/login.do");
		 driver.manage().window().maximize();
		 System.out.println( driver.getTitle());
		 driver.close();

	}

	@Test
	public void TestCase2() {
		System.setProperty("webdriver.gecko.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\ApachePoi\\brouser\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// driver.get("https://demo.actitime.com/login.do");
		 driver.manage().window().maximize();
		System.out.println( driver.getTitle());
		 driver.close();

	}
}
