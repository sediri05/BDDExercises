package Framework.Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/Framework/Features/Ex2.feature",
        glue = {"Framework.stepDefinitions"}
        ,format = {"pretty", "json:target/cucumber.json"}
        )
public class runner
{

}
