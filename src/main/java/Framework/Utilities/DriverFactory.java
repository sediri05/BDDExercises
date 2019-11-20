package Framework.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver driver;
    public static Properties prop;
    private FileInputStream ip;
    public static WebDriverWait wait10;
    public static ArrayList<String> prices = new ArrayList<>();
    public static ArrayList<String> items = new ArrayList<>();


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

    public Double calculateTotalPrice(ArrayList<String> prices) {
        Double sum = 0.00;
        for (String x : prices) {
            sum += Double.parseDouble(x.substring(1));
        }
        sum = sum + 2;
        BigDecimal bd = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void writeToPropFile(String newValue, String Attribute){
        try {
            FileOutputStream out =  new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/Framework/Utilities/Data.properties");
            prop.setProperty(Attribute, newValue);
            prop.store(out,null);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
