package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingTabObjects {
    WebDriver driver;

    public ShippingTabObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@title='Close']")
    public WebElement closeOverlay;

    @FindBy(id = "cgv")
    public WebElement termsCheckbox;
}
