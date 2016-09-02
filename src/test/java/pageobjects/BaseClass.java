package pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class BaseClass {

	protected static WebDriver driver;

	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
	}	
}
