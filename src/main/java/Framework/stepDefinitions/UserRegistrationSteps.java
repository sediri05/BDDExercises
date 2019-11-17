package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistrationSteps extends DriverFactory {
    private PageObjectManager tempObj = new PageObjectManager(driver);

    @Given("^User is on the Registration Page$")
    public void NavigateToRegistrationPage() {
        tempObj.getNavBarActions().clickSignIn();
        tempObj.getUserRegistrationActions().enterEmail(prop.getProperty("registerEmail"));
        tempObj.getUserRegistrationActions().clickCreate();
    }

    @When("^The user enters their details on the registration page$")
    public void EnterDetails() {
        tempObj.getUserRegistrationActions().enterLoginDetails(prop);
        tempObj.getUserRegistrationActions().enterAddressDetails(prop);
        tempObj.getUserRegistrationActions().enterPhone(prop.getProperty("MobPhone"));
    }

    @Then("^The User is able to register$")
    public void Register() {
        tempObj.getUserRegistrationActions().clickRegister();
    }

    @And("^Validate the details$")
    public void Verify(){
        tempObj.getmyAccActions().verifyRegisteredAndLoggedIn();
//        tempObj.getmyAccActions().verifyMyAccountPage();
        tempObj.getmyAccActions().navigateToPersonalInfoPage();
        tempObj.getPersonalInfoActions().verifyDetails();
    }

    @And("^Logout$")
    public void LogoutAndLogin(){
        tempObj.getNavBarActions().clickSignOut();
        tempObj.getUserRegistrationActions().Login();
    }
}
