package appium.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;

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
        DesiredCapabilities des = new DesiredCapabilities("","6.0", Platform.MAC);
        des.setCapability("app","safari");
        driver =  new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), des);
    }
    @AfterClass
    public void after(){
        driver.quit();
    }

    @Test
    public void newsbaidu() throws InterruptedException {
        driver.get("http://m.baidu.com/news");
        String title = driver.findElement(By.xpath("//div[@class=\"index-list-main-title\"]")).getText();
        driver.findElement(By.xpath("//div[@class=\"index-list-main-text\"]")).click();
        Thread.sleep(1000);
        String articleTitle = driver.findElement(By.xpath("//h2[@class=\"page-view-article-title\"]")).getText();
        Assert.assertEquals(title, articleTitle);
        System.out.println(title);

    }

    @Test(dependsOnMethods = { "newsbaidu" })
    public void newbaidu2() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Integer> flickObject;
        flickObject = new HashMap<String, Integer>();
        flickObject.put("endX", 0);
        flickObject.put("endY", 240);
        flickObject.put("touchCount", 2);
        js.executeScript("mobile: flick", flickObject);
        System.out.println("flick");
        Thread.sleep(6000);
        String articleTitle = driver.findElement(By.xpath("//h2[@class=\"page-view-article-title\"]")).getText();
        System.out.println(articleTitle);

    }

}
