package activitiframework;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty","html:cucumber/Destination","json:target/cucumber/activitipageobject.json"},
		dryRun = false,
		features = "src/test/resources/Feature/Activiti_PageObject/Activiti_PageObject.feature",//Path to the features file
		glue={"pageObjectStepDefinition"})
public class ActivitiPageObjectTest {

}
