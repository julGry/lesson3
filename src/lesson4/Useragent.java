package lesson4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public enum Useragent {
    CHROME(){
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            WebDriver chromeDriver = new ChromeDriver();
            return chromeDriver;
        }
    },
    CHROME_MOBILE() {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Nexus 5");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

            WebDriver chromeMobileDriver = new ChromeDriver(chromeOptions);
            return chromeMobileDriver;
        }
    },
    FIREFOX() {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.gecko.driver", "/Users/yuliia/IdeaProjects/lesson3/source/geckodriver");
            WebDriver fireFoxDriver = new FirefoxDriver();
            return fireFoxDriver;
        }
    };

    abstract public WebDriver getDriver();


}
