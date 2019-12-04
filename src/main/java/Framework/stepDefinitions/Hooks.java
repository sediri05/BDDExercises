package Framework.stepDefinitions;

import Framework.Utilities.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;


public class Hooks extends DriverFactory {
    @Before
    public void beforeScenario(Scenario scenario) {
        setUp(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()) {
                scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
            }
        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
        }
        tearDown();
    }
}
