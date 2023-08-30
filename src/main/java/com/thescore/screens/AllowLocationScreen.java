package com.thescore.screens;

import com.thescore.config.BasicAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AllowLocationScreen extends AbstractScreen {

    @AndroidFindBy(id = "btn_allow")
    private WebElement allowLocationButton;

    @AndroidFindBy(id = "btn_disallow")
    private WebElement maybeLaterLink;

    public void allow() {
        BasicAction.clickMobileElement(allowLocationButton);
    }

    public void mayBeLater() {
        BasicAction.clickMobileElement(maybeLaterLink);
    }
}
