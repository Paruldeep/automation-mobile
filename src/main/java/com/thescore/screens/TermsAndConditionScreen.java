package com.thescore.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.thescore.config.BasicAction;

public class TermsAndConditionScreen extends AbstractScreen {

    @AndroidFindBy(id = "accept_button")
    private WebElement accept;

    public void acceptTerms() {
    	if(BasicAction.isMobileElementDisplayed(accept)) {
    		accept.click();
    	}
    }
}
