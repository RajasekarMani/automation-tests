package com.example.ui.hooks;

import com.example.config.EnvironmentProperties;
import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.magentys.cinnamon.webdriver.Browser;

public class UiHooks {
    private final EnvironmentProperties environmentProperties;

    @Inject
    public UiHooks(EnvironmentProperties environmentProperties) {
        this.environmentProperties = environmentProperties;
    }

    @Before(order = 201, value = "@go_to_login_page")
    public void goToLoginPage() {
        Browser.open(environmentProperties.getUiUrl());
    }

    @Before(order = 202, value = "@login")
    public void login() {
    }

    @Before(order = 203, value = "@login_logout")
    public void goToHomePage() {
        goToLoginPage();
        login();
    }
    
    @After(order = 201, value = "@login_logout")
    public void logout() {

    }

}
