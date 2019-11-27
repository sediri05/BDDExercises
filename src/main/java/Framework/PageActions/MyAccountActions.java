package Framework.PageActions;

import Framework.PageObjects.MyAccountObjects;
import Framework.Utilities.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountActions extends DriverFactory {
    private MyAccountObjects mao;

    public MyAccountActions(WebDriver driver) {
        this.driver = driver;
        mao = new MyAccountObjects(driver);
    }
    public void verifyRegisteredAndLoggedIn(){
        wait10.until(ExpectedConditions.visibilityOf(mao.myAccountButton));
        Assert.assertTrue(mao.myAccountButton.getText().matches(prop.getProperty("UsernameF") + " " + prop.getProperty("UsernameL")));
    }

    public void verifyMyAccountPage() {
        wait10.until(ExpectedConditions.visibilityOf(mao.myAccountHeading));
        Assert.assertTrue(mao.myAccountHeading.getText().matches("My account"));
    }

    public void navigateToPersonalInfoPage(){
        mao.personalInformationButton.click();
    }

    public void navigateToOrderHistory(){
        wait10.until(ExpectedConditions.elementToBeClickable(mao.orderHistoryButton)).click();
    }
}
