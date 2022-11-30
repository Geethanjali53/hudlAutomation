package com.automate.hudl.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ExtendedWebDriver {

    public WebDriver driver;

    public WebDriver getDriver() throws IOException {

        String url = getProp().getProperty("ProdUrl");
        String browser_properties = getProp().getProperty("Browser");
        String platform_properties = getProp().getProperty("Platform");
        String platform_maven = getProp().getProperty("Platform");
        String browser_maven = System.getProperty("Browser");

        String browser = browser_maven != null ? browser_maven : browser_properties;
        String platform = platform_maven != null ? platform_maven : platform_properties;
        String driverPath;
        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {
                switch (platform) {
                    case "windows":
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//chromedriver-win.exe");
                        break;
                    case "linux":
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//chromedriver-linux");
                        break;
                    case "mac":
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//chromedriver-mac");
                        break;
                }
                driver = new ChromeDriver();
            }
            if (browser.equalsIgnoreCase("firefox")) {
                switch (platform) {
                    case "windows":
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//geckodriver-win.exe");
                        break;
                    case "linux":
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//geckodriver-linux");
                        break;
                    case "mac":
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//geckodriver-mac");
                        break;
                }
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
        }
        return driver;
    }

    public Properties getProp() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//properties//hudl_prod.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop;
    }

}
