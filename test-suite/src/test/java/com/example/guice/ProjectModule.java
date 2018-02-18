package com.example.guice;

import com.example.config.EnvironmentProperties;
import com.example.ui.hooks.UiHooks;
import com.example.ui.pages.DefaultPage;
import com.example.ui.pages.HomePage;
import com.example.ui.pages.LoginPage;
import com.example.ui.stepdefs.BookingStepDefs;
import com.example.ui.stepdefs.LoginStepDefs;
import com.example.ui.tasks.BookingTasks;
import com.example.ui.tasks.DefaultTasks;
import com.example.ui.tasks.LoginTasks;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import cucumber.api.guice.CucumberScopes;

public final class ProjectModule extends AbstractModule {
    @Override
    public void configure() {
        try {
			bind(EnvironmentProperties.class).in(Scopes.SINGLETON);
            bind(UiHooks.class).in(CucumberScopes.SCENARIO);
            
            bind(DefaultPage.class).in(CucumberScopes.SCENARIO);
            bind(LoginPage.class).in(CucumberScopes.SCENARIO);
            bind(HomePage.class).in(CucumberScopes.SCENARIO);
            
            bind(DefaultTasks.class).in(CucumberScopes.SCENARIO);
            bind(LoginTasks.class).in(CucumberScopes.SCENARIO);
            bind(BookingTasks.class).in(CucumberScopes.SCENARIO);
            
            bind(LoginStepDefs.class).in(CucumberScopes.SCENARIO);
            bind(BookingStepDefs.class).in(CucumberScopes.SCENARIO);
        } catch (Exception e) {
            addError(e.getMessage());
        }
    }

}
