package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task3 extends BaseTest {
    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");
    }

    @Test (description = "CLICK ME!")
    public void wellDoneForWaiting () {
        //Дочекайтесь появи кнопки “CLICK ME!”
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1500));
        //Натисніть на кнопку “CLICK ME!”
        driver.findElement(By.xpath("//*[@id='button1']/p[contains(text(),'CLICK ME!')]")).click();
        //Перевірте появу діалогу “**Well Done For Waiting....!!!**”
     new WebDriverWait(driver, Duration.ofSeconds(20)).until(
             ExpectedConditions.textToBe(By.xpath("//*[@id='myModalClick']/div/div/div[@class='modal-body']"),
                     "The waiting game can be a tricky one; this exercise will hopefully improve your understandings of the various types of waits."));
         //Натисніть в діалозі на кнопку “Close” і перевірте, що діалог було закрито
       driver.findElement(By.xpath("//button[@class='close' and @data-dismiss='modal']")).click();

    }

}
