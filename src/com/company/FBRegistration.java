package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FBRegistration {
    WebDriver driver;
    WebDriverWait wait;

    public FBRegistration(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void runTest(){

        driver.get("https://www.facebook.com/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@data-testid='open-registration-form-button']")));

        WebElement etSearchField = driver.findElement(By.xpath(".//*[@data-testid='open-registration-form-button']"));

        etSearchField.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@name='websubmit']")));

        etSearchField = driver.findElement(By.xpath(".//*[@name='firstname']"));

        etSearchField.sendKeys("Julia");

        etSearchField = driver.findElement(By.xpath(".//*[@name='lastname']"));

        etSearchField.sendKeys("Jonson");

        etSearchField = driver.findElement(By.xpath(".//*[@name='reg_email__']"));

        etSearchField.sendKeys("+380660514137");

        etSearchField = driver.findElement(By.xpath(".//*[@id='password_step_input']"));

        etSearchField.sendKeys("yuliahryshanova@gmail.com");

        Select etSelectField;

        etSelectField = new Select(driver.findElement(By.xpath(".//*[@id='day']")));

        etSelectField.selectByValue("12");

        etSelectField = new Select(driver.findElement(By.xpath(".//*[@id='month']")));

        etSelectField.selectByValue("9");

        etSelectField = new Select(driver.findElement(By.xpath(".//*[@id='year']")));

        etSelectField.selectByValue("2002");

        List<WebElement> etSearchFields = driver.findElements(By.xpath(".//input[@name='sex']"));
        etSearchFields.get(0).click();

        etSearchField = driver.findElement(By.xpath(".//button[@name='websubmit']"));

        etSearchField.click();


    }
}
