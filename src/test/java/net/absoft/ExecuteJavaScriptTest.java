package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExecuteJavaScriptTest extends BaseTest{
    private final String EMAIL = "test070587@test.com";
    private final String PASSWORD = "test070587";
    private final String LOGIN = "Stas_test";
    private final String DATA = "{\"user\":{\"email\":\"" + EMAIL + "\",\"password\":\"" + PASSWORD +"\"}}";

    @BeforeMethod
    public void setUp () {
        driver.get("https://demo.realworld.io/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

    }
    @Test
    public void runTest () {
        System.out.println("Test run");
    }

    @Test (enabled = false)
    public void testExecuteJava () {
        String token = (String) ((JavascriptExecutor) driver).executeAsyncScript(
                "const data = " + DATA +";\n"
                + "\n"
                + "const callback = arguments[arguments.lenth - 1];\n"
                + "const xhr = new XMLHttpRequest();\n"
                + "xhr.open('POST','https://api.realworld.io/api/users/login', true);\n"
                + "xhr.onreadystatechange = function () {\n"
                + "    if (xhr.readyState == 4){\n"
                + "        callback(JSON.parse(xhr.responseText)['user']['token']);\n"
                + "        }\n"
                + "        };\n"
                + "xhr.setRequestHeader(\"Content-Type\",\"application/json\");\n"
                + "xhr.send(JSON.stringify(data));");
        Assert.assertTrue(token != null && !token.isEmpty(),"Token should not be an empty string");

        ((JavascriptExecutor) driver).executeScript(
                "return localStorage.setItem('jwtToken', arguments[0]);", token);

        driver.navigate().refresh();

        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='#/@" + LOGIN + "']")).isDisplayed(),
                "User should be logged in");

    }
    @Test (enabled = false)
    public void testPinScenario () throws InterruptedException {
        ScriptKey scriptKey = ((JavascriptExecutor) driver).pin("return new Date().getTime()");
        Long timeBefore = (Long) ((JavascriptExecutor) driver).executeScript(scriptKey);

        Thread.sleep(5000);
        Long timeAfter = (Long) ((JavascriptExecutor) driver).executeScript(scriptKey);
        Assert.assertTrue((timeAfter-timeBefore)>5000,"Time after is not after 5 seconds");
    }
}
