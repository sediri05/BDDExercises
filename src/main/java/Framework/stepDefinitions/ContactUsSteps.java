package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import Framework.Utilities.Log;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ContactUsSteps extends DriverFactory {
    private PageObjectManager tempObj = new PageObjectManager(driver);

    @Given("^the User is on the Sign In Page$")
    public void NavigateToSignInPage() {
        tempObj.getNavBarActions().clickSignIn();
        Log.info("Signed in successfully");
    }

    @When("^the User goes to the Contact Page$")
    public void NavigateToContactPage(){
        tempObj.getNavBarActions().clickContactUs();
        Log.info("Navigated to Contact Us page");
    }

    @And("^inputs the details with an attachment included$")
    public void InputDetails(){
        tempObj.getContactUsActions().enterDetails();
        Log.info("Details entered");
        tempObj.getContactUsActions().attachFile();
        Log.info("text file is attached");
    }

    @Then("^the User is able to successfully submit the query$")
    public void SubmitMessage(){
        tempObj.getContactUsActions().submit();
        Log.info("Query is submitted");
        tempObj.getContactUsActions().validateSuccess();
        Log.info("Successful submission");
    }

    @And("^logs out$")
    public void Logout(){
        Assert.assertTrue(false);
        //tempObj.getNavBarActions().clickSignOut();
        //Log.info("Signed out successfully");
    }
}