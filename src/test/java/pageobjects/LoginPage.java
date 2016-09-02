package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

	WebDriver driver;

	@FindBy(id = "username")
	public static WebElement userNameTextBox;

	@FindBy(id = "password")
	public static WebElement passwordTextBox;
	
	@FindBy(id = "txtUserID")
	public static WebElement pegaUserNameTextBox;

	@FindBy(id = "txtPassword")
	public static WebElement pegaPasswordTextBox;

	@FindBy(id = "login")
	public static WebElement loginButton;
	
	@FindBy(id = "sub")
	public static WebElement pegaLoginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}	
}
