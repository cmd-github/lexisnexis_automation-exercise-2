package stepDefinitions;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/job_search.feature", // Path to feature files
                glue = "stepDefinitions", // Path to step definitions
                plugin = { "pretty" })
public class RunCucumberSerenityTest {
}
