package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW5FBTitleCheck {
    WebDriver driver_ff;
    WebDriver driver_ch;

    @DataProvider(name = "dp")
    public Object[][] parseData() {
        return new Object[][] {
                {"https://google.com"}
        };
    }
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/yuliia/IdeaProjects/lesson3/source/geckodriver");
        driver_ch = new ChromeDriver();
        driver_ff = new FirefoxDriver();
    }

    @Test(dataProvider = "dp")
    public void test1(String searchUrl) throws InterruptedException {
        driver_ff.get(searchUrl);
        WebElement element = driver_ff.findElement(By.xpath(".//*[@name='q']"));
        element.sendKeys("Selenium");
        element.submit();
        Thread.sleep(3000);
        System.out.println("Firefox page title is: " + driver_ff.getTitle());
        Thread.sleep(3000);
    }

    @Test(dataProvider = "dp")
    public void test2(String searchUrl) throws InterruptedException {
        driver_ch.get(searchUrl);
        WebElement element = driver_ch.findElement(By.xpath(".//*[@name='q']"));
        element.sendKeys("Selenium");
        element.submit();
        Thread.sleep(3000);
        System.out.println("Google chrome page title is: " + driver_ch.getTitle());
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver_ff.quit();
        driver_ch.quit();
    }
}
