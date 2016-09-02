package activitiframework;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//tags = {"@EmployeeRoleTest"},  
		tags = { "@EmployeeRoleTest,@LeadRoleTest,@ManagerRoleTest" },  
		format = {"pretty","html:cucumber/Destination","json:target/cucumber/activiti.json"},
		/*format = {
			        "json:target/cucumber/activiti.json",
			         "html:target/cucumber/activiti.html",
			         "junit:target/cucumber/activiti.xml",
			         "pretty"
			        },*/
		dryRun = false,
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		features = "src/test/resources/Feature/activiti/Activit_Login.feature",//Path to the features file
		glue={"stepDefinition"})
public class ActivitiRunnerTest {

}
