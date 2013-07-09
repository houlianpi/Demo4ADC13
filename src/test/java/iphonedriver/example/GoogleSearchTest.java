package iphonedriver.example;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created with IntelliJ IDEA.
 * User: komejun
 * Date: 13-7-9
 * Time: PM1:32
 * To change this template use File | Settings | File Templates.
 */
public class GoogleSearchTest {
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
    public void googleTest() throws InterruptedException {
        driver.get("http://www.google.com");
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("豆瓣");
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().contains("豆瓣"));
        String str = driver.findElement(By.xpath("//h2[@class=\"hd\"]")).getText();
        Assert.assertEquals(str,"搜索结果");
        String str1 = driver.findElement(By.xpath("//span[@class=\"st\"]")).getText();
        Assert.assertTrue(str1.contains("推荐"));
    }
}
