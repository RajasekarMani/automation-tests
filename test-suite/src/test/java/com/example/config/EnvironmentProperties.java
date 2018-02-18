package com.example.config;

import com.google.inject.Inject;
import io.magentys.cinnamon.conf.Env;

public class EnvironmentProperties {

    private final Env env;

    @Inject
    public EnvironmentProperties(Env env) {
        this.env = env;
    }

    public String getTargetServer() {
        return System.getProperty("targetServer", "localhost");
    }

    public String getUiUrl() {
        return env.config.getString("app.ui.url");
    }

    public String getServiceUrl() {
        return env.config.getString("app.service.url");
    }

    public String getServiceUsername() {
        return env.config.getString("app.service.username");
    }

    public String getServicePassword() {
        return env.config.getString("app.service.password");
    }

}
