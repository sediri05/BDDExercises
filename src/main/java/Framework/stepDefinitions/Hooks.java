package Framework.stepDefinitions;

import Framework.Utilities.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends DriverFactory {
    @Before
    public void beforeScenario() {
        setUp();
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
