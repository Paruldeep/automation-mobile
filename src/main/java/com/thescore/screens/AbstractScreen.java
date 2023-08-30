package com.thescore.screens;

import com.thescore.config.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AbstractScreen {

    private final Long DEFAULT_IMPLICIT_WAIT_TIMEOUT = 10L;

    public AbstractScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getInstance(), Duration.ofSeconds(DEFAULT_IMPLICIT_WAIT_TIMEOUT)), this);
    }
}
