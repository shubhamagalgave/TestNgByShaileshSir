package PracticeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo0707 {

	public static WebDriver driver;
	public static void main(String[] args){
		System.setProperty("webdriver.gecko.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\geckodriver.exe");
		    driver = new FirefoxDriver();
			driver.get("https://demo.guru99.com/");
			driver.manage().window().maximize();
			driver.close();
			
		
	}

}
