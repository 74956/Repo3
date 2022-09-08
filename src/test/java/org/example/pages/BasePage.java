package org.example.pages;

import org.example.driver.Driver;
import org.example.util.Waiters;
import org.openqa.selenium.WebDriver;

public class BasePage {

    Waiters waiters = new Waiters();
    protected WebDriver driver;

    public BasePage() {
        this.driver = Driver.getDriver();
    }
}
