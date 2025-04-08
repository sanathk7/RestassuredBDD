package runners;  // Ensure this matches your package structure

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

    features = "src/test/resources/Feature", // Adjust this if your feature files are in a different folder

    glue = {"Stepdefination", "utils"}, // This should match the package of your step definitions
   plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}, // Generates reports
    monochrome = true // Makes the console output readable
)
public class TestRunnerTest {
}
