package com.automate.hudl.pageObjects;

import com.automate.hudl.utils.GenericUtils;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class PublicPage {

    WebDriver driver;
    Properties prop;
    private final String HERO_BUTTON = "[id='homepage-hero_button']";

    public PublicPage(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }

    public boolean onPublicPage() {
        GenericUtils genericUtils = new GenericUtils(driver);
        return genericUtils.isElementPresent(HERO_BUTTON);
    }

    public void getLoginPage() {
        String LoginUrl = prop.getProperty("ProdUrl") + "/login";
        driver.get(LoginUrl);
    }

}
