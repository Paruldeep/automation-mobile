package com.thescore.screens;

import com.thescore.config.BasicAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeaguesScreen extends AbstractScreen {

    @AndroidFindBy(id = "titleTextView")
    private WebElement titleText;

    @AndroidFindBy(id = "league_name_text")
    private List<WebElement> leagueNames;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.fivemobile.thescore:id/header_right_text\" and @text=\"Edit\"]")
    private WebElement editButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.fivemobile.thescore:id/header_right_text\" and @text=\"Done\"]")
    private WebElement doneButton;

    public boolean isTitleDisplayed() {
        return BasicAction.getMobileElementText(titleText).equals("Leagues");
    }

    public LeagueScreen selectLeague(String leagueName) {
        WebElement league = leagueNames.stream()
                .filter(l -> BasicAction.getMobileElementText(l).equals(leagueName))
                .findFirst().get();
        BasicAction.clickMobileElement(league);
        return new LeagueScreen();
    }

    public LeaguesScreen edit() {
        BasicAction.clickMobileElement(editButton);
        return this;
    }

    public LeaguesScreen done() {
        BasicAction.clickMobileElement(doneButton);
        return this;
    }
}
