package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HW3FBRunner {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/yuliia/IdeaProjects/lesson3/source/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        FBRegistration test;
        test = new FBRegistration(driver);
        test.runTest();

        Thread.sleep(2000);

        driver.quit();
    }
}
