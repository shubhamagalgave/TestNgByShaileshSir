package DataProviderByShaileshSir;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {
	/**
	 * This test method declares that its data should be supplied by the Data
	 * Provider "getdata" is the function name which is passing the data Number of
	 * columns should match the number of input parameters
	 */

	@Test(dataProvider = "getData") // using dataProvider method name
	public void setData(String username, String password) {
		System.out.println("UserName is  " + username);
		System.out.println("PassWord is  " + password);
	}

	@Test(dataProvider = "testData") // using dataProvider parameter name
	public void testLoginOfVtiger(String browser, String username, String password) {
		System.setProperty(browser,	"E:\\Acceleration\\Automation Testing\\Workplace 4.9\\Test\\Executable\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"loginFormDiv\"]/form/div[3]/button")).click();
		driver.close();

	}

	@org.testng.annotations.DataProvider
	public Object[][] getData() {
		/**
		 * Rows - Number of times your test has to be repeated. Columns - Number of
		 * parameters in test data.
		 */

		Object[][] data = new Object[3][2];

		// 1st row
		data[0][0] = "admin";
		data[0][1] = "admin";

		// 2st row
		data[1][0] = "";
		data[1][1] = "";

		// 3st row
		data[2][0] = "guestuser3";
		data[2][1] = "Pass123";
		return data;
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] testData()
	{
		/**
		 * Rows - Number of times your test has to be repeated. Columns - Number of
		 * parameters in test data.
		 */

		Object[][] data = new Object[3][3];
		
		data[0][0]="webdriver.chrome.driver";
		data[0][1]="admin";
		data[0][2]="admin";
		
		data[1][0]="webdriver.chrome.driver";
		data[1][1]="";
		data[1][2]="";
		
		data[2][0]="webdriver.chrome.driver";
		data[2][1]="guestuser3";
		data[2][2]="Pass123";
		
		return data;
		
	}

}
