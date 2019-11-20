package Framework.Managers;
import Framework.PageActions.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private UserRegistrationActions userRegistrationActions;
    private NavigationBarActions navBarActions;
    private MyAccountActions myAccActions;
    private PersonalInfoActions personalInfoActions;
    private ContactUsActions contactUsActions;
    private SearchPageActions searchPageActions;
    private ShoppingCartActions shoppingCartActions;
    private AddressTabActions addressTabActions;
    private ShippingTabActions shippingTabActions;
    private PaymentTabActions paymentTabActions;
    private OrderSummaryActions orderSummaryActions;
    private OrderConfirmationActions orderConfirmationActions;
    private OrderHistoryActions orderHistoryActions;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public NavigationBarActions getNavBarActions(){
        return (navBarActions == null) ? navBarActions = new NavigationBarActions(driver) : navBarActions;
    }

    public UserRegistrationActions getUserRegistrationActions() {
        return (userRegistrationActions == null) ? userRegistrationActions = new UserRegistrationActions(driver) : userRegistrationActions;
    }

    public MyAccountActions getmyAccActions() {
        return (myAccActions == null) ? myAccActions = new MyAccountActions(driver) : myAccActions;
    }

    public PersonalInfoActions getPersonalInfoActions() {
        return (personalInfoActions == null) ? personalInfoActions = new PersonalInfoActions(driver) : personalInfoActions;
    }

    public ContactUsActions getContactUsActions() {
        return (contactUsActions == null) ? contactUsActions = new ContactUsActions(driver) : contactUsActions;
    }

    public SearchPageActions getSearchPageActions() {
        return (searchPageActions == null) ? searchPageActions = new SearchPageActions(driver) : searchPageActions;
    }

    public ShoppingCartActions getShoppingCartActions() {
        return (shoppingCartActions == null) ? shoppingCartActions = new ShoppingCartActions(driver) : shoppingCartActions;
    }

    public AddressTabActions getAddressTabActions() {
        return (addressTabActions == null) ? addressTabActions = new AddressTabActions(driver) : addressTabActions;
    }

    public ShippingTabActions getShippingTabActions() {
        return (shippingTabActions == null) ? shippingTabActions = new ShippingTabActions(driver) : shippingTabActions;
    }

    public PaymentTabActions getPaymentTabActions() {
        return (paymentTabActions == null) ? paymentTabActions = new PaymentTabActions(driver) : paymentTabActions;
    }

    public OrderSummaryActions getOrderSummaryActions() {
        return (orderSummaryActions == null) ? orderSummaryActions = new OrderSummaryActions(driver) : orderSummaryActions;
    }

    public OrderConfirmationActions getOrderConfirmationActions() {
        return (orderConfirmationActions == null) ? orderConfirmationActions = new OrderConfirmationActions(driver) : orderConfirmationActions;
    }

    public OrderHistoryActions getOrderHistoryActions() {
        return (orderHistoryActions == null) ? orderHistoryActions = new OrderHistoryActions(driver) : orderHistoryActions;
    }

}