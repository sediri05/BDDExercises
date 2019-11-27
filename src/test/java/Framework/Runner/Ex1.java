package Framework.Runner;

import Framework.Managers.PageObjectManager;
import Framework.Utilities.DriverFactory;

import java.util.ArrayList;

public class Ex1 {

    public static void main(String arg[]) {
        DriverFactory df = new DriverFactory();

        df.setUp("Hello");

        PageObjectManager obj = new PageObjectManager(df.driver);

        obj.getNavBarActions().clickSignIn();
        obj.getUserRegistrationActions().Login();
        obj.getmyAccActions().navigateToOrderHistory();
        obj.getOrderHistoryActions().verifyDetails();
        obj.getOrderHistoryActions().downloadPDF();
        obj.getOrderHistoryActions().verifyDownloadSuccessful();
        obj.getNavBarActions().clickSignOut();
    }
}
