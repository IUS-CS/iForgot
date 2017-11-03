package com.mycompany.app;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestOrganizer {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://iforgotorganizer.xyz/LoginPage.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOrganizer() throws Exception {
        driver.get(baseUrl + "/LoginPage.html");
        driver.findElement(By.cssSelector("h4.logo")).click();
        driver.findElement(By.id("new-task")).clear();
        driver.findElement(By.id("new-task")).sendKeys("Do HW");
        driver.findElement(By.id("addButton")).click();
        driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
        driver.findElement(By.id("new-task")).clear();
        driver.findElement(By.id("new-task")).sendKeys("Study For Test");
        driver.findElement(By.id("addButton")).click();
        driver.findElement(By.id("new-task")).clear();
        driver.findElement(By.id("new-task")).sendKeys("Finish Lab");
        driver.findElement(By.id("addButton")).click();
        driver.findElement(By.xpath("//ul[@id='incomplete-tasks']/li[2]/button[2]")).click();
        driver.findElement(By.id("new-task")).clear();
        driver.findElement(By.id("new-task")).sendKeys("Study");
        driver.findElement(By.id("addButton")).click();
        driver.findElement(By.xpath("//ul[@id='incomplete-tasks']/li[2]/button")).click();
        driver.findElement(By.cssSelector("li.editMode > input[type=\"text\"]")).clear();
        driver.findElement(By.cssSelector("li.editMode > input[type=\"text\"]")).sendKeys("Study For Final");
        driver.findElement(By.id("new-task")).clear();
        driver.findElement(By.id("new-task")).sendKeys("Create Pull Request");
        driver.findElement(By.id("addButton")).click();
        driver.findElement(By.xpath("//ul[@id='incomplete-tasks']/li[3]/button[2]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
