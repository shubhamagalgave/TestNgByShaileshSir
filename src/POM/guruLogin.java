package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guruLogin {
	WebDriver driver;
	
	public guruLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type=\"text\"]")
	WebElement userName;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement passWord;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement button;
	
	public void setUserName(String username)
	{
		userName.sendKeys(username);
	}
	
	public void setPassWord(String password)
	{
		passWord.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		button.click();
	}

}
