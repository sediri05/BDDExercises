package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPageObjects {
    WebDriver driver;

    public OrderSummaryPageObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    public WebElement confirmOrderButton;

    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']")
    public WebElement otherPaymentMethods;
}
