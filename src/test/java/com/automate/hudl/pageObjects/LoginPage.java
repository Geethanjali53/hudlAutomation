package com.automate.hudl.pageObjects;

import com.automate.hudl.utils.GenericUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;
    private final GenericUtils genericUtils;
    private final String LOGO = "[data-qa-id='hudl-logo']";
    private final String EMAIL_ID = "[data-qa-id='email-input']";
    private final String PASSWORD = "password";
    private final String LOGIN_BUTTON = "[data-qa-id='login-btn']";
    private final String ERROR_MESSAGE = "[data-qa-id='error-display']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        genericUtils = new GenericUtils(driver);
    }

    public boolean onLoginPage() {
        if (driver.getTitle().equalsIgnoreCase("Log In") &&
                genericUtils.isElementPresent(LOGO)) {
            return true;
        } else
            return false;
    }

    public void fillUserCredentials(String userName, String password) {
        driver.findElement(By.cssSelector(EMAIL_ID)).sendKeys(userName);
        driver.findElement(By.id(PASSWORD)).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector(LOGIN_BUTTON)).click();
    }

    public String getErrorMessage() {
        String ErrorMessage = null;
        if (genericUtils.isElementPresent(ERROR_MESSAGE))
            ErrorMessage = driver.findElement(By.cssSelector(ERROR_MESSAGE)).getAttribute("innerHTML");
        return ErrorMessage;
    }

}
