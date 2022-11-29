package com.automate.hudl.pageObjects;

import com.automate.hudl.utils.GenericUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    WebDriver driver;
    private final String HOME_CONTENT = "[id=home-content]";
    private final String USER_MENU = ".hui-globalusermenu";
    private final String LOGOUT = "[data-qa-id='webnav-usermenu-logout'] span";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean onHomePage() {
        GenericUtils genericUtils = new GenericUtils(driver);
        return genericUtils.isElementPresent(HOME_CONTENT);
    }

    public boolean isTabPresent(String tab) {
        String loc;
        GenericUtils genericUtils = new GenericUtils(driver);
        loc = "[data-current-tab=\"" + tab + "\"]";
        return genericUtils.isElementPresent(loc);
    }

    public void clickLogOut() {
        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector(USER_MENU));
        action.moveToElement(menu).moveToElement(driver.findElement(By.cssSelector(LOGOUT))).click().build().perform();
    }

}
