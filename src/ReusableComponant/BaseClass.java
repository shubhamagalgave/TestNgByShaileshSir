package ReusableComponant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public void logIn() throws IOException {
	String path="E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\PropertyFileFolder\\FileRead.properties";
	FileInputStream file = new FileInputStream(path);
	Properties prop = new Properties();
	prop.load(file);
	
	System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
	WebDriver driver = new ChromeDriver();
	driver.get(prop.getProperty("appUrl"));
	}
	
	   public void logIn(WebDriver d) throws IOException {
		String path="E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\PropertyFileFolder\\FileRead.properties";
		FileInputStream file = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(file);
		
		//System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\latest.exe");
		//WebDriver driver = new ChromeDriver();
		d.get(prop.getProperty("appUrl"));
		}


}
