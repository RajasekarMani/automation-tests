package com.example.ui.tasks;

import com.example.ui.pages.HomePage;
import com.example.ui.pages.LoginPage;
import com.google.inject.Inject;

import static com.example.Defaults.DEFAULT_KEY_STROKE_INTERVAL_IN_MILLISECONDS;

public class LoginTasks extends DefaultTasks {

    private final LoginPage loginPage;
    private final HomePage homePage;

    @Inject
    public LoginTasks(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    public void login(String username, String password) {
        waitUntilPageLoaded();
        loginPage.userNameInputField.withKeyStrokeInterval(DEFAULT_KEY_STROKE_INTERVAL_IN_MILLISECONDS).typeText(username);
        loginPage.passwordInputField.withKeyStrokeInterval(DEFAULT_KEY_STROKE_INTERVAL_IN_MILLISECONDS).typeText(password);
        loginPage.loginButton.click();
    }
    
    public boolean isLoggedIn(){
        waitUntilPageLoaded();
        return homePage.profileIcon.isPresent();
    }

}
