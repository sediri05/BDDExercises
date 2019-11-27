package Framework.PageObjects;

import cucumber.api.java.de.Wenn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsObjects {
    WebDriver driver;

    public ContactUsObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    public WebElement subHeadingDropDown;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "id_order")
    public WebElement orderRef;

    @FindBy(id = "fileUpload")
    public WebElement attachFile;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(id = "submitMessage")
    public WebElement submitButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successMessage;
}
