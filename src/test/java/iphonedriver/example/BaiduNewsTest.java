package iphonedriver.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: komejun
 * Date: 13-7-9
 * Time: PM2:13
 * To change this template use File | Settings | File Templates.
 */
public class BaiduNewsTest {
    public WebDriver driver;

    @BeforeClass
    public void before() throws Exception {
        driver =  new IPhoneDriver();
    }
    @AfterClass
    public void after(){
        driver.quit();
    }

    @Test
    public void baiduTest(){
        driver.get("http://m.baidu.com");
        driver.findElement(By.xpath("//input[@type=\"search\"][@name=\"word\"]")).sendKeys("豆瓣");
        driver.findElement(By.id("se_bn")).click();
        Assert.assertTrue(driver.getTitle().contains("豆瓣"));
    }

    @Test
    public void newbaidu() throws InterruptedException {
        driver.get("http://m.baidu.com/news");
        driver.findElement(By.xpath("//div[@class=\"index-list-main-text\"]")).click();
        Thread.sleep(1000);
        Actions builder = new Actions(driver);
        WebElement canvas = driver.findElement(By.xpath("//div[@class=\"page-view-article-content\"]"));
        Action dragAndDrop = builder.clickAndHold(canvas)
                .moveByOffset(30,200)
                .moveByOffset(200,220)
                .release()
                .build();
        dragAndDrop.perform();

        Thread.sleep(5000);
    }
}
