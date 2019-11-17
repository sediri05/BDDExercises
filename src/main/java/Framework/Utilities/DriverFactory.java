package Framework.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver driver;
    public static Properties prop;
    private FileInputStream ip;
    public static WebDriverWait wait10;


    public void setUp() {
        prop = new Properties();
        try {
            ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Framework/Utilities/Data.properties");
            prop.load(ip);
            driver = GetDriver(prop);
            wait10 = new WebDriverWait(driver, 10);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("URL"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static WebDriver GetDriver(Properties prop) {
        switch (prop.getProperty("Browser")) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                driver = null;
        }
        return driver;
    }

    public void tearDown() {
        try {
            ip.close();
            driver.quit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
