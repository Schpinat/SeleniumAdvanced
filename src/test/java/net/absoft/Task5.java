package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task5 extends BaseTest {
    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Click-Buttons/index.html ");
    }

    @Test(description = "3 type of click")
    public void clickClickClick () {

        //Actions
        WebElement moveAndClick = driver.findElement(By.cssSelector("#button3"));
        new Actions(driver).moveToElement(moveAndClick).click().perform();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"myModalMoveClick\"]//*//button[@class='close']")))).click();

        //WebElement.click
        driver.findElement(By.xpath("//*[@id=\"button1\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"myModalClick\"]//*//button[@class='close']")))).click();

        //JavaScript
        WebElement element = driver.findElement(By.cssSelector("#button2"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"myModalJSClick\"]//*//button[@class='close']")))).click();


   }
}
