package Framework.PageActions;

import Framework.PageObjects.ShoppingCartObjects;
import Framework.Utilities.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.internal.annotations.ExpectedExceptionsAnnotation;

import java.util.ArrayList;

public class ShoppingCartActions extends DriverFactory {
    private ShoppingCartObjects sco;


    public ShoppingCartActions(WebDriver driver) {
        this.driver = driver;
        sco = new ShoppingCartObjects(driver);
    }

    public void verifyPrices(ArrayList<String> prices){
        ArrayList<String>priceDetails = new ArrayList<String>();
        for(WebElement x:sco.prices){
            priceDetails.add(x.getText());
        }
        Assert.assertTrue(prices.equals(priceDetails));
    }

    public void verifyItems(ArrayList<String> items){
        wait10.until(ExpectedConditions.visibilityOf(sco.proceedToCheckoutButton));
        ArrayList<String>productDetails = new ArrayList<String>();
        for(WebElement x:sco.products){
            productDetails.add(x.getText().toLowerCase());
        }
        Assert.assertTrue(items.equals(productDetails));
    }

    public void clickCheckout(){
        sco.proceedToCheckoutButton.click();
    }
}
