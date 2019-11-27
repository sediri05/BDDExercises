package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationObjects {
    WebDriver driver;

    public OrderConfirmationObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    public WebElement orderConfirmationHeading;

    @FindBy(xpath = "//a[@title='Back to orders']")
    public WebElement backToOrders;

    @FindBy(xpath = "//span[@class='price']/strong")
    public WebElement totalPricePaid;

    @FindBy(xpath = "//div[@class='box order-confirmation']")
    public WebElement OrderRefCheck;

    @FindBy(xpath = "//div[@class='box']")
    public WebElement OrderRefWire;
}
