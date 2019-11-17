package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegistrationObject {
    WebDriver driver;

    public UserRegistrationObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    public WebElement registerEmailField;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@name='passwd']")
    public WebElement loginPW;

    @FindBy(id = "SubmitLogin")
    public WebElement submitLogin;

    @FindBy(id = "customer_firstname")
    public WebElement userFirstNameField;

    @FindBy(id = "customer_lastname")
    public WebElement userLastNameField;

    @FindBy(id = "email")
    public WebElement userEmailField;

    @FindBy(id = "passwd")
    public WebElement pwField;

    /*@FindBy(id = "firstname")
    public WebElement addressFirstNameField;

    @FindBy(id = "lastname")
    public WebElement addressLastNameField;*/

    @FindBy(id = "address1")
    public WebElement addressL1Field;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "id_state")
    public WebElement stateDropDown;

    @FindBy(id = "postcode")
    public WebElement postcodeField;

    @FindBy(id = "id_country")
    public WebElement countryDropDown;

    @FindBy(id = "phone_mobile")
    public WebElement mobNumField;

    @FindBy(id = "alias")
    public WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;


}
