package PracticeScenario;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import POM.LoginPage23;
import Page1.GoogleSearchBoxSuggetion;
import ReusableComponant.BaseClass;

public class TestDemo extends BaseTestutil {
	public WebDriver driver=getDriver();
	
	
	@Test(priority = 0, enabled = false)
	public void identifyLogoField() {
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e = driver.findElement(By.xpath("//a[@class=\"home-redirect redbus-logo\"]"));
		//explicitWait(driver, e);
		boolean logo = e.isDisplayed();
		System.out.println(logo);
		driver.close();
	}

	@Test(priority = 1, enabled = false)
	public void reusableLoginMethodUse() throws IOException {
		BaseClass bt = new BaseClass();
		bt.logIn(driver);
	}

	@Test(priority = 2, enabled = false)
	public void validateText() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("//h5[text()=\"Login\"]"));
		String text = ele.getText();
		System.out.println(text);
		String expectedText = "Login";

		if (text.equals(expectedText)) {
			System.out.println("Test valid");
		} else {
			System.out.println("Test invalid");
		}
	}

	@Test(priority = 3, enabled = false)
	public void allNavigationCommand() {
		driver.get("https://www.amazon.in/");
		// or driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.snapdeal.com/");
		driver.manage().window().maximize();

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();

	}

	@Test(priority = 4, enabled = false)
	public void allConditionalMethod() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]"));

		System.out.println(searchBox.isEnabled());
		System.out.println(searchBox.isDisplayed());

		// isSelected() - radio buttons,check boxes,dropdowns
		WebElement male = driver.findElement(By.xpath("//input[@id=\"gender-male\"]"));
		WebElement female = driver.findElement(By.xpath("//input[@id=\"gender-female\"]"));

		System.out.println("male radio button is selected :" + male.isSelected());
		System.out.println("female radio button is selected :" + female.isSelected());

		male.click();// male radio button is selected
		System.out.println("male radio button is selected :" + male.isSelected());
		System.out.println("female radio button is selected :" + female.isSelected());

		female.click();// female radio button is selected
		System.out.println("male radio button is selected :" + male.isSelected());
		System.out.println("female radio button is selected :" + female.isSelected());

		driver.close();

	}

	@Test(priority = 4, enabled = false)
	public void ScrollDownByJavaScriptExecutor() {
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.close();

	}

	@Test(enabled = false)
	public void Assertion() {
		// HardAssert
		AssertJUnit.assertTrue(true);// passed
		AssertJUnit.assertEquals("shubham", "Shubham");// false-failed
		System.out.println("TC Passed");
	}

	@Test(enabled = false)
	public void SoftAssertion() {
		// SoftAssert
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertTrue(true);
		AssertJUnit.assertEquals("shubham", "shubham");
		AssertJUnit.assertEquals("selenium", "Selenium");
		System.out.println("TC Passed");
		softAssert.assertAll();
	}

	@Test(priority = 5, enabled = false)
	public void HardAssertUse() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));

		AssertJUnit.assertTrue(username.isDisplayed());
		username.sendKeys("Admin");

		AssertJUnit.assertTrue(password.isDisplayed());
		username.sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		AssertJUnit.assertEquals("OrangeHRM", driver.getTitle());
		
	}

	@Test(priority = 6, enabled = false)
	public void checkBoxScenarioQuestion() {
		driver.get("https://www.amazon.in/s?k=MOBI&crid=37TRUFPBR7GYR&sprefix=mobi%2Caps%2C374&ref=nb_sb_noss_2");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> e = driver.findElements(By.xpath("//ul[@aria-labelledby=\"p_89-title\"]//li[contains(@id,'p_89')]"));
		/***
		  for(WebElement ele:e) { System.out.println(e.size());
		  System.out.println(ele.getText()); }
		 
		*/
		for (int i = 1; i < e.size(); i++) {
			WebElement e11 = e.get(i);
			e11.click();
			System.out.println(e11.getText());

		}
		
	}

	@Test(priority = 7, enabled = false)
	public void useOfJavaScriptExecutorUtilDrawBorder() throws IOException, InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]"));
		// drow border along with element
		// drawBorder(driver, element);
		// get title of webpage
		// getTitleByJs(driver);
		// getScreenShots(driver);
		// WebElement element1
		// =driver.findElement(By.xpath("//div[@class=\"orangehrm-login-forgot\"]"));
		// to click on element by js
		// clickElementByJs(driver, element1);

		// refresh the page
		refreshBrouserByJs(driver);
		// scroll down the page
		scrollPageDown(driver);
		// scroll up the page
		scrollPageUp(driver);
		// zoom the page
		// zoomPageByJs(driver);
		// Thread.sleep(4000);
		// flash
		WebElement e12 = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]"));
		flash(e12, driver);
		Thread.sleep(5000);
		try {// StaleElementReference handled
			flash(element, driver);
		} catch (StaleElementReferenceException e) {
			element = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]"));
			flash(element, driver);
		}
		driver.close();
	}

	@Test(priority = 7, enabled = false)
	public void useOfJavaScriptErUtilDrawBorder() throws InterruptedException {
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Shree Swami Samarth");

		List<WebElement> list = driver.findElements(By.xpath("//li[@class=\"sbct\"]//div[@class=\"wM6W7d\"]//span"));
		System.out.println(list.size());
		for (WebElement e : list) {
			try {
				System.out.println(e.getText());
				Thread.sleep(3000);
			} catch (Exception e1) {

				driver.get(driver.getCurrentUrl());
				System.out.println(e.getText());
			}
		}
	}

	@Test(priority = 8, enabled = false, dataProvider = "getData")
	public void writingTheScriptInPOM(String username, String password) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		LoginPage23 page = new LoginPage23(driver);

		page.userName(username);
		page.passWord(password);
		page.click();

		System.out.println(driver.getTitle());
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = new Object[3][2];

		data[0][0] = "";
		data[0][1] = "";

		data[1][0] = "admin";
		data[1][1] = "admin";

		data[2][0] = "Admin";
		data[2][1] = "admin123";
		return data;
	}

	@Test(priority = 9, enabled = false)
	public void handleCheckboxByPawanSir() throws InterruptedException {
		driver.get("https://www.amazon.in/s?k=mobile&crid=3DAM5OD46B6ML&sprefix=mobile%2Caps%2C567&ref=nb_sb_noss_1");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.xpath("//li[contains(@id,'p_n_feature_eight_browse-bin/856111')]"));
		Thread.sleep(5000);
		System.out.println(list.size());
		/*****
		 * for(WebElement e:list) 
		 * { /* WebDriverWait w = new WebDriverWait(driver, 10);
		 * w.until(ExpectedConditions.elementToBeClickable(e));
		 *  Wait wait= new FluentWait(driver) .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(ElementClickInterceptedException.class);
		 * wait.until(ExpectedConditions.elementToBeClickable(e)); 
		 * try { e.click();
		 * driver.navigate().back(); 
		 * Thread.sleep(6000);
		 *  }catch(StaleElementReferenceException e111111) 
		 * { driver.navigate().refresh();
		 * driver.get(driver.getCurrentUrl());
		 *  Thread.sleep(3000);
		 *   e.click();
		 *    }
		 *****/
		// To select specific check box//E.g 7 check boxes are there and we have to
		// select last check box
		int count = list.size();/****
								 * for(int i=count-6;i<list.size();i++) { Thread.sleep(5000); String
								 * text=list.get(i).getText(); System.out.println(text); list.get(i).click(); }
								 */
		// Select Multiple Check box by choice
		for (WebElement e : list) {
			String t = e.getAttribute("aria-label");
			if (t.equals("64 GB") || t.equals("128 GB")) {

				e.click();

			}

		}
		Thread.sleep(6000);

		// choose first two checkbox
		for (int i = 0; i < count; i++) {
			if (i < 3) {
				list.get(i).click();
			}
		}
	}

	@Test(priority = 10, enabled = false)
	public void handlingAutoSuggetionPopups() throws InterruptedException {
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("pune");
		List<WebElement> listEle = driver.findElements(By.xpath("//ul[@class=\"G43f7e\"]//li"));
		int size = listEle.size();
		// listEle.get(size-2).click();//to click on perticular link

		/*
		 * for (int i = 0; i < listEle.size(); i++) { if(i<2) //to click on first link {
		 * listEle.get(i).click(); } }
		 */
		// to click on link textwise
		for (WebElement li : listEle) {
			if (li.getText().equals("pune")) {
				li.click();
			}
		}
		driver.close();
	}

	@Test(priority = 11, enabled = false)
	public void handlingAutoSuggetionPopupwithPOM() throws InterruptedException {
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		GoogleSearchBoxSuggetion ss = new GoogleSearchBoxSuggetion(driver);
		String lo = "pune";
		ss.searchBox(lo);
		ss.allLinkinkName();
		Thread.sleep(5000);
		driver.close();
	}

	@Test(priority = 12, enabled = false)
	public void LinkTextandPartialLinkText() throws InterruptedException {
		driver.get("https://www.att.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 // LinkText and Partial LinkText
		 driver.findElement(By.linkText("Internet")).click();
		 driver.findElement(By.partialLinkText("Inte")).click();
		 System.out.println(driver.getTitle());

	}

	@Test(priority = 13, enabled = false)
	public void allTheLinkOnWebApplication() {
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) {

			// System.out.println(links.get(i).getText());
			WebElement element = links.get(i);
			String url = element.getAttribute("href");

			try {
				URL link = new URL(url);

				HttpURLConnection http = (HttpURLConnection) link.openConnection();

				http.connect();

				int responseCode = http.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(i+" "+"link is btoken " + url);
				} else {
					System.out.println(i+" "+"link is not btoken " + url);
				}
			} catch (Exception e) {

			}
		}
	}
	
	@Test(priority = 14, enabled = false)
	public void keyboardaction() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
	}

	@Test(priority = 15, enabled = false)
	public void multiKeyboardAction() throws InterruptedException {
		driver.get("https://text-compare.com/");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		WebElement box1=driver.findElement(By.xpath("//textarea[@id=\"inputText1\"]"));
		WebElement box2=driver.findElement(By.xpath("//textarea[@id=\"inputText2\"]"));
		
		box1.sendKeys("Shri Swami Samarth");
		Thread.sleep(3000);
		//CTRL+A
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(3000);
		//CTRL+C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(3000);
		//press TAB button
		act.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		//CTRL+V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		if(box1.getAttribute("value").equals(box2.getAttribute("value")))
				System.out.println("link copied");
		else 
			System.out.println("link copied");
	    }
	
	@Test(priority = 16, enabled = false)
	public void iframe() throws InterruptedException {
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summery.html");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Identify the frame with help of name     --->>1st frame
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
		
		driver.switchTo().defaultContent();// go back to main page  if this step is not taken then we can get **NosuchException**
		
		//Identify the frame with help of name     --->>2nd frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		
		driver.switchTo().defaultContent();// go back to main page.  if this step is not taken then we can get **NosuchException**
		
		//Identify the frame with help of WebElement     --->>3nd frame
		WebElement iframe=driver.findElement(By.xpath("//iframe[@name=\"classFrame\"]"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("(//a[text()='Tree'])[1]")).click();
		
	}
	@Test(priority = 17, enabled = false)
	public void multiKeybrdAcon() throws InterruptedException {
		driver.get("https://demo.automationtesting.in/Frames.html");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/***
		 * handling single frame
		//Identify the frame with help of FrameId     --->>single frame
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("Swami");
		*/
		
		/****
		 * Handling multiple frame
		//Identify the frame with help of WebElement     --->>1 frame
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		WebElement parentFrame=driver.findElement(By.xpath("//iframe[@style=\"float: left;height: 300px;width:600px\"]"));
		driver.switchTo().frame(parentFrame);
		
		WebElement childFrame=driver.findElement(By.xpath("(//iframe[@src=\"SingleFrame.html\"])[1]"));
		driver.switchTo().frame(childFrame);
		
		driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("swami");
		*/
	}
	
	@Test(priority = 18, enabled = false)
	public void rightclickByPawanSir() throws InterruptedException {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement button=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act= new Actions(driver);
		act.contextClick(button).build().perform();
		
	}
	@Test(priority = 19, enabled = false)
	public void doubletClickByPawanSir() throws InterruptedException {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame("iframeResult");//identify frame by frame name
		WebElement button=driver.findElement(By.xpath("//p[@ondblclick=\"myFunction()\"]"));
		explicitWait(driver, button);
		Actions act= new Actions(driver);
		act.doubleClick(button).build().perform();
		Thread.sleep(5000);
		
	}

	@Test(priority = 20, enabled = false)
	public void dragAndDropByPawanSir() throws InterruptedException {
		/****
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-1.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement box1=driver.findElement(By.id("box1"));
		WebElement box2=driver.findElement(By.id("box2"));
		WebElement box3=driver.findElement(By.id("box3"));
		WebElement box4=driver.findElement(By.id("box4"));
		WebElement dropBox1=driver.findElement(By.id("dropBox"));
		WebElement dropBox2=driver.findElement(By.id("dropBox2"));
		
		Actions act= new Actions(driver);
		act.dragAndDrop(box1, dropBox1).build().perform();
		act.dragAndDrop(box2, dropBox1).build().perform();
		act.dragAndDrop(box3, dropBox1).build().perform();
		act.dragAndDrop(box4, dropBox1).build().perform();
		
		act.dragAndDrop(box1, dropBox2).build().perform();
		act.dragAndDrop(box2, dropBox2).build().perform();
		act.dragAndDrop(box3, dropBox2).build().perform();
		act.dragAndDrop(box4, dropBox2).build().perform();
		*/
		driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
		
		Actions act= new Actions(driver);
		WebElement frame=driver.findElement(By.xpath("//iframe[@class=\"demo-frame lazyloaded\"]"));
		driver.switchTo().frame(frame);
		List<WebElement> dragList=driver.findElements(By.xpath("//ul[@class=\"gallery ui-helper-reset ui-helper-clearfix ui-droppable\"]//img"));
		WebElement drop=driver.findElement(By.xpath("//div[@id=\"trash\"]"));
		for(WebElement drag:dragList)
		{
			act.dragAndDrop(drag, drop).build().perform();;
			Thread.sleep(5000);
		}
	}
	@Test(priority = 21, enabled = false)
	public void mouseHoverWithClickByPawanSir() throws InterruptedException {
		driver.get("https://demo.opencart.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement element=driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		WebElement element1=driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));
		Actions act =new Actions(driver);
		act.moveToElement(element).moveToElement(element1).click();
		Thread.sleep(5000);
		
	}
	@Test(priority = 22, enabled = false)
	public void sliderByPawanSir() throws InterruptedException {
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement min_slider=driver.findElement(By.xpath("(//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"])[1]"));
		System.out.println("Location of the min slider :"+min_slider.getLocation());
		System.out.println("Height and width of element :"+min_slider.getSize());
		
		Actions act = new Actions(driver);
		
		Thread.sleep(5000);
		act.dragAndDropBy(min_slider, 100,0).build().perform();
		
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		Thread.sleep(5000);
		act.dragAndDropBy(max_slider,-100,0).build().perform();
		Thread.sleep(5000);
		
	}
	@Test(priority = 23, enabled = false)
	public void capturingScreenShotByPawanSir() throws InterruptedException, IOException {
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//capturing screenshot
	
				TakesScreenshot tcr=(TakesScreenshot) driver;
				File src =tcr.getScreenshotAs(OutputType.FILE);
				File trg =new File(".\\screenshot\\homepage1.png");
				FileUtils.copyFile(src, trg);
		
				
				//screenshot of section/portion of page
				/**
				WebElement section=driver.findElement(By.xpath("(//div[@class=\"a-cardui fluid-quad-card fluid-card fluid-quad-image-label fluid-quad-image-label\"])[1]"));
				File src =section.getScreenshotAs(OutputType.FILE);
				File trg =new File(".\\screenshot\\homepage2.png");
				FileUtils.copyFile(src, trg);
				*/
				
	}
	@Test(priority = 24, enabled = false)
	public void fileUploadByWithSendkeysByPawanSir() throws InterruptedException, IOException {
		driver.get("https://www.foundit.in/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class=\"heroSection-buttonContainer_secondaryBtn secondaryBtn\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys("C:\\Users\\Basvaraj\\Downloads\\Variables.pdf");
	}
	@Test(priority = 25, enabled = false)
	public void fileUploadByWithRobotClassByPawanSir() throws InterruptedException, IOException, AWTException {
		driver.get("https://www.foundit.in/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class=\"heroSection-buttonContainer_secondaryBtn secondaryBtn\"]")).click();
		WebElement button = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
		//org.openqa.selenium.InvalidArgumentException: invalid argument --->>>to overcome this issue use javascript executor
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		
		Robot r = new Robot();
		StringSelection ss  =new StringSelection("C:\\Users\\Basvaraj\\Downloads\\Variables.pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	
	}
	@Test(priority = 26, enabled = false)
	public void fileyUploadingWithJavascriptExecutorByPawanSir() throws InterruptedException, IOException {
		driver.get("https://www.foundit.in/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class=\"heroSection-buttonContainer_secondaryBtn secondaryBtn\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys("C:\\Users\\Basvaraj\\Downloads\\Variables.pdf");
		JavascriptExecutor js  =(JavascriptExecutor) driver;
	    js.executeScript ("document.getElementById('file-upload').value='‪C:\\Users\\Basvaraj\\Downloads\\Variables.pdf'");
	    
	}
	@Test(priority = 27, enabled = false)
	public void webTableHandlingByPawanSir() throws InterruptedException, Exception {
		driver.get("https://www.selenium.dev/ecosystem/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/***
		List<WebElement> list=driver.findElements(By.xpath("(//table[@class=\"table\"]//tbody//tr)"));
		for(WebElement ele:list)
		{
			Thread.sleep(2000);
			System.out.println(ele.getText());
		}
		List<WebElement> list1=driver.findElements(By.xpath("//table[@class=\"table\"]//tbody//tr//th"));
		for(WebElement ele1:list1)
		{
			Thread.sleep(2000);
			System.out.println(ele1.getText());
		}
		*/
		WebElement element=driver.findElement(By.xpath("(//table[@class=\"table\"]//tbody//tr)[2]"));
		System.out.println(element.getText());
	}
	
	@Test(priority = 28, enabled = false)
	public void calenderTableHandlingByPawanSir(){
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id=\"onward_cal\"]")).click();
		driver.findElement(By.xpath("//td[@class=\"next\"]")).click();
		driver.findElement(By.xpath("//table[@class=\"rb-monthTable first last\"]//tbody//tr//td[text()='10']")).click();
		try {
			BaseTestutil.getScreenShots(driver);
			System.out.println("screenshot captured successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 29, enabled = false)
	public void toolTipByPawanSir(){
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement iframe= driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
		driver.switchTo().frame(iframe);
		
		WebElement tooltip= driver.findElement(By.xpath("//input[@id=\"age\"]"));
		String tollTip= tooltip.getAttribute("title");
		System.out.println("tooltip --:"+tollTip);
	}
	@Test(groups = {"Regression","Sanity","smoke"},priority = 30, enabled = true)
	public void validateTextByPagesourceMethod(){
		//WebDriver driver=getDriver();
		getDriver().get("https://jqueryui.com/tooltip/");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(getDriver().getPageSource().contains("Your age:"))
		{
			System.out.println("Text is valid");
		}
		else 
		{
			System.out.println("Text is not valid");
		}
	}
	@Test(groups = {"Regression","Sanity","smoke"},priority = 31, enabled = true)
	public void validateTextBy(){
		//WebDriver driver=getDriver();
		getDriver().get("https://jqueryui.com/tooltip/");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement>list=getDriver().findElements(By.xpath("//h1[text()='Tooltip']"));
		if(list.size()>0)
		{
			System.out.println("Text is valid");
		}
		else 
		{
			System.out.println("Text is not valid");
		}
	}
	@Test(priority = 32, enabled = false)
	public void getTextIsNotWorking(){
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.xpath("//div[@id=\"content\"]//h1"));
		String text=ele.getAttribute("innerText");
		System.out.println(text);
		String text1=ele.getAttribute("textContent");
		System.out.println(text1);
	}
}