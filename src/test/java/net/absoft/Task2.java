package net.absoft;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    @Test(description = "Checks: Dropdown Menu(s), Checkboxe(s), Radio Button(s)")
    public void DropdownCheckboxesRadioButtons  () {
        //в секції Dropdown Menu(s) виберіть JAVA, TestNG і HTML
        driver.findElement(By.xpath("//*[@id='dropdowm-menu-1']/option[1]")).click();
        driver.findElement(By.xpath("//*[@id='dropdowm-menu-2']/option[3]")).click();
        driver.findElement(By.xpath("//*[@id='dropdowm-menu-3']/option[1]")).click();
        //в секції Checkboxe(s) виберіть тільки опції Option 1 і Option 4
        driver.findElement(By.xpath("//*[@id='checkboxes']/label[1]/input")).click();
        driver.findElement(By.xpath("//*[@id='checkboxes']/label[3]/input")).click();
        driver.findElement(By.xpath("//*[@id='checkboxes']/label[4]/input")).click();
        //в секції Radio Button(s) виберіть Orange
        driver.findElement(By.xpath("//*[@id='radio-buttons']/input[4]")).click();
        //в секції Selected & Disabled перевірте, що за замовчуванням вибраніPumpkin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='radio-buttons-selected-disabled']/input[@value='pumpkin']")).isSelected(), "Pumpkin doesn`t selected");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='radio-buttons-selected-disabled']/input[@value='pumpkin']")).isEnabled(), "Pumpkin can be chosen");
        //в секції Selected & Disabled перевірте, що за замовчуванням вибран Grape
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruit-selects']/option[@value='grape']")).isSelected(), "Grape doesn`t selected");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruit-selects']/option[@value='grape']")).isEnabled(), "Grape can be chosen");
        //в секції Selected & Disabled перевірте, що Cabbage недоступні
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='radio-buttons-selected-disabled']/input[@value='cabbage']")).isSelected(), "Cabbage selected");
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='radio-buttons-selected-disabled']/input[@value='cabbage']")).isEnabled(), "Cabbage can be chosen");
        //в секції Selected & Disabled перевірте, що Orange недоступні
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruit-selects']/option[@value='orange']")).isSelected(), "Orange selected");
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruit-selects']/option[@value='orange']")).isEnabled(), "Orange can be chosen");

    }
}
