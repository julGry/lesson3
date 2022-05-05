package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HW3RozetkaRunner {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/Users/yuliia/IdeaProjects/lesson3/source/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver dr = new FirefoxDriver();
        //WebDriver dr = new ChromeDriver();

        RozetkaTest test;
        test = new RozetkaTest(dr);
        test.runTest();

        dr.quit();
    }


}
