package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHrmLoginPage {
	WebDriver driver;
	By userName=By.name("txtUsername");
	By passWord =By.name("txtPassword");
	By loginButton=By.name("Submit");
	
	OrangeHrmLoginPage(WebDriver d)
	{
		driver=d;
	}
	
	public void setUserName(String username)
	{
		driver.findElement(userName).sendKeys(username);;
	}
	
	public void setPassWord(String password)
	{
		driver.findElement(passWord).sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	
	

}
