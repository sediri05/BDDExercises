package Framework.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountObjects {
    WebDriver driver;

    public MyAccountObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//h1[@class='page-heading']")
    public WebElement myAccountHeading;

    @FindBy(xpath = "//a[@title='Information']")
    public WebElement personalInformationButton;

    @FindBy(xpath = "//a[@title='Orders']")
    public WebElement orderHistoryButton;

}
