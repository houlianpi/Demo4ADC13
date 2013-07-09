package appium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: komejun
 * Date: 13-7-9
 * Time: PM2:14
 * To change this template use File | Settings | File Templates.
 */
public class TapWebTest {
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
    public void google() throws InterruptedException {
        driver.get("http://www.google.com");
        Point beforePoint = driver.findElement(By.id("gbg")).getLocation();
        driver.findElement(By.id("gbg")).click();
        Thread.sleep(1000);
        Point afterPoint = driver.findElement(By.id("gbg")).getLocation();
        driver.findElement(By.id("hplogoo")).click();
        Thread.sleep(2000);
        Point lastPoint = driver.findElement(By.id("gbg")).getLocation();
        Assert.assertNotEquals(beforePoint.getX(), afterPoint.getX());
        Assert.assertEquals(beforePoint.getX(),lastPoint.getX());
    }
}
