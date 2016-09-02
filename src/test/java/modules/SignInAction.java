package modules;

import org.openqa.selenium.WebDriver;

import pageobjects.LoginPage;

public class SignInAction {

	public static void ExecuteActivitiCall(WebDriver driver,String userName,String password) throws Exception{
		LoginPage.userNameTextBox.sendKeys(userName);
		System.out.println(" Entered UserName in text box" );
		LoginPage.passwordTextBox.sendKeys(password);
		System.out.println("Entered Password in text box" );
		LoginPage.loginButton.click();
		System.out.println("Click action is performed on Submit button");
		System.out.println("SignIn Action is successfully perfomred");
	}
	
	public static void ExecutePegaCall(WebDriver driver,String userName,String password) throws Exception{
		LoginPage.pegaUserNameTextBox.sendKeys(userName);
		System.out.println(" Entered UserName in text box" );
		LoginPage.pegaPasswordTextBox.sendKeys(password);
		System.out.println("Entered Password in text box" );
		LoginPage.pegaLoginButton.click();
		System.out.println("Click action is performed on Submit button");
		System.out.println("SignIn Action is successfully perfomred");
	}

}
