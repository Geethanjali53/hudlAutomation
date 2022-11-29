package com.automate.hudl.stepDefinitions;

import com.automate.hudl.pageObjects.PublicPage;
import com.automate.hudl.utils.TestContextSetUp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PublicPageSteps {
    TestContextSetUp testContextSetUp;
    WebDriver driver;
    PublicPage publicPage;

    public PublicPageSteps(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.publicPage = testContextSetUp.pageObjectManager.getPublicPage();
    }

    @Then("^I '(.+)' be on a Public page$")
    public void onPublicPage(String condn) {
        boolean expectedValue = false;
        if (condn.equalsIgnoreCase("should")) {
            expectedValue = true;
        }
        Assert.assertEquals("Sorry ! You are not on the Public page", expectedValue, publicPage.onPublicPage());
    }

    @When("^I go to application login page$")
    public void getLoginPage() {
        publicPage.getLoginPage();
    }
}
