package Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class DriverManager {
    private static WebDriver driver;
    private static WebDriver getGerenciadorDriver(TypeDriver navegador){
        switch (navegador){

            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions background = new ChromeOptions();
                background.addArguments("--headless");
                driver = new ChromeDriver(background);
                break;

            case IE:
                WebDriverManager.iedriver().setup();
                MutableCapabilities mutableCapabilities = new MutableCapabilities();
                mutableCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
                mutableCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                driver = new InternetExplorerDriver();
                break;

            default:
                break;

        }
        return driver;
    }
    public static WebDriver setDriver(TypeDriver navegador) {
        if (driver == null){
            driver = getGerenciadorDriver(navegador);

        }
        return driver;
    }

    public static void fecharDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
