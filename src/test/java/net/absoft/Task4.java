package net.absoft;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task4 extends BaseTest {
    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html");
    }

    @Test(description = "Check authorization")
    public void checkAuthorization () {
        driver.findElement(By.xpath("//*[@id=\"text\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys("User");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "validation failed","No alert find");
        driver.switchTo().alert().accept();
    }
}
