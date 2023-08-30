package com.thescore.screens;

import com.thescore.config.BasicAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LeagueScreen extends AbstractScreen {

    @AndroidFindBy(id = "titleTextView")
    private WebElement titleText;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Fixtures\"]")
    private WebElement fixturesTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"News\"]")
    private WebElement newsTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Chat\"]")
    private WebElement chatTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Groups\"]")
    private WebElement groupsTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Leaders\"]")
    private WebElement leadersTab;

    public LeaguesScreen clickBackButton() {
        BasicAction.clickMobileElement(backButton);
        return new LeaguesScreen();
    }
    
    public boolean isTitlePresent(String league) {
        return BasicAction.getMobileElementText(titleText).equals(league);
    }

    public boolean isNewsTabPresent() {
        return BasicAction.isMobileElementDisplayed(newsTab);
    }

    public boolean isChatTabPresent() {
        return BasicAction.isMobileElementDisplayed(chatTab);
    }

    public boolean isLeadersTabPresent() {
        return BasicAction.isMobileElementDisplayed(leadersTab);
    }

    public LeadersTabScreen clickLeadersTab() {
        BasicAction.clickMobileElement(leadersTab);
        return new LeadersTabScreen();
    }
}
