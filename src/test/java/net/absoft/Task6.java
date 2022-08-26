package net.absoft;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task6 extends BaseTest{
    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Datepicker/index.html");
    }

    @Test(description = "Check ACT")
    public void checkAct() {

    }
}
