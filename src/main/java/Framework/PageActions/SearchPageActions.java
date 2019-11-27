package Framework.PageActions;

import Framework.PageObjects.SearchPageObjects;
import Framework.Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPageActions extends DriverFactory {
    private SearchPageObjects spo;
    private Actions act;


    public SearchPageActions(WebDriver driver) {
        this.driver = driver;
        spo = new SearchPageObjects(driver);
        this.act = new Actions(driver);
    }

    public void hoverOverItem(){
        act.moveToElement(spo.item).perform();
    }

    public String capturePrice(){
        return spo.price.getText();
    }

    public void addToCart(){
        act.moveToElement(spo.addToCartButton).click().build().perform();
    }

    public void clickContinueShopping(){
        wait10.until(ExpectedConditions.elementToBeClickable(spo.continueShoppingButton));
        act.moveToElement(spo.continueShoppingButton).click().build().perform();
    }

    public void clickProceedToCheckout(){
        wait10.until(ExpectedConditions.elementToBeClickable(spo.proceedToCheckoutButton));
        act.moveToElement(spo.proceedToCheckoutButton).click().build().perform();
    }
}
