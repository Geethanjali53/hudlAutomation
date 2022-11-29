package com.automate.hudl.stepDefinitions;

import com.automate.hudl.utils.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetUp testContextSetUp;

    public Hooks(TestContextSetUp testContextSetUp) {

        this.testContextSetUp = testContextSetUp;
    }

    @After
    public void AfterScenario() throws IOException {

        testContextSetUp.extendedWebDriver.getDriver().quit();

    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetUp.extendedWebDriver.getDriver();
        if (scenario.isFailed()) {
            //screenshot
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "caughtYou");

        }

    }

}

