package PracticeScenario;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseTestutil {
	 //public static WebDriver driver;
	
	
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	WebDriver getDriver()
	{
		return driver.get();
	}

	
	@BeforeMethod(groups = {"Regression","Sanity","smoke"})
	@Parameters("browser")
	public void setUp(String browser)
	{
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\driver.exe");
			driver.set(new ChromeDriver());
			getDriver().manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
		    System.setProperty("webdriver.gecko.driver","E:\\Acceleration\\Automation Testing\\Workplace 4.9\\TestNGByShaileshSir\\Browser\\geckodriver.exe");
		    driver.set(new FirefoxDriver());
		    getDriver().manage().window().maximize();
		}
	}
	@AfterMethod(groups = {"Regression","Sanity","smoke"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void explicitWait(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void explicitWait(WebDriver driver,WebElement ele,int timeout)
	{
		WebDriverWait wait =new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void getScreenShots(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshot\\logo.png");
		FileUtils.copyFile(src, trg);
	}
	
	public static void drawBorder(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
		
	public static String getTitleByJs(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	public static void clickElementByJs(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void generateAlert(WebDriver driver,String message)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void refreshBrouserByJs(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollPageUp(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	public static void zoomPageByJs(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}

	public static void flash(WebElement element,WebDriver driver)
	{
		String bgColour=element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) 
		{
			ChangeColor("#000000", element, driver);
			ChangeColor(bgColour, element, driver);
		}
		
	}

	public static void ChangeColor(String color,WebElement element,WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element );
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

	public static void screenShot(String filename,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshot\\"+filename);//File trg = new File(".\\screenshot\\logo.png");
	    FileUtils.copyFile(src,trg);
		System.out.println("ScreenShot saved successfully");
	}
	public static ChromeOptions opt;
	public static void disableNotification()
	{
	    opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}


