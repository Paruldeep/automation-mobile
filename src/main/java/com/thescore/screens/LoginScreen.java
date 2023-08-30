package com.thescore.screens;

import com.thescore.config.BasicAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends AbstractScreen {

    @AndroidFindBy(id = "email_input_edittext")
    private WebElement emailInputField;

    @AndroidFindBy(id = "password_input_edittext")
    private WebElement passwordInputField;

    @AndroidFindBy(id = "login_button")
    private WebElement logInButton;

    public LoginScreen enterEmail(String email) {
        BasicAction.enterText(emailInputField, email);
        return this;
    }

    public LoginScreen enterPassword(String password) {
        BasicAction.enterText(passwordInputField, password);
        return this;
    }

    public HomeScreen clickLogIn() {
        BasicAction.clickMobileElement(logInButton);
        return new HomeScreen();
    }
}
