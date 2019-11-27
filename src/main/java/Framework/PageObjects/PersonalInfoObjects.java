package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoObjects {
    WebDriver driver;

    public PersonalInfoObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    public WebElement first;

    @FindBy(id = "lastname")
    public WebElement last;

    @FindBy(id = "email")
    public WebElement email;
}
