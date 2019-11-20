package Framework.PageActions;

import Framework.PageObjects.OrderConfirmationObjects;
import Framework.Utilities.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderConfirmationActions extends DriverFactory {
    private OrderConfirmationObjects oco;

    public OrderConfirmationActions(WebDriver driver){
        this.driver = driver;
        oco = new OrderConfirmationObjects(driver);
    }

    public void verifySuccess(Double total){
        // validate total amount
        Assert.assertTrue(oco.totalPricePaid.getText().substring(1).matches(total.toString()));

        //verify confirmation
        Assert.assertTrue(oco.orderConfirmationHeading.getText().equalsIgnoreCase("Order confirmation"));
    }

    public void clickBackToOrders(){
        wait10.until(ExpectedConditions.elementToBeClickable(oco.backToOrders)).click();
    }

    public String getOrderRef(){
        String temp = null;
        if(prop.getProperty("Payment").equalsIgnoreCase("wire")){
            String temp1 = oco.OrderRefWire.getText();
            String[] temp2 = temp1.split("reference ");
            String[] temp3 = temp2[1].split(" in");
            temp = temp3[0];
        } else if(prop.getProperty("Payment").equalsIgnoreCase("check")) {
            String temp1 = oco.OrderRefCheck.getText();
            String[] temp2 = temp1.split("reference ");
            String[] temp3 = temp2[0].split(".");
            temp = temp3[0];
        }
        System.out.println(temp);
        return temp;
    }

    public void setOrderRefInFile(){

    }
}
