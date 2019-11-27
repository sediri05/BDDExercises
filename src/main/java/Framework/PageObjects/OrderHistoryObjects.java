package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryObjects {
    WebDriver driver;

    public OrderHistoryObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//td[@class='history_method']")
    public WebElement paymentOption;

    @FindBy(xpath = "//td[@class='history_price']/span[@class='price']")
    public WebElement totalAmount;

    @FindBy(xpath = "//a[@class='color-myaccount']")
    public WebElement orderRef;

    @FindBy(xpath = "//td[@class='history_invoice']/a[@class='link-button']")
    public WebElement pdfDownload;
}
