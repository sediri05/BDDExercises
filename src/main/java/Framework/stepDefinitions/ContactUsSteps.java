package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps extends DriverFactory {
    private PageObjectManager tempObj = new PageObjectManager(driver);

    @Given("^the User is on the Sign In Page$")
    public void NavigateToSignInPage() {
        tempObj.getNavBarActions().clickSignIn();
    }

    @When("^the User goes to the Contact Page$")
    public void NavigateToContactPage(){
        tempObj.getNavBarActions().clickContactUs();
    }

    @And("^inputs the details with an attachment included$")
    public void InputDetails(){
        tempObj.getContactUsActions().enterDetails();
        tempObj.getContactUsActions().attachFile();
    }

    @Then("^the User is able to successfully submit the query$")
    public void SubmitMessage(){
        tempObj.getContactUsActions().submit();
        tempObj.getContactUsActions().validateSuccess();
    }

    @And("^logs out$")
    public void Logout(){
        //tempObj.getNavBarActions().clickSignOut();
    }
}