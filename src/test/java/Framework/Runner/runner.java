package Framework.Runner;

import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        usageReport = false,
        toPDF = true,
        excludeCoverageTags = {"@flaky"},
        includeCoverageTags = {"@passed"},
        outputFolder = "target/site"
)
@CucumberOptions(strict = false, features = "src/test/resources/Features/Ex2.feature",
        glue = "Framework.stepDefinitions", format = { "pretty",
        "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" }, tags = { "~@ignore" })
public class runner {

}

