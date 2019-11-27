package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartObjects {
    WebDriver driver;

    public ShoppingCartObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@data-title='Total']/span[@class='price']")
    public List<WebElement> prices;

    @FindBy(xpath = "//td/p[@class='product-name']")
    public List<WebElement> products;

    @FindBy(xpath = "//p/a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;
}
