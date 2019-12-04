package Framework.Utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;


public class DriverFactory {
    public static WebDriver driver;
    public static Properties prop;
    private FileInputStream ip;
    public static WebDriverWait wait10;
    public static ArrayList<String> prices = new ArrayList<>();
    public static ArrayList<String> items = new ArrayList<>();


    public void setUp(String scenarioName) {
        prop = new Properties();
        try {
            Log.startLog(scenarioName);
            Log.debug("Initialising log4j");
            ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Framework/Utilities/Data.properties");
            prop.load(ip);
            Log.info("Data File has been loaded");
            driver = GetDriver(prop);
            wait10 = new WebDriverWait(driver, 10);
            Log.info("10 second explicit wait setup successful");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("URL"));
            Log.info("Driver setup successful");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Error in set up");
            e.printStackTrace();
        }
    }


    private static WebDriver GetDriver(Properties prop) {
        switch (prop.getProperty("Browser").toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                //HashMap<String, Object> cPrefs = new HashMap<String, Object>();
                //cPrefs.put("profile.default_content_settings.popups", 0);
                //cPrefs.put("download.default_directory", System.getProperty("user.dir"));
                if (prop.getProperty("Headless").equalsIgnoreCase("true")) {
                    //cPrefs.put("cmd", "Page.setDownloadBehavior");
                    options.setHeadless(true);
                    //options.addArguments("--test-type");
                    //options.addArguments("--disable-extensions"); //to disable browser extension popup
                    //Map<String, String> param = new HashMap<>();
                    //param.put("behavior", "allow");
                    //param.put("downloadPath", System.getProperty("user.dir"));
                    //cPrefs.put("params", param);
                    options.addArguments("window-size=1920,1080");
                    Log.info("Headless activated");
                }
                //options.setExperimentalOption("prefs", cPrefs);
                driver = new ChromeDriver(options);
                Log.info("Chrome driver initialised");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
                FirefoxProfile fxProfile = new FirefoxProfile();
                FirefoxOptions fOptions = new FirefoxOptions();
                fxProfile.setPreference("browser.download.folderList", 2);
                fxProfile.setPreference("browser.download.dir", System.getProperty("user.dir"));
                fxProfile.setPreference("browser.download.useDownloadDir", true);
                fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
                fxProfile.setPreference("pdfjs.disabled", true);
                if (prop.getProperty("Headless").equalsIgnoreCase("true")) {
                    fOptions.setHeadless(true);
                    Log.info("Headless activated");
                    fOptions.addArguments("window-size=1920,1080");
                }
                fOptions.setProfile(fxProfile);
                driver = new FirefoxDriver((fOptions));
                Log.info("Firefox driver initialised");
                break;
            case "grid":
                if (prop.getProperty("GridBrowser").equalsIgnoreCase("chrome")) {
                    ChromeOptions cOptions = new ChromeOptions();
                    DesiredCapabilities cCap = new DesiredCapabilities();
                    cCap.setBrowserName("chrome");
                    cCap.setPlatform(Platform.WIN10);
                    cOptions.merge(cCap);
                    if (prop.getProperty("Headless").equalsIgnoreCase("True")) {
                        cOptions.setHeadless(true);
                        cOptions.addArguments("window-size=1920,1080");
                        Log.info("Headless Grid activated");
                    }
                    //HashMap<String, Object> cPrefs2 = new HashMap<String, Object>();
                    //cPrefs2.put("profile.default_content_settings.popups", 0);
                    //cPrefs2.put("download.default_directory", System.getProperty("user.dir"));
                    //cOptions.setExperimentalOption("prefs", cPrefs2);
                    try {
                        driver = new RemoteWebDriver(new URL(prop.getProperty("nodeURL")), cOptions);
                        Log.info("Chrome Grid driver initialised");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        Log.error("Error in Chrome Grid initialisation");
                    }
                } else if (prop.getProperty("GridBrowser").matches("firefox")) {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    DesiredCapabilities fCap = new DesiredCapabilities();
                    fCap.setBrowserName("firefox");
                    fCap.setPlatform(Platform.WINDOWS);
                    firefoxOptions.merge(fCap);
                    if (prop.getProperty("Headless").equalsIgnoreCase("True")) {
                        firefoxOptions.setHeadless(true);
                        firefoxOptions.addArguments("window-size=1920,1080");
                        Log.info("Headless Grid activated");
                    }
                    FirefoxProfile fxProfile2 = new FirefoxProfile();
                    fxProfile2.setPreference("browser.download.folderList", 2);
                    fxProfile2.setPreference("browser.download.dir", System.getProperty("user.dir"));
                    fxProfile2.setPreference("browser.download.useDownloadDir", true);
                    fxProfile2.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
                    fxProfile2.setPreference("pdfjs.disabled", true);
                    firefoxOptions.setProfile(fxProfile2);
                    try {
                        driver = new RemoteWebDriver(new URL(prop.getProperty("nodeURL")), firefoxOptions);
                        Log.info("Firefox Grid initialised");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        Log.error("Error in firefox grid initialisation");
                    }
                }
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
            Log.info("Tear down successful");
            Log.endLog("Test is Finished");
        } catch (IOException e) {
            e.printStackTrace();
            Log.error("Error in tear down");
        }
    }

    public Double calculateTotalPrice(ArrayList<String> prices) {
        Double sum = 0.00;
        for (String x : prices) {
            sum += Double.parseDouble(x.substring(1));
        }
        sum = sum + 2;
        BigDecimal bd = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);
        Log.info("Total Price calculated");
        return bd.doubleValue();
    }

    public void writeToPropFile(String newValue, String Attribute) {
        try {
            FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/Framework/Utilities/Data.properties");
            prop.setProperty(Attribute, newValue);
            prop.store(out, null);
            out.close();
            Log.info(Attribute + " written to data file");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Error writing" + Attribute + " to file");
        }
    }
}
