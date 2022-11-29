package com.automate.hudl.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class GenericUtils {
    WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;

    }

    public boolean isElementPresent(String loc) {
        try {
            driver.findElement(By.cssSelector(loc));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
