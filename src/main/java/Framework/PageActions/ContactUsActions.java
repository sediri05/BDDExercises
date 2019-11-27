package Framework.PageActions;

import Framework.PageObjects.ContactUsObjects;
import Framework.Utilities.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactUsActions extends DriverFactory {
    private ContactUsObjects cuo;

    public ContactUsActions(WebDriver driver) {
        this.driver = driver;
        cuo = new ContactUsObjects(driver);
    }

    public void enterDetails(){
        //wait10.until(ExpectedConditions.elementToBeSelected(cuo.submitButton));
        (new Select(cuo.subHeadingDropDown)).selectByIndex(1);
        cuo.emailInput.sendKeys(prop.getProperty("registerEmail"));
        cuo.orderRef.sendKeys(prop.getProperty("orderRef"));
        cuo.message.sendKeys(prop.getProperty("message"));
    }

    public void attachFile(){
        String filePath = System.getProperty("user.dir")+"\\sample.txt";
        cuo.attachFile.sendKeys(filePath);
    }

    public void submit(){
        cuo.submitButton.click();
    }

    public void validateSuccess(){
        wait10.until(ExpectedConditions.visibilityOf(cuo.successMessage));
        Assert.assertTrue(cuo.successMessage.isDisplayed());
    }
}
