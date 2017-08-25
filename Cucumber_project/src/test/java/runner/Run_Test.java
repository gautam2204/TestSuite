package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = "stepDefinitions", tags = "@Case-4", plugin = {"html:target/cucumber-html-report"})
public class Run_Test {

}
