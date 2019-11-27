package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObjects {
    WebDriver driver;

    public SearchPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@class='price product-price']")
    public WebElement price;

    @FindBy(xpath = "//a[@title='Add to cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    public WebElement continueShoppingButton;


    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@class='product-container']")
    public WebElement item;
}
