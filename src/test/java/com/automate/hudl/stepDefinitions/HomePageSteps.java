package com.automate.hudl.stepDefinitions;

import com.automate.hudl.pageObjects.HomePage;
import com.automate.hudl.utils.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class HomePageSteps {
    WebDriver driver;
    TestContextSetUp testContextSetUp;
    HomePage homePage;

    public HomePageSteps(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.homePage = testContextSetUp.pageObjectManager.getHomePage();
    }

    @When("^I logout from account$")
    public void OnLogout() {
        homePage.clickLogOut();
    }

    @Then("^I '(.+)' be on the application home page$")
    public void isHomePage(String condn) {
        boolean expectedValue = false;
        if (condn.equalsIgnoreCase("should")) {
            expectedValue = true;
        }
        Assert.assertEquals("Sorry ! You are not on the homepage", expectedValue, homePage.onHomePage());
    }

    @Then("I {string} see {string} tab as current tab on the home page")
    public void isTabPresent(String condn, String tab) {
        boolean expectedValue = false;
        if (condn.equalsIgnoreCase("should")) {
            expectedValue = true;
        }
        Assert.assertEquals("Sorry ! You are not on the homepage", expectedValue, homePage.isTabPresent(tab));
    }

    @Given("^I am on application home page$")
    public void onHomePage() {
        Assert.assertTrue("Sorry ! You are not on the homepage", homePage.onHomePage());
    }

}
