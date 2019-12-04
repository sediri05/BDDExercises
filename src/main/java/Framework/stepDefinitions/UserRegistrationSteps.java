package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import Framework.Utilities.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistrationSteps extends DriverFactory {
    private PageObjectManager tempObj = new PageObjectManager(driver);

    @Given("^User is on the Registration Page$")
    public void NavigateToRegistrationPage() {
       /* tempObj.getNavBarActions().clickSignIn();
        Log.info("Navigated to Sign In Page");
        tempObj.getUserRegistrationActions().enterEmail(prop.getProperty("registerEmail"));
        Log.info("Registration email entered");
        tempObj.getUserRegistrationActions().clickCreate();
        Log.info("Create button clicked");*/
    }

    @When("^The user enters their details on the registration page$")
    public void EnterDetails() {
        /*tempObj.getUserRegistrationActions().enterLoginDetails(prop);
        Log.info("Registration detailed are entered");
        tempObj.getUserRegistrationActions().enterAddressDetails(prop);
        Log.info("Address details are entered");
        tempObj.getUserRegistrationActions().enterPhone(prop.getProperty("MobPhone"));
        Log.info("Phone Number is entered");*/
    }

    @Then("^The User is able to register$")
    public void Register() {
        /*tempObj.getUserRegistrationActions().clickRegister();
        Log.info("Register button is clicked");*/
    }

    @And("^Validate the details$")
    public void Verify(){
        /*tempObj.getmyAccActions().verifyRegisteredAndLoggedIn();
        Log.info("Registration confirmation is verified and user is able to Log in");
//        tempObj.getmyAccActions().verifyMyAccountPage();
        //Log.info("My Account Page displayed is verified");
        tempObj.getmyAccActions().navigateToPersonalInfoPage();
        Log.info("Navigated to personal info page");
        tempObj.getPersonalInfoActions().verifyDetails();
        Log.info("Personal Info is verified");*/
    }

    @And("^Logout$")
    public void LogoutAndLogin(){
        /*tempObj.getNavBarActions().clickSignOut();
        Log.info("User is able to successfully Log out");
        tempObj.getUserRegistrationActions().Login();
        Log.info("User is able to successfully Log in");*/
    }
}
