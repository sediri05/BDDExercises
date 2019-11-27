package Framework.PageActions;

import Framework.PageObjects.AddressTabObjects;
import Framework.Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressTabActions extends DriverFactory {
    private AddressTabObjects ato;


    public AddressTabActions(WebDriver driver) {
        this.driver = driver;
        ato = new AddressTabObjects(driver);
    }

    public void selectDeliveryAddress(){
        (new Select(ato.selectDelivery)).selectByIndex(0);
    }

    public void proceedToCheckout(){
        ato.proceedToCheckout.click();
    }
}
