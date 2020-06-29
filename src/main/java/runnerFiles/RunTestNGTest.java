package runnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Mrunal\\BDD_TestNG\\src\\main\\java\\featureFiles\\LoginApp.feature", // path of step feature file 
	glue = "classpath:stepDefinations", // path of step definition file 
	dryRun = false, //to check mapping between feature and step def only and skipped execution
	monochrome = true, //to have console output in more readable format.. unnecessary skipping numeric value
	plugin= {"pretty",
			"html:html-output",
			"json:json-output/cucumber.json",
			"junit:junit-output/cucumber.xml"},
	strict = true //to check mapping between feature and step def only and continues execution
//	name = "user" // RUN SCENARIOS who matches to given string
	
)
public class RunTestNGTest extends AbstractTestNGCucumberTests {

}
