package PracticeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingPermissionPopup {

	public static void main(String[] args)  {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		
		//to handle location popup 
		option.addArguments("disable-geolocations");
		
		//to handle mic and camera popup
		option.addArguments("disable-mediastream");
		
		
	}

}
