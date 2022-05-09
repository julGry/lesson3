package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HW5FBRegistration {
    WebDriver driver;
    WebDriverWait wait;


    @DataProvider(name = "dp")
    public Object[][] parseData() {
        return new Object[][] {
                {"https://www.facebook.com/"}
        };
    }

    @DataProvider(name = "inputData")
    public Object[][]inputDts() {
        Object data[][] = new Object[1][8];
        data[0][0] = "your first name";
        data[0][1] = "your last name";
        data[0][2] = "your_email@gmail.com";
        data[0][3] = "Qwerty123";
        data[0][4] = "12";
        data[0][5] = "12";
        data[0][6] = "2000";
        data[0][7] = "0";
        return data;
    }

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/yuliia/IdeaProjects/lesson3/source/geckodriver");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
    }

    @Test(dataProvider = "dp", priority = 1, groups = "start page")
    public void method1(String searchUrl) {
        driver.get(searchUrl);
     //   driver.get("https://www.facebook.com/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@data-testid='open-registration-form-button']")));

        WebElement etSearchField = driver.findElement(By.xpath(".//*[@data-testid='open-registration-form-button']"));

        etSearchField.click();
    }

    @Test(dataProvider = "inputData", priority = 2, dependsOnMethods = "method1", groups = "input data")
    public void method2(String[] inputData) {
        WebElement etSearchField;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@name='websubmit']")));

        etSearchField = driver.findElement(By.xpath(".//*[@name='firstname']"));

        etSearchField.sendKeys(inputData[0]);

        etSearchField = driver.findElement(By.xpath(".//*[@name='lastname']"));

        etSearchField.sendKeys(inputData[1]);

        etSearchField = driver.findElement(By.xpath(".//*[@name='reg_email__']"));

        etSearchField.sendKeys(inputData[2]);

        etSearchField = driver.findElement(By.xpath(".//*[@id='password_step_input']"));

        etSearchField.sendKeys(inputData[3]);

        Select etSelectField;

        etSelectField = new Select(driver.findElement(By.xpath(".//*[@id='day']")));

        etSelectField.selectByValue(inputData[4]);

        etSelectField = new Select(driver.findElement(By.xpath(".//*[@id='month']")));

        etSelectField.selectByValue(inputData[5]);

        etSelectField = new Select(driver.findElement(By.xpath(".//*[@id='year']")));

        etSelectField.selectByValue(inputData[6]);

        List<WebElement> etSearchFields = driver.findElements(By.xpath(".//input[@name='sex']"));
        etSearchFields.get(Integer.parseInt(inputData[7])).click();
    }
    @Test(dataProvider = "inputData", priority = 3, dependsOnMethods = "method2", groups = "check data")
    public void method3(String[] checkData) throws InterruptedException {
        WebElement etSearchField;

        Thread.sleep(5000);

        try {
            etSearchField = driver.findElement(By.xpath(".//*[@name='firstname']"));
            Assert.assertEquals(etSearchField.getAttribute("value"), checkData[0]);

            etSearchField = driver.findElement(By.xpath(".//*[@name='lastname']"));
            Assert.assertEquals(etSearchField.getAttribute("value"), checkData[1]);

            etSearchField = driver.findElement(By.xpath(".//*[@name='reg_email__']"));
            Assert.assertEquals(etSearchField.getAttribute("value"), checkData[2]);

            etSearchField = driver.findElement(By.xpath(".//*[@id='password_step_input']"));
            Assert.assertEquals(etSearchField.getAttribute("value"), checkData[3]);

            etSearchField = driver.findElement(By.xpath(".//*[@id='day']"));
            Assert.assertEquals(etSearchField.getAttribute("value"), checkData[4]);

            etSearchField = driver.findElement(By.xpath(".//*[@id='month']"));
            Assert.assertEquals(etSearchField.getAttribute("value"), checkData[5]);

            etSearchField = driver.findElement(By.xpath(".//*[@id='year']"));
            Assert.assertEquals(etSearchField.getAttribute("value"), checkData[6]);

            List<WebElement> etSearchFields = driver.findElements(By.xpath(".//input[@name='sex']"));
            Assert.assertTrue(etSearchFields.get(Integer.parseInt(checkData[7])).isSelected());

        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
            throw e;
        }

    }

    @Test(dataProvider = "inputData", priority = 4, dependsOnMethods = "method2", groups = "check data")
    public void method4(String[] checkData){
        WebElement etSearchField = driver.findElement(By.xpath(".//button[@name='websubmit']"));
        Assert.assertTrue(etSearchField.isDisplayed());
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
