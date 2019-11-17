package Framework.Managers;
import Framework.PageActions.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private UserRegistrationActions userRegistrationActions;
    private NavigationBarActions navBarActions;
    private MyAccountActions myAccActions;
    private PersonalInfoActions personalInfoActions;
    private ContactUsActions contactUsActions;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public NavigationBarActions getNavBarActions(){
        return (navBarActions == null) ? navBarActions = new NavigationBarActions(driver) : navBarActions;
    }

    public UserRegistrationActions getUserRegistrationActions() {
        return (userRegistrationActions == null) ? userRegistrationActions = new UserRegistrationActions(driver) : userRegistrationActions;
    }

    public MyAccountActions getmyAccActions() {
        return (myAccActions == null) ? myAccActions = new MyAccountActions(driver) : myAccActions;
    }

    public PersonalInfoActions getPersonalInfoActions() {
        return (personalInfoActions == null) ? personalInfoActions = new PersonalInfoActions(driver) : personalInfoActions;
    }

    public ContactUsActions getContactUsActions() {
        return (contactUsActions == null) ? contactUsActions = new ContactUsActions(driver) : contactUsActions;
    }
}