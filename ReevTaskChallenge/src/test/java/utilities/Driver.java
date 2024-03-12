package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class Driver {

    private Driver(){
        /** Default constructor is defined as private to prevent user to create an object by this class. */
    }
    static WebDriver driver;



    public static WebDriver getDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        SafariOptions safariOptions = new SafariOptions();

        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        edgeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        firefoxOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        System.setProperty("webdriver.chrome.whitelistedIps", "");


        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver(edgeOptions);
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver(new SafariOptions());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
            }
            //Driver Settings
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }

    }

}
