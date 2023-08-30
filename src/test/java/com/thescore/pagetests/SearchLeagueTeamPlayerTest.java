package com.thescore.pagetests;

import com.thescore.ApplicationScreen;
import com.thescore.BasicInit;
import com.thescore.config.BasicAction;
import com.thescore.screens.*;
import com.thescore.util.AssertUtil;
import com.thescore.util.Util;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchLeagueTeamPlayerTest extends BasicInit {

    /**
     * Opens up the app and validate the home screen
     * Navigates to Leagues screen and validate it
     */
    @Test
    public void searchLeague() {
        ApplicationScreen.getWelcomeScreen().clickLogin();
        ApplicationScreen.getTermsAndConditionScreen().acceptTerms();

        HomeScreen homeScreen = ApplicationScreen.getLoginScreen()
                .enterEmail(Util.readConfigProperty("app.user.email"))
                .enterPassword(Util.readConfigProperty("app.user.password"))
                .clickLogIn();

        homeScreen.dismissScoreModal();
        AssertUtil.verifyTrue(homeScreen.isScoresScreenSelected(), "Scores Screen is currently selected");
        AssertUtil.verify(homeScreen.isLeaguesScreenSelected(), false, "Leagues screen is not selected");

        LeaguesScreen leaguesScreen = homeScreen.goToLeagues();

        AssertUtil.verifyTrue(leaguesScreen.isTitleDisplayed(), "Leagues screen is displayed");
        leaguesScreen.edit().done();
    }

    /**
     * Opens up various leagues as per defined, and validate the data
     * Clicks back button and validate the page
     * @param league : League name
     */
    @Test(dependsOnMethods = "searchLeague", dataProvider = "leagues-data")
    public void clickOnLeague(String league) {
         LeagueScreen leagueScreen = ApplicationScreen
                .getLeaguesScreen()
                .selectLeague(league);

        AssertUtil.verifyTrue(leagueScreen.isTitlePresent(league), "News tab is Displayed for league " + league);
        AssertUtil.verifyTrue(leagueScreen.isNewsTabPresent(), "News tab is Displayed");
        AssertUtil.verifyTrue(leagueScreen.isChatTabPresent(), "Chat tab is Displayed");
        AssertUtil.verifyTrue(leagueScreen.isLeadersTabPresent(), "Leaders tab is Displayed");

        LeadersTabScreen leadersTabScreen = leagueScreen.
                clickLeadersTab();

        switch (league) {
        	case "NHL":
        		AssertUtil.verifyTrue(leadersTabScreen.isEmptyContainerDisplayed(),
                    "Empty container is displayed");
            break;
            case "Champions League":
                AssertUtil.verifyTrue(leadersTabScreen.isGoalAndAssistsSectionDisplayed(),
                        "Goal and Assists Sections are displayed");
                break;
            case "MLB":
                AssertUtil.verifyTrue(leadersTabScreen.isALLeadersTabDisplayed(),
                        "AL Leaders sub-section is displayed");
                AssertUtil.verifyTrue(leadersTabScreen.isNLLeadersTabDisplayed(),
                        "NL Leaders sub-section is displayed");
                AssertUtil.verifyTrue(leadersTabScreen.isMLBLeadersTabDisplayed(),
                        "MLB Leaders sub-section is displayed");
                break;
            case "NFL":
                AssertUtil.verifyTrue(leadersTabScreen.isEmptyContainerDisplayed(),
                        "Empty container is displayed");
                break;
            case "NCAA Football":
                AssertUtil.verifyTrue(leadersTabScreen.isPassingYardsAndTouchdownSectionDisplayed(),
                        "Passing Yards and Passing Touchdown sections are displayed");
                break;
        }

        LeaguesScreen leaguesScreen = leagueScreen.clickBackButton();
        AssertUtil.verifyTrue(leaguesScreen.isTitleDisplayed(), "Leagues screen is displayed");
    }

    @DataProvider(name = "leagues-data")
    public Object[][] getLeagues() {
        return new Object[][] {
                {"NHL"},
                {"MLB"},
                {"NFL"},
                {"NCAA Football"}
        };
    }
}
