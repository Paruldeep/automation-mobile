package com.thescore.screens;

import com.thescore.config.BasicAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends AbstractScreen {

    @AndroidFindBy(xpath = "//*[@content-desc=\"Leagues\"]/android.widget.FrameLayout/android.widget.ImageView")
    private WebElement leaguesIcon;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Scores\"]/android.widget.FrameLayout/android.widget.ImageView")
    private WebElement scoresIcon;
    
    @AndroidFindBy(id = "dismiss_modal")
    private WebElement dismissIcon;

    public void dismissScoreModal() {
    	if(BasicAction.isMobileElementDisplayed(dismissIcon)) {
    		dismissIcon.click();
    	}
    }

    public boolean isScoresScreenSelected() {
        return BasicAction.isMobileElementSelected(scoresIcon);
    }

    public boolean isLeaguesScreenSelected() {
        return BasicAction.isMobileElementSelected(leaguesIcon);
    }

    public LeaguesScreen goToLeagues() {
        BasicAction.clickMobileElement(leaguesIcon);
        return new LeaguesScreen();
    }
}
