package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage23 {
	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement userName;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passWord;

	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement click;
	WebDriver driver;
	
	public LoginPage23(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userName(String username) {
		userName.sendKeys(username);
		
	}
	public void passWord(String password) {
		passWord.sendKeys("password");
	}
	
	public void click() {
		click.click();
	}



}
