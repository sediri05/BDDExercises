package Framework.stepDefinitions;

import Framework.Utilities.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends DriverFactory {
    @Before
    public void beforeScenario(Scenario scenario) {
        setUp(scenario.getName());
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
