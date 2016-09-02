package modules;

import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;

public class SignoutAction {

	public static void ShowPegaHomePage(WebDriver driver) throws Exception{
		HomePage.pega_logout_link1.click();
		HomePage.pega_logout_link2.click();
		System.out.println("Pega User logged out succesfully:::");
	}
	
	public static void ShowActivitiHomePage(WebDriver driver) throws Exception{
		HomePage.activiti_logout_link1.click();
		HomePage.activiti_logout_link2.click();
		System.out.println("Activiti User logged out succesfully:::");
	}
}
