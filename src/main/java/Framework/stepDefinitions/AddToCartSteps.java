package Framework.stepDefinitions;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;
import Framework.Utilities.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartSteps extends DriverFactory {
    PageObjectManager obj = new PageObjectManager(driver);


    @Given("^the User has logged in$")
    public void Login() {
        items.add(prop.getProperty("searchItem1").toLowerCase());
        items.add(prop.getProperty("searchItem2").toLowerCase());
        Log.info("Search items added to arraylist");
        obj.getNavBarActions().clickSignIn();
        Log.info("Navigated to sign in page");
        obj.getUserRegistrationActions().Login();
        Log.info("User logs in successfully");
    }

    @When("^the User searches for and adds 2 different items to the Cart$")
    public void AddToCart() {
        obj.getNavBarActions().searchForItem(items.get(0));
        Log.info("Searched for item 1");
        obj.getSearchPageActions().hoverOverItem();
        Log.info("Hovered over item to show overlay");
        prices.add(obj.getSearchPageActions().capturePrice());
        Log.info("Item 1 price captured");
        obj.getSearchPageActions().addToCart();
        Log.info("Item added to cart");
        obj.getSearchPageActions().clickContinueShopping();
        Log.info("Continue Shopping clicked");
        obj.getNavBarActions().searchForItem(items.get(1));
        Log.info("Searched for item 2");
        obj.getSearchPageActions().hoverOverItem();
        Log.info("Hovered over item to show overlay");
        prices.add(obj.getSearchPageActions().capturePrice());
        Log.info("Item 2 price captured");
        obj.getSearchPageActions().addToCart();
        Log.info("Item added to cart");
        obj.getSearchPageActions().clickProceedToCheckout();
        Log.info("Navigated to Checkout screen");
    }

    @Then("^the User is able to input their details$")
    public void InputDetails() {
        obj.getShoppingCartActions().verifyItems(items);
        Log.info("items displayed are verified against those selected previously");
        obj.getShoppingCartActions().verifyPrices(prices);
        Log.info("prices displayed are verified against those selected previously");
        obj.getShoppingCartActions().clickCheckout();
        Log.info("Checkout clicked");
        obj.getAddressTabActions().selectDeliveryAddress();
        Log.info("Delivery Address selected");
        obj.getAddressTabActions().proceedToCheckout();
        Log.info("Proceeded to checkout");
        obj.getShippingTabActions().clickProceedToCheckout();
        Log.info("Clicked Proceed to checkout");
        obj.getShippingTabActions().closeOverlay();
        Log.info("Close overlay");
        obj.getShippingTabActions().clickTerms();
        Log.info("Check terms checkbox");
        obj.getShippingTabActions().clickProceedToCheckout();
        Log.info("Clicked Proceed to checkout");
        obj.getPaymentTabActions().selectPaymentOption(prop.getProperty("Payment"));
        Log.info("Payment type selected");
    }

    @And("^confirms the order and logs out$")
    public void ConfirmOrder(){
        obj.getOrderSummaryActions().clickConfirmOrder();
        Log.info("Confirm Order clicked");
        obj.getOrderConfirmationActions().verifySuccess(calculateTotalPrice(prices));
        Log.info("Total price is verified and correct");
        writeToPropFile(obj.getOrderConfirmationActions().getOrderRef(),"OrderRef");
        Log.info("Order ref written to file");
        writeToPropFile(calculateTotalPrice(prices).toString(),"TotalAmount");
        Log.info("Total price is written to file");
        obj.getNavBarActions().clickSignOut();
        Log.info("Signed out successfully");
    }
}


