package com.example.ui.pages;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;

public class LoginPage extends DefaultPage{

    @FindByKey("login.username")
    public PageElement userNameInputField;

    @FindByKey("login.password")
    public PageElement passwordInputField;

    @FindByKey("login.btn")
    public PageElement loginButton;
    
}
