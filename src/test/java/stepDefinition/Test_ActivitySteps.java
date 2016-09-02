package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.PropertyConfig;

public class Test_ActivitySteps {

	private static WebDriver driver = null;	

	@Before
	public void beforeTest() {

	}

	@Given("^User is on Home Page of the application$")
	public void User_is_on_Home_Page_of_the_application() throws Throwable {		
		String browser = new PropertyConfig().readProperty("browser");
		String activiti_url = new PropertyConfig().readProperty("activiti_url");
		String pega_url = new PropertyConfig().readProperty("pega_url");
		System.out.println("Browser used:::::"+browser);
		System.out.println("Activiti URL:::::"+activiti_url);
		System.out.println("Pega URL:::::"+pega_url);
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
		driver.get(activiti_url);		
		assertEquals("Activiti", driver.getTitle());
		driver.manage().window().maximize();
	}

	@When("^User enters valid Employee role UserName and Password credentials$")
	public void User_enters_valid_Employee_role_UserName_and_Password_credentials() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("anilkumarreddy.narreddi@ness.com"); 
		driver.findElement(By.id("password")).sendKeys("test@123");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.linkText("TimeOff_App")).click();
		driver.findElement(By.xpath("//span[text()='Start a new process and then track its progress']")).click();
		driver.findElement(By.id("form_start_button")).click();
		int process_size=driver.findElements(By.xpath("//div[@class='user-picture']")).size();
		driver.findElements(By.xpath("//div[@class='user-picture']")).get(process_size-1).click();
		driver.findElement(By.id("activiti-vacationStartDate")).sendKeys("09-9-2016");
		driver.findElement(By.id("activiti-vacationEndDate")).sendKeys("09-9-2016");
		driver.findElement(By.id("activiti-noOfDays")).sendKeys("1");
		driver.findElement(By.id("form_complete_button")).click();		
		//assertEquals("Result of clicking process complete button", driver.findElement(By.id("form_complete_button")));
		assertEquals(driver.findElement(By.id("form_complete_button")).getText(),"COMPLETE");
	}

	@When("^User enters valid Manager role UserName and Password credentials$")
	public void User_enters_valid_Manager_role_UserName_and_Password_credentials() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("anilmanager1@ness.com"); 
		driver.findElement(By.id("password")).sendKeys("test@123");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.linkText("TimeOff_App")).click();		
		//assertEquals("Result of clicking time off Button", driver.findElement(By.linkText("TimeOff_App")));
	}

	@Then("^Message displayed Login Successfully$")
	public void Message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Logged into activiti bpm Successfully");
		System.out.println("Start the Vacation Request BPM Process");
		System.out.println("Vacation request BPMS Process started Successfully");
	}

	@When("^User enters In valid UserName and Password credentials$")
	public void User_enters_In_valid_UserName_and_Password_credentials() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("anilkumarreddy1.narreddi@ness.com"); 
		driver.findElement(By.id("password")).sendKeys("test@1234");
		driver.findElement(By.id("login")).click();
	}

	@Then("^Message displayed Login failed$")
	public void Message_displayed_Login_failed() throws Throwable {
		System.out.println("Please enter valid credentials.");
	}

	@When("^User enters valid Lead role UserName and Password credentials$")
	public void User_enters_valid_Lead_role_UserName_and_Password_credentials() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("anillead1@ness.com"); 
		driver.findElement(By.id("password")).sendKeys("test@123");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.linkText("TimeOff_App")).click();			
	}

	@When("^User clicks on claim process$")
	public void User_clicks_on_claim_process() throws Throwable {
		//Click the claim button
		driver.findElement(By.xpath("//button[@ng-click='claimTask()']")).click();
	}

	@Then("^Business process is displayed to the lead to approve or reject$")
	public void Business_process_is_displayed_to_the_lead_to_approve_or_reject() throws Throwable {
		System.out.println("Business Process is displayed for the lead to Claim");
		//Lead approves the request
		driver.findElement(By.id("form_complete_button")).click();	    
		System.out.println("Lead approved the request");
	}

	@Then("^manager approval screen is displayed$")
	public void manager_approval_screen_is_displayed() throws Throwable {
		System.out.println("Business Process is displayed for the Manger to Claim");
		driver.findElement(By.id("activiti-comments")).sendKeys("Vacation Approved with Comments on 08/25/16");
		driver.findElement(By.id("form_complete_button")).click();	
		System.out.println("Manager approved the request");	
	}

	@When("^User LogOut from the Application$")
	public void User_LogOut_from_the_Application() throws Throwable {
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-down']")).click();
		driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void Message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("User logged out succesfully");		
		driver.quit();
		assertTrue("User logged out succesfully",true);
	}

	@After
	public void tearDown(){
		driver.quit();	
	}
}
