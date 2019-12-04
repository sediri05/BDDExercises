package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import Framework.Utilities.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyOrderHistorySteps extends DriverFactory {
    PageObjectManager obj = new PageObjectManager(driver);

    @Given("^the User is on My Account Page$")
    public void navigateToMyAccount() {
        obj.getNavBarActions().clickSignIn();
        Log.info("Navigated to Sign In page");
        obj.getUserRegistrationActions().Login();
        Log.info("Successfully logged in");
    }

    @When("^the User goes to Order History and Details Page$")
    public void navigateToOrderHistory() {
        obj.getmyAccActions().navigateToOrderHistory();
        Log.info("Navigated to Order History");
    }

    @Then("^the order details are displayed and correct$")
    public void verifyDetails() {
        obj.getOrderHistoryActions().verifyDetails();
        Log.info("Order History details are validated");
    }

    @And("^the User is able to download the Invoice and log out$")
    public void downloadInvoiceAndLogout(){
        obj.getOrderHistoryActions().downloadPDF();
        Log.info("PDF is downloaded");
        obj.getOrderHistoryActions().verifyDownloadSuccessful();
        Log.info("Download is successful and verified");
        obj.getNavBarActions().clickSignOut();
        Log.info("User logs out");
    }


}
