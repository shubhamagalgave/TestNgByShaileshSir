package DemoPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
  @Test(dataProvider="setData1")
  public void f(String userName ,String passWord) {
	  System.setProperty("webdriver.chrome.driver", "E:\\Acceleration\\Automation Testing\\Workplace 4.9\\Test\\Executable\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		LoginSoucePage page=new LoginSoucePage(driver);
		PageFactory.initElements(driver, page);
		
	//	page.setUsername("standard_user");
	//	page.setPassword("secret_sauce");
	//	page.setButton();
		driver.close();
  }
		@DataProvider
		public Object[][] setData1() {
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
		
		

	  
	  
  
}
