package Framework.PageActions;

import Framework.PageObjects.NavigationBarObjects;
import Framework.Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class NavigationBarActions extends DriverFactory {
    private NavigationBarObjects nbo;


    public NavigationBarActions(WebDriver driver) {
        this.driver = driver;
        nbo = new NavigationBarObjects(driver);
    }

    public void clickSignIn() {
        wait10.until(ExpectedConditions.elementToBeClickable(nbo.signInButton)).click();
    }

    public void clickContactUs(){
        wait10.until(ExpectedConditions.elementToBeClickable(nbo.contactUsButton)).click();
    }

    public void clickSignOut(){
        wait10.until(ExpectedConditions.elementToBeClickable(nbo.signOutButton)).click();
    }
}
