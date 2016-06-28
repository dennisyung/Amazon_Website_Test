package test.java.testrunners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import static test.java.implementation.utils.TestConstants.*;

@RunWith (Cucumber.class)
@CucumberOptions (features = FEATURE_RELATIVE_PATH, tags = "@sanity", glue = STEPDEFS_RELATIVE_PATH, plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report"})
public class SanitySuite {
	
}
