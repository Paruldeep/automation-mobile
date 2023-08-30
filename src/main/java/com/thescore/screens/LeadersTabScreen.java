package com.thescore.screens;

import com.thescore.config.BasicAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeadersTabScreen extends AbstractScreen {

    @AndroidFindBy(id = "txt_category_name")
    private List<WebElement> categorySection;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"AL LEADERS\"]")
    private WebElement alLeaders;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"NL LEADERS\"]")
    private WebElement nlLeaders;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"MLB LEADERS\"]")
    private WebElement mlbLeaders;

    @AndroidFindBy(id = "empty_state_container")
    private WebElement emptyContainer;

    public boolean isPassingYardsAndTouchdownSectionDisplayed() {
        boolean isAllSectionDisplayed = false;
        for(WebElement subSection: categorySection) {
            if(BasicAction.getMobileElementText(subSection).equals("Passing Yards") ||
                    BasicAction.getMobileElementText(subSection).equals("Passing Touchdowns")) {
                isAllSectionDisplayed = true;
            }
        }
        return isAllSectionDisplayed;
    }

    public boolean isALLeadersTabDisplayed() {
        return BasicAction.isMobileElementDisplayed(alLeaders);
    }

    public boolean isNLLeadersTabDisplayed() {
        return BasicAction.isMobileElementDisplayed(nlLeaders);
    }

    public boolean isMLBLeadersTabDisplayed() {
        return BasicAction.isMobileElementDisplayed(mlbLeaders);
    }
    
    public boolean isGoalAndAssistsSectionDisplayed() {
        boolean isAllSectionDisplayed = false;
        for(WebElement subSection: categorySection) {
            if(BasicAction.getMobileElementText(subSection).equals("Goals") ||
                    BasicAction.getMobileElementText(subSection).equals("Assists")) {
                isAllSectionDisplayed = true;
            }
        }
        return isAllSectionDisplayed;
    }

    public boolean isEmptyContainerDisplayed() {
        return BasicAction.isMobileElementDisplayed(emptyContainer);
    }
}
