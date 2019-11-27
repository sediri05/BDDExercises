package Framework.PageActions;

import Framework.PageObjects.OrderSummaryPageObjects;
import Framework.Utilities.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class OrderSummaryActions extends DriverFactory {
    private OrderSummaryPageObjects oso;

    public OrderSummaryActions(WebDriver driver){
        this.driver=driver;
        oso = new OrderSummaryPageObjects(driver);
    }

    public void clickConfirmOrder(){
        wait10.until(ExpectedConditions.elementToBeClickable(oso.confirmOrderButton)).click();
    }

    public void clickOtherPaymentMethods(){
        wait10.until(ExpectedConditions.elementToBeClickable(oso.otherPaymentMethods)).click();
    }
}
