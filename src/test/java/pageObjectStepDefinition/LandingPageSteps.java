package pageObjectStepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.SignInAction;
import modules.SignoutAction;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import util.PropertyConfig;

public class LandingPageSteps{

	WebDriver driver;

	String invokedUrl =  "";

	public LandingPageSteps(){	
		
	}

	@When("^I open Activiti BPM website$")
	public void iOpenActivitiBpmWebsite() throws Throwable {	
		String browser = new PropertyConfig().readProperty("browser");
		if("" != new PropertyConfig().readProperty("activiti_url")  && null != new PropertyConfig().readProperty("activiti_url")){
			invokedUrl = new PropertyConfig().readProperty("activiti_url");
		}else if("" != new PropertyConfig().readProperty("pega_url")  && null !=  new PropertyConfig().readProperty("pega_url")){
			invokedUrl = new PropertyConfig().readProperty("pega_url");
		}
		System.out.println("Browser used:::::"+browser);
		System.out.println("Invoked  URL:::::"+ invokedUrl);
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Anil\\Maven_Jars\\chromedriver_win32\\chromedriver.exe");
			driver = new org.openqa.selenium.chrome.ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Anil\\Maven_Jars\\IEDriverServer\\IEDriverServer.exe");
			System.out.println("Starting Internet Explorer");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
		} else {
			System.out.println("Can't read browser type");
		}				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(invokedUrl);		
		driver.manage().window().maximize();
	}

	@When("^I sign in$")
	public void iSignIn() throws Throwable {
		if (invokedUrl.equals(new PropertyConfig().readProperty("activiti_url"))) {
			PageFactory.initElements(driver, LoginPage.class);
			PageFactory.initElements(driver, HomePage.class);
			SignInAction.ExecuteActivitiCall(driver,new PropertyConfig().readProperty("emp.username"),new PropertyConfig().readProperty("emp.passwd"));
			assertEquals(new PropertyConfig().readProperty("activiti.browser.title"), driver.getTitle());
		}else if(invokedUrl.equals(new PropertyConfig().readProperty("pega_url"))){
			PageFactory.initElements(driver, LoginPage.class);
			PageFactory.initElements(driver, HomePage.class);
			SignInAction.ExecutePegaCall(driver,new PropertyConfig().readProperty("pega.admin.userid"),new PropertyConfig().readProperty("pega.admin.password"));
			//assertEquals(new PropertyConfig().readProperty("pega.browser.title"), driver.getTitle());
		}

	}

	@Then("^I sign out$")
	public void iSignOut() throws Throwable {
		if (invokedUrl.equals(new PropertyConfig().readProperty("activiti_url"))) {
			SignoutAction.ShowActivitiHomePage(driver);
		}else if(invokedUrl.equals(new PropertyConfig().readProperty("pega_url"))){
			SignoutAction.ShowPegaHomePage(driver);
		}
		driver.quit();
	}
}
