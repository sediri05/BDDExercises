package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentTabObjects {
    private WebDriver driver;

    public PaymentTabObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    public WebElement bankWireOption;

    @FindBy(xpath = "//a[@title='Pay by check.']")
    public WebElement checkOption;
}
