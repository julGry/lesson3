package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW4Main {
    public static void main(String[] args) throws InterruptedException {
        Useragent useragent = Useragent.FIREFOX;
        WebDriver driver = useragent.getDriver();

        driver.get("https://www.google.com");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(".//*[@name='q']"));
        Thread.sleep(3000);
        element.sendKeys("Selenium");
        element.submit();

        Thread.sleep(3000);
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();



    }
}
