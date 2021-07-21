package cucumber.Options;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		features = "src/test/java/features",   
		glue = {"stepDefinations"},
		plugin ="json:target/jsonReports/cucumber-report.json"
		)
// when we run this file with tags then first it search for tags which is mention here in all over feature file
// present in feature package or you can give one file location and it search only into that feature file  
public class TestRunner 
{
	/*@io.cucumber.junit.CucumberOptions(
			features = "src/test/java/features",   
			glue = {"stepDefinations"},
			plugin ="json:target/jsonReports/cucumber-report.json",
			tags = {"@DeletePlace"}
			)*/
}
