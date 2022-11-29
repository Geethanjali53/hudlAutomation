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

        String url = getProp().getProperty("baseUrl");
        String browser_properties = getProp().getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven != null ? browser_maven : browser_properties;

        if (driver == null) {
            String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
            if (browser.equalsIgnoreCase("chrome")) {
                switch (os) {
                    case "win":
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//chromedriver-win.exe");
                        break;
                    case "lin":
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//chromedriver-lnx");
                        break;
                    case "mac":
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//chromedriver-mac64");
                        break;
                }
                driver = new ChromeDriver();
            }
            if (browser.equalsIgnoreCase("firefox")) {
                switch (os) {
                    case "win":
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//geckodriver-win.exe");
                        break;
                    case "lin":
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//geckodriver-lnx");
                        break;
                    case "mac":
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//webDrivers//geckodriver-mac64");
                        break;
                }
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get(url);
        }
        return driver;
    }

    public Properties getProp() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//testConfig.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop;
    }

}
