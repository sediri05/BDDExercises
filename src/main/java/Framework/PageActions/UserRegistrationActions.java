package Framework.PageActions;

import Framework.PageObjects.UserRegistrationObject;
import Framework.Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class UserRegistrationActions extends DriverFactory {
    private UserRegistrationObject uro;


    public UserRegistrationActions(WebDriver driver) {
        this.driver = driver;
        uro = new UserRegistrationObject(driver);
    }

    public void enterEmail(String email) {
        wait10.until(ExpectedConditions.visibilityOf(uro.registerEmailField)).sendKeys(email);
    }

    public void clickCreate() {
        wait10.until(ExpectedConditions.elementToBeClickable(uro.createAccountButton)).click();
    }

    public void enterLoginDetails(Properties prop) {
        wait10.until(ExpectedConditions.visibilityOf(uro.userFirstNameField)).sendKeys(prop.getProperty("UsernameF"));
        wait10.until(ExpectedConditions.visibilityOf(uro.userLastNameField)).sendKeys(prop.getProperty("UsernameL"));
        wait10.until(ExpectedConditions.elementToBeClickable(uro.userEmailField)).click();
        wait10.until(ExpectedConditions.visibilityOf(uro.pwField)).sendKeys(prop.getProperty("registerPW"));
    }

    public void enterAddressDetails(Properties prop) {
        wait10.until(ExpectedConditions.visibilityOf(uro.addressL1Field)).sendKeys(prop.getProperty("Line1"));
        wait10.until(ExpectedConditions.visibilityOf(uro.cityField)).sendKeys(prop.getProperty("City"));
        new Select(uro.stateDropDown).selectByVisibleText(prop.getProperty("State"));
        wait10.until(ExpectedConditions.visibilityOf(uro.postcodeField)).sendKeys(prop.getProperty("Postcode"));
        //wait10.until(ExpectedConditions.elementToBeSelected(uro.countryDropDown));
        //new Select(uro.countryDropDown).selectByVisibleText(prop.getProperty("Country"));
        uro.addressAliasField.clear();
        uro.addressAliasField.sendKeys(prop.getProperty("addressAlias"));
    }


    public void enterPhone(String number) {
        wait10.until(ExpectedConditions.visibilityOf(uro.mobNumField)).sendKeys(number);
    }


    public void clickRegister() {
        wait10.until(ExpectedConditions.elementToBeClickable(uro.registerButton)).click();
    }



   /* public UserRegistrationObject getUro() {
        return uro;
    }*/

    public void Login() {
        wait10.until(ExpectedConditions.visibilityOf(uro.loginEmail)).sendKeys(prop.getProperty("registerEmail"));
        uro.loginPW.sendKeys(prop.getProperty("registerPW"));
        uro.submitLogin.click();
    }



}
