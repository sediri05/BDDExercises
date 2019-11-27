package Framework.PageActions;

import Framework.PageObjects.PaymentTabObjects;
import Framework.Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentTabActions extends DriverFactory {
    private PaymentTabObjects pto;

    public PaymentTabActions(WebDriver driver) {
        this.driver = driver;
        pto = new PaymentTabObjects(driver);
    }

    public void selectPaymentOption(String option) {
        switch (option.toLowerCase()) {
            case "wire":
                wait10.until(ExpectedConditions.elementToBeClickable(pto.bankWireOption)).click();
                break;
            case "check":
                wait10.until(ExpectedConditions.elementToBeClickable(pto.checkOption)).click();
        }
    }
}
