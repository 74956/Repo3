package org.example.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHook {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        Driver.openURL();
        Driver.waiters();
    }

    @After
    public void stopBrowser() {
        Driver.closeBrowser();
    }
}
