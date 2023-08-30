package com.thescore.screens;

import com.thescore.config.BasicAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomeScreen extends AbstractScreen {

    @AndroidFindBy(id = "txt_sign_in")
    private WebElement login;

    public LoginScreen clickLogin() {
        BasicAction.clickMobileElementWithOffset(login, BasicAction.getScreenDimensions().width/5, 0);
        return new LoginScreen();
    }
}
