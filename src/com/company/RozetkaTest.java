package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaTest {
    WebDriver dr;
    WebDriverWait wait;

    public RozetkaTest(WebDriver dr) {
        this.dr = dr;
        this.wait = new WebDriverWait(dr, Duration.ofSeconds(30));
        //умеет ждать пока не загрузиться и отрендариться страничка
    }

    public void runTest() {

        dr.get("https://rozetka.com.ua/ua/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='__JSBridgeIframe_SetResult__']")));
        //ждать пока не появится элемент

        WebElement etSearchField = dr.findElement(By.xpath("(.//a[contains(text(), 'Смартфони, ТВ і електроніка')])[3]"));
        //объявить переменную чтобы найти элемент

        System.out.println(etSearchField);

        etSearchField.click();
        //кликнуть по найденному элементу

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//a[@title='Мобільні телефони'])[1]")));
        //ждать пока не появится элемент

        etSearchField = dr.findElement(By.xpath("(.//a[@title='Мобільні телефони'])[1]"));
        //найти элемент

        System.out.println(etSearchField);

        etSearchField.click();
        //кликнуть по элементу

        //Thread.sleep(3_000);
        //на всякий случай ждать 3 сек

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='__JSBridgeIframe_SetResult__']")));
        //ждать пока загруиться iframe

        List<WebElement> actionElements = dr.findElements(By.xpath("//a[contains(@class, 'goods-tile__heading') and ../span[contains(@class,'promo-label')]]"));
        //найти телефоны топ продаж

        System.out.println(String.format("Found %d action phones\nprint first three",
                actionElements.size()));

        for (int i=0;i<actionElements.size() && i < 3;i++) {
            System.out.println(String.format("item %d : '%s'",
                    i+1,actionElements.get(i).getDomAttribute("title")));
        }
        //цикл чтобы отобразить 3 первых телефоона
    }

}
