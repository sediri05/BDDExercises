package Framework.PageActions;

import Framework.PageObjects.PersonalInfoObjects;
import Framework.Utilities.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PersonalInfoActions extends DriverFactory {
    private PersonalInfoObjects pio;

    public PersonalInfoActions(WebDriver driver) {
        this.driver = driver;
        pio = new PersonalInfoObjects(driver);
    }

    public void verifyDetails(){
        Assert.assertTrue(pio.first.getAttribute("value").matches(prop.getProperty("UsernameF")));
        Assert.assertTrue(pio.last.getAttribute("value").matches(prop.getProperty("UsernameL")));
        Assert.assertTrue(pio.email.getAttribute("value").matches(prop.getProperty("registerEmail")));
    }
}
