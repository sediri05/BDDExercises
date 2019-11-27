package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressTabObjects {
    WebDriver driver;

    public AddressTabObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_address_delivery")
    public WebElement selectDelivery;

    @FindBy(xpath = "//button[@name='processAddress']")
    public WebElement proceedToCheckout;
}
