package com.automate.hudl.pageObjects;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class PageObjectManager {
    public WebDriver driver;

    public Properties prop;
    public HomePage homePage;
    public LoginPage loginPage;

    public PublicPage publicPage;

    public PageObjectManager(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public PublicPage getPublicPage() {
        publicPage = new PublicPage(driver, prop);
        return publicPage;
    }


}
