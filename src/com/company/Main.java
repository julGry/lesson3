package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/Users/yuliia/IdeaProjects/lesson3/source/geckodriver");

        WebDriver dr = new FirefoxDriver();

        dr.get("https://www.google.com");

        WebElement etSearchField = dr.findElement(By.xpath(".//*[@name='q']"));

        etSearchField.sendKeys("Selenium");

        Thread.sleep(20_000);

        etSearchField.submit();

        Thread.sleep(50_000);

        System.out.println("Page title is" + dr.getTitle());

        dr.quit();


    }



}

