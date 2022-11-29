package com.automate.hudl.stepDefinitions;


import com.automate.hudl.pageObjects.LoginPage;
import com.automate.hudl.utils.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginSteps {
    TestContextSetUp testContextSetUp;
    LoginPage loginPage;

    //Dependency Injection using Cucumber pico container
    public LoginSteps(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.loginPage = testContextSetUp.pageObjectManager.getLoginPage();
    }

    @Given("^I am on application login page$")
    public void onLoginPage() {
        Assert.assertTrue("Sorry ! You are not on Application Login Page", loginPage.onLoginPage());
    }

    @When("^I fill username '(.+)' and password '(.+)' fields on login Page$")
    public void fillFieldsOnLoginPage(String userName, String password) {
        loginPage.fillUserCredentials(userName, password);
    }


    @When("^I click Login button$")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("^I should see following error message '(.+)' thrown on login page$")
    public void verifyErrorMessageOnLoginPage(String error) {
        Assert.assertTrue("Sorry ! Error thrown did not match the expected text", loginPage.getErrorMessage().contains(error));
    }

}