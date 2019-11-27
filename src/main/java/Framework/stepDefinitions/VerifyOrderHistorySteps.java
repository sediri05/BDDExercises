package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyOrderHistorySteps extends DriverFactory {
    PageObjectManager obj = new PageObjectManager(driver);

    @Given("^the User is on My Account Page$")
    public void navigateToMyAccount() {
        obj.getNavBarActions().clickSignIn();
        obj.getUserRegistrationActions().Login();
    }

    @When("^the User goes to Order History and Details Page$")
    public void navigateToOrderHistory() {
        obj.getmyAccActions().navigateToOrderHistory();
    }

    @Then("^the order details are displayed and correct$")
    public void verifyDetails() {
        obj.getOrderHistoryActions().verifyDetails();
    }

    @And("^the User is able to download the Invoice and log out$")
    public void downloadInvoiceAndLogout(){
        obj.getOrderHistoryActions().downloadPDF();
        obj.getOrderHistoryActions().verifyDownloadSuccessful();
        obj.getNavBarActions().clickSignOut();
    }


}
