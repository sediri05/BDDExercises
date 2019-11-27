package Framework.PageActions;

import Framework.PageObjects.ShippingTabObjects;
import Framework.Utilities.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingTabActions extends DriverFactory {
    private ShippingTabObjects sto;

    public ShippingTabActions(WebDriver driver){
        this.driver = driver;
        sto = new ShippingTabObjects(driver);
    }

    public void clickProceedToCheckout(){
        try{
        Thread.sleep(1000);}
        catch(Exception e){
            e.printStackTrace();
        }
        sto.proceedToCheckout.click();
    }

    public void closeOverlay(){
        //wait10.until(ExpectedConditions.visibilityOf(sto.overlayBox));
        //driver.switchTo().window(sto.overlayBox);
        wait10.until(ExpectedConditions.elementToBeClickable(sto.closeOverlay)).click();
    }

    public void clickTerms(){
        sto.termsCheckbox.sendKeys(Keys.SPACE);
    }

}
