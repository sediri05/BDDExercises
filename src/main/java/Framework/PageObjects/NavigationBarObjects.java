package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBarObjects {
    WebDriver driver;

    public NavigationBarObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(id = "contact-link")
    public WebElement contactUsButton;

    @FindBy(xpath = "//a[@class='logout']")
    public WebElement signOutButton;

    @FindBy(xpath = "//input[@id='search_query_top']")
    public WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    public WebElement searchButton;
}
