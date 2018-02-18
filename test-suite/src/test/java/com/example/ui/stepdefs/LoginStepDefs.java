package com.example.ui.stepdefs;

import com.example.ScenarioContext;
import com.example.ui.tasks.LoginTasks;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {

    private final ScenarioContext scenarioContext;
    private final LoginTasks loginTasks;

    @Inject
    public LoginStepDefs(ScenarioContext scenarioContext, LoginTasks loginTasks) {
        this.scenarioContext = scenarioContext;
        this.loginTasks = loginTasks;
    }

    @Given("^i login with valid credentials$")
    public void i_login_with_valid_credentials() {
        loginTasks.login("user@phptravels.com", "demouser");
    }

    @Then("^i should be able to login successfully$")
    public void i_should_be_able_to_login_successfully() {
        Assert.assertTrue("User not logged in successfully", loginTasks.isLoggedIn());
    }

}
