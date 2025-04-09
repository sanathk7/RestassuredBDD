package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@SelectClasspathResource("Feature") // folder under src/test/resources
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "Stepdefination,utils")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html, json:target/cucumber-reports.json")
@ConfigurationParameter(key = MONOCHROME_PROPERTY_NAME, value = "true")
public class TestRunnerTest {
}

