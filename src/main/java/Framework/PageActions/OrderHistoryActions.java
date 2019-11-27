package Framework.PageActions;

import Framework.PageObjects.OrderHistoryObjects;
import Framework.Utilities.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class OrderHistoryActions extends DriverFactory {
    private OrderHistoryObjects oho;

    public OrderHistoryActions(WebDriver driver) {
        this.driver = driver;
        oho = new OrderHistoryObjects(driver);
    }

    public void verifyDetails() {
        wait10.until(ExpectedConditions.visibilityOf(oho.orderRef));
        Assert.assertTrue(oho.orderRef.getText().matches(prop.getProperty("OrderRef")));
        Assert.assertTrue(oho.totalAmount.getText().contains(prop.getProperty("TotalAmount")));
        Assert.assertTrue(oho.paymentOption.getText().contains(prop.getProperty("Payment").toLowerCase()));
    }

    public void downloadPDF() {
        oho.pdfDownload.click();
    }

    public void verifyDownloadSuccessful() {
        try {
            Thread.sleep(7000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        for (File x : listOfFiles) {
            if (x.isFile()) {
                String fileName = x.getName();
                if (fileName.startsWith("IN") && fileName.contains(".pdf")) {
                    System.out.println("File: " + fileName);
                    found = true;
                    x.delete();
                }
            }
        }
        Assert.assertTrue(found);
    }
}