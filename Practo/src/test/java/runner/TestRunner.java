package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
 // You can remove this import
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    //features = "src/test/resources/features",
	//features = "src/test/resources/features/CorporateWellness.feature",
	features = "src/test/resources/features/DiagnosticTopCities.feature",
    //features = "@target/rerun.txt",
	
	//tags = "@regression",
    glue = {"stepdefinitions","hooks"}, // Ensure this matches your package name exactly (lowercase)
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "rerun:target/rerun.txt"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // Extending AbstractTestNGCucumberTests makes this a TestNG runner
}