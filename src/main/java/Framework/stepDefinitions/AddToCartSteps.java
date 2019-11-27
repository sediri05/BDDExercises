package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

public class AddToCartSteps extends DriverFactory {
    PageObjectManager obj = new PageObjectManager(driver);


    @Given("^the User has logged in$")
    public void Login() {
        items.add(prop.getProperty("searchItem1").toLowerCase());
        items.add(prop.getProperty("searchItem2").toLowerCase());
        obj.getNavBarActions().clickSignIn();
        obj.getUserRegistrationActions().Login();
    }

    @When("^the User searches for and adds 2 different items to the Cart$")
    public void AddToCart() {
        obj.getNavBarActions().searchForItem(items.get(0));
        obj.getSearchPageActions().hoverOverItem();
        prices.add(obj.getSearchPageActions().capturePrice());
        obj.getSearchPageActions().addToCart();
        obj.getSearchPageActions().clickContinueShopping();
        obj.getNavBarActions().searchForItem(items.get(1));
        obj.getSearchPageActions().hoverOverItem();
        prices.add(obj.getSearchPageActions().capturePrice());
        obj.getSearchPageActions().addToCart();
        obj.getSearchPageActions().clickProceedToCheckout();
    }

    @Then("^the User is able to input their details$")
    public void InputDetails() {
        obj.getShoppingCartActions().verifyItems(items);
        obj.getShoppingCartActions().verifyPrices(prices);
        obj.getShoppingCartActions().clickCheckout();
        obj.getAddressTabActions().selectDeliveryAddress();
        obj.getAddressTabActions().proceedToCheckout();
        obj.getShippingTabActions().clickProceedToCheckout();
        obj.getShippingTabActions().closeOverlay();
        obj.getShippingTabActions().clickTerms();
        obj.getShippingTabActions().clickProceedToCheckout();
        obj.getPaymentTabActions().selectPaymentOption(prop.getProperty("Payment"));
    }

    @And("^confirms the order and logs out$")
    public void ConfirmOrder(){
        obj.getOrderSummaryActions().clickConfirmOrder();
        obj.getOrderConfirmationActions().verifySuccess(calculateTotalPrice(prices));
        writeToPropFile(obj.getOrderConfirmationActions().getOrderRef(),"OrderRef");
        writeToPropFile(calculateTotalPrice(prices).toString(),"TotalAmount");
        obj.getNavBarActions().clickSignOut();
    }
}


