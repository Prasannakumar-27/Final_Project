package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
 // You can remove this import
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    //features = "src/test/resources/features",
	//features = "src/test/resources/features/CorporateWellness.feature",
    features = "@target/rerun.txt",
    
    glue = {"stepdefinitions","hooks"}, // Ensure this matches your package name exactly (lowercase)
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "rerun:target/rerun.txt"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // Extending AbstractTestNGCucumberTests makes this a TestNG runner
}