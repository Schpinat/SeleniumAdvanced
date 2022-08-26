package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 extends BaseTest {
    private final String ADDTASK = "//@placeholder";


    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    @Test(description = "Add and delete task")
    public void addAndDeleteTask() {
        driver.findElement(By.xpath("//*[@id='container']/input")).sendKeys("New task");
        driver.findElement(By.xpath("//*[@id='container']/input")).sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='container']/ul/li[last()]")).getText(), "New task", "Task didn`t add");

        driver.findElement(By.xpath("//*[@id='container']/ul/li[last()]/span/i")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='container']/ul/li[contains(text(),'New task')]")).isDisplayed(), "Task didn`t delete");


    }
}