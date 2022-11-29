package com.automate.hudl.utils;

import com.automate.hudl.pageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetUp {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;

    public ExtendedWebDriver extendedWebDriver;

    public GenericUtils genericUtils;

    public TestContextSetUp() throws IOException {
        extendedWebDriver = new ExtendedWebDriver();
        pageObjectManager = new PageObjectManager(extendedWebDriver.getDriver(), extendedWebDriver.getProp());
        genericUtils = new GenericUtils(extendedWebDriver.getDriver());


    }
}
