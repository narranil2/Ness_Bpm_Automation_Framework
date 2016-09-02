package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{

	WebDriver driver;

	@FindBy(how=How.XPATH, using="//span[@class='glyphicon glyphicon-chevron-down']")
	public static WebElement activiti_logout_link1;

	@FindBy(how=How.XPATH, using="//a[@ng-click='logout()']")
	public static WebElement activiti_logout_link2;
	
	@FindBy(how=How.LINK_TEXT, using="Administrator")
	public static WebElement pega_logout_link1;
	
	@FindBy(how=How.XPATH, using="//span[@class='menu-item-title']")
	public static WebElement pega_logout_link2;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}	

	public void ActivitiUserlogout() throws Throwable {
		activiti_logout_link1.click();
		activiti_logout_link2.click();
	}
	
	public void PegaUserlogout() throws Throwable {
		pega_logout_link1.click();
		pega_logout_link1.click();
	}

}
